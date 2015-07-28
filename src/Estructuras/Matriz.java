/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Estructuras;

/**
 *
 * @author Denis
 */
public class Matriz {

    Nodo_Matriz Raiz;

    public void Incertar_Fila() {
        if (Raiz == null) {
            Raiz = new Nodo_Matriz();
        } else {
            Nodo_Matriz aux1 = Raiz;
            Nodo_Matriz aux2;
            if (Raiz.abajo!=null) {
                Raiz.abajo = new Nodo_Matriz();
                Llenar_Fila(aux1, Raiz.abajo);
            }
        }
    }

    void Llenar_Fila(Nodo_Matriz primero, Nodo_Matriz segundo) {
        if (primero.derecha!=null) {
            segundo.derecha = new Nodo_Matriz();
            primero.derecha.abajo = segundo.derecha;
            segundo.derecha.arriba = primero.derecha;
            Llenar_Fila(primero.derecha, segundo.derecha);
        }
    }

    void Incerdar_Columna() {
    }
}
