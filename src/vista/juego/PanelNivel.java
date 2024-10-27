package vista.juego;

import controlador.Controlador;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class PanelNivel  extends JPanel {
    private Image imagenFondoNivel;
    private int ancho, alto;
    private Controlador controlador;
    private boolean pasarNivel = false;

    public void setPasarNivel(boolean pasarNivel) {
        this.pasarNivel = pasarNivel;
    }

    public PanelNivel(int ancho, int alto) {
        cargarImagenFondo("/imagenes/fondoNivel1.png");
        this.ancho = ancho;
        this.alto = alto;
        setPreferredSize(new Dimension(ancho, alto));
        setFocusable(true);
        requestFocusInWindow();

        addKeyListener(new KeyAdapter() {
            @Override
            public void keyPressed(KeyEvent e) {
                if (controlador != null) {
                    controlador.keyListener(e);
                }
            }
        });
    }

    private void cargarImagenFondo(String rutaFondo) {
        ImageIcon imagen = new ImageIcon(getClass().getResource(rutaFondo));
        imagenFondoNivel = imagen.getImage();
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        g.fillRect(0, 0, ancho, alto);
        g.drawImage(imagenFondoNivel, 0, 0, ancho, alto, this);
    }

    public void cargarNuevoNivel(String rutaFondo) {
        cargarImagenFondo(rutaFondo);
        repaint(); // Asegúrate de actualizar la vista
    }

    public void actualizarPanel() {
        repaint();
    }

    public boolean getPasarNivel() {return pasarNivel;}

    public void setControlador(Controlador controlador) {
        this.controlador = controlador;
    }


}

