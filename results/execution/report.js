$(document).ready(function() {var formatter = new CucumberHTML.DOMFormatter($('.cucumber-report'));formatter.uri("BDDassignment.feature");
formatter.feature({
  "line": 1,
  "name": "Flight booking",
  "description": "",
  "id": "flight-booking",
  "keyword": "Feature"
});
formatter.scenario({
  "line": 4,
  "name": "",
  "description": "",
  "id": "flight-booking;",
  "type": "scenario",
  "keyword": "Scenario",
  "tags": [
    {
      "line": 3,
      "name": "@Assigment1"
    }
  ]
});
formatter.step({
  "line": 5,
  "name": "User is navigated successfully to the website",
  "keyword": "Given "
});
formatter.step({
  "line": 6,
  "name": "Verify its Title",
  "keyword": "When "
});
formatter.step({
  "line": 7,
  "name": "Click on Flights Icon",
  "keyword": "And "
});
formatter.step({
  "line": 8,
  "name": "Enter Origin as \"Bengaluru (BLR)\"",
  "keyword": "And "
});
formatter.step({
  "line": 9,
  "name": "Enter Destination as \"Pune\"",
  "keyword": "And "
});
formatter.step({
  "line": 10,
  "name": "Select depart date as \"15/12/2019\"",
  "keyword": "And "
});
formatter.step({
  "line": 11,
  "name": "Select Return date as \"One Way\"",
  "keyword": "And "
});
formatter.step({
  "line": 12,
  "name": "Click on Search Button",
  "keyword": "And "
});
formatter.step({
  "line": 13,
  "name": "Verify that you are navigated successfully to search flight page",
  "keyword": "Then "
});
formatter.match({
  "location": "Assignment.user_is_navigated_successfully_to_the_website()"
});
formatter.result({
  "duration": 17354930876,
  "status": "passed"
});
formatter.match({
  "location": "Assignment.verify_its_Title()"
});
formatter.result({
  "duration": 15308315,
  "status": "passed"
});
formatter.match({
  "location": "Assignment.click_on_Flights_Icon()"
});
formatter.result({
  "duration": 388397394,
  "status": "passed"
});
formatter.match({
  "arguments": [
    {
      "val": "Bengaluru (BLR)",
      "offset": 17
    }
  ],
  "location": "Assignment.enter_Origin_as_Bengaluru_BLR(String)"
});
formatter.result({
  "duration": 4132002359,
  "status": "passed"
});
formatter.match({
  "arguments": [
    {
      "val": "Pune",
      "offset": 22
    }
  ],
  "location": "Assignment.enter_destination_as_something(String)"
});
formatter.result({
  "duration": 1791924774,
  "status": "passed"
});
formatter.match({
  "arguments": [
    {
      "val": "15/12/2019",
      "offset": 23
    }
  ],
  "location": "Assignment.select_depart_date_as_something(String)"
});
formatter.result({
  "duration": 3068346437,
  "status": "passed"
});
formatter.match({
  "arguments": [
    {
      "val": "One Way",
      "offset": 23
    }
  ],
  "location": "Assignment.select_return_date_as_something(String)"
});
formatter.result({
  "duration": 845507726,
  "status": "passed"
});
formatter.match({
  "location": "Assignment.click_on_Search_Button()"
});
formatter.result({
  "duration": 379743382,
  "status": "passed"
});
formatter.match({
  "location": "Assignment.verify_that_you_are_navigated_successfully_to_search_flight_page()"
});
formatter.result({
  "duration": 5053458504,
  "status": "passed"
});
});