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

public class TC_03_RegisterNewAccount {
	
	//initiate a browser
	static WebDriver driver;

	@Given ("User can able to navigate to login page")
	public void user_can_able_to_navigate_to_login_page() {
		
		driver = new ChromeDriver();
	    driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
        driver.get("http://192.168.99.141:3000/");
        }
	
	//Register New Account
	
	@When("User clicks register new account")
	public void user_clicks_register_new_account() {
		driver.findElement(By.xpath("//h4[contains(text(),\"Register new account\")]")).click();
		
	}
	
	@And("User provides the details of new user")
	public void user_provides_the_details_of_new_user() {
		//driver.findElement(By.xpath("//input[@id='firstName']")).sendKeys("Pradeepkumar");
		//driver.findElement(By.xpath("//input[@id='lastName']")).sendKeys("R");
		driver.findElement(By.xpath("//input[@id='email']")).sendKeys("Ramesh@gmail.com");
		driver.findElement(By.xpath("//input[@id='password']")).sendKeys("July@@@@@@0507");
		driver.findElement(By.xpath("//input[@id='confirmPassword']")).sendKeys("July@@@@@@0507");
		//driver.findElement(By.xpath("//input[@id='startDate']")).sendKeys("01112024");
		//driver.findElement(By.xpath("//input[@id='endDate']")).sendKeys("30112024");
		//driver.findElement(By.xpath("//input[@id='address']")).sendKeys("acd street, VVVV");
		//driver.findElement(By.xpath("//input[@id='phoneNumber']")).sendKeys("9896943212");
		driver.findElement(By.xpath("//button[contains(text(),\"Register\")]")).click();
		
	}
	
	@Then("User creates an account successfully")
	public void user_creates_an_account_successfully() {
		
		Assert.assertTrue(driver.findElements(By.xpath("//h2[contains(text(),\"Registration successful!\")]")).size()>0, "New Account Registered Successfully");
		driver.findElement(By.xpath("//button[contains(text(),\"Navigate to login Page\")]")).click();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
		
	}
	
	@When("User enters email and password")
	public void user_enters_email_and_password() {
	
	    
	  driver.findElement(By.xpath("//input[@placeholder='Email Address']")).sendKeys("ramesh@gmail.com");
	  driver.findElement(By.xpath("//input[@placeholder='Password']")).sendKeys("July@@@@@@0507");
		
	}


	@When("Clicks login button")
	public void clicks_login_button() {
		driver.findElement(By.xpath("//button[@type='submit']")).click();
		
	}

	@Then("User is navigated to dashboard page")
	public void user_is_navigated_to_dashboard_page() {
		
		Assert.assertTrue(driver.findElements(By.xpath("//a[contains(text(),\"Dashboard\")]")).size()>0, "User is navigated to Dashboard");
		
	}

	@Then("Close browser")
	public void close_browser() {
	    driver.close();
	}

	

}
