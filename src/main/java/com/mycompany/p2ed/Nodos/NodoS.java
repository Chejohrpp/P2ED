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
public class NodoS<T> {
    
    private int id;
        private NodoS<T> next;
        private T data;

        public NodoS(int id ,T data, NodoS<T> next){
            this.id = id;
            this.next = next;
            this.data = data;
        }

        public NodoS<T> getNext(){
            return this.next;
        }

        public T getData(){
            return this.data;
        }

        public int getId() {
            return id;
        }

        public void setNext(NodoS<T> next) {
            this.next = next;
        }

        public void setData(T data) {
            this.data = data;
        }
}
