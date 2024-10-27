package controlador;

import javax.swing.Timer;
import utilidades.ColeccionSonidos;
import vista.FrameJuego;
import vista.LayeredPaneMenuPausa;
import vista.juego.PanelLadrillos;
import vista.juego.PanelPelota;
import modelo.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;

public class Controlador implements ActionListener  {
    private Pelota pelota;
    private Barra barra;
    private ArrayLadrillos ladrillos;
    private Juego juego;
    private PanelPelota panelPelota;
    private ColeccionSonidos coleccionSonidos;
    private Timer temporizador;
    private FrameJuego frameJuego;
    private PanelLadrillos panelLadrillos;
    private boolean pausado = false;
    private boolean jugando = false;

    public Controlador(Pelota pelota, Barra barra, PanelPelota panelPelota, ArrayLadrillos ladrillos, Juego juego,
                       FrameJuego frameJuego, PanelLadrillos panelLadrillos, ColeccionSonidos coleccionSonidos) {
        this.pelota = pelota;
        this.panelPelota = panelPelota;
        this.barra = barra;
        this.ladrillos = ladrillos;
        this.juego = juego;
        this.frameJuego = frameJuego;
        this.panelLadrillos = panelLadrillos;
        this.coleccionSonidos = coleccionSonidos;

        // Establece al controlador como el escuchador del botón de jugar en el menú de inicio
        frameJuego.getLayeredPaneMenu().getPanelBotonJugar().agregarActionListener(this);
        // Establece al controlador como el escuchador del botón de salir en el menú de inicio
        frameJuego.getLayeredPaneMenu().getPanelBotonSalir().agregarActionListener(this);
        // Establece al controlador como el escuchador del botón de reiniciar en el menú de game over
        frameJuego.getLayeredMenuGameOver().getPanelBotonReiniciar().agregarActionListener(this);
        // Establece al controlador como el escuchador del botón de salir en el menú de game over
        frameJuego.getLayeredMenuGameOver().getPanelBotonSalir().agregarActionListener(this);
        // Establece al controlador como el escuchador del botón de jugar en el menú de pausa.
        frameJuego.getLayeredPaneMenuPausa().getPanelBotonContinuar().agregarActionListener(this);
        // Establece al controlador como el escuchador del botón de salir en el menú de pausa.
        frameJuego.getLayeredPaneMenuPausa().getPanelBotonSalirMenuInicial().agregarActionListener(this);

        temporizador = new Timer(10, new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if(!jugando) {
                    switch (juego.getNivel()) {
                        case 1:
                            frameJuego.getPanelNivel().setPasarNivel(true);
                            coleccionSonidos.detenerCancionJuego(juego.getNivel());
                            frameJuego.cambiarPantallaNuevoNivel();
                            detener();
                            coleccionSonidos.reproducirCancionNuevoNivel();
                            break;
                        case 2:
                            frameJuego.getPanelNivel().setPasarNivel(true);
                            coleccionSonidos.detenerCancionJuego(juego.getNivel());
                            frameJuego.getPanelNivel().cargarNuevoNivel("/imagenes/fondoNivel2.png");
                            frameJuego.cambiarPantallaNuevoNivel();
                            detener();
                            coleccionSonidos.reproducirCancionNuevoNivel();
                            break;
                        case 3:
                            frameJuego.getPanelNivel().setPasarNivel(true);
                            coleccionSonidos.detenerCancionJuego(juego.getNivel());
                            frameJuego.getPanelNivel().cargarNuevoNivel("/imagenes/fondoNivel3.png");
                            frameJuego.cambiarPantallaNuevoNivel();
                            detener();
                            coleccionSonidos.reproducirCancionNuevoNivel();
                            break;
                        case 4:
                            frameJuego.getPanelNivel().setPasarNivel(true);
                            coleccionSonidos.detenerCancionJuego(juego.getNivel());
                            frameJuego.getPanelNivel().cargarNuevoNivel("/imagenes/fondoNivel4.png");
                            frameJuego.cambiarPantallaNuevoNivel();
                            detener();
                            coleccionSonidos.reproducirCancionNuevoNivel();
                            break;
                        case 5:
                            frameJuego.getPanelNivel().setPasarNivel(true);
                            coleccionSonidos.detenerCancionJuego(juego.getNivel());
                            frameJuego.getPanelNivel().cargarNuevoNivel("/imagenes/fondoNivel5.png");
                            frameJuego.cambiarPantallaNuevoNivel();
                            detener();
                            coleccionSonidos.reproducirCancionNuevoNivel();
                            break;
                        case 6:
                            detener();
                            break;
                    }
                }
                pelota.mover();
                barra.verificarColision(pelota, juego, ladrillos);
                ladrillos.verificarColisiones(pelota, juego);
                panelPelota.actualizarPanel();

                if (juego.nivelCompletado()) {
                    jugando = false;
                    // Disminuir el ancho de la barra y aumentar la velocidad de la pelota
                    barra.disminuirAncho();
                    pelota.incrementarVelocidad();
                    pelota.reiniciarPosicion(); // Reiniciar la posición de la pelota

                    juego.pasarDeNivel();
                    if (juego.getNivel() >= 6) {
                        frameJuego.getPanelFinal().setPuntuacion(juego.getPuntuacion());
                        frameJuego.getPanelFinal().setVidasPerdidas(juego.getVidasPerdidas());
                        frameJuego.cambiarPantallaFinal();
                        coleccionSonidos.detenerCancionJuego(5);
                        frameJuego.getPanelFinal().reproducirCancion();
                    }
                    else {
                        ladrillos.destruirLadrillos(); // Reiniciar el array de ladrillos
                        ladrillos.generarNiveles(juego.getNivel());
                        frameJuego.cambiarFondoNivel(juego.getNivel());
                        coleccionSonidos.detenerCancionJuego(juego.getNivel() - 1);
                        coleccionSonidos.reproducirCancionJuego(juego.getNivel());
                        juego.setCantidadLadrillosEnNivel(ladrillos.cantidadLadrillosNivel());
                        panelLadrillos.actualizarPanel();
                    }
                }

                if (juego.juegoTerminado()) {
                    jugando = false;
                    frameJuego.cambiarPantallaGameOver();
                    coleccionSonidos.detenerCancionJuego(juego.getNivel());
                    coleccionSonidos.reproducirCancionGameOver();
                    detener();
                }
            }
        });
    }

    public void iniciarJuego() {
        frameJuego.iniciarJuego();
        frameJuego.cambiarFondoNivel(1);
        iniciar();
    }

    public void reiniciarJuego() {
        coleccionSonidos.detenerCancionGameOver();
        coleccionSonidos.detenerCancionJuego(juego.getNivel());
        juego.reiniciarJuego();
        ladrillos.generarNiveles(1);
        pelota.reiniciarPosicion();
        pelota.colocarVelocidadOriginal();
        juego.setCantidadLadrillosEnNivel(ladrillos.cantidadLadrillosNivel());
        frameJuego.getPanelNivel().cargarNuevoNivel("/imagenes/fondoNivel1.png");
        barra.colocarAnchoOriginal();
        frameJuego.cambiarFondoNivel(1);
        frameJuego.iniciarJuego();
        coleccionSonidos.reproducirCancionJuego(1);
        iniciar();
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getActionCommand().equals("botonJugarPresionado")) {
            coleccionSonidos.detenerCancionMenuPrincipal();
            reiniciarJuego();
        }
        if (e.getActionCommand().equals("botonSalirPresionado")) {
            System.exit(0);
        }
        if (e.getActionCommand().equals("botonReiniciarPresionado")) {
            reiniciarJuego();
        }
        if (e.getActionCommand().equals("botonSalirAlMenuPresionado")) {
            coleccionSonidos.detenerCancionMenuPausa();
            frameJuego.cambiarPantallaJMenuPrincipal();
            coleccionSonidos.reproducirCancionMenuPrincipal();
            jugando = false;
        }
        if (e.getActionCommand().equals("botonContinuarPresionado")) {
            reanudarJuego();
        }
    }

    public void keyListener(KeyEvent e) {
        if (e.getKeyCode() == KeyEvent.VK_UP) {
            frameJuego.getLayeredPaneMenu().getPanelBotonJugar().cambiarEstadoBoton();
            frameJuego.getLayeredPaneMenu().getPanelBotonSalir().cambiarEstadoBoton();
            frameJuego.getLayeredMenuGameOver().getPanelBotonReiniciar().cambiarEstadoBoton();
            frameJuego.getLayeredMenuGameOver().getPanelBotonSalir().cambiarEstadoBoton();
            frameJuego.getLayeredPaneMenuPausa().getPanelBotonContinuar().cambiarEstadoBoton();
            frameJuego.getLayeredPaneMenuPausa().getPanelBotonSalirMenuInicial().cambiarEstadoBoton();

            coleccionSonidos.reproducirEfectoSeleccion();
        } else if (e.getKeyCode() == KeyEvent.VK_DOWN) {
            frameJuego.getLayeredPaneMenu().getPanelBotonJugar().cambiarEstadoBoton();
            frameJuego.getLayeredPaneMenu().getPanelBotonSalir().cambiarEstadoBoton();
            frameJuego.getLayeredMenuGameOver().getPanelBotonReiniciar().cambiarEstadoBoton();
            frameJuego.getLayeredMenuGameOver().getPanelBotonSalir().cambiarEstadoBoton();
            frameJuego.getLayeredPaneMenuPausa().getPanelBotonContinuar().cambiarEstadoBoton();
            frameJuego.getLayeredPaneMenuPausa().getPanelBotonSalirMenuInicial().cambiarEstadoBoton();
            coleccionSonidos.reproducirEfectoSeleccion();
        }
        if (e.getKeyCode() == KeyEvent.VK_ENTER || e.getKeyCode() == KeyEvent.VK_Z) {
            if (frameJuego.getLayeredPaneMenu().getPanelBotonJugar().getEstadoBoton() &&
                    frameJuego.getPanelMenuInicioEnPantalla()) {
                reiniciarJuego();
                coleccionSonidos.detenerCancionMenuPrincipal();
            }
            if (frameJuego.getLayeredMenuGameOver().getPanelBotonReiniciar().getEstadoBoton() &&
                    frameJuego.getPanelMenuGameOverEnPantalla()) {
                reiniciarJuego();
            }
            if (frameJuego.getLayeredPaneMenu().getPanelBotonSalir().getEstadoBoton() &&
                    frameJuego.getPanelMenuInicioEnPantalla()) {
                System.exit(0);
            }
            if (frameJuego.getLayeredMenuGameOver().getPanelBotonSalir().getEstadoBoton() &&
                    frameJuego.getPanelMenuGameOverEnPantalla()) {
                System.exit(0);
            }
            if (frameJuego.getLayeredPaneMenuPausa().getPanelBotonContinuar().getEstadoBoton() &&
                    frameJuego.getPanelMenuPausaEnPantalla()) {
                reanudarJuego();
            }
            if (frameJuego.getLayeredPaneMenuPausa().getPanelBotonSalirMenuInicial().getEstadoBoton() &&
                    frameJuego.getPanelMenuPausaEnPantalla()) {
                coleccionSonidos.detenerCancionMenuPausa();
                frameJuego.cambiarPantallaJMenuPrincipal();
                coleccionSonidos.reproducirCancionMenuPrincipal();
                jugando = false;
            }
            if (frameJuego.getPanelNivel().getPasarNivel()) {
                jugando = true;
                coleccionSonidos.detenerCancionNuevoNivel();
                frameJuego.getPanelNivel().setPasarNivel(false);
                reanudarJuego();
            }

        }
        if (jugando) {
            if (e.getKeyCode() == KeyEvent.VK_ESCAPE) {
                    if (pausado) {
                    reanudarJuego();
                } else {
                    pausarJuego();
                }
            }
        }

        // Comando para pasar de nivel automaticamente
        if (e.getKeyCode() == KeyEvent.VK_C) {
            ladrillos.destruirLadrillos();
            juego.setCantidadLadrillosEnNivel(0);
        }

        // Comando para ganar vidas
        if (e.getKeyCode() == KeyEvent.VK_X) {
            juego.aumentarVida();
        }
    }

    private void pausarJuego() {
        pausado = true;
        frameJuego.cambiarPantallaMenuPausa();
        coleccionSonidos.detenerCancionJuego(juego.getNivel());
        coleccionSonidos.reproducirCancionMenuPausa();
        detener();
    }

    private void reanudarJuego() {
        pausado = false;
        frameJuego.cambiarPantallaJuego();
        coleccionSonidos.detenerCancionMenuPausa();
        coleccionSonidos.reanudarCancionJuego(juego.getNivel());// Cambiar de nuevo a la pantalla de juego
        iniciar(); // Reinicia el juego o continúa donde lo dejaste
    }
    public void iniciar() {
        temporizador.start();
    }

    public void detener() {
        temporizador.stop();
    }
}

