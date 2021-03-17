/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import bean.benhvienphongkham;
import static java.lang.Math.ceil;
import java.sql.Statement;
import util.DBConnection;

/**
 *
 * @author Admin
 */
public class benhvienphongkhamDao {
//     Connection con = null;

    private static final String addBV = "INSERT INTO benhvienphongkham" + "  ( ten, diachi, sodienthoai, tomtat, mota, anh, anhdaidien, QuanHuyenid,ThanhPhoid,LoaiHinhid,trangthai,urlBv,xepHang) VALUES "
            + " (?, ?, ?,?,?,?,?,?,?,?,?,?,?);";
    private static final String countAllRecord = "select * from benhvienphongkham";
    private static final String selectBvById = "select id,ten,diachi,sodienthoai, tomtat, mota, anh, anhdaidien, QuanHuyenid,ThanhPhoid,LoaiHinhid,trangthai,urlBv,xepHang from benhvienphongkham where id =?";
    private static final String getAllBV = "select * from benhvienphongkham ORDER BY id DESC  LIMIT ? OFFSET ?";
    private static final String deleteBV = "delete from benhvienphongkham where id = ?;";
//        private static final String UPDATE_USERS_SQL = "update benhvienphongkham set name = ?,email= ?, country =? where id = ?;";

    private static final String updateBV = "update benhvienphongkham set ten= ?, diachi= ?, sodienthoai= ?, tomtat= ?, mota= ?, anh= ?, anhdaidien= ?, QuanHuyenid= ?,ThanhPhoid= ?,LoaiHinhid= ?,trangthai= ?,urlBv = ?,xepHang = ? where id= ?;";

    public benhvienphongkhamDao() {
    }

    public void insertBenhVien(benhvienphongkham benhvien) throws SQLException {
        System.out.println(addBV);
        // try-with-resource statement will auto close the connection.
        try (Connection con = DBConnection.createConnection();
                PreparedStatement preparedStatement = con.prepareStatement(addBV)) {
            preparedStatement.setString(1, benhvien.getTenBV());
            preparedStatement.setString(2, benhvien.getDiachi());
            preparedStatement.setString(3, benhvien.getSodienthoai());
            preparedStatement.setString(4, benhvien.getTomtat());
            preparedStatement.setString(5, benhvien.getMota());
            preparedStatement.setString(6, benhvien.getAnhbvchitiet());
            preparedStatement.setString(7, benhvien.getAnhdaidien());
            preparedStatement.setInt(8, benhvien.getQuanhuyenid());
            preparedStatement.setInt(9, benhvien.getThanhphoid());
            preparedStatement.setInt(10, benhvien.getLoaihinhid());
            preparedStatement.setInt(11, benhvien.getTrangthai());
            preparedStatement.setString(12, benhvien.getUrlbv());
            preparedStatement.setInt(13, benhvien.getRank());

            System.out.println(preparedStatement);
            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            printSQLException(e);
        }
    }

    public benhvienphongkham selectBV(int id) {
        benhvienphongkham benhvien = null;
        // Step 1: Establishing a Connection
        try (Connection connection = DBConnection.createConnection();
                // Step 2:Create a statement using connection object
                PreparedStatement preparedStatement = connection.prepareStatement(selectBvById);) {
            preparedStatement.setInt(1, id);
            System.out.println(preparedStatement);
            // Step 3: Execute the query or update query
            ResultSet rs = preparedStatement.executeQuery();

            // Step 4: Process the ResultSet object.
            while (rs.next()) {

                String tenbv = rs.getString("ten");
                String diachi = rs.getString("diachi");
                String sodienthoai = rs.getString("sodienthoai");
                String tomtat = rs.getString("tomtat");
                String mota = rs.getString("mota");
                String anh = rs.getString("anh");
                String anhdaidien = rs.getString("anhdaidien");
                int quanhuyenid = rs.getInt("QuanHuyenid");
                int thanhphoid = rs.getInt("ThanhPhoid");
                int loaihinhid = rs.getInt("LoaiHinhid");
                int trangthai = rs.getInt("trangthai");
                String url = rs.getString("urlBv");
                int xephang = rs.getInt("xepHang");
                benhvien = new benhvienphongkham(id, tenbv, diachi, sodienthoai, tomtat, mota, anh, anhdaidien, quanhuyenid, thanhphoid, loaihinhid, trangthai, url, xephang);
            }
        } catch (SQLException e) {
            printSQLException(e);
        }
        return benhvien;
    }

    public boolean updateBenhVien(benhvienphongkham benhvien) throws SQLException {
        boolean rowUpdated;
        try (Connection connection = DBConnection.createConnection();
                PreparedStatement statement = connection.prepareStatement(updateBV);) {
            statement.setString(1, benhvien.getTenBV());
            statement.setString(2, benhvien.getDiachi());
            statement.setString(3, benhvien.getSodienthoai());
            statement.setString(4, benhvien.getTomtat());
            statement.setString(5, benhvien.getMota());
            statement.setString(6, benhvien.getAnhbvchitiet());
            statement.setString(7, benhvien.getAnhdaidien());
            statement.setInt(8, benhvien.getQuanhuyenid());
            statement.setInt(9, benhvien.getThanhphoid());
            statement.setInt(10, benhvien.getLoaihinhid());
            statement.setInt(11, benhvien.getTrangthai());
            statement.setString(12, benhvien.getUrlbv());
            statement.setInt(13, benhvien.getRank());
            statement.setInt(14, benhvien.getId());

            rowUpdated = statement.executeUpdate() > 0;
        }
        System.out.println(updateBV);
        return rowUpdated;
    }

