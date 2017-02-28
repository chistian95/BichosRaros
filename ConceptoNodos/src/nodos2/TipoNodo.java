package nodos2;

import java.awt.Color;

public enum TipoNodo {
	ESTATICO(new Color(0, 255, 0, 64)),
	MOTOR(new Color(255, 0, 0, 64)),
	PINCHO(new Color(0, 0, 255, 64)),
	OJO(new Color(255, 255, 0, 64));
	
	private Color color;
	
	private TipoNodo(Color color) {
		this.color = color;
	}
	
	public Color getColor() {
		return color;
	}
}
