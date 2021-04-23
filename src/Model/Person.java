/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Model;

/**
 *
 * @author Reynold
 */
abstract public class Person {
    protected String NIK;
    protected String namaLengkap;
    protected String noTelp;

    public Person(String NIK, String namaLengkap, String noTelp) {
        this.NIK = NIK;
        this.namaLengkap = namaLengkap;
        this.noTelp = noTelp;
    }
    
    public Person(){
        
    }
    abstract void Daftar();
}

