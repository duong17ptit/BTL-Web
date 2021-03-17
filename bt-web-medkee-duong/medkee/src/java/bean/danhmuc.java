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
public class danhmuc implements Serializable {

    protected int id;
    protected String tenDanhMuc;
    protected String anhdanhmuc;
    protected int trangthai;

    public danhmuc() {
    }

    public danhmuc(int id, String tenDanhMuc, String anhdanhmuc, int trangthai) {
        this.id = id;
        this.tenDanhMuc = tenDanhMuc;
        this.anhdanhmuc = anhdanhmuc;
        this.trangthai = trangthai;
    }

    public danhmuc(String tenDanhMuc, String anhdanhmuc, int trangthai) {
        this.tenDanhMuc = tenDanhMuc;
        this.anhdanhmuc = anhdanhmuc;
        this.trangthai = trangthai;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTenDanhMuc() {
        return tenDanhMuc;
    }

    public void setTenDanhMuc(String tenDanhMuc) {
        this.tenDanhMuc = tenDanhMuc;
    }

    public String getAnhdanhmuc() {
        return anhdanhmuc;
    }

    public void setAnhdanhmuc(String anhdanhmuc) {
        this.anhdanhmuc = anhdanhmuc;
    }

    public int getTrangthai() {
        return trangthai;
    }

    public void setTrangthai(int trangthai) {
        this.trangthai = trangthai;
    }
    

}
