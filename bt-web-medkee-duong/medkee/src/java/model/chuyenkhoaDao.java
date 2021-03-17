/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import bean.chuyenkhoa;
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
public class chuyenkhoaDao {
    
    private static final String addChuyenKhoa = "INSERT INTO chuyenkhoa" + "  (ten, trangthai) VALUES "
            + " (?, ?);";
//    private static final String countAllRecord = "select * from loaihinh";
    private static final String selectChuyenKhoaById = "select id,ten,trangthai from chuyenkhoa where id =?";
    private static final String getListChuyenKhoa = "select * from chuyenkhoa ORDER BY id DESC LIMIT ? OFFSET ?";
    private static final String deleteChuyenKhoa = "delete from chuyenkhoa where id = ?;";
    private static final String updateChuyenKhoa = "update chuyenkhoa set ten = ?,trangthai= ? where id = ?;";
    private static final String getAll = "select * from chuyenkhoa";

    public chuyenkhoaDao() {
    }

    public void insertCK(chuyenkhoa ck) {
        try (Connection con = DBConnection.createConnection();
                PreparedStatement preparedStatement = con.prepareStatement(addChuyenKhoa)) {
            preparedStatement.setString(1, ck.getTenCK());
            preparedStatement.setInt(2, ck.getTrangthai());
            System.out.println(preparedStatement);
            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            printSQLException(e);
        }
    }

    public chuyenkhoa selectCK(int id) {
        chuyenkhoa chuyenkhoa = null;
        // Step 1: Establishing a Connection
        try (Connection connection = DBConnection.createConnection();
            
                PreparedStatement preparedStatement = connection.prepareStatement(selectChuyenKhoaById);) {
            preparedStatement.setInt(1, id);
            System.out.println(preparedStatement);
          
            ResultSet rs = preparedStatement.executeQuery();

     
            while (rs.next()) {

                String tenCK = rs.getString("ten");//can sua
                int trangthai = rs.getInt("trangthai");// can sua
                chuyenkhoa = new chuyenkhoa(id, tenCK, trangthai);
            }
        } catch (SQLException e) {
            printSQLException(e);
        }
        return chuyenkhoa;
    }

    public boolean updateCK(chuyenkhoa chuyenkhoa) throws SQLException {
        boolean rowUpdated;
        try (Connection connection = DBConnection.createConnection();
                PreparedStatement statement = connection.prepareStatement(updateChuyenKhoa);) {
            statement.setString(1, chuyenkhoa.getTenCK());
            statement.setInt(2, chuyenkhoa.getTrangthai());
            statement.setInt(3, chuyenkhoa.getId());

            rowUpdated = statement.executeUpdate() > 0;
        }
        System.out.println(updateChuyenKhoa);
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

        public List<chuyenkhoa> getAllChuyenKhoa() {


        List<chuyenkhoa> cklists1 = new ArrayList<>();

          try (Connection connection = DBConnection.createConnection();
                PreparedStatement statement = connection.prepareStatement(getAll);){

            ResultSet resultSet = statement.executeQuery();       

            while (resultSet.next()) {
                int id = resultSet.getInt("id");
                String tenCK = resultSet.getString("ten");
                int trangthai = resultSet.getInt("trangthai");
                cklists1.add(new chuyenkhoa(id, tenCK, trangthai));
            }
        } catch (SQLException e) {
            printSQLException(e);
        }
        return cklists1;
    }
    public List<chuyenkhoa> selectAllChuyenKhoa(int limit, int offset) {
        Statement st = null;
        // using try-with-resources to avoid closing resources (boiler plate code)
        List<chuyenkhoa> chuyenkhoalists = new ArrayList<>();
     
        try (Connection connection = DBConnection.createConnection();
                PreparedStatement statement = connection.prepareStatement(getListChuyenKhoa);) {
            statement.setInt(1, limit);
            statement.setInt(2, offset);

            ResultSet resultSet = statement.executeQuery();
            while (resultSet.next()) {
                int id = resultSet.getInt("id");
                String tenLH = resultSet.getString("ten");
                int trangthai = resultSet.getInt("trangthai");
                 chuyenkhoalists.add(new chuyenkhoa(id, tenLH, trangthai));
            }
        } catch (SQLException e) {
            printSQLException(e);
        }

        return  chuyenkhoalists;
    }

    public boolean deleteChuyenKhoa(int id) throws SQLException {
        boolean rowDeleted;
        try (Connection connection = DBConnection.createConnection();
                PreparedStatement statement = connection.prepareStatement(deleteChuyenKhoa);) {
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
