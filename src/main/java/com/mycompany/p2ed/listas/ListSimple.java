/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.p2ed.listas;

/**
 *
 * @author sergi
 */
public class ListSimple<T> {
    
    private Nodo<T> root;

    public ListSimple(){
        root = null;
    }

    public boolean push(int id, T data){
        T dat = get(id);
        if (dat != null) {
            return false;
        }
        
       if (root!=null) {
           Nodo<T> tmp = root;
            root = new Nodo<T>(id,data,tmp);
       }
       else{
           root = new Nodo<T>(id,data,null);
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
        Nodo<T> aux = root;
        while(aux != null){
            if (aux.getId() ==  id) {
                return aux.getData();
            }
            aux = aux.getNext();
        }
        return null;
    }
    
    public boolean eliminar(int id){
        Nodo<T> aux = root;
        if (root.getId() == id) {
            root = root.getNext();
            return true;
        }
        while(aux.getNext() != null){
            if (aux.getNext().getId() == id) {
                aux.setNext(aux.getNext().getNext());
                return true;
            }
            aux = aux.getNext();
        }
        return false;
    }
    
    public boolean Modificar(int id, T data){
        Nodo<T> aux = root;
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
        Nodo aux = root;
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

    private class Nodo <T>{
        
        private int id;
        private Nodo<T> next;
        private T data;

        private Nodo(int id ,T data, Nodo<T> next){
            this.id = id;
            this.next = next;
            this.data = data;
        }

        private Nodo<T> getNext(){
            return this.next;
        }

        private T getData(){
            return this.data;
        }

        public int getId() {
            return id;
        }

        public void setNext(Nodo<T> next) {
            this.next = next;
        }

        public void setData(T data) {
            this.data = data;
        }    

    }
}
