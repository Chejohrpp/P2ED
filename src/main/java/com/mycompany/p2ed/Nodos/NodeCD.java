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
public class NodeCD<T> {
    
    private String id;
        private T data;
        private NodeCD<T> ant;
        private NodeCD<T> sig;

        public NodeCD(String id, T data) {
            this.id = id;
            this.data = data;
            this.ant = null;
            this.sig = null;
        }

        public String getId() {
            return id;
        }

        public T getData() {
            return data;
        }

        public NodeCD<T> getAnt() {
            return ant;
        }

        public NodeCD<T> getSig() {
            return sig;
        }

        public void setData(T data) {
            this.data = data;
        }

        public void setAnt(NodeCD<T> ant) {
            this.ant = ant;
        }

        public void setSig(NodeCD<T> sig) {
            this.sig = sig;
        }
}
