/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.p2ed.listas;

import com.mycompany.p2ed.Nodos.NodoS;

/**
 *
 * @author sergi
 */
public class ListSimple<T> {
    
    private NodoS<T> root;

    public ListSimple(){
        root = null;
    }

    public boolean push(int id, T data){
        T dat = get(id);
        if (dat != null) {
            return false;
        }
        
       if (root!=null) {
           NodoS<T> tmp = root;
            root = new NodoS<T>(id,data,tmp);
       }
       else{
           root = new NodoS<T>(id,data,null);
       }
       return true;
    }
    

    public T pop(){
        if (root != null){
            T data = root.getData();
            root = root.getNext();
            return data;
        }
        else
            return null;
    }
    
    public T get(int id){
        NodoS<T> aux = root;
        while(aux != null){
            if (aux.getId() ==  id) {
                return aux.getData();
            }
            aux = aux.getNext();
        }
        return null;
    }
    
    public NodoS getNodo(int id){
        NodoS<T> aux = root;
        while(aux != null){
            if (aux.getId() ==  id) {
                return aux;
            }
            aux = aux.getNext();
        }
        return null;
    }
    
    public boolean eliminar(int id){
        NodoS<T> aux = root;
        if (root.getId() == id) {
            root.setData(null);
            root = root.getNext();
            return true;
        }
        while(aux.getNext() != null){
            if (aux.getNext().getId() == id) {
                aux.getNext().setData(null);
                aux.setNext(aux.getNext().getNext());
                return true;
            }
            aux = aux.getNext();
        }
        return false;
    }
    
    public boolean Modificar(int id, T data){
        NodoS<T> aux = root;
        while(aux != null){
            if (aux.getId() ==  id) {
                aux.setData(data);
                return true;
            }
            aux = aux.getNext();
        }
        return false;
    }
    
    public String getEstado(String nombre, String idEdificio){
        String estado = "";
        NodoS aux = root;
        if (root == null) {
            return estado;
        }
        do {
            String actual = nombre+aux.getId();
            if (aux == root)
            {
                estado += idEdificio + "->"+ actual + ";\n";
                    if (root.getNext() != null)
                    {
                        String sig = nombre+ aux.getNext().getId();
                        estado += actual +"->"+sig + ";\n";
                    }
            }else if (aux.getNext() != null){
                    String sig = nombre+ aux.getNext().getId();
                    estado += actual +"->"+sig + ";\n";
            }
            estado +=  actual + "[label=\""+ aux.getData().toString()+" \"];\n";                       
            aux = aux.getNext();
        } while (aux != null);        
        return estado;
    }
}
