/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.p2ed.listas;

import com.mycompany.p2ed.Nodos.NodeCD;
import com.mycompany.p2ed.objetos.Edificio;

/**
 *
 * @author sergi
 */
public class ListCircularDoble<T> {
    
    private NodeCD<T> root;
    private NodeCD<T> last;
    
    public ListCircularDoble(){
        root = null;
        last = null;
    }
    
    public boolean push(String id,  T data){
        T data1 = get(id);
        if (data1 != null) {
            return false;
        }
        NodeCD<T> nuevo = new NodeCD<>(id, data);
        if (root == null) {
            root = nuevo;
            root.setAnt(root);
            root.setSig(root);
            last = root;
        }else{
            nuevo.setAnt(last);
            nuevo.setSig(root);
            last.setSig(nuevo);
            last = nuevo;
            root.setAnt(last);
        }
        return true;
    }
    
    public T get(String id){
        NodeCD<T> aux = root;
        if (root==null) {
            return null;
        }
        do {
            if (aux.getId().equals(id)) {
                return aux.getData();
            }
            aux = aux.getSig();
        } while (aux != root);
        return null;
    }
    
    public NodeCD getNode(String id){
        NodeCD<T> aux = root;
        if (root==null) {
            return null;
        }
        do {
            if (aux.getId().equals(id)) {
                return aux;
            }
            aux = aux.getSig();
        } while (aux != root);
        return null;
    }
    
    public boolean show(){
        NodeCD<T> aux = root;
        if (root==null) {
            return false;
        }
        do {
            System.out.println("id:" + aux.getId());
            aux = aux.getSig();
        } while (aux != root);
        return true;
    }
    
    public boolean modificar(String id, T data){
        NodeCD<T> aux = root;
        do {
            if (aux.getId().equals(id)) {
                aux.setData(data);
                return true;
            }
            aux = aux.getSig();
        } while (aux != root);
        return false;
    }
    
    public boolean eliminar(String id){
        NodeCD<T> aux = root;   
        if (root == null) {
            return false;
        }
        do {
            if (aux.getId().equals(id)) {
                aux.setData(null);
                if (aux == root) {
                    if (last == root) {
                        root = null;
                        last = null;
                    }else{                        
                        root.getSig().setAnt(last);                        
                        root = root.getSig();
                        last.setSig(root);
                    }               
                }else if(aux == last){
                    last.getAnt().setSig(root);
                    last = last.getAnt();
                    root.setAnt(last);
                }else{
                    aux.getSig().setAnt(aux.getAnt());
                    aux.getAnt().setSig(aux.getSig());
                }
                return true;
            }            
            aux = aux.getSig();
        } while (aux != root);
        
        return false;
    }
    
    //graficar
    public String getEstado(String nombre){
        String estado = "subgraph cluster_"+nombre+"{\nnode [shape=box,color=black];\n";
        NodeCD<T> aux = root;
        if (root == null) {
            return estado +"}";
        }
        do {
            String actual = nombre+"_"+aux.getId();
            String sig = nombre+"_"+aux.getSig().getId();
            estado += actual +"->"+ sig +"[constraint=false];\n";                                             
            estado +=  actual + "[label=\""+aux.getData().toString()+"\"];\n";                         
            aux = aux.getSig();
        } while (aux != root);
        aux = root;
        do {
            String actual = nombre+"_"+aux.getId();
            String ant = nombre+"_"+aux.getAnt().getId();
            estado += actual +"->"+ ant +"[constraint=false];\n";
            if (aux.getData().getClass().getSimpleName().equalsIgnoreCase("Edificio")) {
                Edificio edificio = (Edificio) aux.getData();
                if (edificio.getSalones() !=  null) {                    
                    estado += edificio.getSalones().getEstado("salon_" + actual, actual);
                } 
            }                      
            aux = aux.getSig();
        } while (aux != root);        
        return estado + "}";
    }
    
}
