package StepDefinitions;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class TC_04_ForgotPassword {
	
	//initiate a browser
	static WebDriver driver;

@Given ("User is in the login page")
public void user_is_in_the_login_page() {

	driver = new ChromeDriver();
	driver.manage().window().maximize();
    driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
    driver.get("http://192.168.99.141:3000/");
}

	
	//Forgot Password
	
			@When("User changes the password")
			public void user_changes_the_password() {
				driver.findElement(By.xpath("//h4[contains(text(),\"Forgot password ?\")]")).click();
				driver.findElement(By.xpath("//input[@type='email']")).sendKeys("swetha@gmail.com");
				driver.findElement(By.xpath("//input[@placeholder=\"Enter your new password\"]")).sendKeys("July@@@@@@0507");
				driver.findElement(By.xpath("//input[@placeholder=\"Confirm your new password\"]")).sendKeys("July@@@@@@0507");
				driver.findElement(By.xpath("//button[contains(text(),\"Reset Password\")]")).click();
				driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
			}
			
			@Then("Closes the browser")
			public void closes_the_browser() {
			    driver.close();
			}

}
