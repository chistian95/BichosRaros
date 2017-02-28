package nodos2;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.image.BufferedImage;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JFrame;

public class Pantalla extends JFrame implements KeyListener {
	private static final long serialVersionUID = -3048304974009662970L;
	private BufferedImage bf;
	private Lanzador lanzador;
	private List<Boton> botones;
	
	public Pantalla(Lanzador lanzador) {
		this.lanzador = lanzador;
		setUndecorated(true);
		setSize(700, 700);
		setLocationRelativeTo(null);
		
		addKeyListener(this);		
		bf = new BufferedImage(700, 700, BufferedImage.TYPE_INT_ARGB);
		
		botones = new ArrayList<Boton>();
		botones.add(new Boton(this, 0, 650, 100, 50, "REINICIAR") {
			@Override
			public void onClick() {
				lanzador.getBicho().reiniciarNodos();
			}
		});
	}
	
	public void comenzar() {
		setVisible(true);
		new Bucle() {
			@Override
			public void onBucle() {
				repaint();
			}
		};
	}
	
	@Override
	public void paint(Graphics g) {
		Graphics2D g2d = (Graphics2D) bf.getGraphics();
		g2d.setColor(Color.WHITE);
		g2d.fillRect(0, 0, 700, 700);
		
		lanzador.getBicho().pintar(g2d);
		
		for(Boton boton : botones) {
			boton.pintar(g2d);
		}
		
		g.drawImage(bf, 0, 0, null);
	}

	@Override
	public void keyPressed(KeyEvent e) {
		if(e.getKeyCode() == KeyEvent.VK_ESCAPE) {
			System.exit(0);
		}
	}

	@Override
	public void keyReleased(KeyEvent e) {
	}

	@Override
	public void keyTyped(KeyEvent e) {
	}
	
}
