/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.p2ed;

import com.mycompany.p2ed.ReglasGram.datos.*;
import com.mycompany.p2ed.Tree.AVL;
import com.mycompany.p2ed.Tree.TreeB;
import com.mycompany.p2ed.hash.Hash;
import com.mycompany.p2ed.listas.ListCircularDoble;
import com.mycompany.p2ed.listas.ListDoble;
import com.mycompany.p2ed.listas.ListSimple;
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
import java.nio.charset.StandardCharsets;
import java.util.List;

/**
 *
 * @author sergi
 */
public class Main {
    
    public static void main(String[] args) {
        Dibujar dibujar = new Dibujar();
        try{            
            BufferedReader bufer = new BufferedReader(new FileReader("C:\\Users\\sergi\\OneDrive\\Documentos\\Datos.txt",StandardCharsets.UTF_8));
            try{
                LexerDatos lexico = new LexerDatos(bufer);
                ParserDatos parse = new ParserDatos(lexico);          
                
                try {
                    parse.parse();
                } catch (Exception ex) {
                 System.out.println("error en el parser: " + ex.getMessage());
                    ex.printStackTrace();
                }
                AVL<Catedratico> listCatedratico = parse.getCatedraticos();
                ListCircularDoble<Edificio> listEdificio = parse.getEdificios();
                ListCircularDoble<Curso> listCurso = parse.getCursos();
                ListCircularDoble<Usuario> listUsers = parse.getUsuarios();
                ListDoble<Asignar> asignacion = parse.getAsignaciones();
                TreeB<Horario> horario = parse.getHorario();
                Hash<Estudiante> hash =  parse.getEstudiantes();
                
                horario.Insert(13, new Horario(13,"periodo","dia",null,null,null,null));
                horario.Insert(14, new Horario(14,"periodo","dia",null,null,null,null));
                horario.Insert(15, new Horario(15,"periodo","dia",null,null,null,null));
                //dibujar.avlCatedraticos(listCatedratico.getEstado("Catedratico"));
                //dibujar.estrucGeneric(listEdificio.getEstado("edificio"),"ListEdificos");
                //dibujar.estrucGeneric(listCurso.getEstado("curso"),"ListCursos");
                //dibujar.estrucGeneric(listUsers.getEstado("user"),"ListUsuarios");
                //dibujar.estrucGeneric(asignacion.getEstado("asgi"),"Asginaciones1");
//                parse.getEstudiantes().show();
//                //parse.getEstudiantes().pop(200745781);
//                System.out.println("");
                //dibujar.estrucGeneric(asignacion.getEstado("asgi"),"Asginaciones2");
                //dibujar.estrucGeneric(horario.getEstado("Horario"), "TreeHorario");
                //dibujar.estrucGeneric(hash.getEstado("Estudiantes"), "Hash");
                List<String> errores = parse.getListErrores();
                for (String errore : errores) {
                    System.out.println(errore);
                }
            
            }catch(Exception e){
               System.out.println("error en el lexer: " + e.getMessage());
            }
        }catch(Exception e){           
            System.out.println("error en el buffer: " + e.getMessage());
        }
        
        
        
        
    }
        
         
}
