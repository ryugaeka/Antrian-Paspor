/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package View;

import Controller.Controller;
import java.awt.Color;
import java.awt.Font;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
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
import javax.swing.JPasswordField;
import javax.swing.JTextField;

/**
 *
 * @author msj
 */
public class Login extends JFrame{
    private JPanel panel,panel1,panel2,background;
    private JLabel username,password,backgroundLogin,lgoGaruda,lgoImigrasi,judul;
    private JTextField usernama;
    private JPasswordField pass;
    private JButton signIn, register;
    private ImageIcon icon,iconGaruda,iconImigrasi;
    
    public Login(){
        setTitle("Login Page");
        setSize(450,750);
        setLayout(null);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setResizable(false);
        
        background = new JPanel();
        background.setSize(450, 750);
        backgroundLogin = new JLabel();
        icon = new ImageIcon(new ImageIcon("img/bg.jpg").getImage().getScaledInstance(450, 750, Image.SCALE_SMOOTH));
        backgroundLogin.setIcon(icon);
        background.add(backgroundLogin);
        
        panel = new JPanel();
        panel.setBounds(40,100,350,450);
        panel.setLayout(null);
        panel.setOpaque(false);
        
        judul = new JLabel("DIREKTORAT IMIGRASI");
        judul.setForeground(Color.WHITE);
        judul.setFont(new Font("Calibri",Font.BOLD,18));
        judul.setBounds(85,-40,200,100);
        
        lgoGaruda = new JLabel();
        iconGaruda = new ImageIcon(new ImageIcon("img/garuda.png").getImage().getScaledInstance(100,100,Image.SCALE_SMOOTH));
        lgoGaruda.setIcon(iconGaruda);
        lgoGaruda.setBounds(0,30,100,100);
         
        lgoImigrasi = new JLabel();
        iconImigrasi = new ImageIcon(new ImageIcon("img/Imigrasi.png").getImage().getScaledInstance(100,100,Image.SCALE_SMOOTH));
        lgoImigrasi.setIcon(iconImigrasi);
        lgoImigrasi.setBounds(250,30,100,100);
        
        panel.add(judul);
        panel.add(lgoGaruda);
        panel.add(lgoImigrasi);
        add(panel);
        
        panel1 = new JPanel();
        panel1.setBounds(50, 250, 330, 450);
        panel1.setOpaque(true);
        add(panel1);
        panel1.setLayout(null);
        
        
        username = new JLabel();
        username.setText("Username");
        username.setFont(new Font("",Font.BOLD,15));
        username.setBounds(50, 20, 80, 20);
        panel1.add(username);
        
        usernama = new JTextField();
        usernama.setBounds(30, 50, 250, 30);
        panel1.add(usernama);
        
        password = new JLabel("Password");
        password.setBounds(50, 100, 80, 20);
        password.setFont(new Font("",Font.BOLD,15));
        panel1.add(password);
        
        pass = new JPasswordField();
        pass.setBounds(30, 130, 250, 30);
        panel1.add(pass);
        
        signIn = new JButton("Sign In");
        signIn.setBounds(50, 190, 200, 40);
        signIn.addActionListener(new AbstractAction(){
            @Override
            public void actionPerformed(ActionEvent su){
                String pa = String.valueOf(pass.getPassword());
                Controller.logIn(usernama.getText(), pa);
                setVisible(false);
                
            }
        });
        panel1.add(signIn);
        register = new JButton("Register");
        register.setBounds(50, 260, 200, 40);
        register.addActionListener(new AbstractAction(){
            @Override
            public void actionPerformed(ActionEvent su){
                Register rg = new Register();
                rg.setVisible(true);
                setVisible(false);
            }
        });
        panel1.add(register);
        
        setVisible(true);
        add(background);
        
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