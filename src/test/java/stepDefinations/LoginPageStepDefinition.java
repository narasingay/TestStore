package stepDefinations;

import static org.junit.Assert.assertEquals;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

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
		driver.manage().window().maximize();	
	}
	@And("Click on login or register button")
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
		System.out.println(expName);
		loginPagePageObjects = new LoginPagePageObjects(driver);
		String actName = loginPagePageObjects.lnkMenuName.getText();
		System.out.println(actName);
		String arr[] = actName.split(" ");
		assertEquals("The expected "+expName+" and actual "+arr[2]+" names are not equal", expName, arr[2]);
}
	
	@And("User logout the test store application")
	public void User_logout_the_test_store_application() throws Exception {
		loginPagePageObjects = new LoginPagePageObjects(driver);
		Thread.sleep(3000);
		Actions action = new Actions(driver);
		WebElement element = driver.findElement(By.xpath("(//a[@class='top menu_account'])[1]"));
		action.moveToElement(element);
		loginPagePageObjects.clickOnLogout();		
	}
	
	@And("user enters username {string} and userpassword {string} on login account screen")
	public void user_enters_username_and_userpassword_on_login_account_screen(String userName, String userPassword) throws Exception{
		loginPagePageObjects = new LoginPagePageObjects(driver);
		loginPagePageObjects.enterUserName(userName);
		loginPagePageObjects.enterUserPassword(userPassword);		
	}
	
	@And("Click on login button")
	public void click_on_login_button() {
		loginPagePageObjects = new LoginPagePageObjects(driver);
		loginPagePageObjects.clickOnLogin();		
	}

}