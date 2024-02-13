package com.CucmberOneCommerce.Pages;


import com.Pages.LoginPageJava;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class Steps {
	
	public TestContext context;
	public LoginPageJava loginpage;

	
	public Steps(TestContext context,LoginPageJava loginpage)
	{
		 this.context=context;
		 this.loginpage=loginpage;
		System.out.println("Steps Construtor");
	}
	//************************data values from files********************************
	//String URL=TestContext.getJsonValueForKey("Config", "URL");
	//String username=TestContext.getJsonValueForKey("Config", "username");
	//String password=TestContext.getJsonValueForKey("Config", "password");
	//String input_Username_xpath =TestContext.getJsonValueForKey("Locators", "input_Username_xpath");
	//String input_password_xpath =TestContext.getJsonValueForKey("Locators", "input_password_xpath");
//	String btn_LogIN_xpath=TestContext.getJsonValueForKey("Locators", "btn_LogIN_xpath");

	//************************************************************************************	
		

	
	@Given("User launch URL")
	public void user_launch_specified_browser() throws InterruptedException {
		 
		System.out.println("***********launch url*******");
		loginpage.launch_url("URL");
	}


	@When("User enter valid username and password")
	public void user_enter_valid_username_and_password() {
		loginpage.EnterUsername("username","input_Username_xpath");
		loginpage.EnterPassword("password","input_password_xpath");

	}

	@When("User click on Login")
	public void user_click_on_login() throws InterruptedException {
		loginpage.ClickLoginButton("btn_LogIN_xpath");
		Thread.sleep(9000);
	}
	
	@Then("User able to login successfully and verify home page title")
	public void User_able_to_login_successfully_and_verify_home_page_title() throws InterruptedException 
	{
		Thread.sleep(9000);

		loginpage.verifyPagetitle("Dashboard / nopCommerce administration");
	}

	@Then("Close the browser")
	public void close_the_browser() {
		loginpage.CloseTheBrowser();
		
	}



}
