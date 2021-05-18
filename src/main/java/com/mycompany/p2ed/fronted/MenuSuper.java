/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.p2ed.fronted;

import com.mycompany.p2ed.CargaDatos;
import com.mycompany.p2ed.Dibujar;
import com.mycompany.p2ed.Informacion.Almacenamiento;
import com.mycompany.p2ed.Nodos.NodeCD;
import com.mycompany.p2ed.fronted.Opciones.*;
import com.mycompany.p2ed.fronted.Reportes.CursoEstudiante;
import com.mycompany.p2ed.objetos.Usuario;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.nio.charset.StandardCharsets;
import javax.swing.JOptionPane;

/**
 *
 * @author sergi
 */
public class MenuSuper extends javax.swing.JFrame {

    Almacenamiento almacenamiento;
    private Dibujar dibujar = new Dibujar();
    private FunctionsEdificio funEdificio;
    private FunctionsUsers funUser;
    private FunctionsSalones funSalon;
    private FunctionsCursos funCursos;
    private FunctionsEstudiante funEst;
    private FunctionsCatedratico funCat;
    private FunctionsAsignacion funAsig;
    private FunctionsHorario funHor;
    private FunctionsReportes funReport;
    /**
     * Creates new form MenuSuper
     * @param almacenamiento
     */
    public MenuSuper(Almacenamiento almacenamiento) {
        initComponents();
        this.almacenamiento = almacenamiento;
        funEdificio = new FunctionsEdificio(almacenamiento);
        funUser = new FunctionsUsers(almacenamiento,this);
        funSalon = new FunctionsSalones(almacenamiento,this);
        funCursos = new FunctionsCursos(almacenamiento,this);
        funEst = new FunctionsEstudiante(almacenamiento,this);
        funCat = new FunctionsCatedratico(almacenamiento,this);
        funAsig = new FunctionsAsignacion(almacenamiento,this);
        funHor = new FunctionsHorario(almacenamiento,this);
        funReport = new FunctionsReportes(almacenamiento,this);
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jMenuBar1 = new javax.swing.JMenuBar();
        cargarDatos = new javax.swing.JMenu();
        cargaDatos = new javax.swing.JMenuItem();
        jSeparator1 = new javax.swing.JPopupMenu.Separator();
        logout = new javax.swing.JMenuItem();
        jMenu1 = new javax.swing.JMenu();
        addUser = new javax.swing.JMenuItem();
        modUser = new javax.swing.JMenuItem();
        deleteUser = new javax.swing.JMenuItem();
        jMenu5 = new javax.swing.JMenu();
        addEdificio = new javax.swing.JMenuItem();
        deleteEdificio = new javax.swing.JMenuItem();
        jMenu6 = new javax.swing.JMenu();
        addSalon = new javax.swing.JMenuItem();
        modSalon = new javax.swing.JMenuItem();
        deleteSalon = new javax.swing.JMenuItem();
        jMenu7 = new javax.swing.JMenu();
        addCurso = new javax.swing.JMenuItem();
        modCurso = new javax.swing.JMenuItem();
        deleteCurso = new javax.swing.JMenuItem();
        jMenu8 = new javax.swing.JMenu();
        addEstudiante = new javax.swing.JMenuItem();
        modEstudiante = new javax.swing.JMenuItem();
        deleteEstudiante = new javax.swing.JMenuItem();
        jMenu9 = new javax.swing.JMenu();
        addCatedratico = new javax.swing.JMenuItem();
        modCatedratico = new javax.swing.JMenuItem();
        jMenu10 = new javax.swing.JMenu();
        addAsign = new javax.swing.JMenuItem();
        modAsig = new javax.swing.JMenuItem();
        deleteAsig = new javax.swing.JMenuItem();
        jMenu11 = new javax.swing.JMenu();
        modHorario = new javax.swing.JMenuItem();
        jMenu2 = new javax.swing.JMenu();
        treeCatedraticos = new javax.swing.JMenuItem();
        GraficarEdificiosSalones = new javax.swing.JMenuItem();
        verCursos = new javax.swing.JMenuItem();
        verUsuarios = new javax.swing.JMenuItem();
        verAsginaciones = new javax.swing.JMenuItem();
        verHorario = new javax.swing.JMenuItem();
        verEstudiantes = new javax.swing.JMenuItem();
        verTodo = new javax.swing.JMenuItem();
        jMenu3 = new javax.swing.JMenu();
        cursoEstudiante = new javax.swing.JMenuItem();
        EstudianteCurso = new javax.swing.JMenuItem();
        CursoSalon = new javax.swing.JMenuItem();
        NotasSemestre = new javax.swing.JMenuItem();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 718, Short.MAX_VALUE)
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 361, Short.MAX_VALUE)
        );

        cargarDatos.setText("Opciones");

        cargaDatos.setText("CargarDatos");
        cargaDatos.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cargaDatosActionPerformed(evt);
            }
        });
        cargarDatos.add(cargaDatos);
        cargarDatos.add(jSeparator1);

        logout.setText("Cerrar Sesion");
        logout.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                logoutActionPerformed(evt);
            }
        });
        cargarDatos.add(logout);

        jMenuBar1.add(cargarDatos);

        jMenu1.setText("Usuarios");

        addUser.setText("Crear");
        addUser.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                addUserActionPerformed(evt);
            }
        });
        jMenu1.add(addUser);

        modUser.setText("Modificar");
        modUser.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                modUserActionPerformed(evt);
            }
        });
        jMenu1.add(modUser);

        deleteUser.setText("Eliminar");
        deleteUser.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                deleteUserActionPerformed(evt);
            }
        });
        jMenu1.add(deleteUser);

        jMenuBar1.add(jMenu1);

        jMenu5.setText("Edificios");

        addEdificio.setText("Crear");
        addEdificio.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                addEdificioActionPerformed(evt);
            }
        });
        jMenu5.add(addEdificio);

        deleteEdificio.setText("Eliminar");
        deleteEdificio.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                deleteEdificioActionPerformed(evt);
            }
        });
        jMenu5.add(deleteEdificio);

        jMenuBar1.add(jMenu5);

        jMenu6.setText("Salones");

        addSalon.setText("Crear");
        addSalon.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                addSalonActionPerformed(evt);
            }
        });
        jMenu6.add(addSalon);

        modSalon.setText("Modificar");
        modSalon.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                modSalonActionPerformed(evt);
            }
        });
        jMenu6.add(modSalon);

        deleteSalon.setText("Eliminar");
        deleteSalon.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                deleteSalonActionPerformed(evt);
            }
        });
        jMenu6.add(deleteSalon);

        jMenuBar1.add(jMenu6);

        jMenu7.setText("Cursos");

        addCurso.setText("Crear");
        addCurso.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                addCursoActionPerformed(evt);
            }
        });
        jMenu7.add(addCurso);

        modCurso.setText("Modificar");
        modCurso.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                modCursoActionPerformed(evt);
            }
        });
        jMenu7.add(modCurso);

        deleteCurso.setText("Eliminar");
        deleteCurso.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                deleteCursoActionPerformed(evt);
            }
        });
        jMenu7.add(deleteCurso);

        jMenuBar1.add(jMenu7);

        jMenu8.setText("Estudiantes");

        addEstudiante.setText("Crear");
        addEstudiante.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                addEstudianteActionPerformed(evt);
            }
        });
        jMenu8.add(addEstudiante);

        modEstudiante.setText("Modificar");
        modEstudiante.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                modEstudianteActionPerformed(evt);
            }
        });
        jMenu8.add(modEstudiante);

        deleteEstudiante.setText("Eliminar");
        deleteEstudiante.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                deleteEstudianteActionPerformed(evt);
            }
        });
        jMenu8.add(deleteEstudiante);

        jMenuBar1.add(jMenu8);

        jMenu9.setText("Catedraticos");

        addCatedratico.setText("Crear");
        addCatedratico.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                addCatedraticoActionPerformed(evt);
            }
        });
        jMenu9.add(addCatedratico);

        modCatedratico.setText("Modificar");
        modCatedratico.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                modCatedraticoActionPerformed(evt);
            }
        });
        jMenu9.add(modCatedratico);

        jMenuBar1.add(jMenu9);

        jMenu10.setText("Asignacion");

        addAsign.setText("Crear");
        addAsign.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                addAsignActionPerformed(evt);
            }
        });
        jMenu10.add(addAsign);

        modAsig.setText("Modificar");
        modAsig.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                modAsigActionPerformed(evt);
            }
        });
        jMenu10.add(modAsig);

        deleteAsig.setText("Eliminar");
        deleteAsig.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                deleteAsigActionPerformed(evt);
            }
        });
        jMenu10.add(deleteAsig);

        jMenuBar1.add(jMenu10);

        jMenu11.setText("Horario");

        modHorario.setText("Modificar");
        modHorario.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                modHorarioActionPerformed(evt);
            }
        });
        jMenu11.add(modHorario);

        jMenuBar1.add(jMenu11);

        jMenu2.setText("Graficar");

        treeCatedraticos.setText("Ver arbol de catedraticos");
        treeCatedraticos.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                treeCatedraticosActionPerformed(evt);
            }
        });
        jMenu2.add(treeCatedraticos);

        GraficarEdificiosSalones.setText("ver lista de Edificios y salones");
        GraficarEdificiosSalones.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                GraficarEdificiosSalonesActionPerformed(evt);
            }
        });
        jMenu2.add(GraficarEdificiosSalones);

        verCursos.setText("Ver Lista de cursos");
        verCursos.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                verCursosActionPerformed(evt);
            }
        });
        jMenu2.add(verCursos);

        verUsuarios.setText("Ver la lista de usuarios");
        verUsuarios.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                verUsuariosActionPerformed(evt);
            }
        });
        jMenu2.add(verUsuarios);

        verAsginaciones.setText("Ver las asignaciones");
        verAsginaciones.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                verAsginacionesActionPerformed(evt);
            }
        });
        jMenu2.add(verAsginaciones);

        verHorario.setText("Ver arbol de horario");
        verHorario.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                verHorarioActionPerformed(evt);
            }
        });
        jMenu2.add(verHorario);

        verEstudiantes.setText("Ver los Estudiantes");
        verEstudiantes.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                verEstudiantesActionPerformed(evt);
            }
        });
        jMenu2.add(verEstudiantes);

        verTodo.setText("Ver Todo");
        verTodo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                verTodoActionPerformed(evt);
            }
        });
        jMenu2.add(verTodo);

        jMenuBar1.add(jMenu2);

        jMenu3.setText("Reportes");

        cursoEstudiante.setText("Cursos por estudiante");
        cursoEstudiante.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cursoEstudianteActionPerformed(evt);
            }
        });
        jMenu3.add(cursoEstudiante);

        EstudianteCurso.setText("Estudiantes por curso");
        EstudianteCurso.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                EstudianteCursoActionPerformed(evt);
            }
        });
        jMenu3.add(EstudianteCurso);

        CursoSalon.setText("Cursos por Salon");
        CursoSalon.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                CursoSalonActionPerformed(evt);
            }
        });
        jMenu3.add(CursoSalon);

        NotasSemestre.setText("Notas de Estudiantes por semestre");
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
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void addUserActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_addUserActionPerformed
        // TODO add your handling code here:
        funUser.add();        
    }//GEN-LAST:event_addUserActionPerformed

    private void addEdificioActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_addEdificioActionPerformed
        // TODO add your handling code here:
        funEdificio.Add(this);
    }//GEN-LAST:event_addEdificioActionPerformed

    private void addSalonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_addSalonActionPerformed
        // TODO add your handling code here:
        funSalon.add();
    }//GEN-LAST:event_addSalonActionPerformed

    private void addCursoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_addCursoActionPerformed
        // TODO add your handling code here:
        funCursos.add();
    }//GEN-LAST:event_addCursoActionPerformed

    private void addEstudianteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_addEstudianteActionPerformed
        // TODO add your handling code here:
        funEst.add();
    }//GEN-LAST:event_addEstudianteActionPerformed

    private void addCatedraticoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_addCatedraticoActionPerformed
        // TODO add your handling code here:
        funCat.add();
    }//GEN-LAST:event_addCatedraticoActionPerformed

    private void addAsignActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_addAsignActionPerformed
        // TODO add your handling code here:
        funAsig.add();
    }//GEN-LAST:event_addAsignActionPerformed

    private void verAsginacionesActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_verAsginacionesActionPerformed
        // TODO add your handling code here:
        dibujar.estrucGeneric(almacenamiento.getEstadoAsignaciones(),"Asginaciones");
    }//GEN-LAST:event_verAsginacionesActionPerformed

    private void verTodoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_verTodoActionPerformed
        // Ver todo
        dibujar.estrucGeneric(almacenamiento.getEstadoTodo(), "TODO");
    }//GEN-LAST:event_verTodoActionPerformed

    private void cargaDatosActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cargaDatosActionPerformed
        // TODO add your handling code here:
        CargaDatos cargar =  new CargaDatos();
        File file = cargar.getFile();
        if (file != null) {
            almacenamiento.cargarDatos(converterBuffer(file));
        }        
    }//GEN-LAST:event_cargaDatosActionPerformed

    private void verEstudiantesActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_verEstudiantesActionPerformed
        // TODO add your handling code here:
        dibujar.hash(almacenamiento.getEstadoEstudiantes(), "Hash");
    }//GEN-LAST:event_verEstudiantesActionPerformed

    private void verHorarioActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_verHorarioActionPerformed
        // TODO add your handling code here:
        dibujar.estrucGeneric(almacenamiento.getEstadoHorario(), "TreeHorario");
    }//GEN-LAST:event_verHorarioActionPerformed

    private void verUsuariosActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_verUsuariosActionPerformed
        // TODO add your handling code here:
        dibujar.estrucGeneric(almacenamiento.getEstadoUsuarios(),"ListUsuarios");
    }//GEN-LAST:event_verUsuariosActionPerformed

    private void verCursosActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_verCursosActionPerformed
        // TODO add your handling code here:
        dibujar.estrucGeneric(almacenamiento.getEstadoCursos(),"ListCursos");
    }//GEN-LAST:event_verCursosActionPerformed

    private void GraficarEdificiosSalonesActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_GraficarEdificiosSalonesActionPerformed
        // TODO add your handling code here:
        dibujar.estrucGeneric(almacenamiento.getEstadoEdificios(),"ListEdificos");
    }//GEN-LAST:event_GraficarEdificiosSalonesActionPerformed

    private void treeCatedraticosActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_treeCatedraticosActionPerformed
        // TODO add your handling code here:        
        dibujar.avlCatedraticos(almacenamiento.getEstadoCatedraticos());
    }//GEN-LAST:event_treeCatedraticosActionPerformed

    private void logoutActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_logoutActionPerformed
        // TODO add your handling code here:
        Login login = new Login(almacenamiento);
        login.setLocationRelativeTo(null);
        login.setVisible(true);
        this.dispose();        
    }//GEN-LAST:event_logoutActionPerformed

    private void deleteUserActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_deleteUserActionPerformed
        // TODO add your handling code here:
        funUser.delete();
    }//GEN-LAST:event_deleteUserActionPerformed

    private void modUserActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_modUserActionPerformed
        // TODO add your handling code here:
        funUser.mod();
    }//GEN-LAST:event_modUserActionPerformed

    private void deleteEdificioActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_deleteEdificioActionPerformed
        // TODO add your handling code here:
        funEdificio.eliminar(this);
    }//GEN-LAST:event_deleteEdificioActionPerformed

    private void modSalonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_modSalonActionPerformed
        // TODO add your handling code here:
        funSalon.mod();
    }//GEN-LAST:event_modSalonActionPerformed

    private void deleteSalonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_deleteSalonActionPerformed
        // TODO add your handling code here:
        funSalon.delete();
    }//GEN-LAST:event_deleteSalonActionPerformed

    private void modCursoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_modCursoActionPerformed
        // TODO add your handling code here:
        funCursos.mod();
    }//GEN-LAST:event_modCursoActionPerformed

    private void deleteCursoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_deleteCursoActionPerformed
        // TODO add your handling code here:
        funCursos.delete();
    }//GEN-LAST:event_deleteCursoActionPerformed

    private void modEstudianteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_modEstudianteActionPerformed
        // TODO add your handling code here:
        funEst.mod();
    }//GEN-LAST:event_modEstudianteActionPerformed

    private void deleteEstudianteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_deleteEstudianteActionPerformed
        // TODO add your handling code here:
        funEst.delete();
    }//GEN-LAST:event_deleteEstudianteActionPerformed

    private void modCatedraticoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_modCatedraticoActionPerformed
        // TODO add your handling code here:
        funCat.mod();
    }//GEN-LAST:event_modCatedraticoActionPerformed

    private void modAsigActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_modAsigActionPerformed
        // TODO add your handling code here:
        funAsig.mod();
    }//GEN-LAST:event_modAsigActionPerformed

    private void deleteAsigActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_deleteAsigActionPerformed
        // TODO add your handling code here:
        funAsig.delete();
    }//GEN-LAST:event_deleteAsigActionPerformed

    private void modHorarioActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_modHorarioActionPerformed
        // TODO add your handling code here:
        funHor.mod();
    }//GEN-LAST:event_modHorarioActionPerformed

    private void cursoEstudianteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cursoEstudianteActionPerformed
        // TODO add your handling code here:
        funReport.CursoEstudiante();
    }//GEN-LAST:event_cursoEstudianteActionPerformed

    private void EstudianteCursoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_EstudianteCursoActionPerformed
        // TODO add your handling code here:
        funReport.EstudianteCurso();
    }//GEN-LAST:event_EstudianteCursoActionPerformed

    private void CursoSalonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_CursoSalonActionPerformed
        // TODO add your handling code here:
        funReport.CursoSalon();
    }//GEN-LAST:event_CursoSalonActionPerformed

    private void NotasSemestreActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_NotasSemestreActionPerformed
        // TODO add your handling code here:
        funReport.NotaSemestre();
    }//GEN-LAST:event_NotasSemestreActionPerformed

    private static BufferedReader converterBuffer(File file){
        try{
            BufferedReader br = new BufferedReader(new FileReader(file,StandardCharsets.UTF_8));
            return br;
        }catch(Exception e){            
        }
        return null;
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JMenuItem CursoSalon;
    private javax.swing.JMenuItem EstudianteCurso;
    private javax.swing.JMenuItem GraficarEdificiosSalones;
    private javax.swing.JMenuItem NotasSemestre;
    private javax.swing.JMenuItem addAsign;
    private javax.swing.JMenuItem addCatedratico;
    private javax.swing.JMenuItem addCurso;
    private javax.swing.JMenuItem addEdificio;
    private javax.swing.JMenuItem addEstudiante;
    private javax.swing.JMenuItem addSalon;
    private javax.swing.JMenuItem addUser;
    private javax.swing.JMenuItem cargaDatos;
    private javax.swing.JMenu cargarDatos;
    private javax.swing.JMenuItem cursoEstudiante;
    private javax.swing.JMenuItem deleteAsig;
    private javax.swing.JMenuItem deleteCurso;
    private javax.swing.JMenuItem deleteEdificio;
    private javax.swing.JMenuItem deleteEstudiante;
    private javax.swing.JMenuItem deleteSalon;
    private javax.swing.JMenuItem deleteUser;
    private javax.swing.JMenu jMenu1;
    private javax.swing.JMenu jMenu10;
    private javax.swing.JMenu jMenu11;
    private javax.swing.JMenu jMenu2;
    private javax.swing.JMenu jMenu3;
    private javax.swing.JMenu jMenu5;
    private javax.swing.JMenu jMenu6;
    private javax.swing.JMenu jMenu7;
    private javax.swing.JMenu jMenu8;
    private javax.swing.JMenu jMenu9;
    private javax.swing.JMenuBar jMenuBar1;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPopupMenu.Separator jSeparator1;
    private javax.swing.JMenuItem logout;
    private javax.swing.JMenuItem modAsig;
    private javax.swing.JMenuItem modCatedratico;
    private javax.swing.JMenuItem modCurso;
    private javax.swing.JMenuItem modEstudiante;
    private javax.swing.JMenuItem modHorario;
    private javax.swing.JMenuItem modSalon;
    private javax.swing.JMenuItem modUser;
    private javax.swing.JMenuItem treeCatedraticos;
    private javax.swing.JMenuItem verAsginaciones;
    private javax.swing.JMenuItem verCursos;
    private javax.swing.JMenuItem verEstudiantes;
    private javax.swing.JMenuItem verHorario;
    private javax.swing.JMenuItem verTodo;
    private javax.swing.JMenuItem verUsuarios;
    // End of variables declaration//GEN-END:variables
}
