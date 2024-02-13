package WebDriverManager;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.CucmberOneCommerce.Pages.TestContext;

public class WebdriverManager {
	//private HomePage homepage;
	private TestContext context;
	private WebdriverManager app;

	
	public WebdriverManager(TestContext context)
	{
		this.context=context;
		System.out.println("WEebdriver Construtor");
	}
	
	
	public void WaitToElement(String locator)
	{
	
		//WebDriverWait wait = new WebDriverWait(driver,20);
	//	wait.until(ExpectedConditions.presenceOfElementLocated(locator));
		//wait.until(ExpectedConditions.visibilityOfElementLocated(locator))
	}
	
	public void Open_Browser()
	{	
  	    System.out.println("in open broswer");

		String sBrowser_type= TestContext.getJsonValueForKey("Config","Browser");	
		System.out.println(sBrowser_type+"-------------------------Openeing up");
		if (sBrowser_type.equals("edge"))
		{
			System.out.println("opening edge.........");	
			context.driver = new EdgeDriver();				
		}else if(sBrowser_type.equals("chrome"))
		{	System.out.println("open chrome.........");	
				context.driver = new ChromeDriver();
		}	else if(sBrowser_type.equals("firefox"))
		{
				System.out.println("open firefox.........");	
				context.driver = new FirefoxDriver();
		}
	}
	
	
	public void navigate_url(String value) throws InterruptedException
	{
		context.driver.get(TestContext.getJsonValueForKey("Config",value));
		context.driver.manage().window().maximize();
		context.log(value+"____________opened successfully.........");
		Thread.sleep(5000);
	}
	
	
	
	public void Click(String locator)
	{	
		System.out.println(locator+" searching");
		FindWebElement(locator).click();
		context.log(locator+"______________Clicked successfully.........");
		
	}

	
	//Json value fetching from .json files under C:\Users\91869\eclipse-workspace\com.CucumberZoho\Json
	public void type(String value,String locator)
	{
		System.out.println("type*******"+value+" in input box");
		FindWebElement(locator).clear();
		FindWebElement(locator).sendKeys(TestContext.getJsonValueForKey("Config",value));
		context.log(locator+"______Value set on"+locator+ "______________text filed.........");

	}
	
	
	    
  // webdriver wait for specific elements   
    public void WaitForElement(String Locatorvalue,int timeinSeconds)
    {
    	
		 WebDriverWait wait = new WebDriverWait(context.driver,Duration.ofSeconds(timeinSeconds));
		// wait.until(ExpectedConditions.visibilityOfElementLocated(Locatorvalue));
    }

    
   //find webelemet via getlocator function 
    public WebElement FindWebElement(String Locatorvalue)
    {
    	WebElement e=null;
    	By sLocator =getLocator(Locatorvalue);
    	try {
    		System.out.println("xpath set find element function");
    		  e=context.driver.findElement(sLocator);
		 	}
    	catch(Exception ex)
    		{
    		context.Fail("Element not found", true);
    		System.out.println("not fpfoundund");
    		}
		return e;
    }
    
    
  //  
    public By getLocator(String Locator)
    {
    	
    	if (Locator.endsWith("_xpath")){
    	  	return By.xpath(TestContext.getJsonValueForKey("Locators",Locator));
    	}else if(Locator.endsWith("_className"))
    	{
    	  	return By.className(TestContext.getJsonValueForKey("Locators",Locator));
    	}
    	else if(Locator.endsWith("_name"))
    	{
    	  	return By.cssSelector(TestContext.getJsonValueForKey("Locators",Locator));

    	}else if(Locator.endsWith("_linkText"))
    	{    	  	return By.linkText(TestContext.getJsonValueForKey("Locators",Locator));
  		
    	}else if(Locator.endsWith("_tagName"))
    	{
        	    	  	return By.tagName(TestContext.getJsonValueForKey("Locators",Locator));

    	}else if(Locator.endsWith("_partialLinkText"))
    	{
    	  	return By.partialLinkText(TestContext.getJsonValueForKey("Locators",Locator));

    	}
		return null;
    	
    }

     
 //*************************VAlidation Functions****************************************
    public boolean VerifyTitle(String Expectedtitle)
    {
    	String Actualtitle=context.driver.getTitle();
    	if(Actualtitle.equalsIgnoreCase(Expectedtitle))
    	{   context.log(Actualtitle+"--------"+"displayed");
    		return true;
    	}
    	else {
    		context.log(Actualtitle+"--------"+"Not displayed");
    		return false;
    	}   	
    }
    
    
    
    
    
    
    
    
}
