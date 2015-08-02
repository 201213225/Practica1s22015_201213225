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
public class Lista {

    Nodo_Lista Raiz;
    int indice = 0;

    public void Incertar_Lista(String Nombre, String Tipo, String Ruta) {
        Nodo_Lista Nuevo = new Nodo_Lista(indice,Nombre, Tipo, Ruta);
        if (Raiz == null) {
            Raiz = Nuevo;
            indice++;
        } else {
            Nodo_Lista aux = Raiz;
            while (aux.sig != null) {
                aux = aux.sig;
            }
            aux.sig = Nuevo;
            indice++;
            aux.sig.ant = aux;
        }
    }

    public Nodo_Lista Extraer_FIFO() {
        Nodo_Lista aux = null;
        if (Raiz != null) {
            aux = Raiz;
            if (Raiz.sig != null) {
                Raiz = Raiz.sig;
                Raiz.ant = null;
            } else {
                Raiz = null;
            }
        }
        return aux;
    }

    public Nodo_Lista Extraer_LIFO() {
        Nodo_Lista aux = null;
        if (Raiz != null) {
            aux = Raiz;
            if (Raiz.sig != null) {
                while (aux.sig != null) {
                    aux = aux.sig;
                }
                aux.ant.sig = null;
            } else {
                Raiz = null;
            }
        }
        return aux;
    }
}
