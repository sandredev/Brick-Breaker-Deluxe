package modelo;

public class ArrayLadrillos {
    Ladrillo[][] ladrillos;
    int filasArrayLadrillos;
    int columnasArrayLadrillos;
    private int contadorLadrillosRotos = 0;
    public void setFilasArrayLadrillos(int filasArrayLadrillos) {
        this.filasArrayLadrillos = filasArrayLadrillos;
    }

    public ArrayLadrillos(int filasArrayLadrillos, int columnasArrayLadrillos) {
        ladrillos = new Ladrillo[filasArrayLadrillos][columnasArrayLadrillos];
        this.filasArrayLadrillos = filasArrayLadrillos;
        this.columnasArrayLadrillos = columnasArrayLadrillos;
        for (int i = 0; i < filasArrayLadrillos; i++) {
            for (int j = 0; j < columnasArrayLadrillos; j++) {
                Ladrillo ladrilloAux = new Ladrillo(j * 45,i * 40 + 100, 45, 40, 2);
                ladrillos[i][j] = ladrilloAux;
            }
        }
    }

    private void generarNivel1() {
        for (int i = 0; i < filasArrayLadrillos; i++) {
            for (int j = 0; j < columnasArrayLadrillos; j++) {
                if ((j == 1 || j == 8) && i == 1) {
                    ladrillos[i][j].setResistencia(3);
                    ladrillos[i][j].setTipo(2);
                }
                else {
                    ladrillos[i][j].setResistencia(2);
                    ladrillos[i][j].setTipo(1);
                }
                if (i <= filasArrayLadrillos - 1 && i >= filasArrayLadrillos - 3)  {
                    ladrillos[i][j].setResistencia(0);
                    ladrillos[i][j].setTipo(0);
                }
            }
        }
    }

    private void generarNivel2() {
        for (int i = 0; i < filasArrayLadrillos; i++) {
            for (int j = 0; j < columnasArrayLadrillos; j++) {
                if (i == 0) {
                    if (j == 2 || j == 7) {
                        ladrillos[i][j].setResistencia(3);
                        ladrillos[i][j].setTipo(2);
                    }
                }
                if (i == 1) {
                    if (j >= 3 && j <= 6) {
                        ladrillos[i][j].setResistencia(3);
                        ladrillos[i][j].setTipo(2);
                    }
                }
                if (i == 2) {
                    if (j == 2 || j == 4 || j == 5 || j == 7) {
                        ladrillos[i][j].setResistencia(3);
                        ladrillos[i][j].setTipo(2);
                    }
                    if (j == 3 || j == 6) {
                        ladrillos[i][j].setResistencia(2);
                        ladrillos[i][j].setTipo(1);
                    }
                }
                if (i == 3) {
                    if (j == 1 || (j >= 3 && j <= 6) || j == 8) {
                        ladrillos[i][j].setResistencia(3);
                        ladrillos[i][j].setTipo(2);
                    }
                }
                if (i == 4) {
                    if (j >= 3 && j <= 6) {
                        ladrillos[i][j].setResistencia(3);
                        ladrillos[i][j].setTipo(2);
                    }
                }
                if (i == 5) {
                    if (j == 2 || j == 3 || j == 6 || j == 7) {
                        ladrillos[i][j].setResistencia(3);
                        ladrillos[i][j].setTipo(2);
                    }
                }
            }
        }
    }

    private void generarNivel3() {
        for (int i = 0; i < filasArrayLadrillos; i++) {
            for (int j = 0; j < columnasArrayLadrillos; j++) {
                if (j == 1 && i >= 1 && i <= 4) {
                    ladrillos[i][j].setResistencia(1);
                    ladrillos[i][j].setTipo(3);
                }
                if (j == 8 && i <=4 && i >= 1) {
                    ladrillos[i][j].setResistencia(1);
                    ladrillos[i][j].setTipo(3);
                }
                if (i == 5 && j >= 1 && j <= 8) {
                    ladrillos[i][j].setResistencia(1);
                    ladrillos[i][j].setTipo(3);
                }
                if (j >= 2 && j <= 7 && i >= 1 && i <= 4) {
                    if (j % 2 == 0) {
                        ladrillos[i][j].setResistencia(3);
                        ladrillos[i][j].setTipo(2);
                    }
                    else {
                        ladrillos[i][j].setResistencia(2);
                        ladrillos[i][j].setTipo(1);
                    }
                }
            }
        }
    }

