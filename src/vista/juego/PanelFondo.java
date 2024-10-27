package vista.juego;
import java.awt.*;
import javax.swing.*;

// Esta clase contiene el fondo del juego
public class PanelFondo extends JPanel {
    Image imagenFondo;
    int ancho, alto;

    public PanelFondo(int ancho, int alto) {
        ImageIcon imagen  = new ImageIcon(getClass().getResource("/imagenes/fondo1.gif"));
        imagenFondo = imagen.getImage();
        this.ancho = ancho;
        this.alto = alto;
        setBounds(0, 0, ancho, alto);
        setBackground(Color.BLACK);
    }

    private void cargarImagenFondo(String rutaFondo) {
        ImageIcon imagen = new ImageIcon(getClass().getResource(rutaFondo));
        imagenFondo = imagen.getImage();
    }

    public void cargarNuevoNivel(String rutaFondo) {
        cargarImagenFondo(rutaFondo);
        repaint(); // Asegúrate de actualizar la vista
    }

    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        g.drawImage(imagenFondo, 0, 0, ancho, alto, this);
    }
}
