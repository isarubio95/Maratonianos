package paquete_1;

import java.util.Collections;
import java.util.Comparator;
import java.util.Scanner;

public class Programa {

	public static void main(String[] args) {
		
		Scanner entrada = new Scanner(System.in);
		Corredor instancia = new Corredor(null, 0, 0);
		
		boolean ejecutando = true;
		
		while (ejecutando) {
			
			System.out.println("¿Qué desea hacer? \n1. Añadir corredor \n2. Ordenar corredores por tiempo "
							 + "\n3. Otos métodos de ordenación \n4. Crear 20 corredores al azar \n5. Salir");
			int eleccion = entrada.nextInt();
			switch(eleccion) {
				case 1:
					instancia.crearCorredor();
					break;
					
				case 2:
					Collections.sort(Participantes.getParticipantes(), new Comparator<Corredor>() {
			            @Override
			            public int compare(Corredor c1, Corredor c2) {
			                return Double.compare(c1.getSegundos(), c2.getSegundos());
			            }
			        });
					
					for(Corredor c : Participantes.getParticipantes()) {
						c.mostrarDetalles();
					}
					break;
					
				case 3:
					instancia.subMenuOdenacion();
					break;
				
				case 4:
					instancia.crear20corredoresAzar();
					break;
				
				case 5:
					System.exit(0);
					
			}	
			
		}	
		
		
			
	}
}
