/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Graphviz;

import Estructuras.*;
import java.io.File;
import java.io.FileWriter;
import java.io.PrintWriter;
import java.io.Writer;

/**
 *
 * @author Denis
 */
public class Graphviz {

    public String cadena;
    int indice = 0;

    public Graphviz(Object Estructura) {
        if (Estructura != null) {
            if (Estructura.getClass() == Lista.class) {
                Graphviz_Lista((Lista) Estructura);
            } else if (Estructura.getClass() == Matriz.class) {
                Graphviz_Matriz((Matriz) Estructura);
            }
        }
    }

    public Graphviz(Object Estructura, int Matriz) {
        if (Matriz == 0 && Estructura != null) {
            Graphviz_Partida((Matriz) Estructura);
        }else if (Matriz == 1 && Estructura != null) {
            Graphviz_Partida2((Matriz) Estructura);
        }else if (Matriz == 2 && Estructura != null) {
            Graphviz_Matriz2((Matriz) Estructura);
        }
    }

    private void Graphviz_Lista(Lista lista) {
        Nodo_Lista aux = lista.Raiz;
        String Cabeza = "";
        String uniones = "";
        String AuxUnion = "";
        while (aux != null) {
            Cabeza = Cabeza + "struct" + indice + " [label=\"<f0> |<f1>Nombre:" + aux.nombre + "\\nTipo:" + aux.tipo + "|<f2>\"];\n";
            if (uniones.length() == 0 && AuxUnion.length() == 0) {
                AuxUnion = "struct" + indice + ":f2 ->";
            } else {
                uniones = uniones + AuxUnion + "struct" + indice + ":f0[constraint=false];\n";
                uniones = uniones + "struct" + indice + ":f0->struct" + (indice - 1) + ":f2[constraint=false];\n";
                AuxUnion = "struct" + indice + ":f2 ->";
            }
            indice++;
            aux = aux.sig;
        }
        cadena = "digraph structs {\n" + "node [shape=record];\n" + Cabeza + uniones + "}";
        EscribirFichero("Lista.dot", cadena);
        dibujar("Lista.dot", "Lista.png");
        //System.out.print(cadena);
    }

    private void Graphviz_Matriz(Matriz matriz) {
        Nodo_Matriz Aux1 = matriz.Raiz;
        String Cabeza = "";
        String uniones = "";
        String AuxUnion = "";
        while (Aux1 != null) {
            Nodo_Matriz Aux2 = Aux1;
            while (Aux2 != null) {
                Cabeza = Cabeza + "struct" + Aux2.X + "P" + Aux2.Y + " [label=\"<f0> |";
                if (Aux2.Objeto != null) {
                    Cabeza = Cabeza + "{<f1>|<f2>Nombre:" + Aux2.Objeto.nombre + "\\nTipo:" + Aux2.Objeto.tipo + "|<f3>}|<f4>\"];\n";
                } else {
                    Cabeza = Cabeza + "{<f1>|<f2>Vacio|<f3>}|<f4>\"];\n";
                }
                if (uniones.length() == 0 && AuxUnion.length() == 0) {
                    AuxUnion = "struct" + Aux2.X + "P" + Aux2.Y + ":f4 ->";
                } else {
                    if (Aux2.arriba != null) {
                        uniones = uniones + "struct" + Aux2.X + "P" + Aux2.Y + ":f1->struct" + Aux2.X + "P" + (Aux2.Y - 1) + ":f3;\n";
                        uniones = uniones + "struct" + Aux2.X + "P" + (Aux2.Y - 1) + ":f3->struct" + Aux2.X + "P" + Aux2.Y + ":f1;\n";
                    }
                    if (Aux2.X == 0) {
                        AuxUnion = "struct" + Aux2.X + "P" + Aux2.Y + ":f4 ->";
                    } else {
                        uniones = uniones + AuxUnion + "struct" + Aux2.X + "P" + Aux2.Y + ":f0 [constraint=false];\n";
                        uniones = uniones + "struct" + Aux2.X + "P" + Aux2.Y + ":f0->struct" + (Aux2.X - 1) + "P" + Aux2.Y + ":f4 [constraint=false];\n";
                        AuxUnion = "struct" + Aux2.X + "P" + Aux2.Y + ":f4 ->";
                    }

                }
                Aux2 = Aux2.derecha;
            }
            /*
             if (Aux1.arriba != null) {
             Nodo_Matriz Aux3 = Aux1;
             while(Aux3 != null){
             //uniones = uniones+;
                    
             Aux3=Aux3.derecha;
             }
             }//*/
            Aux1 = Aux1.abajo;
        }
        cadena = "digraph structs {\n" + "node [shape=record];\n" + Cabeza + uniones + "}";
        EscribirFichero("Matriz.dot", cadena);
        //Sleep(1000);
        dibujar("Matriz.dot", "Matriz.png");
    }

