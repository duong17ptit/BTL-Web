/*
 Dương nè !
 */
package model;

import bean.benhvienphongkham;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import util.DBConnection;

/**
 *
 * @author Admin
 */
public class cosoyteDao {

    private static final String limit_offset = "limit ? offset ?";
    private static final String countAllRecord = "select distinct benhvienphongkham.id,benhvienphongkham.ten, benhvienphongkham.diachi, benhvienphongkham.sodienthoai,benhvienphongkham.tomtat,benhvienphongkham.anh,benhvienphongkham.anhdaidien ,benhvienphongkham.ten,benhvienphongkham.QuanHuyenid,benhvienphongkham.ThanhPhoid,benhvienphongkham.trangthai,benhvienphongkham.urlBv,benhvienphongkham.xepHang ,benhvienphongkham.LoaiHinhid,benhvienphongkham.mota from benhvienphongkham,benhvien_chuyenkhoa,chuyenkhoa  where benhvienphongkham.id = benhvien_chuyenkhoa.BVPKid  and chuyenkhoa.id = benhvien_chuyenkhoa.CKid and ThanhPhoid = IFNULL(?, ThanhPhoid) and LoaiHinhid = IFNULL(?, LoaiHinhid) and chuyenkhoa.id = IFNULL(?, chuyenkhoa.id)";
    private static final String selectBvQuery = "select distinct benhvienphongkham.id,benhvienphongkham.ten, benhvienphongkham.diachi, benhvienphongkham.sodienthoai,benhvienphongkham.tomtat,benhvienphongkham.anh,benhvienphongkham.anhdaidien ,benhvienphongkham.ten,benhvienphongkham.QuanHuyenid,benhvienphongkham.ThanhPhoid,benhvienphongkham.trangthai,benhvienphongkham.urlBv,benhvienphongkham.xepHang ,benhvienphongkham.LoaiHinhid,benhvienphongkham.mota from benhvienphongkham,benhvien_chuyenkhoa,chuyenkhoa  where benhvienphongkham.id = benhvien_chuyenkhoa.BVPKid  and chuyenkhoa.id = benhvien_chuyenkhoa.CKid and ThanhPhoid = IFNULL(?, ThanhPhoid) and LoaiHinhid = IFNULL(?, LoaiHinhid) and chuyenkhoa.id = IFNULL(?, chuyenkhoa.id) limit ? offset ?";

    private static final String getAllBV = "select * from benhvienphongkham ";
    private static final String findBvByID = "select id,ten,diachi,sodienthoai, tomtat, mota, anh, anhdaidien, QuanHuyenid,ThanhPhoid,LoaiHinhid,trangthai,urlBv,xepHang from benhvienphongkham where id =?";

    public int countAllRecords(String diachibv, String loaihinh, String chuyenkhoa) {
        int totalPaqe = 0;
        try (Connection connection = DBConnection.createConnection();
                PreparedStatement statement = connection.prepareStatement(countAllRecord);) {
            if (loaihinh == "") {
                loaihinh = null;
            }
            if (diachibv == "") {
                diachibv = null;
            }
            if (chuyenkhoa == "") {
                chuyenkhoa = null;
            }
            statement.setString(1, diachibv);
            statement.setString(2, loaihinh);
            statement.setString(3, chuyenkhoa);
//            Statement st = null;

//            st = connection.createStatement();
            ResultSet resultTotalRecord = statement.executeQuery();
            resultTotalRecord.last();
            totalPaqe = resultTotalRecord.getRow();
            return totalPaqe;
        } catch (SQLException e) {
            printSQLException(e);
        }
        return 0;
    }

    public List<benhvienphongkham> selectAllBenhVien(String diachibv, String loaihinh, String chuyenkhoa, int limit, int offset) {
        Statement st = null;
        // using try-with-resources to avoid closing resources (boiler plate code)
        List<benhvienphongkham> benhvienlists = new ArrayList<>();
        // Step 1: Establishing a Connection
        try (Connection connection = DBConnection.createConnection();
                PreparedStatement statement = connection.prepareStatement(selectBvQuery);) {
            if (loaihinh == "") {
                loaihinh = null;
            }
            if (diachibv == "") {
                diachibv = null;
            }
            if (chuyenkhoa == "") {
                chuyenkhoa = null;
            }
            statement.setString(1, diachibv);
            statement.setString(2, loaihinh);
            statement.setString(3, chuyenkhoa);
            statement.setInt(4, limit);
            statement.setInt(5, offset);
            System.out.println(diachibv + "lalalalala");
            System.out.println(loaihinh + " gi vay");
            System.out.println(chuyenkhoa + " gi vay taaaaa");
            System.out.println(selectBvQuery);

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
                benhvienlists.add(new benhvienphongkham(id, tenbv, diachi, sodienthoai, tomtat, mota, anh, anhdaidien, quanhuyenid, thanhphoid, loaihinhid, trangthai, url, xephang));
            }
        } catch (SQLException e) {
            printSQLException(e);
        }

        return benhvienlists;
    }

    public benhvienphongkham findBvByID(int id) {
        benhvienphongkham bv = null;
        // Step 1: Establishing a Connection
        try (Connection connection = DBConnection.createConnection();
                // Step 2:Create a statement using connection object
                PreparedStatement preparedStatement = connection.prepareStatement(findBvByID);) {
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
                bv = new benhvienphongkham(id, tenbv, diachi, sodienthoai, tomtat, mota, anh, anhdaidien, quanhuyenid, thanhphoid, loaihinhid, trangthai, url, xephang);
            }
        } catch (SQLException e) {
            printSQLException(e);
        }
        return bv;
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
