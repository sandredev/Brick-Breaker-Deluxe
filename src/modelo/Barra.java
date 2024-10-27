package modelo;

import utilidades.ColeccionSonidos;

import java.lang.reflect.Array;

public class Barra {
    private int x, y; // Posición de la barra
    private int ancho, alto; // Dimensiones de la barra
    private int anchoOriginal; // Almacena el primer ancho ingresado (util para reiniciar el juego)
    private int anchoPanel; // Ancho del área de juego (para limitar el movimiento)
    private ColeccionSonidos coleccionSonidos; // Biblioteca de sonidos del programa
    private int vecesAnchoCambiado = 0; // Cantidad de veces que el ancho fue cambiado
                                    // (util para limitar el cambio al llegar a un nivel alto en el juego)

    public Barra(int x, int y, int ancho, int alto, int anchoPanel) {
        this.x = x;
        this.y = y;
        this.ancho = ancho;
        anchoOriginal = ancho;
        this.alto = alto;
        this.anchoPanel = anchoPanel;
        coleccionSonidos = new ColeccionSonidos();
    }

    public void moverConMouse(int nuevaX) {
        if (nuevaX < 0) {
            x = 0;
        } else if (nuevaX + ancho > anchoPanel) {
            x = anchoPanel - ancho;
        } else {
            x = nuevaX;
        }
    }

    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }

    public int getAncho() {
        return ancho;
    }

    public int getAlto() {
        return alto;
    }

    public void verificarColision(Pelota pelota, Juego juego, ArrayLadrillos ladrillos) {
        double anguloRandom; // Angulo que se producira al chocar la pelota

        // Verica si la posicion en x de la pelota esta por fuera del lado izquierdo de la barra
        if (pelota.getX() < x) {
            // Si la posicion en x de la pelota esta por fuera del lado izquierdo de la barra entonces
            // verifica si el radio de la pelota toca la barra
            if (pelota.getX() + pelota.getRadio() >= x) {
                // Si la pelota esta en el rango de la barra y ademas choca con su parte superior
                // entonces se cambia la direccion de la pelota
                if (pelota.getY() + pelota.getRadio() >= y) {
                    //Esto es para evitar errores a la hora de hacer el choque
                    pelota.setPosicionY(y - pelota.getRadio() - 1);
                    anguloRandom = -(2*(Math.PI/3) + Math.random() * (5*(Math.PI/6) - 2*(Math.PI/3))) ; //limiteInferior + rand() % (limiteSuperior-limiteInferior)
                    pelota.setDireccion(anguloRandom);
                    ladrillos.reiniciarContadorLadrillosRotos();
                    coleccionSonidos.reproducirSonidoColision();

                }
            }
        }

        // Verifica si la pelota esta en la primera mitad izquierda de la barra
        if (pelota.getX() >= x && pelota.getX() < x + (double)ancho/3) {

            // Si la pelota esta en el rango de la barra y ademas choca con su parte superior
            // entonces se cambia la direccion de la pelota
            if (pelota.getY() + pelota.getRadio() >= y) {
                //Esto es para evitar errores a la hora de hacer el choque
                pelota.setPosicionY(y - pelota.getRadio() - 1);

                anguloRandom = -(2*(Math.PI/3) + Math.random() * (5*(Math.PI/6) - 2*(Math.PI/3))) ; //limiteInferior + rand() % (limiteSuperior-limiteInferior)
                pelota.setDireccion(anguloRandom);
                ladrillos.reiniciarContadorLadrillosRotos();
                coleccionSonidos.reproducirSonidoColision();
            }
        }

        // Verifica si la pelota esta en la segunda mitad izquierda de la barra
        if (pelota.getX() >= x + ancho/3 && pelota.getX() < x + ancho/2) {

            // Si la pelota esta en el rango de la barra y ademas choca con su parte superior
            // entonces se cambia la direccion de la pelota
            if (pelota.getY() + pelota.getRadio() >= y) {
                //Esto es para evitar errores a la hora de hacer el choque
                pelota.setPosicionY(y - pelota.getRadio() - 1);

                anguloRandom = -(Math.PI/2 + Math.random() * (2*(Math.PI/3) - Math.PI/2)) ; //limiteInferior + rand() % (limiteSuperior-limiteInferior)
                pelota.setDireccion(anguloRandom);
                ladrillos.reiniciarContadorLadrillosRotos();
                coleccionSonidos.reproducirSonidoColision();
            }
        }

        // Verifica si la pelota esta en la mitad de la barra
        if (pelota.getX() == x + ancho/2) {
            if (pelota.getY() + pelota.getRadio() >= y) {
                //Esto es para evitar errores a la hora de hacer el choque
                pelota.setPosicionY(y - pelota.getRadio() - 1);

                anguloRandom = -Math.PI/2;
                pelota.setDireccion(anguloRandom);
                ladrillos.reiniciarContadorLadrillosRotos();
                coleccionSonidos.reproducirSonidoColision();
            }
        }

        // Verifica si la pelota esta en la primera mitad derecha de la barra
        if (pelota.getX() > x + ancho/2 && pelota.getX() <= x + 2*(ancho/3)) {

            // Si la pelota esta en el rango de la barra y ademas choca con su parte superior
            // entonces se cambia la direccion de la pelota
            if (pelota.getY() + pelota.getRadio() >= y) {
                //Esto es para evitar errores a la hora de hacer el choque
                pelota.setPosicionY(y - pelota.getRadio() - 1);

                anguloRandom = -(Math.PI/3 + Math.random() * (Math.PI/2 - Math.PI/3)) ; //limiteInferior + rand() % (limiteSuperior-limiteInferior)
                pelota.setDireccion(anguloRandom);
                ladrillos.reiniciarContadorLadrillosRotos();
                coleccionSonidos.reproducirSonidoColision();
            }
        }

        // Verifica si la pelota esta en la segunda mitad derecha de la barra
        if (pelota.getX() > x + 2*(ancho/3) && pelota.getX() <= x + ancho) {

            // Si la pelota esta en el rango de la barra y ademas choca con su parte superior
            // entonces se cambia la direccion de la pelota
            if (pelota.getY() + pelota.getRadio() >= y) {
                //Esto es para evitar errores a la hora de hacer el choque
                pelota.setPosicionY(y - pelota.getRadio() - 1);

                anguloRandom = -(Math.PI/6 + Math.random() * (Math.PI/3 - Math.PI/6) ); //limiteInferior + rand() % (limiteSuperior-limiteInferior)
                pelota.setDireccion(anguloRandom);
                ladrillos.reiniciarContadorLadrillosRotos();
                coleccionSonidos.reproducirSonidoColision();
            }
        }
        // Verifica si la posicion en x de la pelota esta por fuera del lado derecho
        if (pelota.getX() > x + ancho) {
            // Si la posicion en x de la pelota esta por fuera del lado derecho de la barra entonces
            // verifica si el radio de la pelota toca la barra
            if (pelota.getX() - pelota.getRadio() <= x + ancho) {
                // Si la pelota esta en el rango de la barra y ademas choca con su parte superior
                // entonces se cambia la direccion de la pelota
                if (pelota.getY() + pelota.getRadio() >= y) {
                    //Esto es para evitar errores a la hora de hacer el choque
                    pelota.setPosicionY(y - pelota.getRadio() - 1);

                    anguloRandom = -(Math.PI/6 + Math.random() * (Math.PI/3 - Math.PI/6) ); //limiteInferior + rand() % (limiteSuperior-limiteInferior)
                    pelota.setDireccion(anguloRandom);
                    ladrillos.reiniciarContadorLadrillosRotos();
                    coleccionSonidos.reproducirSonidoColision();
                }
            }
        }

        // Si la pelota pasa por debajo de la barra se considera imposible que pueda rebotar
        // hacia arriba. Por lo tanto, se pierde una vida
        if (pelota.getY() >= y) {
            pelota.reiniciarPosicion();
            juego.perderVida();
            ladrillos.reiniciarContadorLadrillosRotos();
            coleccionSonidos.reproducirSonidoPerderVida();
        }
    }

    public void disminuirAncho() {
        if (vecesAnchoCambiado <= 5) {
            ancho -= 5;
            vecesAnchoCambiado++;
        }
    }

    public void colocarAnchoOriginal() {
        ancho = anchoOriginal;
    }
}

