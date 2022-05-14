Feature: Flight booking
Background:
	Given User is navigated successfully to the website
	When Verify its Title
@airAsia
Scenario:
And Click on Flights Icon
And Enter Origin as "Bengaluru (BLR)"
And Enter Destination as "Pune"
And Select depart date as "15/12/2019"
And Select Return date as "One Way"
And Click on Search Button
Then  Verify that you are navigated successfully to search flight page

@airAsia
Scenario:
And Click on login button
And Enter username as "a@gmail.com"
And Enter password as "India1234"
And Click on Sign In Button
Then Verify that error message




