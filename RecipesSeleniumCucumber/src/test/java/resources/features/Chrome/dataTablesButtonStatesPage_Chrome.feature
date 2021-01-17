Feature: Chrome - Data, Tables & Button States

Background: 
	Given I access webdriveruniversity
	And I click on the Data Tables And Button Shares Link

Scenario Outline: Able to grab Info form the Table
	Given Fetch the data from the 2nd Table
	
	Examples:
	| 	          url 					| 		username 		|		 password		 |		 message		 |
	|http://www.webdriveruniversity.com/|	webdriver3			|		wendriver 		 | validation failed     |
	|http://www.webdriveruniversity.com/|	webdriver			|		webdriver123	 | validation succeeded  |
	|http://www.webdriveruniversity.com/|	35=D,55=AAPL		|		40=1,18=1		 | validation failed 	 |
	 

Scenario: Able to Input First, Last Name and Input into text box
	Given Enter First Name
	And Enter Last Name
	Then Enter Text Below

Scenario: Able to click on the BreadCrumb
	Given Click on the About Us Link 

Scenario: Able to Fetch the Data off Badges
	Given Get Data off the Todays Deals is more than 1
	And Get Data of All Products is more than 10

Scenario: Able to click on the Pagination
	Given Fetch the number of Pages
	Then Click on the last one

Scenario: User is able to get the info from the Table
	Given Fetch all the data from the Table

Scenario: User is able to get fetch the data off the Random Text
	Given Fetch the Text
	Then Validate texst contains "Lorem Ipsum"

Scenario: User is able to get the Tree List
	When Fetch all the data from the list
	Then Print the last element from each list
