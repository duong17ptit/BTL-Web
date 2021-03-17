/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import bean.danhmuc;
import java.io.File;
import java.io.IOException;
import java.io.PrintWriter;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.sql.SQLException;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import model.danhmucDao;
import org.apache.commons.fileupload.FileItem;
import org.apache.commons.fileupload.disk.DiskFileItemFactory;
import org.apache.commons.fileupload.servlet.ServletFileUpload;

/**
 *
 * @author Admin
 */
//web anotation
@WebServlet(urlPatterns = {"/admin/danhmuc/list-danh-muc", "/admin/danhmuc/new", "/admin/danhmuc/insert", "/admin/danhmuc/delete", "/admin/danhmuc/edit", "/admin/danhmuc/update"})
public class danhmucServlet extends HttpServlet {

    private static final long serialVersionUID = 1L;
    private danhmucDao danhmucDao;

    public void init() {
        danhmucDao = new danhmucDao();
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
                    case "/admin/danhmuc/new":
                        showNewForm(request, response);

                        break;
                    case "/admin/danhmuc/insert":
                        insertDanhMuc(request, response);

                        break;
                    case "/admin/danhmuc/delete":
                        deleteDanhMuc(request, response);
                        break;
                    case "/admin/danhmuc/edit":
                        showEditForm(request, response);
                        break;
                    case "/admin/danhmuc/update":
                        updateDanhMuc(request, response);
                        break;
                    case "/admin/danhmuc/list-danh-muc":
                        listDanhMuc(request, response);
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

    private void listDanhMuc(HttpServletRequest request, HttpServletResponse response)
            throws SQLException, IOException, ServletException {
        int limit = 8;
        int page;
        if (request.getParameter("page") == null) {
            page = 1;
        } else {
            page = Integer.parseInt(request.getParameter("page"));
        }
        int offset = (page - 1) * limit;
        int totalpage = (int) Math.ceil((double) danhmucDao.countAllRecords() / limit);
        double a = 10 / limit;
        System.out.println(a + "a");
        List<danhmuc> listDanhMuc = danhmucDao.selectAllDanhMuc(limit, offset);
        request.setAttribute("listDanhMuc", listDanhMuc);
        request.setAttribute("totalPage", totalpage);
        System.out.println(totalpage + "tong so");
        System.out.println(danhmucDao.countAllRecords() + "so ban gi");
        request.setAttribute("page", page);
        RequestDispatcher dispatcher = request.getRequestDispatcher("/admin/danhmuc/list-danh-muc.jsp");
        dispatcher.forward(request, response);
    }

    private void showNewForm(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        RequestDispatcher dispatcher = request.getRequestDispatcher("danhmucform.jsp");
        dispatcher.forward(request, response);

    }

    private void showEditForm(HttpServletRequest request, HttpServletResponse response)
            throws SQLException, ServletException, IOException {
        int id = Integer.parseInt(request.getParameter("id"));
        danhmuc existingDanhMuc = danhmucDao.selectDanhMuc(id);
        RequestDispatcher dispatcher = request.getRequestDispatcher("danhmucform.jsp");
        request.setAttribute("danhmuc", existingDanhMuc);
        dispatcher.forward(request, response);

    }

    private void insertDanhMuc(HttpServletRequest request, HttpServletResponse response)
            throws SQLException, IOException {

        try {
            String filename = null;
            //tạo các ổ chứa cho các tệp dựa trên ổ đĩa
            DiskFileItemFactory factory = new DiskFileItemFactory();
// Định cấu hình kho lưu trữ (để đảm bảo sử dụng vị trí tạm thời an toàn)
            ServletContext servletContext = this.getServletConfig().getServletContext();
            File repository = (File) servletContext.getAttribute("javax.servlet.context.tempdir");
            factory.setRepository(repository);

// tạo trình xử lý file upload
            ServletFileUpload upload = new ServletFileUpload(factory);
// phân tích resquest
            List<FileItem> items = upload.parseRequest(request);
            // Xử lý các mục tải lên
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
            String tenDanhMuc = fields.get("tenDanhMuc");
            String anh = filename;
            int trangthai = Integer.parseInt(fields.get("trangthai"));
            danhmuc newDanhMuc = new danhmuc(tenDanhMuc, anh, trangthai);
            danhmucDao.insertDanhMuc(newDanhMuc);
        } catch (Exception e) {

        }
        response.sendRedirect("list-danh-muc");
//        Gson gson = new Gson();
//        PrintWriter printWriter = response.getWriter();
//         response.getWriter().write(new Gson().toJson(newLH));
//        printWriter.println(gson.toJson(newLH));

    }

    private void updateDanhMuc(HttpServletRequest request, HttpServletResponse response)
            throws SQLException, IOException {

        try {

//            String anhIFnotUpload = request.getParameter("anhdanhmuc");
//            System.out.println(anhIFnotUpload);
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
                        filename = fields.get("anhdanhmuc");
                        System.out.println("update fail");
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
            String tenDanhMuc = fields.get("tenDanhMuc");
            String anh = filename;
            int trangthai = Integer.parseInt(fields.get("trangthai"));
            System.out.println(filename + "sss");
            danhmuc DanhMucUpdate = new danhmuc(id, tenDanhMuc, anh, trangthai);
            danhmucDao.updateDanhMuc(DanhMucUpdate);

        } catch (Exception e) {
        }

        response.sendRedirect("list-danh-muc");
    }

    private void deleteDanhMuc(HttpServletRequest request, HttpServletResponse response)
            throws SQLException, IOException {
        int id = Integer.parseInt(request.getParameter("id"));
//        String id = request.getParameter("id");
        danhmucDao.deleteDanhMuc(id);
        response.sendRedirect("list-danh-muc");
//        System.out.println("sadsda");
    }

}
