/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller.web;

import bean.benhvienphongkham;
import bean.chuyenkhoa;
import bean.loaihinh;
import bean.tinhthanhpho;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import model.benhvienphongkhamDao;
import model.chuyenkhoaDao;
import model.cosoyteDao;
import model.loaiHinhDao;
import model.tinhTPDao;

/**
 *
 * @author Admin
 */
@WebServlet(urlPatterns = {"/cosoyte/list", "/cosoyte/trangchitiet"})
public class cosoyteServlet extends HttpServlet {

    private static final long serialVersionUID = 1L;
    private benhvienphongkhamDao benhvienphongkhamDao;
    private tinhTPDao tinhTPDao;
    private loaiHinhDao loaiHinhDao;
    private cosoyteDao cosoyteDao;
    private chuyenkhoaDao chuyenkhoaDao;

    public void init() {
        tinhTPDao = new tinhTPDao();
        benhvienphongkhamDao = new benhvienphongkhamDao();
        loaiHinhDao = new loaiHinhDao();
        cosoyteDao = new cosoyteDao();
        chuyenkhoaDao = new chuyenkhoaDao();
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
//        RequestDispatcher dispatcher = request.getRequestDispatcher("/cosoyte/cosoyte.jsp");
//        dispatcher.forward(request, response);
        String action = request.getServletPath();
        try {
            switch (action) {
                case "/cosoyte/list":
                    listBenhVien(request, response);

                    break;
                case "/cosoyte/trangchitiet":
                    showBVPK_chi_tiet(request, response);
                    break;
            }
        } catch (SQLException ex) {
            throw new ServletException(ex);
        }

    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        doGet(request, response);
    }

    /**
     * .
     *
     * @return a list benh vien
     */
    private void listBenhVien(HttpServletRequest request, HttpServletResponse response)
            throws SQLException, IOException, ServletException {
        response.setContentType("text/html;charset=UTF-8");
        int limit = 5;
        int page;
        if (request.getParameter("page") == null) {
            page = 1;
        } else {
            page = Integer.parseInt(request.getParameter("page"));
        }
        int offset = (page - 1) * limit;

        String diachi = request.getParameter("diachi");
        String loaihinh = request.getParameter("loaihinh");
        String chuyenkhoa = request.getParameter("chuyenkhoa");
        int totalpage = (int) Math.ceil((double) cosoyteDao.countAllRecords(diachi, loaihinh, chuyenkhoa) / limit);
        System.out.println(totalpage);
        List<benhvienphongkham> listbv = cosoyteDao.selectAllBenhVien(diachi, loaihinh, chuyenkhoa, limit, offset);
        request.setAttribute("listbv", listbv);
//        request.setAttribute("totalPage", totalpage);
        List<tinhthanhpho> tinhtp = tinhTPDao.getAllThanhPho();
        List<loaihinh> listlh = loaiHinhDao.getAllLoaiHinh();
        List<chuyenkhoa> listck = chuyenkhoaDao.getAllChuyenKhoa();
        request.setAttribute("tinhtp", tinhtp);
        request.setAttribute("listlh", listlh);
        request.setAttribute("listck", listck);
        request.setAttribute("totalPage", totalpage);
//        System.out.println(totalpage + "tong so");
        request.setAttribute("page", page);
        RequestDispatcher dispatcher = request.getRequestDispatcher("/cosoyte/cosoyte.jsp");
        dispatcher.forward(request, response);
    }

    /**
     * .
     *
     * @return a Benh vien chi tiet theo id
     */
    private void showBVPK_chi_tiet(HttpServletRequest request, HttpServletResponse response)
            throws SQLException, IOException, ServletException {
        response.setContentType("text/html;charset=UTF-8");
        int id = Integer.parseInt(request.getParameter("id"));
        benhvienphongkham thisBV = cosoyteDao.findBvByID(id);
        request.setAttribute("bvchitiet", thisBV);
        RequestDispatcher dispatcher = request.getRequestDispatcher("/cosoyte/chi-tiet.jsp");
        dispatcher.forward(request, response);

    }

    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
