package tresenraya;

import java.util.Scanner;

public class TresEnRaya {

    public static void main(String[] args) {

        System.out.println("TRES EN RAYA");
        System.out.println("Reglas del 3 en raya");
        System.out.println("Tienes que moverte entre las 9 posiciones hasta hacer 3 posciones seguidas de tu misma ficha.");

        String tablero[][] = new String[3][3];

        tablero[0][0] = "-";
        tablero[0][1] = "-";
        tablero[0][2] = "-";

        tablero[1][0] = "-";
        tablero[1][1] = "-";
        tablero[1][2] = "-";

        tablero[2][0] = "-";
        tablero[2][1] = "-";
        tablero[2][2] = "-";

        boolean turnoJugador = true; //true=jugador1, false=jugador2

        int turno = 1;

        do {

            mostrarTablero(tablero);
            System.out.println("se ha salido de printar tablero 1º");
            
            System.out.println("Jugador " +turnoJugador+ " Realiza tu movimiento: introduce un número del 1 al 9");

            movimientoJugadores(tablero, turnoJugador);
            System.out.println("se ha salido de movimientojugadores");

            mostrarTablero(tablero);
            System.out.println("se ha salido de printar tablero 2º");

            turnoJugador = cambioJugadores(turnoJugador); //corregir sin argumento
            System.out.println("salido de cambioJugadores");

            //corregir para no mostrar tablero 2 veces seguidas. jugada+tablero+cambioturno
            turno++;
            System.out.println("el turno es: " + turno + "y turno jugador es: " + turnoJugador);

        } while (turno < 10); 

    }

    public static void mostrarTablero(String[][] tablero) {

        for (int fila = 0; fila < tablero.length; fila++) {
            System.out.println();
            for (int columna = 0; columna < tablero[0].length; columna++) {
                System.out.print(tablero[fila][columna] + " ");
            }
        }
        System.out.println(); //revisar como poner linea en un mismo log y tener SOLO UN LOG en esta funcion
        System.out.println("se ha ejecutado el mostrarTablero");

    }

    public static void movimientoJugadores(String[][] tablero, boolean turnoJugador) {
        
        Scanner entrada = new Scanner(System.in);
        int movimiento = entrada.nextInt();
        System.out.println("se ha entrado en movimientoJugadores");

        //todo esto corregir en dos fors. como pintar tablero 
        switch (movimiento) {
            case 1:
                if ("-".equals(tablero[0][0]) && turnoJugador == true) {

                    tablero[0][0] = "X";

                } else if ("-".equals(tablero[0][0]) && turnoJugador == false) {

                    tablero[0][0] = "O";
                } else {

                    System.out.println("Posición ocupada");
                }
                break;
            case 2:
                if ("-".equals(tablero[0][1]) && turnoJugador == true) {

                    tablero[0][1] = "X";

                } else if ("-".equals(tablero[0][1]) && turnoJugador == false) {

                    tablero[0][1] = "O";
                } else {

                    System.out.println("Posición ocupada");
                }
                break;
            case 3:
                if ("-".equals(tablero[0][2]) && turnoJugador == true) {

                    tablero[0][2] = "X";

                } else if ("-".equals(tablero[0][2]) && turnoJugador == false) {

                    tablero[0][2] = "O";
                } else {

                    System.out.println("Posición ocupada");
                }
                break;
            case 4:
                if ("-".equals(tablero[1][0]) && turnoJugador == true) {

                    tablero[1][0] = "X";

                } else if ("-".equals(tablero[1][0]) && turnoJugador == false) {

                    tablero[1][0] = "O";
                } else {

                    System.out.println("Posición ocupada");
                }
                break;
            case 5:
                if ("-".equals(tablero[1][1]) && turnoJugador == true) {

                    tablero[1][1] = "X";

                } else if ("-".equals(tablero[1][1]) && turnoJugador == false) {

                    tablero[1][1] = "O";
                } else {

                    System.out.println("Posición ocupada");
                }
                break;
            case 6:
                if ("-".equals(tablero[1][2]) && turnoJugador == true) {

                    tablero[1][2] = "X";

                } else if ("-".equals(tablero[1][2]) && turnoJugador == false) {

                    tablero[1][2] = "O";
                } else {

                    System.out.println("Posición ocupada");
                }
                break;
            case 7:
                if ("-".equals(tablero[2][0]) && turnoJugador == true) {

                    tablero[2][0] = "X";

                } else if ("-".equals(tablero[2][0]) && turnoJugador == false) {

                    tablero[2][0] = "O";
                } else {

                    System.out.println("Posición ocupada");
                }
                break;
            case 8:
                if ("-".equals(tablero[2][1]) && turnoJugador == true) {

                    tablero[2][1] = "X";

                } else if ("-".equals(tablero[2][1]) && turnoJugador == false) {

                    tablero[2][1] = "O";
                } else {

                    System.out.println("Posición ocupada");
                }
                break;
            case 9:
                if ("-".equals(tablero[2][2]) && turnoJugador == true) {

                    tablero[2][2] = "X";

                } else if ("-".equals(tablero[2][2]) && turnoJugador == false) {

                    tablero[2][2] = "O";
                } else {

                    System.out.println("Posición ocupada");
                }
                break;
            default:
                System.out.println("Movimiento no valido");
                break;
        }

    }

    public static boolean cambioJugadores(boolean turnoJugador) {

        if (turnoJugador == true) {

            turnoJugador = false;

        } else {
            turnoJugador = true;

        }

        System.out.println("Retorno " + turnoJugador);

        return turnoJugador;
    }

}




