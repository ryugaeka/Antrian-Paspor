/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Model;

import java.util.Date;

/**
 *
 * @author Reynold
 */
public class Pemohon extends Person{
    private Kantor tempat;
    private String tglKedatangan;
    private String waktuKedatangan;
    private String kodeBooking;

    public Pemohon(Kantor tempat, String tglKedatangan, String waktuKedatangan, String kodeBooking, String NIK, String namaLengkap, String noTelp) {
        super(NIK, namaLengkap, noTelp);
        this.tempat = tempat;
        this.tglKedatangan = tglKedatangan;
        this.waktuKedatangan = waktuKedatangan;
        this.kodeBooking = kodeBooking;
    }

    public Pemohon() {
        
    }

    public Kantor getTempat() {
        return tempat;
    }

    public void setTempat(Kantor tempat) {
        this.tempat = tempat;
    }

    public String getTglKedatangan() {
        return tglKedatangan;
    }

    public void setTglKedatangan(String tglKedatangan) {
        this.tglKedatangan = tglKedatangan;
    }

    public String getWaktuKedatangan() {
        return waktuKedatangan;
    }

    public void setWaktuKedatangan(String waktuKedatangan) {
        this.waktuKedatangan = waktuKedatangan;
    }

    public String getKodeBooking() {
        return kodeBooking;
    }

    public void setKodeBooking(String kodeBooking) {
        this.kodeBooking = kodeBooking;
    }

    public String getNIK() {
        return NIK;
    }

    public void setNIK(String NIK) {
        this.NIK = NIK;
    }

    public String getNamaLengkap() {
        return namaLengkap;
    }

    public void setNamaLengkap(String namaLengkap) {
        this.namaLengkap = namaLengkap;
    }

    public String getNoTelp() {
        return noTelp;
    }

    public void setNoTelp(String noTelp) {
        this.noTelp = noTelp;
    }
    
    @Override
    void Daftar() {
        
    }
}
