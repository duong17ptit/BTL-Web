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
public class loaihinh implements Serializable {

    protected int id;
    protected String tenLH;
    protected int trangthai;
    public loaihinh(){
    }
    public loaihinh(int id, String tenLH, int trangthai) {
        this.id = id;
        this.tenLH = tenLH;
        this.trangthai = trangthai;
    }

    public loaihinh(String tenLH, int trangthai) {
        this.tenLH = tenLH;
        this.trangthai = trangthai;
    }

    public int getId() {
        return id;
    }

    public String getTenLH() {
        return tenLH;
    }

    public int getTrangthai() {
        return trangthai;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setTenLH(String tenLH) {
        this.tenLH = tenLH;
    }

    public void setTrangthai(int trangthai) {
        this.trangthai = trangthai;
    }
    
}
