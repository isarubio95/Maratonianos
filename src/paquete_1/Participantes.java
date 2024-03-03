package paquete_1;

import java.util.ArrayList;

public class Participantes {
	private static ArrayList<Corredor> participantes = new ArrayList<>();;

		public static ArrayList<Corredor> getParticipantes() {
			return participantes;
		}
		
		public static void insertarCorredor(Corredor corredor) {
			participantes.add(corredor);
		}

}
