package nodos2;

import java.awt.Graphics2D;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.util.ArrayList;
import java.util.List;

public class Bicho implements KeyListener {
	private double x;
	private double y;
	private double velocidadGiro;
	private List<Nodo> nodos;
	private Nodo nodoCentral;
	private boolean arriba, abajo, izquierda, derecha;
	
	public Bicho(Pantalla pantalla) {
		pantalla.addKeyListener(this);		
		reiniciarNodos();
		
		new Bucle(20) {
			@Override
			public void onBucle() {
				double anguloRad = Math.toRadians(nodoCentral.getAnguloActual());
				if(arriba) {					
					x -= Math.cos(anguloRad) * 2;
					y -= Math.sin(anguloRad) * 2;
				}
				if(abajo) {
					x += Math.cos(anguloRad) * 2;
					y += Math.sin(anguloRad) * 2;
				}
				
				if(arriba || abajo) {
					double angulo = nodoCentral.getAnguloActual();
					if(izquierda) {					
						angulo = angulo - velocidadGiro < 0 ? 360 : angulo - velocidadGiro;
					}
					if(derecha) {
						angulo = angulo + velocidadGiro > 360 ? 0 : angulo + velocidadGiro;
					}
					nodoCentral.setAnguloActual(angulo);
					
					nodoCentral.mover();					
				}
			}
		};
	}
	
	public void reiniciarNodos() {
		x = 350;
		y = 350;
		velocidadGiro = 1.0;
		nodos = new ArrayList<Nodo>();
		
		//PARAMETROS DEL OBJETO:
				//Bicho, Tipo de nodo, nodo padre (Null para el nodo central), Angulo relativo, Tamaño)
		/**
		 * BICHO PEZ
		 */
		/*		
		Nodo cuerpo = new Nodo(this, TipoNodo.ESTATICO, null, 0, 50);
		Nodo cola1 = new Nodo(this, TipoNodo.MOTOR, cuerpo, 0, 35);
		Nodo cola2 = new Nodo(this, TipoNodo.MOTOR, cola1, 0, 25);
		Nodo cola3 = new Nodo(this, TipoNodo.MOTOR, cola2, 0, 20);
		Nodo cola4 = new Nodo(this, TipoNodo.MOTOR, cola3, 0, 18);
		new Nodo(this, TipoNodo.PINCHO, cola4, 30, 7); //Pincho1
		new Nodo(this, TipoNodo.PINCHO, cola4, -30, 7); //Pincho2
		new Nodo(this, TipoNodo.OJO, cuerpo, 120, 15); //Ojo1
		new Nodo(this, TipoNodo.OJO, cuerpo, 240, 15); //Ojo2
		*/
		/**
		 * BICHO CANGREJO
		 */
		Nodo cuerpo = new Nodo(this, TipoNodo.ESTATICO, null, 0, 50);		
		
		Nodo pataIzq1_0 = new Nodo(this, TipoNodo.MOTOR, cuerpo, 50, 10);
		Nodo pataIzq1_1 = new Nodo(this, TipoNodo.MOTOR, pataIzq1_0, 0, 5);
		Nodo pataIzq1_2 = new Nodo(this, TipoNodo.MOTOR, pataIzq1_1, 0, 5);
		Nodo pataIzq1_3 = new Nodo(this, TipoNodo.MOTOR, pataIzq1_2, 0, 5);
		new Nodo(this, TipoNodo.MOTOR, pataIzq1_3, 0, 5); //PataIzq1_4
		Nodo pataIzq2_0 = new Nodo(this, TipoNodo.MOTOR, cuerpo, 90, 10);
		Nodo pataIzq2_1 = new Nodo(this, TipoNodo.MOTOR, pataIzq2_0, 0, 5);
		Nodo pataIzq2_2 = new Nodo(this, TipoNodo.MOTOR, pataIzq2_1, 0, 5);
		Nodo pataIzq2_3 = new Nodo(this, TipoNodo.MOTOR, pataIzq2_2, 0, 5);
		new Nodo(this, TipoNodo.MOTOR, pataIzq2_3, 0, 5); //PataIzq2_4
		Nodo pataIzq3_0 = new Nodo(this, TipoNodo.MOTOR, cuerpo, 130, 10);
		Nodo pataIzq3_1 = new Nodo(this, TipoNodo.MOTOR, pataIzq3_0, 0, 5);
		Nodo pataIzq3_2 = new Nodo(this, TipoNodo.MOTOR, pataIzq3_1, 0, 5);
		Nodo pataIzq3_3 = new Nodo(this, TipoNodo.MOTOR, pataIzq3_2, 0, 5);
		new Nodo(this, TipoNodo.MOTOR, pataIzq3_3, 0, 5); //PataIzq3_4
		
		Nodo pataDrc1_0 = new Nodo(this, TipoNodo.MOTOR, cuerpo, -50, 10);
		Nodo pataDrc1_1 = new Nodo(this, TipoNodo.MOTOR, pataDrc1_0, 0, 5);
		Nodo pataDrc1_2 = new Nodo(this, TipoNodo.MOTOR, pataDrc1_1, 0, 5);
		Nodo pataDrc1_3 = new Nodo(this, TipoNodo.MOTOR, pataDrc1_2, 0, 5);
		new Nodo(this, TipoNodo.MOTOR, pataDrc1_3, 0, 5); //pataDrc1_4
		Nodo pataDrc2_0 = new Nodo(this, TipoNodo.MOTOR, cuerpo, -90, 10);
		Nodo pataDrc2_1 = new Nodo(this, TipoNodo.MOTOR, pataDrc2_0, 0, 5);
		Nodo pataDrc2_2 = new Nodo(this, TipoNodo.MOTOR, pataDrc2_1, 0, 5);
		Nodo pataDrc2_3 = new Nodo(this, TipoNodo.MOTOR, pataDrc2_2, 0, 5);
		new Nodo(this, TipoNodo.MOTOR, pataDrc2_3, 0, 5); //pataDrc2_4
		Nodo pataDrc3_0 = new Nodo(this, TipoNodo.MOTOR, cuerpo, -130, 10);
		Nodo pataDrc3_1 = new Nodo(this, TipoNodo.MOTOR, pataDrc3_0, 0, 5);
		Nodo pataDrc3_2 = new Nodo(this, TipoNodo.MOTOR, pataDrc3_1, 0, 5);
		Nodo pataDrc3_3 = new Nodo(this, TipoNodo.MOTOR, pataDrc3_2, 0, 5);
		new Nodo(this, TipoNodo.MOTOR, pataDrc3_3, 0, 5); //pataDrc3_4
		
		Nodo cabeza = new Nodo(this, TipoNodo.ESTATICO, cuerpo, 180, 35);
		new Nodo(this, TipoNodo.OJO, cabeza, 60, 15); //Ojo1
		new Nodo(this, TipoNodo.OJO, cabeza, -60, 15); //Ojo2
		
		nodoCentral = cuerpo;
		nodoCentral.mover();
	}
	
