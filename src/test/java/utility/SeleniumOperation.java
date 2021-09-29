package utility;


import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;


public class SeleniumOperation
{
	  
	
      public  static WebDriver driver=null;
      
  
 
  	//open browser
  	public static void browserLaunch(Object[] inputParameters)
  	{		
  		
  		try
  		{          
  		  String strBroserName=(String)inputParameters[0];
  		  String webDriverExePath=(String)inputParameters[1];
  		                 
  	  if(strBroserName.equalsIgnoreCase("Chrome"))
  			  {
 		           		       
  				  System.setProperty("webdriver.chrome.driver",webDriverExePath);			
  					 driver=new ChromeDriver();
  				  driver.manage().window().maximize();
  				  driver.manage().timeouts().implicitlyWait(60, TimeUnit.SECONDS);
  			  }
  	  else if(strBroserName.equalsIgnoreCase("FF"))
  			  {
  				  System.setProperty("webdriver.gecko.driver",webDriverExePath);			
  					 driver=new FirefoxDriver();
  				  driver.manage().window().maximize();
  				  driver.manage().timeouts().implicitlyWait(60, TimeUnit.SECONDS);
  			  }	
  	 		
  		}
  		catch(Exception e)
  		{
  		  System.out.println(e);
  		}
  		
  		
  	}
  	
  	//openApplication
  	public static void openApplication(Object[] inputParameters)
  	{
  		try{
  		  		
  			String url=(String)inputParameters[0];
  		driver.get(url);
  		 driver.manage().timeouts().implicitlyWait(60, TimeUnit.SECONDS);
	
  	
  		}catch(Exception e)
  		{
  			 System.out.println(e);
  		}
  			
  	}
  	
  	//sendKey 
  	public static void sendKey(Object[] inputParameters)
  	{
  		try
  		{
  		String xpath1=(String)inputParameters[0];
  		String value1=(String)inputParameters[1];
  		
  		driver.findElement(By.xpath(xpath1)).sendKeys(value1);
  		 driver.manage().timeouts().implicitlyWait(60, TimeUnit.SECONDS);
  	
  		}catch(Exception e)
  		{
  			System.out.println(e);
  		}
  		  		
  	}
  	
  	//dropdown
  	public static void dropdown(Object[] inputParameters)
  	{
  		try{
  		String xpath1=(String)inputParameters[0];
  		String value=(String)inputParameters[1];
  		
  		Select sel=new Select(driver.findElement(By.xpath(xpath1)));
  		
  		sel.selectByVisibleText(value);
  		 driver.manage().timeouts().implicitlyWait(60, TimeUnit.SECONDS);
  		
  		
  		}catch(Exception e)
  		{
  			System.out.println(e);
  		}
  		 		
  	}
  	
  	//click
  	public static void click(Object[] inputParameters)
  	{
  		try{
  		String xpath=(String)inputParameters[0];	
  		driver.findElement(By.xpath(xpath)).click();
  		
  		Thread.sleep(5000);
  		 driver.manage().timeouts().implicitlyWait(60, TimeUnit.SECONDS);
  		 
  		
  		}catch(Exception e)
  		{
  			System.out.println(e);
  		}
  	
  	}
  	
      
	
	
	
	public static void mouseOver(Object[]inputParameters)
	{
		try
		{
		String elexpath=(String)inputParameters[0];
		Actions act=new Actions(driver);
		WebElement ele=driver.findElement(By.xpath(elexpath));
		act.moveToElement(ele).build().perform();
		System.out.println("Successfully moved to given element");
		Thread.sleep(1000);
	
		}
		catch(Exception e)
		{
			System.out.println(e);
		}
		
	}
	
	
	
	public static void validation(Object[] inputParameters)
  	{
  		try{
  		String given=(String)inputParameters[0];
  		String xpath=(String)inputParameters[1];
  		
  		String text=driver.findElement(By.xpath(xpath)).getText();
  		
  		if(text.equalsIgnoreCase(given))
  		{
  			System.out.println("Test Case pass");
  			
  		}else
  		{
  			System.out.println("Test Case Fail");
  		}
  		}catch(Exception e)
  		{
  			 System.out.println(e);
  			System.out.println("Test Case Fail");
  		}
  		
  		
  		 		
  	}
	
	
	
	public static void closeBrowserWindow() throws InterruptedException
	{
		//Thread.sleep(5000);
		driver.close();
	}
	
	
}