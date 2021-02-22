/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package interfaz;

import conexion.conector;
import conexion.direccion;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.io.IOException;
import java.util.Arrays;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.util.regex.Pattern;
import javax.swing.ImageIcon;
import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableModel;

/**
 *
 * @author Abrahán
 */
public class admin extends javax.swing.JFrame {
    conector _conexion=new conector();
    DefaultTableModel tablaAux= new DefaultTableModel();
    direccion _direccion= new direccion();
    infoClientes clientes= new infoClientes();

    /**
     * Creates new form admin
     */
    public admin() {
        initComponents();
        limpiar();
         try {
            setIconImage(new ImageIcon(getClass().getResource("/img/LOGO2chiquito.png")).getImage());
        } catch (Exception ex) {
        }
        //this.activo.disable();
       // activo.setVisible(false);
        //id.setVisible(false);
       // identificadorId.setVisible(false);
        CargarUsuarios();
       
        tablaUsuarios.getTableHeader().setReorderingAllowed(false);
        tablaReportes.getTableHeader().setReorderingAllowed(false);
          seleccionarFila();
          
        mostrarReportes();
        seleccionarReporte();
        buscarReporte.setText("");
        this.buscarCliente.setText("");
        cargarClientes();
        seleccionarCliente();
        
       
      //  this.tablaUsuarios= new JTable(new MyTableModel());
    }
    
    int ide=-1;
    void seleccionarCliente(){
        this.tablaInfoClientes.getSelectionModel().addListSelectionListener(new ListSelectionListener(){
           

            @Override
            public void valueChanged(ListSelectionEvent e) {
              if(tablaInfoClientes.getSelectedRow()!=-1){
                  int fila=tablaInfoClientes.getSelectedRow();
                  ide=(int) tablaInfoClientes.getValueAt(fila, 0);
                  
              }  
                
                
                
                //throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
            }
        });
    }

    
     void cargarClientes(){
        String tabla="select * from clientesInfo;";
        this._conexion.mariaDB();
        this.tablaInfoClientes= new javax.swing.JTable(this._conexion.estructurarTabla(tabla)){
            @Override
            public boolean isCellEditable(int row, int column){
                return false;
                
            }
        };
        this.jScrollPane4.getViewport().add(this.tablaInfoClientes);
        this._conexion.cerrarConeccion();
                
    }
    

