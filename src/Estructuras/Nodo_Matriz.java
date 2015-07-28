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
public class Nodo_Matriz {
    Nodo_Matriz arriba, abajo,izquierda, derecha;
    int X,Y;

    Nodo_Matriz(int X, int Y) {
        this.X = X;
        this.Y = Y;
        System.out.println("X:" + X + " Y:" + Y);
    }
}
