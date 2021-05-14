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
public class Salon {
    
    private Edificio edificio;
    private int numeroSalon;
    private int capacidad;

    public Salon(Edificio Edificio, int numeroSalon, int capacidad) {
        this.edificio = Edificio;
        this.numeroSalon = numeroSalon;
        this.capacidad = capacidad;
    }

    public Edificio getEdificio() {
        return edificio;
    }

    public void setEdificio(Edificio edificio) {
        this.edificio = edificio;
    }
    
    public int getNumeroSalon() {
        return numeroSalon;
    }

    public void setNumeroSalon(int numeroSalon) {
        this.numeroSalon = numeroSalon;
    }

    public int getCapacidad() {
        return capacidad;
    }

    public void setCapacidad(int capacidad) {
        this.capacidad = capacidad;
    }

    @Override
    public String toString() {
        return numeroSalon + "\\n" + capacidad +" Estudiantes" ;
    }
    
    
}
