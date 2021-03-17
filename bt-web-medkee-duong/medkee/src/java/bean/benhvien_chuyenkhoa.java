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
public class benhvien_chuyenkhoa implements Serializable{

    protected int idBV;
    protected int idCK;

    public benhvien_chuyenkhoa(int idBV, int idCK) {
        this.idBV = idBV;
        this.idCK = idCK;
    }

    public benhvien_chuyenkhoa() {
    }

    public int getIdBV() {
        return idBV;
    }

    public void setIdBV(int idBV) {
        this.idBV = idBV;
    }

    public int getIdCK() {
        return idCK;
    }

    public void setIdCK(int idCK) {
        this.idCK = idCK;
    }
    
}
