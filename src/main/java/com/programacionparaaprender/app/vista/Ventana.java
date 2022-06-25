package com.programacionparaaprender.app.vista;

import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.awt.Font;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;

import com.programacionparaaprender.app.pruebas.Repetidor;

public class Ventana extends JFrame {

	private JPanel contentPane;
	
	private static final long serialVersionUID = 1L;

	java.util.LinkedList<Thread> hilos;
	
	JLabel lblMenu;
	JComboBox cbMenu;
	
	
	JLabel lblSubMenu;
	JComboBox cboSubMódulos;
	
	
	JLabel lblNClientes;
	JTextField txtNClientes;
	JLabel lblSleep;
	JTextField txtSleep;
	JButton btnIniciar;
	JButton btnDetener;
	Repetidor repetidor = null;
	Thread hilo;
	private void initComponents() {
		setTitle("Testeo Web");
		hilos= new java.util.LinkedList<Thread>();
		this.setVisible(true);
		this.setSize(new java.awt.Dimension(800, 400));
		this.setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
		
		getContentPane().setLayout(null);
		
		int y = 10;
		int height = 360;
		


		String s1[] = { "Seleccionar", "Webs Lenguajes", "Webs IDE's" };
		
		lblMenu = new JLabel("Menú: ");
		lblMenu.setBounds(10, y, height, 40);
		lblMenu.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblMenu.setVisible(true);
        getContentPane().add(lblMenu);
		
        cbMenu = new JComboBox(s1);
     
        
        cbMenu.addActionListener(new java.awt.event.ActionListener() {
            @Override
            public void actionPerformed(java.awt.event.ActionEvent e) {
            	try {
            		int seleccionado = 0;
            		seleccionado = cbMenu.getSelectedIndex();
            		cboSubMódulos.removeAllItems();
            		switch(seleccionado) {
                		case 1: 
                			cboSubMódulos.addItem("Web python");
                			cboSubMódulos.addItem("Web java");

                			break;
                		
                		case 2:
                			cboSubMódulos.addItem("Apache eclipse");
                			break;
                		default:
                			break;
                	}
            	}catch(Exception ex) {
            		javax.swing.JOptionPane.showMessageDialog(null, ex.getMessage());
            	}
            }
        });
        
        
        cbMenu.setBounds(height, y, height, 40);
        cbMenu.setFont(new Font("Tahoma", Font.BOLD, 14));
        cbMenu.setVisible(true);
        getContentPane().add(cbMenu);
		
		
        
        lblSubMenu = new JLabel("SubMenú: ");
        lblSubMenu.setBounds(10, y * 5, height, 40);
        lblSubMenu.setFont(new Font("Tahoma", Font.BOLD, 14));
        lblSubMenu.setVisible(true);
        getContentPane().add(lblSubMenu);
		
        cboSubMódulos = new JComboBox();
        cboSubMódulos.setBounds(height, y * 5, height, 40);
        cboSubMódulos.setFont(new Font("Tahoma", Font.BOLD, 14));
        cboSubMódulos.setVisible(true);
        getContentPane().add(cboSubMódulos);
        
        
		
		lblNClientes = new JLabel("N° Clientes: ");
		lblNClientes.setBounds(10, y * 17, height, 40);
		lblNClientes.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblNClientes.setVisible(true);
        getContentPane().add(lblNClientes);
		
        txtNClientes = new JTextField("1");
        txtNClientes.setBounds(height, y * 17, height, 40);
        txtNClientes.setFont(new Font("Tahoma", Font.BOLD, 14));
        txtNClientes.setVisible(true);
        getContentPane().add(txtNClientes);
        
        
        lblSleep = new JLabel("Milisegundos: ");
        lblSleep.setBounds(10, y * 21, height, 40);
        lblSleep.setFont(new Font("Tahoma", Font.BOLD, 14));
        lblSleep.setVisible(true);
        getContentPane().add(lblSleep);
        
        
        txtSleep = new JTextField("2000");
        txtSleep.setBounds(height, y * 21, height, 40);
        txtSleep.setFont(new Font("Tahoma", Font.BOLD, 14));
        txtSleep.setVisible(true);
        getContentPane().add(txtSleep);
        
        btnIniciar = new JButton("Iniciar");
        btnIniciar.setBounds(10, y * 25, 100, 40);
        btnIniciar.setFont(new Font("Tahoma", Font.BOLD, 14));
        btnIniciar.setVisible(true);
        getContentPane().add(btnIniciar);
        

        btnIniciar.addActionListener(new java.awt.event.ActionListener() {
            @Override
            public void actionPerformed(java.awt.event.ActionEvent e) {
            	try {
            		
            		int menuSeleccionado = cbMenu.getSelectedIndex();
            		
            		
            		if(menuSeleccionado < 1) {
            			javax.swing.JOptionPane.showMessageDialog(null, "Debe seleccionar un menú");
            			return;
            		}
            		
            		int subMenuSeleccionado = cboSubMódulos.getSelectedIndex();
            		if(subMenuSeleccionado < 0) {
            			javax.swing.JOptionPane.showMessageDialog(null, "Debe seleccionar un submenú");
            			return;
            		}
            		
            		
            		if(txtNClientes.getText().length() == 0) {
            			javax.swing.JOptionPane.showMessageDialog(null, "Debe colocar número de clientes");
            			return;
            		}
            		if(txtSleep.getText().length() == 0) {
            			javax.swing.JOptionPane.showMessageDialog(null, "Debe colocar tiempo de espera en milisegundos");
            			return;
            		}
 
            		String urlWeb = "";
                	String puerto = txtSleep.getText();
            		int cantidadHilo = Integer.parseInt(txtNClientes.getText());
                	int sleep = Integer.parseInt(txtSleep.getText());
                	String version = "";
                	iniciar(urlWeb, puerto, cantidadHilo, sleep, version, menuSeleccionado, subMenuSeleccionado);
                	
                	
            	}catch(Exception ex) {
            		javax.swing.JOptionPane.showMessageDialog(null, ex.getMessage());
            	}
            }
        });
        
        
        btnDetener = new JButton("Detener");
        btnDetener.setBounds(110, y * 25, 100, 40);
        btnDetener.setFont(new Font("Tahoma", Font.BOLD, 14));
        btnDetener.setVisible(true);
        getContentPane().add(btnDetener);
        btnDetener.addActionListener(new java.awt.event.ActionListener() {
            @Override
            public void actionPerformed(java.awt.event.ActionEvent e) {
            	detener();
            }
        });
	}
	public void detener() {
		if(repetidor == null) {
			repetidor = new Repetidor("", 0, 0, "", 0, 0);
			repetidor.setValor(false);
			hilo.stop();
			hilo = new Thread(repetidor);	
		}else {
			repetidor.setValor(false);
    		hilo.stop();
    		hilo = new Thread(repetidor);
    		repetidor.setValor(true);
		}
		
	}
	public void iniciar(String ip, String puerto, int cantidadHilo, int sleep, String version, int menuSeleccionado, int subMenuSeleccionado) {
		if(repetidor == null) {
    		repetidor = new Repetidor(ip, cantidadHilo, sleep, version, menuSeleccionado, subMenuSeleccionado);
    		hilo = new Thread(repetidor);
    		hilo.start();
    	}
		else {
    		repetidor.setValor(false);
    		hilo.stop();
    		repetidor = new Repetidor(ip, cantidadHilo, sleep, version, menuSeleccionado, subMenuSeleccionado);
    		hilo = new Thread(repetidor);
    		repetidor.setValor(true);
    		hilo.start();
    	}

	}
	
	/**
	 * Create the frame.
	 */
	public Ventana() {

		initComponents();
	}

}
