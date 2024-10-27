package modelo;

import utilidades.Sonido;

public class Pelota {
    private double x, y; // Posicion de la pelota (usando double para mayor precision)
    private double velocidad; // Magnitud de la velocidad
    private double velocidadOriginal; // Almacena la primera velocidad ingresada en la pelota (util para reinicios)
    private double angulo; // Angulo en radianes que indica la direccion de la pelota
    private int radio; // Radio de la pelota
    private int anchoPanel, altoPanel; // Dimensiones del area de dibujo
    private Sonido sonidoColision = new Sonido();
    private int vecesVelocidadIncrementada = 0;

    public Pelota(int x, int y, int radio, double velocidad, double angulo, int anchoPanel, int altoPanel) {
        this.x = x;
        this.y = y;
        this.radio = radio;
        this.velocidad = velocidad;
        velocidadOriginal = velocidad;
        this.angulo = angulo;
        this.anchoPanel = anchoPanel;
        this.altoPanel = altoPanel;
        sonidoColision.cargarSonido("/sonidos/EfectoColision.wav");
    }

    // Metodo para mover la pelota
    public boolean mover() {
        // Calcular las componentes de la velocidad en X e Y usando trigonometría
        x += velocidad * Math.cos(angulo);
        y += velocidad * Math.sin(angulo);
        // Detectar los bordes y cambiar la direccion si es necesario
        if (x - radio <= 0 || x + radio >= anchoPanel) {
            // Reflejar el angulo horizontalmente
            angulo = Math.PI - angulo;
            sonidoColision.reproducir();

            // Control de errores
            if (x + radio >= anchoPanel) {
                x = (anchoPanel - 1) - radio;
            }
            else if (x - radio <= 0) {
                x = 1 + radio;
            }
            return true;
        }
        if (y - radio <= 0) {
            // Reflejar el angulo verticalmente
            y = 1 + radio;
            angulo = -angulo;
            sonidoColision.reproducir();
            return true;
        }
        // Si la pelota toca el borde inferior de la pantalla se reinicia su posicion
        else if (y + radio >= altoPanel) {
            x = anchoPanel/2;
            y = radio+10;
            return true;
        }
        return false;
    }

    // Metodos getter
    public int getX() {
        return (int)x;
    }

    public int getY() {
        return (int)y;
    }

    public int getRadio() {
        return radio;
    }

    public double getVelocidad() {
        return velocidad;
    }

    public double getAngulo() {
        return angulo;
    }

    public void cambiarDireccionX() {
        // El angulo se cambia de direccion con una pequeña variacion para evitar bucles infinitos en algunos casos
        angulo = Math.PI - ((angulo-0.05) + Math.random() * ((angulo+0.05)-(angulo-0.05))); //limiteInferior + rand() % (limiteSuperior-limiteInferior);
    }

    // El angulo se cambia de direccion con una pequeña variacion para evitar bucles infinitos en algunos casos
    public void cambiarDireccionY() {
        angulo = -((angulo-0.1) + Math.random() * ((angulo+0.1)-(angulo-0.1)));
    }

    public void setDireccion(double angulo) { this.angulo = angulo; }

    public void reiniciarPosicion() {
        x = anchoPanel/2 - radio;
        y = radio+371;
        angulo = Math.PI/2;
    }

    public void setPosicionY(double y) {
        this.y = y;
    }

    public void setPosicionX(double x) {this.x = x; }

    public void incrementarVelocidad() {
        if (vecesVelocidadIncrementada <= 5) {
            velocidad += 0.4;
            vecesVelocidadIncrementada++;
        }

    }

    public void colocarVelocidadOriginal() {
        velocidad = velocidadOriginal;
    }
}