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

public class TC_01_Login {
	
	//initiate a browser
			static WebDriver driver;
		
			@Given ("User is in login page")
		public void user_is_in_login_page() {
		
			driver = new ChromeDriver();
			driver.manage().window().maximize();
		    driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
		    driver.get("http://192.168.99.141:3000/");
		}

		@When("User enters valid email and password")
		public void user_enters_valid_email_and_password() {
		
		    
		  driver.findElement(By.xpath("//input[@placeholder='Email Address']")).sendKeys("swetha@gmail.com");
		  driver.findElement(By.xpath("//input[@placeholder='Password']")).sendKeys("July@@@@@@0507");
			
		}


		@When("Clicks login")
		public void clicks_login() {
			driver.findElement(By.xpath("//button[@type='submit']")).click();
			
		}

		@Then("User is navigated to dashboard")
		public void user_is_navigated_to_dashboard() {
			
			Assert.assertTrue(driver.findElements(By.xpath("//a[contains(text(),\"Dashboard\")]")).size()>0, "User is navigated to Dashboard");
			
		}

		@Then("Close the browser")
		public void close_the_browser() {
		    driver.close();
		}
		
}
