package presentacion;

import Factory.FactoryConnectionDb;
import dao.BoletaDao;
import dao.BoletaDaoImp;
import dao.ClienteDao;
import dao.ClienteDaoImp;
import dao.DetalleDao;
import dao.DetalleDaoImp;
import dao.ProductoDao;
import dao.ProductoDaoImp;
import java.awt.BorderLayout;
import java.util.Calendar;
import java.util.List;
import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import model.cBoleta;
import model.cClientes;
import model.cDetalle;
import model.cProductos;
import model.cUsuario;
import reporte.CReporte;

public class frmBoleta extends javax.swing.JInternalFrame {     
    ClienteDao empleadodao_ = new ClienteDaoImp();
    Object[][] e;
    ProductoDao productodao_ = new ProductoDaoImp();
    Object[][] p;
    BoletaDao boletadao_ = new BoletaDaoImp();
    Object[][] b;
    
    String idCliente;   
    String nombreProducto;
    int idProducto;
    double precio;
    double prePorCantidad;
    
    int idEliminar;
    DefaultTableModel dtmVenta = new DefaultTableModel();
    public frmBoleta() {
       
        initComponents();
        setResizable(false); //bloquear la ampliacion del software
        setTitle("Venta"); //titulo del software
        //poner fondo al software
        ((JPanel)getContentPane()).setOpaque(false); 
        ImageIcon uno=new ImageIcon(this.getClass().getResource("/imagenes/fondo02.png"));
        JLabel fondo= new JLabel(); 
        fondo.setIcon(uno); 
        getLayeredPane().add(fondo,JLayeredPane.FRAME_CONTENT_LAYER);
        fondo.setBounds(0,0,uno.getIconWidth(),uno.getIconHeight());
        this.add(fondo, BorderLayout.CENTER);

        listarCliente("");
        listarProducto("");
        txtCliente.setEditable(false);
        
        dtmVenta.addColumn("idProducto");
        dtmVenta.addColumn("Nombre");
        dtmVenta.addColumn("Precio/u");
        dtmVenta.addColumn("Cantidad");
        dtmVenta.addColumn("Total");
        
        tablaVenta.setModel(dtmVenta);
        txtnro.setText(numBoleta("")+"");
        }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        Listar_clientes = new javax.swing.JDialog();
        jScrollPane1 = new javax.swing.JScrollPane();
        tablaCliente = new javax.swing.JTable();
        btnnuevo = new javax.swing.JButton();
        txtbuscar = new javax.swing.JTextField();
        jPanel1 = new javax.swing.JPanel();
        jLabel9 = new javax.swing.JLabel();
        btnagregar = new javax.swing.JButton();
        btnquitar = new javax.swing.JButton();
        txttotal = new javax.swing.JTextField();
        jLabel10 = new javax.swing.JLabel();
        btnGuardar = new javax.swing.JButton();
        jScrollPane2 = new javax.swing.JScrollPane();
        tablaProducto = new javax.swing.JTable();
        jLabel5 = new javax.swing.JLabel();
        txtcantidad = new javax.swing.JTextField();
        txtbuscarProducto = new javax.swing.JTextField();
        jScrollPane4 = new javax.swing.JScrollPane();
        tablaVenta = new javax.swing.JTable();
        txtCliente = new javax.swing.JTextField();
        jLabel1 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        txtnro = new javax.swing.JTextField();

        Listar_clientes.setAlwaysOnTop(true);

