package com.programacionparaaprender.app.pruebas;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Iterator;
import java.util.List;
import java.util.Set;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.FindBy;

import lombok.Data;
import lombok.AllArgsConstructor;

@Data
@AllArgsConstructor
public class Multihilo implements Runnable {
	private int id;
	private int sleep;
	public void run() {
		try{
		while(true) {
			
				DateFormat dateFormat = new SimpleDateFormat("YYYY/MM/dd HH:mm:ss");
				Date primeraHora = new Date();
				System.out.println("Id: " + String.valueOf(id) + " Primer Hora: ");
				System.setProperty("webdriver.chrome.driver", "C:/Users/Bus209/Downloads/chromedriver_win32/chromedriver.exe");

				WebDriver driver=(WebDriver)new ChromeDriver();

				//driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

				driver.manage().window().maximize();

				driver.get("https://www.python.org/");
		
				driver.navigate();
				
				WebElement link1 = driver.findElement(By.linkText("Windows"));
	            link1.sendKeys(Keys.ENTER);
	            Thread.sleep(2000);

	            WebElement link2 = driver.findElement(By.linkText("Latest Python 3 Release - Python 3.10.5"));
	            link2.sendKeys(Keys.ENTER);
	            Thread.sleep(2000);
	          
	            
				Date segundaHora = new Date();

				
				System.out.println("Id: " + String.valueOf(id) + " Segunda Hora: " + dateFormat.format(segundaHora));
				
				driver.quit();
				// close only the child browser window
				driver.close();
				
              Thread.sleep(sleep); 
         
		}
		 }catch(Exception e){
       	  System.out.println(e.getMessage());
         }
	}

	public boolean findElement(WebElement element, int time ) throws InterruptedException {
		 
		boolean valor = false;
		
		for (int i = 0 ; i<=time ; i++) {
			
			try {		
				valor = element.isDisplayed();
			} catch (Exception e) {
		
			}
		}	
		 return valor;
	 }


 public void clickOverLoop(WebElement element , String text , String tag) throws InterruptedException {
	 System.out.println(tag);
	 if(findElement(element, 4)) {
		 List<WebElement> select = element.findElements(By.tagName(tag));
		 System.out.println(select);
		 for (WebElement e : select) {
				System.out.println(e);
			if(e.getText().equals(text)) {
			
				e.click();
			}
		
		}	 
	 }
	 else {
		 System.out.println("no se encuentra web element");
	 }
	 
 }

}
