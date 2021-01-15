package pageObjects.Chrome;

import java.io.IOException;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.Assert;

import pageObjects.BasePage;

public class PopupAlertsPage_Chrome extends BasePage{
	//	public @FindBy(xpath = "") WebElement ;
	public @FindBy(xpath = "/html//a[@id='popup-alerts']//h1[.='POPUP & ALERTS']") WebElement link_popUpAlert;
	public @FindBy(xpath = "//*[@id=\"button1\"]/p") WebElement button_JSAlert;
	public @FindBy(xpath = "//*[@id=\"button2\"]/p") WebElement button_ModalPopup ;
	public @FindBy(xpath = "//*[@id=\"myModal\"]/div/div/div[1]/h4") WebElement text_modalPopup;
	public @FindBy(xpath = "//*[@id=\"myModal\"]/div/div/div[3]/button") WebElement button_modalPopupClose;
	public @FindBy(xpath = "//*[@id=\"button3\"]/p/a") WebElement button_AjaxLoader;
	public @FindBy(xpath = "//*[@id=\"loader\"]") WebElement loader;
	public @FindBy(xpath = "//*[@id=\"button1\"]/p") WebElement button_clickMeAjax;
	public @FindBy(xpath = "//*[@id=\"myModalClick\"]/div/div/div[3]/button") WebElement button_closeAjax;
	
	public PopupAlertsPage_Chrome() throws IOException {
		super();

	}

	public void clickOnPopUpAlertsLink() throws InterruptedException {
		waitAndClickElement(link_popUpAlert);
		// tab code
		for (String windHandle : getDriver().getWindowHandles()) {
			driver.switchTo().window(windHandle);
		}
	}

	public void clickOnJSPopUpButton() throws InterruptedException {
		button_JSAlert.click();
	}

	public void clickOnJSOkPopupButton() {
		Alert alert = driver.switchTo().alert(); //Alert	
		System.out.println("Alert: " + alert.getText());
		Assert.assertEquals(alert.getText().toString(), "I am an alert box!");
		alert.accept();
		System.out.println("----Clicked on Ok on the JS Alert Popup");
	}

	public void clickOnModalPopupButton() throws InterruptedException {
		waitAndClickElement(button_ModalPopup);
	}

	public void verifyPopupText(String text) {
		this.wait.until(ExpectedConditions.elementToBeClickable(text_modalPopup));
		System.out.println("---Modal PopupText: " + text_modalPopup.getText());
		Assert.assertEquals(text_modalPopup.getText(), text);
	}
	
	public void closeModalPopup() throws InterruptedException {
		waitAndClickElement(button_modalPopupClose);
	}

	
	public void clickAjaxPopupButton() throws InterruptedException {
		button_AjaxLoader.click();
		Thread.sleep(1000);
	}

	public void waitUntilLoaderFinishes() throws InterruptedException {
		System.out.println("----IsDisplayed: " + loader.isDisplayed());		
		WebElement element = driver.findElement(By.xpath("//*[@id=\"loader\"]"));
		
		// WAIT UNTIL ELEMENT IS INVISIBLE
		this.wait.until(ExpectedConditions.invisibilityOf(element));
		System.out.println("----IsDisplayed: " + element.isDisplayed());
	}


	public void clickOnClickMeButton() throws InterruptedException {
		waitAndClickElement(button_clickMeAjax);
	}

	public void clickCloseOnModal() throws InterruptedException {
		waitAndClickElement(button_closeAjax);
	}





}
