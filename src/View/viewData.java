/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package View;

import Model.Person;
import Model.UserAccount;
import javax.swing.JFrame;
import javax.swing.JLabel;

/**
 *
 * @author msj
 */
public class viewData extends JFrame{
    private JLabel nama,username,noTelp,alamat,nik,tglLahir;
    
    public viewData(Person p){
        setSize(350,350);
        setLayout(null);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setResizable(false);
        setVisible(true);
        
        UserAccount ua = (UserAccount)p;
        nama = new JLabel("Nama: "+ua.getNamaLengkap());
        nama.setBounds(30,50,150,20);
        add(nama);
        
        username = new JLabel("Username: "+ua.getUsername());
        username.setBounds(30, 100, 150, 20);
        add(username);
        
        noTelp = new JLabel("No.Telp: "+ua.getNoTelp());
        noTelp.setBounds(30, 150, 150, 20);
        add(noTelp);
        
        alamat = new JLabel("Alamat: "+ua.getAlamat());
        alamat.setBounds(30, 180, 150, 20);
        add(alamat);
        
        nik = new JLabel("NIK: "+ua.getNIK());
        nik.setBounds(30, 210, 150, 20);
        add(nik);
        
        tglLahir = new JLabel("tglLahir: "+ua.getTglLahir());
        tglLahir.setBounds(30, 240, 170, 20);
        add(tglLahir);
        
        
    }
}
