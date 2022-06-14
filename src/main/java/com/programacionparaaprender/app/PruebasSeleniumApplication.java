package com.programacionparaaprender.app;

import java.util.concurrent.TimeUnit;

import javax.swing.JFrame;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.FindBy;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.programacionparaaprender.app.pruebas.Multihilo;
import com.programacionparaaprender.app.ventana.Ventana;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;

@SpringBootApplication
public class PruebasSeleniumApplication {

	public static void main(String[] args) {
		
		try {
			//[Metal, Nimbus, CDE/Motif, Windows, Windows Classic]
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("CDE/Motif"/*"CDE/Motif"*/ .equals(info.getName())) {//"Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException | InstantiationException | IllegalAccessException | javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(JFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            @Override
            public void run() {
            	/*
            	java.util.LinkedList<String> estilos = new java.util.LinkedList<String>();
            	for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
            		estilos.add(info.getName());  
            		System.out.println(info.getName());
            	}
            	*/
            	Ventana ventana = new Ventana();
            	
                //MVentana mve=new MVentana(25,16);
                //VVentana vve=new VVentana(mve);
                //CVentana eVentana = new CVentana(vve,mve);
            }
        });
		//SpringApplication.run(SeleniumEscritorioApplication.class, args);
	}

}
