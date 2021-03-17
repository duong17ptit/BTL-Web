/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import util.DBConnection;
import bean.quanhuyen;

/**
 *
 * @author Admin
 */
public class quanHuyenDao {

    private static final String addQuanHuyen = "INSERT INTO quanhuyen" + "  (ten,ThanhPhoid, trangthai) VALUES "
            + " (?, ?, ?);";
    private static final String selectQuanHuyenById = "select id,ten,ThanhPhoid,trangthai from quanhuyen where id =?";
    private static final String getListQuanHuyen_with_limit = "select * from quanhuyen ORDER BY id DESC LIMIT ? OFFSET ?";
    private static final String deleteQuanHuyen = "delete from quanhuyen where id = ?;";
    private static final String updateQuanHuyen = "update quanhuyen set ten = ?,ThanhPhoid = ?, trangthai= ? where id = ?;";
    private static final String getAll = "select * from quanhuyen";
    private static final String getQuanHuyenByThanhphoid = "select * from quanhuyen where ThanhPhoid = ? and trangthai = 1";

    public quanHuyenDao() {

    }

    public void insertQuanHuyen(quanhuyen qh) {
        try (Connection con = DBConnection.createConnection();
                PreparedStatement preparedStatement = con.prepareStatement(addQuanHuyen)) {
            preparedStatement.setString(1, qh.getTenQH());
            preparedStatement.setInt(2, qh.getThanhphoid());
            preparedStatement.setInt(3, qh.getTrangthai());
            System.out.println(preparedStatement);
            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            printSQLException(e);
        }
    }

    public quanhuyen selectQuanHuyen(int id) {
        quanhuyen quanhuyen = null;
        // Step 1: Establishing a Connection
        try (Connection connection = DBConnection.createConnection();
                // Step 2:Create a statement using connection object
                PreparedStatement preparedStatement = connection.prepareStatement(selectQuanHuyenById);) {
            preparedStatement.setInt(1, id);
            System.out.println(preparedStatement);
            // Step 3: Execute the query or update query
            ResultSet rs = preparedStatement.executeQuery();

            // Step 4: Process the ResultSet object.
            while (rs.next()) {

                String tenQH = rs.getString("ten");//
                int thanhphoid = rs.getInt("ThanhPhoid");//
                int trangthai = rs.getInt("trangthai");//
                quanhuyen = new quanhuyen(id, tenQH, thanhphoid, trangthai);
            }
        } catch (SQLException e) {
            printSQLException(e);
        }
        return quanhuyen;
    }

    public boolean updateQuanHuyen(quanhuyen qh) throws SQLException {
        boolean rowUpdated;
        try (Connection connection = DBConnection.createConnection();
                PreparedStatement statement = connection.prepareStatement(updateQuanHuyen);) {
            statement.setString(1, qh.getTenQH());
            statement.setInt(2, qh.getThanhphoid());
            statement.setInt(3, qh.getTrangthai());

            statement.setInt(4, qh.getId());
            rowUpdated = statement.executeUpdate() > 0;
        }
        return rowUpdated;
    }

    public int countAllRecords() {
        int totalPaqe = 0;
        try (Connection connection = DBConnection.createConnection()) {
            Statement st = null;
            st = connection.createStatement();
            ResultSet resultTotalRecord = st.executeQuery(getAll);
            resultTotalRecord.last();
            totalPaqe = resultTotalRecord.getRow();
        } catch (SQLException e) {
            printSQLException(e);
        }
        return totalPaqe;
    }

    public List<quanhuyen> getAllQuanHuyen() {
//    

        // using try-with-resources to avoid closing resources (boiler plate code)
        List<quanhuyen> qhlists1 = new ArrayList<>();
        // Step 1: Establishing a Connection
        try (Connection connection = DBConnection.createConnection();
                PreparedStatement statement = connection.prepareStatement(getAll);) {

            ResultSet resultSet = statement.executeQuery();

            while (resultSet.next()) {
                int id = resultSet.getInt("id");
                String tenQH = resultSet.getString("ten");
                int tpid = resultSet.getInt("ThanhPhoid");
                int trangthai = resultSet.getInt("trangthai");
                qhlists1.add(new quanhuyen(id, tenQH, tpid, trangthai));
            }
        } catch (SQLException e) {
            printSQLException(e);
        }
        return qhlists1;
    }

    public List<quanhuyen> getQuanHuyenByThanhPhoid(int idtp) {
//    

        // using try-with-resources to avoid closing resources (boiler plate code)
        List<quanhuyen> listQuanHuyen = new ArrayList<>();
        // Step 1: Establishing a Connection
        try (Connection connection = DBConnection.createConnection();
                PreparedStatement statement = connection.prepareStatement(getQuanHuyenByThanhphoid);) {
            statement.setInt(1, idtp);
            ResultSet resultSet = statement.executeQuery();

            while (resultSet.next()) {
                int id = resultSet.getInt("id");
                String tenQH = resultSet.getString("ten");
                int thanhphoid = resultSet.getInt("ThanhPhoid");
                int trangthai = resultSet.getInt("trangthai");
                listQuanHuyen.add(new quanhuyen(id, tenQH, thanhphoid, trangthai));
            }
        } catch (SQLException e) {
            printSQLException(e);
        }
        return listQuanHuyen;
    }

    public List<quanhuyen> selectAllQuanHuyen(int limit, int offset) {
        Statement st = null;
        // using try-with-resources to avoid closing resources (boiler plate code)
        List<quanhuyen> listQuanHuyen = new ArrayList<>();
        // Step 1: Establishing a Connection
        try (Connection connection = DBConnection.createConnection();
                PreparedStatement statement = connection.prepareStatement(getListQuanHuyen_with_limit);) {
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
                String tenQH = resultSet.getString("ten");
                int thanhphoid = resultSet.getInt("ThanhPhoid");
                int trangthai = resultSet.getInt("trangthai");
                listQuanHuyen.add(new quanhuyen(id, tenQH, thanhphoid, trangthai));
            }
        } catch (SQLException e) {
            printSQLException(e);
        }

        return listQuanHuyen;
    }

    public boolean deleteQuanHuyen(int id) throws SQLException {
        boolean rowDeleted;
        try (Connection connection = DBConnection.createConnection();
                PreparedStatement statement = connection.prepareStatement(deleteQuanHuyen);) {
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
