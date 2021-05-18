/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.p2ed.fronted;

import com.mycompany.p2ed.Informacion.Almacenamiento;
import com.mycompany.p2ed.fronted.Reportes.CursoEstudiante;
import com.mycompany.p2ed.fronted.Reportes.NotasEstudiante;

/**
 *
 * @author sergi
 */
public class MenuEstudiante extends javax.swing.JFrame {
    
    private Almacenamiento almacenamiento;
    private int carnet;
    /**
     * Creates new form MenuEstudiante
     */
    public MenuEstudiante(Almacenamiento almacenamiento, int carnet,String name) {
        initComponents();
        this.almacenamiento = almacenamiento;
        this.carnet = carnet;       
        lblId.setText("Carnet: "+String.valueOf(carnet));
        lblName.setText("Nombre: "+name);
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        lblId = new javax.swing.JLabel();
        lblName = new javax.swing.JLabel();
        jMenuBar1 = new javax.swing.JMenuBar();
        cargarDatos = new javax.swing.JMenu();
        jSeparator1 = new javax.swing.JPopupMenu.Separator();
        logout = new javax.swing.JMenuItem();
        jMenu3 = new javax.swing.JMenu();
        cursoEstudiante = new javax.swing.JMenuItem();
        NotasSemestre = new javax.swing.JMenuItem();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        lblId.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        lblId.setText("Id:");

        lblName.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        lblName.setText("Nombre:");

        cargarDatos.setText("Opciones");
        cargarDatos.add(jSeparator1);

        logout.setText("Cerrar Sesion");
        logout.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                logoutActionPerformed(evt);
            }
        });
        cargarDatos.add(logout);

        jMenuBar1.add(cargarDatos);

        jMenu3.setText("Reportes");

        cursoEstudiante.setText("Cursos llevados");
        cursoEstudiante.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cursoEstudianteActionPerformed(evt);
            }
        });
        jMenu3.add(cursoEstudiante);

        NotasSemestre.setText("Notas de cursos");
        NotasSemestre.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                NotasSemestreActionPerformed(evt);
            }
        });
        jMenu3.add(NotasSemestre);

        jMenuBar1.add(jMenu3);

        setJMenuBar(jMenuBar1);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(lblId, javax.swing.GroupLayout.DEFAULT_SIZE, 88, Short.MAX_VALUE)
                        .addGap(601, 601, 601))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(lblName)
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(lblId)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(lblName)
                .addContainerGap(355, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void logoutActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_logoutActionPerformed
        // TODO add your handling code here:
        Login login = new Login(almacenamiento);
        login.setLocationRelativeTo(null);
        login.setVisible(true);
        this.dispose();
    }//GEN-LAST:event_logoutActionPerformed

    private void cursoEstudianteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cursoEstudianteActionPerformed
        // TODO add your handling code here:
        CursoEstudiante curso = new CursoEstudiante(almacenamiento,carnet);
        curso.setLocationRelativeTo(null);
        curso.setVisible(true);
    }//GEN-LAST:event_cursoEstudianteActionPerformed

    private void NotasSemestreActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_NotasSemestreActionPerformed
        // TODO add your handling code here:
        NotasEstudiante notas = new NotasEstudiante(almacenamiento,carnet);
        notas.setLocationRelativeTo(null);
        notas.setVisible(true);
    }//GEN-LAST:event_NotasSemestreActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JMenuItem NotasSemestre;
    private javax.swing.JMenu cargarDatos;
    private javax.swing.JMenuItem cursoEstudiante;
    private javax.swing.JMenu jMenu3;
    private javax.swing.JMenuBar jMenuBar1;
    private javax.swing.JPopupMenu.Separator jSeparator1;
    private javax.swing.JLabel lblId;
    private javax.swing.JLabel lblName;
    private javax.swing.JMenuItem logout;
    // End of variables declaration//GEN-END:variables
}
