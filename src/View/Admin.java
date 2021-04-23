/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package View;

import java.awt.Color;
import java.awt.Font;
import java.awt.Image;
import java.awt.event.ActionEvent;
import javax.swing.AbstractAction;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

/**
 *
 * @author msj
 */
public class Admin extends JFrame{
    private JPanel panel,background;
    private JButton dataCostumer,liatAntrian,updateKuota;
    private JLabel title,bckgrnd;
    private ImageIcon icon;
    
    public Admin(){
        setTitle("Admin");
        setLayout(null);
        setSize(450,750);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        setResizable(false);
        
        background = new JPanel();
        background.setSize(450,750);
        bckgrnd = new JLabel();
        icon = new ImageIcon(new ImageIcon("img/bg.jpg").getImage().getScaledInstance(450, 750, Image.SCALE_DEFAULT));
        bckgrnd.setIcon(icon);
        background.add(bckgrnd);
        
        title = new JLabel("A D M I N");
        title.setBounds(170, 110, 200, 50);
        title.setFont(new Font("",Font.ROMAN_BASELINE,25));
        title.setForeground(Color.WHITE);
        add(title);
        
        
        dataCostumer = new JButton("Data Costumer");
        dataCostumer.setBounds(130, 420, 200, 50);
        dataCostumer.addActionListener(new AbstractAction(){
            @Override
            public void actionPerformed(ActionEvent su){
                dataCostumer dc = new dataCostumer();
                dc.setVisible(true);
                setVisible(false);
            }   
        });
        add(dataCostumer);
        
        liatAntrian = new JButton("Lihat Antrian");
        liatAntrian.setBounds(130, 500, 200, 50);
        liatAntrian.addActionListener(new AbstractAction(){
            @Override
            public void actionPerformed(ActionEvent su){
                AdminAntrian aa = new AdminAntrian();
                aa.setVisible(true);
                setVisible(false);
            }   
        });
        add(liatAntrian);
        
        updateKuota = new JButton("Update Kuota");
        updateKuota.setBounds(130, 580, 200, 50);
        updateKuota.addActionListener(new AbstractAction(){
            @Override
            public void actionPerformed(ActionEvent su){
                AdminKuota ad = new AdminKuota();
                ad.setVisible(true);
                setVisible(false);
            }   
        });
        add(updateKuota);
        
        add(background);
    }
}
