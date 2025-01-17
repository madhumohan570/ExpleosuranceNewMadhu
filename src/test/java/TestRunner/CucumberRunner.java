package TestRunner;

import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;

@CucumberOptions(

	 
        features = {"src/test/resources/Features/steps.feature"},
        glue= {"StepDefinitions"}, tags = "@LoginStep",
        plugin = {"pretty", "json:target/cucumber.json",
		"html:target/htmlreport.html"})
        

public class CucumberRunner extends AbstractTestNGCucumberTests {

}
