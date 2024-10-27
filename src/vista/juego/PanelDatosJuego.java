package vista.juego;

import javax.swing.*;
import java.awt.*;
import modelo.Juego;

public class PanelDatosJuego extends JPanel {
    private Juego juego;
    private Image iconoPelota;
    private int ancho, alto;
    private JLabel puntuacion;

    public PanelDatosJuego(Juego juego, int ancho, int alto) {
        this.juego = juego;
        ImageIcon imagen = new ImageIcon(getClass().getResource("/imagenes/pelota.png"));
        iconoPelota = imagen.getImage();
        this.ancho = ancho;
        this.alto = alto;
        setLayout(null);
        setOpaque(false);
        setBounds(0, 0, ancho, alto);
        puntuacion = new JLabel();
        puntuacion.setBounds(ancho/2-45, 50, 100, 25);
        puntuacion.setFont(new Font("Impact", Font.BOLD, 25));
        puntuacion.setForeground(Color.WHITE);
        puntuacion.setHorizontalAlignment(SwingConstants.CENTER);
        add(puntuacion);
    }

    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        g.drawImage(iconoPelota, 20, 20, 40, 40, this);
        String mensaje = "NIVEL ";
        mensaje += juego.getNivel();
        g.setColor(Color.WHITE);
        g.setFont(new Font("Impact", Font.BOLD, 25));
        g.drawString(mensaje, ancho - 95, 50);
        mensaje = " x ";
        mensaje += juego.getVidas();
        g.drawString(mensaje, 60, 50);
        mensaje = String.valueOf(juego.getPuntuacion());
        puntuacion.setText(mensaje);
        mensaje = "SCORE";
        g.drawString(mensaje, ancho/2 - 28, 40);
    }

    public void actualizarPanel() {
        repaint();
    }
}
