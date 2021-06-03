package stepDefinitionsX.Chrome.WebDriverUniversity;

import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import stepDefinitionsX.DriverFactory;

public class LoginSteps extends DriverFactory {
	
	@Given("^I access webdriveruniversity$")
	public void i_access_webdriveruniversity() throws Throwable {
		loginPage.getWebDriverUniversity();
	}

	@When("^I click on the login portal link$")
	public void i_click_on_the_login_portal_link() throws Throwable {
		loginPage.clickOnLoginPortalLink();
	}

	@When("^I enter a username$")
	public void i_enter_a_username() throws Throwable {
		loginPage.enterFirstName("webdriver");
	}

	@When("^I enter a \"(.*)\" password$")
	public void i_enter_a_password(String password) throws Throwable {
		loginPage.enterPassword(password);
	}

	@When("^I click on the login button$")
	public void i_click_on_the_login_button() throws Throwable {
		loginPage.clickOnLoginPortalButton();
	}

	@Then("^I should be presented with a succesfful validation alert$")
	public void i_should_be_presented_with_a_succesfful_validation_alert() throws Throwable {
		loginPage.verifyValidationAlert("validation succeeded");
	}

	@Then("^I should be presented with a unsuccesfful validation alert$")
	public void i_should_be_presented_with_a_unsuccesfful_validation_alert() throws Throwable {
		loginPage.verifyValidationAlert("validation failed");
	}

	@Given("^user navigates to \"(.*)\"$")
	public void user_navigates_to(String url) throws Throwable {
		loginPage.userNavigatesTo(url);
	}

	@When("^user clicks on the login portal link$")
	public void user_clicks_on_the_login_portal_link() throws Throwable {
		loginPage.clickOnLoginPortalLink();
	}

	@When("^user enters the \"(.*)\" username$")
	public void user_enters_the_username(String name) throws Throwable {
		loginPage.enterFirstName(name);
	}

	@When("^user enter the \"(.*)\" password$")
	public void user_enter_the_password(String passwordX) throws Throwable {
		loginPage.enterPassword(passwordX);
	}

	@When("^user clicks on the login button$")
	public void user_clicks_on_the_login_button() throws Throwable {
		loginPage.clickOnLoginPortalButton();
	}

	@Then("^the user should be presented with the following prompt alert \"(.*)\"$")
	public void the_user_should_be_presented_with_the_following_prompt_alert(String message) throws Throwable {
		loginPage.verifyValidationAlert(message);
	}

	@Given("^Access Stackoverflow using Chrome$")
	public void access_Stackoverflow_using_Chrome() throws Throwable {
		loginPage.userNavigatesTo("https://www.stackoverflow.com");
	}
}
