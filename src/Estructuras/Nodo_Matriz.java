/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Estructuras;

import javax.swing.JLabel;

/**
 *
 * @author Denis
 */
public class Nodo_Matriz extends JLabel {
    public Nodo_Matriz arriba, abajo,izquierda, derecha;
    public Nodo_Lista Objeto,Item,Principal;
    public int X,Y;

    public Nodo_Matriz(int X, int Y) {
        this.X = X;
        this.Y = Y;
        //System.out.println("X:" + X + " Y:" + Y);
        this.setVisible(false);
    }
}
