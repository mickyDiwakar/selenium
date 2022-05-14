Feature: this feature file to test get operation
@restAssuredGet2
Scenario: read wheather citywise
Given URI is "http://restapi.demoqa.com/utilities/weather/city"
When user send a request to get wheather of "Bangalore"
Then user get the response of Weather

@restAssuredGet3
Scenario: rest country
Given URI is "http://restcountries.eu/rest/v1/name"
When user send a request "INDIA"
Then verify the response of country "Republic of India" 
@restAssuredGet1
Scenario: rest country
Given URI is "http://restcountries.eu/rest/v1/name"
When user send a request "XYZ"
Then verify the error code in response  

@restAssuredGet
Scenario: rest country
Given URI is "http://restcountries.eu/rest/v1/name"
When Check the capital "norway"
Then print the details in commandline

@restAssuredGet4
Scenario: get
Given  url is "http://bookstore.toolsqa.com"
@restAssuredGet5
Scenario:
Given the End point Url is "https://samples.openweathermap.org"
