/*
2. Crear una superclase llamada Edificio con los siguientes atributos: ancho, alto y largo. La clase
edificio tendrá como métodos:
• Método calcularSuperficie(): calcula la superficie del edificio.
• Método calcularVolumen(): calcula el volumen del edifico.
Estos métodos serán abstractos y los implementarán las siguientes clases:
• Clase Polideportivo con su nombre y tipo de instalación que puede ser Techado o
Abierto, esta clase implementará los dos métodos abstractos y los atributos del padre.
• Clase EdificioDeOficinas con sus atributos número de oficinas, cantidad de personas
por oficina y número de pisos. Esta clase implementará los dos métodos abstractos y
los atributos del padre.
De esta clase nos interesa saber cuántas personas pueden trabajar en todo el edificio, el
usuario dirá cuántas personas entran en cada oficina, cuantas oficinas y el número de piso
(suponiendo que en cada piso hay una oficina). Crear el método cantPersonas(), que muestre
cuantas personas entrarían en un piso y cuantas en todo el edificio.
Por último, en el main vamos a crear un ArrayList de tipo Edificio. El ArrayList debe contener
dos polideportivos y dos edificios de oficinas. Luego, recorrer este array y ejecutar los
métodos calcularSuperficie y calcularVolumen en cada Edificio. Se deberá mostrar la
superficie y el volumen de cada edificio.
Además de esto, para la clase Polideportivo nos interesa saber cuántos polideportivos son
techados y cuantos abiertos. Y para la clase EdificioDeOficinas deberemos llamar al método
cantPersonas() y mostrar los resultados de cada edificio de oficinas.
 */
package service;

import entity.Edificio;
import entity.EdificioDeOficinas;
import entity.Polideportivo;
import java.util.Scanner;

/**
 *
 * @author Max
 */
public class EdificioServicio {
    
    Scanner input = new Scanner(System.in).useDelimiter("\n");
    
    public Edificio crearEdificio() {
        System.out.println("Ingrese tipo de edificio a crear(Polideportivo/Oficinas): ");
        String orden = input.next().toUpperCase();
        Edificio edif= null;
        switch (orden) {
            case "POLIDEPORTIVO":
                System.out.println("Creando polideportivo...");
                Polideportivo poli = new Polideportivo();
                System.out.println("Ingrese el nombre del polideportivo");
                poli.setNombre(input.next());  
                System.out.println("El polideportivo es techado? S/N");
                if (input.next().equalsIgnoreCase("S")) {
                    poli.setTecho(true);
                }
                poli.calcularSuperficie();
                poli.calcularVolumen();
                break;
            
            case "OFICINAS":
                System.out.println("Creando edificio de oficinas...");
                EdificioDeOficinas ofice = new EdificioDeOficinas();
                System.out.println("Ingrese numero de oficinas por piso");
                ofice.setNumeroOficinas(input.nextInt());
                System.out.println("Ingrese cantidad de personas que habrá por oficina");
                ofice.setpersonasPorOficina(input.nextInt());
                System.out.println("Ingrese numero de pisos del edificio");
                ofice.setNumeroPisos(input.nextInt());
                ofice.calcularSuperficie();
                ofice.calcularVolumen();
                break;
        }
        return edif;
        
    }


}
