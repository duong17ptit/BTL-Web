/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
/**
 *
 * @author Duong
 */
package model;

import bean.loaihinh;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import util.DBConnection;

public class loaiHinhDao {

    private static final String addLoaiHinh = "INSERT INTO loaihinh" + "  (ten, trangthai) VALUES "
            + " (?, ?);";
    private static final String countAllRecord = "select * from loaihinh";
    private static final String selectLoaiHinhById = "select id,ten,trangthai from loaihinh where id =?";
    private static final String getListLoaiHinh = "select * from loaihinh ORDER BY id DESC LIMIT ? OFFSET ?";
    private static final String deleteLoaiHinh = "delete from loaihinh where id = ?;";
    private static final String updateLoaiHinh = "update loaihinh set ten = ?,trangthai= ? where id = ?;";
    private static final String getAll = "select * from loaihinh";

    public loaiHinhDao() {
    }

    public void insertLH(loaihinh lh) {
        try (Connection con = DBConnection.createConnection();
                PreparedStatement preparedStatement = con.prepareStatement(addLoaiHinh)) {
            preparedStatement.setString(1, lh.getTenLH());
            preparedStatement.setInt(2, lh.getTrangthai());
            System.out.println(preparedStatement);
            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            printSQLException(e);
        }
    }

    public loaihinh selectLH(int id) {
        loaihinh loaihinh = null;
        // Step 1: Establishing a Connection
        try (Connection connection = DBConnection.createConnection();
                // Step 2:Create a statement using connection object
                PreparedStatement preparedStatement = connection.prepareStatement(selectLoaiHinhById);) {
            preparedStatement.setInt(1, id);
            System.out.println(preparedStatement);
            // Step 3: Execute the query or update query
            ResultSet rs = preparedStatement.executeQuery();

            // Step 4: Process the ResultSet object.
            while (rs.next()) {

                String tenLH = rs.getString("ten");//can sua
                int trangthai = rs.getInt("trangthai");// can sua
                loaihinh = new loaihinh(id, tenLH, trangthai);
            }
        } catch (SQLException e) {
            printSQLException(e);
        }
        return loaihinh;
    }

    public boolean updateLH(loaihinh loaihinh) throws SQLException {
        boolean rowUpdated;
        try (Connection connection = DBConnection.createConnection();
                PreparedStatement statement = connection.prepareStatement(updateLoaiHinh);) {
            statement.setString(1, loaihinh.getTenLH());
            statement.setInt(2, loaihinh.getTrangthai());
            statement.setInt(3, loaihinh.getId());

            rowUpdated = statement.executeUpdate() > 0;
        }
        System.out.println(updateLoaiHinh);
        return rowUpdated;
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

        public List<loaihinh> getAllLoaiHinh() {
//    
      
        // using try-with-resources to avoid closing resources (boiler plate code)
        List<loaihinh> loaihinhlists1 = new ArrayList<>();
        // Step 1: Establishing a Connection
          try (Connection connection = DBConnection.createConnection();
                PreparedStatement statement = connection.prepareStatement(getAll);){

            ResultSet resultSet = statement.executeQuery();       

            while (resultSet.next()) {
                int id = resultSet.getInt("id");
                String tenLH = resultSet.getString("ten");
                int trangthai = resultSet.getInt("trangthai");
                loaihinhlists1.add(new loaihinh(id, tenLH, trangthai));
            }
        } catch (SQLException e) {
            printSQLException(e);
        }
        return loaihinhlists1;
    }
    public List<loaihinh> selectAllLoaiHinh(int limit, int offset) {
        Statement st = null;
        // using try-with-resources to avoid closing resources (boiler plate code)
        List<loaihinh> loaihinhlists = new ArrayList<>();
        // Step 1: Establishing a Connection
        try (Connection connection = DBConnection.createConnection();
                PreparedStatement statement = connection.prepareStatement(getListLoaiHinh);) {
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
                String tenLH = resultSet.getString("ten");
                int trangthai = resultSet.getInt("trangthai");
                loaihinhlists.add(new loaihinh(id, tenLH, trangthai));
            }
        } catch (SQLException e) {
            printSQLException(e);
        }

        return loaihinhlists;
    }

    public boolean deleteLoaiHinh(int id) throws SQLException {
        boolean rowDeleted;
        try (Connection connection = DBConnection.createConnection();
                PreparedStatement statement = connection.prepareStatement(deleteLoaiHinh);) {
            statement.setInt(1, id);
            rowDeleted = statement.executeUpdate() > 0;
        }
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
