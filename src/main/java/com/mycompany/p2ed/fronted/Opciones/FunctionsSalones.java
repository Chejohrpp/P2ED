/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.p2ed.fronted.Opciones;

import com.mycompany.p2ed.Informacion.Almacenamiento;
import com.mycompany.p2ed.fronted.CrearUser;
import com.mycompany.p2ed.fronted.FormSalones;
import com.mycompany.p2ed.objetos.Edificio;
import com.mycompany.p2ed.objetos.Salon;
import com.mycompany.p2ed.objetos.Usuario;
import javax.swing.JFrame;
import javax.swing.JOptionPane;

/**
 *
 * @author sergi
 */
public class FunctionsSalones {
    private Almacenamiento almacenamiento;
    private JFrame jframe;

    public FunctionsSalones(Almacenamiento almacenamiento, JFrame jframe) {
        this.almacenamiento = almacenamiento;
        this.jframe = jframe;
    }
    
    public void add(){
        FormSalones formSalon = new FormSalones(almacenamiento);
        formSalon.setLocationRelativeTo(null);
        formSalon.setVisible(true);
    }
    public void mod(){        
        try{
             String edificio= JOptionPane.showInputDialog("Ingrese el nombre del edificio donde esta el salon");
              Edificio edi = almacenamiento.getListEdificio().get(edificio);
             if (edi != null) {
                String numeroSalon = JOptionPane.showInputDialog("Ingrese el numero de salon");             
                Salon salon = (Salon) edi.getSalones().get(Integer.parseInt(numeroSalon));             
                if (salon != null) {
                   FormSalones formSalon = new FormSalones(almacenamiento,numeroSalon,salon);
                   formSalon.setLocationRelativeTo(null);
                   formSalon.setVisible(true);
               }else{
                    JOptionPane.showMessageDialog(jframe,"No se encontro el Salon: " + numeroSalon,"error",JOptionPane.ERROR_MESSAGE); 
                }
            }else{
                 JOptionPane.showMessageDialog(jframe,"No se encontro el edificio: " + edificio,"error",JOptionPane.ERROR_MESSAGE); 
             }             
        }catch(Exception e){
            JOptionPane.showMessageDialog(jframe,"Ocurrio un error " + e.getMessage(),"error",JOptionPane.ERROR_MESSAGE);
        }
    }
    public void delete(){
        try{
             String edificio= JOptionPane.showInputDialog("Ingrese el nombre del edificio donde esta el salon");
              Edificio edi = almacenamiento.getListEdificio().get(edificio);
             if (edi != null) {
                String numeroSalon = JOptionPane.showInputDialog("Ingrese el numero de salon a eliminar");             
                boolean bol = edi.getSalones().eliminar(Integer.parseInt(numeroSalon));
                if (bol) {
                   JOptionPane.showMessageDialog(jframe,"Eliminacion exitosa: " + numeroSalon,"Hecho",JOptionPane.INFORMATION_MESSAGE); 
               }else{
                    JOptionPane.showMessageDialog(jframe,"No se encontro el Salon: " + numeroSalon,"error",JOptionPane.ERROR_MESSAGE); 
                }
            }else{
                 JOptionPane.showMessageDialog(jframe,"No se encontro el edificio: " + edificio,"error",JOptionPane.ERROR_MESSAGE); 
             }             
        }catch(Exception e){
            JOptionPane.showMessageDialog(jframe,"Ocurrio un error " + e.getMessage(),"error",JOptionPane.ERROR_MESSAGE);
        }
    }
}
