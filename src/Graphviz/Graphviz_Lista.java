/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Graphviz;

import Estructuras.*;

/**
 *
 * @author Denis
 */
public class Graphviz_Lista {

    public String cadena;
    int indice = 0;

    public Graphviz_Lista(Lista lista) {
        Nodo_Lista aux = lista.Raiz;
        String Cabeza = "";
        String uniones = "";
        String AuxUnion = "";
        while (aux != null) {
            Cabeza = Cabeza + "struct" + indice + " [label=\"<f0> |<f1>Nombre:" + aux.nombre + "\\nTipo:" + aux.tipo + "|<f2>\"];\n";
            if(uniones.length()==0 && AuxUnion.length()==0){
                AuxUnion = "struct"+indice+":f2 ->";
            }else{
                uniones = uniones + AuxUnion+ "struct"+indice+":f0;\n";
                uniones = uniones+ "struct"+indice+":f0->struct"+(indice-1)+":f2\n";
                AuxUnion = "struct"+indice+":f2 ->";
            }
            indice++;
            aux = aux.sig;
        }
        cadena = "digraph structs {\n" + "node [shape=record];\n"+Cabeza+uniones+"}";
        System.out.print(cadena);
    }
}