    void limpiar(){
        this.nombre.setText("");
        this.erp.setText("");
        this.usuario.setText("");
        this.pasw1.setText("");
        this.pasw2.setText("");
        this.ruta.setText("");
        this.id.setText("");
        this.usuario.setEditable(true);
        
    }
   // int fila=0;
   // String id1,nombre1,erp1,usuario1,ruta1;
    void seleccionarFila(){
      //  if(this.jTabbedPane1.isEnabledAt(0)){
        
        tablaUsuarios.getSelectionModel().addListSelectionListener(new ListSelectionListener() {
            @Override
            public void valueChanged(ListSelectionEvent arg0) {
                //throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
                if(tablaUsuarios.getSelectedRow()!=-1){
                  int  fila=tablaUsuarios.getSelectedRow();
                  boolean activo1=(boolean) tablaUsuarios.getValueAt(fila, 7);
                  id.setText(tablaUsuarios.getValueAt(fila, 0).toString());
                  nombre.setText(tablaUsuarios.getValueAt(fila, 1).toString());
                  usuario.setText(tablaUsuarios.getValueAt(fila, 2).toString());
                  usuario.setEditable(false);
                  ruta.setText(tablaUsuarios.getValueAt(fila, 6).toString());
                  erp.setText(tablaUsuarios.getValueAt(fila, 5).toString());
                  rol.setSelectedItem(tablaUsuarios.getValueAt(fila, 4));
                  activo.setSelected(!activo1);
                }
            
            }
        });
        //}
    }
   // int idReporte=0;
    int ide2;
    void seleccionarReporte(){
        tablaReportes.getSelectionModel().addListSelectionListener(new ListSelectionListener() {
            @Override
            public void valueChanged(ListSelectionEvent arg0) {
           if(tablaReportes.getSelectedRow()!=-1){
               int fila=tablaReportes.getSelectedRow();
               String idReporte= tablaReportes.getValueAt(fila, 0).toString();
               ide2=(int)tablaReportes.getValueAt(fila, 0);
               try {
                   _direccion.guardaridReporte(idReporte);
               } catch (IOException ex) {
                   Logger.getLogger(admin.class.getName()).log(Level.SEVERE, null, ex);
               }
               
               
           }
                //throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
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

        jTabbedPane1 = new javax.swing.JTabbedPane();
        jPanel2 = new javax.swing.JPanel();
        jToolBar1 = new javax.swing.JToolBar();
        guardar = new javax.swing.JButton();
        jSeparator1 = new javax.swing.JToolBar.Separator();
        jButton2 = new javax.swing.JButton();
        jSeparator2 = new javax.swing.JToolBar.Separator();
        jButton3 = new javax.swing.JButton();
        jButton4 = new javax.swing.JButton();
        jSeparator8 = new javax.swing.JToolBar.Separator();
        jSeparator3 = new javax.swing.JToolBar.Separator();
        jButton8 = new javax.swing.JButton();
        jSeparator9 = new javax.swing.JToolBar.Separator();
        jLabel4 = new javax.swing.JLabel();
        buscar = new javax.swing.JTextField();
        jLabel1 = new javax.swing.JLabel();
        nombre = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();
        usuario = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        pasw1 = new javax.swing.JPasswordField();
        pasw2 = new javax.swing.JPasswordField();
        jLabel6 = new javax.swing.JLabel();
        rol = new javax.swing.JComboBox<>();
        jLabel7 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        erp = new javax.swing.JTextField();
        jLabel9 = new javax.swing.JLabel();
        ruta = new javax.swing.JTextField();
        activo = new javax.swing.JCheckBox();
        identificadorId = new javax.swing.JLabel();
        id = new javax.swing.JLabel();
        scrollUsuarios = new javax.swing.JScrollPane();
        tablaUsuarios = new javax.swing.JTable();
        jPanel4 = new javax.swing.JPanel();
        jToolBar2 = new javax.swing.JToolBar();
        jButton1 = new javax.swing.JButton();
        jSeparator4 = new javax.swing.JToolBar.Separator();
        jButton7 = new javax.swing.JButton();
        jSeparator7 = new javax.swing.JToolBar.Separator();
        jButton5 = new javax.swing.JButton();
        jSeparator6 = new javax.swing.JToolBar.Separator();
        jButton6 = new javax.swing.JButton();
        jSeparator5 = new javax.swing.JToolBar.Separator();
        jLabel5 = new javax.swing.JLabel();
        buscarReporte = new javax.swing.JTextField();
        jScrollPane3 = new javax.swing.JScrollPane();
        tablaReportes = new javax.swing.JTable();
        jPanel1 = new javax.swing.JPanel();
        jToolBar3 = new javax.swing.JToolBar();
        jButton9 = new javax.swing.JButton();
        jSeparator10 = new javax.swing.JToolBar.Separator();
        jButton10 = new javax.swing.JButton();
        jSeparator11 = new javax.swing.JToolBar.Separator();
        jButton11 = new javax.swing.JButton();
        jSeparator12 = new javax.swing.JToolBar.Separator();
        jLabel10 = new javax.swing.JLabel();
        buscarCliente = new javax.swing.JTextField();
        jSeparator13 = new javax.swing.JToolBar.Separator();
        jButton12 = new javax.swing.JButton();
        jScrollPane4 = new javax.swing.JScrollPane();
        tablaInfoClientes = new javax.swing.JTable();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Admin");
        addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                formKeyPressed(evt);
            }
        });

        jTabbedPane1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jTabbedPane1MouseClicked(evt);
            }
        });
        jTabbedPane1.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                jTabbedPane1KeyPressed(evt);
            }
        });

        jPanel2.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                jPanel2KeyPressed(evt);
            }
        });

        jToolBar1.setRollover(true);

        guardar.setText("Nuevo");
        guardar.setFocusable(false);
        guardar.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        guardar.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        guardar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                guardarActionPerformed(evt);
            }
        });
        jToolBar1.add(guardar);
        jToolBar1.add(jSeparator1);

        jButton2.setText("Cancelar");
        jButton2.setFocusable(false);
        jButton2.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        jButton2.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });
        jToolBar1.add(jButton2);
        jToolBar1.add(jSeparator2);

        jButton3.setText("Editar");
        jButton3.setFocusable(false);
        jButton3.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        jButton3.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        jButton3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton3ActionPerformed(evt);
            }
        });
        jToolBar1.add(jButton3);

        jButton4.setText("Eliminar");
        jButton4.setFocusable(false);
        jButton4.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        jButton4.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        jButton4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton4ActionPerformed(evt);
            }
        });
        jToolBar1.add(jButton4);
        jToolBar1.add(jSeparator8);
        jToolBar1.add(jSeparator3);

        jButton8.setText("Recargar");
        jButton8.setFocusable(false);
        jButton8.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        jButton8.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        jButton8.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton8ActionPerformed(evt);
            }
        });
        jToolBar1.add(jButton8);
        jToolBar1.add(jSeparator9);

        jLabel4.setText("Buscar: ");
        jToolBar1.add(jLabel4);

        buscar.setText("jTextField3");
        buscar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                buscarActionPerformed(evt);
            }
        });
        buscar.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                buscarKeyPressed(evt);
            }
            public void keyReleased(java.awt.event.KeyEvent evt) {
                buscarKeyReleased(evt);
            }
        });
        jToolBar1.add(buscar);

        jLabel1.setText("Nombre");

        nombre.setText("jTextField1");
        nombre.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                nombreKeyReleased(evt);
            }
        });

        jLabel2.setText("Nombre de usuario");

        usuario.setText("jTextField2");
        usuario.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                usuarioKeyReleased(evt);
            }
        });

        jLabel3.setText("Contraseña");

        pasw1.setText("jPasswordField1");
        pasw1.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                pasw1KeyReleased(evt);
            }
        });

        pasw2.setText("jPasswordField2");
        pasw2.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                pasw2KeyReleased(evt);
            }
        });

        jLabel6.setText("Repetir contraseña");

        rol.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "rol", "admin", "usuario" }));
        rol.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                rolActionPerformed(evt);
            }
        });

        jLabel7.setText("Rol");

        jLabel8.setText("Código erp");

        erp.setText("jTextField1");
        erp.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                erpKeyReleased(evt);
            }
        });

        jLabel9.setText("Ruta");

        ruta.setText("jTextField2");
        ruta.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                rutaKeyReleased(evt);
            }
        });

        activo.setText("Desactivar");

        identificadorId.setText("Id");

        id.setText("jLabel11");

        tablaUsuarios.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4"
            }
        ));
        scrollUsuarios.setViewportView(tablaUsuarios);

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jToolBar1, javax.swing.GroupLayout.DEFAULT_SIZE, 1314, Short.MAX_VALUE)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(scrollUsuarios)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel2)
                            .addComponent(jLabel1)
                            .addComponent(jLabel3)
                            .addComponent(jLabel6)
                            .addComponent(jLabel7)
                            .addComponent(jLabel8)
                            .addComponent(jLabel9)
                            .addComponent(identificadorId))
                        .addGap(18, 18, 18)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                .addComponent(id, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(nombre, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, 212, Short.MAX_VALUE))
                            .addGroup(jPanel2Layout.createSequentialGroup()
                                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                    .addComponent(ruta, javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(erp, javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(rol, javax.swing.GroupLayout.Alignment.LEADING, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(pasw2, javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(pasw1, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, 149, Short.MAX_VALUE)
                                    .addComponent(usuario, javax.swing.GroupLayout.Alignment.LEADING))
                                .addGap(295, 295, 295)
                                .addComponent(activo)))
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addComponent(jToolBar1, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(22, 22, 22)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(identificadorId)
                    .addComponent(id))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(nombre, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(usuario, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3)
                    .addComponent(pasw1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(pasw2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel6)
                    .addComponent(activo))
                .addGap(18, 18, 18)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(rol, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel7))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel8)
                    .addComponent(erp, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jLabel9)
                    .addComponent(ruta, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(26, 26, 26)
                .addComponent(scrollUsuarios, javax.swing.GroupLayout.PREFERRED_SIZE, 348, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jTabbedPane1.addTab("Usuarios", jPanel2);

        jToolBar2.setRollover(true);

        jButton1.setText("Ver");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });
        jToolBar2.add(jButton1);
        jToolBar2.add(jSeparator4);

        jButton7.setText("revisar");
        jButton7.setFocusable(false);
        jButton7.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        jButton7.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        jButton7.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton7ActionPerformed(evt);
            }
        });
        jToolBar2.add(jButton7);
        jToolBar2.add(jSeparator7);

        jButton5.setText("Procesar");
        jButton5.setFocusable(false);
        jButton5.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        jButton5.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        jButton5.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton5ActionPerformed(evt);
            }
        });
        jToolBar2.add(jButton5);
        jToolBar2.add(jSeparator6);

        jButton6.setText("Recargar");
        jButton6.setFocusable(false);
        jButton6.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        jButton6.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        jButton6.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton6ActionPerformed(evt);
            }
        });
        jToolBar2.add(jButton6);
        jToolBar2.add(jSeparator5);

        jLabel5.setText("Buscar");
        jToolBar2.add(jLabel5);

        buscarReporte.setText("jTextField4");
        buscarReporte.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                buscarReporteActionPerformed(evt);
            }
        });
        buscarReporte.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                buscarReporteKeyPressed(evt);
            }
            public void keyReleased(java.awt.event.KeyEvent evt) {
                buscarReporteKeyReleased(evt);
            }
        });
        jToolBar2.add(buscarReporte);

        jScrollPane3.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                jScrollPane3KeyPressed(evt);
            }
        });

        tablaReportes.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4"
            }
        ));
        tablaReportes.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                tablaReportesKeyPressed(evt);
            }
        });
        jScrollPane3.setViewportView(tablaReportes);

        javax.swing.GroupLayout jPanel4Layout = new javax.swing.GroupLayout(jPanel4);
        jPanel4.setLayout(jPanel4Layout);
        jPanel4Layout.setHorizontalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jToolBar2, javax.swing.GroupLayout.DEFAULT_SIZE, 1314, Short.MAX_VALUE)
            .addComponent(jScrollPane3)
        );
        jPanel4Layout.setVerticalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addComponent(jToolBar2, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(32, 32, 32)
                .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 628, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jTabbedPane1.addTab("Reportes", jPanel4);

        jToolBar3.setRollover(true);

        jButton9.setText("Nuevo");
        jButton9.setFocusable(false);
        jButton9.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        jButton9.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        jButton9.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton9ActionPerformed(evt);
            }
        });
        jToolBar3.add(jButton9);
        jToolBar3.add(jSeparator10);

        jButton10.setText("Ver");
        jButton10.setFocusable(false);
        jButton10.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        jButton10.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        jButton10.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton10ActionPerformed(evt);
            }
        });
        jToolBar3.add(jButton10);
        jToolBar3.add(jSeparator11);

        jButton11.setText("Eliminar");
        jButton11.setFocusable(false);
        jButton11.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        jButton11.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        jButton11.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton11ActionPerformed(evt);
            }
        });
        jToolBar3.add(jButton11);
        jToolBar3.add(jSeparator12);

        jLabel10.setText("Buscar");
        jToolBar3.add(jLabel10);

        buscarCliente.setText("jTextField1");
        jToolBar3.add(buscarCliente);
        jToolBar3.add(jSeparator13);

        jButton12.setText("Recargar");
        jButton12.setFocusable(false);
        jButton12.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        jButton12.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        jButton12.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton12ActionPerformed(evt);
            }
        });
        jToolBar3.add(jButton12);

        tablaInfoClientes.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4"
            }
        ));
        jScrollPane4.setViewportView(tablaInfoClientes);

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jToolBar3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(jScrollPane4, javax.swing.GroupLayout.DEFAULT_SIZE, 1314, Short.MAX_VALUE)
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addComponent(jToolBar3, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane4, javax.swing.GroupLayout.DEFAULT_SIZE, 649, Short.MAX_VALUE)
                .addContainerGap())
        );

        jTabbedPane1.addTab("Clientes", jPanel1);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jTabbedPane1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jTabbedPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 712, javax.swing.GroupLayout.PREFERRED_SIZE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    /**
     * Metodo para actualizar la información sobre los usuarios
     */
    void actualizar(){
        String pasw1=this.pasw1.getText(),pasw2=this.pasw2.getText(), nombre=this.nombre.getText(), 
                rols=this.rol.getSelectedItem().toString(), erp=this.erp.getText(), ruta=this.ruta.getText(), id=this.id.getText();
        boolean activo=this.activo.isSelected();
        int rol1=this.rol.getSelectedIndex();
        this._conexion.mariaDB();
        if(!nombre.isEmpty()){
            this._conexion.update("update usuarios set nombre='"+nombre+"' where id="+id+"");
        }
        
        if(!pasw1.isEmpty()&&!pasw2.isEmpty()){
            this._conexion.update("update usuarios set contrasenia='"+pasw1+"' where id="+id+"");
        }else{
           JOptionPane.showMessageDialog(this, "Para actualizar la contraseña, tienen que ser iguales");
        }
        
        if(rol1!=0){
            this._conexion.update("update usuarios set rol='"+rols+"' where id="+id+"");
        }
            
        if(!erp.isEmpty()){
            this._conexion.update("update usuarios set codigoerp='"+erp+"' where id="+id+"");
        }
        
        if(!ruta.isEmpty()){
             this._conexion.update("update usuarios set ruta='"+ruta+"' where id="+id+"");
        }
        
        if(activo==true){
            this._conexion.update("update usuarios set activo='0' where id="+id+"");
        }
        
        this._conexion.cerrarConeccion();
        
        
    }
    
    
    /**
 * Metodo para cargar los usuarios al arrancar como administrador
 */
    
    
    void CargarUsuarios(){
        String tabla="select * from usuarios";
                this._conexion.mariaDB();
        this.tablaAux=this._conexion.estructurarTabla(tabla);
        this.tablaUsuarios.setModel(tablaAux);
       
     
        this.scrollUsuarios.getViewport().add(this.tablaUsuarios);
        this._conexion.cerrarConeccion();
    }
    
    
    private void formKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_formKeyPressed
        // TODO add your handling code here:
        if(evt.getKeyCode()==java.awt.event.KeyEvent.VK_ESCAPE){
            System.exit(0);
        }
        
        
    }//GEN-LAST:event_formKeyPressed

    private void jTabbedPane1KeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jTabbedPane1KeyPressed
        // TODO add your handling code here:

        if(this.jTabbedPane1.isEnabledAt(0)){
            if(evt.getKeyCode()==java.awt.event.KeyEvent.VK_F5){

                CargarUsuarios();

            }
        }else if(this.jTabbedPane1.isEnabledAt(1)){

            if(evt.getKeyCode()==java.awt.event.KeyEvent.VK_F6){
                try {
                    guardarReporte();
                    _reporte.setVisible(true);
                } catch (IOException ex) {
                    Logger.getLogger(admin.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
            if(evt.getKeyCode()==java.awt.event.KeyEvent.VK_F7){
                int validar=JOptionPane.showConfirmDialog(rootPane, "¿Desea procesar el reporte?","Procesar reporte",JOptionPane.OK_CANCEL_OPTION);
                if(validar==JOptionPane.OK_OPTION){
                    try {
                        procesarReporte();
                    } catch (IOException ex) {
                        Logger.getLogger(admin.class.getName()).log(Level.SEVERE, null, ex);
                    }
                    // this.mostrarReportes();
                }
            }
            if(evt.getKeyCode()==java.awt.event.KeyEvent.VK_5){
                this.mostrarReportes();
            }

        }

    }//GEN-LAST:event_jTabbedPane1KeyPressed

/***
 * cargara la información en la tabla
 * @param evt 
 */
    private void jTabbedPane1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jTabbedPane1MouseClicked

    }//GEN-LAST:event_jTabbedPane1MouseClicked

    private void jScrollPane3KeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jScrollPane3KeyPressed
        // TODO add your handling code here:

    }//GEN-LAST:event_jScrollPane3KeyPressed

    private void tablaReportesKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_tablaReportesKeyPressed
        // TODO add your handling code here:
        if(evt.getKeyCode()==java.awt.event.KeyEvent.VK_F6){
            try {
                guardarReporte();
                _reporte.setVisible(true);
            } catch (IOException ex) {
                Logger.getLogger(admin.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        if(evt.getKeyCode()==java.awt.event.KeyEvent.VK_F7){
            int validar=JOptionPane.showConfirmDialog(rootPane, "¿Desea procesar el reporte?","Procesar reporte",JOptionPane.OK_CANCEL_OPTION);
            if(validar==JOptionPane.OK_OPTION){
                try {
                    procesarReporte();
                } catch (IOException ex) {
                    Logger.getLogger(admin.class.getName()).log(Level.SEVERE, null, ex);
                }
                // this.mostrarReportes();
            }
        }
        if(evt.getKeyCode()==java.awt.event.KeyEvent.VK_5){
            this.mostrarReportes();
        }

    }//GEN-LAST:event_tablaReportesKeyPressed

    private void buscarReporteKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_buscarReporteKeyPressed
        // TODO add your handling code here:
        //String []listadeDeseos={"select","from","where","delete","insert","into","update","join"};
        
        
        if(evt.getKeyCode()==java.awt.event.KeyEvent.VK_ENTER){
           
            
            
            if(!buscarReporte.getText().isEmpty()){
//                String []parts=buscarReporte.getText().split(" ");
//                boolean error=false;
//                for(int i=0; i<=parts.length;i++){
//                   for(int j=0;j<=listadeDeseos.length;j++){
//                       if(parts[i].equals(listadeDeseos[j])){
//                           error=true;
//                           break;
//                       }
//                   }
//                }
                
            
                  // System.out.println(""+parts);
                      this._conexion.mariaDB();
                this.tablaReportes.setModel(_conexion.estructurarTabla("select * from reportes where id='"+buscarReporte.getText()+"' or idCliente like '%"+buscarReporte.getText()+"' or personas like '%"+buscarReporte.getText()+"'"
                    + " or asesor like '%"+buscarReporte.getText()+"' or tiempoTrabajo like '%"+buscarReporte.getText()+"' or idUsuario like '%"+buscarReporte.getText()+"' "));
            this.jScrollPane3.getViewport().add(this.tablaReportes);
            this._conexion.cerrarConeccion(); 
               
                
                
                
                
                
               
                 
                
               
        }else{
            JOptionPane.showMessageDialog(this,
                "El cuadro de busqueda esta vacio");
        }
        }

    }//GEN-LAST:event_buscarReporteKeyPressed

    private void buscarReporteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_buscarReporteActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_buscarReporteActionPerformed

    private void jButton6ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton6ActionPerformed
        try {
            // TODO add your handling code here:
            // recargar
            _direccion.guardarReporte("", "", "", "", "", "", "", "");
            _direccion.guardarCliente("");
            this.mostrarReportes();
        } catch (IOException ex) {
            Logger.getLogger(admin.class.getName()).log(Level.SEVERE, null, ex);
        }

    }//GEN-LAST:event_jButton6ActionPerformed

    private void jButton5ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton5ActionPerformed
        // TODO add your handling code here:
        //procesar
        int validar=JOptionPane.showConfirmDialog(rootPane, "¿Desea procesar los reportes?","Procesar reporte",JOptionPane.OK_CANCEL_OPTION);
        if(validar==JOptionPane.OK_OPTION){
            try {
                procesarReporte();

                //  idReporte=0;
            } catch (IOException ex) {
                Logger.getLogger(admin.class.getName()).log(Level.SEVERE, null, ex);
            }
            // this.mostrarReportes();
        }

    }//GEN-LAST:event_jButton5ActionPerformed

    private void jButton7ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton7ActionPerformed
        // TODO add your handling code here:
        revisarReporte();

    }//GEN-LAST:event_jButton7ActionPerformed

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        // TODO add your handling code here:
        try {
            guardarReporte();
            //idReporte=0;
            _reporte.setVisible(true);
        } catch (IOException ex) {
            Logger.getLogger(admin.class.getName()).log(Level.SEVERE, null, ex);
        }

    }//GEN-LAST:event_jButton1ActionPerformed

    private void jPanel2KeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jPanel2KeyPressed
        // TODO add your handling code here:
        if(evt.getKeyCode()==java.awt.event.KeyEvent.VK_F5){
            String sql="select * from usuarios";
            //buscarT(sql);

            this.CargarUsuarios();

        }
    }//GEN-LAST:event_jPanel2KeyPressed

    private void rolActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_rolActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_rolActionPerformed

    private void buscarKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_buscarKeyPressed
        // TODO add your handling code here

        if(evt.getKeyCode()==java.awt.event.KeyEvent.VK_ENTER){
            if(!this.buscar.getText().isEmpty()){
                String tabla="select * from usuarios where nombre like '%"+this.buscar.getText()+"%' or"
                + " usuario like '%"+this.buscar.getText()+"%'";
                // buscarT(tabla);
                this._conexion.mariaDB();
                // this.tablaAux=this._conexion.estructurarTabla(sql);
                this.tablaUsuarios= new javax.swing.JTable(this._conexion.estructurarTabla(tabla)){
                    @Override
                    public boolean isCellEditable(int row, int column){
                        return false;
                    }
                };
                this.scrollUsuarios.getViewport().add(this.tablaUsuarios);
                this._conexion.cerrarConeccion();
            }else{
                JOptionPane.showMessageDialog(this, "El campo de busqueda está vacío");
            }
        }
    }//GEN-LAST:event_buscarKeyPressed

    private void buscarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_buscarActionPerformed
        // TODO add your handling code here:

    }//GEN-LAST:event_buscarActionPerformed

    private void jButton4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton4ActionPerformed
        // TODO add your handling code here:
        eliminarUsuario();
        CargarUsuarios();

    }//GEN-LAST:event_jButton4ActionPerformed

    private void jButton3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton3ActionPerformed
        // TODO add your handling code here:
        actualizar();
        CargarUsuarios();
        limpiar();
    }//GEN-LAST:event_jButton3ActionPerformed

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        // TODO add your handling code here:
        this.limpiar();

    }//GEN-LAST:event_jButton2ActionPerformed

    private void guardarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_guardarActionPerformed
        // TODO add your handling code here:
        this._conexion.mariaDB();
        String usuario=this.usuario.getText(), pasw1=this.pasw1.getText(), pasw2=this.pasw2.getText(), nombre=this.nombre.getText();
        String rol=this.rol.getSelectedItem().toString(), erp=this.erp.getText(), ruta=this.ruta.getText();
        if(!nombre.isEmpty()&&!usuario.isEmpty()&&!pasw2.isEmpty()&&!pasw1.isEmpty()&&!rol.equals("rol")
            &&!ruta.isEmpty()&&!erp.isEmpty()){
            if(pasw1.equals(pasw2)){
                if(!this._conexion.verificarDato("select * from usuarios where usuario='"+usuario+"'")){
                    this._conexion.update("insert into usuarios (nombre, usuario, contrasenia, rol, codigoerp, ruta, activo) values('"+nombre+"',"
                        + "'"+usuario+"',"
                        + "'"+pasw1+"',"
                        + "'"+rol+"',"
                        + "'"+erp+"',"
                        + "'"+ruta+"',1)");
                    limpiar();

                }else{
                    JOptionPane.showMessageDialog(rootPane,"Ya existe un usuario con esta descripción:\n"+usuario);
                }
            }else{
                JOptionPane.showMessageDialog(rootPane,"Las contraseñas para el nuevo usuario deben de ser iguales");
            }

        }else{
            JOptionPane.showMessageDialog(rootPane,"Para dar de alta un usuario se requieren todos los datos");
        }
        this._conexion.cerrarConeccion();
        
        CargarUsuarios();
        
        
    }//GEN-LAST:event_guardarActionPerformed

    private void buscarReporteKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_buscarReporteKeyReleased
        // TODO add your handling code here:
        String str=buscarReporte.getText();
        char[] fuente=str.toCharArray();
        char[] resultado= new char[fuente.length];
        String []listadeDeseos={"select","from","where","delete","insert","into","update"};
        
        String aux="";
        int j=0;
        boolean error=false;
        boolean errora=false;
        for(int i=0; i<fuente.length;i++){
           
            if(fuente[i]==';'||fuente[i]=='*'||fuente[i]=='<'||fuente[i]=='>'||fuente[i]=='('||fuente[i]==')'||fuente[i]=='['||fuente[i]==']'||fuente[i]=='{'||fuente[i]=='}'||fuente[i]=='\\'){
                error=true;
                java.awt.Toolkit.getDefaultToolkit().beep();
            }else{
                resultado[j++]=fuente[i];
                
            }
        }
        
       
        
        
        if(error){
            buscarReporte.setText("");
            buscarReporte.setText(new String(resultado,0,j));
        }
        
        
       
        
        
        
        
    }//GEN-LAST:event_buscarReporteKeyReleased

    private void nombreKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_nombreKeyReleased
        // TODO add your handling code here:
        String str=nombre.getText();
        char[] fuente=str.toCharArray();
        char[] resultado= new char[fuente.length];
        
        int j=0;
        boolean error=false;
        for(int i=0; i<fuente.length;i++){
            if(fuente[i]=='|'||fuente[i]=='*'||fuente[i]==';'||fuente[i]=='<'||fuente[i]=='>'||fuente[i]=='\\'){
                 error=true;

                 java.awt.Toolkit.getDefaultToolkit().beep();
            }else{
                resultado[j++]=fuente[i];
                
            }
        }
        
        if(error){
            nombre.setText("");
            nombre.setText(new String(resultado,0,j));
        }
        
        
    }//GEN-LAST:event_nombreKeyReleased

    private void usuarioKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_usuarioKeyReleased
        // TODO add your handling code here:
         String str=usuario.getText();
        char[] fuente=str.toCharArray();
        char[] resultado= new char[fuente.length];
        
        int j=0;
        boolean error=false;
        for(int i=0; i<fuente.length;i++){
            if(fuente[i]=='|'||fuente[i]=='*'||fuente[i]==';'||fuente[i]=='<'||fuente[i]=='>'||fuente[i]=='\\'){
                 error=true;

                 java.awt.Toolkit.getDefaultToolkit().beep();
            }else{
                resultado[j++]=fuente[i];
                
            }
        }
        
        if(error){
            usuario.setText("");
            usuario.setText(new String(resultado,0,j));
        }
        
        
    }//GEN-LAST:event_usuarioKeyReleased

    private void pasw1KeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_pasw1KeyReleased
        // TODO add your handling code here:
        String str=pasw1.getText();
        char[] fuente=str.toCharArray();
        char[] resultado= new char[fuente.length];
        
        int j=0;
        boolean error=false;
        for(int i=0; i<fuente.length;i++){
            if(fuente[i]=='|'||fuente[i]=='*'||fuente[i]==';'||fuente[i]=='<'||fuente[i]=='>'||fuente[i]=='\\'){
                 error=true;

                 java.awt.Toolkit.getDefaultToolkit().beep();
            }else{
                resultado[j++]=fuente[i];
                
            }
        }
        
        if(error){
            pasw1.setText("");
            pasw1.setText(new String(resultado,0,j));
        }
        
        
    }//GEN-LAST:event_pasw1KeyReleased

    private void pasw2KeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_pasw2KeyReleased
        // TODO add your handling code here:
        String str=pasw2.getText();
        char[] fuente=str.toCharArray();
        char[] resultado= new char[fuente.length];
        
        int j=0;
        boolean error=false;
        for(int i=0; i<fuente.length;i++){
            if(fuente[i]=='|'||fuente[i]=='*'||fuente[i]==';'||fuente[i]=='<'||fuente[i]=='>'||fuente[i]=='\\'){
                 error=true;

                 java.awt.Toolkit.getDefaultToolkit().beep();
            }else{
                resultado[j++]=fuente[i];
                
            }
        }
        
        if(error){
            pasw2.setText("");
            pasw2.setText(new String(resultado,0,j));
        }
    }//GEN-LAST:event_pasw2KeyReleased

    private void erpKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_erpKeyReleased
        // TODO add your handling code here:
        String str=erp.getText();
        char[] fuente=str.toCharArray();
        char[] resultado= new char[fuente.length];
        
        int j=0;
        boolean error=false;
        for(int i=0; i<fuente.length;i++){
            if(fuente[i]=='|'||fuente[i]=='*'||fuente[i]==';'||fuente[i]=='<'||fuente[i]=='>'||fuente[i]=='\\'){
                 error=true;

                 java.awt.Toolkit.getDefaultToolkit().beep();
            }else{
                resultado[j++]=fuente[i];
                
            }
        }
        
        if(error){
            erp.setText("");
            erp.setText(new String(resultado,0,j));
        }
        
    }//GEN-LAST:event_erpKeyReleased

    private void rutaKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_rutaKeyReleased
        // TODO add your handling code here:
        String str=ruta.getText();
        char[] fuente=str.toCharArray();
        char[] resultado= new char[fuente.length];
        
        int j=0;
        boolean error=false;
        for(int i=0; i<fuente.length;i++){
            if(fuente[i]=='|'||fuente[i]=='*'||fuente[i]==';'||fuente[i]=='<'||fuente[i]=='>'||fuente[i]=='\\'){
                 error=true;

                 java.awt.Toolkit.getDefaultToolkit().beep();
            }else{
                resultado[j++]=fuente[i];
                
            }
        }
        
        if(error){
            ruta.setText("");
            ruta.setText(new String(resultado,0,j));
        }
        
    }//GEN-LAST:event_rutaKeyReleased

    private void buscarKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_buscarKeyReleased
        // TODO add your handling code here:
        String str=buscar.getText();
        char[] fuente=str.toCharArray();
        char[] resultado= new char[fuente.length];
        
        int j=0;
        boolean error=false;
        for(int i=0; i<fuente.length;i++){
            if(fuente[i]=='|'||fuente[i]=='*'||fuente[i]==';'||fuente[i]=='<'||fuente[i]=='>'||fuente[i]=='\\'){
                 error=true;

                 java.awt.Toolkit.getDefaultToolkit().beep();
            }else{
                resultado[j++]=fuente[i];
                
            }
        }
        
        if(error){
            buscar.setText("");
            buscar.setText(new String(resultado,0,j));
        }
        
        
    }//GEN-LAST:event_buscarKeyReleased
