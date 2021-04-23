/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controller;

import Database.ConnectionManager;
import Model.Kantor;
import Model.Kuota;
import Model.Pemohon;
import Model.Person;
import Model.UserAccount;
import View.Admin;
import View.Beranda;
import View.Login;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.Date;
import javax.swing.JOptionPane;

/**
 *
 * @author Reynold
 */
public class Controller {
    
    private static final String alphabet = "ABCDEFGHJIKLMNOPQRSTUVWXYZ";
    private static final String number = "0123456789";
    private static String result;
    
    public static String randomAlphabet(int count){
        StringBuilder builder = new StringBuilder();
        while(count-- != 0){
            int character = (int)(Math.random()*alphabet.length());
            builder.append(alphabet.charAt(character));
        }
        return builder.toString();
    }
    
    public static String randomNumeric(int count){
        StringBuilder builder = new StringBuilder();
        while(count-- != 0){
            int character = (int)(Math.random()*number.length());
            builder.append(number.charAt(character));
        }
        return builder.toString();
    }
    
    public static String Generate(int n){
        result = randomAlphabet(n-7);   //2 digit
        result += "-";
        result += randomNumeric(n-8);   //1 digit
        result += randomAlphabet(n-7);  //2 digit
        result += randomNumeric(n-8);   //1 digit
        result += randomAlphabet(n-7);  //2 digit
        return result;
    }
    
    public static void registrasi(Person p){
        try{
                        UserAccount nw = (UserAccount)p;
                        Statement st = ConnectionManager.getConnection().createStatement();
                        
                        st.executeUpdate("insert into datacostumer values ("
                            +"'"+nw.getNamaLengkap()+"',"
                            +"'"+nw.getUsername()+"',"
                            +"'"+"non"+"',"
                            +"'"+nw.getJenisKelamin()+"',"
                            +"'"+nw.getPassword()+"',"
                            +"'"+nw.getNoTelp()+"',"
                            +"'"+nw.getTglLahir()+"',"
                            +"'"+nw.getAlamat()+"',"
                            +"'"+nw.getNIK()
                            +"')"
                        );
                    }catch(SQLException a){
                        a.printStackTrace();
                    }
    }
    public static void logIn(String username,String password){
        Person p=null;
                UserAccount ua =(UserAccount)p;
                String query = "select * from datacostumer where Username = ? AND password = ?";
                try{
                    PreparedStatement st = ConnectionManager.getConnection().prepareStatement(query);
                    st.setString(1, username);
                    st.setString(2, password);
                    ResultSet rs = st.executeQuery();
                    if(rs.next()) {
                        String admin = rs.getString("admin");
                        if(username.equals(rs.getString("Username")) && password.equals(rs.getString("password")) && admin.equals("non")){
                            System.out.println(rs.getString("NamaLengkap")+" - "+rs.getString("NIK"));
                            JOptionPane.showMessageDialog(null, "Kamu berhasil Log In!");
                            Beranda br = new Beranda(rs.getString("NamaLengkap"),rs.getString("NIK"));
                            br.setVisible(true);
                        }else if(username.equals(rs.getString("Username")) && password.equals(rs.getString("password")) && admin.equals("yes")){
                            System.out.println("Selamat datang di admin !!");
                            JOptionPane.showMessageDialog(null, "Selamat datang Admin!");
                            Admin adm = new Admin();
                            adm.setVisible(true);
                        }
                    }else{
                            JOptionPane.showMessageDialog(null, "Gagal log In!");
                            Login log = new Login();
                            log.setVisible(true);
                    }
                    
                } catch (SQLException ex) {
                    ex.printStackTrace();
                }
    }
    
