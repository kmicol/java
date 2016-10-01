package test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.concurrent.TimeUnit;

import org.apache.log4j.BasicConfigurator;
import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

public class WorldBankData {
	
	
	 	

	public static void main(String[] args) throws InterruptedException  {
		
	
		BasicConfigurator.configure();						//
		Logger log = Logger.getLogger("WorldBankData");		// For custom logging options
		PropertyConfigurator.configure("log4j.properties"); //
		
		// Text needed for Selenium to run firefox
			System.setProperty("webdriver.gecko.driver", "C:\\Users\\Kevin\\Downloads\\geckodriver-v0.10.0-win64\\geckodriver.exe");
			WebDriver driver = new FirefoxDriver();
		
		//Text needed for chrome
		//System.setProperty("webdriver.chrome.driver", "C:\\Users\\Kevin\\Downloads\\chromedriver_win32\\chromedriver.exe");
		//WebDriver driver = new ChromeDriver();
	
		 
		//Text needed to run IE
		//System.setProperty("webdriver.ie.driver", "C:\\Users\\Kevin\\Downloads\\IEDriverServer_x64_2.53.1\\IEDriverServer.exe");
		//WebDriver driver = new InternetExplorerDriver();
		
		String baseUrl = "http://www.worldbank.org/";
		driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);
	

		//Open Home page
		driver.get(baseUrl + "/");
		//click Countries
		driver.findElement(By.xpath(".//*[@id='hf_header_wrapper']/div/ul[2]/li[9]/a")).click();
		
		//wait a few moments
		Thread.sleep(400);
		
		//Get total number of Countries in list 
		List<WebElement> countryList = driver.findElements(By.xpath(".//*[@class='name-country']//a"));
		
		ArrayList<String> listofcountries = new ArrayList<String>();
		
		String country = "";
		String population = "" ;
		String GDP = "";
		String GDPgrow = "";
		
		//For loop, Clicks on every country, logs data
		try{
		
		System.out.println(countryList.size());
		for(int i=180; i<=countryList.size();i++){
			System.out.println(countryList.get(i).getText());
			WebElement countryLink = countryList.get(i);
			countryLink.click();
			
			//listofcountries.add(driver.findElement(By.xpath("html/body/div[5]/div[1]/div[2]/div[1]/div/div/div/div/div/div/div/div")).getText() +" "+ driver.findElement(By.className("c01v1-country-amounts")).getText() + " "+ driver.findElement(By.xpath("html/body/div[5]/div[2]/div[1]/div[1]/div[2]/div[2]/table/tbody/tr[2]/td[2]")).getText()+ " "+driver.findElement(By.xpath("html/body/div[5]/div[2]/div[1]/div[1]/div[2]/div[2]/table/tbody/tr[3]/td[2]")).getText()); //countryName
			//listofcountries.add(driver.findElement(By.className("c01v1-country-amounts")).getText());   //countryPopulation
			//listofcountries.add(driver.findElement(By.xpath("html/body/div[5]/div[2]/div[1]/div[1]/div[2]/div[2]/table/tbody/tr[2]/td[2]")).getText()); // GDP
			//listofcountries.add(driver.findElement(By.xpath("html/body/div[5]/div[2]/div[1]/div[1]/div[2]/div[2]/table/tbody/tr[3]/td[2]")).getText()); //GDP growth
			try{
			country = driver.findElement(By.xpath("html/body/div[5]/div[1]/div[2]/div[1]/div/div/div/div/div/div/div/div")).getText();
			population = driver.findElement(By.className("c01v1-country-amounts")).getText();
			GDP = driver.findElement(By.xpath("html/body/div[5]/div[2]/div[1]/div[1]/div[2]/div[2]/table/tbody/tr[2]/td[2]")).getText();
			GDPgrow = driver.findElement(By.xpath("html/body/div[5]/div[2]/div[1]/div[1]/div[2]/div[2]/table/tbody/tr[3]/td[2]")).getText();
			
			Double pop= Double.parseDouble(population.replaceAll("[^0-9\\.]+", ""));
			Double gdp= Double.parseDouble(GDP.replaceAll("[^0-9\\.]+", ""));
			Double gdpgrow= Double.parseDouble(GDPgrow.replaceAll("[^0-9\\.]+", ""));
			
			
			listofcountries.add( country + " " + pop + " Millon $" + gdp + " Billion " + gdpgrow + "%\n");
			
			}catch(Exception e){
				log.info("No data for country");
			}
			Thread.sleep(100);
			
			//Restart loop from Countries page
			driver.navigate().back();
			countryList = driver.findElements(By.xpath(".//*[@class='name-country']//a"));
			Thread.sleep(100);
		}	}catch(Exception t){
				log.info("End of list");
			}
		
		
		Collections.sort(listofcountries);
		
		
			
			System.out.println(listofcountries);
			
		
		//log.info("\n" + country + "'s population: " + population + "\nGDP:             " + GDP + "\nGDP growth:       " + GDPgrow + "\n");
		driver.findElement(By.xpath(".//*[@id='navbar-collapse1']/div/ul/li[10]/a")).click();
		Thread.sleep(1000);
		driver.quit();
		
		
		
		
		
		
		
	
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
	

		

		


		
		


		
		
		
	

	
		
	}

	private static Object session() {
		// TODO Auto-generated method stub
		return null;
	}

}
