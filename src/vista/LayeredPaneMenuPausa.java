package vista;

import controlador.Controlador;
import vista.botones.PanelBotonContinuar;
import vista.botones.PanelBotonSalirMenuInicial;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

public class LayeredPaneMenuPausa extends JLayeredPane {
    Image imagenFondoMenuPausa;
    Image imagenLogoMenuPausa;
    int ancho, alto;

    /*
    A pesar de que esto puede parecer que rompa con el patron MVC, en esta clase
    la instancia de controlador solo esta para que se le pueda pasar la entrada de
    eventos directamente.
    Mientras no se manipule o se haga algo con la logica del controlador el patron
    de MVC no deberia de romperse.
     */
    Controlador controlador;

    PanelBotonContinuar panelBotonContinuar;
    PanelBotonSalirMenuInicial panelBotonSalirMenuInicial;
    ActionListener listener;
    boolean pausado = false;

    public LayeredPaneMenuPausa(int ancho, int alto) {
        ImageIcon imagen = new ImageIcon(getClass().getResource("/imagenes/logoMenuPausa.png"));
        imagenLogoMenuPausa = imagen.getImage();
        imagen = new ImageIcon(getClass().getResource("/imagenes/fondoMenuPausa.png"));
        imagenFondoMenuPausa = imagen.getImage();
        panelBotonContinuar = new PanelBotonContinuar(ancho, alto);
        panelBotonSalirMenuInicial = new PanelBotonSalirMenuInicial(ancho, alto);
        this.ancho = ancho;
        this.alto = alto;
        setPreferredSize(new Dimension(ancho, alto));
        add(panelBotonContinuar, Integer.valueOf(1));
        add(panelBotonSalirMenuInicial, Integer.valueOf(2));
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
        g.fillRect(0, 0, ancho, alto);
        g.drawImage(imagenFondoMenuPausa, 0, 0, ancho, alto, this);
        g.drawImage(imagenLogoMenuPausa, 20, 100, 410, 60, this);
    }

    public void actualizarPanel() {
        repaint();
    }

    public PanelBotonContinuar getPanelBotonContinuar() {
        return panelBotonContinuar;
    }

    public PanelBotonSalirMenuInicial getPanelBotonSalirMenuInicial() {
        return panelBotonSalirMenuInicial;
    }

    public void setControlador(Controlador controlador) {
        this.controlador = controlador;
    }

    public void agregarActionListener(ActionListener listener) {
        this.listener = listener;
    }
}