        tablaCliente.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {"casa", "dos", "tre", "cuaaa"},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4"
            }
        ));
        tablaCliente.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tablaClienteMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(tablaCliente);

        btnnuevo.setText("Nuevo");
        btnnuevo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnnuevoActionPerformed(evt);
            }
        });

        txtbuscar.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                txtbuscarKeyReleased(evt);
            }
        });

        javax.swing.GroupLayout Listar_clientesLayout = new javax.swing.GroupLayout(Listar_clientes.getContentPane());
        Listar_clientes.getContentPane().setLayout(Listar_clientesLayout);
        Listar_clientesLayout.setHorizontalGroup(
            Listar_clientesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
            .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
            .addGroup(Listar_clientesLayout.createSequentialGroup()
                .addComponent(txtbuscar, javax.swing.GroupLayout.PREFERRED_SIZE, 280, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, 0)
                .addComponent(btnnuevo, javax.swing.GroupLayout.PREFERRED_SIZE, 73, javax.swing.GroupLayout.PREFERRED_SIZE))
        );
        Listar_clientesLayout.setVerticalGroup(
            Listar_clientesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, Listar_clientesLayout.createSequentialGroup()
                .addGroup(Listar_clientesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtbuscar, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnnuevo))
                .addGap(0, 0, 0)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 227, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, 0))
        );

        setBackground(new java.awt.Color(51, 51, 51));
        setClosable(true);
        setIconifiable(true);

        jPanel1.setMaximumSize(new java.awt.Dimension(2000, 32767));
        jPanel1.setOpaque(false);
        jPanel1.setPreferredSize(new java.awt.Dimension(1000, 850));

        jLabel9.setForeground(new java.awt.Color(255, 255, 255));
        jLabel9.setText("Producto");

        btnagregar.setText("AGREGAR");
        btnagregar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnagregarActionPerformed(evt);
            }
        });

        btnquitar.setText("Eliminar");
        btnquitar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnquitarActionPerformed(evt);
            }
        });

        txttotal.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txttotalActionPerformed(evt);
            }
        });

        jLabel10.setText("Total:");

        btnGuardar.setText("Realizar Venta");
        btnGuardar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnGuardarActionPerformed(evt);
            }
        });

        tablaProducto.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.LOWERED));
        tablaProducto.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {"adadad", "adad", null, "adad", "da", null, "da", "d", null, "ad", "a", "d", "ad", null},
                {"adad", null, "a", "d", "d", null, null, "a", "da", null, null, null, null, null},
                {"adad", null, "a", null, null, "ad", null, "da", "da", null, null, null, null, null},
                {null, null, null, "dd", "a", "da", null, null, null, null, "a", null, null, null},
                {null, null, null, null, null, null, null, null, null, null, null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4", "mol,ñ{", "null", "null44", "Title 8", "Title 9", "Title 10", "Title 11", "Title 12", "Title 13", "null4"
            }
        ));
        tablaProducto.setOpaque(false);
        tablaProducto.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tablaProductoMouseClicked(evt);
            }
        });
        jScrollPane2.setViewportView(tablaProducto);

        jLabel5.setForeground(new java.awt.Color(255, 255, 255));
        jLabel5.setText("Cantidad:");

        txtcantidad.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txtcantidadKeyTyped(evt);
            }
        });

        txtbuscarProducto.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                txtbuscarProductoKeyReleased(evt);
            }
        });

        tablaVenta.setModel(new javax.swing.table.DefaultTableModel(
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
        tablaVenta.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tablaVentaMouseClicked(evt);
            }
        });
        jScrollPane4.setViewportView(tablaVenta);

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(25, 25, 25)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jLabel5)
                        .addGap(18, 18, 18)
                        .addComponent(txtcantidad, javax.swing.GroupLayout.PREFERRED_SIZE, 118, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btnagregar))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jLabel9)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(txtbuscarProducto, javax.swing.GroupLayout.PREFERRED_SIZE, 183, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 688, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jScrollPane4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(btnquitar, javax.swing.GroupLayout.PREFERRED_SIZE, 81, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLabel10)
                .addGap(18, 18, 18)
                .addComponent(txttotal, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(btnGuardar)
                .addGap(134, 134, 134))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel9, javax.swing.GroupLayout.PREFERRED_SIZE, 22, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtbuscarProducto, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 259, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(txtcantidad, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jLabel5))
                    .addComponent(btnagregar))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(btnquitar, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jScrollPane4, javax.swing.GroupLayout.PREFERRED_SIZE, 119, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel10)
                    .addComponent(txttotal, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnGuardar, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(39, Short.MAX_VALUE))
        );

        txtCliente.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                txtClienteMouseClicked(evt);
            }
        });

        jLabel1.setForeground(new java.awt.Color(255, 255, 255));
        jLabel1.setText("Cliente");

        jLabel6.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jLabel6.setForeground(new java.awt.Color(255, 255, 255));
        jLabel6.setText("N° Boleta:");

        txtnro.setEditable(false);
        txtnro.setFont(new java.awt.Font("Tahoma", 1, 24)); // NOI18N
        txtnro.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        txtnro.setText("0000");
        txtnro.setToolTipText("");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(41, 41, 41)
                .addComponent(jLabel1)
                .addGap(18, 18, 18)
                .addComponent(txtCliente, javax.swing.GroupLayout.PREFERRED_SIZE, 178, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLabel6)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(txtnro, javax.swing.GroupLayout.PREFERRED_SIZE, 129, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, 723, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel6)
                    .addComponent(txtnro, javax.swing.GroupLayout.PREFERRED_SIZE, 51, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel1)
                    .addComponent(txtCliente, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, 552, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(20, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents
        
    private void tablaClienteMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tablaClienteMouseClicked
        idCliente = tablaCliente.getValueAt(tablaCliente.getSelectedRow(),0).toString();
        String nombre = tablaCliente.getValueAt(tablaCliente.getSelectedRow(),1).toString();
        String apellidoPa = tablaCliente.getValueAt(tablaCliente.getSelectedRow(),2).toString();
        txtCliente.setText(nombre+" "+apellidoPa);
        Listar_clientes.setVisible(false);
    }//GEN-LAST:event_tablaClienteMouseClicked

    private void txtbuscarKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtbuscarKeyReleased
        if(txtbuscar.getText().trim().length()>0)
        listarCliente(txtbuscar.getText().trim());
    }//GEN-LAST:event_txtbuscarKeyReleased

    private void btnnuevoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnnuevoActionPerformed
        
        dlgCliente dialog = new dlgCliente(new javax.swing.JFrame(), true,new cClientes("","","","","","","","","m",""));
        Listar_clientes.setVisible(false);
        dialog.setVisible(true);
        listarCliente("");
        
    }//GEN-LAST:event_btnnuevoActionPerformed

    private void txtClienteMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_txtClienteMouseClicked
        Listar_clientes.setSize(353, 250);
        Listar_clientes.setVisible(true);
    }//GEN-LAST:event_txtClienteMouseClicked

    private void txtbuscarProductoKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtbuscarProductoKeyReleased
        if(txtbuscarProducto.getText().trim().length()>0)
        listarProducto(txtbuscarProducto.getText().trim());
    }//GEN-LAST:event_txtbuscarProductoKeyReleased

    private void tablaProductoMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tablaProductoMouseClicked
        idProducto=Integer.parseInt(tablaProducto.getValueAt(tablaProducto.getSelectedRow(),0).toString());
        nombreProducto=tablaProducto.getValueAt(tablaProducto.getSelectedRow(),1).toString();
        precio = Double.parseDouble(tablaProducto.getValueAt(tablaProducto.getSelectedRow(),3).toString());
    }//GEN-LAST:event_tablaProductoMouseClicked

    private void btnGuardarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnGuardarActionPerformed
        int numFila= tablaVenta.getRowCount();
        if(txtCliente.getText().length()>0 && numFila>0){
        
        BoletaDao boletadao = new BoletaDaoImp();
        cBoleta boleta_ = new cBoleta();
        
        cUsuario usu = new cUsuario();
                usu.setUsuario(FactoryConnectionDb.usuario);
                usu.setContrasenia(FactoryConnectionDb.contrasenia);
                usu.setIdEmpleado(FactoryConnectionDb.idEmpleado);
                usu.setIdUsuario(Integer.parseInt(FactoryConnectionDb.idUsuario));
        Calendar c = Calendar.getInstance();
        
        ProductoDao productodao = new ProductoDaoImp();
        
        String dia = Integer.toString(c.get(Calendar.DATE));
        String mes = Integer.toString(c.get(Calendar.MONTH));
        String annio = Integer.toString(c.get(Calendar.YEAR));

        boleta_.setIdBoleta(numBoleta("")+"");
        boleta_.setIdCliente(idCliente);
        boleta_.setIdEmpleado(usu.getIdEmpleado());
        boleta_.setFecha(annio+"-"+mes+"-"+dia);
        boleta_.setTotal(Double.parseDouble(txttotal.getText()));

        boletadao.insertar(boleta_);

        
        for (int i = 0; i < numFila; i++) {
            
            DetalleDao detalledao = new DetalleDaoImp();
            cDetalle detalle_ = new cDetalle();
            
            detalle_.setIdBoleta(numBoleta("")+"");
            detalle_.setIdDetalle(i+"");
            detalle_.setIdProducto(tablaVenta.getValueAt(i,0).toString());
            detalle_.setPrecioUnitario(Double.parseDouble(tablaVenta.getValueAt(i,2).toString()));
            detalle_.setPrecioTotal(Double.parseDouble(tablaVenta.getValueAt(i,4).toString()));
            detalle_.setCantidad(Integer.parseInt(tablaVenta.getValueAt(i,3).toString()));
            
            productodao.restarStock(Integer.parseInt(detalle_.getIdProducto()),detalle_.getCantidad());
            
            detalledao.insertar(detalle_);
            
        }
        
        JOptionPane.showMessageDialog(null, "Boleta grabada satisfactoriamente",
                FactoryConnectionDb.Mensaje,JOptionPane.INFORMATION_MESSAGE);
        new CReporte().imprimirBoleta(boleta_.getIdBoleta());
        
        limpiar();
        }
    }//GEN-LAST:event_btnGuardarActionPerformed

    private void txttotalActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txttotalActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txttotalActionPerformed

    private void btnquitarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnquitarActionPerformed
        if(idEliminar>-1 && txtCliente.getText().length()>0)
        dtmVenta.removeRow(idEliminar);
        preciototal();
    }//GEN-LAST:event_btnquitarActionPerformed

    private void btnagregarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnagregarActionPerformed
        if(Integer.parseInt(txtcantidad.getText())>0 && idProducto>0 && txtCliente.getText().length()>0){
            prePorCantidad = precio*Double.parseDouble(txtcantidad.getText());
            dtmVenta.addRow(new Object[]{idProducto,nombreProducto,precio,txtcantidad.getText(),prePorCantidad});
            preciototal();
            txtcantidad.setText("");
        }
    }//GEN-LAST:event_btnagregarActionPerformed

    private void tablaVentaMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tablaVentaMouseClicked
        
        idEliminar = tablaVenta.getSelectedRow();
    }//GEN-LAST:event_tablaVentaMouseClicked

    private void txtcantidadKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtcantidadKeyTyped
