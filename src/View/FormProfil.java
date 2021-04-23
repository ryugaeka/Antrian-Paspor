/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package View;

import Controller.Controller;
import Model.Person;
import Model.UserAccount;
import java.awt.Color;
import java.awt.Font;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import javax.imageio.ImageIO;
import javax.swing.AbstractAction;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import static javax.swing.WindowConstants.DISPOSE_ON_CLOSE;

/**
 *
 * @author msj
 */
public class FormProfil extends JFrame{
    private JPanel bgpanel;
    private JLabel nama,alamat,gender,username,bg,bg2,noTelp,date,nik;
    private JTextField namaLngkp,usernama,nomorTelp,Alamat,NIK;
    private ImageIcon icon;
    private JButton logout,changePassword,home,update;
    private String passLama,passBaru;
    private UserAccount ua;
    
    public FormProfil(Person p){
          ua = (UserAccount)p;
          JFrame f= new JFrame("Profil");
          System.out.println(ua.getNIK());
          System.out.println(ua.getNamaLengkap());
          JLabel labelfoto = new JLabel();
          ImageIcon ft= new ImageIcon(new ImageIcon("img/userlogo.png").getImage().getScaledInstance(120,120,Image.SCALE_DEFAULT));
          labelfoto.setIcon(ft);
          labelfoto.setBounds(100,300,100,130);
          setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
          System.out.println(ua.getNamaLengkap()+" - "+ua.getAlamat()+" - "+ua.getNoTelp()+" - "+ua.getUsername());  
            
            bgpanel = new JPanel();
            bgpanel.setBounds(0,0,450,750);
            bgpanel.setBackground(Color.LIGHT_GRAY);
            bgpanel.add(labelfoto);
          
           
           nama=new JLabel("Nama: "); 
           nama.setBounds(40,150,100,40);
           nama.setFont(new Font("Calibri",Font.CENTER_BASELINE,20));
           nama.setForeground(Color.white);
           
           namaLngkp = new JTextField(ua.getNamaLengkap());
           namaLngkp.setBounds(140, 160, 150, 30);
           
           alamat=new JLabel("Alamat: "); 
           alamat.setBounds(40,200,100,40);
           alamat.setFont(new Font("Calibri",Font.CENTER_BASELINE,20));
           alamat.setForeground(Color.white);
           
           Alamat = new JTextField(ua.getAlamat());
           Alamat.setBounds(140, 200, 150, 30);
           
           noTelp=new JLabel("No.Telp: "); 
           noTelp.setBounds(40,250,100,40);
           noTelp.setFont(new Font("Calibri",Font.CENTER_BASELINE,20));
           noTelp.setForeground(Color.white); 
           
           nomorTelp = new JTextField(ua.getNoTelp().toString());
           nomorTelp.setBounds(140, 250, 150, 30);
           
           
           username=new JLabel("Username:"); 
           username.setBounds(40,300,100,40);
           username.setFont(new Font("Calibri",Font.CENTER_BASELINE,20));
           username.setForeground(Color.white);
          
           usernama = new JTextField(ua.getUsername());
           usernama.setBounds(140, 300, 150, 30);
           
           icon = new ImageIcon(resizeImage("img/home.png"));
           home = new JButton(icon);
           home.setBounds(0, 0, 30, 30);
           home.setBorder(null);
           home.setContentAreaFilled(false);
           home.addActionListener(new AbstractAction(){
            @Override
            public void actionPerformed(ActionEvent su){
                Beranda b = new Beranda(ua.getNamaLengkap(),ua.getNIK());
                b.setVisible(true);
                setVisible(false);
                setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            }   

        });
            
           update = new JButton("Submit");
           update.setBounds(70, 400, 150, 30);
           update.addActionListener(new AbstractAction(){
            @Override
            public void actionPerformed(ActionEvent su){
                System.out.println("Berhasil Mengupdate");
                Person p = new UserAccount(ua.getTglLahir(),usernama.getText(),ua.getPassword(),ua.getJenisKelamin(),Alamat.getText(),ua.getNIK(),namaLngkp.getText(),nomorTelp.getText());
                UserAccount uu = (UserAccount)p;
                Controller.UpdateData(uu);
                Beranda b = new Beranda(uu.getNamaLengkap(),uu.getNIK());
                b.setVisible(true);
                setVisible(false);
                setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            }   

        });
           
           
           
            
            f.add(nama);
            f.add(alamat);
            f.add(noTelp);
            f.add(username);
            f.add(namaLngkp);
            f.add(home);
            f.add(update);
            f.add(usernama);
            f.add(nomorTelp);
            f.add(Alamat);
            f.add(bgpanel);
            f.setSize(450,750);
            f.setLocationRelativeTo(null);
            f.setLayout(null);
            f.setVisible(true);
            
    }
    
