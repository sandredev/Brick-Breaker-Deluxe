package vista;

import vista.botones.*;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import controlador.Controlador;

public class LayeredPaneMenu extends JLayeredPane {
    Image imagenLogoMenu;
    Image imagenFondoMenu;
    int ancho, alto;

    /*
    A pesar de que esto puede parecer que rompa con el patron MVC, en esta clase
    la instancia de controlador solo esta para que se le pueda pasar la entrada de
    eventos directamente.
    Mientras no se manipule o se haga algo con la logica del controlador el patron
    de MVC no deberia de romperse.
     */
    Controlador controlador;

    PanelBotonJugar panelBotonJugar;
    PanelBotonSalir panelBotonSalir;
    ActionListener listener;

    public LayeredPaneMenu(int ancho, int alto) {
        ImageIcon imagen = new ImageIcon(getClass().getResource("/imagenes/logoJuego.png"));
        imagenLogoMenu = imagen.getImage();
        imagen = new ImageIcon(getClass().getResource("/imagenes/fondoMenu.gif"));
        imagenFondoMenu = imagen.getImage();
        panelBotonJugar = new PanelBotonJugar(ancho, alto);
        panelBotonSalir = new PanelBotonSalir(ancho, alto);
        this.ancho = ancho;
        this.alto = alto;
        setPreferredSize(new Dimension(ancho, alto));
        add(panelBotonJugar, Integer.valueOf(1));
        add(panelBotonSalir, Integer.valueOf(2));
        addKeyListener(new KeyListener() {
            public void keyPressed(KeyEvent e) {
                controlador.keyListener(e);
            }
            public void keyReleased(KeyEvent e) {}
            public void keyTyped(KeyEvent e) {}
        });
        setFocusable(true);
        requestFocusInWindow();
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        g.setColor(Color.BLACK);
        g.fillRect(0, 0, ancho, alto);
        g.drawImage(imagenFondoMenu, 0, 0, ancho, alto, this);
        g.drawImage(imagenLogoMenu, 20, 100, 410, 100, this);
    }

    public void actualizarPanel() {
        repaint();
    }

    public PanelBotonJugar getPanelBotonJugar() {
        return panelBotonJugar;
    }

    public PanelBotonSalir getPanelBotonSalir() {
        return panelBotonSalir;
    }

    public void setControlador(Controlador controlador) {
        this.controlador = controlador;
    }

    public void agregarActionListener(ActionListener listener) {
        this.listener = listener;
    }
}