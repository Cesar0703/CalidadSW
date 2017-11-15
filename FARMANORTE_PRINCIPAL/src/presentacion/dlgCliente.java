
package presentacion;
import Factory.FactoryConnectionDb;
import dao.ClienteDao;
import dao.ClienteDaoImp;
import java.awt.BorderLayout;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import javax.swing.ImageIcon;
import javax.swing.JComponent;
import javax.swing.JLabel;
import javax.swing.JLayeredPane;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import model.cClientes;

public class dlgCliente extends javax.swing.JDialog {

    /**
     * Creates new form dlgCliente
     */
    public dlgCliente(java.awt.Frame parent, boolean modal,cClientes cliente_) {
        super(parent, modal);
        initComponents();
        
        setTitle("Cliente"); //titulo del software
        ((JPanel)getContentPane()).setOpaque(false); 
        ImageIcon uno=new ImageIcon(this.getClass().getResource("/imagenes/fondo02.png"));
        JLabel fondo= new JLabel(); 
        fondo.setIcon(uno); 
        getLayeredPane().add(fondo,JLayeredPane.FRAME_CONTENT_LAYER);
        fondo.setBounds(0,0,uno.getIconWidth(),uno.getIconHeight());
        this.add(fondo, BorderLayout.CENTER);
   
        int id =Integer.parseInt(cliente_.getCod());
        btnGrabar.setText(id==0?"Agregar":"Modificar");
        btnEliminar.setVisible(id>0);
        lblId.setText(id+"");
        txtnombre.setText(cliente_.getNombre());
        txtapellidoPa.setText(cliente_.getApe_paterno());
        txtapellidoMa.setText(cliente_.getApe_materno());
        try {
            Date date = new SimpleDateFormat("yyy-MM-dd").parse(cliente_.getFechNacimiento());
            dateC.setDate(date);
        } catch (ParseException ex) {
            
        }
        txtDNI.setText(cliente_.getDNI());
        if ((cliente_.getSexo()+"").equals("m")) {
            rbMas.setSelected(true);            
        }else if ((cliente_.getSexo()+"").equals("f")) {
            rbFe.setSelected(true);            
        } 
        txtdireccion.setText(cliente_.getDireccion());
        txttelefono.setText(cliente_.getTelefono());
        txtcorreo.setText(cliente_.getEmail());
        
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        buttonGroup1 = new javax.swing.ButtonGroup();
        btnEliminar = new javax.swing.JButton();
        btnGrabar = new javax.swing.JButton();
        jPanel1 = new javax.swing.JPanel();
        lblCodigo = new javax.swing.JLabel();
        lblNombre = new javax.swing.JLabel();
        lblApellido = new javax.swing.JLabel();
        lblDireccion = new javax.swing.JLabel();
        lblCorreo = new javax.swing.JLabel();
        lblDni = new javax.swing.JLabel();
        lblTelefono = new javax.swing.JLabel();
        txtDNI = new javax.swing.JTextField();
        txtnombre = new javax.swing.JTextField();
        txtapellidoPa = new javax.swing.JTextField();
        txtapellidoMa = new javax.swing.JTextField();
        lblApellido1 = new javax.swing.JLabel();
        lblApellido2 = new javax.swing.JLabel();
        lblDni1 = new javax.swing.JLabel();
        txtdireccion = new javax.swing.JTextField();
        txttelefono = new javax.swing.JTextField();
        txtcorreo = new javax.swing.JTextField();
        rbMas = new javax.swing.JRadioButton();
        rbFe = new javax.swing.JRadioButton();
        dateC = new com.toedter.calendar.JDateChooser();
        lblId = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);

