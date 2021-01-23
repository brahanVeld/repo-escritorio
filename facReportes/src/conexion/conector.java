/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package conexion;



import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import java.sql.*;
import java.util.ArrayList;
import javax.swing.JComboBox;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import org.mariadb.jdbc.*;


/**
 *
 * @author Abrahán
 */


public class conector {
  public  Connection conexion;
  direccion _direccion= new direccion();
  Statement st=null;
  ResultSet rs=null;
 
  /**
   * 
   * @return 
   */
    public Connection mariaDB(){
        Connection link=null;
      try {
          Class.forName("org.mariadb.jdbc.Driver");
          String contrasenia=_direccion.leerContrasenia();
          System.out.println(""+contrasenia);
          conexion=DriverManager.getConnection("jdbc:mariadb://"+_direccion.leerArchivoDireccion()+":3306/redsoft?useSSL=false&useUnicode=true&characterEncoding=utf-8","red",""+contrasenia);
          link=conexion;
      } catch (ClassNotFoundException ex) {
          Logger.getLogger(conector.class.getName()).log(Level.SEVERE, null, ex);
           JOptionPane.showMessageDialog(null, "¡Error en la conexión!");
      } catch (SQLException ex) {
          Logger.getLogger(conector.class.getName()).log(Level.SEVERE, null, ex);
           JOptionPane.showMessageDialog(null, "¡Error en la conexión!");
      }
       return link; 
    }
    
   /***
    * Método que no devuelve nada. Actualiza la información de la base de datos
    * sintaxis "insert into basededatos.tabla values(campo1, campo 2,... campo n);
    * 
    * @param sql 
    */
   public void update(String sql){
      try{
          st=  (Statement) conexion.createStatement();
          st.executeUpdate(sql);
        //  this.mariaDB();
          
      }catch(Exception e){
          e.getMessage();
          JOptionPane.showMessageDialog(null, "Varifica los datos a introducir");
      }
       
   }
   
   public void cerrarConeccion(){
      try {
          conexion.close();
      } catch (SQLException ex) {
          Logger.getLogger(conector.class.getName()).log(Level.SEVERE, null, ex);
      }
   }
  
   /**
    * Metodo para hacer una consulta sobre un dato y saber si está existe
    * @param sql será un select condicionado, respetando la sintaxis sql
    * @return true si el dato existe y false si no existe.
    */
   public boolean verificarDato(String sql){
         boolean dato=false;
       try {
          
            
            st= (Statement) conexion.createStatement();
            rs=st.executeQuery(sql);
            if(rs.next()){
                dato=true;
            }else{
                dato=false;
            }
            
           
        } catch (SQLException ex) {
            Logger.getLogger(conector.class.getName()).log(Level.SEVERE, null, ex);
        }
        return dato;
   }
   /**
    * Error: C3Con
    * 
    * Metodo para obtener información de alguna tabla
    * @param sql sentencia que respeta la sintaxis para las consultas: "select [celda, celda_N] from cendi.tabla [where celda=condicion]
    * @return una cadena de texto con la consulta
    */
   public String devolverDato(String sql,String columna){
       String dato="";
       try {
            
            
            st=(Statement) conexion.createStatement();
            rs=st.executeQuery(sql);
            if(rs.next()){
                dato=rs.getString(columna);
            }else{
                dato="No se encontro información";
            }
            
            
            
           
        } catch (SQLException ex) {
            Logger.getLogger(conector.class.getName()).log(Level.SEVERE, null, ex);
            JOptionPane.showMessageDialog(null, "Ocurrio un error \n Error: C3Con");
        }
        return dato;
   }
   
   
    public DefaultTableModel estructurarTabla(String sql){
        DefaultTableModel model= new DefaultTableModel();
        
      try {
          st=(Statement) conexion.createStatement();
          rs=st.executeQuery(sql);
          ResultSetMetaData metadatos= rs.getMetaData();
          int numeroColumnas=metadatos.getColumnCount();
          Object [] etiquetas= new Object[numeroColumnas];
          for(int i=0; i<numeroColumnas;i++){
              etiquetas[i]= metadatos.getColumnLabel(i+1);
          }
          model.setColumnIdentifiers(etiquetas);
          
          while(rs.next()){
              Object[]datosFila= new Object[model.getColumnCount()];
              for(int i=0; i<model.getColumnCount();i++){
                  datosFila[i]=rs.getObject(i+1);
              }
              model.addRow(datosFila);
          }
          
      } catch (SQLException ex) {
          Logger.getLogger(conector.class.getName()).log(Level.SEVERE, null, ex);
          JOptionPane.showMessageDialog(null,"Problema al mostrar la información en la tabla");
      }
      
      return model;
       
        
        
    }
        
        
        
    
    
    
    
}
