package com.programacionparaaprender.app.pruebas;

import lombok.Data;


@Data
public class Repetidor implements Runnable {
	java.util.LinkedList<Thread> hilos;
	private int sleep;
	private int cantidadHilo;
	private Boolean valor = true;
	public Repetidor(int cantidadHilo, int sleep) {
		this.cantidadHilo = cantidadHilo;
		this.sleep = sleep;

		hilos = new java.util.LinkedList<Thread>();
	}
	
	
	@Override
	public void run() {
		while(valor) {	
			try {
				iniciar();	
				Thread.sleep(10000);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}
	
	public void iniciar() {
		for(Thread h: hilos) {
			h.stop();
		}
		hilos.clear();
		for(int i = 0; i < cantidadHilo; i++) {	
			Runnable mul = new Multihilo(i + 1, sleep);
			Thread h=new Thread(mul);
			hilos.add(h);
			h.start();
		}
	}
	
	
	public void detener() {
		for(Thread h: hilos) {
			h.stop();	
		}
		hilos.clear();
	
	}

}
