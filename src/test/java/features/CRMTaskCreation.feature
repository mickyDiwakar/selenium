Feature: New task creation
Background: 
Given user logged in to CRM Application
@CRM
Scenario Outline: crreation of multiple task
When user mouse hover to "Cases" and select "New Case"
And User enter the "<Title>","<Status>","<DeadLine>" and "<State>","<Type>", "<priority>","<AssignedTo>","<emailnotify>","<Contact>" details for task creation 
Then verify task created
Examples:
|Title|Status|DeadLine|State|Type|priority|AssignedTo|emailnotify|Contact|
|Mr|Enquiring|14/07/2020|Open|Complaint|Low|diwakar kumar|yes|diwak	|
|Miss|Enquiring|14/08/2020|Open|Complaint|Low|diwakar kumar|yes|diwak|
|Mrs|Enquiring|15/01/2021|Closed|Enquiry|High|diwakar kumar|yes|diwak	|

@CRM1
Scenario: checkdataArchive
When user click on "Blog"
And click WindowXP tiles and click Announcement in categories
	|Announcements|
And  click on Archive "February 2019"
And  click on "CRMPRO News" 
Then Verify the result as "Page not found"
