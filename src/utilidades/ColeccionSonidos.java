package utilidades;

public class ColeccionSonidos {
    private Sonido cancionGameOver;
    private Sonido efectoSeleccion;
    private Sonido efectoDestruccion;
    private Sonido sonidoColision;
    private Sonido sonidoPerderVida;
    private Sonido cancionMenuPausa;
    private Sonido cancionMenuPrincipal;
    private Sonido cancionNuevoNivel;
    private Sonido cancionNivel1;
    private Sonido cancionNivel2;
    private Sonido cancionNivel3;
    private Sonido cancionNivel4;
    private Sonido cancionNivel5;


    public ColeccionSonidos() {
        cancionGameOver = new Sonido();
        cancionGameOver.cargarSonido("/sonidos/CancionGameOver.wav");
        efectoSeleccion = new Sonido();
        efectoSeleccion.cargarSonido("/sonidos/EfectoSeleccion.wav");
        sonidoColision = new Sonido();
        sonidoColision.cargarSonido("/sonidos/EfectoColision.wav");
        sonidoPerderVida = new Sonido();
        sonidoPerderVida.cargarSonido("/sonidos/PerderVida.wav");
        cancionMenuPausa = new Sonido();
        cancionMenuPausa.cargarSonido("/sonidos/CancionMenuPausa.wav");
        cancionMenuPrincipal = new Sonido();
        cancionMenuPrincipal.cargarSonido("/sonidos/CancionMenuPrincipal.wav");
        efectoDestruccion = new Sonido();
        efectoDestruccion.cargarSonido("/sonidos/EfectoDestruccion.wav");
        cancionNuevoNivel = new Sonido();
        cancionNuevoNivel.cargarSonido("/sonidos/CancionNuevoNivel.wav");
        cancionNivel1 = new Sonido();
        cancionNivel1.cargarSonido("/sonidos/CancionJuego.wav");
        cancionNivel2 = new Sonido();
        cancionNivel2.cargarSonido("/sonidos/CancionJuego2.wav");
        cancionNivel3 = new Sonido();
        cancionNivel3.cargarSonido("/sonidos/CancionJuego3.wav");
        cancionNivel4 = new Sonido();
        cancionNivel4.cargarSonido("/sonidos/CancionJuego4.wav");
        cancionNivel5 = new Sonido();
        cancionNivel5.cargarSonido("/sonidos/CancionJuego5.wav");
    }

    public void reproducirCancionGameOver() {
        cancionGameOver.reproducirEnBucle();
    }

    public void reproducirCancionNuevoNivel() {
        cancionNuevoNivel.reproducir();
    }

    public void reproducirCancionJuego(int nivel) {
        switch (nivel) {
            case 1:
                cancionNivel1.reproducir();
                break;
            case 2:
                cancionNivel2.reproducir();
                break;
            case 3:
                cancionNivel3.reproducir();
                break;
            case 4:
                cancionNivel4.reproducir();
                break;
            case 5:
                cancionNivel5.reproducir();
                break;
        }
    }

    public void reproducirCancionMenuPrincipal() {
        cancionMenuPrincipal.reproducirEnBucle();
    }

    public void reproducirCancionMenuPausa() {
        cancionMenuPausa.reproducirEnBucle();
    }

    public void reproducirEfectoSeleccion() {
        efectoSeleccion.reproducir();
    }

    public void reproducirSonidoColision() {
        sonidoColision.reproducir();
    }

    public void reproducirSonidoPerderVida() {
        sonidoPerderVida.reproducir();
    }

    public void detenerCancionNuevoNivel() {
        cancionNuevoNivel.detener();
    }

    public void detenerCancionGameOver() {
        cancionGameOver.detener();
    }

    public void detenerCancionMenuPausa() {
        cancionMenuPausa.detener();
    }

    public void detenerCancionMenuPrincipal() {
        cancionMenuPrincipal.detener();
    }

    public void detenerCancionJuego(int nivel) {
        switch (nivel) {
            case 1:
                cancionNivel1.detener();
                break;
            case 2:
                cancionNivel2.detener();
                break;
            case 3:
                cancionNivel3.detener();
                break;
            case 4:
                cancionNivel4.detener();
                break;
            case 5:
                cancionNivel5.detener();
                break;
        }
    }

    public void reanudarCancionJuego(int nivel) {
        switch (nivel) {
            case 1:
                cancionNivel1.reanudar();
                break;
            case 2:
                cancionNivel2.reanudar();
                break;
            case 3:
                cancionNivel3.reanudar();
                break;
            case 4:
                cancionNivel4.reanudar();
                break;
            case 5:
                cancionNivel5.reanudar();
                break;
        }
    }
}