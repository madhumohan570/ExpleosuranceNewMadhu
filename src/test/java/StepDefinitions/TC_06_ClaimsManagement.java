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

public class TC_06_ClaimsManagement {
	
	//initiate a browser
	static WebDriver driver;

	@Given ("User can able to navigate to the url")
    public void user_can_able_to_navigate_to_the_url() {

	    driver = new ChromeDriver();
	    driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
        driver.get("http://192.168.99.141:3000/");
        }
	
	@When("User enters valid email address and password")
	public void user_enters_valid_email__address_and_password() {
	
	    
	  driver.findElement(By.xpath("//input[@placeholder='Email Address']")).sendKeys("swetha@gmail.com");
	  driver.findElement(By.xpath("//input[@placeholder='Password']")).sendKeys("July@@@@@@0507");
		
	}


	@When("Clicks submit button")
	public void clicks_submit_button() {
		driver.findElement(By.xpath("//button[@type='submit']")).click();
		
	}

	@Then("User is verifying the dashboard page")
	public void user_is_verifying_the_dashboard_page() {
		
		Assert.assertTrue(driver.findElements(By.xpath("//a[contains(text(),\"Dashboard\")]")).size()>0, "User is navigated to Dashboard");
		
	}
	
	//Claims Management
	
	@And("User is navigating to claims management page")
	public void user_is_navigating_to_claims_management_page() {
		driver.findElement(By.xpath("//a[contains(text(),\"Claims Management\")]")).click();
		
	}
	
	@Then("User views the claim list")
	public void user_views_the_claim_list() {
		Assert.assertTrue(driver.findElements(By.xpath("//h3[contains(text(),\"Claims List\")]")).size()>0, "User is able to view the claims list");
		
		}
	
	@And("User close the browser")
    public void user_close_the_browser() {
    	driver.close();
    }


}