    private void Graphviz_Matriz2(Matriz matriz) {
        Nodo_Matriz Aux1 = matriz.Raiz;
        String Cabeza = "";
        String uniones = "";
        String AuxUnion = "";
        while (Aux1 != null) {
            Nodo_Matriz Aux2 = Aux1;
            while (Aux2 != null) {
                Cabeza = Cabeza + "struct" + Aux2.X + "P" + Aux2.Y + " [label=\"<f0> |";
                if (Aux2.Objeto != null) {
                    Cabeza = Cabeza + "{<f1>|<f2>Nombre:" + Aux2.Objeto.nombre + "\\nTipo:" + Aux2.Objeto.tipo + "|<f3>}|<f4>\"];\n";
                } else {
                    Cabeza = Cabeza + "{<f1>|<f2>Vacio|<f3>}|<f4>\"];\n";
                }
                if (uniones.length() == 0 && AuxUnion.length() == 0) {
                    AuxUnion = "struct" + Aux2.X + "P" + Aux2.Y + ":f4 ->";
                } else {
                    if (Aux2.arriba != null) {
                        uniones = uniones + "struct" + Aux2.X + "P" + Aux2.Y + ":f1->struct" + Aux2.X + "P" + (Aux2.Y - 1) + ":f3;\n";
                        uniones = uniones + "struct" + Aux2.X + "P" + (Aux2.Y - 1) + ":f3->struct" + Aux2.X + "P" + Aux2.Y + ":f1;\n";
                    }
                    if (Aux2.X == 0) {
                        AuxUnion = "struct" + Aux2.X + "P" + Aux2.Y + ":f4 ->";
                    } else {
                        uniones = uniones + AuxUnion + "struct" + Aux2.X + "P" + Aux2.Y + ":f0;\n";
                        uniones = uniones + "struct" + Aux2.X + "P" + Aux2.Y + ":f0->struct" + (Aux2.X - 1) + "P" + Aux2.Y + ":f4;\n";
                        AuxUnion = "struct" + Aux2.X + "P" + Aux2.Y + ":f4 ->";
                    }

                }
                Aux2 = Aux2.derecha;
            }
            /*
             if (Aux1.arriba != null) {
             Nodo_Matriz Aux3 = Aux1;
             while(Aux3 != null){
             //uniones = uniones+;
                    
             Aux3=Aux3.derecha;
             }
             }//*/
            Aux1 = Aux1.abajo;
        }
        cadena = "digraph structs {\n" + "node [shape=record];\n" + Cabeza + uniones + "}";
        EscribirFichero("Matriz2.dot", cadena);
        //Sleep(1000);
        dibujar("Matriz2.dot", "Matriz2.png");
    }

    private void Graphviz_Partida(Matriz matriz) {
        Nodo_Matriz Aux1 = matriz.Raiz;
        String Cabeza = "";
        String uniones = "";
        String AuxUnion = "";
        while (Aux1 != null) {
            Nodo_Matriz Aux2 = Aux1;
            while (Aux2 != null) {
                Cabeza = Cabeza + "struct" + Aux2.X + "P" + Aux2.Y + " [label=\"<f0> |{<f1>|<f2>";
                if (Aux2.Objeto != null || Aux2.Item != null || Aux2.Principal != null) {
                    if (Aux2.Objeto != null) {
                        Cabeza = Cabeza + "Nombre:" + Aux2.Objeto.nombre + "\\nTipo:" + Aux2.Objeto.tipo + "\\n";
                    }
                    if (Aux2.Item != null) {
                        Cabeza = Cabeza + "Nombre:" + Aux2.Item.nombre + "\\nTipo:" + Aux2.Item.tipo + "\\n";
                    }
                    if (Aux2.Principal != null) {
                        Cabeza = Cabeza + "Nombre:" + Aux2.Principal.nombre + "\\nTipo:" + Aux2.Principal.tipo + "\\n";
                    }

                } else {
                    Cabeza = Cabeza + "Vacio";
                }
                Cabeza = Cabeza + "|<f3>}|<f4>\"];\n";
                if (uniones.length() == 0 && AuxUnion.length() == 0) {
                    AuxUnion = "struct" + Aux2.X + "P" + Aux2.Y + ":f4 ->";
                } else {
                    if (Aux2.arriba != null) {
                        uniones = uniones + "struct" + Aux2.X + "P" + Aux2.Y + ":f1->struct" + Aux2.X + "P" + (Aux2.Y - 1) + ":f3;\n";
                        uniones = uniones + "struct" + Aux2.X + "P" + (Aux2.Y - 1) + ":f3->struct" + Aux2.X + "P" + Aux2.Y + ":f1;\n";
                    }
                    if (Aux2.X == 0) {
                        AuxUnion = "struct" + Aux2.X + "P" + Aux2.Y + ":f4 ->";
                    } else {
                        uniones = uniones + AuxUnion + "struct" + Aux2.X + "P" + Aux2.Y + ":f0 [constraint=false];\n";
                        uniones = uniones + "struct" + Aux2.X + "P" + Aux2.Y + ":f0->struct" + (Aux2.X - 1) + "P" + Aux2.Y + ":f4 [constraint=false];\n";
                        AuxUnion = "struct" + Aux2.X + "P" + Aux2.Y + ":f4 ->";
                    }

                }
                Aux2 = Aux2.derecha;
            }
            /*
             if (Aux1.arriba != null) {
             Nodo_Matriz Aux3 = Aux1;
             while(Aux3 != null){
             //uniones = uniones+;
                    
             Aux3=Aux3.derecha;
             }
             }//*/
            Aux1 = Aux1.abajo;
        }
        cadena = "digraph structs {\n" + "node [shape=record];\n" + Cabeza + uniones + "}";
        EscribirFichero("Partida.dot", cadena);
        dibujar("Partida.dot", "Partida.png");
    }

