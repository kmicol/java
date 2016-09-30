package test;

import java.util.List;
import java.util.concurrent.TimeUnit;

import org.apache.log4j.BasicConfigurator;
import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

public class WorldBankData {
	
	
	

	public static void main(String[] args) throws InterruptedException  {
		
		BasicConfigurator.configure();
		Logger log = Logger.getLogger("WorldBankData");
		PropertyConfigurator.configure("log4j.properties");
		
		
		System.setProperty("webdriver.gecko.driver", "C:\\Users\\Kevin\\Downloads\\geckodriver-v0.10.0-win64\\geckodriver.exe");
		WebDriver driver = new FirefoxDriver();
		
	
		 
		
		//System.setProperty("webdriver.ie.driver", "C:\\Users\\Kevin\\Downloads\\IEDriverServer_x64_2.53.1\\IEDriverServer.exe");
		//WebDriver driver = new InternetExplorerDriver();
		
		String baseUrl = "http://www.worldbank.org/";
		driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);
	

		
		driver.get(baseUrl + "/");
		
		driver.findElement(By.xpath(".//*[@id='hf_header_wrapper']/div/ul[2]/li[9]/a")).click();
		Thread.sleep(2000);
		
		List<WebElement> countryList = driver.findElements(By.xpath(".//*[@id='alphaA' or @id='alphaB' or @id='alphaC' or @id='alphaD' or @id='alphaE' or @id='alphaF' or @id='alphaG' or @id='alphaH' or @id='alphaI' or @id='alphaJ' or @id='alphaK' or @id='alphaL' or @id='alphaM' or @id='alphaN' or @id='alphaO' or @id='alphaP' or @id='alphaQ' or @id='alphaR' or @id='alphaS' or @id='alphaT' or @id='alphaU' or @id='alphaV' or @id='alphaW' or @id='alphaX' or @id='alphaY' or @id='alphaZ']/ul[1]/li[*]"));
		
		System.out.println(countryList.size());
		
	//	for(int i=1; i<=countryList.size();i++){
	//		String n = Integer.toString(i);
	//		String locator =".//*[@id='alphaA']/ul[%%i%%]/li[1]/ul";
	//		locator = locator.replaceAll("%%i%%", n);
	//		String countryList1 = driver.findElement(By.xpath(locator)).getText();
		//	System.out.println(countryList1);
	//	}
		
		
		
		//Thread.sleep(2000);
		//for(int i=1; i<=2; i++) {
		//driver.findElement(By.xpath(".//*[@id='alphaA']/ul[1]/li[1]/ul/li/span/a")).click();
	//	} 
		
		
		//String country = driver.findElement(By.className("c01v1-page-title")).getText();
		//String population = driver.findElement(By.className("c01v1-country-amounts")).getText();
		//String GDP = driver.findElement(By.className("c01v1-country-amounts")).getText();
		//String GDPgrow = driver.findElement(By.className("c01v1-country-amounts")).getText();
		//log.info("\n" + country + "'s population: " + population + "\nGDP:                    " + GDP + "\nGDP growth:             " + GDPgrow);
		//Thread.sleep(2000);
		
		//for(int i=1; i<=5; i++) {
		//driver.findElement(By.xpath("//a[contains(text(),'Countries')]")).click();
		//}
		
		
		
		
		
		
		
		
		
		
	

		

		


		
		


		
		
		
	

	
		
	}

	private static Object session() {
		// TODO Auto-generated method stub
		return null;
	}

}
