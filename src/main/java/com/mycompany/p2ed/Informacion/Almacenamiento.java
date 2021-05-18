/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.p2ed.Informacion;

import com.mycompany.p2ed.ReglasGram.datos.LexerDatos;
import com.mycompany.p2ed.ReglasGram.datos.ParserDatos;
import com.mycompany.p2ed.Tree.AVL;
import com.mycompany.p2ed.Tree.TreeB;
import com.mycompany.p2ed.hash.Hash;
import com.mycompany.p2ed.listas.ListCircularDoble;
import com.mycompany.p2ed.listas.ListDoble;
import com.mycompany.p2ed.objetos.Asignar;
import com.mycompany.p2ed.objetos.Catedratico;
import com.mycompany.p2ed.objetos.Curso;
import com.mycompany.p2ed.objetos.Edificio;
import com.mycompany.p2ed.objetos.Estudiante;
import com.mycompany.p2ed.objetos.Horario;
import com.mycompany.p2ed.objetos.Salon;
import com.mycompany.p2ed.objetos.Usuario;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.Reader;
import java.io.StringReader;
import java.nio.charset.StandardCharsets;
import java.util.List;

/**
 *
 * @author sergi
 */
public class Almacenamiento {
    private AVL<Catedratico> listCatedratico;
    private ListCircularDoble<Edificio> listEdificio;
    private ListCircularDoble<Curso> listCurso;
    private ListCircularDoble<Usuario> listUsers;
    private ListDoble<Asignar> asignacion ;
    private TreeB<Horario> horario ;
    private Hash<Estudiante> hash ;
    
    
    public Almacenamiento(){
        //No se pueden eliminar: horario,(no)catedraticos
    }
    
    public void cargarDatos(BufferedReader texto){
        //Reader inputString = new StringReader(texto);
        //BufferedReader reader = new BufferedReader(inputString);
        try{            
            BufferedReader bufer = new BufferedReader(new FileReader("C:\\Users\\sergi\\OneDrive\\Documentos\\Datos.txt",StandardCharsets.UTF_8));
            try{
                //LexerDatos lexico = new LexerDatos(reader);
                LexerDatos lexico = new LexerDatos(texto);
                ParserDatos parse = new ParserDatos(lexico);          
                
                try {
                    parse.parse();
                } catch (Exception ex) {
                 System.out.println("error en el parser: " + ex.getMessage());
                    ex.printStackTrace();
                }
                listCatedratico = parse.getCatedraticos();
                listEdificio = parse.getEdificios();
                listCurso = parse.getCursos();
                listUsers = parse.getUsuarios();
                asignacion = parse.getAsignaciones();
                horario = parse.getHorario();
                hash =  parse.getEstudiantes();
                
                                
                List<String> errores = parse.getListErrores();
                for (String errore : errores) {
                    System.out.println(errore);
                }
                if (errores.isEmpty()) {
                    System.out.println("Datos cargados correctamente");
                }
            
            }catch(Exception e){
               System.out.println("error en el lexer: " + e.getMessage());
               //e.printStackTrace();
            }
        }catch(Exception e){           
            System.out.println("error en el buffer: " + e.getMessage());
        }
    }
    
    public String getEstadoTodo(){
        String estado = listEdificio.getEstado("edificio") +"\n"+  listCatedratico.getEstado("catedratico")+listCurso.getEstado("curso")+"\n"+ horario.getEstadoTodo("Horario") +"\n" ;
                estado += listUsers.getEstado("user") + "\n" + hash.getEstado("Estudiante") ;
                estado += horario.getFlechas();
        return estado;
    }
    public String getEstadoCatedraticos(){
        return listCatedratico.getEstado("Catedratico");
    }
    public String getEstadoEdificios(){
        return listEdificio.getEstado("edificio");
    }
    public String getEstadoCursos(){
        return listCurso.getEstado("curso");
    }    
    public String getEstadoUsuarios(){
        return listUsers.getEstado("user");
    }
    public String getEstadoAsignaciones(){
        return asignacion.getEstado("asgi");
    }
    public String getEstadoHorario(){
        return horario.getEstado("Horario");
    }
    public String getEstadoEstudiantes(){
        return hash.getEstado("Estudiantes");
    }

    public AVL<Catedratico> getListCatedratico() {
        return listCatedratico;
    }

    public void setListCatedratico(AVL<Catedratico> listCatedratico) {
        this.listCatedratico = listCatedratico;
    }

    public ListCircularDoble<Edificio> getListEdificio() {
        return listEdificio;
    }

    public void setListEdificio(ListCircularDoble<Edificio> listEdificio) {
        this.listEdificio = listEdificio;
    }

    public ListCircularDoble<Curso> getListCurso() {
        return listCurso;
    }

    public void setListCurso(ListCircularDoble<Curso> listCurso) {
        this.listCurso = listCurso;
    }

    public ListCircularDoble<Usuario> getListUsers() {
        return listUsers;
    }

    public void setListUsers(ListCircularDoble<Usuario> listUsers) {
        this.listUsers = listUsers;
    }

    public ListDoble<Asignar> getAsignacion() {
        return asignacion;
    }

    public void setAsignacion(ListDoble<Asignar> asignacion) {
        this.asignacion = asignacion;
    }

    public TreeB<Horario> getHorario() {
        return horario;
    }

    public void setHorario(TreeB<Horario> horario) {
        this.horario = horario;
    }

    public Hash<Estudiante> getHash() {
        return hash;
    }

    public void setHash(Hash<Estudiante> hash) {
        this.hash = hash;
    }
    
    
}
