/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.p2ed.fronted.Opciones;

import com.mycompany.p2ed.Informacion.Almacenamiento;
import com.mycompany.p2ed.fronted.FormEstudiante;
import com.mycompany.p2ed.objetos.Estudiante;
import javax.swing.JFrame;
import javax.swing.JOptionPane;

/**
 *
 * @author sergi
 */
public class FunctionsEstudiante {
    
    private Almacenamiento almacenamiento;
    private JFrame jframe;

    public FunctionsEstudiante(Almacenamiento almacenamiento, JFrame jframe) {
        this.almacenamiento = almacenamiento;
        this.jframe = jframe;
    }
    
    public void add(){
        FormEstudiante form = new FormEstudiante(almacenamiento);
        form.setLocationRelativeTo(null);
        form.setVisible(true);
    }
    
    public void mod(){
        try{
             String id= JOptionPane.showInputDialog("Ingrese el carnet del estudiante a modificar");
             Estudiante bol = almacenamiento.getHash().get(Integer.parseInt(id));
             if (bol != null) {
                FormEstudiante formEstudiante = new FormEstudiante(almacenamiento,bol);
                formEstudiante.setLocationRelativeTo(null);
                formEstudiante.setVisible(true);
            }else{
                 JOptionPane.showMessageDialog(jframe,"No se encontro el Estudiante: " + id,"error",JOptionPane.ERROR_MESSAGE); 
             }
        }catch(Exception e){
            JOptionPane.showMessageDialog(jframe,"Ocurrio un error " + e.getMessage(),"error",JOptionPane.ERROR_MESSAGE);          
        }
    }
    
    public void delete(){
        try{
             String id= JOptionPane.showInputDialog("Ingrese el carnet del estudiante a modificar");
             boolean bol = almacenamiento.getHash().pop(Integer.parseInt(id));
             if (bol) {
                JOptionPane.showMessageDialog(jframe,"Eliminacion exitosa");
            }else{
                 JOptionPane.showMessageDialog(jframe,"No se encontro el Estudiante: " + id,"error",JOptionPane.ERROR_MESSAGE); 
             }
        }catch(Exception e){
            JOptionPane.showMessageDialog(jframe,"Ocurrio un error " + e.getMessage(),"error",JOptionPane.ERROR_MESSAGE);          
        }
    }
    
}
