/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.p2ed.listas;

import com.mycompany.p2ed.objetos.Asignar;
import com.mycompany.p2ed.objetos.Salon;
import java.lang.reflect.Field;

/**
 *
 * @author sergi
 */
public class ListDoble<T> {
    
    private class Node<T>{
        private int carnet;
        private int codHorario;
        private Node<T> ant;
        private Node<T> sig;
        private T data;

        public Node(int carnet, int codHorario, Node<T> ant, Node<T> sig, T data) {
            this.carnet = carnet;
            this.codHorario = codHorario;
            this.ant = ant;
            this.sig = sig;
            this.data = data;
        }   

        public int getCarnet() {
            return carnet;
        }

        public int getCodHorario() {
            return codHorario;
        }

        public Node<T> getAnt() {
            return ant;
        }

        public Node<T> getSig() {
            return sig;
        }

        public T getData() {
            return data;
        }

        public void setAnt(Node<T> ant) {
            this.ant = ant;
        }

        public void setSig(Node<T> sig) {
            this.sig = sig;
        }

        public void setData(T data) {
            this.data = data;
        }        
           
    }
    
    private Node<T> root;
    private Node<T> last;
    
    public ListDoble(){
        root = null;
    }
    
    public void push(int carnet, int codHorario, T data){
        Node<T> nuevo = new Node<>(carnet, codHorario, null, null, data);        
        if (root == null) {
            root = nuevo;
            last = root;
        }else{
            nuevo.setAnt(last);
            last.setSig(nuevo);
            last = nuevo;
        }        
    }
    
    public T get(int carnet, int codHorario){
        Node<T> aux = root;
        while(aux != null){
            if (aux.getCarnet()== carnet && aux.getCodHorario() ==  codHorario) {
                return aux.getData();
            }
            aux = aux.getSig();
        }
        return null;
    }
    
    public boolean modificar(int carnet, int codHorario, T data){
        Node<T> aux = root;
        while(aux != null){
            if (aux.getCarnet()== carnet && aux.getCodHorario() ==  codHorario) {
                aux.setData(data);
                return true;
            }
            aux = aux.getSig();
        }
        return false;
    }
    public boolean eliminar(int carnet, int codHorario){
        Node<T> aux = root;
        if (root.getCarnet() == carnet && root.getCodHorario() == codHorario) {
            root = root.getSig();
            root.setAnt(null);
            return true;
        }
        while(aux.getSig() != null){
            if (aux.getSig().getCarnet() == carnet && aux.getSig().getCodHorario() == codHorario) {
                aux.setSig(aux.getSig().getSig());
                try{
                    if (aux.getSig().getSig() != null) {
                        aux.getSig().getSig().setAnt(aux);
                    }
                }catch(Exception e){
                    
                }                                
                return true;
            }
            aux = aux.getSig();
        }
        return false;
    }
    
    public String getEstado(String nombre){
        String estado = "subgraph cluster_"+nombre+"{\nstyle=filled;\nstyle=filled;\ncolor=white;\nnode [shape=box,color=black];\n";
        Node aux = root;
        if (root == null) {
            return estado;
        }
        do {
            if (aux.getData().getClass().getSimpleName().equals("Asignar")) {
                Asignar asig = (Asignar) aux.getData();
                if (asig.getEstudiante() != null) {
                    String actual = nombre+asig.getEstudiante().getCarnet();
                    //System.out.println(asig.getEstudiante());
                    if (aux == root)
                    {                    
                        if (last!=root)
                        {
                            String sig = nombre+ aux.getSig().getCarnet();
                            estado += actual +"->"+sig + ";\n";
                        }
                    }else if (aux != last){
                            String sig = nombre+ aux.getSig().getCarnet();
                            estado += actual +"->"+sig + ";\n";
                            String ant = nombre + aux.getAnt().getCarnet();
                            estado +=  actual + "->" + ant + ";\n";
                    }else{
                        String ant = nombre + aux.getAnt().getCarnet();
                        estado +=  actual + "->" + ant + ";\n";
                    }
                    estado +=  actual + "[label=\""+ aux.getCarnet()+ aux.getData().toString() +" \"];\n";
                }
            }
                                  
            aux = aux.getSig();            
        } while (aux != null);        
        return estado + "}";
    }
    
}
