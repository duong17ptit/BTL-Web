/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;


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
import bean.loaihinh;
import com.google.gson.Gson;
import java.io.PrintWriter;
import javax.servlet.http.HttpSession;
import model.tinhTPDao;


/**
 *
 * @author Admin
 */
@WebServlet(urlPatterns = {"/admin/tinhthanhpho/list-tinh-thanh-pho", "/admin/tinhthanhpho/new", "/admin/tinhthanhpho/insert", "/admin/tinhthanhpho/delete", "/admin/tinhthanhpho/edit", "/admin/tinhthanhpho/update"})
public class tinhthanhphoServlet  extends HttpServlet{
     private static final long serialVersionUID = 1L;
    private tinhTPDao tinhTPDao;

    public void init() {
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
            String action1 = request.getServletPath();
            System.out.println(action1);
            System.out.println("rung");

            try {
                switch (action1) {
                    case "/admin/tinhthanhpho/new":
                        showNewForm(request, response);

                        break;
                    case "/admin/tinhthanhpho/insert":
                        insertTP(request, response);

                        break;
                    case "/admin/tinhthanhpho/delete":
                        deleteTP(request, response);
                        break;
                    case "/admin/tinhthanhpho/edit":
                        showEditForm(request, response);
                        break;
                    case "/admin/tinhthanhpho/update":
                        updateTP(request, response);
                        break;
                    case "/admin/tinhthanhpho/list-tinh-thanh-pho":
                        listTinhThanhPho(request, response);
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

    private void  listTinhThanhPho(HttpServletRequest request, HttpServletResponse response)
            throws SQLException, IOException, ServletException {
        int limit = 8;
        int page;
        if(request.getParameter("page")== null){
            page = 1;
        }
        else page = Integer.parseInt(request.getParameter("page"));
        int offset = (page - 1) * limit;
        int totalpage = (int) Math.ceil((double)tinhTPDao.countAllRecords() / limit);
        double a =  10 /limit;
        System.out.println(a + "a");
        List<tinhthanhpho> listTp = tinhTPDao.selectAllThanhPho(limit, offset);
        request.setAttribute("listTp", listTp);
        request.setAttribute("totalPage", totalpage);
        System.out.println(totalpage +"tong so");
        System.out.println(tinhTPDao.countAllRecords() +"so ban gi");
        request.setAttribute("page", page);
        RequestDispatcher dispatcher = request.getRequestDispatcher("/admin/tinhthanhpho/list-tinh-thanh-pho.jsp");
        dispatcher.forward(request, response);
    }

    private void showNewForm(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        RequestDispatcher dispatcher = request.getRequestDispatcher("tinhthanhphoform.jsp");
        dispatcher.forward(request, response);

    }

    private void showEditForm(HttpServletRequest request, HttpServletResponse response)
            throws SQLException, ServletException, IOException {
        int id = Integer.parseInt(request.getParameter("id"));
        tinhthanhpho existingTP = tinhTPDao.selectTP(id);
        RequestDispatcher dispatcher = request.getRequestDispatcher("tinhthanhphoform.jsp");
        request.setAttribute("TinhThanhPho", existingTP);
        dispatcher.forward(request, response);

    }

    private void insertTP(HttpServletRequest request, HttpServletResponse response)
            throws SQLException, IOException {

        String tentp = request.getParameter("tentp");
        int trangthai = Integer.parseInt(request.getParameter("trangthai"));
        tinhthanhpho newTP = new tinhthanhpho(tentp, trangthai);
        tinhTPDao.insertTP(newTP);
//        Gson gson = new Gson();
//        PrintWriter printWriter = response.getWriter();
//         response.getWriter().write(new Gson().toJson(newLH));
//        printWriter.println(gson.toJson(newLH));
        response.sendRedirect("list-tinh-thanh-pho");
    }

    private void updateTP(HttpServletRequest request, HttpServletResponse response)
            throws SQLException, IOException {
         int id = Integer.parseInt(request.getParameter("id"));
        String tenTP = request.getParameter("tentp");
        int trangthai = Integer.parseInt(request.getParameter("trangthai"));

        tinhthanhpho TPupdate = new tinhthanhpho(id, tenTP, trangthai);
        tinhTPDao.updateTP(TPupdate);
        response.sendRedirect("list-tinh-thanh-pho");
    }

    private void deleteTP(HttpServletRequest request, HttpServletResponse response)
            throws SQLException, IOException {
        int id = Integer.parseInt(request.getParameter("id"));
//        String id = request.getParameter("id");
        tinhTPDao.deleteThanhPho(id);
        response.sendRedirect("list-tinh-thanh-pho");
        System.out.println("sadsda");
    }

}
