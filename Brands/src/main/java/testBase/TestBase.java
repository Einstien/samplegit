package testBase;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class TestBase 
{
	public static WebDriver driver;
	static Properties prop;
	
	public TestBase()
	{
	try 
	{
		prop = new Properties();
		FileInputStream ip = new FileInputStream("C:\\Users\\Raja\\eclipse-workspace\\Brands\\src\\main\\java\\config\\Config.properties");
		prop.load(ip);
	} catch (FileNotFoundException e) 
	{
		e.printStackTrace();
	} catch (IOException e) 
	{
		e.printStackTrace();
	}
}

	public static void initialization()
    {
    	String browserName = prop.getProperty("browser");
    	if(browserName.equals("chrome"))
    	{
    		System.setProperty("webdriver.chrome.driver", "./drivers/chromedriver.exe");
    		driver = new ChromeDriver();
    	} else if(browserName.equals("Firefox"))
    	{
    		System.setProperty("webdriver.gecko.driver", "./drivers/geckodriver.exe");
    		driver = new FirefoxDriver();
    	}
    	
    	driver.manage().window().maximize();
    	driver.manage().deleteAllCookies();
    	driver.manage().timeouts().pageLoadTimeout(20,TimeUnit.SECONDS);
    	driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
    	
    	driver.get(prop.getProperty("url"));   	
    	    	
    }
    
    
    
}