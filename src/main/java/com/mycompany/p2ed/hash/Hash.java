/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.p2ed.hash;

import com.mycompany.p2ed.Nodos.NodeHash;
import com.mycompany.p2ed.objetos.Usuario;

/**
 *
 * @author sergi
 */
public class Hash<T> {
    
    private static final double CARGA_MAXIMA = 0.55;
    private int size = 37;
    private NodeHash<T>[] listaId = new NodeHash[size];
    private int cantOcupado = 0;
    
    public Hash(){
        
    }
    
    public void push(int id, T data){
        Integer  key = id % size;
        if (listaId[key] == null) {
            listaId[key] =  new NodeHash();
            listaId[key].setId(id);
            listaId[key].setData(data);
            cantOcupado++;
        }else{
            colision(id,0,data);
        }
        double verificar = (double)cantOcupado/listaId.length;
        if (verificar >= CARGA_MAXIMA) {
            reHash();
        }        
    }    
    private void reHash(){
        NodeHash<T>[] aux = listaId;      
        size = getSigPrime(size*2);
        listaId =  new NodeHash[size];
        for (NodeHash i : aux) {
            if (i != null) {
                push(i.getId(),(T) i.getData());
            }
        }
    }    
    private void colision(int id, int iteracion, T data){
        int posicionNueva = (id % 7 + 1 )* iteracion;
        try{
            if (listaId[posicionNueva] == null) {
                listaId[posicionNueva] =  new NodeHash();
                listaId[posicionNueva].setId(id);
                listaId[posicionNueva].setData(data);
                cantOcupado++;
            }else{
                colision(id,iteracion+1,data);
            }
        }catch(Exception e){
            System.out.println("No se puedo ingresar el dato: " + id );
            e.printStackTrace();
        }        
    }
    public T get(int id){
        Integer  key = id % size;
        if (listaId[key] != null) {
            if(listaId[key].getId() ==  id){
                return listaId[key].getData();
            }else{
                return getInColision(id, 0);
            }            
        }else{
            return null;
        }
    }
    
    private T getInColision(int id, int iteracion){
        int posicionNueva = (id % 7 + 1 )* iteracion;
        if (posicionNueva >= size) {
            return null;
        }
        try{
            if (listaId[posicionNueva] != null) {
                if (listaId[posicionNueva].getId() == id) {
                   return listaId[posicionNueva].getData();
                }else{
                    return getInColision(id,iteracion+1);
                }
            }else{
                return null;
            }            
        }catch(Exception e){
            System.out.println("No se encontro el dato: " + id );
            e.printStackTrace();
            return null;
        }
    }
    
    public NodeHash getNode(int id){
        Integer  key = id % size;
        if (listaId[key] != null) {
            if(listaId[key].getId() ==  id){
                return listaId[key];
            }else{
                return getInColisionNode(id, 0);
            }            
        }else{
            return null;
        }
    }
    
    private NodeHash getInColisionNode(int id, int iteracion){
        int posicionNueva = (id % 7 + 1 )* iteracion;
        if (posicionNueva >= size) {
            return null;
        }
        try{
            if (listaId[posicionNueva] != null) {
                if (listaId[posicionNueva].getId() == id) {
                   return listaId[posicionNueva];
                }else{
                    return getInColisionNode(id,iteracion+1);
                }
            }else{
                return null;
            }            
        }catch(Exception e){
            System.out.println("No se encontro el dato: " + id );
            e.printStackTrace();
            return null;
        }
    }
    
    private int getSigPrime(int n){
        int i,m=0,flag=0;        
        m=n/2;      
        for(i=2;i<=m;i++){      
          if(n%i==0){      
           flag=1;      
           break;      
          }      
         }      
         if(flag==0)  {
            return n;
         }else{
            return getSigPrime(n+1);
         }         
    }
    
    //eliminar    
    public boolean pop(int id){
        Integer  key = id % size;
        if (listaId[key] != null) {
            if(listaId[key].getId() ==  id){
                listaId[key].setData(null);
                listaId[key] =  null;
                return true;
            }else{
                return getInColisionPop(id, 0);
            }            
        }else{
            return false;
        }
    }    
    private boolean getInColisionPop(int id, int iteracion){
        int posicionNueva = (id % 7 + 1 )* iteracion;
        if (posicionNueva >= size) {
            return false;
        }
        try{
            if (listaId[posicionNueva] != null) {
                if (listaId[posicionNueva].getId() == id) {
                    listaId[posicionNueva].setData(null);
                    listaId[posicionNueva] =  null;
                    return true;
                }else{
                    return getInColisionPop(id,iteracion+1);
                }
            }else{
                return false;
            }            
        }catch(Exception e){
            System.out.println("No se encontro el dato: " + id );
            e.printStackTrace();
            return false;
        }
    }
    
    //modificar
    public boolean mod(int id, T data){
        Integer  key = id % size;
        if (listaId[key] != null) {
            if(listaId[key].getId() ==  id){
                listaId[key].setData(data);
                return true;
            }else{
                return modColision(id, 0, data);
            }            
        }else{
            return false;
        }
    }
    
    private boolean modColision(int id, int iteracion, T data){
        int posicionNueva = (id % 7 + 1 )* iteracion;
        if (posicionNueva >= size) {
            return false;
        }
        try{
            if (listaId[posicionNueva] != null) {
                if (listaId[posicionNueva].getId() == id) {
                    listaId[posicionNueva].setData(data);
                    return true;
                }else{
                    return modColision(id,iteracion+1,data);
                }
            }else{
                return false;
            }            
        }catch(Exception e){
            System.out.println("No se encontro el dato: " + id );
            e.printStackTrace();
            return false;
        }
    }
    
    public void show(){
        for (NodeHash<T> node : listaId) {
            if (node != null) {
                System.out.println(node.getData());
                node.setData(null);
            }
            
        }
    }
    
    public String getEstado(String nombre){
        String estado = "subgraph cluster_arbol_"+nombre+"{\nrankdir=LR;\n"
                + "node[shape = record, style=filled, fillcolor=white];\n";
        estado += "struct_"+nombre+"_1 [label=\"";
        for (int i = 0; i < listaId.length; i++) {
            if (i+1 == listaId.length) {
                estado += "<f"+i+"> " + i;
            }else{
                estado += "<f"+i+"> " + i +"|";
            }
        }
        estado += "\"];\n";
        for (int i = 0; i < listaId.length; i++) {
            if (listaId[i] != null) {
                String actual = nombre+listaId[i].getId();
                estado +=  actual + "[label=\""+ listaId[i].getData().toString()+" \"];\n";
                estado += "struct_"+nombre+"_1:f"+i+" -> " + actual + ";\n";
            }            
        }
        return estado + "}";
    }
    
}
