package nodos;

public class ConstructorBichos {	
	public static void gusano(Bicho bicho, int fase) {
		new Thread() {
			@Override
			public void run() {
				switch(fase) {
				case 0:
					gusanoFase0(bicho);
					break;
				case 1:
					gusanoFase1(bicho);
					break;
				case 2:
					gusanoFase2(bicho);
					break;
				case 3:
					gusanoFase3(bicho);
					break;
				}	
				bicho.getNodoCentral().mover();
			}
		}.start();
	}
	
	public static void gusanoFase0(Bicho bicho) {
		bicho.getNodos().clear();
		Nodo cuerpo = new Nodo(bicho, TipoNodo.ESTATICO, null, 0, 50);
		new Nodo(bicho, TipoNodo.OJO, cuerpo, 120, 15); //Ojo1
		new Nodo(bicho, TipoNodo.OJO, cuerpo, 240, 15); //Ojo2	
		bicho.setNodoCentral(cuerpo);		
	}	
	
	private static void gusanoFase1(Bicho bicho) {
		Nodo cola1 = new Nodo(bicho, TipoNodo.MOTOR, bicho.getNodoCentral(), 0, 35);
		Nodo cola2 = new Nodo(bicho, TipoNodo.FLEXIBLE, cola1, 0, 25);
		Nodo cola3 = new Nodo(bicho, TipoNodo.FLEXIBLE, cola2, 0, 20);
		new Nodo(bicho, TipoNodo.MOTOR, cola3, 0, 18); //Cola4
	}
	
	private static void gusanoFase2(Bicho bicho) {
		Nodo cola1 = bicho.getNodos().get(3);
		cola1.setTipoNodo(TipoNodo.ESTATICO);
		cola1.setAnguloActual(0);
		cola1.setAnguloGiro(0);
		
		Nodo cola2 = bicho.getNodos().get(4);
		cola2.setTipoNodo(TipoNodo.ESTATICO);
		cola2.setAnguloActual(0);
		cola2.setAnguloGiro(0);
		
		Nodo cola3 = bicho.getNodos().get(5);
		cola3.setTipoNodo(TipoNodo.ESTATICO);
		cola3.setAnguloActual(0);
		cola3.setAnguloGiro(0);
		
		Nodo cola4 = bicho.getNodos().get(6);
		new Nodo(bicho, TipoNodo.PINCHO, cola4, 30, 7); //Pincho1
		new Nodo(bicho, TipoNodo.PINCHO, cola4, -30, 7);//Pincho2
		
		Nodo pataIzq1 = new Nodo(bicho, TipoNodo.MOTOR, cola1, 90, 7);
		Nodo pataDrc1 = new Nodo(bicho, TipoNodo.MOTOR, cola1, -90, 7);
		new Nodo(bicho, TipoNodo.FLEXIBLE, pataIzq1, 0, 7);
		new Nodo(bicho, TipoNodo.FLEXIBLE, pataDrc1, 0, 7);
		
		Nodo pataIzq2 = new Nodo(bicho, TipoNodo.MOTOR, cola2, 90, 7);
		Nodo pataDrc2 = new Nodo(bicho, TipoNodo.MOTOR, cola2, -90, 7);
		new Nodo(bicho, TipoNodo.FLEXIBLE, pataIzq2, 0, 7);
		new Nodo(bicho, TipoNodo.FLEXIBLE, pataDrc2, 0, 7);
		
		Nodo pataIzq3 = new Nodo(bicho, TipoNodo.MOTOR, cola3, 90, 7);
		Nodo pataDrc3 = new Nodo(bicho, TipoNodo.MOTOR, cola3, -90, 7);
		new Nodo(bicho, TipoNodo.FLEXIBLE, pataIzq3, 0, 7);
		new Nodo(bicho, TipoNodo.FLEXIBLE, pataDrc3, 0, 7);
	}
	
