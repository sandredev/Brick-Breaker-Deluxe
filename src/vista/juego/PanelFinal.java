package vista.juego;

import java.awt.*;
import javax.swing.*;
import utilidades.Sonido;

public class PanelFinal extends JPanel {
    private int ancho, alto;
    private int puntuacion;
    private int vidasPerdidas;
    private Sonido cancionFinal;
    private Image gifFinal;
    private Image estadisticasFinal;

    public PanelFinal(int ancho, int alto) {
        this.ancho = ancho;
        this.alto = alto;
        ImageIcon imagen = new ImageIcon(getClass().getResource("/imagenes/gifFinal.gif"));
        gifFinal = imagen.getImage();
        imagen = new ImageIcon(getClass().getResource("/imagenes/estadisticasFinal.png"));
        estadisticasFinal = imagen.getImage();
        cancionFinal = new Sonido();
        setPreferredSize(new Dimension(ancho, alto));
        cancionFinal.cargarSonido("/sonidos/CancionFinal.wav");
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        g.drawImage(gifFinal, 0, 0, ancho, alto, this);
        g.drawImage(estadisticasFinal, 0, 0, ancho, alto, this);
        g.setColor(Color.WHITE);
        String mensaje = "";
        g.setFont(new Font("Impact", Font.BOLD, 25));
        mensaje = String.valueOf(puntuacion);
        g.drawString(mensaje, ancho/2 + 40, alto/2);
        mensaje = String.valueOf(vidasPerdidas);
        g.drawString(mensaje, ancho/2 + 120, alto/2 + 39);
    }

    public void reproducirCancion() {
        cancionFinal.reproducir();
    }

    public void setVidasPerdidas(int vidasPerdidas) {
        this.vidasPerdidas = vidasPerdidas;
    }

    public void setPuntuacion(int puntuacion) {
        this.puntuacion = puntuacion;
    }
}
