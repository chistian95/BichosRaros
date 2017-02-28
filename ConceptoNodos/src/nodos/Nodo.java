package nodos;

import java.awt.Color;
import java.awt.Graphics2D;
import java.util.ArrayList;
import java.util.List;

public class Nodo {
	private Bicho bicho;
	private int x;
	private int y;
	private int radio;
	private int rotacion;
	private boolean rotacionBajar;
	private TipoNodo tipo;
	private List<Nodo> uniones;
	
	public Nodo(Bicho bicho, TipoNodo tipo, int x, int y, int radio) {
		this.bicho = bicho;
		this.tipo = tipo;
		this.x = x;
		this.y = y;
		this.radio = radio;
		uniones = new ArrayList<Nodo>();
		bicho.getNodos().add(this);
	}
	
	public void mover() {
		if(rotacionBajar) {
			rotacion = rotacion - 1 <= -90 ? -90 : rotacion - 1; 
			rotacionBajar = rotacion > -90;
		} else {
			rotacion = rotacion + 1 >= 90 ? 90 : rotacion + 1;
			rotacionBajar = rotacion >= 90;
		}
		
		for(Nodo nodo : uniones) {
			if(nodo.tipo == TipoNodo.MOTOR) {
			}
			nodo.mover();
		}
	}

	public void pintar(Graphics2D g) {
		int absX = bicho.getX() + x - radio;
		int absY = bicho.getY() + y - radio;
		int capaX = bicho.getX() + x - radio * 4;
		int capaY = bicho.getY() + y - radio * 4;
		int centroX = bicho.getX() + x;
		int centroY = bicho.getY() + y;
		
		g.setColor(new Color(0, 255, 0, 64));
		g.fillOval(capaX, capaY, radio * 8, radio * 8);
		
		g.setColor(Color.RED);
		if(bicho.getNodoSeleccionado() == this) {
			g.setColor(Color.BLUE);
		}
		g.fillOval(absX, absY, radio * 2, radio * 2);		
		
		g.setColor(Color.BLACK);
		for(Nodo nodo : uniones) {
			int centroXNodo = bicho.getX() + nodo.getX();
			int centorYNodo = bicho.getY() + nodo.getY();
			g.drawLine(centroX, centroY, centroXNodo, centorYNodo);
		}
	}
	
	public int getX() {
		return x;
	}

	public void setX(int x) {
		this.x = x;
	}

	public int getY() {
		return y;
	}

	public void setY(int y) {
		this.y = y;
	}

	public int getRadio() {
		return radio;
	}

	public void setRadio(int radio) {
		this.radio = radio;
	}
	
	public TipoNodo getTipo() {
		return tipo;
	}
	
	public void setTipo(TipoNodo tipo) {
		this.tipo = tipo;
	}
	
	public List<Nodo> getUniones() {
		return uniones;
	}
}
