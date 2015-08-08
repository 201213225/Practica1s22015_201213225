/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Graphviz;

import Estructuras.*;
import java.io.FileWriter;
import java.io.PrintWriter;

/**
 *
 * @author Denis
 */
public class Graphviz {

    public String cadena;
    int indice = 0;

    public Graphviz(Object Estructura) {
        if(Estructura.getClass()==Lista.class){
            Graphviz_Lista((Lista) Estructura);
        }else if(Estructura.getClass()==Matriz.class){
            Graphviz_Matriz();
        }
    }
    private void Graphviz_Lista(Lista lista){
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
        EsccribirFichero("Lista.dot",cadena);
        dibujar("Lista.dot","Lista.png");
        //System.out.print(cadena);
    }

    private void Graphviz_Matriz() {
        
    }
    
    public void dibujar( String direccionDot, String direccionPng ){
		try
		{       
			ProcessBuilder pbuilder;
		    
			/*
			 * Realiza la construccion del comando    
			 * en la linea de comandos esto es: 
			 * dot -Tpng -o archivo.png archivo.dot
			 */
			pbuilder = new ProcessBuilder( "dot", "-Tpng", "-o", direccionPng, direccionDot );
			pbuilder.redirectErrorStream( true );
			//Ejecuta el proceso
			pbuilder.start();
		    
		} catch (Exception e) { e.printStackTrace(); }
	}

    private void EsccribirFichero(String ArchDot, String cadena) {
        FileWriter fichero = null;
        PrintWriter pw = null;
        try
        {
            fichero = new FileWriter(ArchDot);
            pw = new PrintWriter(fichero);
 
            for (int i = 0; i < 10; i++)
                pw.print(cadena);
 
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
           try {
           // Nuevamente aprovechamos el finally para 
           // asegurarnos que se cierra el fichero.
           if (null != fichero)
              fichero.close();
           } catch (Exception e2) {
              e2.printStackTrace();
           }
        }
    }
}
