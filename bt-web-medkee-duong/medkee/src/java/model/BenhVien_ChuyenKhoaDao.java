/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import bean.benhvien_chuyenkhoa;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import util.DBConnection;

/**
 *
 * @author Admin
 */
public class BenhVien_ChuyenKhoaDao {

    private static final String addbv_ck = "INSERT INTO benhvien_chuyenkhoa" + "  (BVPKid, CKid) VALUES "
            + " (?, ?);";
    private static final String deleteBv_Ck = "delete from benhvien_chuyenkhoa where BVPKid = ?;";

    public void insertBV_CK(benhvien_chuyenkhoa bvck) {
        try (Connection con = DBConnection.createConnection();
                PreparedStatement preparedStatement = con.prepareStatement(addbv_ck)) {
            preparedStatement.setInt(1, bvck.getIdBV());
            preparedStatement.setInt(2, bvck.getIdCK());
            System.out.println(preparedStatement);
            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            printSQLException(e);
        }
    }

    public boolean deleteBenhVien_ChuyenKhoa(int id) throws SQLException {
        boolean rowDeleted;
        try (Connection connection = DBConnection.createConnection();
                PreparedStatement statement = connection.prepareStatement(deleteBv_Ck);) {
            statement.setInt(1, id);
            rowDeleted = statement.executeUpdate() > 0;
        }
        System.out.println(deleteBv_Ck);
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
