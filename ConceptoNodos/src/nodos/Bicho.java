package nodos;

import java.awt.Graphics2D;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;
import java.awt.event.MouseWheelEvent;
import java.awt.event.MouseWheelListener;
import java.util.ArrayList;
import java.util.List;

public class Bicho implements MouseListener, MouseMotionListener, MouseWheelListener, KeyListener {
	private int x;
	private int y;
	private List<Nodo> nodos;
	private Nodo nodoSeleccionado;
	private Nodo nodoCentral;
	private int puntero = 0;
	private boolean dragg;
	private boolean arriba, abajo;
	
	public Bicho(Pantalla pantalla) {
		x = 350;
		y = 350;
		pantalla.addMouseListener(this);
		pantalla.addMouseMotionListener(this);
		pantalla.addMouseWheelListener(this);
		pantalla.addKeyListener(this);
		
		reiniciarNodos();
		
		new Bucle(20) {
			@Override
			public void onBucle() {
				if(arriba) {
					y -= 1;
				}
				if(abajo) {
					y += 1;
				}
				if(arriba || abajo) {
					nodoCentral.mover();
				}
			}
		};
	}
	
	public void reiniciarNodos() {
		nodos = new ArrayList<Nodo>();
		Nodo cuerpo = new Nodo(this, TipoNodo.ESTATICO, 0, 0, 15);
		Nodo cabeza = new Nodo(this, TipoNodo.ESTATICO, 0, -80, 10);
		Nodo cola1 = new Nodo(this, TipoNodo.MOTOR, 0, 60, 7);
		Nodo cola2 = new Nodo(this, TipoNodo.MOTOR, 0, 100, 5);
		Nodo cola3 = new Nodo(this, TipoNodo.MOTOR, 0, 130, 3);
		Nodo ojoIzq = new Nodo(this, TipoNodo.ESTATICO, -40, -90, 5);
		Nodo ojoDrc = new Nodo(this, TipoNodo.ESTATICO, 40, -90, 5);
		cuerpo.getUniones().add(cabeza);
		cabeza.getUniones().add(ojoIzq);
		cabeza.getUniones().add(ojoDrc);
		cuerpo.getUniones().add(cola1);
		cola1.getUniones().add(cola2);
		cola2.getUniones().add(cola3);
		nodoSeleccionado = nodos.get(puntero);
		nodoCentral = cuerpo;
	}
	
	public void pintar(Graphics2D g) {
		for(Nodo nodo : nodos) {
			nodo.pintar(g);
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
	
	public List<Nodo> getNodos() {
		return nodos;
	}
	
	public Nodo getNodoSeleccionado() {
		return nodoSeleccionado;
	}

	@Override
	public void mouseClicked(MouseEvent e) {
	}

	@Override
	public void mouseEntered(MouseEvent e) {
	}

	@Override
	public void mouseExited(MouseEvent e) {
	}

	@Override
	public void mousePressed(MouseEvent e) {
		if(e.getButton() == MouseEvent.BUTTON3) {
			dragg = true;
			nodoSeleccionado.setX(e.getX() - x);
			nodoSeleccionado.setY(e.getY() - y);
		}
	}

	@Override
	public void mouseReleased(MouseEvent e) {
		if(e.getButton() == MouseEvent.BUTTON3) {
			dragg = false;
		}
	}

	@Override
	public void mouseDragged(MouseEvent e) {
		if(dragg) {
			nodoSeleccionado.setX(e.getX() - x);
			nodoSeleccionado.setY(e.getY() - y);
		}		
	}

	@Override
	public void mouseMoved(MouseEvent e) {
	}

	@Override
	public void mouseWheelMoved(MouseWheelEvent e) {
		if(e.getWheelRotation() < 0) {
			puntero = puntero + 1 >= nodos.size() ? 0 : puntero + 1;
		} else {
			puntero = puntero - 1 < 0 ? nodos.size() - 1 : puntero - 1;
		}
		nodoSeleccionado = nodos.get(puntero);
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
		}
	}

	@Override
	public void keyTyped(KeyEvent e) {
	}
}
