package modelo;

import vista.juego.PanelLadrillos;

public class Juego {
    private int nivel;
    private int vidas;
    private int vidasPerdidas = 0;
    private int cantidadLadrillosEnNivel;
    private int puntuacion = 0;

    public Juego(int nivel, int vidas, int cantidadLadrillosEnNivel) {
        this.nivel = nivel;
        this.vidas = vidas;
        this.cantidadLadrillosEnNivel = cantidadLadrillosEnNivel;
    }

    public boolean juegoTerminado() {
        return vidas == 0;
    }

    public int getNivel() {
        return nivel;
    }

    public void pasarDeNivel() {
        nivel++;
    }

    public void perderVida() {
        vidas--;
        vidasPerdidas++;
    }

    public int getVidas() {
        return vidas;
    }

    public void aumentarPuntuacion(int escalar) {
        puntuacion += 20 * escalar;
    }

    public boolean nivelCompletado() {
        return cantidadLadrillosEnNivel == 0;
    }

    public int getPuntuacion() {
        return puntuacion;
    }

    public void ladrilloRoto() {
        cantidadLadrillosEnNivel--;
    }

    public void reiniciarJuego() {
        vidas = 3;
        nivel = 1;
        puntuacion = 0;
        vidasPerdidas = 0;
    }

    public int getCantidadLadrillosEnNivel() {
        return cantidadLadrillosEnNivel;
    }

    public void setCantidadLadrillosEnNivel(int cantidadLadrillosEnNivel) {
        this.cantidadLadrillosEnNivel = cantidadLadrillosEnNivel;
    }

    public void aumentarVida() {
        vidas++;
    }

    public int getVidasPerdidas() {
        return vidasPerdidas;
    }
}
