package modelo;

import utilidades.Sonido;

public class Ladrillo {
    private int x, y; // Posicion del ladrillo en el panel
    private int ancho, alto; // Dimensiones del ladrillo en el panel
    private int resistencia; // Nivel de resistencia del ladrillo (0 = roto, 1 = casi roto, 2 = sin tocar)
    private Sonido sonidoDestruccion = new Sonido(); // Sonido de destruccion del ladrillo
    private int tipo; // Numero que indica el tipo de ladrillo que es

    public Ladrillo(int x, int y, int ancho, int alto, int tipo) {
        this.x = x;
        this.y = y;
        this.ancho = ancho;
        this.alto = alto;
        if (tipo == 1) {
            resistencia = 2;
        }
        else if (tipo == 2) {
            resistencia = 3;
        }
        this.tipo = tipo;
        sonidoDestruccion.cargarSonido("/sonidos/EfectoDestruccion.wav");
    }

    public void romperLadrillo() {
        if (resistencia != 0) {
            resistencia--;
        }
    }

    public int getResistencia() {
        return resistencia;
    }

    public void setResistencia(int resistencia) {
        this.resistencia = resistencia;
    }

    public int getX() {
        return x;
    }

    public void setX(int x) {
        this.x = x;
    }

    public int getY() {
        return y;
    }

    public void setY(int y) {
        this.y = y;
    }

    public int getAncho() {
        return ancho;
    }

    public int getAlto() {
        return alto;
    }

    public boolean verificarColision(Pelota pelota) {
        if (resistencia == 0) {
            // Si el ladrillo no tiene resistencia (esta roto) entonces la pelota no puede colisionar con el)
            return false;
        }

        // Se evalua si la pelota esta atras del lado izquierdo del ladrillo
        if (pelota.getX() < x) {
            // El radio de la pelota choca con la esquina superior izquierda del ladrillo
            if (pelota.getX() + pelota.getRadio() >= x && pelota.getY() < y &&
                    pelota.getY() + pelota.getRadio() >= y) {
                pelota.cambiarDireccionX();

                // Esta instruccion es para evitar errores en las colisiones
                // Coloca a la pelota en una posicion en la cual no quede atrapada en el ladrillo
                pelota.setPosicionX(x - pelota.getRadio() - 1);

                sonidoDestruccion.reproducir();
                return true;
            }
            // El radio de la pelota choca con la esquina inferior izquierda del ladrillo
            else if (pelota.getX() + pelota.getRadio() >= x && pelota.getY() > y + alto &&
                    pelota.getY() - pelota.getRadio() <= y + alto) {
                pelota.cambiarDireccionX();

                // Esta instruccion es para evitar errores en las colisiones
                // Coloca a la pelota en una posicion en la cual no quede atrapada en el ladrillo
                pelota.setPosicionX(x - pelota.getRadio() - 1);

                sonidoDestruccion.reproducir();
                return true;
            }
            // El radio de la pelota choca con el lado izquierdo del ladrillo
            if (pelota.getX() + pelota.getRadio() >= x && pelota.getY() >= y && pelota.getY() <= y + alto) {
                pelota.cambiarDireccionX();

                // Esta instruccion es para evitar errores en las colisiones
                // Coloca a la pelota en una posicion en la cual no quede atrapada en el ladrillo
                pelota.setPosicionX(x - pelota.getRadio() - 1);

                sonidoDestruccion.reproducir();
                return true;
            }
        }

        // Se evalua si la pelota esta dentro del rango en x del ladrillo
        if (pelota.getX() >= x && pelota.getX()  <= x + ancho) {

            // Se verifica si la pelota golpea al ladrillo desde arriba
            if (pelota.getY() + pelota.getRadio() >= y && pelota.getY() < y) {
                pelota.cambiarDireccionY();

                // Esta instruccion es para evitar errores en las colisiones
                // Coloca a la pelota en una posicion en la cual no quede atrapada en el ladrillo
                pelota.setPosicionY(y - pelota.getRadio() - 1);

                sonidoDestruccion.reproducir();
                return true;
            }

            // Se verifica si la pelota golpea al ladrillo desde abajo
            if (pelota.getY() - pelota.getRadio() <= y + alto && pelota.getY() > y + alto) {
                pelota.cambiarDireccionY();
                sonidoDestruccion.reproducir();

                // Esta instruccion es para evitar errores en las colisiones
                // Coloca a la pelota en una posicion en la cual no quede atrapada en el ladrillo
                pelota.setPosicionY(y + alto + pelota.getRadio() + 1);

                return true;
            }
        }

        // Se evalua si la pelota esta atras del lado izquierdo del ladrillo
        if (pelota.getX() > x + ancho) {

            // El radio de la pelota choca con la esquina superior derecha del ladrillo
            if (pelota.getX() - pelota.getRadio() <= x + ancho && pelota.getY() < y &&
                    pelota.getY() + pelota.getRadio() >= y) {
                pelota.cambiarDireccionX();

                // Esta instruccion es para evitar errores en las colisiones
                // Coloca a la pelota en una posicion en la cual no quede atrapada en el ladrillo
                pelota.setPosicionX(x + ancho + pelota.getRadio() + 1);

                sonidoDestruccion.reproducir();
                return true;
            }
            // El radio de la pelota choca con la esquina inferior derecha del ladrillo
            else if (pelota.getX() - pelota.getRadio() <= x + ancho && pelota.getY() > y + alto &&
                    pelota.getY() - pelota.getRadio() <= y + alto) {
                pelota.cambiarDireccionX();

                // Esta instruccion es para evitar errores en las colisiones
                // Coloca a la pelota en una posicion en la cual no quede atrapada en el ladrillo
                pelota.setPosicionX(x + ancho + pelota.getRadio() + 1);

                sonidoDestruccion.reproducir();
                return true;
            }
            // El radio de la pelota choca con el lado izquierdo del ladrillo
            if (pelota.getX() - pelota.getRadio() <= x + ancho && pelota.getY() >= y && pelota.getY() <= y + alto) {
                pelota.cambiarDireccionX();

                // Esta instruccion es para evitar errores en las colisiones
                // Coloca a la pelota en una posicion en la cual no quede atrapada en el ladrillo
                pelota.setPosicionX(x + ancho + pelota.getRadio() + 1);

                sonidoDestruccion.reproducir();
                return true;
            }
        }


        // Si en ningun momento la pelota colisiona con el ladrillo retorna false
        return false;
    }

    public void setTipo(int tipo) {
        this.tipo = tipo;
    }

    public int getTipo() {
        return tipo;
    }
}
