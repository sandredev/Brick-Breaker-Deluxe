import modelo.*;
import utilidades.ColeccionSonidos;
import vista.*;
import controlador.Controlador;
import vista.juego.*;

public class Main {
    public static void main(String[] args) {
        int ancho = 450;
        int alto = 600;
        int filasArrayLadrillos = 6;
        int columnasArrayLadrillos = 10;


        Pelota pelota = new Pelota(ancho/2 - 15, 386, 15, 6, Math.PI/2, ancho, alto);
        Barra barra = new Barra(ancho/2, 550, 120, 20, ancho);
        ArrayLadrillos ladrillos = new ArrayLadrillos(filasArrayLadrillos, columnasArrayLadrillos);
        Juego juego = new Juego(1, 3, filasArrayLadrillos * columnasArrayLadrillos);

        PanelPelota panelPelota = new PanelPelota(pelota, ancho, alto);
        PanelBarra panelBarra = new PanelBarra(barra, ancho, alto);
        PanelFondo panelFondo = new PanelFondo(ancho, alto);
        PanelLadrillos panelLadrillos = new PanelLadrillos(ancho, alto, ladrillos, ladrillos.getFilasArrayLadrillos(), columnasArrayLadrillos);
        PanelDatosJuego panelDatosJuego = new PanelDatosJuego(juego, ancho, alto);

        // Objeto que divide a los paneles en capas
        LayeredPaneJuego layeredPaneJuego = new LayeredPaneJuego(
                pelota, barra, juego, ladrillos,
                panelPelota, panelDatosJuego, panelFondo,
                panelLadrillos, panelBarra, ancho, alto
        );

        FrameJuego frameJuego = new FrameJuego(ancho, alto, layeredPaneJuego, "Brick Breaker Deluxe");
        ColeccionSonidos cancionMain = new ColeccionSonidos();
        cancionMain.reproducirCancionMenuPrincipal();
        ladrillos.generarNiveles(1);
        Controlador controlador = new Controlador(pelota, barra, panelPelota, ladrillos, juego,
                frameJuego, panelLadrillos, cancionMain);

        frameJuego.getLayeredPaneJuego().setControlador(controlador);
        frameJuego.getLayeredPaneMenu().setControlador(controlador);
        frameJuego.getLayeredMenuGameOver().setControlador(controlador);
        frameJuego.getLayeredPaneMenuPausa().setControlador(controlador);
        frameJuego.getPanelNivel().setControlador(controlador);
    }
}
