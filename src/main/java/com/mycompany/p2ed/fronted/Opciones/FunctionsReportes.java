/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.p2ed.fronted.Opciones;

import com.mycompany.p2ed.Informacion.Almacenamiento;
import com.mycompany.p2ed.fronted.FormEstudiante;
import com.mycompany.p2ed.fronted.Reportes.CursoEstudiante;
import com.mycompany.p2ed.objetos.Estudiante;
import javax.swing.JFrame;
import javax.swing.JOptionPane;

/**
 *
 * @author sergi
 */
public class FunctionsReportes {
    private Almacenamiento almacenamiento;
    private JFrame jframe;

    public FunctionsReportes(Almacenamiento almacenamineto,JFrame jframe) {
        this.almacenamiento = almacenamineto;
        this.jframe = jframe;
    }
    
    public void CursoEstudiante(){
        try{
             String id= JOptionPane.showInputDialog("Ingrese el carnet del estudiante");
             Estudiante bol = almacenamiento.getHash().get(Integer.parseInt(id));
             if (bol != null) {
                CursoEstudiante curso = new CursoEstudiante(almacenamiento,Integer.parseInt(id));
                curso.setLocationRelativeTo(null);
                curso.setVisible(true);
            }else{
                 JOptionPane.showMessageDialog(jframe,"No se encontro el Estudiante: " + id,"error",JOptionPane.ERROR_MESSAGE); 
             }
        }catch(Exception e){
            JOptionPane.showMessageDialog(jframe,"Ocurrio un error " + e.getMessage(),"error",JOptionPane.ERROR_MESSAGE);          
        
        }
    }
    
}
