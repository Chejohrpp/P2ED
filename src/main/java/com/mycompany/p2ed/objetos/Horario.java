/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.p2ed.objetos;

import com.mycompany.p2ed.Nodos.NodeCD;
import com.mycompany.p2ed.Nodos.NodoS;
import com.mycompany.p2ed.listas.ListDoble;

/**
 *
 * @author sergi
 */
public class Horario {
    
    private int id;
    private String periodo;
    private String dia;
    private NodeCD<Curso> curso;
    private NodoS<Salon> salon;
    private NodeCD<Edificio> edificio;
    private Catedratico catedratico;
    private ListDoble<Asignar> asignaciones;

    public Horario(int id, String periodo, String dia, NodeCD curso, NodoS salon, NodeCD edificio, Catedratico catedratico) {
        this.id = id;
        this.periodo = periodo;
        this.dia = dia;
        this.curso = curso;
        this.salon = salon;
        this.edificio = edificio;
        this.catedratico = catedratico;
        this.asignaciones =  new ListDoble<>();
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getPeriodo() {
        return periodo;
    }

    public void setPeriodo(String periodo) {
        this.periodo = periodo;
    }

    public String getDia() {
        return dia;
    }

    public void setDia(String dia) {
        this.dia = dia;
    }

    public NodeCD getCurso() {
        return curso;
    }

    public void setCurso(NodeCD curso) {
        this.curso = curso;
    }

    public NodoS getSalon() {
        return salon;
    }

    public void setSalon(NodoS salon) {
        this.salon = salon;
    }

    public NodeCD getEdificio() {
        return edificio;
    }

    public void setEdificio(NodeCD edificio) {
        this.edificio = edificio;
    }

    public Catedratico getCatedratico() {
        return catedratico;
    }

    public void setCatedratico(Catedratico catedratico) {
        this.catedratico = catedratico;
    }

    public ListDoble<Asignar> getAsignaciones() {
        return asignaciones;
    }

    public void setAsignaciones(ListDoble<Asignar> asignaciones) {
        this.asignaciones = asignaciones;
    }

    
    @Override
    public String toString() {
        String estado = "";
        if (curso.getData() != null) {
            estado += "Curso: "+curso.getData().getCodigo()+"\\n";
        }else{
            estado += "Curso: null"+"\\n";
        }
        if (salon.getData() != null && edificio.getData() != null) {
            estado += "Salon: "+salon.getData().getNumeroSalon()+"\\n";
        }else{
            estado += "Salon: null"+"\\n";
        }
        if(edificio.getData() != null){
            estado += "Edificio: "+edificio.getData().getNombre()+"\\n";
        }else{
            estado += "Edificio: null"+"\\n";
        }
        if (catedratico != null) {
            estado += "Catedratico: "+catedratico.getId()+"\\n";
        }        
        return id + "\\n" + estado + periodo + "\\n" + dia ;
    }
    
}
