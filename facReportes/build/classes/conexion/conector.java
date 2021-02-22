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
import java.util.Calendar;
import java.util.GregorianCalendar;
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
           cerrarConeccion();
           System.exit(0);
      } catch (SQLException ex) {
          Logger.getLogger(conector.class.getName()).log(Level.SEVERE, null, ex);
           JOptionPane.showMessageDialog(null, "¡Error en la conexión!");
           cerrarConeccion();
           System.exit(0);
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
          System.out.println(""+sql);
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
   
   
   
   /***
    * metodo para unificar los resportes en uno solo a partir de una fecha dada,
    * deben de coincidir el id del cliente, poliza, revisado y procesado además de tener marcada la banderilla 
    * de unificado.
    * @param fecha 
    */
   
   public void reporteGlobal(String fecha){
      try {
          
          
          st=(Statement) conexion.createStatement();
          rs=st.executeQuery("select distinct (idCliente) from reportes where unificado=1 and fecha>='"+fecha+"' and macrop=0");
          ResultSet rsaux=null;
          if(!rs.last()){////valido que haya más de un id de cliente
          ///comienza while
          while(rs.next()){
              String minuto="";
             rsaux=st.executeQuery("select sum(tiempoTrabajo) as total from reportes where unificado=1 and fecha>='"+fecha+"' and idCliente='"+rs.getString("idCliente")+"' and macrop=0");
             if(rsaux.next()){
                 minuto=rsaux.getString("total");
             }
             String servicio="";
             rsaux=st.executeQuery("select fecha, servicioRealizado  from reportes where unificado=1 and fecha>='"+fecha+"' and idCliente='"+rs.getString("idCliente")+"'");
             while(rsaux.next()){
                 servicio+=rsaux.getString("fecha")+"\n"+rsaux.getString("servicioRealizado")+"\n";
             }
             
             st.executeUpdate("insert into reportes(fecha,horaInicio,idCliente, poliza,personas,asesor,persona, tiempoTrabajo,"
                     + " servicioRealizado,materiales, revisado,idUsuario,nomCliente, procesado,unificado)"
                     + " values('"+fecha()+"','00:00','"+rs.getString("idCliente")+"',1,'','GLOBAL','',"+minuto+",'"+servicio+"','',1,'01','nombreCliente',1,0)");
              
          }///termina while
          }
      } catch (SQLException ex) {
          Logger.getLogger(conector.class.getName()).log(Level.SEVERE, null, ex);
      }
       
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
         // boolean isCellEditable(){
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
    
    
    String fecha(){
        String fecha="";
        
        Calendar date=new GregorianCalendar();
        int año=date.get(Calendar.YEAR);
        int mes=date.get(Calendar.MONTH);
        int dia=date.get(Calendar.DAY_OF_MONTH);
        
        fecha=""+año+"-"+(mes+1)+"-"+dia;
        
        return fecha;
    }
        
        
        
    
    
    
    
}