    private void generarNivel4() {
        for (int i = 0; i < filasArrayLadrillos; i++) {
            for (int j = 0; j < columnasArrayLadrillos; j++) {
                if (j % 2 == 0 && j <= 2) {
                    if (i % 2 == 0) {
                        ladrillos[i][j].setResistencia(3);
                        ladrillos[i][j].setTipo(2);
                    }
                    else {
                        ladrillos[i][j].setResistencia(1);
                        ladrillos[i][j].setTipo(3);
                    }
                }
                else if (j % 2 == 1 && j >= 7) {
                    if (i % 2 == 0) {
                        ladrillos[i][j].setResistencia(3);
                        ladrillos[i][j].setTipo(2);
                    }
                    else {
                        ladrillos[i][j].setResistencia(1);
                        ladrillos[i][j].setTipo(3);
                    }
                }
                else if (j == 4 || j == 5) {
                    if (i % 2 == 0 && j == 4) {
                        ladrillos[i][j].setResistencia(2);
                        ladrillos[i][j].setTipo(1);
                    }
                    else if (i % 2 != 0 && j == 4) {
                        ladrillos[i][j].setResistencia(3);
                        ladrillos[i][j].setTipo(2);
                    }
                    else if (i % 2 == 0 && j == 5) {
                        ladrillos[i][j].setResistencia(2);
                        ladrillos[i][j].setTipo(1);
                    }
                    else if (i % 2 != 0 && j == 5) {
                        ladrillos[i][j].setResistencia(3);
                        ladrillos[i][j].setTipo(2);
                    }
                }
                else {
                    ladrillos[i][j].setResistencia(0);
                    ladrillos[i][j].setTipo(0);
                }
            }
        }
    }

    private void generarNivel5() {
        for (int i = 0; i < filasArrayLadrillos; i++) {
            for (int j = 0; j < columnasArrayLadrillos; j++) {
                if (i == filasArrayLadrillos - 1) {
                    if (j != 4 && j != 5) {
                        ladrillos[i][j].setResistencia(1);
                        ladrillos[i][j].setTipo(3);
                    }
                    else {
                        ladrillos[i][j].setResistencia(0);
                        ladrillos[i][j].setTipo(0);
                    }
                }
                if (i % 2 == 0) {
                    ladrillos[i][j].setResistencia(2);
                    ladrillos[i][j].setTipo(1);
                }
                else if (i % 2 != 0 && i != filasArrayLadrillos - 1) {
                    ladrillos[i][j].setResistencia(3);
                    ladrillos[i][j].setTipo(2);
                }
            }
        }
    }

    public void generarNiveles(int nivel) {
        switch (nivel) {
            case 1:
                generarNivel1();
                break;
            case 2:
                generarNivel2();
                break;
            case 3:
                generarNivel3();
                break;
            case 4:
                generarNivel4();
                break;
            case 5:
                generarNivel5();
                break;
        }
    }

    public int cantidadLadrillosNivel() {
        int cantidadLadrillos = 0;
        for (int i = 0; i < filasArrayLadrillos; i++) {
            for (int j = 0; j < columnasArrayLadrillos; j++) {
                if (ladrillos[i][j].getTipo() > 0 && ladrillos[i][j].getTipo() <= 2 &&
                        ladrillos[i][j].getResistencia() >0) {
                    cantidadLadrillos++;
                }
            }
        }
        return cantidadLadrillos;
    }

    public void destruirLadrillos() {
        for (int i = 0; i < filasArrayLadrillos; i++) {
            for (int j = 0; j < columnasArrayLadrillos; j++) {
                ladrillos[i][j].setResistencia(0);
                ladrillos[i][j].setTipo(0);
            }
        }
    }
    public void verificarColisiones(Pelota pelota, Juego juego) {
        for (int i = 0; i < filasArrayLadrillos; i++) {
            for (int j = 0; j < columnasArrayLadrillos; j++) {

                // Controla las colisiones de la pelota y los ladrillos y
                // retorna TRUE si la pelota choca con el ladrillo
                if (ladrillos[i][j].verificarColision(pelota)){
                    if (ladrillos[i][j].getTipo() != 3) {
                        ladrillos[i][j].romperLadrillo();
                    }
                    if (ladrillos[i][j].getResistencia() <= 0) {
                        juego.ladrilloRoto();
                    }
                    contadorLadrillosRotos++;
                    if  (ladrillos[i][j].getTipo() != 3) {
                        juego.aumentarPuntuacion(contadorLadrillosRotos);
                    }
                }
            }
        }
    }

    public int getFilasArrayLadrillos() {
        return filasArrayLadrillos;
    }

    public int getColumnasArrayLadrillos() {
        return columnasArrayLadrillos;
    }

    public Ladrillo getLadrillo(int fila, int columna) {
        return ladrillos[fila][columna];
    }

    public void reiniciarContadorLadrillosRotos() {
        contadorLadrillosRotos = 0;
    }
}
