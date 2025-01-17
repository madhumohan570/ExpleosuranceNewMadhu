package TestRunner;

import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;

@CucumberOptions(
	 
        features = {"src/test/resources/Features/steps.feature"},
        glue= {"StepDefinitions"}, tags = "@LoginStep",  
        plugin= {"pretty", "html:ExpleoInsuranceDemo/target/cucumber-reports.html", 
        		"json:ExpleoInsuranceDemo/target/cucumber-reports.json"})

public class CucumberRunner extends AbstractTestNGCucumberTests {

}
