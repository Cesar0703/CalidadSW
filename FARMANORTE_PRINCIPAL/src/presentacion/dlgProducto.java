
package presentacion;

import dao.ProductoDao;
import dao.LaboratorioDao;
import dao.ProductoDaoImp;
import Factory.FactoryConnectionDb;
import dao.CategoriaDao;
import dao.CategoriaDaoImp;
import dao.LaboratorioDaoImp;
import dao.ProveedorDao;
import dao.ProveedorDaoImp;
import java.awt.BorderLayout;
import java.awt.event.KeyEvent;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JLayeredPane;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import model.cCategoria;
import model.cLaboratorio;

import model.cProductos;
import model.cProveedor;

public class dlgProducto extends javax.swing.JDialog {

    LaboratorioDao laboratoriodao_ = new LaboratorioDaoImp();
    Object[][] l;
    ProveedorDao proveedordao_ = new ProveedorDaoImp();
    Object[][] p;
    CategoriaDao categoriadao_ = new CategoriaDaoImp();
    Object[][] c;
    public dlgProducto(java.awt.Frame parent, boolean modal,cProductos producto_) {
        super(parent, modal);
        initComponents();
        listarCombo();
        setTitle("Producto"); //titulo del software
        ((JPanel)getContentPane()).setOpaque(false); 
        ImageIcon uno=new ImageIcon(this.getClass().getResource("/imagenes/fondo02.png"));
        JLabel fondo= new JLabel(); 
        fondo.setIcon(uno); 
        getLayeredPane().add(fondo,JLayeredPane.FRAME_CONTENT_LAYER);
        fondo.setBounds(0,0,uno.getIconWidth(),uno.getIconHeight());
        this.add(fondo, BorderLayout.CENTER);
   
        
        setLocationRelativeTo(null);
           
        int id = Integer.parseInt(producto_.getIdProducto());
           
        btnGrabar.setText(id==0?"Agregar":"Modificar");
        btnEliminar.setVisible(id>0);
        txtCodigo.setText(id+"");
        txtnom.setText(producto_.getNomProducto());
        txtstock.setText(producto_.getStock()+"");
        txtdesc.setText(producto_.getDescripcionProducto());
        txtprecioO.setText(producto_.getPrecOriginal()+"");
        txtpreciov.setText(producto_.getPrecVenta()+"");
        
        
        try {
            String[] name = comboName(producto_.getIdLaboratorio(),
                producto_.getIdCategoria(), producto_.getIdProveedor());
        
            comboLaboratorio.setSelectedItem(name[0]);
            comboCategoria.setSelectedItem(name[1]);
            comboProveedor.setSelectedItem(name[2]);
            Date date = new SimpleDateFormat("yyy-MM-dd").parse(producto_.getFechEmision());
            dateE.setDate(date);
            
            Date datv = new SimpleDateFormat("yyy-MM-dd").parse(producto_.getFechVencimiento());
            dateV.setDate(datv);
        } catch (ParseException ex) {            
        }catch (NullPointerException es){
            
        }
        
    }

   
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        lblDescripcion = new javax.swing.JLabel();
        lblCategoria = new javax.swing.JLabel();
        lblStock = new javax.swing.JLabel();
        lblPrecio = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        jButton3 = new javax.swing.JButton();
        lblDescripcion1 = new javax.swing.JLabel();
        lblDescripcion2 = new javax.swing.JLabel();
        lblDescripcion3 = new javax.swing.JLabel();
        lblDescripcion4 = new javax.swing.JLabel();
        lblDescripcion5 = new javax.swing.JLabel();
        lblDescripcion6 = new javax.swing.JLabel();
        lblDescripcion7 = new javax.swing.JLabel();
        txtnom = new javax.swing.JTextField();
        jScrollPane3 = new javax.swing.JScrollPane();
        txtdesc = new javax.swing.JTextArea();
        dateE = new com.toedter.calendar.JDateChooser();
        dateV = new com.toedter.calendar.JDateChooser();
        txtstock = new javax.swing.JTextField();
        txtprecioO = new javax.swing.JTextField();
        txtpreciov = new javax.swing.JTextField();
        txtCodigo = new javax.swing.JLabel();
        comboProveedor = new javax.swing.JComboBox();
        comboLaboratorio = new javax.swing.JComboBox();
        comboCategoria = new javax.swing.JComboBox();
        btnEliminar = new javax.swing.JButton();
        btnGrabar = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);

        jPanel1.setBorder(javax.swing.BorderFactory.createTitledBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.LOWERED), "", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Tahoma", 1, 14), new java.awt.Color(255, 255, 255))); // NOI18N
        jPanel1.setOpaque(false);

        lblDescripcion.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        lblDescripcion.setForeground(new java.awt.Color(255, 255, 255));
        lblDescripcion.setText("id");

        lblCategoria.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        lblCategoria.setForeground(new java.awt.Color(255, 255, 255));
        lblCategoria.setText("Fecha Vencimiento");

        lblStock.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        lblStock.setForeground(new java.awt.Color(255, 255, 255));
        lblStock.setText("Stock");

        lblPrecio.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        lblPrecio.setForeground(new java.awt.Color(255, 255, 255));
        lblPrecio.setText("Precio Original");

        jButton3.setText("LIMPIAR");

        lblDescripcion1.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        lblDescripcion1.setForeground(new java.awt.Color(255, 255, 255));
        lblDescripcion1.setText("Nombre");

        lblDescripcion2.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        lblDescripcion2.setForeground(new java.awt.Color(255, 255, 255));
        lblDescripcion2.setText("Laboratorio");

        lblDescripcion3.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        lblDescripcion3.setForeground(new java.awt.Color(255, 255, 255));
        lblDescripcion3.setText("Fecha Emision");

        lblDescripcion4.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        lblDescripcion4.setForeground(new java.awt.Color(255, 255, 255));
        lblDescripcion4.setText("Precio Venta");

        lblDescripcion5.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        lblDescripcion5.setForeground(new java.awt.Color(255, 255, 255));
        lblDescripcion5.setText("Categoria");

        lblDescripcion6.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        lblDescripcion6.setForeground(new java.awt.Color(255, 255, 255));
        lblDescripcion6.setText("Proveedor");

        lblDescripcion7.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        lblDescripcion7.setForeground(new java.awt.Color(255, 255, 255));
        lblDescripcion7.setText("Descripcion");

        txtdesc.setColumns(20);
        txtdesc.setRows(5);
        jScrollPane3.setViewportView(txtdesc);

        dateE.setDateFormatString("yyyy-MM-dd");

        dateV.setDateFormatString("yyyy-MM-dd");

        txtstock.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txtstockKeyTyped(evt);
            }
        });

        txtprecioO.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txtprecioOKeyTyped(evt);
            }
        });

        txtpreciov.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txtpreciovKeyTyped(evt);
            }
        });

        txtCodigo.setText("jLabel1");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(36, 36, 36)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(lblDescripcion)
                    .addComponent(lblDescripcion1)
                    .addComponent(lblDescripcion7)
                    .addComponent(lblDescripcion3)
                    .addComponent(lblPrecio)
                    .addComponent(lblDescripcion6))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 336, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(213, 213, 213)
                        .addComponent(jLabel8, javax.swing.GroupLayout.PREFERRED_SIZE, 1024, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                    .addComponent(comboProveedor, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(txtprecioO, javax.swing.GroupLayout.DEFAULT_SIZE, 101, Short.MAX_VALUE))
                                .addGap(23, 23, 23)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addGroup(jPanel1Layout.createSequentialGroup()
                                        .addComponent(lblDescripcion2)
                                        .addGap(18, 18, 18)
                                        .addComponent(comboLaboratorio, javax.swing.GroupLayout.PREFERRED_SIZE, 97, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addComponent(lblDescripcion4))
                                .addGap(18, 18, 18)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(txtpreciov, javax.swing.GroupLayout.PREFERRED_SIZE, 101, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addGroup(jPanel1Layout.createSequentialGroup()
                                        .addGap(10, 10, 10)
                                        .addComponent(lblDescripcion5)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(comboCategoria, javax.swing.GroupLayout.PREFERRED_SIZE, 97, javax.swing.GroupLayout.PREFERRED_SIZE))))
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(dateE, javax.swing.GroupLayout.PREFERRED_SIZE, 192, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(lblCategoria)
                                .addGap(18, 18, 18)
                                .addComponent(dateV, javax.swing.GroupLayout.PREFERRED_SIZE, 192, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(txtnom, javax.swing.GroupLayout.PREFERRED_SIZE, 203, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(74, 74, 74)
                                .addComponent(lblStock)
                                .addGap(18, 18, 18)
                                .addComponent(txtstock, javax.swing.GroupLayout.PREFERRED_SIZE, 101, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addComponent(txtCodigo))
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
            .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(jPanel1Layout.createSequentialGroup()
                    .addGap(0, 0, Short.MAX_VALUE)
                    .addComponent(jButton3)
                    .addGap(0, 0, Short.MAX_VALUE)))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(lblDescripcion)
                            .addComponent(txtCodigo))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(lblDescripcion1)
                            .addComponent(txtnom, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(lblStock)
                            .addComponent(txtstock, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(lblDescripcion7)
                                .addGap(31, 31, 31)
                                .addComponent(jLabel8))
                            .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 112, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(16, 16, 16)
                        .addComponent(lblDescripcion3))
                    .addComponent(dateE, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lblCategoria)
                    .addComponent(dateV, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblPrecio)
                    .addComponent(txtprecioO, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lblDescripcion4)
                    .addComponent(txtpreciov, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblDescripcion6)
                    .addComponent(lblDescripcion2)
                    .addComponent(comboProveedor, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(comboLaboratorio, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lblDescripcion5)
                    .addComponent(comboCategoria, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(55, Short.MAX_VALUE))
            .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(jPanel1Layout.createSequentialGroup()
                    .addGap(0, 145, Short.MAX_VALUE)
                    .addComponent(jButton3)
                    .addGap(0, 145, Short.MAX_VALUE)))
        );

        btnEliminar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/limpiar.png"))); // NOI18N
        btnEliminar.setText("ELIMINAR");
        btnEliminar.setAutoscrolls(true);
        btnEliminar.setBorder(javax.swing.BorderFactory.createEtchedBorder());
        btnEliminar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnEliminarActionPerformed(evt);
            }
        });

        btnGrabar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/Grabar.png"))); // NOI18N
        btnGrabar.setText("GRABAR");
        btnGrabar.setToolTipText("");
        btnGrabar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnGrabarActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(23, 23, 23)
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, 691, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(26, 26, 26)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(btnEliminar, javax.swing.GroupLayout.PREFERRED_SIZE, 157, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnGrabar, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(19, Short.MAX_VALUE)
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(23, 23, 23))
            .addGroup(layout.createSequentialGroup()
                .addGap(114, 114, 114)
                .addComponent(btnGrabar)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btnEliminar, javax.swing.GroupLayout.PREFERRED_SIZE, 73, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnGrabarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnGrabarActionPerformed
        ProductoDao productodao = new ProductoDaoImp();
        cProductos producto_ = new cProductos();

        String formato = dateE.getDateFormatString();
        SimpleDateFormat sdf = new SimpleDateFormat(formato);
        Date datE = dateE.getDate();
        String fechaE = String.valueOf(sdf.format(datE));
        Date datV = dateV.getDate();
        String fechaV = String.valueOf(sdf.format(datV));

        if(txtnom.getText().trim().length()==0){
            JOptionPane.showMessageDialog(null, "Error en el ingreso del Nombre",FactoryConnectionDb.Mensaje,JOptionPane.ERROR_MESSAGE);
            txtnom.requestFocus();
        }else if(txtstock.getText().trim().length()==0){
            JOptionPane.showMessageDialog(null, "Error en el ingreso de Stock",FactoryConnectionDb.Mensaje,JOptionPane.ERROR_MESSAGE);
            txtstock.requestFocus();
        }else if(txtdesc.getText().trim().length()==0){
            JOptionPane.showMessageDialog(null, "Error en el ingreso de Descripcion",FactoryConnectionDb.Mensaje,JOptionPane.ERROR_MESSAGE);
            txtdesc.requestFocus();
        }else if(fechaE.length()==0){
            JOptionPane.showMessageDialog(null, "Error en el ingreso de la fecha de Emision",FactoryConnectionDb.Mensaje,JOptionPane.ERROR_MESSAGE);
            dateE.requestFocus();
        }else if(fechaV.length()==0){
            JOptionPane.showMessageDialog(null, "Error en el ingreso de la Fechad e Vencimiento",FactoryConnectionDb.Mensaje,JOptionPane.ERROR_MESSAGE);
            dateV.requestFocus();
        }else if(txtprecioO.getText().trim().length()==0){
            JOptionPane.showMessageDialog(null, "Error en el ingreso del precio de Origen",FactoryConnectionDb.Mensaje,JOptionPane.ERROR_MESSAGE);
            txtprecioO.requestFocus();
        }else if(txtpreciov.getText().trim().length()==0){
            JOptionPane.showMessageDialog(null, "Error en el ingreso del predio de Venta",FactoryConnectionDb.Mensaje,JOptionPane.ERROR_MESSAGE);
            txtpreciov.requestFocus();
//        }else if(txtproveedor.getText().trim().length()==0){
//            JOptionPane.showMessageDialog(null, "Error en el ingreso del Proveedor",FactoryConnectionDb.Mensaje,JOptionPane.ERROR_MESSAGE);
//            txtproveedor.requestFocus();
//        }else if(txtlabo.getText().trim().length()==0){
//            JOptionPane.showMessageDialog(null, "Error en el ingreso del Laboratorio",FactoryConnectionDb.Mensaje,JOptionPane.ERROR_MESSAGE);
//            txtlabo.requestFocus();
//        }else if(txtcatg.getText().trim().length()==0){
//            JOptionPane.showMessageDialog(null, "Error en el ingreso de la Categoria",FactoryConnectionDb.Mensaje,JOptionPane.ERROR_MESSAGE);
//            txtcatg.requestFocus();
        }else{

            producto_.setIdProducto(txtCodigo.getText());
            producto_.setNomProducto(txtnom.getText());
            producto_.setStock(Integer.parseInt(txtstock.getText()));
            producto_.setDescripcionProducto(txtdesc.getText());
            producto_.setFechEmision(fechaE);
            producto_.setFechVencimiento(fechaV);
            producto_.setPrecOriginal(Double.parseDouble(txtprecioO.getText()));
            producto_.setPrecVenta(Double.parseDouble(txtpreciov.getText()));
            
            String[] id = comboId(comboLaboratorio.getSelectedItem().toString(),
                        comboCategoria.getSelectedItem().toString() ,
                        comboProveedor.getSelectedItem().toString());
            
            producto_.setIdLaboratorio(id[0]);
            producto_.setIdCategoria(id[1]);
            producto_.setIdProveedor(id[2]);

            if(Integer.parseInt(producto_.getIdProducto())>0){
                productodao.modificar(producto_);
                JOptionPane.showMessageDialog(null, "Producto modificado correctamente",FactoryConnectionDb.Mensaje,JOptionPane.INFORMATION_MESSAGE);
            }
            else{
                productodao.insertar(producto_);
                JOptionPane.showMessageDialog(null, "Producto ingresado correctamente",FactoryConnectionDb.Mensaje,JOptionPane.INFORMATION_MESSAGE);
            }
            dispose();
        }
    }//GEN-LAST:event_btnGrabarActionPerformed

    private void btnEliminarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnEliminarActionPerformed
        int confirmacion = JOptionPane.showConfirmDialog (null, "Desea eliminar este Producto?",FactoryConnectionDb.Mensaje,JOptionPane.YES_NO_OPTION);
        if(JOptionPane.YES_OPTION==confirmacion){
            ProductoDao productodao = new ProductoDaoImp();
            productodao.eliminar(Integer.parseInt(txtCodigo.getText()));
            JOptionPane.showMessageDialog(null, "Producto eliminado ",FactoryConnectionDb.Mensaje,JOptionPane.INFORMATION_MESSAGE);
            dispose();
        }
    }//GEN-LAST:event_btnEliminarActionPerformed

    private void txtstockKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtstockKeyTyped
