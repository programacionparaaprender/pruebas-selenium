package com.programacionparaaprender.app;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.FindBy;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.programacionparaaprender.app.pruebas.Multihilo;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;

@SpringBootApplication
public class PruebasSeleniumApplication {

	public static void prueba1() {

		System.setProperty("webdriver.chrome.driver", "C:/Users/lcorrea.LT-LCORREA/Downloads/chromedriver_win32/chromedriver.exe");

		WebDriver driver=(WebDriver)new ChromeDriver();

		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

		driver.manage().window().maximize();

		driver.get("https://www.facebook.com");

		driver.close();

		}
	public static void prueba2() {
		// TODO Auto-generated method stub
		System.setProperty("webdriver.chrome.driver", "C:/Users/lcorrea.LT-LCORREA/Downloads/chromedriver_win32/chromedriver.exe");
		WebDriver webDriver = (WebDriver)new ChromeDriver();
        //  webDriver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        webDriver.manage().window().maximize();
		// WebDriver driver =(WebDriver) new ChromeDriver();
		// driver.get("http://google.com");
	}
	
	
	public static void prueba0() {
		System.setProperty("webdriver.chrome.driver", "C:/Users/lcorrea.LT-LCORREA/Downloads/chromedriver_win32/chromedriver.exe");

		WebDriver driver=(WebDriver)new ChromeDriver();

		//driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

		driver.manage().window().maximize();

		driver.get("http://192.168.64.71:8080/HCENTER2_PMPM/");
		
		WebElement googleTextBoxUsuario = driver.findElement(By.name("usuario"));
		googleTextBoxUsuario.sendKeys("administrador");
		
		WebElement googleTextBoxPassword = driver.findElement(By.name("clave"));
		googleTextBoxPassword.sendKeys("123456");
		
		// @FindBy(xpath = "/html/body/map/area[2]")
		WebElement ingresar = driver.findElement(By.xpath("/html/body/map/area[2]"));
		ingresar.sendKeys(Keys.ENTER);
		
		
		WebElement menu = driver.findElement(By.xpath("/html[1]/body[1]/form[1]/table[1]/tbody[1]/tr[5]/td[1]/table[1]/tbody[1]/tr[1]"));
		System.out.println(menu.getText());
		
		driver.close();
	}
	
	public static void main(String[] args) {
		int cantidadHilo = 2;
		java.util.LinkedList<Multihilo> hilos = new java.util.LinkedList<Multihilo>();
		for(int i = 0; i < cantidadHilo; i++) {
			hilos.add(new Multihilo());
		}
		for(Multihilo mul: hilos) {
			Thread h=new Thread(mul);
            h.start();
		}
		SpringApplication.run(PruebasSeleniumApplication.class, args);
	}

}
