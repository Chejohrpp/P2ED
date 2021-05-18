/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.p2ed.Tree;

import com.mycompany.p2ed.listas.ListSimple;
import com.mycompany.p2ed.objetos.Curso;
import com.mycompany.p2ed.objetos.Edificio;
import com.mycompany.p2ed.objetos.Horario;
import com.mycompany.p2ed.objetos.Salon;
import java.util.Stack;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author sergi
 */
public class TreeB<T> {
    
    private int T;
    private int i = 0;
    private int iteracion = 0;
    private String flechas = "";
    private String subGrahp = "";
    
    private class minNode<T>{
        int id;
        T data;
    }
    
    private class Node<T>{
        int n;
        minNode<T> key[] = new minNode[2 * T - 1];
        Node child[] = new Node[2 * T];
        boolean leaf = true;

        public int Find(int k) {
          for (int i = 0; i < this.n; i++) {
            if (this.key[i].id == k) {
              return i;
            }
          }
          return -1;
        };    
        
    }
    
    private Node<T> root;
    
    public TreeB(int t){
        T = 3;
        root = new Node<>();
        root.n = 0;
        root.leaf = true;
    }
    
    // Search key
  private Node Search(Node x, int key) {
    i = 0;
    if (x == null)
      return x;
    for (i = 0; i < x.n; i++) {
      if (key < x.key[i].id) {
        break;
      }
      if (key == x.key[i].id) {
        return  x;
      }
    }
    if (x.leaf) {
      return null;
    } else {
      return Search(x.child[i], key);
    }
  }
  
  public boolean mod(int key, T data){
      Node aux = Search(root,key);
      if (aux == null) {
          return false;
        }
      aux.key[i].data = data;
      return true;
  }
  
  public T get(int key){
        Node aux = Search(root,key);
        if (aux == null) {
          return null;
        }
        return (T) aux.key[i].data;
  }

  // Splitting the node
  private void Split(Node x, int pos, Node y) {
    Node z = new Node();
    z.leaf = y.leaf;
    z.n = T - 1;
    for (int j = 0; j < T - 1; j++) {
      z.key[j] = y.key[j + T];
    }
    if (!y.leaf) {
      for (int j = 0; j < T; j++) {
        z.child[j] = y.child[j + T];
      }
    }
    y.n = T - 1;
    for (int j = x.n; j >= pos + 1; j--) {
      x.child[j + 1] = x.child[j];
    }
    x.child[pos + 1] = z;

    for (int j = x.n - 1; j >= pos; j--) {
      x.key[j + 1] = x.key[j];
    }
    x.key[pos] = y.key[T - 1];
    x.n = x.n + 1;
  }

  // Inserting a value
  public void Insert(final int key, T data) {
    Node r = root;
    if (r.n == 2 * T - 1) {
      Node s = new Node();
      root = s;
      s.leaf = false;
      s.n = 0;
      s.child[0] = r;
      Split(s, 0, r);
      insertValue(s, key,data);
    } else {
      insertValue(r, key,data);
    }
  }

  // Insert the node
  final private void insertValue(Node x, int k,T data) {
    if (x.leaf) {
      int i = 0;
      for (i = x.n - 1; i >= 0 && k < x.key[i].id; i--) {
        x.key[i + 1] = x.key[i];
      }
      x.key[i+1] =  new minNode();
      x.key[i + 1].id = k;
      x.key[i + 1].data= data;
      x.n = x.n + 1;
    } else {
      int i = 0;
      for (i = x.n - 1; i >= 0 && k < x.key[i].id; i--) {
      }
      ;
      i++;
      Node tmp = x.child[i];
      if (tmp.n == 2 * T - 1) {
        Split(x, i, tmp);
        if (k > x.key[i].id) {
          i++;
        }
      }
      insertValue(x.child[i], k,data);
    }
  }

  public void Show() {
    Show(root);
  }

  // Mostar todo el arbol por consola
  private void Show(Node x) {
    assert (x == null);
    for (int i = 0; i < x.n; i++) {
      System.out.print(x.key[i].id + " ");
    }
    if (!x.leaf) {
      for (int i = 0; i < x.n + 1; i++) {
        Show(x.child[i]);
      }
    }
  }
  
  public void getCursoEstudiante(int carnet,DefaultTableModel dfm){
      AVL<String> listCursos = new AVL();
      getSubCursoEstudiante(root,carnet,dfm,listCursos);
  }
  
