package vista;

import controlador.Controlador;
import modelo.*;
import vista.juego.*;

import javax.swing.*;
import java.awt.*;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

public class LayeredPaneJuego extends JLayeredPane {
    Pelota pelota;
    Barra barra;
    Juego juego;
    ArrayLadrillos ladrillos;
    PanelBarra panelBarra;
    PanelDatosJuego panelDatosJuego;
    PanelFondo panelFondo;
    PanelLadrillos panelLadrillos;
    PanelPelota panelPelota;
    int ancho, alto;
    Controlador controlador;

    public void setControlador(Controlador controlador) {
        this.controlador = controlador;
    }

    public LayeredPaneJuego(Pelota pelota, Barra barra, Juego juego, ArrayLadrillos ladrillos, PanelPelota panelPelota,
                            PanelDatosJuego panelDatosJuego, PanelFondo panelFondo, PanelLadrillos panelLadrillos,
                            PanelBarra panelBarra, int ancho, int alto) {
        this.pelota = pelota;
        this.barra = barra;
        this.juego = juego;
        this.ladrillos = ladrillos;
        this.panelBarra = panelBarra;
        this.panelDatosJuego = panelDatosJuego;
        this.panelFondo = panelFondo;
        this.panelLadrillos = panelLadrillos;
        this.panelPelota = panelPelota;
        this.ancho = ancho;
        this.alto = alto;
        setPreferredSize(new Dimension(ancho, alto));

        // Registrar este panel como KeyListener
        addKeyListener(new KeyListener() {
            public void keyPressed(KeyEvent e) {
                controlador.keyListener(e);
            }

            public void keyReleased(KeyEvent e) {
            }

            public void keyTyped(KeyEvent e) {
            }
        });
        setFocusable(true);
        requestFocusInWindow();


        // Se agrega el panelFondo a la capa de nivel 1
        add(panelFondo, Integer.valueOf(1));

        // Se agrega el panelPelota a la capa de nivel 2 (se sobrepone a panelFondo)
        add(panelPelota, Integer.valueOf(2));

        // Se agrega el panelBarra a la capa de nivel 3 (se sobrepone a panelPelota)
        add(panelBarra, Integer.valueOf(3));

        // Se agrega el panelLadrillos a la capa de nivel 4 (se sobrepone a panelBarra)
        add(panelLadrillos, Integer.valueOf(4));

        // Se agrega el panelDatosJuego a la capa de nivel 5 (se sobrepone a panelLadrillos)
        add(panelDatosJuego, Integer.valueOf(5));
    }

    public PanelFondo getPanelFondo() {
        return panelFondo;
    }
}