    public List<benhvienphongkham> getAllBV() {
//    

        // using try-with-resources to avoid closing resources (boiler plate code)
        List<benhvienphongkham> bvlists1 = new ArrayList<>();
        // Step 1: Establishing a Connection
        try (Connection connection = DBConnection.createConnection();
                PreparedStatement statement = connection.prepareStatement(countAllRecord);) {

            ResultSet resultSet = statement.executeQuery();

            while (resultSet.next()) {
                int id = resultSet.getInt("id");
                String tenbv = resultSet.getString("ten");
                String diachi = resultSet.getString("diachi");
                String sodienthoai = resultSet.getString("sodienthoai");
                String tomtat = resultSet.getString("tomtat");
                String mota = resultSet.getString("mota");
                String anh = resultSet.getString("anh");
                String anhdaidien = resultSet.getString("anhdaidien");
                int quanhuyenid = resultSet.getInt("QuanHuyenid");
                int thanhphoid = resultSet.getInt("ThanhPhoid");
                int loaihinhid = resultSet.getInt("LoaiHinhid");
                int trangthai = resultSet.getInt("trangthai");
                String url = resultSet.getString("urlBv");
                int xephang = resultSet.getInt("xepHang");
                bvlists1.add(new benhvienphongkham(id, tenbv, diachi, sodienthoai, tomtat, mota, anh, anhdaidien, quanhuyenid, thanhphoid, loaihinhid, trangthai, url, xephang));
            }
        } catch (SQLException e) {
            printSQLException(e);
        }
        return bvlists1;
    }

    public int id_After_Insert() {
        try (Connection connection = DBConnection.createConnection()) {
            Statement st = null;
            int id=0;
            st = connection.createStatement();
            ResultSet result = st.executeQuery(countAllRecord);
            if (result.last()) {
                id = result.getInt("id");
                 return id;
            }
        } catch (SQLException e) {
            printSQLException(e);
        }
      return 0;
    }

    public int countAllRecords() {
        int totalPaqe = 0;
        try (Connection connection = DBConnection.createConnection()) {
            Statement st = null;
            st = connection.createStatement();
            ResultSet resultTotalRecord = st.executeQuery(countAllRecord);
            resultTotalRecord.last();
            totalPaqe = resultTotalRecord.getRow();
        } catch (SQLException e) {
            printSQLException(e);
        }
        return totalPaqe;
    }

    public List<benhvienphongkham> selectAllBenhVien(int limit, int offset) {
        Statement st = null;
        // using try-with-resources to avoid closing resources (boiler plate code)
        List<benhvienphongkham> benhvienlists = new ArrayList<>();
        // Step 1: Establishing a Connection
        try (Connection connection = DBConnection.createConnection();
                PreparedStatement statement = connection.prepareStatement(getAllBV);) {
            statement.setInt(1, limit);
            statement.setInt(2, offset);
            // Step 2:Create a statement using connection object
//            PreparedStatement preparedStatement = connection.prepareStatement(SELECT_ALL_USERS); 
//                 st = connection.createStatement();
//         ResultSet resultTotalRecord = st.executeQuery(countAllRecord);
//         
//         int totalPaqe = (int) ceil((resultTotalRecord.getRow())/limit);
//            System.out.println(totalPaqe);

            ResultSet resultSet = statement.executeQuery();
            //            System.out.println(preparedStatement);
            // Step 3: Execute the query or update query
            //            ResultSet rs = preparedStatement.executeQuery();
            // Step 4: Process the ResultSet object.
            while (resultSet.next()) {
                int id = resultSet.getInt("id");
                String tenbv = resultSet.getString("ten");
                String diachi = resultSet.getString("diachi");
                String sodienthoai = resultSet.getString("sodienthoai");
                String tomtat = resultSet.getString("tomtat");
                String mota = resultSet.getString("mota");
                String anh = resultSet.getString("anh");
                String anhdaidien = resultSet.getString("anhdaidien");
                int quanhuyenid = resultSet.getInt("QuanHuyenid");
                int thanhphoid = resultSet.getInt("ThanhPhoid");
                int loaihinhid = resultSet.getInt("LoaiHinhid");
                int trangthai = resultSet.getInt("trangthai");
                String url = resultSet.getString("urlBv");
                int xephang = resultSet.getInt("xepHang");
                benhvienlists.add(new benhvienphongkham(id, tenbv, diachi, sodienthoai, tomtat, mota, anh, anhdaidien, quanhuyenid, thanhphoid, loaihinhid, trangthai, url, xephang));
            }
        } catch (SQLException e) {
            printSQLException(e);
        }

        return benhvienlists;
    }

    public boolean deleteBenhVien(int id) throws SQLException {
        boolean rowDeleted;
        try (Connection connection = DBConnection.createConnection();
                PreparedStatement statement = connection.prepareStatement(deleteBV);) {
            statement.setInt(1, id);
            rowDeleted = statement.executeUpdate() > 0;
        }
        System.out.println(deleteBV);
        return rowDeleted;
    }

    private void printSQLException(SQLException ex) {
        for (Throwable e : ex) {
            if (e instanceof SQLException) {
                e.printStackTrace(System.err);
                System.err.println("SQLState: " + ((SQLException) e).getSQLState());
                System.err.println("Error Code: " + ((SQLException) e).getErrorCode());
                System.err.println("Message: " + e.getMessage());
                Throwable t = ex.getCause();
                while (t != null) {
                    System.out.println("Cause: " + t);
                    t = t.getCause();
                }
            }
        }
    }
}
