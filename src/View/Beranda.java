/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package View;

/**
 *
 * @author Ryuga
 */
import Controller.Controller;
import Model.Pemohon;
import Model.Person;
import Model.UserAccount;
import java.awt.Color;
import java.awt.Font;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.AbstractAction;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

public class Beranda extends JFrame {
    private JPanel panel, panel1 , button , panel2 , panel3, background;
    private JLabel uname , passw , bcklbl , lbltkt ,lblinf ,lblberanda, namaL;
    private JButton home, antrian , jadwal , antrmn , informasi, userlogo;
    private ImageIcon icon , btnicn , tkticn , jwdicn , usrlogo , tktmn ,infcn,userLogo;
    private Font font;
    
    public Beranda(String nama,String NIK){
        setSize(450,750);
        setLocationRelativeTo(null);
        setLayout(null);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setResizable(false);
        
        font = new Font("Bebas Neue",Font.PLAIN,18);  
        
        //set background
        background = new JPanel();
        background.setSize(450,750);
        bcklbl = new JLabel();
        icon = new ImageIcon(new ImageIcon("img/bg.jpg").getImage().getScaledInstance(450,750, Image.SCALE_DEFAULT));
        bcklbl.setIcon(icon);
        background.add(bcklbl);
        
        //panel menu 1
        panel = new JPanel();
        panel.setBounds(70,210,300,100);
        panel.setBackground(Color.WHITE);
        panel.setLayout(null);
        
        userLogo = new ImageIcon(new ImageIcon("img/userlogo.png").getImage().getScaledInstance(90,90, Image.SCALE_DEFAULT)); 
        userlogo = new JButton(userLogo);
        userlogo.setBounds(10,5,90,90);
        userlogo.setBorder(null);
        userlogo.setContentAreaFilled(false);
        userlogo.addActionListener(new AbstractAction(){
            @Override
            public void actionPerformed(ActionEvent su){
                FormProfil fp = new FormProfil(NIK);
            }   
        });
        
        namaL = new JLabel(nama);
        namaL.setFont(new Font("",Font.ITALIC,20));
        namaL.setBounds(110, 10, 200, 30);
        panel.add(namaL);
        //
        
        //panel menu 2
        panel3 = new JPanel();
        panel3.setBounds(70,350,300,100);
        panel3.setBackground(Color.WHITE);
        panel3.setLayout(null);
        
        informasi = new JButton();
        infcn = new ImageIcon(new ImageIcon("img/warning2.png").getImage().getScaledInstance(50,50, Image.SCALE_DEFAULT));
        informasi.setIcon(infcn);
        informasi.setBounds(100,-10,100,100);
        informasi.setBorder(null);
        informasi.setContentAreaFilled(false);
        
        lblinf = new JLabel("Informasi");
        lblinf.setBounds(120,25,100,100);
        lblinf.setFont(font);
        
        
        panel3.add(lblinf);
        panel3.add(informasi);
        
        //
        
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
        
        //end of panel bawah
        
        lblberanda = new JLabel("B E R A N D A");
        lblberanda.setFont(new Font("Bebas Neue",Font.PLAIN,25));
        lblberanda.setForeground(Color.WHITE);
        lblberanda.setBounds(170,20,200,50);
        
        
        //adding to frame
        add(panel);
        add(lblberanda);
        add(panel3);
        add(panel1);
        add(background);
        
        setVisible(true);
        
        //action listener
        informasi.addActionListener(new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent arg0){
                Person p = new UserAccount();
                p = Controller.searchDataUA(NIK);
                UserAccount au = (UserAccount)p;
                au = (UserAccount)p;
                Informasi infoFrame = new Informasi(au.getNamaLengkap(),NIK);
                infoFrame.setVisible(true);
                setVisible(false);
            }
        });
        
        antrian.addActionListener(new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent arg0){
                Person p = new UserAccount();
                p = Controller.searchDataUA(NIK);
                PilihKantor frameKantor = new PilihKantor(p);
                frameKantor.setVisible(true);
                setVisible(false);
            }
        });
        
        jadwal.addActionListener(new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent arg0){
                Person p = new Pemohon();
                p = Controller.searchDataPMH(NIK);
                if(p == null){
                    JOptionPane.showMessageDialog(null, "Belum ada Antrian");
                    Beranda b = new Beranda(nama,NIK);
                    b.setVisible(true);
                    setVisible(false);
                }else{
                    Pemohon pmh = (Pemohon)p;
                    if(Controller.checkStatus(pmh.getKodeBooking()) == 0){
                        TiketAntrian frameTiket = new TiketAntrian(p);
                        frameTiket.setVisible(true);
                        setVisible(false);
                    }else{
                        JOptionPane.showMessageDialog(null, "Antrian sudah terpakai");
                        Beranda b = new Beranda(nama,NIK);
                        b.setVisible(true);
                        setVisible(false);
                    }
                }
            }
        });
        panel.add(userlogo);
    }
}