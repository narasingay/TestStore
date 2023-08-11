package stepDefinations;

import static org.junit.Assert.assertEquals;

import java.util.List;
import java.util.Map;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.interactions.Actions;

import io.cucumber.datatable.DataTable;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import pageObjects.LoginPagePageObjects;
import testStoreConfigFiles.ConfigFileReader;

/*
 * This class defines user signup, login and logout functionality
 */
public class LoginPageStepDefinition {

	public WebDriver driver;
	LoginPagePageObjects loginPagePageObjects = new LoginPagePageObjects(driver);
	ConfigFileReader configFileReader = new ConfigFileReader();

	/*
	 * Launch the browser and navigate to test store application
	 */
	@Given("Launch the browser and navigate to automation test store application")
	public void navigateToUrl() {
		if (configFileReader.getChromeBrowser().equalsIgnoreCase("Chrome")) {
			System.setProperty("webdriver.chrome.driver", configFileReader.getChromeDriverPath());
			driver = new ChromeDriver();
			String appUrl = configFileReader.getAppUrl();
			driver.get(appUrl);
			driver.manage().window().maximize();
		} else {
			System.setProperty("webdriver.edge.driver", configFileReader.getEdgeDriverPath());
			driver = new EdgeDriver();
			String appUrl = configFileReader.getAppUrl();
			driver.get(appUrl);
			driver.manage().window().maximize();
		}

	}

	/*
	 * Click on login or register button to singup
	 */
	@And("Click on login or register button")
	public void click_on_login_or_register_button() {
		loginPagePageObjects = new LoginPagePageObjects(driver);
		loginPagePageObjects.clickOnLoginRegister();
	}

	/*
	 * Enter user personal details name, surname, email and other details as
	 * required to signup
	 */
	@And("User enters personal and other details as requiired in register page to signup")
	public void User_enters_personal_and_other_details_as_requiired_in_register_page_to_signup(DataTable userDetails)
			throws Exception {
		List<Map<String, String>> data = userDetails.asMaps(String.class, String.class);
		String userName = data.get(0).get("Name");
		String userSurName = data.get(0).get("Surname");
		String userEmail = data.get(0).get("Email");
		String userAddressOne = data.get(0).get("Addressone");
		String userCountry = data.get(0).get("Country");
		String userState = data.get(0).get("State");
		String userCity = data.get(0).get("City");
		String userZipcode = data.get(0).get("Zipcode");
		String userLoginName = data.get(0).get("Loginname");

		loginPagePageObjects.enterName(userName);
		loginPagePageObjects.enterSurname(userSurName);
		loginPagePageObjects.enterEmail(userEmail);
		loginPagePageObjects.enterAddressOne(userAddressOne);
		loginPagePageObjects.selectCounty(userCountry);
		loginPagePageObjects.selectState(userState);
		loginPagePageObjects.enterCity(userCity);
		loginPagePageObjects.enterZipCode(userZipcode);
		loginPagePageObjects.enterLoginName(userLoginName);
		String strUserPassword = configFileReader.getUserPassword();
		loginPagePageObjects.enterLoginPassword(strUserPassword);
		String strConfirmPassword = configFileReader.getUserConfirmPassword();
		loginPagePageObjects.enterConfirmPassword(strConfirmPassword);

		loginPagePageObjects.clickOnAgreeCheckbox();
	}

	/*
	 * Click on continue button
	 */
	@When("Click on Continue button")
	public void click_on_continue_button() {
		loginPagePageObjects.clickOnContinue();
	}

	/*
	 * Validate name and surname on landing page after signup successfully
	 */
	@Then("Validate the name and surname on landing screen")
	public void Validate_the_name_and_surname_on_landing_screen(DataTable userNameAndSurname) {
		List<Map<String, String>> data = userNameAndSurname.asMaps(String.class, String.class);
		String expUserName = data.get(0).get("Name");
		String actName = loginPagePageObjects.lnkMenuName.getText();
		String arr[] = actName.split(" ");
		assertEquals("The expected " + expUserName + " and actual " + arr[2] + " names are not equal", expUserName,
				arr[2]);
	}

	/*
	 * Click on logout button on home page
	 */
	@And("User logout the test store application")
	public void User_logout_the_test_store_application() throws Exception {
		Thread.sleep(2000);
		Actions action = new Actions(driver);
		WebElement element = driver.findElement(By.xpath("(//span[contains(text(),'Account')])[1]"));
		action.moveToElement(element).build().perform();
		Thread.sleep(1000);
		loginPagePageObjects.clickOnLogout();
	}

	/*
	 * Enter username and password to login
	 */
	@And("user enters username and userpassword on login account screen")
	public void user_enters_username_and_userpassword_on_login_account_screen() throws Exception {
		loginPagePageObjects.enterUserName(configFileReader.getUserName());
		loginPagePageObjects.enterUserPassword(configFileReader.getUserPassword());
	}

	/*
	 * Click on login button
	 */
	@And("Click on login button")
	public void click_on_login_button() {
		loginPagePageObjects.clickOnLogin();
	}

	/*
	 * Add product to the cart and click on checkout button
	 */
	@When("User add product to the cart and click on checkout")
	public void User_add_product_to_the_cart_and_click_on_checkout() throws Exception {
		Thread.sleep(2000);
		Actions action = new Actions(driver);
		WebElement element = driver.findElement(By.xpath("(//a[contains(text(),'Men')])[3]"));
		action.moveToElement(element).build().perform();
		Thread.sleep(1000);
		loginPagePageObjects.clickOnMainProd();
		Thread.sleep(1000);
		loginPagePageObjects.clickOnAddToCart();
		Thread.sleep(1000);
		loginPagePageObjects.clickOnMenuAddToCart();
		Thread.sleep(1000);
		loginPagePageObjects.clickOnCheckOut();
	}

	/*
	 * Validate product details on payments page once checkout
	 */
	@Then("Validate product {string} details on payments page")
	public void Validate_product_details_on_payments_page(String expProductName) throws Exception {
		Thread.sleep(2000);
		WebElement actProd = driver.findElement(By.xpath("//a[@class='checkout_heading']"));
		String actualProductName = actProd.getText();
		assertEquals("No product " + actualProductName + " available in test store", expProductName, actualProductName);
	}

}