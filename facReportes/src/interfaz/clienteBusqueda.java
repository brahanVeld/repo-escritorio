/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package interfaz;

import conexion.conector;
import conexion.direccion;
import dom.accederFactura;
import dom.datosFactura;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.ImageIcon;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author Abrahán
 */
public class clienteBusqueda extends javax.swing.JFrame {

    conector _conexion= new conector();
    /**
     * Creates new form clienteBusqueda
     */
    public clienteBusqueda() {
        initComponents();
        try {
            setIconImage(new ImageIcon(getClass().getResource("/img/LOGO2chiquito.png")).getImage());
        } catch (Exception ex) {
        }
      //  clientes(idCliente);
      clientes();
        jTable1.getTableHeader().setReorderingAllowed(false);
        selecionarFila();
       
    }
 
    
    
    String idCliente2="", cliente="";
   // int fila=0;
    void selecionarFila(){
        this.jTable1.getSelectionModel().addListSelectionListener(new ListSelectionListener() {
            @Override
            public void valueChanged(ListSelectionEvent arg0) {
               if(jTable1.getSelectedRow()!=-1){
                   //limpiar(_datos);
                  int fila=jTable1.getSelectedRow();
                   idCliente2=String.valueOf(jTable1.getValueAt(fila, 0));
                   cliente=String.valueOf(jTable1.getValueAt(fila, 1));
                 //  guardar(_datos, idCliente2);
                 
                 //  limpiar(_datos);
              
               } 
                
                
               // throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
            }
        });
    }
    
    
    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jScrollPane1 = new javax.swing.JScrollPane();
        jTable1 = new javax.swing.JTable();
        jButton1 = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Catalogo clientes");

        jScrollPane1.setEnabled(false);

        jTable1.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null}
            },
            new String [] {
                "Title 1", "Title 2"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jTable1.getTableHeader().setReorderingAllowed(false);
        jTable1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jTable1MouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(jTable1);

        jButton1.setText("Regresar");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jButton1)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 934, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(0, 0, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 379, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jButton1))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    direccion _direccion= new direccion();
    
    
    private void jTable1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jTable1MouseClicked
        // TODO add your handling code here:
        if(evt.getClickCount()==1){
            try {
                _direccion.guardarCliente(idCliente2);
                _direccion.getcliente(cliente);
                limpiar(_datos);
                
                reporte _reporte;
                
                _reporte= new reporte();
                _reporte.setVisible(true);
                dispose();
            } catch (IOException ex) {
                Logger.getLogger(clienteBusqueda.class.getName()).log(Level.SEVERE, null, ex);
            }
           
        }
        
       
        
    }//GEN-LAST:event_jTable1MouseClicked

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        // TODO add your handling code here:
        limpiar(_datos);
                
                reporte _reporte;
                
                _reporte= new reporte();
                _reporte.setVisible(true);
                dispose();
        
        
    }//GEN-LAST:event_jButton1ActionPerformed
///abcdefghijklmnopqrstuvwxyz
    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(clienteBusqueda.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(clienteBusqueda.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(clienteBusqueda.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(clienteBusqueda.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new clienteBusqueda().setVisible(true);
            }
        });
    }
    
    DefaultTableModel tablaAux= new DefaultTableModelImpl();
   // direccion _direccion = new direccion();
    datosFactura _datos= new datosFactura() ;
    void clientes(){
        this._conexion.mariaDB();
        String dato="";
        dato=ver(_datos);
        System.out.println("id Cliente "+dato);
        if(!dato.isEmpty()){
        String sql="select ClientId, Description from clients where ClientId like '%"+dato+"%' or Description like '%"+dato+"%'";
        tablaAux=this._conexion.estructurarTabla(sql);
        this.jTable1.setModel(tablaAux);
        this.jScrollPane1.getViewport().add(this.jTable1);
        }else{
        String sql="select ClientId, Description from clients";
        tablaAux=this._conexion.estructurarTabla(sql);
        this.jTable1.setModel(tablaAux);
        
        
        this.jScrollPane1.getViewport().add(this.jTable1);
        
        
        }
        
        this._conexion.cerrarConeccion();
        
        
    }
    
    ////accedo al metodo para extraer la descripción del cliente
   static String ver(accederFactura f){
       String aux="";
       if(!f.getIdCliente().isEmpty()){
           aux=f.getIdCliente();
       }
       return aux;
   }
    
   ///guardo el id del cliente
     static void guardar(accederFactura f, String idCliente){
        f.setIdCliente(idCliente);
    }
    
     
     ///accedo al metodo para limpiar la variable
     static void limpiar(accederFactura f){
         f.limpiar();
     }
    

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButton1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable jTable1;
    // End of variables declaration//GEN-END:variables

    private static class DefaultTableModelImpl extends DefaultTableModel {

        public DefaultTableModelImpl() {
        }

        @Override
        public boolean isCellEditable(int row, int column){
            return false;
        }
    }
}
