/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bean;

/**
 *
 * @author Admin
 */
public class tinhthanhpho {
    protected int id;
    protected String tenTP;
    protected int trangthai;
    
    public tinhthanhpho (){}

    public tinhthanhpho(int id, String tenTP, int trangthai) {
        this.id = id;
        this.tenTP = tenTP;
        this.trangthai = trangthai;
    }

    public tinhthanhpho(String tenTP, int trangthai) {
        this.tenTP = tenTP;
        this.trangthai = trangthai;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTenTP() {
        return tenTP;
    }

    public void setTenTP(String tenTP) {
        this.tenTP = tenTP;
    }

    public int getTrangthai() {
        return trangthai;
    }

    public void setTrangthai(int trangthai) {
        this.trangthai = trangthai;
    }
    
}
