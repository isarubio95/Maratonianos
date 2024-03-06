package paquete_1;

import java.util.Collections;
import java.util.Comparator;
import java.util.InputMismatchException;
import java.util.Scanner;

/**
 * @author Isaías Rubio Hernández
 * @version 1.2 05/03/2024
 * @see <a href = "https://github.com/isarubio95/Maratonianos.git">Link al repositorio GitHub</a> 
 * 
 * Sistema de gestión de corredores maratonianos que permite añadir corredores, 
 * ordenarlos por tiempo, aplicar otros métodos de ordenación, crear corredores al azar y salir del programa.
 */
public class Programa {
	
	/**
     * Punto de entrada del programa. Muestra un menú de opciones y realiza acciones basadas en la elección del usuario.
     * 
     * @param args Argumentos pasados a la línea de comandos. No se utilizan en este programa.
     */
	public static void main(String[] args) {
		
		//Mensaje de bienvenida del programa
		System.out.println("\n");
		System.out.println("BIENVENIDDO AL SISTEMA DE GESTIÓN DE CORREDORES MARATONIANOS");
		System.out.println("");
		
		Scanner entrada = new Scanner(System.in); // Instanciación de la clase Scanner
		Corredor instancia = new Corredor(null, 0, 0); // Instanciación de la clase Corredor
		
		boolean ejecutando = true; // Varible booleana para controlar la ejecucución del bucle del menú
		
		while (ejecutando) { // El menú estará ejecutándose hasta que pulsemos la tecla 5
			
			// Texto del menú principal
			System.out.println("¿Qué desea hacer?\n \n1. Añadir corredor \n2. Ordenar corredores por tiempo "
							 + "\n3. Otos métodos de ordenación \n4. Crear 20 corredores al azar \n5. Salir");
			
			// Bloque de código que controla la validez de la opción elegida por el usuario
			int eleccion = 0;			
			boolean entradaInvalida = true;			
			while(entradaInvalida) { // Bucle que se repetirá hasta que la entrada sea válida
				try {
					eleccion = entrada.nextInt();	
					if(eleccion >= 1 && eleccion <= 5) { // El número debe estar entre 1 y 5
						entradaInvalida = false;
					}
					else { // Mensaje que se imprimirá si la opción no se ajusta a los requisitos
						System.out.println("Opción inválida. El número debe estar entre 1 y 5.");
					}					
				}
				catch (InputMismatchException e){ // Absorvemos el error lanzado en caso de que la entrada no sea un número
					System.out.println("Entrada inválida, por favor introduzca un número.");
	                entrada.next(); // Limpiamos el buffer de la entrada
				}				
			}
			
			//Switch que controla la ejecución dependiendo la elección del usuario
			switch(eleccion) {
				case 1:
					instancia.crearCorredor(); //Creación del un corredor, con los parámetros elegidos por el usuario
					break;					
				case 2:
					/*
					 * El siguiente bloque de código ordena la lista que almacena todos los objetos "Corredor".
					 * Utilizamos el método estático Collections.sort() para ordenador la lista.
					 * Con un "Comparator" personalizado con la clase "Corredor", sobreescribos el método "compare"
					 * de la interfaz "Comparable", con el objetivo de establecer nuestro propio criterior.
					 * "compare" recibe dos objetos como parámetros, y luego compara los respectivos atributos que le pasamos
					 * como parámetros al método devuelto "compare". De este modo conseguimos que:
					 *    1. Si c1.getSegundos() es menor que c2.getSegundos(), el resultado será negativo, indicando que 
					 *         c1 debe ir por delante de c2.
					 *    2. Si c1.getSegundos() es mayor que c2.getSegundos(), el resultado será positivo, y por lo tanto
					 *         c1 debe ir por detrás de c2.
					 */
					Collections.sort(Participantes.getParticipantes(), new Comparator<Corredor>() {
			            @Override
			            public int compare(Corredor c1, Corredor c2) {
			                return Double.compare(c1.getSegundos(), c2.getSegundos());
			            }
			        });					
					for(Corredor c : Participantes.getParticipantes()) {
						c.mostrarDetalles(); // Mostramos la lista de corredores ordenada por de mejor a peor tiempo
					}
					break;					
				case 3:
					instancia.subMenuOdenacion(); // Ejecución del submenú para ordenar la lisa de corredores mediante diversos criterios
					break;				
				case 4:
					instancia.crear20corredoresAzar(); // Método implementado para facilitar el testeo del programa
					break;				
				case 5:
					System.exit(0); // Opción para salir del programa
					
			}				
		}	
					
	}
}
