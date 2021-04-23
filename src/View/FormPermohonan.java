/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package View;

import Controller.Controller;
import Model.Kantor;
import Model.Pemohon;
import Model.Person;
import Model.UserAccount;
import java.awt.*;
import javax.swing.*;
import com.toedter.calendar.JDateChooser;
import java.awt.event.*;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.logging.Level;
import java.util.logging.Logger;
/**
 *
 * @author Reynold
 */
public class FormPermohonan extends JFrame{
    private JPanel bgPanel, headerPanel, bodyPanel;
    private JLabel bg, headerText, dateText, timeText, quotaText, kuota;
    private ImageIcon bgImage;
    private JTextField quotaField;
    private JRadioButton pagiButton, siangButton;
    private ButtonGroup timeGroup;
    private JButton continueButton, seeQuota;
    private JDateChooser chooseDate;
    private String tanggal="",month="",KUOTA="";
    private int countMonth=0;
    
    private int q;
    
    public FormPermohonan(Kantor k,UserAccount au){
        setSize(450,750);
        setLayout(null);
        setTitle("Antrian Paspor");
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setResizable(false);
        
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
        headerText = new JLabel("PILIH TANGGAL & WAKTU KEDATANGAN");
        headerText.setForeground(Color.WHITE);
        headerText.setFont(new Font("Arial", Font.BOLD, 20));
            
        headerPanel.add(headerText);
            
        
        //Panel Body
        bodyPanel = new JPanel();
        bodyPanel.setBounds(6,120,430,620);
        bodyPanel.setLayout(null);
        bodyPanel.setBackground(Color.WHITE);
        
        //Date Text
        dateText = new JLabel("Tanggal Kedatangan");
        dateText.setBounds(10,10,200,25);
        dateText.setForeground(Color.GRAY);
        dateText.setFont(new Font("Arial", Font.BOLD, 20));
            
        //DateChooser Date
        chooseDate = new JDateChooser();
        chooseDate.setDateFormatString("dd//MM//yyyy");
        chooseDate.setBorder(BorderFactory.createLineBorder(Color.BLACK, 2));
        chooseDate.setBounds(10, 35, 410, 30);
            
        //Time Text
        timeText = new JLabel("Waktu Kedatangan");
        timeText.setBounds(10,80,200,25);
        timeText.setForeground(new Color(99,99,99));
        timeText.setFont(new Font("Arial", Font.BOLD, 20));
            
        //RadioButton Time
        pagiButton = new JRadioButton("Pagi (08:00 - 12:00)");
        pagiButton.setBackground(Color.WHITE);
        pagiButton.setBounds(10,100,200,20);
        pagiButton.setFont(new Font("Arial", Font.BOLD, 15));
            
        siangButton = new JRadioButton("Siang (13:00 - 16:00)");
        siangButton.setBackground(Color.WHITE);
        siangButton.setBounds(10,120,200,20);
        siangButton.setFont(new Font("Arial", Font.BOLD, 15));
            
        timeGroup = new ButtonGroup();
        timeGroup.add(pagiButton);
        timeGroup.add(siangButton);
            
        //Quota Text
        quotaText = new JLabel("Kuota Tersisa");
        quotaText.setBounds(10,150,200,25);
        quotaText.setForeground(new Color(99,99,99));
        quotaText.setFont(new Font("Arial", Font.BOLD, 20));
            
            
        //Button Cek Kuota
        seeQuota = new JButton("Cek");
        seeQuota.setBounds(70,175,70,30);
        seeQuota.setBackground(new Color(99,99,99));
        seeQuota.setForeground(Color.WHITE);
        seeQuota.setFont(new Font("Arial", Font.BOLD, 20));
        seeQuota.addActionListener(new ActionListener(){
                    @Override
                    public void actionPerformed(ActionEvent e){
                        String result = "";
                        
                        String pattern = "yyyy-MM-dd";
                        SimpleDateFormat format = new SimpleDateFormat(pattern);
                        tanggal = String.valueOf(format.format(chooseDate.getDate()));
                        month = tanggal.substring(5 , 7);
                        
                         String currentDate = Controller.getDate();
                         Date d = null;
                         Date d1 = null;
                         
                        try {
                            d = format.parse(tanggal);
                            d1 = format.parse(currentDate);
                             if(d1.compareTo(d) < 0){
                                countMonth = Controller.countKuota(month);
                                System.out.println(countMonth);
                                q = Controller.getKuota(month) - countMonth;
                                KUOTA = String.valueOf(q);
                                quotaField.setText(KUOTA);
                                System.out.println("Kuota tersisa di bulan "+month+": "+KUOTA);
                             }else{
                                 JOptionPane.showMessageDialog(null, "Tanggal yang anda masukkan salah");
                                 FormPermohonan fp = new FormPermohonan(k,au);
                                 fp.setVisible(true);
                                 setVisible(false);
                             }
                        } catch (ParseException ex) {
                            ex.printStackTrace();
                        }
                             
                    }
                });
                
            //TextField Quota
            quotaField = new JTextField();
            quotaField.setBounds(10,175,50,30);
            quotaField.setEditable(false);
            
            //Button Lanjut
            continueButton = new JButton("Lanjut");
            continueButton.setBounds(10,210,410,30);
            continueButton.setBackground(new Color(99,99,99));
            continueButton.setForeground(Color.WHITE);
            continueButton.setFont(new Font("Arial", Font.BOLD, 20));
            
        bodyPanel.add(dateText);
        bodyPanel.add(chooseDate);
        bodyPanel.add(timeText);
        bodyPanel.add(pagiButton);
        bodyPanel.add(siangButton);
        bodyPanel.add(quotaText);
        bodyPanel.add(quotaField);
        bodyPanel.add(seeQuota);
        bodyPanel.add(continueButton);
        
        
        getContentPane().add(headerPanel);
        getContentPane().add(bodyPanel);
        getContentPane().add(bgPanel);
        
        continueButton.addActionListener(new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent e){
                String temp="";
                
                if(pagiButton.isSelected()){
                    temp = "Pagi (08:00 - 12:00)";
                }else{
                    temp = "Siang (13:00 - 16:00)";
                }
                String kodeBooking = Controller.Generate(9);
                Person p = new Pemohon(k,tanggal,temp,kodeBooking,au.getNIK(),au.getNamaLengkap(),au.getNoTelp());
                Controller.insertAntrian(p);
                Controller.addKuota(tanggal,au.getNIK(),month);
                Controller.updateKuota(q, month);
                TiketAntrian tiketFrame = new TiketAntrian(p);
                tiketFrame.setVisible(true);
                setVisible(false);
            }
        });
    }
}

