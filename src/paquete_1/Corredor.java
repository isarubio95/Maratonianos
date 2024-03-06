package paquete_1;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.InputMismatchException;
import java.util.Random;
import java.util.Scanner;

/**
 * Representa a un corredor de una maratón. Permite 
 * la creación de corredores, su ordenación según el tiempo de carrera, 
 * y la gestión de sus datos como el nombre, dorsal y tiempo registrado.
 */
public class Corredor {
	private String nombre;
	private int dorsal;
	private double segundos;
		
		 /**
		 * Construye un nuevo corredor con los detalles especificados.
		 * 
		 * @param nombre El nombre del corredor.
		 * @param dorsal El número de dorsal del corredor.
		 * @param segundos El tiempo registrado por el corredor en segundos.
		 */
		public Corredor (String nombre, int dorsal, double segundos) {
			this.nombre = nombre;
			this.dorsal = dorsal;
			this.segundos = segundos;
		}
		
		Scanner entrada = new Scanner(System.in);
		
		/**
	     * Establece el nombre del corredor basado en la entrada del usuario.
	     */
		public void setNombre() { 
			System.out.println("Introducza el nombre del maratoniano: ");
			this.nombre = entrada.nextLine();	
		}
		
		/**
	     * Establece el dorsal del corredor basado en la entrada del usuario.
	     */
		public void setDorsal() {			
			System.out.println("Introducza dorsal: ");
			this.dorsal = entrada.nextInt();	
		}
		
		/**
	     * Establece el tiempo en segundos del corredor basado en la entrada del usuario.
	     */
		public void setSegundos() {		
			System.out.println("Introducza los segundos: ");
			this.segundos = entrada.nextDouble();	
		}
		
		/**
	     * Obtiene el tiempo en segundos registrado por el corredor.
	     * 
	     * @return El tiempo en segundos del corredor.
	     */
		public double getSegundos() {
			return segundos;
		}
		
		/**
	     * Crea y añade un nuevo corredor a la lista de participantes, con información
	     * recogida a través de la entrada del usuario.
	     */
		public void crearCorredor() {
			Corredor corredor = new Corredor(nombre, dorsal, segundos);
			corredor.setNombre();
			corredor.setDorsal();
			corredor.setSegundos();
			Participantes.insertarCorredor(corredor);
		}
		
		/**
	     * Crea 20 corredores con información aleatoria y los añade a la lista de participantes.
	     * Los nombres y dorsales son seleccionados de manera aleatoria, y los tiempos son generados
	     * también de forma aleatoria dentro de un rango.
	     */
		public void crear20corredoresAzar() {	
			// ArrayList que contiene los números del 1 al 100. Son ingresados de forma automática por un bucle for
			ArrayList<Integer> dorsales = new ArrayList<Integer>(100); 
			for (int i1 = 1; i1 < 100; i1++) {
			    dorsales.add(i1);
			}
			// Array que contiene 100 nombres de chicos y chicas. Será recorrido al azar para establecer los nombres
			String[] nombres = { 
				    "Isaías", "Noelia", "Daniel", "Pablo", "Manuel", "Iván", "José", "Adrián", "Ángel", "Mario",
				    "Alberto", "Javier", "Sergio", "Rafael", "Fernando", "Diego", "Luis", "Óscar", "Miguel", "Antonio",
				    "Jorge", "Carlos", "Juan", "Rubén", "Raúl", "Enrique", "Marcos", "Gonzalo", "Víctor", "Francisco",
				    "Eduardo", "Hugo", "Nicolás", "Julio", "Pedro", "Alvaro", "Roberto", "Jaime", "Héctor", "Guillermo",
				    "Gabriel", "Christian", "Joaquín", "Emilio", "Marc", "Íker", "Saúl", "Salvador", "Ricardo", "Ernesto",
				    "María", "Carmen", "Josefa", "Isabel", "Laura", "Marta", "Ana", "Sandra", "Patricia", "Pilar",
				    "Lucía", "Sara", "Paula", "Clara", "Elena", "Cristina", "Marta", "Sofía", "Beatriz", "Rocío",
				    "Alba", "Julia", "Nuria", "Silvia", "Teresa", "Lorena", "Alicia", "Mónica", "Irene", "Raquel",
				    "Eva", "Daniela", "Mercedes", "Rosario", "Inmaculada", "Lidia", "Margarita", "Rosa", "Susana", "Andrea",
				    "Esther", "Noelia", "Verónica", "Ángela", "Consuelo", "Laura", "Paloma", "Belén", "Manuela", "Cecilia"
				};
						
			for (int i = 0 ; i < 20 ; i++) { // Este bucle repite 20 veces la creación de un corredor					
				
				Random aleatorio = new Random(); // Instanciación de la clase "Random", para generar un número aleatorio
				
				// El nombre del nuevo corredor será uno de los valores, aleatoriamente, del Array de Strings "nombres"
				String nombre = nombres[aleatorio.nextInt(nombres.length)]; 
				
				/* 
				 * El siguiente método genera un número aleatorio entre 0 y el total de valores almacenados en el ArrayList.
				 * Luego lo almacenamos en la variable "dorsal", que posteriormente se pasará como parámetro para la construcción 
				 * del nuevo corredor.
				 * Por último, eliminamos el dorsal que acabamos de utilizar, para que no se pueda repetir.
				 */
				int indiceDorsal = aleatorio.nextInt(dorsales.size());
		        int dorsal = dorsales.get(indiceDorsal);
		        dorsales.remove(indiceDorsal);
				
		        // Para el parámetro segundos, generamos un número doble aleatorio entre 10.00 y 99.99
		        double segundos = 10.00 + (Math.round((Math.random() * (99.99 - 10.00)) * 100.0) / 100.0);
				
		        // Construimos el nuevo corredor con los valores generados anteriormente
				Corredor corredor = new Corredor(nombre, dorsal, segundos);
				
				Participantes.insertarCorredor(corredor); // Insertamos el corredor en el ArrayList "participantes"
			}
			
			for(Corredor c : Participantes.getParticipantes()) { // Mostramos por pantalla los corredores recién creados
				c.mostrarDetalles();
			}
			
			System.out.println("CORREDORES CREADOS SATISFACTORIAMENTE\n");
		}
		
