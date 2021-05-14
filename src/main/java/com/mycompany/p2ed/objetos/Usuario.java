/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.p2ed.objetos;

/**
 *
 * @author sergi
 */
public class Usuario {
    
    private int id;
    private String nombre;
    private String password;
    private String tipo;
    private Estudiante estudiante;

    public Usuario(int id, String nombre, String password, String tipo, Estudiante estudiante) {
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

    public Estudiante getEstudiante() {
        return estudiante;
    }

    public void setEstudiante(Estudiante estudiante) {
        this.estudiante = estudiante;
    }

    @Override
    public String toString() {
        return id + "\\n" + nombre + "\\n" + password + "\\n" + tipo;
    }
    
    
}
