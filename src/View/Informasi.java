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
import java.awt.event.ActionListener;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

/**
 *
 * @author Ryuga
 */
public class Informasi extends JFrame {
    private JPanel background,panel,panel1;
    private JLabel lblbck ,lbltitle , lblinfo , lblisi , lgoGaruda , lgoImigrasi;
    private JButton home, antrian , jadwal;
    private ImageIcon icon , btnicn , tkticn ,jwdicn , iconGaruda , iconImigrasi;
    private Font font;
    
    
    public Informasi(String nama,String NIK){
        setSize(450,750);
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
        
        //panel for information
        panel = new JPanel();
        panel.setBounds(47,110,340,500);
        panel.setBackground(Color.WHITE);
        panel.setLayout(null);
        
        lblinfo = new JLabel("T A T A  C A R A");
        lblinfo.setFont(new Font("Calibri",Font.BOLD,25));
        lblinfo.setForeground(Color.BLACK);
        lblinfo.setBounds(90,20,200,30);
        
        lblisi = new JLabel("<html>1. Daftarkan Diri Anda Dengan Menekan Logo Tiket Dibawah. <br> "
                + "2. Pastikan Anda Memilih Kantor Yang Sesuai"
                + "<br> 3. Pilihlah Jadwal Yang Anda Inginkan"
                + "<br> 4. Dapatkan Kode Booking Untuk Antrian Paspor Anda"
                + "<br> 5. Terimakasih, Selamat Melanjutkan"
                + "</html>");
        lblisi.setFont(new Font("Calibri",Font.BOLD,18));
        lblisi.setBounds(30,0,300,300);
        
        lgoGaruda = new JLabel();
        iconGaruda = new ImageIcon(new ImageIcon("img/garuda.png").getImage().getScaledInstance(100,100,Image.SCALE_SMOOTH));
        lgoGaruda.setIcon(iconGaruda);
        lgoGaruda.setBounds(120,250,100,100);
         
        lgoImigrasi = new JLabel();
        iconImigrasi = new ImageIcon(new ImageIcon("img/Imigrasi.png").getImage().getScaledInstance(100,100,Image.SCALE_SMOOTH));
        lgoImigrasi.setIcon(iconImigrasi);
        lgoImigrasi.setBounds(120,370,100,100);
        
        panel.add(lblinfo);
        panel.add(lblisi);
        panel.add(lgoGaruda);
        panel.add(lgoImigrasi);
        //title at the up
        lbltitle = new JLabel("I N F O R M A S I");
        lbltitle.setFont(new Font("Bebas Neue",Font.PLAIN,21));
        lbltitle.setForeground(Color.WHITE);
        lbltitle.setBounds(175,0,100,100);
        
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
        
        panel1.add(home);
        panel1.add(antrian);
        panel1.add(jadwal);
        
        //adding panel
        add(lbltitle);
        add(panel);
        add(panel1);
        add(background);
        
        //action listener
        home.addActionListener(new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent arg0){
                Person p = new UserAccount();
				p = Controller.searchDataUA(NIK);
				UserAccount au = (UserAccount)p;
                Beranda berandaFrame = new Beranda(au.getNamaLengkap(),NIK);
                berandaFrame.setVisible(true);
                setVisible(false);
            }
        });
        
        antrian.addActionListener(new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent arg0){
                Person p = new UserAccount();
				p = Controller.searchDataUA(NIK);
                UserAccount au = (UserAccount)p;
                PilihKantor frameKantor = new PilihKantor(au);
                frameKantor.setVisible(true);
                setVisible(false);
            }
        });
        
        jadwal.addActionListener(new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent arg0){
                Person p = new UserAccount();
				p = Controller.searchDataUA(NIK);
                UserAccount au = (UserAccount)p;
                TiketAntrian frameTiket = new TiketAntrian(au);
                frameTiket.setVisible(true);
                setVisible(false);
            }
        });
    }
}
