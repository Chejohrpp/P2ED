/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.p2ed.objetos;

import com.mycompany.p2ed.Nodos.NodeHash;
import com.mycompany.p2ed.hash.Hash;

/**
 *
 * @author sergi
 */
public class Asignar {
    
    private Estudiante estudiante;
    private NodeHash<Estudiante> estudiante1;
    private Horario horario;
    private int zona;
    private int ex_final;

    public Asignar(Estudiante estudiante, Horario horario, int zona, int ex_final) {
        this.estudiante = estudiante;
        this.horario = horario;
        this.zona = zona;
        this.ex_final = ex_final;
    }   
    public Estudiante getEstudiante() {
        return estudiante;
    }

    public void setEstudiante(Estudiante estudiante) {
        this.estudiante = estudiante;
    }

    public Horario getHorario() {
        return horario;
    }

    public void setHorario(Horario horario) {
        this.horario = horario;
    }

    public int getZona() {
        return zona;
    }

    public void setZona(int zona) {
        this.zona = zona;
    }

    public int getEx_final() {
        return ex_final;
    }

    public void setEx_final(int ex_final) {
        this.ex_final = ex_final;
    }

    public NodeHash getEstudiante1() {
        return estudiante1;
    }

    public void setEstudiante1(NodeHash estudiante1) {
        this.estudiante1 = estudiante1;
    }
    
    @Override
    public String toString() {
        if (estudiante1.getData() != null) {
            return estudiante1.getData().getCarnet()+ "\\nZona: "+ zona + "\\nFinal: " + ex_final;
        }else{
            return "null"+ "\\nZona: "+ zona + "\\nFinal: " + ex_final;
        }        
    }
    
    
}
