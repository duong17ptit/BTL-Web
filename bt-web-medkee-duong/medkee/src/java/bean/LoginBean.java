/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bean;
import java.io.Serializable;

/**
 *
 * @author Admin
 */
public class LoginBean implements Serializable
{
     private String username;
     private String password;
 
    public String getUserName() {
        return username;
     }
    public void setUserName(String userName) {
        this.username = userName;
     }
     public String getPassword() {
        return password;
     }
     public void setPassword(String password) {
        this.password = password;
     }
}