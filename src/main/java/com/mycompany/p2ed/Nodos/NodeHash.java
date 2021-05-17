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
public class NodeHash<T> {
    
        private int id;
        private T data;
        public NodeHash(){
            id = 0;
            data = null;
        }

        public int getId() {
            return id;
        }

        public void setId(int id) {
            this.id = id;
        }

        public T getData() {
            return data;
        }

        public void setData(T data) {
            this.data = data;
        }
        
    }
