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
public class chuyenkhoa implements Serializable {

    protected int id;
    protected String tenCK;
    protected int trangthai;
    public chuyenkhoa(){
    }
    public chuyenkhoa(int id, String  tenCK, int trangthai) {
        this.id = id;
        this.tenCK =  tenCK;
        this.trangthai = trangthai;
    }

    public chuyenkhoa(String tenCK, int trangthai) {
        this.tenCK =  tenCK;
        this.trangthai = trangthai;
    }

    public int getId() {
        return id;
    }

    public String getTenCK() {
        return tenCK;
    }

    public int getTrangthai() {
        return trangthai;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setTenCK(String tenLH) {
        this.tenCK = tenLH;
    }

    public void setTrangthai(int trangthai) {
        this.trangthai = trangthai;
    }
    
}
