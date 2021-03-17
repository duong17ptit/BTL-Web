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
public class quanhuyen implements Serializable{
    
    protected int id;
    protected String tenQH;
    protected int thanhphoid;
    protected int trangthai;

    public quanhuyen() {
    }

    public quanhuyen(String tenQH, int thanhphoid, int trangthai) {
        this.tenQH = tenQH;
        this.thanhphoid = thanhphoid;
        this.trangthai = trangthai;
    }

    public quanhuyen(int id, String tenQH, int thanhphoid, int trangthai) {
        this.id = id;
        this.tenQH = tenQH;
        this.thanhphoid = thanhphoid;
        this.trangthai = trangthai;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTenQH() {
        return tenQH;
    }

    public void setTenQH(String tenQH) {
        this.tenQH = tenQH;
    }

    public int getThanhphoid() {
        return thanhphoid;
    }

    public void setThanhphoid(int thanhphoid) {
        this.thanhphoid = thanhphoid;
    }

    public int getTrangthai() {
        return trangthai;
    }

    public void setTrangthai(int trangthai) {
        this.trangthai = trangthai;
    }
    
    
    
}
