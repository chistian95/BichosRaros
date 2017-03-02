package nodos;

public class Lanzador {
	private Bicho bicho;
	
	public Lanzador() {
		Pantalla pantalla = new Pantalla(this);
		bicho = new Bicho(pantalla);
		pantalla.comenzar();
	}
	
	public static void main(String[] args) {
		new Lanzador();
	}
	
	public Bicho getBicho() {
		return bicho;
	}
}
