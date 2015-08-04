/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package practica1s22015_201213225;

import Estructuras.Lista;
import Interfaz.*;

/**
 *
 * @author Denis
 */
public class Practica1s22015_201213225 {

    /**
     * @param args the command line arguments
     */
    public static Lista carga;
    public static void main(String[] args) {
        // TODO code application logic here
        //Matriz a = new Matriz();
        //Lista b = new Lista();
        //Interfaz_Carga c = new Interfaz_Carga();
        //c.setVisible(true);
        Interfaz_Objetos d;
        Lista e = new Lista();
        e.Incertar_Lista("Goomba", "Goomba", "C:\\Users\\Denis\\Pictures\\Plushtrap.png");
        e.Incertar_Lista("Koopa", "Koopa", "C:\\Users\\Denis\\Pictures\\11722263_729165757195353_3790519502923449454_o.png");
        e.Incertar_Lista("Heroe", "Mario", "C:\\Users\\Denis\\Pictures\\183308.jpg");
        e.Incertar_Lista("Castillo", "MinasTirith", "C:\\Users\\Denis\\Pictures\\wows-1b.jpg");
        e.Incertar_Lista("Goomba", "Goomba", "C:\\Users\\Denis\\Pictures\\3.jpg");
        e.Incertar_Lista("Koopa", "Koopa", "C:\\Users\\Denis\\Pictures\\11722263_729165757195353_3790519502923449454_o.png");
        e.Incertar_Lista("Heroe", "Mario", "C:\\Users\\Denis\\Pictures\\3.jpg");
        e.Incertar_Lista("Castillo", "MinasTirith", "C:\\Users\\Denis\\Pictures\\wows-1b.jpg");
        d = new Interfaz_Objetos(e);
        d.repaint();
        d.setVisible(true);
    }

}
