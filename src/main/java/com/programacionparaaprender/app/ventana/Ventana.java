package com.programacionparaaprender.app.ventana;

import java.awt.Font;

import javax.swing.*;

import com.programacionparaaprender.app.pruebas.Multihilo;

public class Ventana extends JFrame{
	java.util.LinkedList<Thread> hilos;
	JLabel lblNClientes;
	JTextField txtNClientes;
	JLabel lblSleep;
	JTextField txtSleep;
	JButton btnIniciar;
	JButton btnDetener;
	public Ventana() {
		setTitle("Testeo Web");
		hilos= new java.util.LinkedList<Thread>();
		this.setVisible(true);
		this.setSize(new java.awt.Dimension(500,300));
		this.setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
		
		setLayout(null);
		lblNClientes = new JLabel("N° clientes: ");
		lblNClientes.setBounds(10, 10, 100, 40);
		lblNClientes.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblNClientes.setVisible(true);
        add(lblNClientes);
		
        txtNClientes = new JTextField("1");
        txtNClientes.setBounds(110, 10, 100, 40);
        txtNClientes.setFont(new Font("Tahoma", Font.BOLD, 14));
        txtNClientes.setVisible(true);
        add(txtNClientes);
        
        
        lblSleep = new JLabel("Milisegundos: ");
        lblSleep.setBounds(10, 50, 100, 40);
        lblSleep.setFont(new Font("Tahoma", Font.BOLD, 14));
        lblSleep.setVisible(true);
        add(lblSleep);
        
        
        txtSleep = new JTextField("2000");
        txtSleep.setBounds(110, 50, 100, 40);
        txtSleep.setFont(new Font("Tahoma", Font.BOLD, 14));
        txtSleep.setVisible(true);
        add(txtSleep);
        
        btnIniciar = new JButton("Iniciar");
        btnIniciar.setBounds(10, 90, 100, 40);
        btnIniciar.setFont(new Font("Tahoma", Font.BOLD, 14));
        btnIniciar.setVisible(true);
        add(btnIniciar);
        

        btnIniciar.addActionListener(new java.awt.event.ActionListener() {

            @Override
            public void actionPerformed(java.awt.event.ActionEvent e) {
            	try {
            		if(txtNClientes.getText().length() == 0) {
            			javax.swing.JOptionPane.showMessageDialog(null, "Debe colocar número de clientes");
            			return;
            		}
            		if(txtSleep.getText().length() == 0) {
            			javax.swing.JOptionPane.showMessageDialog(null, "Debe colocar tiempo de espera en milisegundos");
            			return;
            		}
            		int cantidadHilo = Integer.parseInt(txtNClientes.getText());
                	int sleep = Integer.parseInt(txtSleep.getText());
                	iniciar(cantidadHilo, sleep);
            	}catch(Exception ex) {
            		javax.swing.JOptionPane.showMessageDialog(null, ex.getMessage());
            	}
            }
        });
        
        
        btnDetener = new JButton("Detener");
        btnDetener.setBounds(110, 90, 100, 40);
        btnDetener.setFont(new Font("Tahoma", Font.BOLD, 14));
        btnDetener.setVisible(true);
        add(btnDetener);
        btnDetener.addActionListener(new java.awt.event.ActionListener() {

            @Override
            public void actionPerformed(java.awt.event.ActionEvent e) {
            	detener();
            }
        });
        
	}
	public void detener() {
		for(Thread h: hilos) {
			h.stop();
		
		}
		hilos.clear();
	}
	public void iniciar(int cantidadHilo, int sleep) {
		for(Thread h: hilos) {
			h.stop();
		}
		hilos.clear();
		for(int i = 0; i < cantidadHilo; i++) {
			Multihilo mul = new Multihilo(i + 1, sleep);
			Thread h=new Thread(mul);
			hilos.add(h);
			h.start();
		}
	}
}