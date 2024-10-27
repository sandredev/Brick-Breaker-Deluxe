package vista.botones;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class PanelBotonReiniciar extends JPanel {
    Image imagenBotonActivo, imagenBotonInactivo;
    int ancho, alto;
    private ActionListener listener;
    private boolean estadoBoton = true;

    public PanelBotonReiniciar(int ancho, int alto) {
        this.ancho = ancho;
        this.alto = alto;
        ImageIcon imagen = new ImageIcon(getClass().getResource("/imagenes/botonReiniciarActivo.png"));
        imagenBotonActivo = imagen.getImage();
        imagen = new ImageIcon(getClass().getResource("/imagenes/botonReiniciarInactivo.png"));
        imagenBotonInactivo = imagen.getImage();
        setBounds(0, alto/2, 410, 70);
        setOpaque(false);

        addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                if (e.getX() <= ancho - 20 && e.getX() >= 20) {
                    // Crea un ActionEvent que sirve para verificar en el controlador si el boton es presionado
                    if (listener != null) {
                        listener.actionPerformed(new ActionEvent(this, ActionEvent.ACTION_PERFORMED,
                                "botonReiniciarPresionado"));
                    }
                }
            }
        });
    }

    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        if (estadoBoton) {
            g.drawImage(imagenBotonActivo, 20, 0, 410, 70, null);
        }
        else {
            g.drawImage(imagenBotonInactivo, 20, 0, 410, 70, null);
        }
    }

    public void actualizarPanel() {
        repaint();
    }

    public void agregarActionListener(ActionListener listener) {
        this.listener = listener;
    }

    public void cambiarEstadoBoton() {
        if (estadoBoton) {
            estadoBoton = false;
        }
        else {
            estadoBoton = true;
        }
        repaint();
    }

    public boolean getEstadoBoton() {
        return estadoBoton;
    }
}
