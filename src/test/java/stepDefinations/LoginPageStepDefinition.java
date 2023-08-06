package stepDefinations;

import static org.junit.Assert.assertEquals;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import pageObjects.LoginPagePageObjects;


public class LoginPageStepDefinition {

	public WebDriver driver;
	LoginPagePageObjects loginPagePageObjects;
	
	@Given("Lunch the browser and navigate to automation test store application")
	public void navigateUrl() {
		System.setProperty("webdriver.chrome.driver", "driver\\chromedriver.exe");
		driver = new ChromeDriver();
		driver.get("https://automationteststore.com/");
		System.out.println("Title is: "  +driver.getTitle());
		driver.manage().window().maximize();	
	}
	@And("Click on register button")
	public void click_on_register_button() {
		loginPagePageObjects = new LoginPagePageObjects(driver);
		loginPagePageObjects.clickOnLoginRegister();		
	}

	@And("User enter name {string} surname {string} and other details in register page")
	public void user_enter_name_surname_and_other_details_in_register_page(String expName, String expSurname) throws Exception{
		loginPagePageObjects = new LoginPagePageObjects(driver);
		loginPagePageObjects.fillCreateAccountDetails();		
	}
	@When("Click on Continue button")
	public void click_on_continue_button() {
		loginPagePageObjects = new LoginPagePageObjects(driver);
		loginPagePageObjects.clickOnContinue();		
	}
	@Then("Validate the name {string} and surname {string} on landing screen")
	public void Validate_the_name_and_surname_on_landing_screen(String expName, String expSurname) {
		loginPagePageObjects = new LoginPagePageObjects(driver);
		String actualName = loginPagePageObjects.lnkMenuName.getText();
		assertEquals("The expected "+expName+" and actual "+actualName+" names are not equal", expName, actualName);
}

}