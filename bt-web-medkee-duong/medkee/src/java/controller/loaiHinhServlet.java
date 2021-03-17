/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.sql.SQLException;
import java.util.List;
import javax.servlet.RequestDispatcher;
import bean.loaihinh;
import com.google.gson.Gson;
import java.io.PrintWriter;
import javax.servlet.http.HttpSession;
import model.loaiHinhDao;

/**
 *
 * @author Admin
 */
//@WebServlet(urlPatterns = {"/admin/loaihinh"})
@WebServlet(urlPatterns = {"/admin/loaihinh/list-loai-hinh", "/admin/loaihinh/new", "/admin/loaihinh/insert", "/admin/loaihinh/delete", "/admin/loaihinh/edit", "/admin/loaihinh/update"})
public class loaiHinhServlet extends HttpServlet {

    private static final long serialVersionUID = 1L;
    private loaiHinhDao loaiHinhDao;

    public void init() {
        loaiHinhDao = new loaiHinhDao();
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
                    case "/admin/loaihinh/new":
                        showNewForm(request, response);
                        break;
                    case "/admin/loaihinh/insert":
                        insertLH(request, response);
                        break;
                    case "/admin/loaihinh/delete":
                        deleteLH(request, response);
                        break;
                    case "/admin/loaihinh/edit":
                        showEditForm(request, response);
                        break;
                    case "/admin/loaihinh/update":
                        updateLH(request, response);
                        break;
                    case "/admin/loaihinh/list-loai-hinh":
                        listLoaiHinh(request, response);
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

    private void listLoaiHinh(HttpServletRequest request, HttpServletResponse response)
            throws SQLException, IOException, ServletException {
        int limit = 8;
        int page;
        if (request.getParameter("page") == null) {
            page = 1;
        } else {
            page = Integer.parseInt(request.getParameter("page"));
        }
        int offset = (page - 1) * limit;
        int totalpage = (int) Math.ceil((double) loaiHinhDao.countAllRecords() / limit);
        double a = 10 / limit;
        System.out.println(a + "a");
        List<loaihinh> listlh = loaiHinhDao.selectAllLoaiHinh(limit, offset);
        request.setAttribute("listlh", listlh);
        request.setAttribute("totalPage", totalpage);
        System.out.println(totalpage + "tong so");
        System.out.println(loaiHinhDao.countAllRecords() + "so ban gi");
        request.setAttribute("page", page);
        RequestDispatcher dispatcher = request.getRequestDispatcher("/admin/loaihinh/list-loai-hinh.jsp");
        dispatcher.forward(request, response);
    }

    private void showNewForm(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        RequestDispatcher dispatcher = request.getRequestDispatcher("loaihinhform.jsp");
        dispatcher.forward(request, response);
    }

    private void showEditForm(HttpServletRequest request, HttpServletResponse response)
            throws SQLException, ServletException, IOException {
        int id = Integer.parseInt(request.getParameter("id"));
        loaihinh existingLH = loaiHinhDao.selectLH(id);
        RequestDispatcher dispatcher = request.getRequestDispatcher("loaihinhform.jsp");
        request.setAttribute("loaihinh", existingLH);
//        response.getWriter().write(new Gson().toJson(existingLH));
        dispatcher.forward(request, response);

    }

    private void insertLH(HttpServletRequest request, HttpServletResponse response)
            throws SQLException, IOException {

        String tenlh = request.getParameter("tenlh");
        int trangthai = Integer.parseInt(request.getParameter("trangthai"));
        loaihinh newLH = new loaihinh(tenlh, trangthai);
        loaiHinhDao.insertLH(newLH);
//        Gson gson = new Gson();
//        PrintWriter printWriter = response.getWriter();
//         response.getWriter().write(new Gson().toJson(newLH));
//        printWriter.println(gson.toJson(newLH));
        response.sendRedirect("list-loai-hinh");
    }

    private void updateLH(HttpServletRequest request, HttpServletResponse response)
            throws SQLException, IOException {
        int id = Integer.parseInt(request.getParameter("id"));
        String tenlh = request.getParameter("tenlh");
        int trangthai = Integer.parseInt(request.getParameter("trangthai"));

        loaihinh LHupdate = new loaihinh(id, tenlh, trangthai);
        loaiHinhDao.updateLH(LHupdate);
        response.sendRedirect("list-loai-hinh");
    }

    private void deleteLH(HttpServletRequest request, HttpServletResponse response)
            throws SQLException, IOException {
        int id = Integer.parseInt(request.getParameter("id"));
//        String id = request.getParameter("id");
        loaiHinhDao.deleteLoaiHinh(id);
        response.sendRedirect("list-loai-hinh");

    }
}
