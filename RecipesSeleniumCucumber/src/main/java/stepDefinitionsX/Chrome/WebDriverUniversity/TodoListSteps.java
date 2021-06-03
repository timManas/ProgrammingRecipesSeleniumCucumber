package stepDefinitionsX.Chrome.WebDriverUniversity;

import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import stepDefinitionsX.DriverFactory;

public class TodoListSteps extends DriverFactory {
	
	
	@Given("^I click on the TodoList Link$")
	public void i_click_on_the_TodoList_Link() throws Throwable {
		todoPage.clickOnTodoList();
	}

	@When("^I click on the \\+ button$")
	public void i_click_on_the_button() throws Throwable {
		todoPage.clickOnPlusButton();
	}

	@When("^I can enter a new Todo list$")
	public void i_can_enter_a_new_Todo_list() throws Throwable {
		todoPage.enterNewTodoItem();
	}

	@Then("^I should see the new item at the bottom of the list$")
	public void i_should_see_the_new_item_at_the_bottom_of_the_list() throws Throwable {
		todoPage.verifyNewItem();
	}

	@When("^I click on the first item$")
	public void i_click_on_the_first_item() throws Throwable {
		todoPage.clickOnToDoItem(0);
	}

	@Then("^I should see item crossed off$")
	public void i_should_see_item_crossed_off() throws Throwable {
		todoPage.verifyItemCrossedOff();
	}

	@When("^I hover over the first item$")
	public void i_hover_over_the_first_item() throws Throwable {
		todoPage.hoverItem(0);
	}

	@When("^Click on the delete button$")
	public void click_on_the_delete_button() throws Throwable {
		todoPage.clickOnDeleteButton();
	}

	@Then("^I should not see the item in the list$")
	public void i_should_not_see_the_item_in_the_list() throws Throwable {
		todoPage.verifyItemNotInList();
	}
}
