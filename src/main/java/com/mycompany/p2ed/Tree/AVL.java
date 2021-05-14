/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.p2ed.Tree;

/**
 *
 * @author sergi
 */
public class AVL<T> {
    
    private class Node<T>{
        private String id;
        private T data;
        private Node<T> izq;
        private Node<T> derc;
        private int altura;

        public Node(String id, T data) {
            this.id = id;
            this.data = data;
            this.izq = null;
            this.derc = null;
        }

        public String getId() {
            return id;
        }

        public void setId(String id) {
            this.id = id;
        }

        public T getData() {
            return data;
        }

        public Node<T> getIzq() {
            return izq;
        }

        public Node<T> getDerc() {
            return derc;
        }

        public void setData(T data) {
            this.data = data;
        }

        public void setIzq(Node<T> izq) {
            this.izq = izq;
        }

        public void setDerc(Node<T> der) {
            this.derc = der;
        }       

        public int getAltura() {
            return altura;
        }

        public void setAltura(int altura) {
            this.altura = altura;
        }
        
        
    }
    
     private Node<T> raiz;
    private int cantNodos = 0;
    
    public AVL(){
        raiz = null;
    }
    public int getCantNodos(){
        return cantNodos;
    }
    
    private void updateAltura(Node<T> n) {
        n.setAltura(1 + Math.max(altura(n.getIzq()),altura(n.getDerc())));
    }

    private int altura(Node<T> n) {
        return n == null ? -1 : n.getAltura();
    }

    private int getBalance(Node<T> n) {
        return (n == null) ? 0 : altura(n.getDerc()) - altura(n.getIzq());
    }
    
    public int getAltura() {
        return raiz == null ? -1 : raiz.getAltura();
    }
    public Node<T> getRaiz(){
        return raiz;
    }
    
    private Node<T> rotateRight(Node<T> y) {
        Node<T> x = y.getIzq();
        Node<T> z = x.getDerc();
        x.setDerc(y);
        y.setIzq(z);
        updateAltura(y);
        updateAltura(x);
        return x;
    }
    
    private Node<T> rotateLeft(Node<T> y) {
        Node<T> x = y.getDerc();
        Node<T> z = x.getIzq();
        x.setIzq(y);
        y.setDerc(z);
        updateAltura(y);
        updateAltura(x);
        return x;
    }
    
    private Node<T> rebalance(Node<T> z) {
        updateAltura(z);
        int balance = getBalance(z);
        if (balance > 1) {
            if (altura(z.getDerc().getDerc()) > altura(z.getDerc().getIzq())) {
                z = rotateLeft(z);
            } else {
                z.setDerc(rotateRight(z.getDerc()));                
                z = rotateLeft(z);
            }
        } else if (balance < -1) {
            if (altura(z.getIzq().getIzq()) > altura(z.getIzq().getDerc()))
                z = rotateRight(z);
            else {
                z.setIzq(rotateLeft(z.getIzq()));
                z = rotateRight(z);
            }
        }
        return z;
    }    
    public void add(String id, T object){
        raiz = insert(raiz,id,object);
    }   
    private Node<T> insert(Node<T> node, String id, T object){
        if (node == null) {
            cantNodos++;
            return new Node<T>(id, object);        
        } else if (node.getId().compareTo(id) > 0) {
            node.setIzq(insert(node.getIzq(),id,object));            
        } else if (node.getId().compareTo(id) <  0 ) {
            node.setDerc(insert(node.getDerc(),id,object));            
        } else {
            System.out.println("Codigo duplicado: " + id);
        }
        return rebalance(node);  
    }
    
    public void remove(String id){                
        raiz = delete(raiz,id);
    }   
    private Node<T> delete(Node<T> node, String id){
        if (node == null) {
            return node;
        } else if (node.getId().compareTo(id) > 0) {
            node.setIzq(delete(node.getIzq(),id));            
        } else if (node.getId().compareTo(id) < 0) {
            node.setDerc(delete(node.getDerc(),id));            
        } else {
            if (node.getIzq() == null || node.getDerc() == null) {
                node = (node.getIzq() == null) ? node.getDerc() : node.getIzq();
            } else {
                Node<T> mostLeftChild = mostLeftChild(node.getDerc());
                node.setId(mostLeftChild.getId());
                node.setDerc(delete(node.getDerc(),node.getId()));
            }
        }
        if (node != null) {
            node = rebalance(node);
        }
        return node;
    }    
    private Node<T> mostLeftChild(Node<T> node) {
        Node<T> current = node;
        /* loop down to find the leftmost leaf */
        while (current.getIzq() != null) {
            current = current.getIzq();
        }
        return current;
    }
    
    public Node<T> find(String id) {
        Node<T> current = raiz;
        while (current != null) {
            if (current.getId().equals(id)) {
               break;
            }
            current = current.getId().compareTo(id) < 0 ? current.getDerc() : current.getIzq();
        }
        return current;
    }
    public void Modificar(String id, T obj){
        Node<T> node = find(id);
        if (node != null) {
            raiz = delete(raiz,id);
            raiz = insert(raiz,id,obj);
            System.out.println(id +" modificado con exito");
        }else{
            System.out.println("No esta el usuario a modificar");
        }
    }
    
    public T get(String id){
        Node<T> current = find(id);
        if (current != null) {
            return current.getData();
        }else{
            return null;
        }
    }
    //graficar
    public String getEstado(String nombre){
        String estado = "subgraph cluster_arbol_"+nombre+"{\nrankdir=TB;\n"
                + "node[shape = record, style=filled, fillcolor=white];\n";
        Node<T> aux = raiz;
        if (aux == null) {
            return estado + " }";
        }
        estado += getSubEstados(aux,nombre);                   
        return estado + "}";
    }
    private String getSubEstados(Node<T> raiz, String nombre){
        String estado = "";
        Node<T> aux = raiz;
        String actual = nombre+aux.getId();
        if (aux.getIzq() != null) {
            String iz = nombre+aux.getIzq().getId();
            estado += actual +":C0->"+ iz +";\n";
            estado += getSubEstados(aux.getIzq(),nombre);
        }            
        if (aux.getDerc() != null) {
            String der =  nombre+aux.getDerc().getId();
            estado += actual +":C1->"+ der + ";\n";
            estado += getSubEstados(aux.getDerc(),nombre);
        }
        if (aux.getDerc() == null && aux.getIzq()==null) {
            estado += actual + "[label=\""+aux.getData().toString()+"\"];\n";            
        }else{
            estado += actual + "[ label =\"<C0>|"+aux.getData().toString()+"|<C1>\"];\n";
        }         
        return estado;
    } 
}
