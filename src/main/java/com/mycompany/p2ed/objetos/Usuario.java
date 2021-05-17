/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.p2ed.objetos;

import com.mycompany.p2ed.Nodos.NodeHash;

/**
 *
 * @author sergi
 */
public class Usuario {
    
    private int id;
    private String nombre;
    private String password;
    private String tipo;
    private NodeHash<Estudiante> estudiante;

    public Usuario(int id, String nombre, String password, String tipo, NodeHash estudiante) {
        this.id = id;
        this.nombre = nombre;
        this.password = password;
        this.tipo = tipo;
        this.estudiante = estudiante;
    }

    public Usuario(int id, String nombre, String password, String tipo) {
        this.id = id;
        this.nombre = nombre;
        this.password = password;
        this.tipo = tipo;
        this.estudiante = null;
    }
    
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    public NodeHash<Estudiante> getEstudiante() {
        return estudiante;
    }

    public void setEstudiante(NodeHash<Estudiante> estudiante) {
        this.estudiante = estudiante;
    }    

    @Override
    public String toString() {
        if (estudiante != null) {
            if (estudiante.getData() != null) {
                 return estudiante.getData().getCarnet() + "\\n" + nombre + "\\n" + password + "\\n" + tipo;
            }else{
                 return "null" + "\\n" + nombre + "\\n" + password + "\\n" + tipo;
            }
        }
        return id + "\\n" + nombre + "\\n" + password + "\\n" + tipo;
    }
    
    
}
