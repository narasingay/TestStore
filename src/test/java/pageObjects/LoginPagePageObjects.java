package pageObjects;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

/*
 * This class defines page objects for user signup and login pages
 */
public class LoginPagePageObjects {

	public WebDriver driver;

	public LoginPagePageObjects(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	@FindBy(id = "customer_menu_top")
	public WebElement lnkLoginRegister;

	@FindBy(xpath = "//button[@title='Continue']")
	public WebElement btnContinue;

	@FindBy(xpath = "//input[@id='AccountFrm_firstname']")
	public WebElement txtFirstName;

	@FindBy(xpath = "//input[@id='AccountFrm_lastname']")
	public WebElement txtLastName;

	@FindBy(xpath = "//input[@id='AccountFrm_email']")
	public WebElement txtEmail;

	@FindBy(xpath = "//input[@id='AccountFrm_address_1']")
	public WebElement txtAddressOne;

	@FindBy(xpath = "//input[@id='AccountFrm_city']")
	public WebElement txtCity;

	@FindBy(xpath = "//select[@id='AccountFrm_zone_id']")
	public WebElement ddState;

	@FindBy(xpath = "//select[@id='AccountFrm_country_id']//option")
	public List<WebElement> ddStateList;

	@FindBy(xpath = "//input[@id='AccountFrm_postcode']")
	public WebElement txtZipCode;

	@FindBy(xpath = "//select[@id='AccountFrm_country_id']")
	public WebElement ddCountry;

	@FindBy(xpath = "//select[@id='AccountFrm_country_id']//option")
	public List<WebElement> ddCountryList;

	@FindBy(xpath = "//input[@id='AccountFrm_loginname']")
	public WebElement txtLoginName;

	@FindBy(xpath = "//input[@id='AccountFrm_password']")
	public WebElement txtLoginPassword;

	@FindBy(xpath = "//input[@id='AccountFrm_confirm']")
	public WebElement txtConfirmPassword;

	@FindBy(xpath = "//input[@id='AccountFrm_agree']")
	public WebElement chkAgree;

	@FindBy(xpath = "//div[@class='menu_text']")
	public WebElement lnkMenuName;

	@FindBy(xpath = "(//span[contains(text(),'Logout')])[1]")
	public WebElement lnkLogout;

	@FindBy(xpath = "//input[@id='loginFrm_loginname']")
	public WebElement txtUserName;

	@FindBy(xpath = "//input[@id='loginFrm_password']")
	public WebElement txtUserPassword;

	@FindBy(xpath = "//button[@title='Login']")
	public WebElement btnLogin;

	@FindBy(xpath = "//a[contains(text(),'Pre-Shave & Shaving')]")
	public WebElement lnkProd;

	@FindBy(xpath = "(//a[@title='Add to Cart'])[1]")
	public WebElement lnkAddToCart;

	@FindBy(xpath = "(//li[@data-id='menu_cart'])[1]")
	public WebElement lnkMenuAddToCart;

	@FindBy(xpath = "//button[@title='Confirm Order']")
	public WebElement btnConfirmOrder;

	@FindBy(xpath = "//a[@id='cart_checkout1']")
	public WebElement lnkCheckOut;

	public void clickOnLoginRegister() {
		lnkLoginRegister.click();
	}

	public void clickOnContinue() {
		btnContinue.click();
	}

	public void enterName(String name) {
		txtFirstName.sendKeys(name);
	}

	public void enterSurname(String surName) {
		txtLastName.sendKeys(surName);
	}

	public void enterEmail(String email) {
		txtEmail.sendKeys(email);
	}

	public void enterAddressOne(String addressOne) {
		txtAddressOne.sendKeys(addressOne);
	}

	public void selectCounty(String countryName) {
		Select drpState = new Select(driver.findElement(By.id("AccountFrm_country_id")));
		drpState.selectByVisibleText(countryName);
	}

	public void selectState(String stateName) throws Exception {
		Thread.sleep(2000);
		Select drpState = new Select(driver.findElement(By.id("AccountFrm_zone_id")));
		drpState.selectByVisibleText(stateName);
	}

	public void enterCity(String city) {
		txtCity.sendKeys(city);
	}

	public void enterZipCode(String zipCode) {
		txtZipCode.sendKeys(zipCode);
	}

	public void enterLoginName(String loginName) {
		txtLoginName.sendKeys(loginName);
	}

	public void enterLoginPassword(String loginPassword) {
		txtLoginPassword.sendKeys(loginPassword);
	}

	public void enterConfirmPassword(String confirmPassword) {
		txtConfirmPassword.sendKeys(confirmPassword);
	}

	public void clickOnAgreeCheckbox() {
		chkAgree.click();
	}

	public void clickOnMenuName() {
		lnkMenuName.click();
	}

	public void clickOnLogout() {
		lnkLogout.click();
		driver.close();
	}

	public void enterUserName(String userName) {
		txtUserName.sendKeys(userName);
	}

	public void enterUserPassword(String userPassword) {
		txtUserPassword.sendKeys(userPassword);
	}

	public void clickOnLogin() {
		btnLogin.click();
	}

	public void clickOnMainProd() {
		lnkProd.click();
	}

	public void clickOnAddToCart() {
		lnkAddToCart.click();
	}

	public void clickOnMenuAddToCart() {
		lnkMenuAddToCart.click();
	}

	public void clickOnCheckOut() {
		lnkCheckOut.click();
	}

}
