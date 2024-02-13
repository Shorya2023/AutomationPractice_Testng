package TestRunner;


import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;

@CucumberOptions
(
		features="C:\\Users\\91869\\eclipse-workspace\\com.CucumberOneCommerce\\src\\test\\resources\\Features\\Login.feature",
		glue="com.CucmberOneCommerce.Pages",
		monochrome=true,
		dryRun=false,
		plugin={"pretty","html:test-output"}
)


public class TestRunnerWithTestng extends AbstractTestNGCucumberTests {
	/*@DataProvider(parallel=true)
public Object[][] scenarios()
{
			return super.scenarios();
			
}*/
	
}

