package nodos;

import java.awt.Graphics2D;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.util.ArrayList;
import java.util.ConcurrentModificationException;
import java.util.List;

public class Bicho implements KeyListener {
	private double x;
	private double y;
	private double velocidadGiro;
	private int contFase;
	private List<Nodo> nodos;
	private Nodo nodoCentral;
	private boolean arriba, abajo, izquierda, derecha;
	
	public Bicho(Pantalla pantalla) {
		pantalla.addKeyListener(this);		
		reiniciarNodos();
		
		new Bucle(20) {
			@Override
			public void onBucle() {
				if(nodoCentral == null) {
					return;
				}
				double anguloRad = Math.toRadians(nodoCentral.getAnguloActual());
				if(arriba) {					
					x -= Math.cos(anguloRad) * 2;
					y -= Math.sin(anguloRad) * 2;
				}
				if(abajo) {
					x += Math.cos(anguloRad) * 2;
					y += Math.sin(anguloRad) * 2;
				}
				
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
		};
	}
	
	public void reiniciarNodos() {
		x = 350;
		y = 350;
		velocidadGiro = 1.0;
		nodos = new ArrayList<Nodo>();
		contFase = 0;
		evolucionar();
	}
	
	public void evolucionar() {
		ConstructorBichos.gusano(this, contFase);
		contFase++;
	}
	
	public void pintar(Graphics2D g) {
		try {
			for(Nodo nodo : nodos) {
				if(nodo == null) {
					continue;
				}
				nodo.pintar(g);
			}
		} catch(ConcurrentModificationException e) {
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
	
	public Nodo getNodoCentral() {
		return nodoCentral;
	}
	
	public void setNodoCentral(Nodo nodoCentral) {
		this.nodoCentral = nodoCentral;
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
		case KeyEvent.VK_SPACE:
			evolucionar();
			break;
		case KeyEvent.VK_CONTROL:
			reiniciarNodos();
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
