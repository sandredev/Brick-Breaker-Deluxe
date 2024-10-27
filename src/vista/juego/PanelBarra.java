package vista.juego;

import java.awt.*;
import java.awt.event.MouseEvent;
import java.awt.event.MouseMotionListener;
import modelo.Barra;
import javax.swing.*;

public class PanelBarra extends JPanel {
    private Barra barra;
    private Image imagenBarra;

    public PanelBarra(Barra barra, int ancho, int alto) {
        this.barra = barra;
        setBounds(0, 0, ancho, alto);
        ImageIcon imagen = new ImageIcon(getClass().getResource("/imagenes/barra.png"));
        imagenBarra = imagen.getImage();
        // Coloca el fondo del panel como transparente (no afecta componentes)
        setOpaque(false);

        // Agrega un escuchador del mouse al objeto
        addMouseMotionListener(new MouseMotionListener() {

            // Este metodo mueve la barra segun la posicion del mouse al moverlo
            @Override
            public void mouseMoved(MouseEvent e) {
                barra.moverConMouse(e.getX() - barra.getAncho()/2);
                repaint();
            }

            @Override
            public void mouseDragged(MouseEvent e) { }
        });
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        g.drawImage(imagenBarra, barra.getX(), barra.getY(), barra.getAncho(), barra.getAlto(), this);
    }

    public void actualizarPanel() {
        repaint();
    }
}
