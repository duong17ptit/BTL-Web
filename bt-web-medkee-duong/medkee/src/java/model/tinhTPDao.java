/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;


import bean.tinhthanhpho;
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
public class tinhTPDao {
     private static final String addThanhPho = "INSERT INTO thanhpho" + "  (ten, trangthai) VALUES "
            + " (?, ?);";
    private static final String countAllRecord = "select * from thanhpho";
    private static final String getAll = "select * from thanhpho";
    private static final String selectThanhPhoById = "select id,ten,trangthai from thanhpho where id =?";
    private static final String getListThanhPho = "select * from thanhpho ORDER BY id DESC LIMIT ? OFFSET ? ";
    private static final String deleteThanhPho = "delete from thanhpho where id = ?;";
    private static final String updateThanhPho = "update thanhpho set ten = ?,trangthai= ? where id = ?;";

    public tinhTPDao() {
    }

    public void insertTP(tinhthanhpho tp) {
        try (Connection con = DBConnection.createConnection();
                PreparedStatement preparedStatement = con.prepareStatement(addThanhPho)) {
            preparedStatement.setString(1, tp.getTenTP());
            preparedStatement.setInt(2, tp.getTrangthai());
            System.out.println(preparedStatement);
            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            printSQLException(e);
        }
    }

    public tinhthanhpho selectTP(int id) {
        tinhthanhpho tinhthanhpho = null;
        // Step 1: Establishing a Connection
        try (Connection connection = DBConnection.createConnection();
                // Step 2:Create a statement using connection object
                PreparedStatement preparedStatement = connection.prepareStatement(selectThanhPhoById);) {
            preparedStatement.setInt(1, id);
            System.out.println(preparedStatement);
            // Step 3: Execute the query or update query
            ResultSet rs = preparedStatement.executeQuery();

            // Step 4: Process the ResultSet object.
            while (rs.next()) {

                String tenTP = rs.getString("ten");//can sua
                int trangthai = rs.getInt("trangthai");// can sua
                tinhthanhpho = new tinhthanhpho(id, tenTP, trangthai);
            }
        } catch (SQLException e) {
            printSQLException(e);
        }
        return tinhthanhpho;
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
    public boolean updateTP(tinhthanhpho tinhthanhpho) throws SQLException {
        boolean rowUpdated;
        try (Connection connection = DBConnection.createConnection();
                PreparedStatement statement = connection.prepareStatement(updateThanhPho);) {
            statement.setString(1, tinhthanhpho.getTenTP());
            statement.setInt(2, tinhthanhpho.getTrangthai());
            statement.setInt(3, tinhthanhpho.getId());

            rowUpdated = statement.executeUpdate() > 0;
        }
        System.out.println(updateThanhPho);
        return rowUpdated;
    }
    public List<tinhthanhpho> getAllThanhPho() {
//    
      
        // using try-with-resources to avoid closing resources (boiler plate code)
        List<tinhthanhpho> thanhpholists1 = new ArrayList<>();
        // Step 1: Establishing a Connection
          try (Connection connection = DBConnection.createConnection();
                PreparedStatement statement = connection.prepareStatement(getAll);){
            // Step 2:Create a statement using connection object
//            PreparedStatement preparedStatement = connection.prepareStatement(SELECT_ALL_USERS); 

            ResultSet resultSet = statement.executeQuery();       
            // Step 3: Execute the query or update query
            //            ResultSet rs = preparedStatement.executeQuery();
            // Step 4: Process the ResultSet object.
            while (resultSet.next()) {
                int id = resultSet.getInt("id");
                String tenTP = resultSet.getString("ten");
                int trangthai = resultSet.getInt("trangthai");
                thanhpholists1.add(new tinhthanhpho(id, tenTP, trangthai));
            }
        } catch (SQLException e) {
            printSQLException(e);
        }
        return thanhpholists1;
    }
    public List<tinhthanhpho> selectAllThanhPho(int limit,int offset) {
//    
      
        // using try-with-resources to avoid closing resources (boiler plate code)
        List<tinhthanhpho> thanhpholists = new ArrayList<>();
        // Step 1: Establishing a Connection
          try (Connection connection = DBConnection.createConnection();
                PreparedStatement statement = connection.prepareStatement(getListThanhPho);){
            statement.setInt(1, limit);
            statement.setInt(2, offset);
            // Step 2:Create a statement using connection object
//            PreparedStatement preparedStatement = connection.prepareStatement(SELECT_ALL_USERS); 

            ResultSet resultSet = statement.executeQuery();       
            // Step 3: Execute the query or update query
            //            ResultSet rs = preparedStatement.executeQuery();
            // Step 4: Process the ResultSet object.
            while (resultSet.next()) {
                int id = resultSet.getInt("id");
                String tenTP = resultSet.getString("ten");
                int trangthai = resultSet.getInt("trangthai");
                thanhpholists.add(new tinhthanhpho(id, tenTP, trangthai));
            }
        } catch (SQLException e) {
            printSQLException(e);
        }
        return thanhpholists;
    }

    public boolean deleteThanhPho(int id) throws SQLException {
        boolean rowDeleted;
        try (Connection connection = DBConnection.createConnection();
                PreparedStatement statement = connection.prepareStatement(deleteThanhPho);) {
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