	public void pintar(Graphics2D g) {
		for(Nodo nodo : nodos) {
			nodo.pintar(g);
		}
	}

	public double getX() {
		return x;
	}

	public void setX(double x) {
		this.x = x;
	}

	public double getY() {
		return y;
	}

	public void setY(double y) {
		this.y = y;
	}
	
	public double getVelocidadGiro() {
		return velocidadGiro;
	}
	
	public void setVelocidadGiro(double velocidadGiro) {
		this.velocidadGiro = velocidadGiro;
	}
	
	public List<Nodo> getNodos() {
		return nodos;
	}

	@Override
	public void keyPressed(KeyEvent e) {
		switch(e.getKeyCode()) {
		case KeyEvent.VK_W:
			arriba = true;
			break;
		case KeyEvent.VK_S:
			abajo = true;
			break;
		case KeyEvent.VK_A:
			izquierda = true;
			break;
		case KeyEvent.VK_D:
			derecha = true;
			break;
		}
	}

	@Override
	public void keyReleased(KeyEvent e) {
		switch(e.getKeyCode()) {
		case KeyEvent.VK_W:
			arriba = false;
			break;
		case KeyEvent.VK_S:
			abajo = false;
			break;
		case KeyEvent.VK_A:
			izquierda = false;
			break;
		case KeyEvent.VK_D:
			derecha = false;
			break;
		}
	}

	@Override
	public void keyTyped(KeyEvent e) {
	}
}
