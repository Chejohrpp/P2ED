/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.p2ed.fronted.Opciones;

import com.mycompany.p2ed.Informacion.Almacenamiento;
import com.mycompany.p2ed.fronted.FormCatedratico;
import com.mycompany.p2ed.objetos.Catedratico;
import javax.swing.JFrame;
import javax.swing.JOptionPane;

/**
 *
 * @author sergi
 */
public class FunctionsCatedratico {
    private Almacenamiento almacenamiento;
    private JFrame jframe;

    public FunctionsCatedratico(Almacenamiento almacenamiento, JFrame jframe) {
        this.almacenamiento = almacenamiento;
        this.jframe = jframe;
    }
    
    public void add(){
        FormCatedratico form = new FormCatedratico(almacenamiento);
        form.setLocationRelativeTo(null);
        form.setVisible(true);
    }
    
    public void mod(){
        try{
             String id= JOptionPane.showInputDialog("Ingrese el id del Catedratico a modificar");
             Catedratico bol = almacenamiento.getListCatedratico().get(id);
             if (bol != null) {
                FormCatedratico form = new FormCatedratico(almacenamiento,bol);
                form.setLocationRelativeTo(null);
                form.setVisible(true);
            }else{
                 JOptionPane.showMessageDialog(jframe,"No se encontro el Catedratico: " + id,"error",JOptionPane.ERROR_MESSAGE); 
             }
        }catch(Exception e){
            JOptionPane.showMessageDialog(jframe,"Ocurrio un error " + e.getMessage(),"error",JOptionPane.ERROR_MESSAGE);          
        }
    }
}