  private void getSubCursoEstudiante(Node x, int carnet,DefaultTableModel dfm, AVL<String> listCursos){
      assert (x == null);
    for (int i = 0; i < x.n; i++) {
      Horario horario = (Horario) x.key[i].data;
        if (horario.getAsignaciones().get(carnet, horario.getId()) != null) {
            Curso curso = (Curso) horario.getCurso().getData();
            String cur = listCursos.get(curso.getNombre());
            if (cur == null) {
                String[] data = {String.valueOf(carnet),curso.getNombre()};
                dfm.addRow(data);
                listCursos.add(curso.getNombre(), curso.getNombre());
            }
            
        }      
    }
    if (!x.leaf) {
      for (int i = 0; i < x.n + 1; i++) {
        getSubCursoEstudiante(x.child[i],carnet,dfm,listCursos);
      }
    }
  }
  
  public void getEstudianteCurso(int codigo,DefaultTableModel dfm){
      AVL<String> listEstudiantes = new AVL();
      getSubEstianteCurso(root,codigo,dfm,listEstudiantes);
  }
  
  private void getSubEstianteCurso(Node x, int codigo,DefaultTableModel dfm, AVL<String> listEst){
      assert (x == null);
    for (int i = 0; i < x.n; i++) {
      Horario horario = (Horario) x.key[i].data;
      Curso curso = (Curso) horario.getCurso().getData();
        if (curso.getCodigo() == codigo) {
            horario.getAsignaciones().getEstudianteCurso(codigo, dfm, listEst);
        }
    }
    if (!x.leaf) {
      for (int i = 0; i < x.n + 1; i++) {
        getSubEstianteCurso(x.child[i],codigo,dfm,listEst);
      }
    }
  }
  
  public void getCursoSalon(int codigoSalon,DefaultTableModel dfm){
      AVL<String> listCurso = new AVL();
      getSubCursoSalon(root,codigoSalon,dfm,listCurso);
      
  }
  private void getSubCursoSalon(Node x, int codigoSalon,DefaultTableModel dfm,AVL<String> listCurso){
      assert (x == null);
    for (int i = 0; i < x.n; i++) {
      Horario horario = (Horario) x.key[i].data;
      Salon salon = (Salon) horario.getSalon().getData();
        if (salon.getNumeroSalon() == codigoSalon) {
            Curso curso = (Curso) horario.getCurso().getData();
            String cur = listCurso.get(curso.getNombre());
            if (cur == null) {
                String[] data = {String.valueOf(codigoSalon),curso.getNombre()};
                dfm.addRow(data);
                listCurso.add(curso.getNombre(), curso.getNombre());
            }
        }
    }
    if (!x.leaf) {
      for (int i = 0; i < x.n + 1; i++) {
        getSubCursoSalon(x.child[i],codigoSalon,dfm,listCurso);
      }
    }
  }
  
  public void getNotaSemestre(int semestre,DefaultTableModel dfm){
      getSubNotaSemestre(root,semestre,dfm);
  }
  private void getSubNotaSemestre(Node x, int semestre, DefaultTableModel dfm){
      assert (x == null);
    for (int i = 0; i < x.n; i++) {
      Horario horario = (Horario) x.key[i].data;
      Curso curso = (Curso) horario.getCurso().getData();
        if (curso.getSemestre() == semestre) {
            horario.getAsignaciones().getNotaSemestre(curso.getNombre(), dfm);
        }
    }
    if (!x.leaf) {
      for (int i = 0; i < x.n + 1; i++) {
        getSubNotaSemestre(x.child[i],semestre,dfm);
      }
    }
  }

  // revisar si esta presente
  public boolean Contain(int k) {
    if (this.Search(root, k) != null) {
      return true;
    } else {
      return false;
    }
  }
  
  private void FindKeys(int a, int b, Node x, Stack<Integer> st) {
    int i = 0;
    for (i = 0; i < x.n && x.key[i].id < b; i++) {
      if (x.key[i].id > a) {
        st.push(x.key[i].id);
      }
    }
    if (!x.leaf) {
      for (int j = 0; j < i + 1; j++) {
        FindKeys(a, b, x.child[j], st);
      }
    }
 }
  
  public void Remove(int key) {
    Node x = Search(root, key);
    if (x == null) {
      return;
    }
    Remove(root, key);
  }