    private void Graphviz_Partida2(Matriz matriz) {
        Nodo_Matriz Aux1 = matriz.Raiz;
        String Cabeza = "";
        String uniones = "";
        String AuxUnion = "";
        while (Aux1 != null) {
            Nodo_Matriz Aux2 = Aux1;
            while (Aux2 != null) {
                Cabeza = Cabeza + "struct" + Aux2.X + "P" + Aux2.Y + " [label=\"<f0> |{<f1>|<f2>";
                if (Aux2.Objeto != null || Aux2.Item != null || Aux2.Principal != null) {
                    if (Aux2.Objeto != null) {
                        Cabeza = Cabeza + "Nombre:" + Aux2.Objeto.nombre + "\\nTipo:" + Aux2.Objeto.tipo + "\\n";
                    }
                    if (Aux2.Item != null) {
                        Cabeza = Cabeza + "Nombre:" + Aux2.Item.nombre + "\\nTipo:" + Aux2.Item.tipo + "\\n";
                    }
                    if (Aux2.Principal != null) {
                        Cabeza = Cabeza + "Nombre:" + Aux2.Principal.nombre + "\\nTipo:" + Aux2.Principal.tipo + "\\n";
                    }

                } else {
                    Cabeza = Cabeza + "Vacio";
                }
                Cabeza = Cabeza + "|<f3>}|<f4>\"];\n";
                if (uniones.length() == 0 && AuxUnion.length() == 0) {
                    AuxUnion = "struct" + Aux2.X + "P" + Aux2.Y + ":f4 ->";
                } else {
                    if (Aux2.arriba != null) {
                        uniones = uniones + "struct" + Aux2.X + "P" + Aux2.Y + ":f1->struct" + Aux2.X + "P" + (Aux2.Y - 1) + ":f3;\n";
                        uniones = uniones + "struct" + Aux2.X + "P" + (Aux2.Y - 1) + ":f3->struct" + Aux2.X + "P" + Aux2.Y + ":f1;\n";
                    }
                    if (Aux2.X == 0) {
                        AuxUnion = "struct" + Aux2.X + "P" + Aux2.Y + ":f4 ->";
                    } else {
                        uniones = uniones + AuxUnion + "struct" + Aux2.X + "P" + Aux2.Y + ":f0;\n";
                        uniones = uniones + "struct" + Aux2.X + "P" + Aux2.Y + ":f0->struct" + (Aux2.X - 1) + "P" + Aux2.Y + ":f4;\n";
                        AuxUnion = "struct" + Aux2.X + "P" + Aux2.Y + ":f4 ->";
                    }

                }
                Aux2 = Aux2.derecha;
            }
            /*
             if (Aux1.arriba != null) {
             Nodo_Matriz Aux3 = Aux1;
             while(Aux3 != null){
             //uniones = uniones+;
                    
             Aux3=Aux3.derecha;
             }
             }//*/
            Aux1 = Aux1.abajo;
        }
        cadena = "digraph structs {\n" + "node [shape=record];\n" + Cabeza + uniones + "}";
        EscribirFichero("Partida2.dot", cadena);
        dibujar("Partida2.dot", "Partida2.png");
    }

    public void dibujar(String direccionDot, String direccionPng) {
        try {
            ProcessBuilder pbuilder;

            /*
             * Realiza la construccion del comando    
             * en la linea de comandos esto es: 
             * dot -Tpng -o archivo.png archivo.dot
             */
            File fichero = new File(direccionDot);
            while (!fichero.exists()) {
            }

            System.out.println(direccionDot);
            pbuilder = new ProcessBuilder("dot", "-Tpng", "-o", direccionPng, direccionDot);
            pbuilder.redirectErrorStream(true);
            //Ejecuta el proceso
            pbuilder.start();

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private void EscribirFichero(String ArchDot, String cadena) {
        Writer fichero = null;
        PrintWriter pw = null;
        try {
            fichero = new FileWriter(ArchDot);
            pw = new PrintWriter(fichero);
            pw.write(cadena);
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            try {
                // Nuevamente aprovechamos el finally para 
                // asegurarnos que se cierra el fichero.
                if (null != fichero) {
                    fichero.close();
                }
            } catch (Exception e2) {
                e2.printStackTrace();
            }
        }
    }
}