///recargar usuarios
    private void jButton8ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton8ActionPerformed
        // TODO add your handling code here:
        
        
        
        
    }//GEN-LAST:event_jButton8ActionPerformed

    private void jButton9ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton9ActionPerformed
        // TODO add your handling code here:
        clientes.setVisible(true);

    }//GEN-LAST:event_jButton9ActionPerformed

    private void jButton12ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton12ActionPerformed
        // TODO add your handling code here:
        cargarClientes();
        
    }//GEN-LAST:event_jButton12ActionPerformed

    private void jButton11ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton11ActionPerformed
        // TODO add your handling code here:
        if(ide!=-1){
            _conexion.mariaDB();
            _conexion.update("delete from clientesInfo where id="+ide+"");
            _conexion.cerrarConeccion();
        }else{
           JOptionPane.showMessageDialog(rootPane, "Seleccione primero un cliente y despues de clic en eliminar. Esto no afectara a macropro.");  
        }
        cargarClientes();
        
        
        
    }//GEN-LAST:event_jButton11ActionPerformed

    private void jButton10ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton10ActionPerformed
        // TODO add your handling code here:
        clientes= new infoClientes(ide);
        clientes.setVisible(true);
        
        
        
    }//GEN-LAST:event_jButton10ActionPerformed

    void eliminarUsuario(){
         if(!id.getText().isEmpty()&&!id.getText().equals("1")){
         _conexion.mariaDB();
         _conexion.update("delete from usuarios where id="+id.getText()+"");
         
         _conexion.cerrarConeccion();
        }else{
             JOptionPane.showMessageDialog(rootPane, "No puedes eliminar el usuario administrador");
         }
    }
    
    
    reporte _reporte= new reporte();
    
    void guardarReporte() throws IOException{
        String idReporte=_direccion.leeridReporte();
        if(!idReporte.isEmpty()){
             _direccion.guardarReporte("", "", "", "", "", "", "", "");
            _direccion.guardarCliente("");
            _direccion.getcliente("");
            this._conexion.mariaDB();
            String fecha, horaInicio, idCliente, poliza, persona, asesor, tiempoTrabajo,ServicioRealizado, materiales, nomcliente;
            fecha=this._conexion.devolverDato("select fecha from reportes where id="+idReporte+" and procesado=0", "fecha");
            horaInicio=this._conexion.devolverDato("select horaInicio from reportes where id="+idReporte+" and procesado=0", "horaInicio");
            idCliente=this._conexion.devolverDato("select idCliente from reportes where id="+idReporte+" and procesado=0", "idCliente");
            poliza=this._conexion.devolverDato("select poliza from reportes where id="+idReporte+" and procesado=0", "poliza");
            persona=this._conexion.devolverDato("select personas from reportes where id="+idReporte+" and procesado=0", "personas");
            asesor=this._conexion.devolverDato("select asesor from reportes where id="+idReporte+" and procesado=0", "asesor");
            tiempoTrabajo=this._conexion.devolverDato("select tiempoTrabajo from reportes where id="+idReporte+" and procesado=0", "tiempoTrabajo");
            ServicioRealizado=this._conexion.devolverDato("select servicioRealizado from reportes where id="+idReporte+" and procesado=0", "servicioRealizado");
            materiales=this._conexion.devolverDato("select materiales from reportes where id="+idReporte+" and procesado=0", "materiales");
            nomcliente=this._conexion.devolverDato("select nomCliente from reportes where id="+idReporte+" and procesado=0", "nomCliente");
            _direccion.guardarReporte(fecha, horaInicio, poliza, persona, asesor, tiempoTrabajo, ServicioRealizado, materiales);
            _direccion.guardarCliente(idCliente);
            _direccion.getcliente(nomcliente);
          //  _direccion.guardaridReporte(String.valueOf(idReporte));
            this._conexion.cerrarConeccion();
        }else{
            JOptionPane.showMessageDialog(rootPane, "Tiene que dar clic en el reporte que desea visualizar");
        }
    
    }
    
    
    void procesarReporte() throws IOException{
        _conexion.mariaDB();
        
       JFrame parent= new JFrame();
       JOptionPane optionPane= new JOptionPane();
       JTextField field=getField();
       optionPane.setMessage(new Object[]{"Fecha:",field});
       optionPane.setMessageType(JOptionPane.QUESTION_MESSAGE);
       optionPane.setOptionType(JOptionPane.OK_CANCEL_OPTION);
       JDialog dialog= optionPane.createDialog(parent,"fecha");
       dialog.setVisible(true);
       String fecha=field.getText();
        if(validarFecha(fecha)){
            _conexion.update("update reportes set procesado=1 where fecha>='"+fecha+"'");
            _conexion.update("update reportes set unificado=1 where poliza=1 and revisado=1 and procesado=1 and fecha>='"+fecha+"'");
            _conexion.reporteGlobal(fecha);
            _conexion.update("update reportes set macrop=1 where fecha>='"+fecha+"' and revisado=1 and procesado=1");
           // this.limpiarInfor();
            this.limpiar();
            
            //this.dispose();
        }else{
            JOptionPane.showMessageDialog(rootPane, "La fecha debe de contener el siguiente formato yy-mm-dd separada por guion medio");
        }
        
        
        _conexion.cerrarConeccion();
       
        
        
    }
    
    private static JTextField getField(){
        JTextField field= new JTextField();
        field.addKeyListener(new KeyListener(){
            @Override
            public void keyTyped(KeyEvent e) {
                //throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
            }

            @Override
            public void keyPressed(KeyEvent e) {
              //  throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
            }

            @Override
            public void keyReleased(KeyEvent e) {
                String str=field.getText();
                char[] fuente=str.toCharArray();
                char[] resultado= new char[fuente.length];
                int j=0;
                boolean error=false;
                
                for(int i=0;i<fuente.length;i++){
                    if(fuente[i]>='0'&&fuente[i]<='9'){
                        resultado[j++]=fuente[i];
                    }else if(fuente[i]=='-'){
                        resultado[j++]=fuente[i];
                    }else{
                        error=true;
                        java.awt.Toolkit.getDefaultToolkit().beep();
                    }
                }
                
                
                if(error){
                    field.setText("");
                    field.setText(new String(resultado,0,j));
                }
                
                
               // throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
            }
        });
        return field;
    }
    
    void revisarReporte(){
        _conexion.mariaDB();
        if(ide!=-1){
            _conexion.update("update reportes set revisado=1 where id="+ide+"");
            
        }else{
            JOptionPane.showMessageDialog(rootPane, "Ocurrio un problema con el reporte, cierre e intentelo más tarde. ;)");
        }
        _conexion.cerrarConeccion();
    }
    
    boolean validarFecha(String fecha){
        boolean validar=false;
        if(fecha.length()==10){
             String []parts=fecha.split("-");
             String part1=parts[0];
             String part2=parts[1];
             String part3=parts[2];
        if(Integer.parseInt(part3)>0&&Integer.parseInt(part2)>0&&Integer.parseInt(part1)>0){
            validar=true;
        }else{
            validar=false;
        }
        }
       
        
        return validar;
    }
    
  
    
    

