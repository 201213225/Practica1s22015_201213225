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

    public void Incertar_Lista() {
        if (Raiz == null) {
            Raiz = new Nodo_Lista(indice);
            indice++;
        } else {
            Nodo_Lista aux = Raiz;
            while (aux.sig != null) {
                aux = aux.sig;
            }
            aux.sig = new Nodo_Lista(indice);
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