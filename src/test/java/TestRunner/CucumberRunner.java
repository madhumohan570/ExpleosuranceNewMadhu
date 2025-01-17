package TestRunner;

import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;

@CucumberOptions(
		tags="@LoginStep", 
        features= {"src/test/resources/Features"},
        glue= {"StepDefinitions"}, 
        plugin= {"pretty", "html:ExpleoInsuranceDemo/target/cucumber-reports.html", "json:ExpleoInsuranceDemo/target/cucumber-reports.json"})

public class CucumberRunner extends AbstractTestNGCucumberTests {

}
