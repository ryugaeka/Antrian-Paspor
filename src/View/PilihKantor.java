/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package View;

import Controller.Controller;
import Model.Kantor;
import Model.Person;
import Model.UserAccount;
import java.awt.Color;
import java.awt.Font;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

/**
 *
 * @author Ryuga
 */
public class PilihKantor extends JFrame {
    private JPanel background,panel,panel1;
    private JLabel lblbck ,lbltitle , lblkntr ;
    private JButton home, antrian , jadwal , btnPemohon;
    private ImageIcon icon , btnicn , tkticn ,jwdicn;
    private JComboBox cbkota;
    private Font font;
    private UserAccount au;
    
    public PilihKantor(Person p){
        au = (UserAccount)p;
        setSize(450,750);
        setVisible(true);
        setLocationRelativeTo(null);
        setLayout(null);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setResizable(false);
        font = new Font("Bebas Neue",Font.PLAIN,18);
        //add background
        background = new JPanel();
        background.setSize(450,750);
        lblbck = new JLabel();
        icon = new ImageIcon(new ImageIcon("img/bg.jpg").getImage().getScaledInstance(450,750, Image.SCALE_DEFAULT));
        lblbck.setIcon(icon);
        background.add(lblbck);
        
        //title at the up
        lbltitle = new JLabel("P I L I H  K A N T O R");
        lbltitle.setFont(new Font("Bebas Neue",Font.PLAIN,16));
        lbltitle.setForeground(Color.WHITE);
        lbltitle.setBounds(165,0,200,100);
       
        //panel for pilihkantor
        panel = new JPanel();
        panel.setBounds(47,110,340,500);
        panel.setBackground(Color.WHITE);
        panel.setLayout(null);
        
        String [] kantor = {"Kantor Imigrasi Bandung","UKK Cianjur","ULP Bandung","Imigrasi Ciamis","Imigrasi Surabaya"};
        JComboBox cbkota = new JComboBox(kantor);
        cbkota.setBounds(70,60,200,30);
   
        lblkntr = new JLabel("Pilih Kantor");
        lblkntr.setFont(new Font("Bebas Neue",Font.PLAIN,25));
        lblkntr.setBounds(110,20,200,25);
        panel.add(lblkntr);
        panel.add(cbkota);
        
        //btnPemohon
        
        btnPemohon = new JButton("Submit");
        btnPemohon.setBounds(130,120,80,20);
        panel.add(btnPemohon);
        
        //panel menu bawah
        panel1 = new JPanel();
        panel1.setLayout(null);
        panel1.setBounds(0,630,450,100);
        panel1.setBackground(Color.WHITE);
        
        home = new JButton();
        antrian = new JButton();
        jadwal = new JButton();
        
        btnicn = new ImageIcon(new ImageIcon("img/home.png").getImage().getScaledInstance(40,40, Image.SCALE_DEFAULT));
        tkticn = new ImageIcon(new ImageIcon("img/tiket.png").getImage().getScaledInstance(40, 40, Image.SCALE_DEFAULT));
        jwdicn = new ImageIcon(new ImageIcon("img/jadwal.png").getImage().getScaledInstance(40, 40, Image.SCALE_DEFAULT));
        
        home.setIcon(btnicn);
        home.setBounds(40, 17, 50, 50);
        home.setBorder(null);
        home.setContentAreaFilled(false);
        
        antrian.setIcon(tkticn);
        antrian.setBounds(195,17,50,50);
        antrian.setBorder(null);
        antrian.setContentAreaFilled(false);
        
        jadwal.setIcon(jwdicn);
        jadwal.setBounds(350,17,50,50);
        jadwal.setBorder(null);
        jadwal.setContentAreaFilled(false);
        
        setVisible(true);
        panel1.add(home);
        panel1.add(antrian);
        panel1.add(jadwal);
        
        
        //adding action listener
        btnPemohon.addActionListener(new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent arg0){
                String alamat="";
                if(cbkota.getSelectedItem().toString().equals("Kantor Imigrasi Bandung")){
                    alamat = "Dipatiukur no 15";
                }else if(cbkota.getSelectedItem().toString().equals("UKK Cianjur")){
                    alamat = "Cianjur 1 No 20";
                }else if(cbkota.getSelectedItem().toString().equals("ULP Bandung")){
                    alamat = "Sekeloa No.5";
                }else if(cbkota.getSelectedItem().toString().equals("Imgigrasi Ciamis")){
                    alamat = "Ciamis juju";
                }else if(cbkota.getSelectedItem().toString().equals("Imigrasi Surabaya")){
                    alamat = "Surabaya jaknot";
                }
                System.out.println(cbkota.getSelectedItem()+" - "+alamat);
                Kantor k = new Kantor(cbkota.getSelectedItem().toString(),alamat);
                FormPermohonan framePemohon = new FormPermohonan(k,au);
                framePemohon.setVisible(true);
                setVisible(false);
            }
        });
        
        home.addActionListener(new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent arg0){
                Person p = new UserAccount();
                Beranda berandaFrame = new Beranda(au.getNamaLengkap(),au.getNIK());
                berandaFrame.setVisible(true);
                setVisible(false);
            }
        });
        
        jadwal.addActionListener(new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent arg0){
                Person p = new UserAccount();
                TiketAntrian frameTiket = new TiketAntrian(au);
                frameTiket.setVisible(true);
                setVisible(false);
            }
        });
        
        add(lbltitle);
        add(panel);
        add(panel1);
        add(background);
    }
}
