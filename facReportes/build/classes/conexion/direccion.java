/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package conexion;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;

/**
 *Clase que crea un archivo txt para almacenar la dirección del servidor
 * Además crea otro archivo por separado para guardar la contraseña de la base de datos
 * @author Abrahán
 */
public class direccion {
    public String direccion="", pasw="";
    
    
 public direccion(){
     if(this.leerArchivoDireccion().isEmpty()||this.leerContrasenia().isEmpty()){
         try {
             escribirDireccion();
         } catch (IOException ex) {
             Logger.getLogger(direccion.class.getName()).log(Level.SEVERE, null, ex);
         }
     }
    
    
 }
    
   
      
    /**
     * Metodo que no devuelve nada.
     * Se crea el archivo pikachu.txt para almacenar la dirección ip del servidor
     */
    public void escribirDireccion() throws IOException{
          File archivoDireccion= new File("src/txt/pikachu.txt");
    File archivoContrasenia= new File("src/txt/pokebola.txt");
 archivoDireccion.createNewFile();
            archivoContrasenia.createNewFile();
        BufferedWriter escribir;
        if(archivoDireccion.exists()){
            try {
                escribir= new BufferedWriter(new FileWriter("src/txt/pikachu.txt"));
                String direccion= JOptionPane.showInputDialog(null,"Introduce la dirección de tu base de datos: ");
                escribir.write(direccion);
                escribir.close();
                if(direccion.isEmpty()){
                    System.exit(0);
                }
            } catch (IOException ex) {
                Logger.getLogger(direccion.class.getName()).log(Level.SEVERE, null, ex);
            }
        }else{
            archivoDireccion.createNewFile();
        }
        if(archivoContrasenia.exists()){
            try {
                escribir = new BufferedWriter(new FileWriter("src/txt/pokebola.txt"));
               String pasw=JOptionPane.showInputDialog(null,"Introduce la contraseña de tu base de datos: ");
                escribir.write(pasw);
                escribir.close();
                
               
                
            } catch (IOException ex) {
                Logger.getLogger(direccion.class.getName()).log(Level.SEVERE, null, ex);
            }
        }else {
            
            archivoContrasenia.createNewFile();
        }
        
        
    }
    
    
    public String leerArchivoDireccion(){
          //File archivoDireccion= new File("pikachu.txt");
   

        String direccion1="";
        String direccion2="";
        BufferedReader br= null;
        FileReader direccionip=null;
        
        //this.escribirDireccion();
        try {
            direccionip=new FileReader("src/txt/pikachu.txt");
            br=new BufferedReader(direccionip);
            while((direccion1=br.readLine())!=null){
                direccion2=direccion1;
            }
            
            
        } catch (FileNotFoundException ex) {
            Logger.getLogger(direccion.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IOException ex) {
            Logger.getLogger(direccion.class.getName()).log(Level.SEVERE, null, ex);
        }finally{
            if(null!=direccionip){
                try {
                    direccionip.close();
                } catch (IOException ex) {
                    Logger.getLogger(direccion.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        }
      return direccion2; 
        
    }
    
    public String leerContrasenia(){
       //  File archivoDireccion= new File("pikachu.txt");
        String contrasenia="";
        BufferedReader br= null;
        FileReader direccionip=null;
       // this.escribirDireccion();
        try {
            direccionip=new FileReader("src/txt/pokebola.txt");
            br=new BufferedReader(direccionip);
            String aux="";
            while((aux=br.readLine())!=null){
                contrasenia=aux;
            }
            
            
        } catch (FileNotFoundException ex) {
            Logger.getLogger(direccion.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IOException ex) {
            Logger.getLogger(direccion.class.getName()).log(Level.SEVERE, null, ex);
        }finally{
            if(null!=direccionip){
                try {
                    direccionip.close();
                } catch (IOException ex) {
                    Logger.getLogger(direccion.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        }
        return contrasenia;
        
    }
    
    
    /***
     * guardo el nombre del usuario en un archivo de texto para su posterior uso
     * @param usuario
     * @throws IOException 
     */
    public void guardarUsuario(String usuario) throws IOException{
              File archivoNombre= new File("src/txt/tu.txt");
   
                archivoNombre.createNewFile();
           // archivoContrasenia.createNewFile();
        BufferedWriter escribir;
        if(archivoNombre.exists()){
            try {
                escribir= new BufferedWriter(new FileWriter("src/txt/tu.txt"));
                //String direccion= JOptionPane.showInputDialog(null,"Introduce la dirección de tu base de datos: ");
                escribir.write(usuario);
                escribir.close();
                
            } catch (IOException ex) {
                Logger.getLogger(direccion.class.getName()).log(Level.SEVERE, null, ex);
            }
        }else if(!archivoNombre.exists()){
            archivoNombre.createNewFile();
            
        }
        
        
    }
    
    /**
     * Metodo para guardar el rol del usuario
     * @param usuario
     * @throws IOException 
     */
    public void guardarRol(String usuario) throws IOException{
              File archivoNombre= new File("src/txt/poe.txt");
   
                archivoNombre.createNewFile();
           // archivoContrasenia.createNewFile();
        BufferedWriter escribir;
        if(archivoNombre.exists()){
            try {
                escribir= new BufferedWriter(new FileWriter("src/txt/poe.txt"));
                //String direccion= JOptionPane.showInputDialog(null,"Introduce la dirección de tu base de datos: ");
                escribir.write(usuario);
                escribir.close();
                
            } catch (IOException ex) {
                Logger.getLogger(direccion.class.getName()).log(Level.SEVERE, null, ex);
            }
        }else if(!archivoNombre.exists()){
            archivoNombre.createNewFile();
            
        }
        
        
    }
    
    
     public String leerRol(){
       //  File archivoDireccion= new File("pikachu.txt");
        String contrasenia="";
        BufferedReader br= null;
        FileReader direccionip=null;
       // this.escribirDireccion();
        try {
            direccionip=new FileReader("src/txt/poe.txt");
            br=new BufferedReader(direccionip);
            String aux="";
            while((aux=br.readLine())!=null){
                contrasenia=aux;
            }
            
            
        } catch (FileNotFoundException ex) {
            Logger.getLogger(direccion.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IOException ex) {
            Logger.getLogger(direccion.class.getName()).log(Level.SEVERE, null, ex);
        }finally{
            if(null!=direccionip){
                try {
                    direccionip.close();
                } catch (IOException ex) {
                    Logger.getLogger(direccion.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        }
        return contrasenia;
        
    }
    
    /**
     * Metodo para guardar el id de un reporte a modificar
     * @param idReporte
     * @throws IOException 
     */
    public void guardaridReporte(String idReporte) throws IOException{
              File archivoNombre= new File("src/txt/grimes.txt");
   
                archivoNombre.createNewFile();
           // archivoContrasenia.createNewFile();
        BufferedWriter escribir;
        if(archivoNombre.exists()){
            try {
                escribir= new BufferedWriter(new FileWriter("src/txt/grimes.txt"));
                //String direccion= JOptionPane.showInputDialog(null,"Introduce la dirección de tu base de datos: ");
                escribir.write(idReporte);
                escribir.close();
                
            } catch (IOException ex) {
                Logger.getLogger(direccion.class.getName()).log(Level.SEVERE, null, ex);
            }
        }else if(!archivoNombre.exists()){
            archivoNombre.createNewFile();
            
        }
        
        
    }
    
     public String leerUsuario(){
       //  File archivoDireccion= new File("pikachu.txt");
        String contrasenia="";
        BufferedReader br= null;
        FileReader direccionip=null;
       // this.escribirDireccion();
        try {
            direccionip=new FileReader("src/txt/tu.txt");
            br=new BufferedReader(direccionip);
            String aux="";
            while((aux=br.readLine())!=null){
                contrasenia=aux;
            }
            
            
        } catch (FileNotFoundException ex) {
            Logger.getLogger(direccion.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IOException ex) {
            Logger.getLogger(direccion.class.getName()).log(Level.SEVERE, null, ex);
        }finally{
            if(null!=direccionip){
                try {
                    direccionip.close();
                } catch (IOException ex) {
                    Logger.getLogger(direccion.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        }
        return contrasenia;
        
    }
    
    
    public String leeridReporte(){
       //  File archivoDireccion= new File("pikachu.txt");
        String contrasenia="";
        BufferedReader br= null;
        FileReader direccionip=null;
       // this.escribirDireccion();
        try {
            direccionip=new FileReader("src/txt/grimes.txt");
            br=new BufferedReader(direccionip);
            String aux="";
            while((aux=br.readLine())!=null){
                contrasenia=aux;
            }
            
            
        } catch (FileNotFoundException ex) {
            Logger.getLogger(direccion.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IOException ex) {
            Logger.getLogger(direccion.class.getName()).log(Level.SEVERE, null, ex);
        }finally{
            if(null!=direccionip){
                try {
                    direccionip.close();
                } catch (IOException ex) {
                    Logger.getLogger(direccion.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        }
        return contrasenia;
        
    }
    
    
     public String poliza(){
     String contrasenia="";
        BufferedReader br= null;
        FileReader direccionip=null;
       // this.escribirDireccion();
        try {
            direccionip=new FileReader("src/txt/poliza.txt");
            br=new BufferedReader(direccionip);
            String aux="";
            while((aux=br.readLine())!=null){
                contrasenia=aux;
            }
            
            
        } catch (FileNotFoundException ex) {
            Logger.getLogger(direccion.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IOException ex) {
            Logger.getLogger(direccion.class.getName()).log(Level.SEVERE, null, ex);
        }finally{
            if(null!=direccionip){
                try {
                    direccionip.close();
                } catch (IOException ex) {
                    Logger.getLogger(direccion.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        }
        return contrasenia;
}

     public String persona(){
     String contrasenia="";
        BufferedReader br= null;
        FileReader direccionip=null;
       // this.escribirDireccion();
        try {
            direccionip=new FileReader("src/txt/persona.txt");
            br=new BufferedReader(direccionip);
            String aux="";
            while((aux=br.readLine())!=null){
                contrasenia=aux;
            }
            
            
        } catch (FileNotFoundException ex) {
            Logger.getLogger(direccion.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IOException ex) {
            Logger.getLogger(direccion.class.getName()).log(Level.SEVERE, null, ex);
        }finally{
            if(null!=direccionip){
                try {
                    direccionip.close();
                } catch (IOException ex) {
                    Logger.getLogger(direccion.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        }
        return contrasenia;
}
     
      public String asesor(){
     String contrasenia="";
        BufferedReader br= null;
        FileReader direccionip=null;
       // this.escribirDireccion();
        try {
            direccionip=new FileReader("src/txt/asesor.txt");
            br=new BufferedReader(direccionip);
            String aux="";
            while((aux=br.readLine())!=null){
                contrasenia=aux;
            }
            
            
        } catch (FileNotFoundException ex) {
            Logger.getLogger(direccion.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IOException ex) {
            Logger.getLogger(direccion.class.getName()).log(Level.SEVERE, null, ex);
        }finally{
            if(null!=direccionip){
                try {
                    direccionip.close();
                } catch (IOException ex) {
                    Logger.getLogger(direccion.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        }
        return contrasenia;
}
     
      public String tiempo(){
     String contrasenia="";
        BufferedReader br= null;
        FileReader direccionip=null;
       // this.escribirDireccion();
        try {
            direccionip=new FileReader("src/txt/tiempo.txt");
            br=new BufferedReader(direccionip);
            String aux="";
            while((aux=br.readLine())!=null){
                contrasenia=aux;
            }
            
            
        } catch (FileNotFoundException ex) {
            Logger.getLogger(direccion.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IOException ex) {
            Logger.getLogger(direccion.class.getName()).log(Level.SEVERE, null, ex);
        }finally{
            if(null!=direccionip){
                try {
                    direccionip.close();
                } catch (IOException ex) {
                    Logger.getLogger(direccion.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        }
        return contrasenia;
}
      
      
      public String servicio(){
     String contrasenia="";
        BufferedReader br= null;
        FileReader direccionip=null;
       // this.escribirDireccion();
        try {
            direccionip=new FileReader("/txt/servicio.txt");
            br=new BufferedReader(direccionip);
            String aux="";
            while((aux=br.readLine())!=null){
                contrasenia+=aux+"\n";
            }
            
            
        } catch (FileNotFoundException ex) {
            Logger.getLogger(direccion.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IOException ex) {
            Logger.getLogger(direccion.class.getName()).log(Level.SEVERE, null, ex);
        }finally{
            if(null!=direccionip){
                try {
                    direccionip.close();
                } catch (IOException ex) {
                    Logger.getLogger(direccion.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        }
        return contrasenia;
}
     /**
      * metodo que regresa el contenido sobre los materiales y/o obervaciones 
      * @return 
      */
      
       public String materiales(){
     String contrasenia="";
        BufferedReader br= null;
        FileReader direccionip=null;
       // this.escribirDireccion();
        try {
            direccionip=new FileReader("/txt/materiales.txt");
            br=new BufferedReader(direccionip);
            String aux="";
            while((aux=br.readLine())!=null){
                contrasenia+=aux+"\n";
            }
            
            
        } catch (FileNotFoundException ex) {
            Logger.getLogger(direccion.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IOException ex) {
            Logger.getLogger(direccion.class.getName()).log(Level.SEVERE, null, ex);
        }finally{
            if(null!=direccionip){
                try {
                    direccionip.close();
                } catch (IOException ex) {
                    Logger.getLogger(direccion.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        }
        return contrasenia;
}
     
     
     
      public void guardarCliente(String usuario) throws IOException{
              File archivoNombre= new File("/txt/idInicio.txt");
   
                archivoNombre.createNewFile();
           // archivoContrasenia.createNewFile();
        BufferedWriter escribir;
        if(archivoNombre.exists()){
            try {
                escribir= new BufferedWriter(new FileWriter("/txt/idInicio.txt"));
                //String direccion= JOptionPane.showInputDialog(null,"Introduce la dirección de tu base de datos: ");
                escribir.write(usuario);
                escribir.close();
                
            } catch (IOException ex) {
                Logger.getLogger(direccion.class.getName()).log(Level.SEVERE, null, ex);
            }
        }else if(!archivoNombre.exists()){
            archivoNombre.createNewFile();
            
        }
        
        
    }
     
     
    /**
     * Método para almacenar la información sobre un pedido a medio concluir
     * en caso de no meter alguno de los parametros mandar una cadena vacía
     * @param fecha 
     * @param horaInicio
     * @param poliza
     * @param persona
     * @param otroAsesor
     * @param tiempoTrabajo
     * @param ServiciosRealizados
     * @param materiales
     * @throws IOException 
     */
    public void guardarReporte(String fecha, String horaInicio, String poliza, String persona,
            String otroAsesor, String tiempoTrabajo, String ServiciosRealizados, String materiales) throws IOException{
         File fecha1= new File("/txt/fecha.txt");
         File horaInicio1= new File("/txt/horaInicio.txt");
         //File idCliente1= new File("idInicio.txt");
         File poliza1= new File("/txt/poliza.txt");
         File person1= new File("/txt/persona.txt");
         File asesor= new File("/txt/asesor.txt");
         File tiempo= new File("/txt/tiempo.txt");
         File servicio= new File("/txt/servicio.txt");
         File materiales1= new File("/txt/materiales.txt");
         
         fecha1.createNewFile();
         horaInicio1.createNewFile();
        // idCliente1.createNewFile();
         poliza1.createNewFile();
         person1.createNewFile();
         asesor.createNewFile();
         tiempo.createNewFile();
         servicio.createNewFile();
         materiales1.createNewFile();
         
         BufferedWriter escribir;
         
         if(fecha1.exists()){
             escribir = new BufferedWriter(new FileWriter("/txt/fecha.txt"));
             escribir.write(fecha);
             escribir.close();
         }else{
             fecha1.createNewFile();
         }
         if(horaInicio1.exists()){
             escribir = new BufferedWriter(new FileWriter("/txt/horaInicio.txt"));
             escribir.write(horaInicio);
             escribir.close();
         }else{
             horaInicio1.createNewFile();
         }
         /*
         if(idCliente1.exists()){
             escribir = new BufferedWriter(new FileWriter("idInicio.txt"));
             escribir.write(idCliente);
             escribir.close();
         }else{
             idCliente1.createNewFile();
         }
         */
         if(poliza1.exists()){
             escribir = new BufferedWriter(new FileWriter("/txt/poliza.txt"));
             escribir.write(poliza);
             escribir.close();
         }else{
             poliza1.createNewFile();
         }
         if(person1.exists()){
             escribir = new BufferedWriter(new FileWriter("/txt/persona.txt"));
             escribir.write(persona);
             escribir.close();
         }else{
             person1.createNewFile();
         }
         if(asesor.exists()){
             escribir = new BufferedWriter(new FileWriter("/txt/asesor.txt"));
             escribir.write(otroAsesor);
             escribir.close();
         }else{
             asesor.createNewFile();
         }
         if(tiempo.exists()){
             escribir = new BufferedWriter(new FileWriter("/txt/tiempo.txt"));
             escribir.write(tiempoTrabajo);
             escribir.close();
         }else{
             tiempo.createNewFile();
         }
         if(servicio.exists()){
             escribir = new BufferedWriter(new FileWriter("/txt/servicio.txt"));
             escribir.write(ServiciosRealizados);
             escribir.close();
         }else{
             servicio.createNewFile();
         }
         if(materiales1.exists()){
             escribir = new BufferedWriter(new FileWriter("/txt/materiales.txt"));
             escribir.write(materiales);
             escribir.close();
         }else{
             materiales1.createNewFile();
         }
         
        
         
        
    }

       
public String leerfecha(){
     String contrasenia="";
        BufferedReader br= null;
        FileReader direccionip=null;
       // this.escribirDireccion();
        try {
            direccionip=new FileReader("/txt/fecha.txt");
            br=new BufferedReader(direccionip);
            String aux="";
            while((aux=br.readLine())!=null){
                contrasenia=aux;
            }
            
            
        } catch (FileNotFoundException ex) {
            Logger.getLogger(direccion.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IOException ex) {
            Logger.getLogger(direccion.class.getName()).log(Level.SEVERE, null, ex);
        }finally{
            if(null!=direccionip){
                try {
                    direccionip.close();
                } catch (IOException ex) {
                    Logger.getLogger(direccion.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        }
        return contrasenia;
}
    
    
public String horaInicio(){
     String contrasenia="";
        BufferedReader br= null;
        FileReader direccionip=null;
       // this.escribirDireccion();
        try {
            direccionip=new FileReader(""
                    + "/txt/horaInicio.txt");
            br=new BufferedReader(direccionip);
            String aux="";
            while((aux=br.readLine())!=null){
                contrasenia=aux;
            }
            
            
        } catch (FileNotFoundException ex) {
            Logger.getLogger(direccion.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IOException ex) {
            Logger.getLogger(direccion.class.getName()).log(Level.SEVERE, null, ex);
        }finally{
            if(null!=direccionip){
                try {
                    direccionip.close();
                } catch (IOException ex) {
                    Logger.getLogger(direccion.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        }
        return contrasenia;
}
  /**
   * metodo para leer el id del cliente almacenado
   * @return 
   */
    public String idCliente(){
     String contrasenia="";
        BufferedReader br= null;
        FileReader direccionip=null;
       // this.escribirDireccion();
        try {
            direccionip=new FileReader("/txt/idInicio.txt");
            br=new BufferedReader(direccionip);
            String aux="";
            while((aux=br.readLine())!=null){
                contrasenia=aux;
            }
            
            
        } catch (FileNotFoundException ex) {
            Logger.getLogger(direccion.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IOException ex) {
            Logger.getLogger(direccion.class.getName()).log(Level.SEVERE, null, ex);
        }finally{
            if(null!=direccionip){
                try {
                    direccionip.close();
                } catch (IOException ex) {
                    Logger.getLogger(direccion.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        }
        return contrasenia;
}
    /**
     * Metodo para guardar el nombre del cliente
     * @param cliente descripción del cliente
     * @throws IOException 
     */
    public void getcliente(String cliente) throws IOException{
        File archivoNombre= new File("/txt/cliente.txt");
   
                archivoNombre.createNewFile();
           // archivoContrasenia.createNewFile();
        BufferedWriter escribir;
        if(archivoNombre.exists()){
            try {
                escribir= new BufferedWriter(new FileWriter("/txt/cliente.txt"));
                //String direccion= JOptionPane.showInputDialog(null,"Introduce la dirección de tu base de datos: ");
                escribir.write(cliente);
                escribir.close();
                
            } catch (IOException ex) {
                Logger.getLogger(direccion.class.getName()).log(Level.SEVERE, null, ex);
            }
        }else if(!archivoNombre.exists()){
            archivoNombre.createNewFile();
            
        }
    }
    
    /**
     * Método para obtener el nombre o descripción del cliente
     * @return un string con la descripción del cliente
     */
    public String setcliente(){
     String contrasenia="";
        BufferedReader br= null;
        FileReader direccionip=null;
       // this.escribirDireccion();
        try {
            direccionip=new FileReader("/txt/cliente.txt");
            br=new BufferedReader(direccionip);
            String aux="";
            while((aux=br.readLine())!=null){
                contrasenia=aux;
            }
            
            
        } catch (FileNotFoundException ex) {
            Logger.getLogger(direccion.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IOException ex) {
            Logger.getLogger(direccion.class.getName()).log(Level.SEVERE, null, ex);
        }finally{
            if(null!=direccionip){
                try {
                    direccionip.close();
                } catch (IOException ex) {
                    Logger.getLogger(direccion.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        }
        return contrasenia;
}
    
    
    
}



