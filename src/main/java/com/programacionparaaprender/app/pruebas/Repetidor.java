package com.programacionparaaprender.app.pruebas;

import lombok.Data;


@Data
public class Repetidor implements Runnable {
	java.util.LinkedList<Thread> hilos;
	private String urlWeb;
	private String puerto;
	private int sleep;
	private int cantidadHilo;
	private Boolean valor = true;
	private String version;
	private int módulo;
	private int submódulo;
	private int menuSeleccionado;
	private int subMenuSeleccionado;
	
	
	public Repetidor(String urlWeb, int cantidadHilo, int sleep, String version, int menuSeleccionado, int subMenuSeleccionado) {
		this.urlWeb = urlWeb;
		this.cantidadHilo = cantidadHilo;
		this.sleep = sleep;
		this.version = version;
		
		this.menuSeleccionado = menuSeleccionado;
		this.subMenuSeleccionado = subMenuSeleccionado;
		
		hilos = new java.util.LinkedList<Thread>();
	}
	
	
	@Override
	public void run() {
		while(valor) {	
			try {
				iniciar();	
				int sleep1 = 0;
				switch(this.menuSeleccionado) {
					case 1:
						switch(this.subMenuSeleccionado) {
							case 0:
								sleep1 = 10000;
								break;
							default:
								sleep1 = 10000;
								break;
						}
						break;
					default:
						sleep1 = 10000;
						break;
				}
				Thread.sleep(sleep1);
			} catch (InterruptedException e) {

				e.printStackTrace();
			}
		}
	}
	
	public Runnable getSubMenuSeleccionado(int i) {
		Runnable mul = null;
		switch(this.menuSeleccionado) {
			case 1:
				switch(this.subMenuSeleccionado) {
					case 0:
						mul = new PaginaPython(urlWeb, i + 1, sleep, version, menuSeleccionado, subMenuSeleccionado);
						break;
					default:
						mul = new PaginaJava(urlWeb, i + 1, sleep, version, menuSeleccionado, subMenuSeleccionado);
						break;
				}
				break;
			default:
				
				break;
		}
		return mul;
	}
	
	public void iniciar() {
		for(Thread h: hilos) {
			h.stop();
		}
		hilos.clear();
		for(int i = 0; i < cantidadHilo; i++) {	
			Runnable mul = getSubMenuSeleccionado(i);
			if(mul != null) {
				Thread h=new Thread(mul);
				hilos.add(h);
				h.start();
			}
		}
		if(hilos.size() == 0) {
			javax.swing.JOptionPane.showMessageDialog(null, "Submódulo aun no se ha creado.");
		}
	}
	
	
	public void detener() {
		for(Thread h: hilos) {
			h.stop();	
		}
		hilos.clear();
	
	}

}
