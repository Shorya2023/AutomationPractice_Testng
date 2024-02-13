package com.Pages;

import org.openqa.selenium.WebDriver;

import com.CucmberOneCommerce.Pages.TestContext;

import WebDriverManager.WebdriverManager;
import io.opentelemetry.context.Context;


 

public class LoginPageJava {

//*******************************************************	
public WebdriverManager app;
public TestContext context;

public LoginPageJava(WebdriverManager app)
{
	this.app=app;
	System.out.println("LoginPageJava Construtor");
}


	public void launch_url(String url) throws InterruptedException
	{
		app.Open_Browser();
		app.navigate_url(url);		
	}
	
	
	public void EnterUsername(String username, String locator)
	{
		
		app.type(username, locator);
	}

	public void EnterPassword(String password, String locator)
	{
		app.type(password, locator);
	}

	
	public void ClickLoginButton(String locator)
	{
		app.Click(locator);
		
	}

	
	public void CloseTheBrowser()
	{
		context.driver.close();
	}

     
	public  void verifyPagetitle(String title)
	{
			//	app.WaitForElement(title, 0);
		if( app.VerifyTitle(title))
		{
			context.log("title passed");
		}
		else
		{
			context.log("title failed");

		}
	}

}
	
	


