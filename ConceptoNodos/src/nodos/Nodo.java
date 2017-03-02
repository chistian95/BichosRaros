package nodos;

import java.awt.Color;
import java.awt.Graphics2D;
import java.util.ArrayList;
import java.util.List;

public class Nodo {
	private double x;
	private double y;
	private double radio;
	private double anguloInicio;
	private double anguloActual;
	private double anguloGiro;
	private double anguloTope;
	private boolean anguloBajar;
	private boolean visible;
	private TipoNodo tipoNodo;
	private Nodo nodoPadre;
	private Bicho bicho;
	private List<Nodo> nodos;
	
	public Nodo(Bicho bicho, TipoNodo tipoNodo, Nodo nodoPadre, double anguloInicio, double radio) {
		this.bicho = bicho;
		this.tipoNodo = tipoNodo;
		this.nodoPadre = nodoPadre;
		this.anguloInicio = anguloInicio;
		this.radio = radio;		
		anguloTope = 15;
		nodos = new ArrayList<Nodo>();
		bicho.getNodos().add(this);
		if(nodoPadre != null) {
			nodoPadre.nodos.add(this);
		}
		visible = false;
		try {
			double tiempo = Math.random() * 40 + 10;
			Thread.sleep((long) tiempo);
			visible = true;
		} catch(Exception e) {
			e.printStackTrace();
		}
	}
	
	public void mover() {
		if(tipoNodo == TipoNodo.MOTOR) {
			if(anguloBajar) {
				anguloGiro = anguloGiro - bicho.getVelocidadGiro() <= -anguloTope ? -anguloTope : anguloGiro - bicho.getVelocidadGiro(); 
				anguloBajar = anguloGiro > -anguloTope;
			} else {
				anguloGiro = anguloGiro + bicho.getVelocidadGiro() >= anguloTope ? anguloTope : anguloGiro + bicho.getVelocidadGiro();
				anguloBajar = anguloGiro >= anguloTope;
			}
		} else if(tipoNodo == TipoNodo.FLEXIBLE) {
			if(nodoPadre.anguloBajar) {
				anguloGiro = nodoPadre.anguloGiro - bicho.getVelocidadGiro();
			} else {
				anguloGiro = nodoPadre.anguloGiro + bicho.getVelocidadGiro();
			}
		}
		
		if(nodoPadre == null) {
			x = bicho.getX();
			y = bicho.getY();
		} else {
			double centroX = nodoPadre.getX();
			double centroY = nodoPadre.getY();
			anguloActual = nodoPadre.getAnguloActual() + nodoPadre.getAnguloGiro() + anguloInicio;
			double angulo = Math.toRadians(anguloActual);
			double radioPadre = nodoPadre.getRadio();
			x = (int) (Math.round(Math.cos(angulo) * radioPadre)) + centroX;
			y = (int) (Math.round(Math.sin(angulo) * radioPadre)) + centroY;
		}
		for(Nodo nodo : nodos) {
			nodo.mover();
		}
	}
	
	public void pintar(Graphics2D g) {
		if(!visible) {
			return;
		}
		int xAbs = (int) Math.round(x - radio);
		int yAbs = (int) Math.round(y - radio);	
		int radioAbs = (int) Math.round(radio * 2.0);
		
		g.setColor(tipoNodo.getColor());
		g.fillOval(xAbs, yAbs, radioAbs, radioAbs);
		
		int xSel = (int) Math.round(x - radio / 8.0);
		int ySel = (int) Math.round(y - radio / 8.0);
		int radioSel = (int) Math.round(radio / 4.0);
		g.setColor(Color.BLACK);
		g.fillOval(xSel, ySel, radioSel, radioSel);
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

	public double getRadio() {
		return radio;
	}

	public void setRadio(double radio) {
		this.radio = radio;
	}

	public double getAnguloInicio() {
		return anguloInicio;
	}

	public void setAnguloInicio(double anguloInicio) {
		this.anguloInicio = anguloInicio;
	}
	
	public double getAnguloActual() {
		return anguloActual;
	}

	public void setAnguloActual(double anguloActual) {
		this.anguloActual = anguloActual;
	}
	
	public double getAnguloGiro() {
		return anguloGiro;
	}

	public void setAnguloGiro(double anguloGiro) {
		this.anguloGiro = anguloGiro;
	}

	public TipoNodo getTipoNodo() {
		return tipoNodo;
	}

	public void setTipoNodo(TipoNodo tipoNodo) {
		this.tipoNodo = tipoNodo;
	}

	public Nodo getNodoPadre() {
		return nodoPadre;
	}

	public void setNodoPadre(Nodo nodoPadre) {
		this.nodoPadre = nodoPadre;
	}

	public Bicho getBicho() {
		return bicho;
	}

	public void setBicho(Bicho bicho) {
		this.bicho = bicho;
	}
}
