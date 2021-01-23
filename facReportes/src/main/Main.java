/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package main;

import conexion.direccion;
import interfaz.loging;
import java.io.IOException;

/**
 *
 * @author Abrahán
 */
public class Main {
    public static void main(String []args) throws IOException{
        direccion _direccion= new direccion();
        loging _loging= new loging();
        
        if(_direccion.leerArchivoDireccion().isEmpty()){
            _direccion.escribirDireccion();
           // if(!_direccion.leerArchivoDireccion().isEmpty()){
               _loging.setVisible(true);
            //}
        }else{
            _loging.setVisible(true);
        }
        
        
    }
    
    
    
    
    
}