//
//    void buscarT(String sql){
//        
//        //String tabla="select nombre, usuario, contrasenia, rol, codigoerp, ruta from usuarios";
//        this._conexion.mariaDB();
//       // this.tablaAux=this._conexion.estructurarTabla(sql);
//        this.tablaUsuarios= new javax.swing.JTable(this._conexion.estructurarTabla(sql)){
//            @Override
//            public boolean isCellEditable(int row, int column){
//                return false;
//            }
//        };
//        this.scrollUsuarios.getViewport().add(this.tablaUsuarios);
//        this._conexion.cerrarConeccion();
//    }
//    
//    
    
    
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
            java.util.logging.Logger.getLogger(admin.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(admin.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(admin.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(admin.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new admin().setVisible(true);
            }
        });
    }
    
    
    void mostrarReportes(){
        this._conexion.mariaDB();
        String sql="select * from reportes";
       // this.tablaAux=this._conexion.estructurarTabla(sql);
        this.tablaReportes.setModel(this._conexion.estructurarTabla(sql));
        
        this.jScrollPane3.getViewport().add(this.tablaReportes);
        this._conexion.cerrarConeccion();
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JCheckBox activo;
    private javax.swing.JTextField buscar;
    private javax.swing.JTextField buscarCliente;
    private javax.swing.JTextField buscarReporte;
    private javax.swing.JTextField erp;
    private javax.swing.JButton guardar;
    private javax.swing.JLabel id;
    private javax.swing.JLabel identificadorId;
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton10;
    private javax.swing.JButton jButton11;
    private javax.swing.JButton jButton12;
    private javax.swing.JButton jButton2;
    private javax.swing.JButton jButton3;
    private javax.swing.JButton jButton4;
    private javax.swing.JButton jButton5;
    private javax.swing.JButton jButton6;
    private javax.swing.JButton jButton7;
    private javax.swing.JButton jButton8;
    private javax.swing.JButton jButton9;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JScrollPane jScrollPane4;
    private javax.swing.JToolBar.Separator jSeparator1;
    private javax.swing.JToolBar.Separator jSeparator10;
    private javax.swing.JToolBar.Separator jSeparator11;
    private javax.swing.JToolBar.Separator jSeparator12;
    private javax.swing.JToolBar.Separator jSeparator13;
    private javax.swing.JToolBar.Separator jSeparator2;
    private javax.swing.JToolBar.Separator jSeparator3;
    private javax.swing.JToolBar.Separator jSeparator4;
    private javax.swing.JToolBar.Separator jSeparator5;
    private javax.swing.JToolBar.Separator jSeparator6;
    private javax.swing.JToolBar.Separator jSeparator7;
    private javax.swing.JToolBar.Separator jSeparator8;
    private javax.swing.JToolBar.Separator jSeparator9;
    private javax.swing.JTabbedPane jTabbedPane1;
    private javax.swing.JToolBar jToolBar1;
    private javax.swing.JToolBar jToolBar2;
    private javax.swing.JToolBar jToolBar3;
    private javax.swing.JTextField nombre;
    private javax.swing.JPasswordField pasw1;
    private javax.swing.JPasswordField pasw2;
    private javax.swing.JComboBox<String> rol;
    private javax.swing.JTextField ruta;
    private javax.swing.JScrollPane scrollUsuarios;
    private javax.swing.JTable tablaInfoClientes;
    private javax.swing.JTable tablaReportes;
    private javax.swing.JTable tablaUsuarios;
    private javax.swing.JTextField usuario;
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
