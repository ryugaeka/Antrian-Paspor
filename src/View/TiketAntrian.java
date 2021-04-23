/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package View;

import Model.Pemohon;
import Model.Person;
import Model.UserAccount;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import javax.imageio.ImageIO;
/**
 *
 * @author Reynold
 */
public class TiketAntrian extends JFrame{
    private JPanel bgPanel, headerPanel, bodyPanel, codePanel;
    private ImageIcon bgImage;
    private JLabel bg, headerText;
    private JLabel dateText, nikText, nameText, placeText, timeText, nikContentText, nameContentText, placeContentText, timeContentText,  codeText, codeContentText;
    private JButton home;
    private ImageIcon icon;
    private Pemohon pmh;
    
    public TiketAntrian(Person p){
//        setVisible(true);
        setSize(450,750);
        setLayout(null);
        setTitle("Antrian Paspor");
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setResizable(false);
        
        pmh = (Pemohon)p;
        if(pmh.getNIK() == null){
            JOptionPane.showMessageDialog(null, "Jadwal Antrian belum Ada!");
            
        }else{
            //Panel Background
            bgPanel = new JPanel();
            bgPanel.setBounds(0,0,450,750);

                //Background Image
                bg = new JLabel();
                bgImage = new ImageIcon(new ImageIcon("img/bg.jpg").getImage().getScaledInstance(450,750,Image.SCALE_DEFAULT));
                bg.setIcon(bgImage);
            bgPanel.add(bg);


            //Panel Header
            headerPanel = new JPanel();
            headerPanel.setBounds(6,50,430,35);
            headerPanel.setBackground(new Color(0,255,0,0));

                //Header Text
                headerText = new JLabel("JADWAL ANTRIAN");
                headerText.setForeground(Color.WHITE);
                headerText.setFont(new Font("Arial", Font.BOLD, 20));

            headerPanel.add(headerText);


            //Panel Body
            bodyPanel = new JPanel();
            bodyPanel.setBounds(6,120,430,620);
            bodyPanel.setLayout(null);
            bodyPanel.setBackground(Color.WHITE);

                //Date Text
                dateText = new JLabel(pmh.getTglKedatangan());
                dateText.setBounds(120,10,200,35);
                dateText.setForeground(new Color(99,99,99));
                dateText.setFont(new Font("Arial", Font.BOLD, 20));

                //NIK
                nikText = new JLabel("NIK");
                nikText.setBounds(10,50,60,35);
                nikText.setForeground(new Color(99,99,99));
                nikText.setFont(new Font("Arial", Font.BOLD, 17));

                //Isi NIK
                nikContentText = new JLabel(pmh.getNIK());
                nikContentText.setBounds(120,50,300,35);
                nikContentText.setForeground(new Color(99,99,99));
                nikContentText.setFont(new Font("Arial", Font.BOLD, 17));

                //Nama
                nameText = new JLabel("Nama");
                nameText.setBounds(10,80,60,35);
                nameText.setForeground(new Color(99,99,99));
                nameText.setFont(new Font("Arial", Font.BOLD, 17));

                //Isi Nama
                nameContentText = new JLabel(pmh.getNamaLengkap());
                nameContentText.setBounds(120,80,300,35);
                nameContentText.setForeground(new Color(99,99,99));
                nameContentText.setFont(new Font("Arial", Font.BOLD, 17));

                //Tempat
                placeText = new JLabel("Tempat");
                placeText.setBounds(10,110,60,35);
                placeText.setForeground(new Color(99,99,99));
                placeText.setFont(new Font("Arial", Font.BOLD, 17));

                //Isi Tempat
                placeContentText = new JLabel(pmh.getTempat().getNama());
                placeContentText.setBounds(120,110,300,35);
                placeContentText.setForeground(new Color(99,99,99));
                placeContentText.setFont(new Font("Arial", Font.BOLD, 17));

                //Waktu
                timeText = new JLabel("Waktu");
                timeText.setBounds(10,140,60,35);
                timeText.setForeground(new Color(99,99,99));
                timeText.setFont(new Font("Arial", Font.BOLD, 17));

                //Isi Waktu
                timeContentText = new JLabel(pmh.getWaktuKedatangan());
                timeContentText.setBounds(120,140,300,35);
                timeContentText.setForeground(new Color(99,99,99));
                timeContentText.setFont(new Font("Arial", Font.BOLD, 17));

                //Kode Booking
                codeText = new JLabel("Kode Booking");
                codeText.setBounds(153,200,150,35);
                codeText.setForeground(new Color(99,99,99));
                codeText.setFont(new Font("Arial", Font.BOLD, 18));

                //Panel Code
                codePanel = new JPanel();
                codePanel.setBounds(20,235,390,31);
                codePanel.setBackground(new Color(99,99,99));

                    //Isi Kode Booking
                    codeContentText = new JLabel(pmh.getKodeBooking());
                    codeContentText.setForeground(Color.WHITE);
                    codeContentText.setFont(new Font("Arial", Font.BOLD, 18));

               icon = new ImageIcon(resizeImage("img/home.png"));
               home = new JButton(icon);
               home.setBounds(0, 0, 30, 30);
               home.addActionListener(new AbstractAction(){
                @Override
                public void actionPerformed(ActionEvent su){
                    Person p = new UserAccount();
                    UserAccount ua = (UserAccount)p;
                    Beranda b = new Beranda(pmh.getNamaLengkap(),pmh.getNIK());
                    b.setVisible(true);
                    setVisible(false);
                }   

            });

                codePanel.add(codeContentText);

            bodyPanel.add(dateText);
            bodyPanel.add(nikText);
            bodyPanel.add(nikContentText);
            bodyPanel.add(nameText);
            bodyPanel.add(nameContentText);
            bodyPanel.add(placeText);
            bodyPanel.add(placeContentText);
            bodyPanel.add(timeText);
            bodyPanel.add(timeContentText);
            bodyPanel.add(codeText);
            bodyPanel.add(codePanel);
            bodyPanel.add(home);


            getContentPane().add(headerPanel);
            getContentPane().add(bodyPanel);
            getContentPane().add(bgPanel);
        }
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
