package TestRunner;

import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;

@CucumberOptions(

	 
        features = {"src/test/resources/Features"},
        glue= {"StepDefinitions"}, 
        tags = "@AllScenarios", 
        //dryRun = true, 
        monochrome = true,
        plugin = {"pretty", "json:target/cucumber.json",
		"html:target/htmlreport.html"})
        

public class CucumberRunner extends AbstractTestNGCucumberTests {

}
