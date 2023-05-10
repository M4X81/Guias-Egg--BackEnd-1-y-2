/*
2-Juego Ahorcado: Crear una clase Ahorcado (como el juego), la cual deberá contener como atributos, 
un vector con la palabra a buscar, la cantidad de letras encontradas y la cantidad 
jugadas máximas que puede realizar el usuario. Definir los siguientes métodos en AhorcadoService:
Metodo crearJuego(): le pide la palabra al usuario y cantidad de jugadas máxima. 
Con la palabra del usuario, pone la longitud de la palabra, como la longitud del vector. 
Después ingresa la palabra en el vector, letra por letra, quedando cada letra de 
la palabra en un índice del vector. Y también, guarda la cantidad de jugadas máximas 
y el valor que ingresó el usuario.
Método longitud(): muestra la longitud de la palabra que se debe encontrar. 
Nota: buscar como se usa el vector.length.
Método buscar(letra):  este método recibe una letra dada por el usuario y busca 
si la letra ingresada es parte de la palabra o no. También informará si la letra estaba o no.
Método encontradas(letra):  que reciba una letra ingresada por el usuario y muestre 
cuantas letras han sido encontradas y cuántas le faltan. Este método además deberá 
devolver true si la letra estaba y false si la letra no estaba, ya que, cada vez 
que se busque una letra que no esté, se le restará uno a sus oportunidades.
Método intentos(): para mostrar cuántas oportunidades le queda al jugador.
Método juego(): el método juego se encargará de llamar todos los métodos previamente 
mencionados e informará cuando el usuario descubra toda la palabra o se quede sin intentos. 
Este método se llamará en el main.
 */
package service;

import entity.Ahorcado;
import java.util.Scanner;

/**
 *
 * @author Max
 */
public class AhorcadoService {

    Scanner input = new Scanner(System.in).useDelimiter("\n");

    private char[] palabra;
    Ahorcado juegoAhorcado = new Ahorcado();

    /*
    Metodo crearJuego(): le pide la palabra al usuario y cantidad de jugadas máxima. 
Con la palabra del usuario, pone la longitud de la palabra, como la longitud del vector. 
Después ingresa la palabra en el vector, letra por letra, quedando cada letra de 
la palabra en un índice del vector. Y también, guarda la cantidad de jugadas máximas 
y el valor que ingresó el usuario.
     */
    public void crearJuego() {
        System.out.println("Ingrese la palabra a adivinar para comenzar el juego.");
        String palabraJuego = input.nextLine();
        // tomo la palabra ingresada y la cargo en un vector
        palabra = new char[palabraJuego.length()];
        for (int i = 0; i < palabraJuego.length(); i++) {
            palabra[i] = palabraJuego.charAt(i);
        }
        juegoAhorcado.setJugadasMax(palabraJuego.length() );
        System.out.println("La cantidad máxima de intentos será igual al largo de la palabra + 1.");
        System.out.println("Intentos" + juegoAhorcado.getJugadasMax()) ;
    }

    //Método longitud(): muestra la longitud de la palabra que se debe encontrar. 
    public int longitud() {
        int longPalabra = juegoAhorcado.getJugadasMax() ;
        return longPalabra;
    }

    //Método buscar(letra):  este método recibe una letra dada por el usuario y busca 
    //si la letra ingresada es parte de la palabra o no. También informará si la letra estaba o no.
    public boolean buscar() {
        String[] vectorIngresadas = new String[juegoAhorcado.getJugadasMax()];
        boolean encontrada = false;
        int intentos = (juegoAhorcado.getJugadasMax())+1;
       
        do {
            for (int i = 0; i < intentos; i++) {
                System.out.println("Jugador, ingrese la letra.");
                vectorIngresadas[i] = input.next();
                if (vectorIngresadas[i].charAt(0) == palabra[i]) {
                    encontrada = true;
                    intentos--;
                    System.out.println("La letra ingresada está en la palabra.Quedan " + intentos + " intentos.");

                } else {
                    intentos--;
                    System.out.println("La letra no está en la palabra. Quedan " + intentos + " intentos.");
                }
            }

        } while (intentos > 0);
        return encontrada;
    }
    /*
    Método encontradas(letra):  que reciba una letra ingresada por el usuario y muestre 
cuantas letras han sido encontradas y cuántas le faltan. Este método además deberá 
devolver true si la letra estaba y false si la letra no estaba, ya que, cada vez 
que se busque una letra que no esté, se le restará uno a sus oportunidades.
     */
//    public boolean encontradas() {
//
//    }

    //Arrays.binarySearch(ah.getPalabra(), letra)
    /*
    private boolean buscar(String letra) {
        if (Arrays.binarySearch(ah.getPalabra(), letra) >= 0) {
            System.out.println("La letra si esta");
            return true;
        } else {
            System.out.println("La letra " + letra + " no esta");
            return false;
        }
     */
}