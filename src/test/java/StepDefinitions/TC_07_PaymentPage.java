package StepDefinitions;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;

import io.cucumber.java.en.*;

public class TC_07_PaymentPage {
	
	//initiate a browser
	static WebDriver driver;
 
	@Given ("User is navigated to the login page")
    public void user_is_navigated_to_the_login_page() {
		
		driver = new ChromeDriver();
	    driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
        driver.get("http://192.168.99.141:3000/");
        }
	
	@When("User enters emailid and password")
	public void user_enters_emailid_and_password() {
	
	    
	  driver.findElement(By.xpath("//input[@placeholder='Email Address']")).sendKeys("swetha@gmail.com");
	  driver.findElement(By.xpath("//input[@placeholder='Password']")).sendKeys("July@@@@@@0507");
		
	}
 
 
	@When("Clicks the login button")
	public void clicks_the_login_button() {
		driver.findElement(By.xpath("//button[@type='submit']")).click();
		
	}
 
	@Then("User is able to navigate to dashboard page")
	public void user_is_able_to_navigate_to_dashboard_page() {
		
		Assert.assertTrue(driver.findElements(By.xpath("//a[contains(text(),\"Dashboard\")]")).size()>0, "User is navigated to Dashboard");
		
	}
	
	//Payment Page
	
	@And("User is navigating to payment page to proceed the payment")
	public void user_is_navigating_to_payment_page_to_proceed_the_payment() {
		driver.findElement(By.xpath("//a[contains(text(),\"Payment Page\")]")).click();
		driver.findElement(By.xpath("//input[@placeholder='Policy Amount']")).sendKeys("100000");
		driver.findElement(By.xpath("//button[contains(text(),\"Calculate Premium\")]")).click();
		driver.findElement(By.xpath("//button[contains(text(),\"Proceed to Pay\")]")).click();
		
	} 
	
	@Then("User gets the payment processing popup message")
	public void user_gets_the_payment_processing_popup_message() {
		driver.switchTo().alert().accept();
		
	}
	
	@And("Quit browser")
	public void quit_browser() {
		driver.close();
	}
 
 
}
 



