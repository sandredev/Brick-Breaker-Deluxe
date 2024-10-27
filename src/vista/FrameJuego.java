package vista;


import vista.juego.PanelNivel;
import vista.juego.PanelFinal;
import javax.swing.*;
import java.awt.*;

public class FrameJuego extends JFrame {
    private int ancho;
    private int alto;
    private Image iconoFrame;
    private LayeredPaneJuego layeredPaneJuego;
    private LayeredPaneMenu layeredPaneMenu;
    private LayeredMenuGameOver layeredMenuGameOver;
    private LayeredPaneMenuPausa layeredPaneMenuPausa;
    private PanelNivel panelNivel;
    private PanelFinal panelFinal;
    private boolean panelMenuInicioEnPantalla = true;
    private boolean panelMenuGameOverEnPantalla = false;
    private boolean panelMenuPausaEnPantalla = false;


    public FrameJuego(int ancho, int alto, LayeredPaneJuego layeredPaneJuego, String titulo) {
        this.ancho = ancho;
        this.alto = alto;
        this.layeredPaneJuego = layeredPaneJuego;
        setTitle(titulo);
        layeredPaneMenu = new LayeredPaneMenu(ancho, alto);
        add(layeredPaneMenu);
        panelNivel = new PanelNivel(ancho, alto);
        panelFinal = new PanelFinal(ancho, alto);
        layeredMenuGameOver = new LayeredMenuGameOver(ancho, alto);
        layeredPaneMenuPausa = new LayeredPaneMenuPausa(ancho, alto);
        ImageIcon imagen = new ImageIcon(getClass().getResource("/imagenes/iconFrame.png"));
        iconoFrame = imagen.getImage();
        setIconImage(iconoFrame);
        pack();
        setLocationRelativeTo(null);
        setResizable(false);
        setVisible(true);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }

    public void cambiarPantallaGameOver() {
        remove(layeredPaneJuego);
        add(layeredMenuGameOver);
        panelMenuInicioEnPantalla = false;
        panelMenuGameOverEnPantalla = true;
        panelMenuPausaEnPantalla = false;

        /*
        Al producirse el cambio de paneles en el frame el foco de eventos de teclado no cambia
        automaticamente.
        Con esta instruccion se logra cambiar el foco manualmente al componente que deseamos.
         */
        layeredMenuGameOver.requestFocusInWindow();

        revalidate();
        repaint();
    }

    public void cambiarPantallaNuevoNivel() {
        remove(layeredPaneMenu);
        remove(layeredPaneJuego);
        add(panelNivel);
        panelMenuInicioEnPantalla = false;
        panelMenuGameOverEnPantalla = false;

        /*
        Al producirse el cambio de paneles en el frame el foco de eventos de teclado no cambia
        automaticamente.
        Con esta instruccion se logra cambiar el foco manualmente al componente que deseamos.
         */
        panelNivel.requestFocusInWindow();

        revalidate();
        repaint();
    }

    public void cambiarPantallaMenuPausa() {
        remove(layeredPaneJuego);
        add(layeredPaneMenuPausa);
        panelMenuInicioEnPantalla = false;
        panelMenuGameOverEnPantalla = false;
        panelMenuPausaEnPantalla = true;

        /*
        Al producirse el cambio de paneles en el frame el foco de eventos de teclado no cambia
        automaticamente.
        Con esta instruccion se logra cambiar el foco manualmente al componente que deseamos.
         */
        layeredPaneMenuPausa.requestFocusInWindow();

        revalidate();
        repaint();
    }

    public void cambiarPantallaJuego() {
        remove(layeredPaneMenuPausa);
        remove(panelNivel);
        add(layeredPaneJuego);
        /*
        Al producirse el cambio de paneles en el frame el foco de eventos de teclado no cambia
        automaticamente.
        Con esta instruccion se logra cambiar el foco manualmente al componente que deseamos.
         */
        layeredPaneJuego.requestFocusInWindow();

        revalidate();
        repaint();
    }

    public void cambiarPantallaJMenuPrincipal() {
        remove(layeredPaneMenuPausa);
        add(layeredPaneMenu);
        panelMenuInicioEnPantalla = true;
        panelMenuGameOverEnPantalla = false;
        panelMenuPausaEnPantalla = false;

        /*
        Al producirse el cambio de paneles en el frame el foco de eventos de teclado no cambia
        automaticamente.
        Con esta instruccion se logra cambiar el foco manualmente al componente que deseamos.
         */
        layeredPaneMenu.requestFocusInWindow();

        revalidate();
        repaint();
    }

    public void cambiarPantallaFinal() {
        remove(layeredPaneJuego);
        add(panelFinal);
        revalidate();
        repaint();
    }

    public PanelFinal getPanelFinal() {
        return panelFinal;
    }

    public LayeredPaneJuego getLayeredPaneJuego() {return layeredPaneJuego;
    }
    public LayeredPaneMenu getLayeredPaneMenu() {
        return layeredPaneMenu;
    }

    public LayeredMenuGameOver getLayeredMenuGameOver() {
        return layeredMenuGameOver;
    }

    public LayeredPaneMenuPausa getLayeredPaneMenuPausa() {return layeredPaneMenuPausa;}


    public void iniciarJuego() {
        remove(layeredPaneMenuPausa);
        remove(layeredPaneMenu);
        remove(layeredMenuGameOver);
        add(layeredPaneJuego);
        layeredPaneJuego.requestFocusInWindow();
        repaint();
        revalidate();
    }

    public void cambiarFondoNivel (int nivel) {
        switch (nivel) {
            case 1:
                getLayeredPaneJuego().getPanelFondo().cargarNuevoNivel("/imagenes/fondo1.gif");
                break;
            case 2:
                getLayeredPaneJuego().getPanelFondo().cargarNuevoNivel("/imagenes/fondo2.gif");
                break;
            case 3:
                getLayeredPaneJuego().getPanelFondo().cargarNuevoNivel("/imagenes/fondo3.gif");
                break;
            case 4:
                getLayeredPaneJuego().getPanelFondo().cargarNuevoNivel("/imagenes/fondo4.gif");
                break;
            case 5:
                getLayeredPaneJuego().getPanelFondo().cargarNuevoNivel("/imagenes/fondo5.gif");
                break;
        }
    }

    public boolean getPanelMenuInicioEnPantalla() {
        return panelMenuInicioEnPantalla;
    }

    public boolean getPanelMenuGameOverEnPantalla() {
        return panelMenuGameOverEnPantalla;
    }

    public boolean getPanelMenuPausaEnPantalla() {
        return panelMenuPausaEnPantalla;
    }

    public PanelNivel getPanelNivel() {
        return panelNivel;
    }
}
