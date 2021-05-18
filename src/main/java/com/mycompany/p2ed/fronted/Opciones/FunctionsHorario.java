/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.p2ed.fronted.Opciones;

import com.mycompany.p2ed.Informacion.Almacenamiento;
import com.mycompany.p2ed.fronted.FormHorario;
import com.mycompany.p2ed.objetos.Horario;
import javax.swing.JFrame;
import javax.swing.JOptionPane;

/**
 *
 * @author sergi
 */
public class FunctionsHorario {
    private Almacenamiento almacenamiento;
    private JFrame jframe;

    public FunctionsHorario(Almacenamiento almacenamiento, JFrame jframe) {
        this.almacenamiento = almacenamiento;
        this.jframe = jframe;
    }
    
    public void mod(){
        try{
            String codigo= JOptionPane.showInputDialog("Ingrese el codigo del horario a modificar");
            Horario hor = almacenamiento.getHorario().get(Integer.parseInt(codigo));
            if (hor != null) {
                FormHorario form = new FormHorario(almacenamiento,hor);
                form.setLocationRelativeTo(null);
                form.setVisible(true);
            }else{
                 JOptionPane.showMessageDialog(jframe,"No se encontro el Horario: " + codigo,"error",JOptionPane.ERROR_MESSAGE);
            }            
        }catch(Exception e){
            JOptionPane.showMessageDialog(jframe,"Ocurrio un error " + e.getMessage(),"error",JOptionPane.ERROR_MESSAGE);
        }
    }
}
