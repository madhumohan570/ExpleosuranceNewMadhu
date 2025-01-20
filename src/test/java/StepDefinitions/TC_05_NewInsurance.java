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

public class TC_05_NewInsurance {
	
	//initiate a browser
	static WebDriver driver;

	@Given ("User can be able to navigate to login page")
    public void user_can_able_to_navigate_login_page() {

	    driver = new ChromeDriver();
	    driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
        driver.get("http://192.168.99.141:3000/");
        }
	
	@When("User enters valid email and valid password")
	public void user_enters_valid_email_and_valid_password() {
	
	    
	  driver.findElement(By.xpath("//input[@placeholder='Email Address']")).sendKeys("swetha@gmail.com");
	  driver.findElement(By.xpath("//input[@placeholder='Password']")).sendKeys("July@@@@@@0507");
		
	}


	@When("Clicks the login")
	public void clicks_the_login() {
		driver.findElement(By.xpath("//button[@type='submit']")).click();
		
	}

	@Then("User is navigated to the dashboard")
	public void user_is_navigated_to_the_dashboard() {
		
		Assert.assertTrue(driver.findElements(By.xpath("//a[contains(text(),\"Dashboard\")]")).size()>0, "User is navigated to Dashboard");
		
	}
	
	//New Insurance
	
	@And("User is applying for a new insurance")
	public void user_is_applying_for_a_new_insurance() {
		driver.findElement(By.xpath("//a[contains(text(),\"New Insurance\")]")).click();
		driver.findElement(By.xpath("//input[@id='Name']")).sendKeys("Mouse");
		driver.findElement(By.xpath("//input[@id='email']")).sendKeys("Mouse@gmail.com");
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
	
	@And("User close browser")
	public void user_close_browser() {
    	driver.close();
    }


	
	

}
