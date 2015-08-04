/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Estructuras;

import javax.swing.ImageIcon;

/**
 *
 * @author Denis
 */
public class Nodo_Lista {
    public Nodo_Lista sig;
    public Nodo_Lista ant;
    public int indice;
    public String nombre, tipo, ruta;
    Nodo_Lista(int indice, String nombre, String tipo, String ruta) {
        this.indice = indice;
        this.nombre = nombre;
        this.tipo = tipo;
        this.ruta = ruta;
    }
}
