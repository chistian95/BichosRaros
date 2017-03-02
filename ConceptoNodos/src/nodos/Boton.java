package nodos;

import java.awt.Color;
import java.awt.FontMetrics;
import java.awt.Graphics2D;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

public abstract class Boton implements MouseListener {
	private int x;
	private int y;
	private int ancho;
	private int alto;
	private String texto;
	
	public Boton(Pantalla pantalla, int x, int y, int ancho, int alto, String texto) {
		this.x = x;
		this.y = y;
		this.ancho = ancho;
		this.alto = alto;
		this.texto = texto;
		pantalla.addMouseListener(this);
	}
	
	public abstract void onClick();
	
	public void pintar(Graphics2D g) {
		g.setColor(Color.BLUE);
		g.fillRect(x,  y, ancho, alto);
		
		g.setColor(Color.WHITE);
		FontMetrics metrics = g.getFontMetrics();
		int anchoTexto = metrics.stringWidth(texto);
		int altoTexto = metrics.getAscent();
		int tx = (x + ancho / 2) - (anchoTexto / 2);
		int ty = (y + alto / 2) + (altoTexto / 2);
		g.drawString(texto, tx, ty);
	}
	
	@Override
	public void mouseClicked(MouseEvent e) {
		if(e.getX() >= x && e.getX() <= x + ancho) {
			if(e.getY() >= y && e.getY() <= y + alto) {
				onClick();
			}
		}
	}

	@Override
	public void mouseEntered(MouseEvent e) {
	}

	@Override
	public void mouseExited(MouseEvent e) {
	}

	@Override
	public void mousePressed(MouseEvent e) {
	}

	@Override
	public void mouseReleased(MouseEvent e) {
	}
	
	public int getX1() {
		return x;
	}
	public void setX1(int x1) {
		this.x = x1;
	}
	public int getY1() {
		return y;
	}
	public void setY1(int y1) {
		this.y = y1;
	}
	public int getX2() {
		return ancho;
	}
	public void setX2(int x2) {
		this.ancho = x2;
	}
	public int getY2() {
		return alto;
	}
	public void setY2(int y2) {
		this.alto = y2;
	}
	public String getTexto() {
		return texto;
	}
	public void setTexto(String texto) {
		this.texto = texto;
	}
}
