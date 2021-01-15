package stepDefinitionsX.Chrome;

import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import stepDefinitionsX.DriverFactory;

public class PopupAlertsPageSteps extends DriverFactory{
	
	@Given("^I click on the PopUpAlerts Link$")
	public void i_click_on_the_PopUpAlerts_Link() throws Throwable {
		popUpAlertsPage.clickOnPopUpAlertsLink();
	}

	@When("^I click on the JavaScript popup button$")
	public void i_click_on_the_JavaScript_popup_button() throws Throwable {
		popUpAlertsPage.clickOnJSPopUpButton();
	}

	@Then("^I should be able to click JavaScript Ok$")
	public void i_should_be_able_to_click_JavaScript_Ok() throws Throwable {
		popUpAlertsPage.clickOnJSOkPopupButton();
	}

	@When("^I click on the Modal popup button$")
	public void i_click_on_the_Modal_popup_button() throws Throwable {
		popUpAlertsPage.clickOnModalPopupButton();
	}

//	@Then("^I should be able to click Ok on Modal$")
//	public void i_should_be_able_to_click_Ok_on_Modal() throws Throwable {
//		popUpAlertsPage.clickOnModalOkButton();
//	}

	@Then("^Verify Popup Text \"(.*)\"$")
	public void verify_Popup_Text(String text) throws Throwable {
		popUpAlertsPage.verifyPopupText(text);
	}
	
	@Then("^Close ModalPopup$")
	public void close_ModalPopup() throws Throwable {
		popUpAlertsPage.closeModalPopup();
	}
	
	@When("^I click on the Ajax popup button$")
	public void i_click_on_the_Ajax_popup_button() throws Throwable {
		popUpAlertsPage.clickAjaxPopupButton();
	}


	@When("^Wait until Loader Finishes$")
	public void wait_until_Loader_Finishes() throws Throwable {
		popUpAlertsPage.waitUntilLoaderFinishes();
	}

	@When("^Click on the ClickMe Button$")
	public void click_on_the_ClickMe_Button() throws Throwable {
		popUpAlertsPage.clickOnClickMeButton();
	}

	@Then("^I should be able to click Close on Modal$")
	public void i_should_be_able_to_click_Close_on_Modal() throws Throwable {
		popUpAlertsPage.clickCloseOnModal();
	}

	

}
