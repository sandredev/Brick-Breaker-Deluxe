package vista.juego;

import javax.swing.*;
import java.awt.*;

public class PanelGameOver extends JPanel {
    Image imagenGameOver;
    int ancho, alto;

    public PanelGameOver(int ancho, int alto) {
        setPreferredSize(new Dimension(ancho, alto));
        ImageIcon imagen = new ImageIcon(getClass().getResource("/imagenes/gameOver.png"));
        imagenGameOver = imagen.getImage();
        this.ancho = ancho;
        this.alto = alto;
    }

    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        g.drawImage(imagenGameOver, 0, 0, ancho, alto, this);
    }
}
