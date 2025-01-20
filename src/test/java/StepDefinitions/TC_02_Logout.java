package StepDefinitions;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class TC_02_Logout {
	
	//initiate a browser
	static WebDriver driver;

	@Given ("User can launch to the url")
    public void user_can_launch_to_the_url() {

	    driver = new ChromeDriver();
	    driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
        driver.get("http://192.168.99.141:3000/");
        }
	
	@When("User provides valid email and password")
	public void user_provides_valid_email_and_password() {
	
	    
	  driver.findElement(By.xpath("//input[@placeholder='Email Address']")).sendKeys("swetha@gmail.com");
	  driver.findElement(By.xpath("//input[@placeholder='Password']")).sendKeys("July@@@@@@0507");
		
	}


	@When("Clicks the submit")
	public void clicks_the_submit() {
		driver.findElement(By.xpath("//button[@type='submit']")).click();
		
	}

	@Then("User is navigated to verify dashboard")
	public void user_is_navigated_to_verify_dashboard() {
		
		Assert.assertTrue(driver.findElements(By.xpath("//a[contains(text(),\"Dashboard\")]")).size()>0, "User is navigated to Dashboard");
		
	}
	
	@Then("User can able to logout")
	public void user_can_able_to_logout() {
		JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("window.scrollBy(0, 500);");
		driver.findElement(By.xpath("//button[contains(text(),\"Logout\")]")).click();
		if (driver.getPageSource().contains("Sign in")) {
			System.out.println("Logout is done successfully");
			}
		else {
			System.out.println("Logout is not done");
		}
	}
	
	@And("User closes the browser")
	public void user_closes_the_browser() {
		driver.close();
	}




}
