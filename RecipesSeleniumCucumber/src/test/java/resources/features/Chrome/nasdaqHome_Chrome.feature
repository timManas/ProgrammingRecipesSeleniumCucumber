Feature: Chrome - Verify Elements on HomePage

Background: 
	Given I access nasdaq homepage

Scenario: Verify Elements in Navbar HomePage
	Given Fetch the list of elements in Market Activity
	And Fetch the list of elements in News + Insights
	And Fetch the list of elements in Solutions
	And Fetch the list of elements in About
	
Scenario: Find a Symbol
	Given I enter a symbol "AAPL"
	Then verify user is taken to Page
	
Scenario: Verify Just In
	Given I click on the Just In
	Then verify user is taken to article in just in
	
Scenario: Verify Top Reads
	Given User is able to click on First Article
	Then User is taken to Article on TopReads
	
Scenario: Verify Latest News
	Given User is able to click on the 2nd particle in Latest News
	Then User is takent to Article for latest News
	
Scenario: Verify Upcoming Market Events
	Given User is able to click on the Dividends
	Then User is taken to Dividends event page
	
Scenario: Verify Most Active By Dollar Volume
	Given User is able to fetch all Stocks data

Scenario: Verify US Market is Closed/Open
	Given User is able to verify the Nasdaq-100 Index Data
	Then User is able to click on Nasdaq-100 link

Scenario: Verify Nasdaq watch
	Given User is able to view Nasdaq watch
	And User is able to select next Nasdaq watch
	Then User is able to click Pause
	And User is able to click Mute
	Then User is able to click on See More Video
	
