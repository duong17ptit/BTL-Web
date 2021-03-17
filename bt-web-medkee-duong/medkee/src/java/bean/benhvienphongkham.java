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
public class benhvienphongkham implements Serializable 
{
    protected int id;
    protected String tenBV;
    protected String diachi;
    protected String sodienthoai;
    protected String tomtat;
    protected String mota;
    protected String anhbvchitiet;
    protected String anhdaidien;
    protected int quanhuyenid;
    protected int thanhphoid;
    protected int loaihinhid;
    protected int trangthai;
    protected String urlbv;
    protected int rank;
    public benhvienphongkham(){};
    public benhvienphongkham(int id, String tenBV, String diachi, String sodienthoai, String tomtat, String mota, String anhbvchitiet, String anhdaidien, int quanhuyenid, int thanhphoid, int loaihinhid, int trangthai, String urlbv, int rank) {
        this.id = id;
        this.tenBV = tenBV;
        this.diachi = diachi;
        this.sodienthoai = sodienthoai;
        this.tomtat = tomtat;
        this.mota = mota;
        this.anhbvchitiet = anhbvchitiet;
        this.anhdaidien = anhdaidien;
        this.quanhuyenid = quanhuyenid;
        this.thanhphoid = thanhphoid;
        this.loaihinhid = loaihinhid;
        this.trangthai = trangthai;
        this.urlbv = urlbv;
        this.rank = rank;
    }

    public benhvienphongkham(String tenBV, String diachi, String sodienthoai, String tomtat, String mota, String anhbvchitiet, String anhdaidien, int quanhuyenid, int thanhphoid, int loaihinhid, int trangthai, String urlbv, int rank) {
        this.tenBV = tenBV;
        this.diachi = diachi;
        this.sodienthoai = sodienthoai;
        this.tomtat = tomtat;
        this.mota = mota;
        this.anhbvchitiet = anhbvchitiet;
        this.anhdaidien = anhdaidien;
        this.quanhuyenid = quanhuyenid;
        this.thanhphoid = thanhphoid;
        this.loaihinhid = loaihinhid;
        this.trangthai = trangthai;
        this.urlbv = urlbv;
        this.rank = rank;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTenBV() {
        return tenBV;
    }

    public void setTenBV(String tenBV) {
        this.tenBV = tenBV;
    }

    public String getDiachi() {
        return diachi;
    }

    public void setDiachi(String diachi) {
        this.diachi = diachi;
    }

    public String getSodienthoai() {
        return sodienthoai;
    }

    public void setSodienthoai(String sodienthoai) {
        this.sodienthoai = sodienthoai;
    }

    public String getTomtat() {
        return tomtat;
    }

    public void setTomtat(String tomtat) {
        this.tomtat = tomtat;
    }

    public String getMota() {
        return mota;
    }

    public void setMota(String mota) {
        this.mota = mota;
    }

    public String getAnhbvchitiet() {
        return anhbvchitiet;
    }

    public void setAnhbvchitiet(String anhbvchitiet) {
        this.anhbvchitiet = anhbvchitiet;
    }

    public String getAnhdaidien() {
        return anhdaidien;
    }

    public void setAnhdaidien(String anhdaidien) {
        this.anhdaidien = anhdaidien;
    }

    public int getQuanhuyenid() {
        return quanhuyenid;
    }

    public void setQuanhuyenid(int quanhuyenid) {
        this.quanhuyenid = quanhuyenid;
    }

    public int getThanhphoid() {
        return thanhphoid;
    }

    public void setThanhphoid(int thanhphoid) {
        this.thanhphoid = thanhphoid;
    }

    public int getLoaihinhid() {
        return loaihinhid;
    }

    public void setLoaihinhid(int loaihinhid) {
        this.loaihinhid = loaihinhid;
    }

    public int getTrangthai() {
        return trangthai;
    }

    public void setTrangthai(int trangthai) {
        this.trangthai = trangthai;
    }

    public String getUrlbv() {
        return urlbv;
    }

    public void setUrlbv(String urlbv) {
        this.urlbv = urlbv;
    }

    public int getRank() {
        return rank;
    }

    public void setRank(int rank) {
        this.rank = rank;
    }
    
    
}