    public FormProfil(String NIK){
            JFrame f= new JFrame("Profil");  
          Person p = null;
          p = Controller.searchDataUA(NIK);
          ua = (UserAccount)p;
          System.out.println(ua.getNIK());
          System.out.println(ua.getNamaLengkap());
          JLabel labelfoto =new JLabel();
          ImageIcon ft=new ImageIcon(new ImageIcon("img/userlogo.png").getImage().getScaledInstance(120,120,Image.SCALE_DEFAULT));
          labelfoto.setIcon(ft);
          labelfoto.setBounds(100,300,100,130);
            
            
            bgpanel = new JPanel();
            bgpanel.setBounds(0,0,450,750);
            bgpanel.setBackground(Color.LIGHT_GRAY);
            bgpanel.add(labelfoto);
          
           
           nama=new JLabel("Nama: "+ua.getNamaLengkap()); 
           nama.setBounds(40,150,200,40);
           nama.setFont(new Font("Calibri",Font.CENTER_BASELINE,20));
           nama.setForeground(Color.white);
           
           alamat=new JLabel("Alamat: "+ua.getAlamat()); 
           alamat.setBounds(40,200,300,40);
           alamat.setFont(new Font("Calibri",Font.CENTER_BASELINE,20));
           alamat.setForeground(Color.white);
           
           noTelp=new JLabel("No.Telp: "+ua.getNoTelp()); 
           noTelp.setBounds(40,250,200,40);
           noTelp.setFont(new Font("Calibri",Font.CENTER_BASELINE,20));
           noTelp.setForeground(Color.white); 
           
           username=new JLabel("Username:"+ua.getUsername()); 
           username.setBounds(40,300,200,40);
           username.setFont(new Font("Calibri",Font.CENTER_BASELINE,20));
           username.setForeground(Color.white);
          
           date = new JLabel("Tgl Lahir: "+ua.getTglLahir());
           date.setBounds(40, 350, 200, 40);
           date.setFont(new Font("Calibri",Font.CENTER_BASELINE,20));
           date.setForeground(Color.WHITE);
           
           nik = new JLabel("NIK: "+ua.getNIK());
           nik.setBounds(40, 400, 200, 40);
           nik.setFont(new Font("Calibri",Font.CENTER_BASELINE,20));
           nik.setForeground(Color.WHITE);
           
           changePassword = new JButton("Change Password");
           changePassword.setBounds(240, 310, 150, 30);
           changePassword.addActionListener(new AbstractAction(){
            @Override
            public void actionPerformed(ActionEvent su){
                passLama = JOptionPane.showInputDialog(null,"Masukkan password lama");
                if(ua.getPassword().equals(passLama)){
                    System.out.println("Password benar, masukkan yang baru!");
                    passBaru = JOptionPane.showInputDialog(null,"Masukkan Password yang baru!");
                    Controller.updatePassword(NIK,passLama,passBaru);
                }else{
                    JOptionPane.showInputDialog(null,"Masukkan Password dengan benar!");
                    
                }
                
            }   
        });
           logout=new JButton("Logout");
           logout.setBounds(240,470,150,30);  
           logout.addActionListener(new AbstractAction(){
            @Override
            public void actionPerformed(ActionEvent su){
                Login lgn = new Login();
                lgn.setVisible(true);
            }   

        });
           
           icon = new ImageIcon(resizeImage("img/home.png"));
           home = new JButton(icon);
           home.setBounds(0, 0, 30, 30);
           home.setBorder(null);
           home.setContentAreaFilled(false);
           home.addActionListener(new AbstractAction(){
            @Override
            public void actionPerformed(ActionEvent su){
                Beranda b = new Beranda(ua.getNamaLengkap(),ua.getNIK());
                b.setVisible(true);
                setVisible(false);
                setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            }   

        });
            
           update = new JButton("Update");
           update.setBounds(30, 470, 150, 30);
           update.addActionListener(new AbstractAction(){
            @Override
            public void actionPerformed(ActionEvent su){
                FormProfil fp = new FormProfil(ua);
                fp.setVisible(true);
                setVisible(false);
                setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            }   

        });
           
           
           
            
            f.add(nama);
            f.add(alamat);
            f.add(noTelp);
            f.add(username);
            f.add(logout);
            f.add(date);
            f.add(nik);
            f.add(changePassword);
            f.add(home);
            f.add(update);
            f.add(bgpanel);
            f.setSize(450,750);
            f.setLocationRelativeTo(null);
            f.setLayout(null);  
            f.setVisible(true);
            
    }
    private Image resizeImage(String url){
        Image dimg = null;
        try{
            BufferedImage img = ImageIO.read(new File(url));
            dimg = img.getScaledInstance(30, 30, Image.SCALE_SMOOTH);
        }catch (IOException ex){
            ex.printStackTrace(System.err);
        }
        return dimg;
    }
}

