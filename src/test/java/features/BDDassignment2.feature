Feature: by using this http://automationpractice.com/index.php

@automationpractice
Scenario: verfiythecreationofmember
 
Given Click on Sign In2 Button
And Create an account box
	|email|
	|mdk92@gmail.com|

When Select the below data and Click on Register button
	|title	|firstname	|lastname	|password	|date|month|year|Address1|Address2|City|state|country|postalcode|MbPhone|
	|Mr		|Diwa		|kum		|mdm@123		|15|11|2019|adress1|address2|bangalore|Florida|United States|58060|9066|

Then Validate that you are successfully registered  