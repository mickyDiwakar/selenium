	Feature: CRMlogin
	Background: 
	Given User is logged in with chrome browser
	
	
	Scenario: CRM Homes Page
	And user enter the url
	When User login to crm application with "micky.diwakar@gmail.com" and "Crm@12345"
	Then Home page is displayed
	And Username is displayed
	And Close browser
	
	
	Scenario Outline: CRM Homes Page
	And user enter the url
	When User login to crm application with "<username>" and "<password>"
	Then Home page is displayed
	And Username is displayed
	And Close browser
	
	Examples: 
	|username|password|
	|micky.diwakar@gmail.com|Crm@12345|
	|micy.diwakar@gmail.com|Crm@1245|
	
	

@SmokeTest	
	Scenario: CRM Homes Page using map
	
	When User login to crm application with username and password
			|uname                  |pwd      |
			|micky.diwakar@gmail.com|Crm@12345|
			|micky.diakar@gmail.com|Cm@12345|
			
	Then Home page is displayed
	And Username is displayed
	And Close browser
	

@SmokeTest
	Scenario: CRM Homes Page using list
	
	When User login to crm application with username1 and password1
			|uname|pwd|
			|micky.diwakar@gmail.com|Crm@12345|
			|micky.diakar@gmail.com|Cm@12345|
			
	Then Home page is displayed
	And Username is displayed
	And Close browser
	
	
	
@E2ETest
Scenario: Create a Deals

 
When user enter the CRM PRO url
And  User logged in to PRO with username and password
		|username	|password|
		|mickydiwakar	|Crm@12345|

Then Hover to Deals tab and select New Deals
And enter all details new deals and click save
|Title|comapny	|Primecont|Amount|probab|commision|identifier|quant|type|source|status|pdate|Adate|reports|
|Test123|tester|90876|5000|60|8|utest|10|Old|Online|Open|9/04/2020|11/1/2020|Yes|

@E2ETest
Scenario: create an alert

When user enter the CRM PRO url
And  User logged in to PRO with username and password
		|username	|password|
		|mickydiwakar	|Crm@12345|
Then click on alert tab
And Delete existing alert
And Add new Alert
	|Alert|Type|Trigger|Format|Active|
	|[O]wner|Deals|Note Added|Text Message Alert|No|
	|[N]ew Owner|Tasks|Record Updated|Email Alert|Yes|
	
@E2ETest
Scenario: Check Tag and FreeCRM Link in blog tab

And user enter the CRM PRO url
And User logged in to PRO with username and password
	|username	|password|
	|mickydiwakar	|Crm@12345|
When user Click on Blog and navigate in new tab
	|Tab|
	|Blog|
Then Click on New Help Centre and click link [tag and free crm]

	

