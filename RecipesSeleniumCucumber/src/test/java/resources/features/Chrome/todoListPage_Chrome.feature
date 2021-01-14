Feature: Chrome - Verify the TODO List Page

Background: 
	Given I access webdriveruniversity
	And I click on the TodoList Link
	
	
Scenario: User should be able to Add a new item and Modify
	When I click on the + button
	And I can enter a new Todo list
	Then I should see the new item at the bottom of the list
	
	 
Scenario: User should be able to Cross off items
	When I click on the first item
	Then I should see item crossed off

Scenario: User should be able to Delete items
	When I hover over the first item
	And Click on the delete button
	Then I should not see the item in the list
