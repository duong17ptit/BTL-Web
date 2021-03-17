/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import bean.benhvien_chuyenkhoa;
import java.io.File;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.sql.SQLException;
import java.util.List;
import javax.servlet.RequestDispatcher;

import bean.benhvienphongkham;
import bean.chuyenkhoa;
import bean.loaihinh;
import bean.quanhuyen;
import bean.tinhthanhpho;
import java.io.PrintWriter;
import static java.lang.Math.ceil;
import java.nio.charset.StandardCharsets;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import javax.servlet.FilterChain;
import javax.servlet.ServletContext;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.http.HttpSession;
import model.BenhVien_ChuyenKhoaDao;
import model.benhvienphongkhamDao;
import model.chuyenkhoaDao;
import model.loaiHinhDao;
import model.quanHuyenDao;
import model.tinhTPDao;
import org.apache.commons.fileupload.FileItem;
import org.apache.commons.fileupload.disk.DiskFileItemFactory;
import org.apache.commons.fileupload.servlet.ServletFileUpload;

/**
 *
 * @author Admin
 */
//
@WebServlet(urlPatterns = {"/admin/benhvienphongkham/list-benh-vien", "/admin/benhvienphongkham/new", "/admin/benhvienphongkham/insert", "/admin/benhvienphongkham/delete", "/admin/benhvienphongkham/edit", "/admin/benhvienphongkham/update"})
//@MultipartConfig(fileSizeThreshold = 1024 * 1024 * 2, // 2MB
//        maxFileSize = 1024 * 1024 * 10, // 10MB
//        maxRequestSize = 1024 * 1024 * 50) // 50MB
//@WebServlet(urlPatterns = "/admin/benhvienphongkham/*")
public class benhvienphongkhamServlet extends HttpServlet {

    private static final long serialVersionUID = 1L;
    private benhvienphongkhamDao benhvienphongkhamDao;
    private tinhTPDao tinhTPDao;
    private loaiHinhDao loaiHinhDao;
    private chuyenkhoaDao chuyenkhoaDao;
    private BenhVien_ChuyenKhoaDao BenhVien_ChuyenKhoaDao;
    private quanHuyenDao quanHuyenDao;

