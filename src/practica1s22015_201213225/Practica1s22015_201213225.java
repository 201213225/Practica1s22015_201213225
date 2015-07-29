/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package practica1s22015_201213225;

import Estructuras.Lista;
import Estructuras.Matriz;

/**
 *
 * @author Denis
 */
public class Practica1s22015_201213225 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        Matriz a = new Matriz();
        Lista b = new Lista();
        b.Incertar_Lista();
        b.Incertar_Lista();
        b.Incertar_Lista();
        b.Incertar_Lista();
        b.Incertar_Lista();
        b.Incertar_Lista();
        System.out.println(b.Extraer_FIFO().indice);
        System.out.println(b.Extraer_FIFO().indice);
        System.out.println(b.Extraer_FIFO().indice);
        System.out.println(b.Extraer_LIFO().indice);
        System.out.println(b.Extraer_LIFO().indice);
        System.out.println(b.Extraer_LIFO().indice);
    }
    
}
