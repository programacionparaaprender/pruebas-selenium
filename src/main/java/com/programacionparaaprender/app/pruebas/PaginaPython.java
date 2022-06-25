package com.programacionparaaprender.app.pruebas;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import lombok.AllArgsConstructor;
import lombok.Data;


@Data
@AllArgsConstructor
public class PaginaPython implements Runnable {
	private String urlWeb;
	private int id;
	private int sleep;
	private String ip;
	private String puerto;
	private String version;
	private int menuSeleccionado;
	private int subMenuSeleccionado;
	public PaginaPython(String urlWeb, int id, int sleep, String version, int menuSeleccionado, int subMenuSeleccionado) {
		this.urlWeb = urlWeb;
		this.id = id;
		this.sleep = sleep;
	}
	
	public void run() {
		try{
			if(true) {
				System.setProperty("webdriver.chrome.driver", "C:/Users/Bus209/Downloads/chromedriver_win32/chromedriver.exe");
				WebDriver driver=(WebDriver)new ChromeDriver();
				driver.manage().window().maximize();
				driver.get("https://www.python.org/");
				driver.navigate();
				WebElement link1 = driver.findElement(By.linkText("Windows"));
	            link1.sendKeys(Keys.ENTER);
				
				Thread.sleep(sleep);
				driver.close();
				
			}
		 }catch(Exception e){
			 javax.swing.JOptionPane.showMessageDialog(null, e.getMessage());
         }
	}
}
