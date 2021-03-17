/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import bean.danhmuc;
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
public class danhmucDao {
        private static final String addDanhMuc = "INSERT INTO danhmuc" + "  ( ten, anh,trangthai) VALUES "
            + " (?, ?, ?);";
    private static final String countAllRecord = "select * from danhmuc";
    private static final String selectDanhMucById = "select id,ten, anh,trangthai from danhmuc where id =?";
    private static final String getAllDanhMuc = "select * from danhmuc  LIMIT ? OFFSET ?";
    private static final String deleteDanhMuc = "delete from danhmuc where id = ?;";
//        private static final String UPDATE_USERS_SQL = "update benhvienphongkham set name = ?,email= ?, country =? where id = ?;";

    private static final String updateDanhMuc = "update danhmuc set ten= ?, anh= ?,trangthai= ? where id= ?;";

    public danhmucDao() {
    }
        public void insertDanhMuc(danhmuc danhmuc) throws SQLException {
        System.out.println(addDanhMuc);
        // try-with-resource statement will auto close the connection.
        try (Connection con = DBConnection.createConnection();
                PreparedStatement preparedStatement = con.prepareStatement(addDanhMuc)) {
            preparedStatement.setString(1, danhmuc.getTenDanhMuc());
            preparedStatement.setString(2, danhmuc.getAnhdanhmuc());
            preparedStatement.setInt(3, danhmuc.getTrangthai());

            System.out.println(preparedStatement);
            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            printSQLException(e);
        }
    }

    public danhmuc selectDanhMuc(int id) {
        danhmuc danhmuc = null;
        // Step 1: Establishing a Connection
        try (Connection connection = DBConnection.createConnection();
                // Step 2:Create a statement using connection object
                PreparedStatement preparedStatement = connection.prepareStatement(selectDanhMucById);) {
            preparedStatement.setInt(1, id);
            System.out.println(preparedStatement);
            // Step 3: Execute the query or update query
            ResultSet rs = preparedStatement.executeQuery();

            // Step 4: Process the ResultSet object.
            while (rs.next()) {
                
                String tendanhmuc = rs.getString("ten");
                String anh = rs.getString("anh");
                int trangthai = rs.getInt("trangthai");
                danhmuc = new danhmuc(id,tendanhmuc, anh, trangthai);
            }
        } catch (SQLException e) {
            printSQLException(e);
        }
        return danhmuc;
    }

    public boolean updateDanhMuc(danhmuc danhmuc) throws SQLException {
        boolean rowUpdated;
        try (Connection connection = DBConnection.createConnection();
                PreparedStatement statement = connection.prepareStatement(updateDanhMuc);) {
            statement.setString(1, danhmuc.getTenDanhMuc());
            statement.setString(2, danhmuc.getAnhdanhmuc());
            statement.setInt(3, danhmuc.getTrangthai());
             statement.setInt(4, danhmuc.getId());

            
            rowUpdated = statement.executeUpdate() > 0;
        }
        System.out.println(updateDanhMuc);
        return rowUpdated;
    }
    public int countAllRecords(){
        int  totalPaqe =0;
      try (Connection connection = DBConnection.createConnection()){
          Statement st = null;
           st = connection.createStatement();
           ResultSet resultTotalRecord = st.executeQuery(countAllRecord);
           resultTotalRecord.last();
             totalPaqe= resultTotalRecord.getRow();
      } 
      catch (SQLException e) {
            printSQLException(e);
        }
      return totalPaqe;
    }
    public List<danhmuc> selectAllDanhMuc(int limit,int offset) {
        Statement st = null;
        // using try-with-resources to avoid closing resources (boiler plate code)
        List<danhmuc> danhmuclists = new ArrayList<>();
        // Step 1: Establishing a Connection
        try (Connection connection = DBConnection.createConnection();
                PreparedStatement statement = connection.prepareStatement(getAllDanhMuc);){
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
                String tenDanhMuc = resultSet.getString("ten");
                String anh = resultSet.getString("anh");
                int trangthai = resultSet.getInt("trangthai");
                danhmuclists.add(new danhmuc(id, tenDanhMuc, anh,trangthai));
            }
        } catch (SQLException e) {
            printSQLException(e);
        }
       
        return danhmuclists;
    }

    public boolean deleteDanhMuc(int id) throws SQLException {
        boolean rowDeleted;
        try (Connection connection = DBConnection.createConnection();
                PreparedStatement statement = connection.prepareStatement(deleteDanhMuc);) {
            statement.setInt(1, id);
            rowDeleted = statement.executeUpdate() > 0;
        }
        System.out.println(deleteDanhMuc);
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
