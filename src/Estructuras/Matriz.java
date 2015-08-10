/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Estructuras;

import java.awt.Rectangle;

/**
 *
 * @author Denis
 */
public class Matriz {

    public Nodo_Matriz Raiz;

    public void Incertar_Fila() {
        if (Raiz == null) {
            Raiz = new Nodo_Matriz(0, 0);
        } else {
            Nodo_Matriz aux1 = Raiz;
            while (aux1.abajo != null) {
                aux1 = aux1.abajo;
            }
            aux1.abajo = new Nodo_Matriz(aux1.X, aux1.Y + 1);
            aux1.abajo.arriba = aux1;
            Llenar_Fila(aux1, aux1.abajo);
        }
    }

    void Llenar_Fila(Nodo_Matriz primero, Nodo_Matriz segundo) {
        if (primero.derecha != null) {
            segundo.derecha = new Nodo_Matriz(segundo.X + 1, segundo.Y);
            segundo.derecha.izquierda = segundo;
            primero.derecha.abajo = segundo.derecha;
            segundo.derecha.arriba = primero.derecha;
            Llenar_Fila(primero.derecha, segundo.derecha);
        }
    }

    public void Incerdar_Columna() {
        if (Raiz == null) {
            Raiz = new Nodo_Matriz(0, 0);
        } else {
            Nodo_Matriz aux1 = Raiz;
            while (aux1.derecha != null) {
                aux1 = aux1.derecha;
            }
            aux1.derecha = new Nodo_Matriz(aux1.X + 1, aux1.Y);
            aux1.derecha.izquierda = aux1;
            Llenar_Columna(aux1, aux1.derecha);
        }
    }

    void Llenar_Columna(Nodo_Matriz primero, Nodo_Matriz segundo) {
        if (primero.abajo != null) {
            segundo.abajo = new Nodo_Matriz(segundo.X, segundo.Y + 1);
            segundo.abajo.arriba = segundo;
            primero.abajo.derecha = segundo.abajo;
            segundo.abajo.izquierda = primero.abajo;
            Llenar_Columna(primero.abajo, segundo.abajo);
        }
    }

    public void eliminarFila(int Indice) {
        Nodo_Matriz Aux = Raiz;
        while (Aux != null && Aux.Y != Indice) {
            Aux = Aux.abajo;
        }
        if (Aux != null) {
            if (Aux.arriba != null && Aux.abajo != null) {
                while(Aux!=null){
                    Aux.abajo.arriba = Aux.arriba;
                    Aux.arriba.abajo = Aux.abajo;
                    Aux.setVisible(false);
                    Aux=Aux.derecha;
                }
            } else {
                if (Aux.arriba == null) {
                    Raiz = Aux.abajo;
                    while (Aux != null) {
                        Aux.abajo.arriba = null;
                        Aux.setVisible(false);
                        Aux = Aux.derecha;
                    }
                }else {
                    while (Aux != null) {
                        Aux.arriba.abajo = null;
                        Aux.setVisible(false);
                        Aux = Aux.derecha;
                    }
                }
            }
        }
    }

    public void eliminarColumna(int Indice) {
        Nodo_Matriz Aux = Raiz;
        while (Aux != null && Aux.X != Indice) {
            Aux = Aux.derecha;
        }
        if (Aux != null) {
            if (Aux.derecha != null && Aux.izquierda != null) {
                while(Aux!=null){
                    Aux.derecha.izquierda=Aux.izquierda;
                    Aux.izquierda.derecha=Aux.derecha;
                    Aux.setVisible(false);
                    Aux=Aux.abajo;
                }
            } else {
                if (Aux.izquierda == null) {
                    Raiz = Aux.derecha;
                    while (Aux != null) {
                        Aux.derecha.izquierda = null;
                        Aux.setVisible(false);
                        Aux = Aux.abajo;
                    }
                }else {
                    while (Aux != null) {
                        Aux.izquierda.derecha = null;
                        Aux.setVisible(false);
                        Aux = Aux.abajo;
                    }
                }
            }
        }
    }
}