    public void init() {
        tinhTPDao = new tinhTPDao();
        benhvienphongkhamDao = new benhvienphongkhamDao();
        loaiHinhDao = new loaiHinhDao();
        chuyenkhoaDao = new chuyenkhoaDao();
        BenhVien_ChuyenKhoaDao = new BenhVien_ChuyenKhoaDao();
        quanHuyenDao = new quanHuyenDao();
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        doGet(request, response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        request.setCharacterEncoding("UTF-8");
        PrintWriter out = response.getWriter();
        HttpSession session = request.getSession();
        System.out.println(session.getAttribute("name"));
        if (session.getAttribute("name") != null) {
            String action1 = request.getServletPath();
            System.out.println(action1);
            System.out.println("rung");

            try {
                switch (action1) {
                    case "/admin/benhvienphongkham/new":
                        showNewForm(request, response);

                        break;
                    case "/admin/benhvienphongkham/insert":
                        insertBV(request, response);

                        break;
                    case "/admin/benhvienphongkham/delete":
                        deleteBV(request, response);
                        break;
                    case "/admin/benhvienphongkham/edit":
                        showEditForm(request, response);
                        break;
                    case "/admin/benhvienphongkham/update":
                        updateBV(request, response);
                        break;
                    case "/admin/benhvienphongkham/list-benh-vien":
                        listBenhVien(request, response);
                        break;
                }
            } catch (SQLException ex) {
                throw new ServletException(ex);
            }
        } else {
            out.print("Please login first");
            response.sendRedirect(request.getContextPath() + "/login.jsp");
            System.out.println(request.getContextPath());
        }
        out.close();
    }

    private void listBenhVien(HttpServletRequest request, HttpServletResponse response)
            throws SQLException, IOException, ServletException {
        int limit = 10;
        int page;
        if (request.getParameter("page") == null) {
            page = 1;
        } else {
            page = Integer.parseInt(request.getParameter("page"));
        }
        int offset = (page - 1) * limit;
        int totalpage = (int) Math.ceil((double) benhvienphongkhamDao.countAllRecords() / limit);
        double a = 10 / limit;
        System.out.println(a + "a");
        List<benhvienphongkham> listbv = benhvienphongkhamDao.selectAllBenhVien(limit, offset);
        request.setAttribute("listbv", listbv);
        request.setAttribute("totalPage", totalpage);
        List<tinhthanhpho> tinhtp = tinhTPDao.getAllThanhPho();
        request.setAttribute("tinhtp", tinhtp);
        System.out.println(totalpage + "tong so");
        System.out.println(benhvienphongkhamDao.countAllRecords() + "so ban gi");
        request.setAttribute("page", page);
        RequestDispatcher dispatcher = request.getRequestDispatcher("/admin/benhvienphongkham/list-benh-vien.jsp");
        dispatcher.forward(request, response);
    }

    private void showNewForm(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        RequestDispatcher dispatcher = request.getRequestDispatcher("benhvienform.jsp");
        List<tinhthanhpho> tinhtp = tinhTPDao.getAllThanhPho();
        List<loaihinh> loaihinhlist = loaiHinhDao.getAllLoaiHinh();
        List<chuyenkhoa> cklist = chuyenkhoaDao.getAllChuyenKhoa();
        List<quanhuyen> listqh = quanHuyenDao.getAllQuanHuyen();
        request.setAttribute("tinhtp", tinhtp);
        request.setAttribute("lhlist", loaihinhlist);
        request.setAttribute("cklist", cklist);
        request.setAttribute("listqh", listqh);
        dispatcher.forward(request, response);

    }

    private void showEditForm(HttpServletRequest request, HttpServletResponse response)
            throws SQLException, ServletException, IOException {
        int id = Integer.parseInt(request.getParameter("id"));
        benhvienphongkham existingBV = benhvienphongkhamDao.selectBV(id);
        List<tinhthanhpho> tinhtp = tinhTPDao.getAllThanhPho();
        List<loaihinh> loaihinhlist = loaiHinhDao.getAllLoaiHinh();
        List<quanhuyen> listqh = quanHuyenDao.getAllQuanHuyen();
        RequestDispatcher dispatcher = request.getRequestDispatcher("benhvienform.jsp");
        request.setAttribute("BenhVien", existingBV);
        request.setAttribute("tinhtp", tinhtp);
        request.setAttribute("lhlist", loaihinhlist);
        request.setAttribute("listqh", listqh);
        dispatcher.forward(request, response);

    }

    private void insertBV(HttpServletRequest request, HttpServletResponse response)
            throws SQLException, IOException {

        String a[] = request.getParameterValues("chuyenkhoa");
//        for(int i=0;i<a.length;i++){
//            System.out.println(Integer.parseInt(a[i]));
//        }
        try {

            String filename = null;
            // Create a factory for disk-based file items
            DiskFileItemFactory factory = new DiskFileItemFactory();
// Configure a repository (to ensure a secure temp location is used)
            ServletContext servletContext = this.getServletConfig().getServletContext();
            File repository = (File) servletContext.getAttribute("javax.servlet.context.tempdir");
            factory.setRepository(repository);

// Create a new file upload handler
            ServletFileUpload upload = new ServletFileUpload(factory);
// Parse the request
            List<FileItem> items = upload.parseRequest(request);
            // Process the uploaded items
            Iterator<FileItem> iter = items.iterator();
            HashMap<String, String> fields = new HashMap<>();
            List<String> completeSet = new ArrayList<String>();
            while (iter.hasNext()) {
                FileItem item = iter.next();

                if (item.isFormField()) {
                    fields.put(item.getFieldName(), item.getString("UTF-8"));

                    String name = item.getFieldName();
                    String value = item.getString();
                    if (name.equals("chuyenkhoa[]")) {
                        completeSet.add(value);
                    }
                    System.out.println(name);
                    System.out.println(value);

                } else {
                    filename = item.getName();
                    System.out.println("filename : " + filename);
                    if (filename == null || filename.equals("")) {
                        break;
                    } else {
                        Path path = Paths.get(filename);
                        String storePath = servletContext.getRealPath("/uploads");
                        File uploadFile = new File(storePath + "/" + path.getFileName());
                        for (int num = 0; uploadFile.exists(); num++) {
                            path = Paths.get(num + filename);
                            uploadFile = new File(storePath + "/" + path.getFileName());
                        }
                        item.write(uploadFile);
                        System.out.println(storePath + "/" + path.getFileName());
                    }
                }

            }
//            System.out.println("ko up dc");
            String tenbv = fields.get("tenbv");
            String diachi = fields.get("diachi");
            String sodienthoai = fields.get("sodienthoai");
            String tomtat = fields.get("tomtat");
            String mota = fields.get("mota");
            String anh = filename;
            String anhdaidien = fields.get("anhdaidien");
            int quanhuyenid = Integer.parseInt(fields.get("quanhuyenid"));
            int thanhphoid = Integer.parseInt(fields.get("thanhphoid"));
            int loaihinhid = Integer.parseInt(fields.get("loaihinhid"));
            int trangthai = Integer.parseInt(fields.get("trangthai"));
            String url = fields.get("urlbv");

            int xephang = Integer.parseInt(fields.get("rank"));
            completeSet.forEach(System.out::println);
            benhvien_chuyenkhoa bvpk = new benhvien_chuyenkhoa();

            benhvienphongkham newBV = new benhvienphongkham(tenbv, diachi, sodienthoai, tomtat, mota, anh, anhdaidien, quanhuyenid, thanhphoid, loaihinhid, trangthai, url, xephang);
            benhvienphongkhamDao.insertBenhVien(newBV);
            for (int i = 0; i < completeSet.size(); i++) {
                bvpk = new benhvien_chuyenkhoa(benhvienphongkhamDao.id_After_Insert(), Integer.parseInt(completeSet.get(i)));
                BenhVien_ChuyenKhoaDao.insertBV_CK(bvpk);
            }
//            System.out.println(anh + "ádasdasdasd");
        } catch (Exception e) {
        }
        response.sendRedirect("list-benh-vien");
    }

    private void updateBV(HttpServletRequest request, HttpServletResponse response)
            throws SQLException, IOException {
        try {
            String filename = null;
            // Create a factory for disk-based file items
            DiskFileItemFactory factory = new DiskFileItemFactory();
// Configure a repository (to ensure a secure temp location is used)
            ServletContext servletContext = this.getServletConfig().getServletContext();
            File repository = (File) servletContext.getAttribute("javax.servlet.context.tempdir");
            factory.setRepository(repository);

// Create a new file upload handler
            ServletFileUpload upload = new ServletFileUpload(factory);
// Parse the request
            List<FileItem> items = upload.parseRequest(request);
            // Process the uploaded items
            Iterator<FileItem> iter = items.iterator();
            HashMap<String, String> fields = new HashMap<>();
            while (iter.hasNext()) {
                FileItem item = iter.next();

                if (item.isFormField()) {
                    fields.put(item.getFieldName(), item.getString("UTF-8"));
                    String name = item.getFieldName();
                    String value = item.getString();
                    System.out.println(name);
                    System.out.println(value);
                } else {
                    filename = item.getName();
                    System.out.println("filename : " + filename);
                    if (filename == null || filename.equals("")) {
                        filename = fields.get("anhchitiet");
                    } else {
                        Path path = Paths.get(filename);
                        String storePath = servletContext.getRealPath("/uploads");
                        File uploadFile = new File(storePath + "/" + path.getFileName());
                        for (int num = 0; uploadFile.exists(); num++) {
                            path = Paths.get(num + filename);
                            uploadFile = new File(storePath + "/" + path.getFileName());
                        }
                        item.write(uploadFile);
                        System.out.println(storePath + "/" + path.getFileName());
                    }
                }

            }

            int id = Integer.parseInt(fields.get("id"));
            String tenbv = fields.get("tenbv");
            String diachi = fields.get("diachi");
            String sodienthoai = fields.get("sodienthoai");
            String tomtat = fields.get("tomtat");
            String mota = fields.get("mota");
            String anh = filename;
            String anhdaidien = fields.get("anhdaidien");
            int quanhuyenid = Integer.parseInt(fields.get("quanhuyenid"));
            int thanhphoid = Integer.parseInt(fields.get("thanhphoid"));
            int loaihinhid = Integer.parseInt(fields.get("loaihinhid"));
            int trangthai = Integer.parseInt(fields.get("trangthai"));
            String url = fields.get("urlbv");
            int xephang = Integer.parseInt(fields.get("rank"));

            benhvienphongkham BVupdate = new benhvienphongkham(id, tenbv, diachi, sodienthoai, tomtat, mota, anh, anhdaidien, quanhuyenid, thanhphoid, loaihinhid, trangthai, url, xephang);
            benhvienphongkhamDao.updateBenhVien(BVupdate);

        } catch (Exception e) {
            response.setStatus(500);
        }

        response.sendRedirect("list-benh-vien");
    }

    private void deleteBV(HttpServletRequest request, HttpServletResponse response)
            throws SQLException, IOException {
        int id = Integer.parseInt(request.getParameter("id"));
//        String id = request.getParameter("id");
        BenhVien_ChuyenKhoaDao.deleteBenhVien_ChuyenKhoa(id);
        benhvienphongkhamDao.deleteBenhVien(id);

        response.sendRedirect("list-benh-vien");
        System.out.println("sadsda");

    }
}
