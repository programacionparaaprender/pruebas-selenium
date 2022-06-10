package com.programacionparaaprender.app.pruebas;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class Multihilo implements Runnable {

	public void run() {
		while(true) {
			try{
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
				
              Thread.sleep(200); 
          }catch(Exception e){
        	  
          }
		}
		
	}

}