	private static void gusanoFase3(Bicho bicho) {
		new Nodo(bicho, TipoNodo.OJO, bicho.getNodoCentral(), 100, 15);//Ojo3
		new Nodo(bicho, TipoNodo.OJO, bicho.getNodoCentral(), 260, 15);//Ojo4
		new Nodo(bicho, TipoNodo.PINCHO, bicho.getNodoCentral(), 200, 7);//Pincho3
		new Nodo(bicho, TipoNodo.PINCHO, bicho.getNodoCentral(), 160, 7);//Pincho4
		
		Nodo pataIzq1_1 = bicho.getNodos().get(11);
		Nodo pataDrc1_1 = bicho.getNodos().get(12);
		pataIzq1_1.setTipoNodo(TipoNodo.ESTATICO);
		pataIzq1_1.setAnguloActual(0);
		pataIzq1_1.setAnguloGiro(0);
		pataDrc1_1.setTipoNodo(TipoNodo.ESTATICO);
		pataDrc1_1.setAnguloActual(0);
		pataDrc1_1.setAnguloGiro(0);
		
		Nodo pataIzq2_1 = bicho.getNodos().get(15);
		Nodo pataDrc2_1 = bicho.getNodos().get(16);
		pataIzq2_1.setTipoNodo(TipoNodo.ESTATICO);
		pataIzq2_1.setAnguloActual(0);
		pataIzq2_1.setAnguloGiro(0);
		pataDrc2_1.setTipoNodo(TipoNodo.ESTATICO);
		pataDrc2_1.setAnguloActual(0);
		pataDrc2_1.setAnguloGiro(0);
		
		Nodo pataIzq3_1 = bicho.getNodos().get(19);
		Nodo pataDrc3_1 = bicho.getNodos().get(20);
		pataIzq3_1.setTipoNodo(TipoNodo.ESTATICO);
		pataIzq3_1.setAnguloActual(0);
		pataIzq3_1.setAnguloGiro(0);
		pataDrc3_1.setTipoNodo(TipoNodo.ESTATICO);
		pataDrc3_1.setAnguloActual(0);
		pataDrc3_1.setAnguloGiro(0);
		
		Nodo pataIzq1_2 = new Nodo(bicho, TipoNodo.FLEXIBLE, pataIzq1_1, 0, 7);
		Nodo pataIzq1_3 = new Nodo(bicho, TipoNodo.MOTOR, pataIzq1_2, 0, 7);
		Nodo pataIzq1_4 = new Nodo(bicho, TipoNodo.FLEXIBLE, pataIzq1_3, 0, 7);
		new Nodo(bicho, TipoNodo.ESTATICO, pataIzq1_4, 0, 7);
		Nodo pataDrc1_2 = new Nodo(bicho, TipoNodo.FLEXIBLE, pataDrc1_1, 0, 7);
		Nodo pataDrc1_3 = new Nodo(bicho, TipoNodo.MOTOR, pataDrc1_2, 0, 7);
		Nodo pataDrc1_4 = new Nodo(bicho, TipoNodo.FLEXIBLE, pataDrc1_3, 0, 7);
		new Nodo(bicho, TipoNodo.ESTATICO, pataDrc1_4, 0, 7);
		
		Nodo pataIzq2_2 = new Nodo(bicho, TipoNodo.FLEXIBLE, pataIzq2_1, 0, 7);
		Nodo pataIzq2_3 = new Nodo(bicho, TipoNodo.MOTOR, pataIzq2_2, 0, 7);
		Nodo pataIzq2_4 = new Nodo(bicho, TipoNodo.FLEXIBLE, pataIzq2_3, 0, 7);
		new Nodo(bicho, TipoNodo.ESTATICO, pataIzq2_4, 0, 7);
		Nodo pataDrc2_2 = new Nodo(bicho, TipoNodo.FLEXIBLE, pataDrc2_1, 0, 7);
		Nodo pataDrc2_3 = new Nodo(bicho, TipoNodo.MOTOR, pataDrc2_2, 0, 7);
		Nodo pataDrc2_4 = new Nodo(bicho, TipoNodo.FLEXIBLE, pataDrc2_3, 0, 7);
		new Nodo(bicho, TipoNodo.ESTATICO, pataDrc2_4, 0, 7);
		
		Nodo pataIzq3_2 = new Nodo(bicho, TipoNodo.FLEXIBLE, pataIzq3_1, 0, 7);
		Nodo pataIzq3_3 = new Nodo(bicho, TipoNodo.MOTOR, pataIzq3_2, 0, 7);
		Nodo pataIzq3_4 = new Nodo(bicho, TipoNodo.FLEXIBLE, pataIzq3_3, 0, 7);
		new Nodo(bicho, TipoNodo.ESTATICO, pataIzq3_4, 0, 7);
		Nodo pataDrc3_2 = new Nodo(bicho, TipoNodo.FLEXIBLE, pataDrc3_1, 0, 7);
		Nodo pataDrc3_3 = new Nodo(bicho, TipoNodo.MOTOR, pataDrc3_2, 0, 7);
		Nodo pataDrc3_4 = new Nodo(bicho, TipoNodo.FLEXIBLE, pataDrc3_3, 0, 7);
		new Nodo(bicho, TipoNodo.ESTATICO, pataDrc3_4, 0, 7);
	}
	
