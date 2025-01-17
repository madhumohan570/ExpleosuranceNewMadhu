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

public class ExpleoInsurance {
	
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
		
		//Register New Account
		
		@When("User clicks register new account")
		public void user_clicks_register_new_account() {
			driver.findElement(By.xpath("//h4[contains(text(),\"Register new account\")]")).click();
			
		}
		
		@And("User provides the details of new user")
		public void user_provides_the_details_of_new_user() {
			//driver.findElement(By.xpath("//input[@id='firstName']")).sendKeys("Pradeepkumar");
			//driver.findElement(By.xpath("//input[@id='lastName']")).sendKeys("R");
			driver.findElement(By.xpath("//input[@id='email']")).sendKeys("renuka@gmail.com");
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
		
		//New Insurance
		
		@And("User is applying for a new insurance")
		public void user_is_applying_for_a_new_insurance() {
			driver.findElement(By.xpath("//a[contains(text(),\"New Insurance\")]")).click();
			driver.findElement(By.xpath("//input[@id='Name']")).sendKeys("Harini");
			driver.findElement(By.xpath("//input[@id='email']")).sendKeys("harini@gmail.com");
			driver.findElement(By.xpath("//input[@id='Address']")).sendKeys("abc street, ZZZZ");
			driver.findElement(By.xpath("//input[@id='DateOfBirth']")).sendKeys("02112000");
			//driver.findElement(By.xpath("//input[@value=\"Male\"]")).click();
			driver.findElement(By.xpath("//input[@value=\"Female\"]")).click();
			driver.findElement(By.xpath("//option[contains(text(),\"-- Policy Type --\")]")).click();
			//driver.findElement(By.xpath("//option[@value="Health"]")).click();
			//driver.findElement(By.xpath("//option[@value="Life"]")).click();
			driver.findElement(By.xpath("//option[@value=\"Vehicle\"]")).click();
			driver.findElement(By.xpath("//select[@name=\"coverage\"]")).click();
			driver.findElement(By.xpath("//option[@value=\"Third-Party Liability\"]")).click();
			//driver.findElement(By.xpath("//option[@value=\"Comprehensive\"]")).click();
			//driver.findElement(By.xpath("//option[@value=\"Personal Vehicle Damage\"]")).click();
			driver.findElement(By.xpath("//select[@name=\"SumInsured\"]")).click();
			driver.findElement(By.xpath("//option[contains(text(),\"1,00,000\")]")).click();
			driver.findElement(By.xpath("//input[@id='Premium']")).sendKeys("2000");
			//driver.findElement(By.xpath("//input[@value=\"Yes\"]")).click();
			driver.findElement(By.xpath("//input[@value=\"No\"]")).click();
			driver.findElement(By.xpath("//button[@type='submit']")).click();
			
			
		}

		@Then("User successfully created a new insurance policy")
		public void user_successfully_created_a_new_insurance_policy() {
			
			Assert.assertTrue(driver.findElements(By.xpath("//p[contains(text(),\"Insurance policy created successfully.\")]")).size()>0, "New Insurance Policy Created Successfully");
			
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
		
		//Claims Management
		
		@And("User is navigating to claims management page")
		public void user_is_navigating_to_claims_management_page() {
			driver.findElement(By.xpath("//a[contains(text(),\"Claims Management\")]")).click();
			
		}
		
		@Then("User views the claim list")
		public void user_views_the_claim_list() {
			Assert.assertTrue(driver.findElements(By.xpath("//h3[contains(text(),\"Claims List\")]")).size()>0, "User is able to view the claims list");
			
			
		}
		
}