  public void Task(int a, int b) {
    Stack<Integer> st = new Stack<>();
    FindKeys(a, b, root, st);
    while (st.isEmpty() == false) {
      this.Remove(root, st.pop());
    }
  }
  
  private void Remove(Node x, int key) {
    int pos = x.Find(key);
    if (pos != -1) {
      if (x.leaf) {
        int i = 0;
        for (i = 0; i < x.n && x.key[i].id != key; i++) {
        }
        ;
        for (; i < x.n; i++) {
          if (i != 2 * T - 2) {
            x.key[i] = x.key[i + 1];
          }
        }
        x.n--;
        return;
      }
      if (!x.leaf) {

        Node pred = x.child[pos];
        int predKey = 0;
        if (pred.n >= T) {
          for (;;) {
            if (pred.leaf) {
              System.out.println(pred.n);
              predKey = pred.key[pred.n - 1].id;
              break;
            } else {
              pred = pred.child[pred.n];
            }
          }
          Remove(pred, predKey);
          x.key[pos].id = predKey;
          return;
        }

        Node nextNode = x.child[pos + 1];
        if (nextNode.n >= T) {
          int nextKey = nextNode.key[0].id;
          if (!nextNode.leaf) {
            nextNode = nextNode.child[0];
            for (;;) {
              if (nextNode.leaf) {
                nextKey = nextNode.key[nextNode.n - 1].id;
                break;
              } else {
                nextNode = nextNode.child[nextNode.n];
              }
            }
          }
          Remove(nextNode, nextKey);
          x.key[pos].id = nextKey;
          return;
        }

        int temp = pred.n + 1;
        pred.key[pred.n++] = x.key[pos];
        for (int i = 0, j = pred.n; i < nextNode.n; i++) {
          pred.key[j++] = nextNode.key[i];
          pred.n++;
        }
        for (int i = 0; i < nextNode.n + 1; i++) {
          pred.child[temp++] = nextNode.child[i];
        }

        x.child[pos] = pred;
        for (int i = pos; i < x.n; i++) {
          if (i != 2 * T - 2) {
            x.key[i] = x.key[i + 1];
          }
        }
        for (int i = pos + 1; i < x.n + 1; i++) {
          if (i != 2 * T - 1) {
            x.child[i] = x.child[i + 1];
          }
        }
        x.n--;
        if (x.n == 0) {
          if (x == root) {
            root = x.child[0];
          }
          x = x.child[0];
        }
        Remove(pred, key);
        return;
      }
    } else {
      for (pos = 0; pos < x.n; pos++) {
        if (x.key[pos].id > key) {
          break;
        }
      }
      Node tmp = x.child[pos];
      if (tmp.n >= T) {
        Remove(tmp, key);
        return;
      }
      if (true) {
        Node nb = null;
        int devider = -1;

        if (pos != x.n && x.child[pos + 1].n >= T) {
          devider = x.key[pos].id;
          nb = x.child[pos + 1];
          x.key[pos] = nb.key[0];
          tmp.key[tmp.n++].id = devider;
          tmp.child[tmp.n] = nb.child[0];
          for (int i = 1; i < nb.n; i++) {
            nb.key[i - 1] = nb.key[i];
          }
          for (int i = 1; i <= nb.n; i++) {
            nb.child[i - 1] = nb.child[i];
          }
          nb.n--;
          Remove(tmp, key);
          return;
        } else if (pos != 0 && x.child[pos - 1].n >= T) {

          devider = x.key[pos - 1].id;
          nb = x.child[pos - 1];
          x.key[pos - 1] = nb.key[nb.n - 1];
          Node child = nb.child[nb.n];
          nb.n--;

          for (int i = tmp.n; i > 0; i--) {
            tmp.key[i] = tmp.key[i - 1];
          }
          tmp.key[0].id = devider;
          for (int i = tmp.n + 1; i > 0; i--) {
            tmp.child[i] = tmp.child[i - 1];
          }
          tmp.child[0] = child;
          tmp.n++;
          Remove(tmp, key);
          return;
        } else {
          Node lt = null;
          Node rt = null;
          boolean last = false;
          if (pos != x.n) {
            devider = x.key[pos].id;
            lt = x.child[pos];
            rt = x.child[pos + 1];
          } else {
            devider = x.key[pos - 1].id;
            rt = x.child[pos];
            lt = x.child[pos - 1];
            last = true;
            pos--;
          }
          for (int i = pos; i < x.n - 1; i++) {
            x.key[i] = x.key[i + 1];
          }
          for (int i = pos + 1; i < x.n; i++) {
            x.child[i] = x.child[i + 1];
          }
          x.n--;
          lt.key[lt.n++].id = devider;

          for (int i = 0, j = lt.n; i < rt.n + 1; i++, j++) {
            if (i < rt.n) {
              lt.key[j] = rt.key[i];
            }
            lt.child[j] = rt.child[i];
          }
          lt.n += rt.n;
          if (x.n == 0) {
            if (x == root) {
              root = x.child[0];
            }
            x = x.child[0];
          }
          Remove(lt, key);
          return;
        }
      }
    }
  }
    public String getEstado(String nombre){
        String estado = "subgraph cluster_arbol_"+nombre+"{\nrankdir=TB;\n"
                + "node[shape = record, style=filled, fillcolor=white];\n";
        iteracion = 0;
        estado += getSubEstado(root,nombre);
        return estado + "}";
    }
    
