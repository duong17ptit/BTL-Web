/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import bean.LoginBean;
import util.DBConnection;
 
public class LoginDao {
     public String authenticateUser(LoginBean loginBean)
     {
         String userName = loginBean.getUserName(); 
         String password = loginBean.getPassword();
 
         Connection con = null;
         Statement statement = null;
         ResultSet resultSet = null;
 
         String userNameDB = "";
         String passwordDB = "";
 
         try
         {
             con = DBConnection.createConnection(); //ket noi database
             statement = con.createStatement(); //Statement is used to write queries. Read more about it.
             resultSet = statement.executeQuery("select username,password from user"); //the table name is users and userName,password are columns. Fetching all the records and storing in a resultSet.
 
             while(resultSet.next()) //
             {
              userNameDB = resultSet.getString("username"); //lay ket qua tra ve tu db
              passwordDB = resultSet.getString("password");
 
               if(userName.equals(userNameDB) && password.equals(passwordDB))
               {
                  return "SUCCESS"; 
               }
             }
         }
             catch(SQLException e)
             {
                e.printStackTrace();
             }
             return "Tài khoản không hợp lệ"; 
         }
     }