    public static Person searchDataUA(String NIK){
        Person p = null;
        String query = "select * from datacostumer where NIK = ?";
        
        try{
            PreparedStatement st = ConnectionManager.getConnection().prepareStatement(query);
            st.setString(1, NIK);
            ResultSet rs = st.executeQuery();
            while (rs.next()) {
                String namaLengkap = rs.getString("NamaLengkap");
                String Username = rs.getString("Username");
                String password = rs.getString("password");
                String gender = rs.getString("gender");
                String date = rs.getString("date");
                String noTelp = rs.getString("noTelp");
                String alamat = rs.getString("Alamat");
                String nik = rs.getString("NIK");
                
                p = new UserAccount(date,Username,password,gender,alamat,nik,namaLengkap,noTelp);
              
            }
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        
        
        return p;
    }
    public static Person searchDataPMH(String NIK){
        Person p = null;
        String query = "select * from formpermohonan where NIK = ? OR NIK = ?";
        
        try{
            PreparedStatement st = ConnectionManager.getConnection().prepareStatement(query);
            st.setString(1, NIK);
            st.setString(2, null);
            ResultSet rs = st.executeQuery();
                while (rs.next()) {
                    String namaKantor = rs.getString("NamaKantor");
                    String Alamat = rs.getString("Alamat");
                    String tanggalKedatangan = rs.getString("tglKedatangan");
                    String waktuKedatangan = rs.getString("waktuKedatangan");
                    String kode = rs.getString("kodeBooking");
                    String nik = rs.getString("NIK");
                    String NamaLengkap = rs.getString("NamaLengkap");
                    String NomorLengkap = rs.getString("noTelp");

                    Kantor k = new Kantor(namaKantor,Alamat);
                    p = new Pemohon(k,tanggalKedatangan,waktuKedatangan,kode,nik,NamaLengkap,NomorLengkap);
                }
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        
        
        return p;
    }
    
    public static int countKuota(String bulan){
        int total = 0;
        String query ="Select Count(month) from kuota where month = ?";
        
        try{
            PreparedStatement st = ConnectionManager.getConnection().prepareStatement(query);
            st.setString(1, bulan);
            ResultSet rs = st.executeQuery();
                while (rs.next()) {
                    total = rs.getInt("count(month)");
                }
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        
        return total;
    }
    
    public static int getKuota(String bulan){
        int kuota = 0;
        String query = "select * from kuotaperbulan where bulan = ?";
        
        try{
            PreparedStatement st = ConnectionManager.getConnection().prepareStatement(query);
            st.setString(1, bulan);
            ResultSet rs = st.executeQuery();
                while (rs.next()) {
                    kuota = rs.getInt("kuota");
                }
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        return kuota;
    }
    
    public static void updatePassword(String nik,String passLama,String passBaru){
        String query = "update datacostumer set password = ? where NIK = ? AND password = ?";
        
        try{
            PreparedStatement st = ConnectionManager.getConnection().prepareStatement(query);
            st.setString(1, passBaru);
            st.setString(2, nik);
            st.setString(3, passLama);
            st.execute();
            JOptionPane.showMessageDialog(null, "Password Telah diganti");
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        
    }
    
    public static void UpdateData(UserAccount uu){
        String query = "update datacostumer set NamaLengkap = ?,Username = ?,noTelp = ?,Alamat = ? where NIK = ?";
        
        try{
            PreparedStatement st = ConnectionManager.getConnection().prepareStatement(query);
            st.setString(1, uu.getNamaLengkap());
            st.setString(2, uu.getUsername());
            st.setString(3, uu.getNoTelp());
            st.setString(4, uu.getAlamat());
            st.setString(5, uu.getNIK());
            st.execute();
            JOptionPane.showMessageDialog(null, "Data telah Diupdate!");
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        
    }
    
    public static void insertAntrian(Person p){
        try{
            Pemohon nw = (Pemohon)p;
            Statement st = ConnectionManager.getConnection().createStatement();
                        
            st.executeUpdate("insert into formpermohonan values ("
                +"'"+nw.getTempat().getNama()+"',"
                +"'"+nw.getTempat().getAlamat()+"',"
                +"'"+nw.getTglKedatangan()+"',"
                +"'"+nw.getWaktuKedatangan()+"',"
                +"'"+nw.getKodeBooking()+"',"
                +"'"+nw.getNIK()+"',"
                +"'"+nw.getNamaLengkap()+"',"
                +"'"+nw.getNoTelp()+"',"
                +0
                +")"
               );
            
            }catch(SQLException a){
                a.printStackTrace();
            }
    }
    
    public static void updateKuota(int kuota,String bulan){
        String query = "update kuotaperbulan set kuota = ? where bulan = ?";
        
        try{
            PreparedStatement st = ConnectionManager.getConnection().prepareStatement(query);
            st.setInt(1, kuota);
            st.setString(2, bulan);
            st.execute();
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
    }
    
    public static int checkStatus(String kode){
        int check = 0;
        String query = "Select * from formpermohonan where kodeBooking = ?";
        
        try{
            PreparedStatement st = ConnectionManager.getConnection().prepareStatement(query);
            st.setString(1, kode);
            ResultSet rs = st.executeQuery();
                while (rs.next()) {
                    check = rs.getInt("status");
                }
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        
        return check;
    }
    
    public static void addKuota(String date,String nik,String bulan){
        try{
            Statement st = ConnectionManager.getConnection().createStatement();
            st.executeUpdate("insert into kuota values ("
            +null+","
            +"'"+date+"',"
            +"'"+bulan+"',"
            +"'"+nik+"')"
            );
            
        }catch(SQLException a){
            a.printStackTrace();
        }
        
    }
    
    public static String getDate(){
        String date="";
        Timestamp timeStamp = new Timestamp(new Date().getTime());
        date = String.valueOf(timeStamp);
        
        return date.substring(0,10);
    }
    
    public static ArrayList<UserAccount> showDataUser(){
        ArrayList<UserAccount> listData = new ArrayList<>();
        UserAccount ua;
        
        String query = "select * from datacostumer where admin = 'non'";
        try{
            PreparedStatement st = ConnectionManager.getConnection().prepareStatement(query);
            ResultSet rs = st.executeQuery();
                while (rs.next()) {
                    String namaLengkap = rs.getString("NamaLengkap");
                    String Username = rs.getString("Username");
                    String password = rs.getString("password");
                    String gender = rs.getString("gender");
                    String date = rs.getString("date");
                    String noTelp = rs.getString("noTelp");
                    String alamat = rs.getString("Alamat");
                    String nik = rs.getString("NIK");
                    ua = new UserAccount(date,Username,password,gender,alamat,nik,namaLengkap,noTelp);
                    listData.add(ua);
                }
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        return listData;
    }
    
    public static ArrayList<Kuota> dataKuota(){
        ArrayList<Kuota> listData = new ArrayList<>();
        Kuota k;
        
        String query = "select * from kuotaperbulan";
        try{
            PreparedStatement st = ConnectionManager.getConnection().prepareStatement(query);
            ResultSet rs = st.executeQuery();
                while (rs.next()) {
                    String bulan = rs.getString("bulan");
                    int kuota = rs.getInt("kuota");
                    k = new Kuota(bulan,kuota);
                    listData.add(k);
                }
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        return listData;
    }
    
    public static ArrayList<Pemohon> dataPemohon(){
        ArrayList<Pemohon> listData = new ArrayList<>();
        Pemohon pmh;
        
        String query = "select * from formpermohonan";
        try{
            PreparedStatement st = ConnectionManager.getConnection().prepareStatement(query);
            ResultSet rs = st.executeQuery();
                while (rs.next()) {
                    String namaKantor = rs.getString("NamaKantor");
                    String Alamat = rs.getString("Alamat");
                    String tanggalKedatangan = rs.getString("tglKedatangan");
                    String waktuKedatangan = rs.getString("waktuKedatangan");
                    String kode = rs.getString("kodeBooking");
                    String nik = rs.getString("NIK");
                    String NamaLengkap = rs.getString("NamaLengkap");
                    String NomorLengkap = rs.getString("noTelp");
                    
                    Kantor k = new Kantor(namaKantor,Alamat);
                    pmh = new Pemohon(k,tanggalKedatangan,waktuKedatangan,kode,nik,NamaLengkap,NomorLengkap);
                    listData.add(pmh);
                }
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        return listData;
    }
    
    public static void updateStatus(String kode){
        String query = "Update formpermohonan set status = ? where kodeBooking = ?";
        
        try{
            PreparedStatement st = ConnectionManager.getConnection().prepareStatement(query);
            st.setInt(1, 1);
            st.setString(2, kode);
            st.execute();
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
    }
}

