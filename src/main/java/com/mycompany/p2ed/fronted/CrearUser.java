/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.p2ed.fronted;

import com.mycompany.p2ed.Informacion.Almacenamiento;
import com.mycompany.p2ed.Nodos.NodeHash;
import com.mycompany.p2ed.objetos.Usuario;
import javax.swing.JOptionPane;

/**
 *
 * @author sergi
 */
public class CrearUser extends javax.swing.JFrame {

    private boolean isAdd = true;
    Almacenamiento almacenamiento;
    private Usuario user;
    /**
     * Creates new form CrearUser
     */
    public CrearUser(Almacenamiento almacenamiento) {
        initComponents();
        this.almacenamiento = almacenamiento;
    }
    public CrearUser(Almacenamiento almacenamiento,String id,Usuario user){
        initComponents();
        this.almacenamiento = almacenamiento;
        isAdd= false;
        txtId.setText(id);
        txtId.setEnabled(false);
        this.user = user;
        txName.setText(user.getNombre());
        txtPass.setText(user.getPassword());
        cmbTipo.setSelectedItem(user.getTipo());
        cmbTipo.setEnabled(false);
        lblTitle.setText("Modificar Usuario");
    }
    
    private void add(){
        try{
            int id = Integer.parseInt(txtId.getText());
            String name = txName.getText();
            String pass = txtPass.getText();
            String tipo = (String) cmbTipo.getSelectedItem();
            Usuario user = new Usuario(id,name,pass,tipo);
            if(tipo.equalsIgnoreCase("estudiante")){            
                    NodeHash estud = almacenamiento.getHash().getNode(id);
                    if(estud ==  null){
                            JOptionPane.showMessageDialog(this,"No exite el estudiante con el carnet: " + id);                            
                    }else{
                        user.setEstudiante(estud);
                        boolean bol = almacenamiento.getListUsers().push(String.valueOf(id),user);
                        if (bol) {
                            JOptionPane.showMessageDialog(this,"Usuario ingresado");
                            this.dispose();
                        }else{
                            JOptionPane.showMessageDialog(this,"Ya existe el id del usuario: " + id);
                        }
                            
                    }
            }else{            
                    boolean bol = almacenamiento.getListUsers().push(String.valueOf(id),user);
                    if (bol) {
                        JOptionPane.showMessageDialog(this,"Usuario ingresado");
                        this.dispose();
                    }else{
                        JOptionPane.showMessageDialog(this,"Ya existe el id del usuario: " + id);
                    }
            }
        }catch(Exception e){
            JOptionPane.showMessageDialog(this,"Error al ingresar el usuario: " + e.getMessage());
        }
    }
    
    private void mod(){
        try{
            int id = Integer.parseInt(txtId.getText());
            String name = txName.getText();
            String pass = txtPass.getText();
            String tipo = (String) cmbTipo.getSelectedItem();
            if(tipo.equalsIgnoreCase("estudiante")){            
                    NodeHash estud = almacenamiento.getHash().getNode(id);
                    if(estud ==  null){
                            JOptionPane.showMessageDialog(this,"No exite el estudiante con el carnet: " + id);                            
                    }else{
                        user.setEstudiante(estud);
                        user.setNombre(name);
                        user.setPassword(pass);
                        user.setTipo(tipo);
                        boolean bol = almacenamiento.getListUsers().modificar(String.valueOf(id),user);
                        if (bol) {
                            JOptionPane.showMessageDialog(this,"Usuario Modificado");
                            this.dispose();
                        }else{
                            JOptionPane.showMessageDialog(this,"No exite el usuario: " + id);
                        }
                            
                    }
            }else{      
                    user.setNombre(name);
                    user.setPassword(pass);
                    user.setTipo(tipo);
                    boolean bol = almacenamiento.getListUsers().modificar(String.valueOf(id), user);
                    if (bol) {
                        JOptionPane.showMessageDialog(this,"Usuario Modificado");
                        this.dispose();
                    }else{
                        JOptionPane.showMessageDialog(this,"No se encontro el usuario : " + id);
                    }
            }
            
            
        }catch(Exception e){
             JOptionPane.showMessageDialog(this,"Error al modificar el usuario: " + e.getMessage());
        }
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        jButton1 = new javax.swing.JButton();
        txtId = new javax.swing.JTextField();
        txName = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();
        txtPass = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        cmbTipo = new javax.swing.JComboBox<>();
        lblTitle = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Usuario");

        jLabel1.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel1.setText("ID");

        jButton1.setText("Aceptar");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        txtId.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N

        txName.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N

        jLabel2.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel2.setText("Nombre");

        txtPass.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N

        jLabel3.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel3.setText("Contraseña");

        jLabel4.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel4.setText("ID");

        cmbTipo.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "colaborador", "estudiante" }));

        lblTitle.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        lblTitle.setText("Crear Usuario");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 114, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jButton1)
                            .addComponent(txtId, javax.swing.GroupLayout.PREFERRED_SIZE, 210, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 114, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(txName, javax.swing.GroupLayout.PREFERRED_SIZE, 210, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 114, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(txtPass, javax.swing.GroupLayout.PREFERRED_SIZE, 210, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 114, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(cmbTipo, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                .addContainerGap(102, Short.MAX_VALUE))
            .addGroup(layout.createSequentialGroup()
                .addGap(120, 120, 120)
                .addComponent(lblTitle, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(22, 22, 22)
                .addComponent(lblTitle, javax.swing.GroupLayout.PREFERRED_SIZE, 22, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(txtId, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(txName, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3)
                    .addComponent(txtPass, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel4)
                    .addComponent(cmbTipo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 62, Short.MAX_VALUE)
                .addComponent(jButton1)
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        // TODO add your handling code here:        
        if (isAdd) {
            add();
        }else{
            mod();
        }
    }//GEN-LAST:event_jButton1ActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JComboBox<String> cmbTipo;
    private javax.swing.JButton jButton1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel lblTitle;
    private javax.swing.JTextField txName;
    private javax.swing.JTextField txtId;
    private javax.swing.JTextField txtPass;
    // End of variables declaration//GEN-END:variables
}
