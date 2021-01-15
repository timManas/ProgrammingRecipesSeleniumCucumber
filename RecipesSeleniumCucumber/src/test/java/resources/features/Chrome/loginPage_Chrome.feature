Feature: Test Login - Chrome


Scenario: Login account with a valid password
	Given I access webdriveruniversity
	When I click on the login portal link
	And I enter a username
	And I enter a "webdriver123" password
	When I click on the login button
	Then I should be presented with a succesfful validation alert
	

@TagInvalidLogin
Scenario: Login account with a invalid password
	Given I access webdriveruniversity
	When I click on the login portal link
	And I enter a username
	And I enter a "invalid: 35=D,40=1,18=1" password
	When I click on the login button
	Then I should be presented with a unsuccesfful validation alert  
	

@TagScenarioOutline
Scenario Outline: Test Login to account with credentials using ScenarioOutlines
	Given user navigates to "<url>"
	When user clicks on the login portal link
	And user enters the "<username>" username
	And user enter the "<password>" password
	When user clicks on the login button
	Then the user should be presented with the following prompt alert "<message>"
	
	
	Examples:
	| 	          url 					| 		username 		|		 password		 |		 message		 |
	|http://www.webdriveruniversity.com/|	webdriver3			|		wendriver 		 | validation failed     |
	|http://www.webdriveruniversity.com/|	webdriver			|		webdriver123	 | validation succeeded  |
	|http://www.webdriveruniversity.com/|	35=D,55=AAPL		|		40=1,18=1		 | validation failed 	 |

	
@HookTagCombination
Scenario: Hook Combined with Tags Example
	Given Access Stackoverflow using Chrome
	