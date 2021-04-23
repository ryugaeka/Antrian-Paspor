/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package View;

import Controller.Controller;
import java.awt.Image;
import java.awt.event.ActionEvent;
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
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author msj
 */
public class AdminAntrian extends JFrame{
    private JPanel panel;
    private JTable tableData;
    private ImageIcon icon;
    private JButton home;
    
    public AdminAntrian(){
        setLayout(null);
        setSize(600,500);
        setResizable(false);
        setLocationRelativeTo(null);
        setVisible(true);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        
        icon = new ImageIcon(resizeImage("img/home.png"));
        home = new JButton(icon);
        home.setBounds(0, 0, 30, 30);
        home.setBorder(null);
        home.setContentAreaFilled(false);
        home.addActionListener(new AbstractAction(){
            @Override
            public void actionPerformed(ActionEvent su){
                Admin a = new Admin();
                a.setVisible(true);
                setVisible(false);
                setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            }   

        });
        add(home);
        
        panel = new JPanel();
        panel.setBounds(30, 280, 150, 20);
        panel.setLayout(null);
        
        
        tableData = new JTable();
        DefaultTableModel model = new DefaultTableModel();
        Object[] columnName = new Object[6];
        
        columnName[0] = "kodeBooking";
        columnName[1] = "NamaKantor";
        columnName[2] = "Alamat";
        columnName[3] = "tglKedatangan";
        columnName[4] = "waktuKedatangan";
        columnName[5] = "NIK";
        model.setColumnIdentifiers(columnName);
        
        Object[] rowData = new Object[6];
        
        for (int i = 0; i < Controller.dataPemohon().size(); i++) {
            rowData[0] = Controller.dataPemohon().get(i).getKodeBooking();
            rowData[1] = Controller.dataPemohon().get(i).getTempat().getNama();
            rowData[2] = Controller.dataPemohon().get(i).getTempat().getAlamat();
            rowData[3] = Controller.dataPemohon().get(i).getTglKedatangan();
            rowData[4] = Controller.dataPemohon().get(i).getWaktuKedatangan();
            rowData[5] = Controller.dataPemohon().get(i).getNIK();
            model.addRow(rowData);
        }
        tableData.setModel(model);
        tableData.addMouseListener(new MouseAdapter(){
            @Override
            public void mouseClicked(MouseEvent me){
                String found = "";
                found = tableData.getValueAt(tableData.getSelectedRow(), tableData.getSelectedColumn()).toString();
                System.out.println(found);
                Controller.updateStatus(found);
                JOptionPane.showMessageDialog(null, "Antrian sudah terpanggil");
            }
        });
        JScrollPane pane = new JScrollPane(tableData);
        pane.setBounds(30, 100, 450, 150);
        pane.setOpaque(false);
        add(pane);
        add(panel);
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
