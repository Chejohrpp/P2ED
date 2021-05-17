/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.p2ed.fronted.Opciones;

import com.mycompany.p2ed.Informacion.Almacenamiento;
import com.mycompany.p2ed.fronted.CrearUser;
import com.mycompany.p2ed.objetos.Usuario;
import javax.swing.JFrame;
import javax.swing.JOptionPane;

/**
 *
 * @author sergi
 */
public class FunctionsUsers {
 
    private Almacenamiento almacenamiento;
    private JFrame jframe;

    public FunctionsUsers(Almacenamiento almacenamiento,JFrame jframe) {
        this.almacenamiento = almacenamiento;
        this.jframe = jframe;
    }
    
    public void add(){
        CrearUser crearUser = new CrearUser(almacenamiento);
        crearUser.setLocationRelativeTo(null);
        crearUser.setVisible(true);
    }
    
    public void mod(){
        try{
             String id= JOptionPane.showInputDialog("Ingrese el id para modificar");
             Usuario bol = almacenamiento.getListUsers().get(id);
             if (bol != null) {
                CrearUser crearUser = new CrearUser(almacenamiento,id,bol);
                crearUser.setLocationRelativeTo(null);
                crearUser.setVisible(true);
            }else{
                 JOptionPane.showMessageDialog(jframe,"No se encontro el usuario: " + id,"error",JOptionPane.ERROR_MESSAGE); 
             }
        }catch(Exception e){
            JOptionPane.showMessageDialog(jframe,"Ocurrio un error " + e.getMessage(),"error",JOptionPane.ERROR_MESSAGE);          
        }
    }
    
    public void delete(){
        try{
             String id= JOptionPane.showInputDialog("Ingrese el id para eliminar");
             boolean bol = almacenamiento.getListUsers().eliminar(id);
             if (bol) {
                JOptionPane.showMessageDialog(jframe,"Eliminacion exitosa");
            }else{
                 JOptionPane.showMessageDialog(jframe,"No se encontro el usuario: " + id,"error",JOptionPane.ERROR_MESSAGE); 
             }
        }catch(Exception e){
            JOptionPane.showMessageDialog(jframe,"Ocurrio un error " + e.getMessage(),"error",JOptionPane.ERROR_MESSAGE);            
        }
    }
    
    
    
}
