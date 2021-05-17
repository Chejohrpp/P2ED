/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.p2ed.Nodos;

/**
 *
 * @author sergi
 */
public class NodeAVL<T> {
    
     private String id;
        private T data;
        private NodeAVL<T> izq;
        private NodeAVL<T> derc;
        private int altura;

        public NodeAVL(String id, T data) {
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

        public NodeAVL<T> getIzq() {
            return izq;
        }

        public NodeAVL<T> getDerc() {
            return derc;
        }

        public void setData(T data) {
            this.data = data;
        }

        public void setIzq(NodeAVL<T> izq) {
            this.izq = izq;
        }

        public void setDerc(NodeAVL<T> der) {
            this.derc = der;
        }       

        public int getAltura() {
            return altura;
        }

        public void setAltura(int altura) {
            this.altura = altura;
        }
}
