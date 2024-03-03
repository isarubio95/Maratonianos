package paquete_1;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.Random;
import java.util.Scanner;

public class Corredor {
	private String nombre;
	private int dorsal;
	private double segundos;
	
	
		public Corredor (String nombre, int dorsal, double segundos) {
			this.nombre = nombre;
			this.dorsal = dorsal;
			this.segundos = segundos;
		}
		
		Scanner entrada = new Scanner(System.in);
		
		public void setNombre() {			
			System.out.println("Introducza el nombre del maratoniano: ");
			this.nombre = entrada.nextLine();	
		}
		
		public void setDorsal() {			
			System.out.println("Introducza dorsal: ");
			this.dorsal = entrada.nextInt();	
		}
		
		public void setSegundos() {		
			System.out.println("Introducza los segundos: ");
			this.segundos = entrada.nextDouble();	
		}
		
		public double getSegundos() {
			return segundos;
		}
		
		public void crearCorredor() {
			Corredor corredor = new Corredor(nombre, dorsal, segundos);
			corredor.setNombre();
			corredor.setDorsal();
			corredor.setSegundos();
			Participantes.insertarCorredor(corredor);
		}
		
		public void crear20corredoresAzar() {
						
			ArrayList<Integer> dorsales = new ArrayList<Integer>(100);
			for (int i1 = 0; i1 < 100; i1++) {
			    dorsales.add(i1);
			}
			
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
						
			for (int i = 0 ; i < 20 ; i++) {					
				
				Random aleatorio = new Random();
				
				String nombre = nombres[aleatorio.nextInt(nombres.length)];
				
				int indiceDorsal = aleatorio.nextInt(dorsales.size());
		        int dorsal = dorsales.get(indiceDorsal);
		        dorsales.remove(indiceDorsal);
											
				double segundos = 10.00 + Math.round((Math.random() * (99.99 - 10.00))*100)/100;
								
				Corredor corredor = new Corredor(nombre, dorsal, segundos);
				
				Participantes.insertarCorredor(corredor);
			}
		}
		
		public void mostrarDetalles() {
			System.out.println("Dorsal: " + dorsal);
			System.out.println("Nombre: " + nombre);			
			System.out.println("Tiempo: " + segundos + "segundos");
			System.out.println("------------------------");
		}
		
		public void subMenuOdenacion() {
			
			boolean menu = true;
			while(menu) {				
				System.out.println("Escoja una opción: \n1) Los 10 primeros corredores de menor a mayor tiempo"
						+ "\n2) Los 3 primeros corredores de menor a mayor tiempo \n3) Los 10 primeros corredores de mayor"
						+ " a menor tiempo \n4) Los 3 primeros corredores de mayor a menor tiempo \n5) Volver atrás");
				int eleccion2 = entrada.nextInt();
				switch(eleccion2) {
					case 1:
						Collections.sort(Participantes.getParticipantes(), new Comparator<Corredor>() {
				            @Override
				            public int compare(Corredor c1, Corredor c2) {
				                return Double.compare(c1.getSegundos(), c2.getSegundos());
				            }
				        });
						for (int i = 0; i < Math.min(10, Participantes.getParticipantes().size()); i++) {
						    Corredor corredor = Participantes.getParticipantes().get(i);
						    corredor.mostrarDetalles();
						}
						break;
						
					case 2:
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
						menu = false;
						break;
				}			
						
			}
		}
		
		
		
	
	
	
	
		
		
		
		
		
		
		
		
		
}
