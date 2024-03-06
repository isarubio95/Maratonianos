package paquete_1;

import java.util.ArrayList;

/**
 * Clase estática creada para almenacer todos los corredores en un ArrayList.
 */
public class Participantes {
	private static ArrayList<Corredor> participantes = new ArrayList<>();;
		
		/**
	     * Obtiene la lista de corredores.
	     * 
	     * @return ArrayList participantes.
	     */
		public static ArrayList<Corredor> getParticipantes() {
			return participantes;
		}
		
		/**
	     * Añade un corredor a la lista de participantes.
	     */
		public static void insertarCorredor(Corredor corredor) {
			participantes.add(corredor);
		}

}
