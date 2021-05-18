/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.p2ed.fronted.Opciones;

import com.mycompany.p2ed.Informacion.Almacenamiento;
import com.mycompany.p2ed.objetos.Edificio;
import javax.swing.JFrame;
import javax.swing.JOptionPane;

/**
 *
 * @author sergi
 */
public class FunctionsEdificio {
    private Almacenamiento almacenamiento;

    public FunctionsEdificio(Almacenamiento almacenamiento) {
        this.almacenamiento = almacenamiento;
    } 
    
    public void eliminar(JFrame jframe){
        try{
             String id= JOptionPane.showInputDialog("Ingrese el nombre de un edificio a eliminar");
             boolean bol = almacenamiento.getListEdificio().eliminar(id);
             if (bol) {
                JOptionPane.showMessageDialog(jframe,"Eliminacion exitosa");
            }else{
                 JOptionPane.showMessageDialog(jframe,"No se encontro el Edificio: " + id);
             }
        }catch(Exception e){
            JOptionPane.showMessageDialog(jframe,"Ocurrio un error " + e.getMessage());            
        }
    }
    
    public void Add(JFrame jframe){
        try{
             String id= JOptionPane.showInputDialog("Ingrese el nombre de un edificio a agregar");
             if (id != null) {
                Edificio edificio =  almacenamiento.getListEdificio().get(id);
                if (edificio == null){
                        edificio = new Edificio(id);
                        almacenamiento.getListEdificio().push(id,edificio);
                        JOptionPane.showMessageDialog(jframe,"Se agrego el edificio");
                }else{
                        JOptionPane.showMessageDialog(jframe,"Ya existe el edificio: " + id,"eror",JOptionPane.ERROR_MESSAGE); 
                }
            }            
        }catch(Exception e){
            JOptionPane.showMessageDialog(jframe,"Ocurrio un error " + e.getMessage(),"eror",JOptionPane.ERROR_MESSAGE);            
        }
    }
    
}
