Feature: 2ndfeature
Background: 

Given User is logged in with chrome browser
When user enter the CRM PRO url
And  User logged in to PRO with username and password
		|username	|password|
		|mickydiwakar	|Crm@12345|


		
@E2ETest
Scenario: Naviagte to calandertab and search for conatct
 Then user hover to "Calendar" and click on view today
 And For specific time click on newEvent
 	|time|contnum|
 	|09:00AM|9035|
 

@E2ETest
Scenario: Enter values in contacts - fullsearch
Then mouse hover "Contacts" and click Full Search Form
And Enter Title,firstname,savesearch,supervisor,searchconatct
	|Title|Firstname|supervisor|
	|Mr.|diwakar|diwakar kumar|
	
@E2ETest1
Scenario: Find a refrence element in table and click respetive cell	
Then Click on column refered by column
	|05:00AM|
	
@E2ETest2
Scenario: Create a new Task
Then Mouse hover Tasks and click New Task
And Enter the details
	|Title|AutoExtend					|status|completion|Type|priority|
	|Mr	|Extend deadline by 1 day		|Open	|70			|Call|Low		|
And click On Save button
And check Task created

