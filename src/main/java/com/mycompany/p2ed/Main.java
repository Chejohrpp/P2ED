/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.p2ed;

import com.mycompany.p2ed.Informacion.Almacenamiento;
import com.mycompany.p2ed.fronted.Login;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileReader;
import java.io.InputStreamReader;
import java.nio.charset.StandardCharsets;
import java.util.Scanner;

/**
 *
 * @author sergi
 */
public class Main {
    
    private static Almacenamiento almacenamiento =  new Almacenamiento();
    private static Dibujar dibujar = new Dibujar();
    private static Scanner scanner = new Scanner(System.in);
    
    public static void main(String[] args) {        
        almacenamiento.cargarDatos(null);
        Login login = new Login(almacenamiento);
        login.setLocationRelativeTo(null);
        login.setVisible(true);
        //dibujar.estrucGeneric(almacenamiento.getEstadoTodo(), "TODO");
        //dibujar();
    }    
    public static void dibujar(){
        //dibujar.avlCatedraticos(almacenamiento.getEstadoCatedraticos());              1
        //dibujar.estrucGeneric(almacenamiento.getEstadoEdificios(),"ListEdificos");    2  
        //dibujar.estrucGeneric(almacenamiento.getEstadoCursos(),"ListCursos");         3
        //dibujar.estrucGeneric(almacenamiento.getEstadoUsuarios(),"ListUsuarios");     4
        //dibujar.estrucGeneric(almacenamiento.getEstadoAsignaciones(),"Asginaciones"); 5
        //dibujar.estrucGeneric(almacenamiento.getEstadoHorario(), "TreeHorario");      6
        //dibujar.hash(almacenamiento.getEstadoEstudiantes(), "Hash");                  7
        //dibujar.estrucGeneric(almacenamiento.getEstadoTodo(), "TODO");                8
        OUTER:
        while(true){
            System.out.println("\nGraficar Estado");
            System.out.println("Escoja el numero de opcion");
            System.out.println("1.Ver arbol de catedraticos");
            System.out.println("2.ver lista de Edificios y salones");
            System.out.println("3.Ver Lista de cursos");
            System.out.println("4.Ver la lista de usuarios");
            System.out.println("5.Ver las asignaciones");
            System.out.println("6.Ver arbol de horario");
            System.out.println("7.Ver los Estudiantes");
            System.out.println("8.Ver Todo");
            System.out.println("9.Regresar");
            String opcion = scanner.nextLine();            
            switch(opcion){
                case "1":{
                    dibujar.avlCatedraticos(almacenamiento.getEstadoCatedraticos());
                    break OUTER;
                }
                case "2":{
                   dibujar.estrucGeneric(almacenamiento.getEstadoEdificios(),"ListEdificos");
                    break OUTER;
                }
                case "3":{
                    dibujar.estrucGeneric(almacenamiento.getEstadoCursos(),"ListCursos");
                    break OUTER;
                }
                case "4":{
                    dibujar.estrucGeneric(almacenamiento.getEstadoUsuarios(),"ListUsuarios");
                    break OUTER;
                }
                case "5":{
                    dibujar.estrucGeneric(almacenamiento.getEstadoAsignaciones(),"Asginaciones");
                    break OUTER;
                }
                case "6":{
                    dibujar.estrucGeneric(almacenamiento.getEstadoHorario(), "TreeHorario");
                    break OUTER;
                }
                case "7":{
                    dibujar.hash(almacenamiento.getEstadoEstudiantes(), "Hash");
                    break OUTER;
                }
                case "8":{
                    dibujar.estrucGeneric(almacenamiento.getEstadoTodo(), "TODO");
                    break OUTER;
                }
                case "9": break OUTER;
                default:break;
            }            
        }        
    }      
}
