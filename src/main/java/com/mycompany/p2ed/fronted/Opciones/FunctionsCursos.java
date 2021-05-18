/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.p2ed.fronted.Opciones;

import com.mycompany.p2ed.Informacion.Almacenamiento;
import com.mycompany.p2ed.fronted.CrearUser;
import com.mycompany.p2ed.fronted.FormCurso;
import com.mycompany.p2ed.objetos.Curso;
import com.mycompany.p2ed.objetos.Usuario;
import javax.swing.JFrame;
import javax.swing.JOptionPane;

/**
 *
 * @author sergi
 */
public class FunctionsCursos {
    
    private Almacenamiento almacenamiento;
    private JFrame jframe;

    public FunctionsCursos(Almacenamiento almacenamiento, JFrame jframe) {
        this.almacenamiento = almacenamiento;
        this.jframe = jframe;
    }
    
    public void add(){
        FormCurso formCurso = new FormCurso(almacenamiento);
        formCurso.setLocationRelativeTo(null);
        formCurso.setVisible(true);
    }
    
    public void mod(){
        try{
             String id= JOptionPane.showInputDialog("Ingrese el codigo del Curso a modificar");
             Curso bol = almacenamiento.getListCurso().get(id);
             if (bol != null) {
                FormCurso formCurso = new FormCurso(almacenamiento,bol);
                formCurso.setLocationRelativeTo(null);
                formCurso.setVisible(true);
            }else{
                 JOptionPane.showMessageDialog(jframe,"No se encontro el Curso: " + id,"error",JOptionPane.ERROR_MESSAGE); 
             }
        }catch(Exception e){
            JOptionPane.showMessageDialog(jframe,"Ocurrio un error " + e.getMessage(),"error",JOptionPane.ERROR_MESSAGE);          
        }
    }
    
    public void delete(){
        try{
             String id= JOptionPane.showInputDialog("Ingrese el codigo del curso a eliminar");
             boolean bol = almacenamiento.getListCurso().eliminar(id);
             if (bol) {
                JOptionPane.showMessageDialog(jframe,"Eliminacion exitosa");
            }else{
                 JOptionPane.showMessageDialog(jframe,"No se encontro el curso: " + id,"error",JOptionPane.ERROR_MESSAGE); 
             }
        }catch(Exception e){
            JOptionPane.showMessageDialog(jframe,"Ocurrio un error " + e.getMessage(),"error",JOptionPane.ERROR_MESSAGE);            
        }
    }
    
}
