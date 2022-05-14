Feature: Hotel booking
Background:
Given User is navigated successfully to the website

@airAsia1
Scenario:
And Click on "Hotels" tab
When User landed on search page enter leaving and going 
	|leavingFrom|goingTo|
	|	bangalore		|	delhi	|
And Enter departing and returing date
|DepartingDate|ReturningDate|
|29/02/2020|01/03/2020|
And select "1" rooms
And Select number of adult "6" and children "3"
And Select the direct flight and hotel
And Select prefrred class as "Business"
Then Click on Search button

@airAsia1
Scenario:	
And Click on SNAP "Bags, Meals, Seats" tab
When user landed on search booking and enter invalid bookingnumber,familySurname
	|BookingNumber|FamilySurname|
	|1234|kumar|
And select departure
	|CEI|
And click on search "Search" button
Then check the error message
