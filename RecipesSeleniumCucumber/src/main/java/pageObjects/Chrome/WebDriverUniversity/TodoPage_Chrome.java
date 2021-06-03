package pageObjects.Chrome.WebDriverUniversity;

import java.io.IOException;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.Assert;

import pageObjects.BasePage;

public class TodoPage_Chrome extends BasePage {
	public @FindBy(xpath = "/html//a[@id='to-do-list']//h1[.='TO DO LIST']") WebElement link_todo;
	public @FindBy(xpath = "/html//i[@id='plus-icon']") WebElement button_Add;
	public @FindBy(xpath = "//div[@id='container']/input[@type='text']") WebElement textfield_AddNewTodo;
	public @FindBy(xpath = "//div[@id='container']/ul/li[1]") WebElement listItem_item;
	public @FindBy(xpath = "//*[@id=\"container\"]/ul/li[1]/span/i") WebElement listItem_itemDeleteButton;
	public @FindBy(xpath = "//div[@id='container']/ul/li[4]") WebElement lastListItem_item;

	public TodoPage_Chrome() throws IOException {
		super();
	}

	public void clickOnTodoList() throws InterruptedException {
		waitAndClickElement(link_todo);
		// tab code
		for (String windHandle : getDriver().getWindowHandles()) {
			driver.switchTo().window(windHandle);
		}
	}

	public void clickOnPlusButton() throws InterruptedException {
		if (!textfield_AddNewTodo.isDisplayed())
			waitAndClickElement(button_Add);
	}

	public void enterNewTodoItem() throws Exception {
		sendKeysToWebElement(textfield_AddNewTodo, "Hello World");
		textfield_AddNewTodo.sendKeys(Keys.ENTER);
	}

	public void verifyNewItem() {
		System.out.println("----Last List Item: " + lastListItem_item.getText());
		Assert.assertEquals("Hello World", lastListItem_item.getText());
	}

	public void clickOnToDoItem(int item) {
		listItem_item.click();
	}

	public void verifyItemCrossedOff() {
		System.out.println("-----VerifyItemCross Off Attribute: " + listItem_item.getAttribute("class"));
		Assert.assertEquals("completed", listItem_item.getAttribute("class"));
	}
	
	public void hoverItem(int i) {
		Actions hover = new Actions(driver);
		hover.moveToElement(listItem_item).build().perform();
		System.out.println("---Hovering  Mouse");
	}


	public void clickOnDeleteButton() throws InterruptedException, IOException {
		Thread.sleep(1000);
		this.wait.until(ExpectedConditions.elementToBeClickable(listItem_itemDeleteButton)).click();
	}

	public void verifyItemNotInList() throws InterruptedException {
		Thread.sleep(1000);
		System.out.println("---- List Of Items");
		List<WebElement> parentElement = driver.findElements(By.xpath("//*[@id=\"container\"]/ul/li"));
		for (WebElement element : parentElement) {
			System.out.println("Element #: " + element.getText());
		}
		Assert.assertEquals(parentElement.size(), 2);
	}



}