char c=evt.getKeyChar(); 
          if(Character.isLetter(c)) { 
              getToolkit().beep(); 
              evt.consume(); 
              JOptionPane.showMessageDialog(this,"Ingresa Solo Numeros"); 
          }         // TODO add your handling code here:
    }//GEN-LAST:event_txtcantidadKeyTyped

    public void limpiar(){
        int numFila= tablaVenta.getRowCount();

        for (int i = 0; i < numFila; i++) {
            dtmVenta.removeRow(0);
        }
        txtCliente.setText("");
        txtcantidad.setText("");
        txtnro.setText(numBoleta("")+"");
        idCliente="";   
        nombreProducto="";
        idProducto=-1;
        precio=0.00;
        prePorCantidad=0.00;
        idEliminar=-1;
        listarProducto("");
    }
     private void listarCliente(String texto){
        List<cClientes> list = empleadodao_.list(texto);
        e =new Object[4][list.size()];
        int i = 0;
        for (cClientes tr : list) {            
            e[0][i]=tr.getCod();
            e[1][i]=tr.getNombre();
            e[2][i]=tr.getApe_paterno()+" "+tr.getApe_materno();
            e[3][i]=tr.getDNI();  
            i++;
        }
        
        DefaultTableModel modelo=new DefaultTableModel(){
            public Class getColumnClass(int indiceColumna){
                Object stefany=getValueAt(0, indiceColumna);
                if(stefany == null){
                    return Object.class;
                }else{
                return stefany.getClass();
                }
               }
        };
        modelo.addColumn("idCliente",e[0]);
        modelo.addColumn("Nombre",e[1]);
        modelo.addColumn("Apellidos",e[2]);
        modelo.addColumn("DNI",e[3]);
        
        tablaCliente.setModel(modelo);
        
    }
    private int numBoleta(String texto){
        List<cBoleta> list = boletadao_.list(texto);
        e =new Object[1][list.size()];
        int i = 0;
        for (cBoleta tr : list) {            
            e[0][i]=tr.getIdBoleta();
            i++;
        }
        return i;
    }
     private void listarProducto(String texto){
        List<cProductos> list = productodao_.list(texto);
        p =new Object[5][list.size()];
        int i = 0;
        for (cProductos tr : list) {            
            p[0][i]=tr.getIdProducto()+"";
            p[1][i]=tr.getNomProducto();
            p[2][i]=tr.getStock();
            p[3][i]=tr.getPrecVenta();
            p[4][i]=tr.getDescripcionProducto();  
            i++;
        }
        
        DefaultTableModel modelo=new DefaultTableModel(){
            public Class getColumnClass(int indiceColumna){
                Object stefany=getValueAt(0, indiceColumna);
                if(stefany == null){
                    return Object.class;
                }else{
                return stefany.getClass();
                }
               }
        };
        modelo.addColumn("idProducto",p[0]);
        modelo.addColumn("Nombre",p[1]);
        modelo.addColumn("Stock",p[2]);
        modelo.addColumn("Precio",p[3]);
        modelo.addColumn("Descripcion",p[4]);
        
        tablaProducto.setModel(modelo);
        
    }
     void preciototal(){
         int numFilas = tablaVenta.getRowCount();
            double sum=0.00;
            for (int i = 0; i < numFilas; i++) {
                sum+= Double.parseDouble(tablaVenta.getValueAt(i,4).toString());
            }
            txttotal.setText(sum+"");
     }
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JDialog Listar_clientes;
    private javax.swing.JButton btnGuardar;
    private javax.swing.JButton btnagregar;
    private javax.swing.JButton btnnuevo;
    private javax.swing.JButton btnquitar;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane4;
    private javax.swing.JTable tablaCliente;
    private javax.swing.JTable tablaProducto;
    private javax.swing.JTable tablaVenta;
    private javax.swing.JTextField txtCliente;
    private javax.swing.JTextField txtbuscar;
    private javax.swing.JTextField txtbuscarProducto;
    private javax.swing.JTextField txtcantidad;
    private javax.swing.JTextField txtnro;
    private javax.swing.JTextField txttotal;
    // End of variables declaration//GEN-END:variables
}
