/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package View;

import Controller.Controller;
import Model.Person;
import Model.UserAccount;
import com.toedter.calendar.JDateChooser;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import javax.imageio.ImageIO;
import javax.swing.AbstractAction;
import javax.swing.ButtonGroup;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JRadioButton;
import javax.swing.JTextField;


/**
 *
 * @author Ryuga
 */

public class Register extends JFrame {
    private JPanel login,panel, panel1 , button , panel2, background;
    private JLabel nama, uname , passw, ttl, alamat, noTelp,judul,nik,backgroundRegister;
    private JTextField namaLengkap, username, Alamat,telepon,noKTP;
    private JRadioButton male,female;
    private JPasswordField password;
    private JButton submit, register;
    private ImageIcon icon;
    private JDateChooser tglLahir;
    private String date;
    private String temp="";
    
    public Register(){
        setTitle("Registrasi Page");
        setSize(450,750);
        setLayout(null);
        setLocationRelativeTo(null);
        setResizable(false);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        
        background = new JPanel();
        background.setSize(450, 750);
        backgroundRegister = new JLabel();
        icon = new ImageIcon(new ImageIcon("img/bg.jpg").getImage().getScaledInstance(450, 750, Image.SCALE_DEFAULT));
        backgroundRegister.setIcon(icon);
        background.add(backgroundRegister);
        
        
        judul = new JLabel("R E G I S T E R");
        judul.setFont(new Font("apa ajah",Font.PLAIN,25));
        judul.setForeground(Color.WHITE);
        judul.setBounds(130, 20, 300, 30);
        add(judul);
        
        
        panel1 = new JPanel();
        panel1.setBounds(40,80,350,600);
        panel1.setBackground(Color.WHITE);
        add(panel1);
        panel1.setLayout(null);
        
        //nama
        nama = new JLabel();
        nama.setText("Nama Lengkap");
        nama.setFont(new Font("apa ajah",Font.BOLD,15));
        nama.setBounds(35, 0, 200, 48);
        panel1.add(nama);
        
        namaLengkap = new JTextField();
        namaLengkap.setVisible(true);
        namaLengkap.setBounds(30, 45, 290, 30);
        panel1.add(namaLengkap);
        
        //gender
        ButtonGroup button12 = new ButtonGroup();
        male = new JRadioButton("Male");
        male.setBounds(100,80,60,20);
        button12.add(male);
        female = new JRadioButton("Female");
        female.setBounds(170,80,70,20);
        button12.add(female);
        panel1.add(male);
        panel1.add(female);
        
        //uname
        uname = new JLabel();
        uname.setText("Username");
        uname.setFont(new Font("apa ajah",Font.BOLD,15));
        uname.setBounds(35, 90, 200, 48);
        panel1.add(uname);
        username = new JTextField();
        username.setVisible(true);
        username.setBounds(30, 130, 290, 30);
        panel1.add(username);
        
        //password
        passw = new JLabel();
        passw.setText("Password");
        passw.setFont(new Font("apa ajah",Font.BOLD,15));
        passw.setBounds(35, 150, 70, 40);
        panel1.add(passw);
        password = new JPasswordField(20);
        password.setBounds(30, 190, 290, 30);
        password.setVisible(true);
        panel1.add(password);
        
        //notelp
        noTelp = new JLabel();
        noTelp.setText("No Telepon");
        noTelp.setFont(new Font("apa ajah",Font.BOLD,15));
        noTelp.setBounds(35, 200, 150, 70);
        panel1.add(noTelp);
        telepon = new JTextField(17);
        telepon.setBounds(30, 250, 290, 30);
        panel1.add(telepon);
        
        //ttl
        ttl = new JLabel();
        ttl.setText("Tgl Lahir");
        ttl.setFont(new Font("apa ajah",Font.BOLD,15));
        ttl.setBounds(35, 250, 70, 90);
        panel1.add(ttl);
        tglLahir = new JDateChooser();
        tglLahir.setBounds(30, 310, 290, 30);
        panel1.add(tglLahir);
        
        //alamat
        alamat = new JLabel();
        alamat.setText("Alamat");
        alamat.setFont(new Font("apa ajah",Font.BOLD,15));
        alamat.setBounds(35, 340, 70, 30);
        panel1.add(alamat);
        Alamat = new JTextField(20);
        Alamat.setBounds(30, 370, 290, 30);
        panel1.add(Alamat);
        
        //nik
        nik = new JLabel();
        nik.setText("Nomor Induk Kependudukan");
        nik.setFont(new Font("apa ajah",Font.BOLD,15));
        nik.setBounds(35,400,300,30);
        panel1.add(nik);
        noKTP = new JTextField();
        noKTP.setBounds(30,430,290,30);
        panel1.add(noKTP);
        
        //button regist
        submit = new JButton("R E G I S T E R");
        submit.setPreferredSize(new Dimension(290,20));
        submit.setBounds(70, 490, 200, 40);
        submit.addMouseListener(new MouseAdapter(){
            
            @Override
            public void mouseClicked(MouseEvent e){
                register(e);
                setVisible(false);
            }
        });
        submit.addActionListener(new AbstractAction(){
            @Override
            public void actionPerformed(ActionEvent e){
                if(e.getSource() == submit){
                    
//                    String query = "Insert into datacostumer"+"(namaLengkap,Username,password,noTelp,date,TglLahir,Alamat,NIK)" +"Values ("+namaLengkap.getText()+","+username.getText()+","+String.valueOf(password.getPassword())+","+telepon.getText()+","+tglLahir.getDateFormatString()+","+Alamat.getText()+","+noKTP.getText()+")";
                    if(tglLahir.getDate()!=null){
                        String pattern = "yyyy-MM-dd";
                        SimpleDateFormat format = new SimpleDateFormat(pattern);
                        date = String.valueOf(format.format(tglLahir.getDate()));
                    }
                    
                    if(female.isSelected()){
                        temp = "Female";
                    }else{
                        temp = "Male";
                    }
                    
                    System.out.println(namaLengkap.getText());
                    Person p = new UserAccount(date,username.getText(),String.valueOf(password.getPassword()),temp,Alamat.getText(),noKTP.getText(),namaLengkap.getText(),telepon.getText());
                    Controller.registrasi(p);
                }
            }
        });
        panel1.add(submit);
        
        panel1.setVisible(true);
        add(background);
    }
    private void register(MouseEvent e){
        String isiNama = nama.getText();
        String isiUname = uname.getText();
        String alamat = Alamat.getText();
        String noktp = noKTP.getText();
        if(isiNama.equals(null)){
            JOptionPane.showMessageDialog(null, "Harap Isi Dengan Lengkap!");
        }else{
            JOptionPane.showMessageDialog(null, "Selamat anda sudah dapat Sign In sekarang!");
            Login frameLogin = new Login();
            frameLogin.setVisible(true);
            this.setVisible(false);
        }
    }
    
    private Image resizeImage(String url){
        Image dimg = null;
        try{
            BufferedImage img = ImageIO.read(new File(url));
            dimg = img.getScaledInstance(450, 750, Image.SCALE_SMOOTH);
        }catch (IOException ex){
            ex.printStackTrace(System.err);
        }
        return dimg;
    }
}