char c=evt.getKeyChar(); 
          if(Character.isLetter(c)) { 
              getToolkit().beep(); 
              evt.consume(); 
              JOptionPane.showMessageDialog(this,"Ingresa Solo Numeros"); 
          }         // TODO add your handling code here:
    }//GEN-LAST:event_txtstockKeyTyped

    private void txtprecioOKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtprecioOKeyTyped
char caracter = evt.getKeyChar();
                if(((caracter < '0') || (caracter > '9')) && (caracter != KeyEvent.VK_BACK_SPACE)
                                && (caracter !='.')){
                                  JOptionPane.showMessageDialog(this,"Ingresa Solo Numeros y un punto"); 

                evt.consume();
                }   
                if (caracter == '.' && txtprecioO.getText().contains(".")) {
                evt.consume();}
    }//GEN-LAST:event_txtprecioOKeyTyped

    private void txtpreciovKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtpreciovKeyTyped
    char caracter = evt.getKeyChar();
                if(((caracter < '0') || (caracter > '9')) && (caracter != KeyEvent.VK_BACK_SPACE)
                                && (caracter !='.')){
                                  JOptionPane.showMessageDialog(this,"Ingresa Solo Numeros y un punto"); 

                evt.consume();
                }   
                if (caracter == '.' && txtpreciov.getText().contains(".")) {
                evt.consume();
}     // TODO add your handling code here:
    }//GEN-LAST:event_txtpreciovKeyTyped


    private void listarCombo(){
        List<cLaboratorio> listl = laboratoriodao_.list("");
        List<cCategoria> listc = categoriadao_.list("");
        List<cProveedor> listp = proveedordao_.list("");
        
        for (cLaboratorio tr : listl) {   
            comboLaboratorio.addItem(tr.getNomLaboratorio());
        }
        for (cCategoria tr : listc) {   
            comboCategoria.addItem(tr.getNomCategoria());
        }
        for (cProveedor tr : listp) {   
            comboProveedor.addItem(tr.getNomProveedor());
        }
    }
    private String[] comboName(String idLaboratorio, String idCategoria, String idProveedor){
        List<cLaboratorio> listl = laboratoriodao_.list("");
        List<cCategoria> listc = categoriadao_.list("");
        List<cProveedor> listp = proveedordao_.list("");
        
        String[] name = new String[3];
        
        l =new Object[2][listl.size()];   
        c =new Object[2][listc.size()];  
        p =new Object[2][listp.size()]; 
        
        int i = 0;
        for (cLaboratorio tr : listl) {   
            l[0][i]=tr.getIdLaboratorio();
            l[1][i]=tr.getNomLaboratorio(); 

            if(idLaboratorio.equals(l[0][i].toString())){
                name[0]=l[1][i].toString(); 
                break;
            }
            i++;
        } 
        i = 0;
        for (cCategoria tr : listc) {   
            c[0][i]=tr.getIdCategoria();
            c[1][i]=tr.getNomCategoria(); 

            if(idCategoria.equals(c[0][i].toString())){
                name[1]=c[1][i].toString(); 
                break;
            }
            i++;
        }
        i = 0;
        for (cProveedor tr : listp) {   
            p[0][i]=tr.getIdProveedor();
            p[1][i]=tr.getNomProveedor(); 

            if(idProveedor.equals(p[0][i].toString())){
                name[2]=p[1][i].toString(); 
                break;
            }
            i++;
        }

        return name;
        
    }
    private String[] comboId(String nameLaboratorio, String nameCategoria, String nameProveedor){
        List<cLaboratorio> listl = laboratoriodao_.list("");
        List<cCategoria> listc = categoriadao_.list("");
        List<cProveedor> listp = proveedordao_.list("");
        
        String[] id = new String[3];
        
        l =new Object[2][listl.size()];   
        c =new Object[2][listc.size()];  
        p =new Object[2][listp.size()]; 
        
        int i = 0;
        for (cLaboratorio tr : listl) {   
            l[0][i]=tr.getIdLaboratorio();
            l[1][i]=tr.getNomLaboratorio(); 

            if(nameLaboratorio.equals(l[1][i].toString())){
                id[0]=l[0][i].toString(); 
                break;
            }
            i++;
        } 
        i = 0;
        for (cCategoria tr : listc) {   
            c[0][i]=tr.getIdCategoria();
            c[1][i]=tr.getNomCategoria(); 

            if(nameCategoria.equals(c[1][i].toString())){
                id[1]=c[0][i].toString(); 
                break;
            }
            i++;
        }
        i = 0;
        for (cProveedor tr : listp) {   
            p[0][i]=tr.getIdProveedor();
            p[1][i]=tr.getNomProveedor(); 

            if(nameProveedor.equals(p[1][i].toString())){
                id[2]=p[0][i].toString(); 
                break;
            }
            i++;
        }

        return id;
        
    }
    
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnEliminar;
    private javax.swing.JButton btnGrabar;
    private javax.swing.JComboBox comboCategoria;
    private javax.swing.JComboBox comboLaboratorio;
    private javax.swing.JComboBox comboProveedor;
    private com.toedter.calendar.JDateChooser dateE;
    private com.toedter.calendar.JDateChooser dateV;
    private javax.swing.JButton jButton3;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JLabel lblCategoria;
    private javax.swing.JLabel lblDescripcion;
    private javax.swing.JLabel lblDescripcion1;
    private javax.swing.JLabel lblDescripcion2;
    private javax.swing.JLabel lblDescripcion3;
    private javax.swing.JLabel lblDescripcion4;
    private javax.swing.JLabel lblDescripcion5;
    private javax.swing.JLabel lblDescripcion6;
    private javax.swing.JLabel lblDescripcion7;
    private javax.swing.JLabel lblPrecio;
    private javax.swing.JLabel lblStock;
    private javax.swing.JLabel txtCodigo;
    private javax.swing.JTextArea txtdesc;
    private javax.swing.JTextField txtnom;
    private javax.swing.JTextField txtprecioO;
    private javax.swing.JTextField txtpreciov;
    private javax.swing.JTextField txtstock;
    // End of variables declaration//GEN-END:variables
}
