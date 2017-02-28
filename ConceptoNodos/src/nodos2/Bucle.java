package nodos2;

public abstract class Bucle extends Thread {
	private long tiempo;
	private boolean parar;
	
	public Bucle() {
		this(20);
	}
	
	public Bucle(long tiempo) {
		this.tiempo = tiempo;
		start();
	}
	
	public void parar() {
		parar = true;
	}
	
	public abstract void onBucle();
	
	@Override
	public void run() {
		while(!parar) {
			try {
				Thread.sleep(tiempo);
				onBucle();
			} catch(Exception e) {
				e.printStackTrace();
			}
		}
	}
}
