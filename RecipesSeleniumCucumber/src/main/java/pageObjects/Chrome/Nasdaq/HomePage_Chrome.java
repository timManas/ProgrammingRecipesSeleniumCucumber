package pageObjects.Chrome.Nasdaq;

import java.io.IOException;
import java.util.List;

import org.junit.Assert;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindAll;
import org.openqa.selenium.support.FindBy;

import pageObjects.BasePage;

public class HomePage_Chrome extends BasePage{
	public @FindBy(xpath="//input[@placeHolder=\"Find a Symbol\"]") WebElement symbolInputField;
	public @FindBy(xpath="//button[@class=\"find-symbol__submit\"]") WebElement symbolButton;
	public @FindBy(xpath="//span[@class=\"symbol-page-header__name\"]") WebElement symbolName;
	public @FindBy(xpath="//span[@class=\"symbol-page-header__pricing-price\"]") List<WebElement> symbolPrice;
	
	public HomePage_Chrome() throws IOException {
		super();
	}

	public HomePage_Chrome getHomePage() throws IOException {
		getDriver().get("http://www.nasdaq.com");
		return new HomePage_Chrome();
	}

	public HomePage_Chrome enterSymbol(String symbol) throws Exception {
		sendKeysToWebElement(symbolInputField, symbol);
		return new HomePage_Chrome();
	}

	public HomePage_Chrome clicksOnFindSymbolButton() throws InterruptedException, IOException {
		waitAndClickElement(symbolButton);
		return new HomePage_Chrome();
	}

	public HomePage_Chrome verifyDataOnSymbolPage() throws IOException {
		System.out.println("Text: " + symbolName.getText());
		Assert.assertEquals("Apple Inc. Common Stock (AAPL)", symbolName.getText());
		
		String price = null;
		for (WebElement element : symbolPrice) {
			if (element.getText().contains("$")) {
				price = element.getText();
				System.out.println("Price: " + price);
			}
				
		}
		
		Assert.assertNotNull(price);
		
		return new HomePage_Chrome();
	}

}


