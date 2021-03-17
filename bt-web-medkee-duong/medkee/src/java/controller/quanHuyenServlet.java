/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import bean.quanhuyen;
import bean.tinhthanhpho;
import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.sql.SQLException;
import java.util.List;
import javax.servlet.RequestDispatcher;
//import com.google.gson.Gson;
import java.io.PrintWriter;
import javax.servlet.http.HttpSession;
import model.quanHuyenDao;
import model.tinhTPDao;

/**
 *
 * @author Admin
 */
@WebServlet(urlPatterns = {"/admin/quanhuyen/list-quan-huyen", "/admin/quanhuyen/new", "/admin/quanhuyen/insert", "/admin/quanhuyen/delete", "/admin/quanhuyen/edit", "/admin/quanhuyen/update", "/admin/quanhuyen/QuanHuyenByTpid"})
public class quanHuyenServlet extends HttpServlet {

    private static final long serialVersionUID = 1L;
    private quanHuyenDao quanHuyenDao;
    private tinhTPDao tinhTPDao;

    public void init() {
        quanHuyenDao = new quanHuyenDao();
        tinhTPDao = new tinhTPDao();
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
            String action = request.getServletPath();
            System.out.println("action:" + action);

            try {
                switch (action) {
                    case "/admin/quanhuyen/new":
                        showNewForm(request, response);

                        break;
                    case "/admin/quanhuyen/insert":
                        insertQH(request, response);

                        break;
                    case "/admin/quanhuyen/delete":
                        deleteQH(request, response);
                        break;
                    case "/admin/quanhuyen/edit":
                        showEditForm(request, response);
                        break;
                    case "/admin/quanhuyen/update":
                        updateQH(request, response);
                        break;
                    case "/admin/quanhuyen/list-quan-huyen":
                        listQuanHuyen(request, response);
                        break;
                    case "/admin/quanhuyen/QuanHuyenByTpid":
                        getQuanHuyenByThanhphoid(request, response);
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

    private void listQuanHuyen(HttpServletRequest request, HttpServletResponse response)
            throws SQLException, IOException, ServletException {
        int limit = 8;
        int page;
        if (request.getParameter("page") == null) {
            page = 1;
        } else {
            page = Integer.parseInt(request.getParameter("page"));
        }
        int offset = (page - 1) * limit;
        int totalpage = (int) Math.ceil((double) quanHuyenDao.countAllRecords() / limit);
        List<quanhuyen> listQh = quanHuyenDao.selectAllQuanHuyen(limit, offset);
        request.setAttribute("listQh", listQh);
        List<tinhthanhpho> tinhtp = tinhTPDao.getAllThanhPho();
        request.setAttribute("tinhtp", tinhtp);
        request.setAttribute("totalPage", totalpage);
        System.out.println(totalpage + "tong so");
        System.out.println(quanHuyenDao.countAllRecords() + "so ban gi");
        request.setAttribute("page", page);
        RequestDispatcher dispatcher = request.getRequestDispatcher("/admin/quanhuyen/list-quan-huyen.jsp");
        dispatcher.forward(request, response);
    }

    private void showNewForm(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        List<tinhthanhpho> tinhtp = tinhTPDao.getAllThanhPho();
        RequestDispatcher dispatcher = request.getRequestDispatcher("quanhuyenform.jsp");
        request.setAttribute("tinhtp", tinhtp);
        dispatcher.forward(request, response);

    }

    private void showEditForm(HttpServletRequest request, HttpServletResponse response)
            throws SQLException, ServletException, IOException {
        int id = Integer.parseInt(request.getParameter("id"));
        quanhuyen existingQH = quanHuyenDao.selectQuanHuyen(id);
        List<tinhthanhpho> tinhtp = tinhTPDao.getAllThanhPho();
        RequestDispatcher dispatcher = request.getRequestDispatcher("quanhuyenform.jsp");
        request.setAttribute("tinhtp", tinhtp);
        request.setAttribute("quanhuyen", existingQH);
        dispatcher.forward(request, response);

    }

    private void getQuanHuyenByThanhphoid(HttpServletRequest request, HttpServletResponse response)
            throws SQLException, IOException {

        int thanhphoid = Integer.parseInt(request.getParameter("thanhphoid"));
        List<quanhuyen> listquanhuyenbythanhphoid = quanHuyenDao.getQuanHuyenByThanhPhoid(thanhphoid);
        response.setContentType("text/html;charset=UTF-8");
        try (PrintWriter out = response.getWriter()) {
            /* TODO output your page here. You may use following sample code. */
            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("</head>");
            out.println("<body>");
//            out.println("<h1>Servlet NewServlet at " + request.getContextPath() + "</h1>");
            out.println("<option value='0'>--- Trống ---</option>");
            for (quanhuyen qh : listquanhuyenbythanhphoid) {
                out.println("<option value='" + qh.getId() + "'>" + qh.getTenQH() + "</option>");
            }
            out.println("</body>");
            out.println("</html>");
        }

    }

    private void insertQH(HttpServletRequest request, HttpServletResponse response)
            throws SQLException, IOException {

        String tenqh = request.getParameter("tenqh");
        int thanhphoid = Integer.parseInt(request.getParameter("thanhphoid"));
        int trangthai = Integer.parseInt(request.getParameter("trangthai"));
        quanhuyen newQH = new quanhuyen(tenqh, thanhphoid, trangthai);
        quanHuyenDao.insertQuanHuyen(newQH);
//        Gson gson = new Gson();
//        PrintWriter printWriter = response.getWriter();
//         response.getWriter().write(new Gson().toJson(newLH));
//        printWriter.println(gson.toJson(newLH));
        response.sendRedirect("list-quan-huyen");
    }

    private void updateQH(HttpServletRequest request, HttpServletResponse response)
            throws SQLException, IOException {
        int id = Integer.parseInt(request.getParameter("id"));
        String tenQH = request.getParameter("tenqh");
        int thanhphoid = Integer.parseInt(request.getParameter("thanhphoid"));
        int trangthai = Integer.parseInt(request.getParameter("trangthai"));

        quanhuyen qh_update = new quanhuyen(id, tenQH, thanhphoid, trangthai);
        quanHuyenDao.updateQuanHuyen(qh_update);
        response.sendRedirect("list-quan-huyen");
    }

    private void deleteQH(HttpServletRequest request, HttpServletResponse response)
            throws SQLException, IOException {
        int id = Integer.parseInt(request.getParameter("id"));
//        String id = request.getParameter("id");
        quanHuyenDao.deleteQuanHuyen(id);
        response.sendRedirect("list-quan-huyen");
        System.out.println("sadsda");
    }

}
