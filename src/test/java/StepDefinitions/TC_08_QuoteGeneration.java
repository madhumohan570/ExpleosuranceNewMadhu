package StepDefinitions;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class TC_08_QuoteGeneration {
	
	//initiate a browser
		static WebDriver driver;
	 
		@Given ("User is navigated to url")
	    public void user_is_navigated_to_url() {
			
			driver = new ChromeDriver();
		    driver.manage().window().maximize();
	        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
	        driver.get("http://192.168.99.141:3000/");
	        }
		
		@When("User enters valid emailid and valid password")
		public void user_enters_valid_emailid_and_valid_password() {
		
		    
		  driver.findElement(By.xpath("//input[@placeholder='Email Address']")).sendKeys("swetha@gmail.com");
		  driver.findElement(By.xpath("//input[@placeholder='Password']")).sendKeys("July@@@@@@0507");
			
		}
	 
	 
		@When("Clicks submit button to login")
		public void clicks_submit_button_to_login() {
			driver.findElement(By.xpath("//button[@type='submit']")).click();
			
		}
	 
		@Then("User is navigated to the dashboard page")
		public void user_is_navigate_to_the_dashboard_page() {
			
			Assert.assertTrue(driver.findElements(By.xpath("//a[contains(text(),\"Dashboard\")]")).size()>0, "User is navigated to Dashboard");
			
		}
		
		//Quote Generation
		
		
		@And("User can able to generate the quote")
		public void user_can_able_to_generate_the_quote() {
			
			driver.findElement(By.xpath("//a[contains(text(),\"Quate Generation\")]")).click();
			driver.findElement(By.name("policyType")).click();
			driver.findElement(By.xpath("//option[@value=\"Health\"]")).click();
			//driver.findElement(By.xpath("//option[@value=\"Life\"]")).click();
			//driver.findElement(By.xpath("//option[@value=\"Auto\"]")).click();
			//driver.findElement(By.xpath("//option[@value=\"Home\"]")).click();
			driver.findElement(By.name("coverageAmount")).sendKeys("100000");
			driver.findElement(By.name("customerAge")).sendKeys("24");
			driver.findElement(By.xpath("//button[contains(text(),\"Generate Quote\")]")).click();
			
			
		}
		
	    @Then("User verifies the generated quote price")
	    public void user_verifies_the_generated_quote_price() {
	    	
	    	Assert.assertTrue(driver.findElements(By.xpath("//h3[contains(text(),\"Generated Quote: $\")]")).size()>0, "Quote Generation is Successfull");
			
	    	
	    }
	    
	    @And("Close browsers")
	    public void close_the_browsers() {
	    	driver.close();
	    }


}