		/**
	     * Muestra los detalles del corredor, incluyendo dorsal, nombre y tiempo.
	     */
		public void mostrarDetalles() {
			System.out.println("Dorsal: " + dorsal);
			System.out.println("Nombre: " + nombre);			
			System.out.printf("Tiempo: %.2f\n", segundos); // Aseguramos que se muestran solo dos decimales por pantalla
			System.out.println("------------------------");
		}
		
		/**
	     * Presenta un submenú al usuario para que elija entre diferentes opciones de ordenación
	     * para los corredores, permitiendo visualizar los primeros 10 o 3 corredores, ordenados
	     * por tiempo ascendente o descendente.
	     */
		public void subMenuOdenacion() {			
			boolean menu = true;
			while(menu) {				
				System.out.println("Escoja una opción: \n1) Los 10 primeros corredores de menor a mayor tiempo"
						+ "\n2) Los 3 primeros corredores de menor a mayor tiempo \n3) Los 10 primeros corredores de mayor"
						+ " a menor tiempo \n4) Los 3 primeros corredores de mayor a menor tiempo \n5) Volver atrás");
				
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
				
				switch(eleccion) {
					case 1:
						// En este caso, ordenamos los participantes de menor a mayor tiempo
						Collections.sort(Participantes.getParticipantes(), new Comparator<Corredor>() {
				            @Override
				            public int compare(Corredor c1, Corredor c2) {
				                return Double.compare(c1.getSegundos(), c2.getSegundos());
				            }
				        });
						/* Solo cogeremos los 10 primeros participantes. El programa contempla la posibilidad de 
						 * que haya menos de 10 corredores, por lo que en el bucle que recorre la lista,
						 * fijamos la condición de finalización del bucle con Math.min(), de forma que el número sea 
						 * el mínimo entre 10 y el total de los corredores que hay en la competición, la primera que
						 * se cumpla.  
						 */ 
						for (int i = 0; i < Math.min(10, Participantes.getParticipantes().size()); i++) {
						    Corredor corredor = Participantes.getParticipantes().get(i);
						    corredor.mostrarDetalles();
						}
						break;						
					case 2:
						//Este caso es similar al anterior, con la diferencia de que solo cogeremos los 3 primeros corredores
						Collections.sort(Participantes.getParticipantes(), new Comparator<Corredor>() {
				            @Override
				            public int compare(Corredor c1, Corredor c2) {
				                return Double.compare(c1.getSegundos(), c2.getSegundos());
				            }
				        });
						for (int i = 0; i < Math.min(3, Participantes.getParticipantes().size()); i++) {
						    Corredor corredor = Participantes.getParticipantes().get(i);
						    corredor.mostrarDetalles();
						}
						break;					
					case 3:
						// Ahora ordenaremos de mayor a menor tiempo, los 10 corredores más lentos.
						// Invertimos la posición de los corredores en el return
						Collections.sort(Participantes.getParticipantes(), new Comparator<Corredor>() {
				            @Override
				            public int compare(Corredor c1, Corredor c2) {
				                return Double.compare(c2.getSegundos(), c1.getSegundos());
				            }
				        });
						for (int i = 0; i < Math.min(10, Participantes.getParticipantes().size()); i++) {
						    Corredor corredor = Participantes.getParticipantes().get(i);
						    corredor.mostrarDetalles();
						}
						break;						
					case 4:
						// Similar a la opción anterior, pero cogiendo solo los 3 corredores con peores tiempos
						Collections.sort(Participantes.getParticipantes(), new Comparator<Corredor>() {
				            @Override
				            public int compare(Corredor c1, Corredor c2) {
				                return Double.compare(c2.getSegundos(), c1.getSegundos());
				            }
				        });
						for (int i = 0; i < Math.min(3, Participantes.getParticipantes().size()); i++) {
						    Corredor corredor = Participantes.getParticipantes().get(i);
						    corredor.mostrarDetalles();
						}
						break;						
					case 5:
						// Opción para salir del submenú y volver al menú principal
						menu = false;
						break;
						
				}			
						
			} // Fin del bucle while del menú
			
		} // Fin del método submenuOrdenacion()
			
} // Fin de la clase Corredor
