/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.p2ed;

import com.mycompany.p2ed.Informacion.Almacenamiento;
import com.mycompany.p2ed.fronted.Login;

/**
 *
 * @author sergi
 */
public class Main {
    
    private static Almacenamiento almacenamiento =  new Almacenamiento();
    //private static Dibujar dibujar = new Dibujar();
    
    public static void main(String[] args) {        
        Login login = new Login(almacenamiento);
        login.setLocationRelativeTo(null);
        login.setVisible(true);

    }    
    public static void dibujar(){
        //dibujar.avlCatedraticos(almacenamiento.getEstadoCatedraticos());              1
        //dibujar.estrucGeneric(almacenamiento.getEstadoEdificios(),"ListEdificos");    2  
        //dibujar.estrucGeneric(almacenamiento.getEstadoCursos(),"ListCursos");         3
        //dibujar.estrucGeneric(almacenamiento.getEstadoUsuarios(),"ListUsuarios");     4
        //dibujar.estrucGeneric(almacenamiento.getEstadoAsignaciones(),"Asginaciones"); 5
        //dibujar.estrucGeneric(almacenamiento.getEstadoHorario(), "TreeHorario");      6
        //dibujar.hash(almacenamiento.getEstadoEstudiantes(), "Hash");                  7
        //dibujar.estrucGeneric(almacenamiento.getEstadoTodo(), "TODO");                8        
    }      
}
