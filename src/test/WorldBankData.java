package test;
import java.util.Comparator;
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
	
	
	 	static ArrayList<Integer> array = new ArrayList<Integer>();

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
		driver.manage().timeouts().implicitlyWait(2, TimeUnit.SECONDS);
	

		//Open Home page
		driver.get(baseUrl + "/");
		//click Countries
		driver.findElement(By.xpath(".//*[@id='hf_header_wrapper']/div/ul[2]/li[9]/a")).click();
		
		//wait a few moments
		Thread.sleep(400);
		
		//Get total number of Countries in list 
		List<WebElement> countryList = driver.findElements(By.xpath(".//*[@class='name-country']//a"));
		
		ArrayList<Player> listofcountries = new ArrayList<Player>();
		
		//Create Variables
		String country = "";
		String population = "" ;
		String GDP = "";
		String GDPgrow = "";
		
		//For loop, Clicks on every country, logs data
		try{
		System.out.println(countryList.size());
		for(int i=170; i<=countryList.size();i++){
			System.out.println(countryList.get(i).getText());
			WebElement countryLink = countryList.get(i);
			countryLink.click();
			
			try{	
			country = driver.findElement(By.xpath("html/body/div[5]/div[1]/div[2]/div[1]/div/div/div/div/div/div/div/div")).getText();
			population = driver.findElement(By.className("c01v1-country-amounts")).getText();
			GDP = driver.findElement(By.xpath("html/body/div[5]/div[2]/div[1]/div[1]/div[2]/div[2]/table/tbody/tr[2]/td[2]")).getText();
			GDPgrow = driver.findElement(By.xpath("html/body/div[5]/div[2]/div[1]/div[1]/div[2]/div[2]/table/tbody/tr[3]/td[2]")).getText();
			
			//Convert to double- Retain Decimals
			Double pop= Double.parseDouble(population.replaceAll("[^0-9\\.]+", ""));
			Double gdp= Double.parseDouble(GDP.replaceAll("[^0-9\\.]+", ""));
			Double gdpgrow= Double.parseDouble(GDPgrow.replaceAll("[^0-9\\.]+", ""));
			
			
			listofcountries.add(new Player(country, pop , gdp , gdpgrow));
			
			}catch(Exception e){
				System.out.println("No data for country");
			}
			Thread.sleep(50);
			
			//Restart loop from Countries page
			driver.navigate().back();
			countryList = driver.findElements(By.xpath(".//*[@class='name-country']//a"));
			//Thread.sleep(100);
		}	}catch(Exception t){
				System.out.println("End of list");
			}
		
		
		
	
		
		
		
		
			
		
		
	
		 
		//Sorting Via Population
		 Comparator<Player> bypop = (e2, e1) -> Double.compare(e1.getpop(),
					e2.getpop());
		 listofcountries .stream()
						 .sorted(bypop);
		 listofcountries.sort(bypop);
						
		 //Logging top 3 via Population
		ArrayList<Player> listofcountries2 = new ArrayList<Player>(listofcountries.subList(0,3));
		log.info("\nTop 3 countries by Population: " +listofcountries2);
		
		
		
		//Sorting Via Gdp Growth
		 Comparator<Player> bygdpG = (e2, e1) -> Double.compare(e1.getgdpG(),
					e2.getgdpG());
		 listofcountries .stream()
						 .sorted(bygdpG);
		 listofcountries.sort(bygdpG);
						
		 //Logging top 3 via Population
		ArrayList<Player> listofcountries3 = new ArrayList<Player>(listofcountries.subList(0,3));
		log.info("\nTop 3 countries by GDP Growth: " +listofcountries3);
		
		
		 
		driver.findElement(By.xpath(".//*[@id='navbar-collapse1']/div/ul/li[10]/a")).click();
		Thread.sleep(1000);
		driver.quit();
		
		
		
		
		
		
		
	
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
	

		

		


		
		


		
		
		
	

	
		
	}

	private static Object session() {
		// TODO Auto-generated method stub
		return null;
	}

}
