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
public class Nodo_Lista implements Runnable {

    public Nodo_Lista sig;
    public Nodo_Lista ant;
    public int indice;
    public String nombre, tipo, ruta;
    public Nodo_Matriz casilla = null;
    public boolean MovIzq = true;
    public boolean running = false;
    public boolean salto = false;
    public boolean PierdeVida = false, GanaVida = false, Finaliza = false, GanaPuntos = false;

    public Nodo_Lista(int indice, String nombre, String tipo, String ruta) {
        this.indice = indice;
        this.nombre = nombre;
        this.tipo = tipo;
        this.ruta = ruta;
    }

    @Override
    public void run() {
        while (running) {
            //System.out.println(practica1s22015_201213225.Practica1s22015_201213225.Corre);
            boolean aux = practica1s22015_201213225.Practica1s22015_201213225.Corre;
            if (aux) {
                boolean caida = VerificarCaida();
                if (!tipo.equals("Principal") && !caida) {
                    if (MovIzq && VerificarIzq()) {
                        MoverIzquierda();
                    } else if (VerificarDer()) {
                        MoverDerecha();
                    }
                }
                //System.out.println("Corre");
                if (caida && !salto) {
                    MoverAbajo();
                }
            }
            if (tipo.equals("Principal")) {
                verificar();
            }

        }
    }

    private void MoverAbajo() {
        try {
            Thread.sleep(200);
        } catch (InterruptedException ex) {
        }
        //System.out.println("Abajo");
        if (casilla.Objeto != null) {
            casilla.Objeto = null;
            casilla = casilla.abajo;
            casilla.Objeto = this;
        } else if (casilla.Principal != null) {
            casilla.Principal = null;
            casilla = casilla.abajo;
            casilla.Principal = this;
        }
        SetIcon(casilla.arriba);
        SetIcon(casilla);

    }

    private void MoverIzquierda() {
        try {
            Thread.sleep(500);
        } catch (InterruptedException ex) {
        }
        //System.out.println("Abajo");
        casilla.Objeto = null;
        casilla = casilla.izquierda;
        casilla.Objeto = this;
        SetIcon(casilla.derecha);
        SetIcon(casilla);
        if (!VerificarIzq()) {
            MovIzq = false;
        }
    }

    private void MoverDerecha() {
        try {
            Thread.sleep(500);
        } catch (InterruptedException ex) {
        }
        //System.out.println("Abajo");
        casilla.Objeto = null;
        casilla = casilla.derecha;
        casilla.Objeto = this;
        SetIcon(casilla.izquierda);
        SetIcon(casilla);
        if (!VerificarDer()) {
            MovIzq = true;
        }
    }

    public void MoverIzquierdaP() {
        try {
            Thread.sleep(500);
        } catch (InterruptedException ex) {
        }
        //System.out.println("Abajo");
        casilla.Principal = null;
        casilla = casilla.izquierda;
        casilla.Principal = this;
        SetIcon(casilla.derecha);
        SetIcon(casilla);
        if (!VerificarIzq()) {
            MovIzq = false;
        }
    }

    public void MoverDerechaP() {
        try {
            Thread.sleep(500);
        } catch (InterruptedException ex) {
        }
        //System.out.println("Abajo");
        casilla.Principal = null;
        casilla = casilla.derecha;
        casilla.Principal = this;
        SetIcon(casilla.izquierda);
        SetIcon(casilla);
        if (!VerificarDer()) {
            MovIzq = true;
        }
    }

    public boolean VerificarCaida() {
        if (casilla.abajo != null) {
            if (casilla.abajo.Objeto != null) {
                Nodo_Lista Aux1 = casilla.abajo.Objeto;
                if (!(Aux1.tipo.equals("Suelo") || Aux1.tipo.equals("Pared"))) {
                    if (tipo.equals("Goomba") || tipo.equals("Koopa")) {
                        if (Aux1.tipo.equals("Koopa")) {
                            return false;
                        } else if (Aux1.tipo.equals("Goomba")) {
                            Aux1.running = false;
                            Aux1.casilla.Objeto = null;
                            SetIcon(Aux1.casilla);
                            Aux1.casilla = null;
                        }

                    }
                    return true;
                }
            } else {
                return true;
            }
        }
        return false;
    }

    private boolean VerificarIzq() {
        if (casilla.izquierda != null) {
            if (casilla.izquierda.Objeto != null) {
                //Nodo_Lista Aux1 = casilla.izquierda.Objeto;
                return false;
            } else {
                return true;
            }
        }
        return false;
    }

    private boolean VerificarDer() {
        if (casilla.derecha != null) {
            if (casilla.derecha.Objeto != null) {
                //Nodo_Lista Aux1 = casilla.derecha.Objeto;
                return false;
            } else {
                return true;
            }
        }
        return false;
    }

    public boolean VerificarIzqP() {
        if (casilla.izquierda != null) {
            if (casilla.izquierda.Objeto != null) {
                if (!casilla.izquierda.Objeto.tipo.equals("Goomba") && !casilla.izquierda.Objeto.tipo.equals("Koopa")) {
                    return false;
                }
                return true;
            } else {
                return true;
            }
        }
        return false;
    }

    public boolean VerificarDerP() {
        if (casilla.derecha != null) {
            if (casilla.derecha.Objeto != null) {
                if (!casilla.derecha.Objeto.tipo.equals("Goomba") && !casilla.izquierda.Objeto.tipo.equals("Koopa")) {
                    return false;
                }
                return true;
            } else {
                return true;
            }
        }
        return false;
    }

    private void SetIcon(Nodo_Matriz casilla) {
        if (casilla.Principal != null) {
            casilla.setIcon(new ImageIcon(casilla.Principal.ruta));
        } else if (casilla.Objeto != null) {
            casilla.setIcon(new ImageIcon(casilla.Objeto.ruta));
        } else if (casilla.Item != null) {
            casilla.setIcon(new ImageIcon(casilla.Item.ruta));
        } else {
            casilla.setIcon(null);
        }
    }

    private void verificar() {
        if (casilla.Objeto != null) {
            PierdeVida = true;
        }
        if (casilla.Item != null) {
            String Aux = casilla.Item.tipo;
            //System.out.println(casilla.Item.tipo);
            if (Aux.equals("Vida")) {
                GanaVida = true;
            } else if (Aux.equals("Castillo")) {
                Finaliza = true;
            } else {
                GanaPuntos = true;
            }
            casilla.Item.casilla = null;
            casilla.Item = null;
        }
    }
}
