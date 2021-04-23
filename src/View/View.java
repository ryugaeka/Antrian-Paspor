/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package View;

import Model.*;
import java.util.*;

/**
 *
 * @author Reynold
 */
public class View {
//    private FormPermohonan form = new FormPermohonan();
//    
    public View(){
        ArrayList<Kantor> listKantor = new ArrayList();
        
        Kantor lokasi1 = new Kantor("Kantor Imigrasi Bandung","Jl. Surapati No.82");
        Kantor lokasi2 = new Kantor("UKK Cianjur","Jl. Raya Bandung No. 61");
        Kantor lokasi3 = new Kantor("ULP Bandung","Unit Layanan Paspor, Gedung Binacitra, Lantai 3, Jl. Soekarno-Hatta No.162");
        
        listKantor.add(lokasi1);
        listKantor.add(lokasi2);
        listKantor.add(lokasi3);
        
        new Login().setVisible(true);
        
    }
}
