package com.CucmberOneCommerce.Pages;


import static org.testng.Assert.fail;

//import static org.junit.Assert.fail;

//import static org.testng.Assert.*;

import java.io.File;
import java.io.IOException;
import java.util.Date;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;
//import org.testng.asserts.IAssert;
import org.testng.asserts.SoftAssert;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
//import com.aventstack.extentreports.util.Assert;
import com.fasterxml.jackson.databind.ObjectMapper;

import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.Scenario;

public class TestContext {
	public WebDriver driver;
	public String sBrowser_type;
	private TestContext context;
    public static ExtentReports  report;
    public static ExtentTest test;
    public ExtentSparkReporter sparkreport;
    public SoftAssert softAssert;

	public String Report_path="C:\\Users\\91869\\eclipse-workspace\\com.CucumberOneCommerce\\Execution_Reports";

	public TestContext()
	{		
		System.out.println("Constructor TestContext");
	}

	
	@Before
	public void initialize(Scenario scenario)
	{
		System.out.println("initialize Scenario----"+scenario.getName());
		CreateExtentReport(scenario.getName().toString());
		System.out.println("before method completed");
	}

	
	@After
	public void teardown()
	{
		System.out.println("tear down folder");
		report.flush();
	}
	
	
    public void CreateExtentReport(String ScenarioName)
    {
    	
    	System.out.println("result folder started.....");
    	Date d= new Date();
    	String spath= d.toString().substring(0);
		String arr[]=(spath.split(" "));
		String newPath=(arr[0]+"_"+arr[1]+"_"+arr[2]+"_"+arr[4]+"_"+arr[5]);
		System.out.println(newPath);
		String newReportPath=Report_path+"\\"+newPath;
		File file= new File(newReportPath);
		System.out.println("Results file created.......");
		if (!file.exists())
		{	
			file.mkdir();	
		}
		 report = new ExtentReports();
		 int CurrentTime=(int) System.currentTimeMillis();
		 sparkreport = new ExtentSparkReporter(file+"\\"+"Execution Report_"+ScenarioName+"_"+"_"+CurrentTime+".html");
		 report.attachReporter(sparkreport);
		System.out.println("Spark html ereport started");
		//test= report.createTest("Envrinmont--->"+env+"/n"+"FeaureFile---"+Featurefile+"/n"+"-----"+"Current Scenarios******"+"/n"+currentScenario+"On browser--->"+getJsonValueForKey("Config","Browser"));
		test= report.createTest(ScenarioName);

    }
    
    

    public static String getJsonValueForKey(String featurefileName, String key) {
        try {
        	 System.out.println("in getJsonValueForKey");
            // Create ObjectMapper
            ObjectMapper objectMapper = new ObjectMapper();

            // Read JSON file into JsonNode
            com.fasterxml.jackson.databind.JsonNode rootNode = objectMapper.readTree(new File(".//JsonFiles//"+featurefileName+".Json"));

            // Get value for the specified key
            com.fasterxml.jackson.databind.JsonNode valueNode = rootNode.get(key);

            // Check if the key exists in the JSON
            if (valueNode != null) {
           	 System.out.println("return json value");
                return (valueNode.asText()).toString();
                
            } else 
            {
                return "no value exists";
            }

        } catch (IOException e) {
            e.printStackTrace();
            return "Error reading JSON file";
        }
    }

    public void log(String msg)
    {
    	test.log(Status.INFO, msg); 	
    }

    public void Pass(String msg)
    {
    	test.log(Status.PASS, msg); 
    }
    
    
    public void Fail(String msg, boolean Stopexecution)
    {
    	test.log(Status.FAIL, msg);
		softAssert.fail(msg);
		if(Stopexecution)
		{
			softAssert.assertAll();
		}
    }
    
	
	


}
