package vista.juego;

import modelo.ArrayLadrillos;
import modelo.Ladrillo;
import javax.swing.*;
import java.awt.*;

public class PanelLadrillos extends JPanel {
    ArrayLadrillos ladrillos;
    Image imagenResistencia1;
    Image imagenResistencia2;
    Image imagenLadrillo2Resistencia1;
    Image imagenLadrillo2Resistencia2;
    Image imagenLadrillo2Resistencia3;
    Image imagenLadrilloIrrompible;
    int ancho, alto;
    int filasArrayLadrillos, columnasArrayLadrillos;

    public void setFilasArrayLadrillos(int filasArrayLadrillos) {
        this.filasArrayLadrillos = filasArrayLadrillos;
    }

    public PanelLadrillos(int ancho, int alto, ArrayLadrillos ladrillos,
                          int filasArrayLadrillos, int columnasArrayLadrillos) {
        this.ancho = ancho;
        this.alto = alto;
        this.ladrillos = ladrillos;
        this.filasArrayLadrillos = filasArrayLadrillos;
        this.columnasArrayLadrillos = columnasArrayLadrillos;
        ImageIcon imagen = new ImageIcon(getClass().getResource("/imagenes/ladrilloResistencia2.png"));
        imagenResistencia2 = imagen.getImage();
        imagen = new ImageIcon(getClass().getResource("/imagenes/ladrilloResistencia1.png"));
        imagenResistencia1 = imagen.getImage();
        imagen = new ImageIcon(getClass().getResource("/imagenes/ladrilloTipo2Resistencia1.png"));
        imagenLadrillo2Resistencia1 = imagen.getImage();
        imagen = new ImageIcon(getClass().getResource("/imagenes/ladrilloTipo2Resistencia2.png"));
        imagenLadrillo2Resistencia2 = imagen.getImage();
        imagen = new ImageIcon(getClass().getResource("/imagenes/ladrilloTipo2Resistencia3.png"));
        imagenLadrillo2Resistencia3 = imagen.getImage();
        imagen = new ImageIcon(getClass().getResource("/imagenes/ladrilloIrrompible.png"));
        imagenLadrilloIrrompible = imagen.getImage();
        setBounds(0, 0, ancho, alto);
        setOpaque(false);
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        for (int i = 0; i < filasArrayLadrillos; i++) {
            for (int j = 0; j < columnasArrayLadrillos; j++) {
                Ladrillo ladrillo = ladrillos.getLadrillo(i,j);
                if (ladrillo.getResistencia() == 2 && ladrillo.getTipo() == 1) {
                    g.drawImage(imagenResistencia2, ladrillo.getX(), ladrillo.getY(),
                            ladrillo.getAncho(), ladrillo.getAlto(), this);
                }
                else if (ladrillo.getResistencia() == 1 && ladrillo.getTipo() == 1) {
                    g.drawImage(imagenResistencia1, ladrillo.getX(), ladrillo.getY(),
                            ladrillo.getAncho(), ladrillo.getAlto(), this);
                }
                else if (ladrillo.getResistencia() == 1 && ladrillo.getTipo() == 2) {
                    g.drawImage(imagenLadrillo2Resistencia1, ladrillo.getX(), ladrillo.getY(),
                            ladrillo.getAncho(), ladrillo.getAlto(), this);
                }
                else if (ladrillo.getResistencia() == 2 && ladrillo.getTipo() == 2) {
                    g.drawImage(imagenLadrillo2Resistencia2, ladrillo.getX(), ladrillo.getY(),
                            ladrillo.getAncho(), ladrillo.getAlto(), this);
                }
                else if (ladrillo.getResistencia() == 3 && ladrillo.getTipo() == 2) {
                    g.drawImage(imagenLadrillo2Resistencia3, ladrillo.getX(), ladrillo.getY(),
                            ladrillo.getAncho(), ladrillo.getAlto(), this);
                }
                else if (ladrillo.getTipo() == 3) {
                    g.drawImage(imagenLadrilloIrrompible, ladrillo.getX(), ladrillo.getY(),
                            ladrillo.getAncho(), ladrillo.getAlto(), this);
                }
                else {
                    //Nada
                }
            }
        }
    }

    public void actualizarPanel() {
        repaint();
    }

    public void setLadrillos(ArrayLadrillos ladrillos) {
        this.ladrillos = ladrillos;
    }
}
