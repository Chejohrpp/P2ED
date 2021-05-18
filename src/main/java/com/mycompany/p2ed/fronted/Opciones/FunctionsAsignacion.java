/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.p2ed.fronted.Opciones;

import com.mycompany.p2ed.Informacion.Almacenamiento;
import com.mycompany.p2ed.fronted.FormAsingnar;
import com.mycompany.p2ed.objetos.Asignar;
import com.mycompany.p2ed.objetos.Estudiante;
import com.mycompany.p2ed.objetos.Horario;
import javax.swing.JFrame;
import javax.swing.JOptionPane;

/**
 *
 * @author sergi
 */
public class FunctionsAsignacion {
    private Almacenamiento almacenamiento;
    private JFrame jframe;

    public FunctionsAsignacion(Almacenamiento almacenamiento, JFrame jframe) {
        this.almacenamiento = almacenamiento;
        this.jframe = jframe;
    }
    
    public void add(){
        FormAsingnar form = new FormAsingnar(almacenamiento);
        form.setLocationRelativeTo(null);
        form.setVisible(true);
    }
    public void mod(){
        try{
             String id= JOptionPane.showInputDialog("Ingrese el carnet del estudiante a modificar");
             Estudiante bol = almacenamiento.getHash().get(Integer.parseInt(id));
             if (bol != null) {
                String codHorario= JOptionPane.showInputDialog("Ingrese el codigo del horario");
                 Horario horario = almacenamiento.getHorario().get(Integer.parseInt(codHorario));
                 if (horario != null) {
                      Asignar asignar =  almacenamiento.getAsignacion().get(Integer.parseInt(id),Integer.parseInt(codHorario));
                      if (asignar != null) {
                        FormAsingnar form = new FormAsingnar(almacenamiento,asignar);
                        form.setLocationRelativeTo(null);
                        form.setVisible(true);
                     }else{
                          JOptionPane.showMessageDialog(jframe,"No se encontro La asginacion entre : " + id + " y el horario: " + codHorario,"error",JOptionPane.ERROR_MESSAGE);
                      }
                 }else{
                     JOptionPane.showMessageDialog(jframe,"No se encontro el Horario: " + codHorario,"error",JOptionPane.ERROR_MESSAGE);
                 }                
            }else{
                 JOptionPane.showMessageDialog(jframe,"No se encontro el Estudiante: " + id,"error",JOptionPane.ERROR_MESSAGE); 
             }
        }catch(Exception e){
            JOptionPane.showMessageDialog(jframe,"Ocurrio un error " + e.getMessage(),"error",JOptionPane.ERROR_MESSAGE);          
        }
    }
    
    public void delete(){
        try{
             String id= JOptionPane.showInputDialog("Ingrese el carnet del estudiante a eliminar");
             Estudiante bol = almacenamiento.getHash().get(Integer.parseInt(id));
             if (bol != null) {
                String codHorario= JOptionPane.showInputDialog("Ingrese el codigo de horario");
                 Horario horario = almacenamiento.getHorario().get(Integer.parseInt(codHorario));
                 if (horario != null) {
                      boolean isDelete =  almacenamiento.getAsignacion().eliminar(Integer.parseInt(id),Integer.parseInt(codHorario));
                      horario.getAsignaciones().eliminar(Integer.parseInt(id),Integer.parseInt(codHorario));
                      if (isDelete) {
                        JOptionPane.showMessageDialog(jframe,"Eliminacion exitosa");
                     }else{
                          JOptionPane.showMessageDialog(jframe,"No se encontro La asginacion entre : " + id + " y el horario: " + codHorario,"error",JOptionPane.ERROR_MESSAGE);
                      }
                 }else{
                     JOptionPane.showMessageDialog(jframe,"No se encontro el Horario: " + codHorario,"error",JOptionPane.ERROR_MESSAGE);
                 }                
            }else{
                 JOptionPane.showMessageDialog(jframe,"No se encontro el Estudiante: " + id,"error",JOptionPane.ERROR_MESSAGE); 
             }
        }catch(Exception e){
            JOptionPane.showMessageDialog(jframe,"Ocurrio un error " + e.getMessage(),"error",JOptionPane.ERROR_MESSAGE);          
        }
    }
}
