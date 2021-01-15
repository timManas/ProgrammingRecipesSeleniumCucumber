Feature: Chrome - Verify the Popup Page

Background: 
	Given I access webdriveruniversity
	And I click on the PopUpAlerts Link
	
	
Scenario: User click on JavaScript popup
	When I click on the JavaScript popup button
	Then I should be able to click JavaScript Ok
	
	 
Scenario: User click on Modal popup
	When I click on the Modal popup button
	And Verify Popup Text "It’s that Easy!! Well I think it is....."
	And Close ModalPopup
	
	
Scenario: User click on Ajax popup
	When I click on the Ajax popup button
	And Wait until Loader Finishes
	And Click on the ClickMe Button
	Then I should be able to click Close on Modal



