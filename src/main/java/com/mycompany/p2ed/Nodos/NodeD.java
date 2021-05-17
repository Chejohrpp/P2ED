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
public class NodeD<T> {
    
    private int carnet;
        private int codHorario;
        private NodeD<T> ant;
        private NodeD<T> sig;
        private T data;

        public NodeD(int carnet, int codHorario, NodeD<T> ant, NodeD<T> sig, T data) {
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

        public NodeD<T> getAnt() {
            return ant;
        }

        public NodeD<T> getSig() {
            return sig;
        }

        public T getData() {
            return data;
        }

        public void setAnt(NodeD<T> ant) {
            this.ant = ant;
        }

        public void setSig(NodeD<T> sig) {
            this.sig = sig;
        }

        public void setData(T data) {
            this.data = data;
        }
}
