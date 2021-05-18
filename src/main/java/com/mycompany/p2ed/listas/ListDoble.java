/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.p2ed.listas;

import com.mycompany.p2ed.Nodos.NodeD;
import com.mycompany.p2ed.Tree.AVL;
import com.mycompany.p2ed.objetos.Asignar;
import com.mycompany.p2ed.objetos.Salon;
import java.lang.reflect.Field;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author sergi
 */
public class ListDoble<T> {
         
    private NodeD<T> root;
    private NodeD<T> last;
    private String flecha="";
    
    public ListDoble(){
        root = null;
    }
    
    public void push(int carnet, int codHorario, T data){
        NodeD<T> nuevo = new NodeD<>(carnet, codHorario, null, null, data);        
        if (root == null) {
            root = nuevo;
            last = root;
        }else{
            nuevo.setAnt(last);
            last.setSig(nuevo);
            last = nuevo;
        }        
    }
    
    public T get(int carnet, int codHorario){
        NodeD<T> aux = root;
        while(aux != null){
            if (aux.getCarnet()== carnet && aux.getCodHorario() ==  codHorario) {
                return aux.getData();
            }
            aux = aux.getSig();
        }
        return null;
    }
    
    public void getEstudianteCurso(int codigo,DefaultTableModel dfm, AVL<String> listEst){
        NodeD<T> aux = root;
        while(aux != null){
            Asignar asignacion = (Asignar) aux.getData();
            String i = listEst.get(String.valueOf(aux.getCarnet()));
            if (i == null) {
                if (asignacion.getEstudiante() != null) {
                    String data[] = {String.valueOf(codigo),String.valueOf(aux.getCarnet()),asignacion.getEstudiante().getNombre()};
                    listEst.add(String.valueOf(aux.getCarnet()), String.valueOf(aux.getCarnet()));
                    dfm.addRow(data);
                }               
            }
            aux = aux.getSig();
        }
    }
    
    public boolean modificar(int carnet, int codHorario, T data){
        NodeD<T> aux = root;
        while(aux != null){
            if (aux.getCarnet()== carnet && aux.getCodHorario() ==  codHorario) {
                aux.setData(data);
                return true;
            }
            aux = aux.getSig();
        }
        return false;
    }
    public boolean eliminar(int carnet, int codHorario){
        NodeD<T> aux = root;
        if (root.getCarnet() == carnet && root.getCodHorario() == codHorario) {
            root.setAnt(null);
            root = root.getSig();            
            return true;
        }
        while(aux.getSig() != null){
            if (aux.getSig().getCarnet() == carnet && aux.getSig().getCodHorario() == codHorario) {
                if (aux.getSig() == last) {
                    last = aux;
                }
                try{
                    if (aux.getSig().getSig() != null) {
                        aux.getSig().getSig().setAnt(aux);                        
                    }
                }catch(Exception e){
                    e.printStackTrace();
                }    
                aux.setSig(aux.getSig().getSig());
                return true;
            }
            aux = aux.getSig();
        }
        return false;
    }
    
    public String getEstado(String nombre){
        String estado = "subgraph cluster_"+nombre+"{\nstyle=filled;\nstyle=filled;\ncolor=white;\nnode [shape=box,color=black];\n";
        NodeD aux = root;
        if (root == null) {
            return estado;
        }
        do {
            if (aux.getData().getClass().getSimpleName().equals("Asignar")) {
                Asignar asig = (Asignar) aux.getData();
                if (asig.getEstudiante() != null) {
                    String actual = "_"+aux.getCodHorario()+nombre+asig.getEstudiante().getCarnet();
                    //System.out.println(asig.getEstudiante());
                    if (aux == root)
                    {                    
                        if (last!=root)
                        {
                            String sig = "_"+aux.getSig().getCodHorario()+nombre+ aux.getSig().getCarnet();
                            estado += actual +"->"+sig + ";\n";
                        }
                    }else if (aux != last){
                            String sig = "_"+aux.getSig().getCodHorario()+nombre+ aux.getSig().getCarnet();
                            estado += actual +"->"+sig + ";\n";
                            String ant = "_"+aux.getAnt().getCodHorario()+nombre + aux.getAnt().getCarnet();
                            estado +=  actual + "->" + ant + ";\n";
                    }else{
                        String ant = "_"+aux.getAnt().getCodHorario()+nombre + aux.getAnt().getCarnet();
                        estado +=  actual + "->" + ant + ";\n";
                    }
                    estado +=  actual + "[label=\""+ aux.getData().toString() +"\\nCodigo Horario: "+aux.getCodHorario()+" \"];\n";
                }
            }
                                  
            aux = aux.getSig();            
        } while (aux != null);        
        return estado + "}";
    }
    
    public String getEstado(String nombre, String idHorario, int i){
        flecha = "";
        if (root == null) {
            return "";
        }
        String estado = "subgraph cluster_"+nombre+"_"+idHorario+"{\nrankdir=TB;\n"
                + "node[shape = record, style=filled, fillcolor=white];\n";
        NodeD aux = root;
        do {
            if (aux.getData().getClass().getSimpleName().equals("Asignar")) {
                Asignar asig = (Asignar) aux.getData();
                if (asig.getEstudiante1() != null) {
                    String actual = idHorario+nombre+asig.getEstudiante().getCarnet();
                    //System.out.println(asig.getEstudiante());
                    if (aux == root)
                    {                    
                        flecha += idHorario+":T"+i + " -> "+ actual + " [arrowhead=onormal, arrowtail=dot, dir=both,color=red,arrowsize=0.9];\n";
                        if (last!=root)
                        {
                            String sig = idHorario+nombre+ aux.getSig().getCarnet();
                            estado += actual +"->"+sig + ";\n";
                        }
                    }else if (aux != last){
                            String sig = idHorario+nombre+ aux.getSig().getCarnet();
                            estado += actual +"->"+sig + ";\n";
                            String ant = idHorario+nombre + aux.getAnt().getCarnet();
                            estado +=  actual + "->" + ant + ";\n";
                    }else{
                        String ant = idHorario+nombre + aux.getAnt().getCarnet();
                        estado +=  actual + "->" + ant + ";\n";
                    }
                    estado +=  actual + "[label=\""+ aux.getData().toString() +" \"];\n";
                    if (asig.getEstudiante1().getData() != null) {
                        flecha += actual +" -> Estudiante" + asig.getEstudiante().getCarnet()+"[arrowhead=onormal, arrowtail=dot, dir=both,color=x11maroon,arrowsize=0.9];\n";
                    }
                }
            }                                  
            aux = aux.getSig();            
        } while (aux != null);       
        return estado +"}\n";
    }
    
    public String getFlecha(){
        return flecha;
    }
    
}
