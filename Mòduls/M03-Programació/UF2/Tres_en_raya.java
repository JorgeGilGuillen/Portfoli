import java.util.Scanner;

public class Tres_en_raya {
     
    public static final String ANSI_RESET = "\u001B[0m";
    public static final String ANSI_RED = "\u001B[31m";
    public static final String ANSI_BLUE = "\u001B[34m";

    public static void main(String[] args) {

        System.out.println("TRES EN RAYA");
        System.out.println("Reglas del 3 en raya");
        System.out.print("Tienes que moverte entre las 9 posiciones hasta hacer 3 posciones seguidas de tu misma ficha.");

        String tablero[][] = {
            {"-", "-", "-"},
            {"-", "-", "-"},
            {"-", "-", "-"}
        };

        boolean turnoJugador = true; //true=jugador1, false=jugador2

        int turno = 1;

        boolean ganador = false;

        mostrarTablero(tablero);

        do {
            movimientoJugadores(tablero, turnoJugador);
            ganador = comprobarGanador(tablero, turnoJugador);
            mostrarTablero(tablero);
            if (ganador) {
                System.out.println("¡Felicidades! El jugador " + (turnoJugador ? "1" : "2") + " ha ganado");
                break;
            }

            turnoJugador = cambioJugadores(turnoJugador);

            turno++;

        } while (turno < 10);

        if (!ganador) {
            System.out.println("¡Empate!");
        }

        preguntarJugar();

    }

    public static void mostrarTablero(String[][] tablero) {

        for (int fila = 0; fila < tablero.length; fila++) {
            System.out.println();
            for (int columna = 0; columna < tablero[0].length; columna++) {
                System.out.print(tablero[fila][columna] + " ");
            }
        }
        System.out.println();
    }

    public static void movimientoJugadores(String[][] tablero, boolean turnoJugador) {
        Scanner entrada = new Scanner(System.in);
        int movimiento;

        do {
            System.out.println("Jugador " + (turnoJugador ? "1" : "2") + " Realiza tu movimiento: introduce un número del 1 al 9");
            movimiento = entrada.nextInt();

            if (movimiento < 1 || movimiento > 9) {
                System.out.println("Movimiento no válido");
            } else {
                int fila = (movimiento - 1) / 3;
                int columna = (movimiento - 1) % 3;

                if (tablero[fila][columna].equals("-")) {
                    tablero[fila][columna] = turnoJugador ? ANSI_RED + "X" + ANSI_RESET : ANSI_BLUE + "O" + ANSI_RESET;
                    break;
                } else {
                    System.out.println("Posición ocupada, elige otra posición: ");
                }
            }
        } while (true);
    }

    public static boolean cambioJugadores(boolean turnoJugador) {
        /*if (turnoJugador == true) {
            turnoJugador = false;
        } else {
            turno Jugador = true;
        }*/
        turnoJugador = turnoJugador != true;

        return turnoJugador;
    }

    public static boolean comprobarGanador(String[][] tablero, boolean turnoJugador) {

        String ficha = turnoJugador ? ANSI_RED + "X" + ANSI_RESET : ANSI_BLUE + "O" + ANSI_RESET;

        // Comprobar filas
        for (int fila = 0; fila < tablero.length; fila++) {
            if (tablero[fila][0].equals(ficha) && tablero[fila][1].equals(ficha) && tablero[fila][2].equals(ficha)) {
                return true;
            }
        }

        // Comprobar columnas
        for (int columna = 0; columna < tablero[0].length; columna++) {
            if (tablero[0][columna].equals(ficha) && tablero[1][columna].equals(ficha) && tablero[2][columna].equals(ficha)) {
                return true;
            }
        }

        // Comprobar diagonales
        if ((tablero[0][0].equals(ficha) && tablero[1][1].equals(ficha) && tablero[2][2].equals(ficha))
                || (tablero[0][2].equals(ficha) && tablero[1][1].equals(ficha) && tablero[2][0].equals(ficha))) {
            return true;
        }

        // Si no se cumple ninguna de las condiciones anteriores, no hay ganador todavía
        return false;
    }

    public static void preguntarJugar() {

        Scanner sc = new Scanner(System.in);
        String respuesta;

        do {
            System.out.println("¿Quieres volver a jugar? (S/N)");
            respuesta = sc.nextLine();
        } while (!respuesta.equalsIgnoreCase("S") && !respuesta.equalsIgnoreCase("N"));

        if (respuesta.equalsIgnoreCase("S")) {
            // Reiniciar el juego
            main(new String[0]); // Llama a la función "main" para reiniciar el juego, pasando un arreglo de cadenas vacío como argumento.
        } else {
            System.out.println("¡Gracias por jugar!");
        }

    }

}