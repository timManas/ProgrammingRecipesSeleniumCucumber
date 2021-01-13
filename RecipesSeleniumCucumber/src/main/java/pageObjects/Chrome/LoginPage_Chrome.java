package pageObjects.Chrome;

import static org.testng.Assert.assertEquals;

import java.io.IOException;

import org.openqa.selenium.Alert;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;

import pageObjects.BasePage;

public class LoginPage_Chrome extends BasePage {
	public @FindBy(xpath = "//a[@id='login-portal']//h1[.='LOGIN PORTAL']") WebElement link_loginPortalButton;
	public @FindBy(xpath = "//input[@id='text']") WebElement textfield_loginUserName;
	public @FindBy(xpath = "//input[@id='password']") WebElement textfield_loginPassword;
	public @FindBy(xpath = "//*[@id='login-button']") WebElement button_loginButton;

	public LoginPage_Chrome() throws IOException {
		super();
	}

	public LoginPage_Chrome getWebDriverUniversity() throws IOException {
		getDriver().get("http://www.webdriveruniversity.com");
		return new LoginPage_Chrome();
	}
	
	public LoginPage_Chrome clickOnLoginPortalLink() throws IOException {
		link_loginPortalButton.click();
		return new LoginPage_Chrome();
	}

	public LoginPage_Chrome enterFirstName(String firstName) throws Exception {
		//tab code
		for (String windHandle : getDriver().getWindowHandles()) {
			driver.switchTo().window(windHandle);
		}
		sendKeysToWebElement(textfield_loginUserName, firstName);
		return new LoginPage_Chrome();
	}

	public LoginPage_Chrome enterPassword(String password) throws Exception {
		sendKeysToWebElement(textfield_loginPassword, password);
		return new LoginPage_Chrome();
	}
	
	public LoginPage_Chrome clickOnLoginPortalButton() throws InterruptedException, IOException {
//		waitAndClickElement(button_loginButton);	// Reason this doesent work is because the Alert dialog pops up
		button_loginButton.click();					// This line works

		return new LoginPage_Chrome();
	}

	public LoginPage_Chrome verifyValidationAlert(String message) throws IOException {
		Alert alert = getDriver().switchTo().alert(); //Alert	
		assertEquals(alert.getText().toString().toLowerCase().replaceAll("\\s", ""), message.toLowerCase().replaceAll("\\s", ""));
		alert.accept();
		return new LoginPage_Chrome();
	}

	public LoginPage_Chrome userNavigatesTo(String url) throws IOException {
		getDriver().get(url);
		return new LoginPage_Chrome();
	}



}