	public static void cangrejo(Bicho bicho) {
		bicho.getNodos().clear();
		
		Nodo cuerpo = new Nodo(bicho, TipoNodo.ESTATICO, null, 0, 50);		
		
		Nodo pataIzq1_0 = new Nodo(bicho, TipoNodo.MOTOR, cuerpo, 50, 10);
		Nodo pataIzq1_1 = new Nodo(bicho, TipoNodo.ESTATICO, pataIzq1_0, 0, 5);
		Nodo pataIzq1_2 = new Nodo(bicho, TipoNodo.MOTOR, pataIzq1_1, 0, 5);
		Nodo pataIzq1_3 = new Nodo(bicho, TipoNodo.ESTATICO, pataIzq1_2, 0, 5);
		new Nodo(bicho, TipoNodo.MOTOR, pataIzq1_3, 0, 5); //PataIzq1_4
		Nodo pataIzq2_0 = new Nodo(bicho, TipoNodo.MOTOR, cuerpo, 90, 10);
		Nodo pataIzq2_1 = new Nodo(bicho, TipoNodo.ESTATICO, pataIzq2_0, 0, 5);
		Nodo pataIzq2_2 = new Nodo(bicho, TipoNodo.MOTOR, pataIzq2_1, 0, 5);
		Nodo pataIzq2_3 = new Nodo(bicho, TipoNodo.ESTATICO, pataIzq2_2, 0, 5);
		new Nodo(bicho, TipoNodo.MOTOR, pataIzq2_3, 0, 5); //PataIzq2_4
		Nodo pataIzq3_0 = new Nodo(bicho, TipoNodo.MOTOR, cuerpo, 130, 10);
		Nodo pataIzq3_1 = new Nodo(bicho, TipoNodo.ESTATICO, pataIzq3_0, 0, 5);
		Nodo pataIzq3_2 = new Nodo(bicho, TipoNodo.MOTOR, pataIzq3_1, 0, 5);
		Nodo pataIzq3_3 = new Nodo(bicho, TipoNodo.ESTATICO, pataIzq3_2, 0, 5);
		new Nodo(bicho, TipoNodo.MOTOR, pataIzq3_3, 0, 5); //PataIzq3_4
		
		Nodo pataDrc1_0 = new Nodo(bicho, TipoNodo.MOTOR, cuerpo, -50, 10);
		Nodo pataDrc1_1 = new Nodo(bicho, TipoNodo.ESTATICO, pataDrc1_0, 0, 5);
		Nodo pataDrc1_2 = new Nodo(bicho, TipoNodo.MOTOR, pataDrc1_1, 0, 5);
		Nodo pataDrc1_3 = new Nodo(bicho, TipoNodo.ESTATICO, pataDrc1_2, 0, 5);
		new Nodo(bicho, TipoNodo.MOTOR, pataDrc1_3, 0, 5); //pataDrc1_4
		Nodo pataDrc2_0 = new Nodo(bicho, TipoNodo.MOTOR, cuerpo, -90, 10);
		Nodo pataDrc2_1 = new Nodo(bicho, TipoNodo.ESTATICO, pataDrc2_0, 0, 5);
		Nodo pataDrc2_2 = new Nodo(bicho, TipoNodo.MOTOR, pataDrc2_1, 0, 5);
		Nodo pataDrc2_3 = new Nodo(bicho, TipoNodo.ESTATICO, pataDrc2_2, 0, 5);
		new Nodo(bicho, TipoNodo.MOTOR, pataDrc2_3, 0, 5); //pataDrc2_4
		Nodo pataDrc3_0 = new Nodo(bicho, TipoNodo.MOTOR, cuerpo, -130, 10);
		Nodo pataDrc3_1 = new Nodo(bicho, TipoNodo.ESTATICO, pataDrc3_0, 0, 5);
		Nodo pataDrc3_2 = new Nodo(bicho, TipoNodo.MOTOR, pataDrc3_1, 0, 5);
		Nodo pataDrc3_3 = new Nodo(bicho, TipoNodo.ESTATICO, pataDrc3_2, 0, 5);
		new Nodo(bicho, TipoNodo.MOTOR, pataDrc3_3, 0, 5); //pataDrc3_4
		
		Nodo cabeza = new Nodo(bicho, TipoNodo.ESTATICO, cuerpo, 180, 35);
		new Nodo(bicho, TipoNodo.OJO, cabeza, 60, 15); //Ojo1
		new Nodo(bicho, TipoNodo.OJO, cabeza, -60, 15); //Ojo2
		
		bicho.setNodoCentral(cuerpo);
		cuerpo.mover();
	}
}
