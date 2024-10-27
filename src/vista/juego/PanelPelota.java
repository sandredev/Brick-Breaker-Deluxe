package vista.juego;

import javax.swing.*;
import java.awt.*;
import modelo.Pelota;

public class PanelPelota extends JPanel {
    private Pelota pelota;
    private Image imagenPelota;

    public PanelPelota(Pelota pelota, int ancho, int alto) {
        this.pelota = pelota;
        ImageIcon imagen = new ImageIcon(getClass().getResource("/imagenes/pelota.png"));
        imagenPelota = imagen.getImage();
        setBounds(0, 0, ancho, alto);
        setOpaque(false);
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        g.setColor(Color.RED); // Color de la pelota
        g.drawImage(imagenPelota, pelota.getX() - pelota.getRadio(),
                pelota.getY() - pelota.getRadio(),
                pelota.getRadio() * 2, pelota.getRadio() * 2, this);

    }

    public void actualizarPanel() {
        repaint();
    }
}
