/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import bean.chuyenkhoa;
import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.sql.SQLException;
import java.util.List;
import javax.servlet.RequestDispatcher;
import com.google.gson.Gson;
import java.io.PrintWriter;
import javax.servlet.http.HttpSession;
import model.chuyenkhoaDao;


/**
 *
 * @author Admin
 */

@WebServlet(urlPatterns = {"/admin/chuyenkhoa/list-ck", "/admin/chuyenkhoa/new", "/admin/chuyenkhoa/insert", "/admin/chuyenkhoa/delete", "/admin/chuyenkhoa/edit", "/admin/chuyenkhoa/update"})
public class chuyenkhoaServlet extends HttpServlet {

    private static final long serialVersionUID = 1L;
    private chuyenkhoaDao chuyenkhoaDao;

    public void init() {
        chuyenkhoaDao = new chuyenkhoaDao();
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        doGet(request, response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        request.setCharacterEncoding("utf-8");
        String action = request.getServletPath();
        System.out.println(action);
        System.out.println("ádasdasdasd");
        PrintWriter out = response.getWriter();
        HttpSession session = request.getSession();
        if (session.getAttribute("name") != null) {
            try {
                switch (action) {
                    case "/admin/chuyenkhoa/new":
                        showNewForm(request, response);
                        break;
                    case "/admin/chuyenkhoa/insert":
                        insertCK(request, response);
                        break;
                    case "/admin/chuyenkhoa/delete":
                        deleteCK(request, response);
                        break;
                    case "/admin/chuyenkhoa/edit":
                        showEditForm(request, response);
                        break;
                    case "/admin/chuyenkhoa/update":
                        updateCK(request, response);
                        break;
                    case "/admin/chuyenkhoa/list-ck":
                        listChuyenKhoa(request, response);
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

    private void listChuyenKhoa(HttpServletRequest request, HttpServletResponse response)
            throws SQLException, IOException, ServletException {
        int limit = 8;
        int page;
        if (request.getParameter("page") == null) {
            page = 1;
        } else {
            page = Integer.parseInt(request.getParameter("page"));
        }
        int offset = (page - 1) * limit;
        int totalpage = (int) Math.ceil((double) chuyenkhoaDao.countAllRecords() / limit);
        double a = 10 / limit;
        System.out.println(a + "a");
        List<chuyenkhoa> listck = chuyenkhoaDao.selectAllChuyenKhoa(limit, offset);
        request.setAttribute("listck", listck);
        request.setAttribute("totalPage", totalpage);
        System.out.println(totalpage + "tong so");
        System.out.println(chuyenkhoaDao.countAllRecords() + "so ban gi");
        request.setAttribute("page", page);
        RequestDispatcher dispatcher = request.getRequestDispatcher("/admin/chuyenkhoa/list-ck.jsp");
        dispatcher.forward(request, response);
    }

    private void showNewForm(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        RequestDispatcher dispatcher = request.getRequestDispatcher("chuyenkhoaform.jsp");
        dispatcher.forward(request, response);
    }

    private void showEditForm(HttpServletRequest request, HttpServletResponse response)
            throws SQLException, ServletException, IOException {
        int id = Integer.parseInt(request.getParameter("id"));
        chuyenkhoa existingCK = chuyenkhoaDao.selectCK(id);
        RequestDispatcher dispatcher = request.getRequestDispatcher("chuyenkhoaform.jsp");
        request.setAttribute("chuyenkhoa", existingCK);
//        response.getWriter().write(new Gson().toJson(existingLH));
        dispatcher.forward(request, response);

    }

    private void insertCK(HttpServletRequest request, HttpServletResponse response)
            throws SQLException, IOException {

        String tenck = request.getParameter("tenck");
        int trangthai = Integer.parseInt(request.getParameter("trangthai"));
        chuyenkhoa newCK = new chuyenkhoa(tenck, trangthai);
        chuyenkhoaDao.insertCK(newCK);
//        Gson gson = new Gson();
//        PrintWriter printWriter = response.getWriter();
//         response.getWriter().write(new Gson().toJson(newLH));
//        printWriter.println(gson.toJson(newLH));
        response.sendRedirect("list-ck");
    }

    private void updateCK(HttpServletRequest request, HttpServletResponse response)
            throws SQLException, IOException {
        int id = Integer.parseInt(request.getParameter("id"));
        String tenck = request.getParameter("tenck");
        int trangthai = Integer.parseInt(request.getParameter("trangthai"));

        chuyenkhoa CKupdate = new chuyenkhoa(id, tenck, trangthai);
        chuyenkhoaDao.updateCK(CKupdate);
        response.sendRedirect("list-ck");
    }

    private void deleteCK(HttpServletRequest request, HttpServletResponse response)
            throws SQLException, IOException {
        int id = Integer.parseInt(request.getParameter("id"));
//        String id = request.getParameter("id");
        chuyenkhoaDao.deleteChuyenKhoa(id);
        response.sendRedirect("list-ck");

    }
}