        btnEliminar.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        btnEliminar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/limpiar.png"))); // NOI18N
        btnEliminar.setText("Eliminar");
        btnEliminar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnEliminarActionPerformed(evt);
            }
        });

        btnGrabar.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        btnGrabar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/Grabar.png"))); // NOI18N
        btnGrabar.setText("Grabar");
        btnGrabar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnGrabarActionPerformed(evt);
            }
        });

        jPanel1.setBorder(javax.swing.BorderFactory.createTitledBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.LOWERED), "", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Tahoma", 1, 14), new java.awt.Color(255, 255, 255))); // NOI18N
        jPanel1.setOpaque(false);

        lblCodigo.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        lblCodigo.setForeground(new java.awt.Color(255, 255, 255));
        lblCodigo.setText("id");

        lblNombre.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        lblNombre.setForeground(new java.awt.Color(255, 255, 255));
        lblNombre.setText("Nombre");

        lblApellido.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        lblApellido.setForeground(new java.awt.Color(255, 255, 255));
        lblApellido.setText("Apellido Paterno");

        lblDireccion.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        lblDireccion.setForeground(new java.awt.Color(255, 255, 255));
        lblDireccion.setText("Dirección");

        lblCorreo.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        lblCorreo.setForeground(new java.awt.Color(255, 255, 255));
        lblCorreo.setText("Correo Electrónico");

        lblDni.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        lblDni.setForeground(new java.awt.Color(255, 255, 255));
        lblDni.setText("DNI");

        lblTelefono.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        lblTelefono.setForeground(new java.awt.Color(255, 255, 255));
        lblTelefono.setText("Teléfono");

        txtDNI.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.LOWERED));
        txtDNI.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txtDNIKeyTyped(evt);
            }
        });

        txtnombre.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.LOWERED));
        txtnombre.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txtnombreKeyTyped(evt);
            }
        });

        txtapellidoPa.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.LOWERED));
        txtapellidoPa.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txtapellidoPaKeyTyped(evt);
            }
        });

        txtapellidoMa.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.LOWERED));
        txtapellidoMa.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txtapellidoMaKeyTyped(evt);
            }
        });

        lblApellido1.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        lblApellido1.setForeground(new java.awt.Color(255, 255, 255));
        lblApellido1.setText("Apellido Materno");

        lblApellido2.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        lblApellido2.setForeground(new java.awt.Color(255, 255, 255));
        lblApellido2.setText("Fecha de Nacimiento");

        lblDni1.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        lblDni1.setForeground(new java.awt.Color(255, 255, 255));
        lblDni1.setText("Sexo");

        txtdireccion.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.LOWERED));

        txttelefono.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.LOWERED));
        txttelefono.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txttelefonoKeyTyped(evt);
            }
        });

        txtcorreo.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.LOWERED));
        txtcorreo.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusLost(java.awt.event.FocusEvent evt) {
                txtcorreoFocusLost(evt);
            }
        });

        buttonGroup1.add(rbMas);
        rbMas.setText("Masculino");

        buttonGroup1.add(rbFe);
        rbFe.setText("Femenino");

        dateC.setDateFormatString("yyyy-MM-dd");
        dateC.setMaxSelectableDate(new java.util.Date(852098486000L));
        dateC.setMinSelectableDate(new java.util.Date(-631130314000L));

        lblId.setText("jLabel1");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(46, 46, 46)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(lblApellido)
                    .addComponent(lblNombre)
                    .addComponent(lblCodigo))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                        .addComponent(txtapellidoPa, javax.swing.GroupLayout.DEFAULT_SIZE, 97, Short.MAX_VALUE)
                        .addComponent(txtnombre))
                    .addComponent(lblId))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addGap(23, 23, 23)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(lblDireccion)
                    .addComponent(lblApellido2)
                    .addComponent(lblCorreo))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(txtdireccion)
                            .addComponent(dateC, javax.swing.GroupLayout.PREFERRED_SIZE, 163, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(81, 81, 81)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addComponent(lblApellido1)
                                    .addComponent(lblDni))
                                .addGap(18, 18, 18)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(txtapellidoMa)
                                    .addComponent(txtDNI)))
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGap(51, 51, 51)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addComponent(lblDni1)
                                    .addComponent(lblTelefono))
                                .addGap(18, 18, 18)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addGroup(jPanel1Layout.createSequentialGroup()
                                        .addComponent(rbMas)
                                        .addGap(18, 18, 18)
                                        .addComponent(rbFe))
                                    .addComponent(txttelefono))))
                        .addContainerGap(20, Short.MAX_VALUE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(txtcorreo, javax.swing.GroupLayout.PREFERRED_SIZE, 238, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(9, 9, 9)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblCodigo)
                    .addComponent(lblId))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(txtnombre, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(lblNombre))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(lblApellido)
                            .addComponent(txtapellidoPa, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(lblApellido2)
                            .addComponent(dateC, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(8, 8, 8)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(lblDireccion)
                            .addComponent(txtdireccion, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(lblDni)
                            .addComponent(txtDNI, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(9, 9, 9)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(lblApellido1)
                            .addComponent(txtapellidoMa, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(lblDni1)
                            .addComponent(rbMas)
                            .addComponent(rbFe))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(lblTelefono)
                            .addComponent(txttelefono, javax.swing.GroupLayout.PREFERRED_SIZE, 18, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addGap(9, 9, 9)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblCorreo)
                    .addComponent(txtcorreo, javax.swing.GroupLayout.PREFERRED_SIZE, 18, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(16, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(btnGrabar, javax.swing.GroupLayout.PREFERRED_SIZE, 147, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnEliminar, javax.swing.GroupLayout.PREFERRED_SIZE, 145, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(24, 24, 24)
                .addComponent(btnGrabar)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(btnEliminar)
                .addContainerGap(25, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnEliminarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnEliminarActionPerformed
        int confirmacion = JOptionPane.showConfirmDialog (null, "Desea eliminar a este cliente?",FactoryConnectionDb.Mensaje,JOptionPane.YES_NO_OPTION);
        if(JOptionPane.YES_OPTION==confirmacion){
            ClienteDao clientedao = new ClienteDaoImp();
            clientedao.eliminar(Integer.parseInt(lblId.getText()));
            JOptionPane.showMessageDialog(null, "Cliente eliminado ",FactoryConnectionDb.Mensaje,JOptionPane.INFORMATION_MESSAGE);
            dispose();
        }
    }//GEN-LAST:event_btnEliminarActionPerformed

    private void btnGrabarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnGrabarActionPerformed
        ClienteDao clientedao = new ClienteDaoImp();
        cClientes cliente_ = new cClientes("","","","","","","","","","");
        
        String formato = dateC.getDateFormatString();
        SimpleDateFormat sdf = new SimpleDateFormat(formato);        
        Date datE = dateC.getDate();
        String fechaC = String.valueOf(sdf.format(datE));    
        
        if(txtnombre.getText().trim().length()==0){
            JOptionPane.showMessageDialog(null, "Error en el ingreso del nombre",FactoryConnectionDb.Mensaje,JOptionPane.ERROR_MESSAGE);
            txtnombre.requestFocus();        
        }else if(txtapellidoPa.getText().trim().length()==0){
            JOptionPane.showMessageDialog(null, "Error en el ingreso del Apellido paterno",FactoryConnectionDb.Mensaje,JOptionPane.ERROR_MESSAGE);
            txtapellidoPa.requestFocus();
        }else if(txtapellidoMa.getText().trim().length()==0){
            JOptionPane.showMessageDialog(null, "Error en el ingreso del Apellido Materno",FactoryConnectionDb.Mensaje,JOptionPane.ERROR_MESSAGE);
            txtapellidoMa.requestFocus();
        }else if(txtDNI.getText().trim().length()==0){
            JOptionPane.showMessageDialog(null, "Error en el ingreso del DNI",FactoryConnectionDb.Mensaje,JOptionPane.ERROR_MESSAGE);
            txtDNI.requestFocus();
        }else{
            cliente_.setCod(lblId.getText());
            cliente_.setNombre(txtnombre.getText());
            cliente_.setApe_paterno(txtapellidoPa.getText());
            cliente_.setApe_materno(txtapellidoMa.getText());
            cliente_.setFechNacimiento(fechaC);
            cliente_.setDNI(txtDNI.getText());
            cliente_.setSexo((rbMas.isSelected())?"m":"f");
            cliente_.setDireccion(txtdireccion.getText());
            cliente_.setTelefono(txttelefono.getText());
            cliente_.setEmail(txtcorreo.getText());
            
            if(Integer.parseInt(cliente_.getCod())>0){
                clientedao.modificar(cliente_);                
                JOptionPane.showMessageDialog(null, "Datos del cliente modificados correctamente",FactoryConnectionDb.Mensaje,JOptionPane.INFORMATION_MESSAGE);
            }                
            else{
                clientedao.insertar(cliente_);
                JOptionPane.showMessageDialog(null, "Datos del cliente ingresados correctamente",FactoryConnectionDb.Mensaje,JOptionPane.INFORMATION_MESSAGE);
            }
            dispose();            
        } 
    }//GEN-LAST:event_btnGrabarActionPerformed

    private void txtDNIKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtDNIKeyTyped
        char c=evt.getKeyChar(); 
          if(Character.isLetter(c) || txtDNI.getText().length()>7 ) { 
              getToolkit().beep(); 
              evt.consume(); 
              JOptionPane.showMessageDialog(this,"Ingresa Solo Numeros. 8 digitos maximo"); 
          }         // TODO add your handling code here:        // TODO add your handling code here:
    }//GEN-LAST:event_txtDNIKeyTyped

    private void txttelefonoKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txttelefonoKeyTyped
char c=evt.getKeyChar(); 
          if(Character.isLetter(c)) { 
              getToolkit().beep(); 
              evt.consume(); 
              JOptionPane.showMessageDialog(this,"Ingresa Solo Numeros"); 
          }         // TODO add your handling code here:        // TODO add your handling code here:
    }//GEN-LAST:event_txttelefonoKeyTyped

    private void txtnombreKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtnombreKeyTyped
        char c=evt.getKeyChar(); 
          if(Character.isDigit(c)) { 
              getToolkit().beep(); 
              evt.consume(); 
              JOptionPane.showMessageDialog(this,"Ingresa Solo Letras"); 
          } 
    }//GEN-LAST:event_txtnombreKeyTyped

    private void txtapellidoPaKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtapellidoPaKeyTyped
char c=evt.getKeyChar(); 
          if(Character.isDigit(c)) { 
              getToolkit().beep(); 
              evt.consume(); 
              JOptionPane.showMessageDialog(this,"Ingresa Solo Letras"); 
          }         // TODO add your handling code here:
    }//GEN-LAST:event_txtapellidoPaKeyTyped

    private void txtapellidoMaKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtapellidoMaKeyTyped
char c=evt.getKeyChar(); 
          if(Character.isDigit(c)) { 
              getToolkit().beep(); 
              evt.consume(); 
              JOptionPane.showMessageDialog(this,"Ingresa Solo Letras"); 
          }         // TODO add your handling code here:
    }//GEN-LAST:event_txtapellidoMaKeyTyped

    private void txtcorreoFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_txtcorreoFocusLost
       
    }//GEN-LAST:event_txtcorreoFocusLost

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnEliminar;
    private javax.swing.JButton btnGrabar;
    private javax.swing.ButtonGroup buttonGroup1;
    private com.toedter.calendar.JDateChooser dateC;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JLabel lblApellido;
    private javax.swing.JLabel lblApellido1;
    private javax.swing.JLabel lblApellido2;
    private javax.swing.JLabel lblCodigo;
    private javax.swing.JLabel lblCorreo;
    private javax.swing.JLabel lblDireccion;
    private javax.swing.JLabel lblDni;
    private javax.swing.JLabel lblDni1;
    private javax.swing.JLabel lblId;
    private javax.swing.JLabel lblNombre;
    private javax.swing.JLabel lblTelefono;
    private javax.swing.JRadioButton rbFe;
    private javax.swing.JRadioButton rbMas;
    private javax.swing.JTextField txtDNI;
    private javax.swing.JTextField txtapellidoMa;
    private javax.swing.JTextField txtapellidoPa;
    private javax.swing.JTextField txtcorreo;
    private javax.swing.JTextField txtdireccion;
    private javax.swing.JTextField txtnombre;
    private javax.swing.JTextField txttelefono;
    // End of variables declaration//GEN-END:variables
}