    private String getSubEstado(Node x,String nombre){        
        String estado = "";
        assert (x == null);
        String actual = "struct_"+nombre+iteracion;
        estado += actual + "[ label =\"";
       for (int i = 0; i < x.n; i++) {
            if (i+1 == x.n) {
                estado += "<T"+i+"> " + x.key[i].data.toString();
            }else{
                estado += "<T"+i+"> " + x.key[i].data.toString()+ "|";
            }
          
       }
        estado += "\"];\n";
        if (!x.leaf) {
          for (int i = 0; i < x.n + 1; i++) {
            //Show(x.child[i]); 
            iteracion += 1;
            estado += actual +  "->" +  "struct_"+nombre+(iteracion) +";\n";
            estado += getSubEstado(x.child[i],nombre);
          }
        }     
        return estado;
    }
    
    public String getEstadoTodo(String nombre){
        flechas = "";
        subGrahp = "";
        String estado = "subgraph cluster_arbol_"+nombre+"{\nrankdir=TB;\n"
                + "node[shape = record, style=filled, fillcolor=white];\n";
        iteracion = 0;
        estado += getSubEstadoTodo(root,nombre);
        estado += "}\n";
        estado += subGrahp;
        return estado;
    }
    private String getSubEstadoTodo(Node x,String nombre){        
        String estado = "";
        assert (x == null);
        String actual = "struct_"+nombre+iteracion;
        estado += actual + "[ label =\"";
        for (int i = 0; i < x.n; i++) {
        if (x.key[i].data.getClass().getSimpleName().equalsIgnoreCase("Horario")) {
            if (i+1 == x.n) {
                estado += "<T"+i+"> " + x.key[i].data.toString();
            }else{
                estado += "<T"+i+"> " + x.key[i].data.toString()+ "|";
            }
            Horario horario = (Horario)  x.key[i].data;            
            if (horario.getSalon().getData() != null) {
                Salon salon = (Salon) horario.getSalon().getData();
                if (horario.getEdificio().getData() != null) {
                    Edificio edi = (Edificio) horario.getEdificio().getData();
                    String edificio =  edi.getNombre();
                    flechas +=  actual+":T"+i +" -> salon_edificio_"+edificio + salon.getNumeroSalon()+"[color=green];\n";
                }                
            }
            if (horario.getCatedratico() != null) {
                 flechas +=  actual+":T"+i +" -> catedratico"+ horario.getCatedratico().getId()+"[color=blue];\n";
            }
            if (horario.getCurso().getData() != null) {
                Curso curso = (Curso) horario.getCurso().getData();
                flechas +=  actual+":T"+i +" -> curso_"+ curso.getCodigo()+"[color=brown4];\n";
            }
            if (horario.getAsignaciones() !=  null) {                    
                subGrahp += horario.getAsignaciones().getEstado("Asignaciones", actual,i);
                flechas += horario.getAsignaciones().getFlecha();
            } 
            
        }          
          
        }
        estado += "\"];\n";        
        if (!x.leaf) {
          for (int i = 0; i < x.n + 1; i++) {
            //Show(x.child[i]); 
            iteracion += 1;
            estado += actual +  "->" +  "struct_"+nombre+(iteracion) +";\n";
            estado += getSubEstadoTodo(x.child[i],nombre);
          }
        }     
        //estado +=  flechas;
        return estado;
    }
    public String getFlechas(){
        return flechas;
    }
}
