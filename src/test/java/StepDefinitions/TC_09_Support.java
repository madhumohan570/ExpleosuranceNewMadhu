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

public class TC_09_Support {
	
	//initiate a browser
	static WebDriver driver;

	@Given ("User can navigate to url for login")
    public void user_can_navigate_to_url_for_login() {

	    driver = new ChromeDriver();
	    driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
        driver.get("http://192.168.99.141:3000/");
        }
	
	@When("User provides valid email and valid password")
	public void user_provides_valid_email_and_valid_password() {
	
	    
	  driver.findElement(By.xpath("//input[@placeholder='Email Address']")).sendKeys("swetha@gmail.com");
	  driver.findElement(By.xpath("//input[@placeholder='Password']")).sendKeys("July@@@@@@0507");
		
	}


	@When("Clicks submit for login")
	public void clicks_submit_for_login() {
		driver.findElement(By.xpath("//button[@type='submit']")).click();
		
	}

	@Then("User is navigated to verify the dashboard page is displayed")
	public void user_is_navigated_to_verify_the_dashboard_page_is_displayed() {
		
		Assert.assertTrue(driver.findElements(By.xpath("//a[contains(text(),\"Dashboard\")]")).size()>0, "User is navigated to Dashboard");
		
	}
	
	@And("User can able to get support")
	public void user_can_able_to_get_support() {
		driver.findElement(By.xpath("//a[contains(text(),\"Support\")]")).click();
		driver.findElement(By.name("name")).sendKeys("testing");
		driver.findElement(By.name("email")).sendKeys("swetha@gmail.com");
		driver.findElement(By.name("message")).sendKeys("testing purpose");
		driver.findElement(By.xpath("//button[contains(text(),\"Submit\")]")).click();
		
		
	}
	
	@And("Quit the browser")
	public void quit_the_browser() {
		driver.close();
	}
	    

	
	

}
