/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.p2ed.objetos;

import com.mycompany.p2ed.listas.ListSimple;

/**
 *
 * @author sergi
 */
public class Edificio {
    
    private String nombre;
    private ListSimple<Salon> salones;

    public Edificio(String nombre) {
        this.nombre = nombre;
        this.salones = new ListSimple<Salon>();
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    @Override
    public String toString() {
        return  nombre;
    }

    public ListSimple getSalones() {
        return salones;
    }

    public void setSalones(ListSimple salones) {
        this.salones = salones;
    }
    
    
    
    
}
