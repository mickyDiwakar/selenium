Feature: POst request
@restAssuredPost
Scenario: script to make a post request to the service for user registration
Given Post request URI for registration "http://restapi.demoqa.com/customer"
And Body param is given for registration
	|FirstName|LastName |UserName |Password |Email|
	|John01|chmerkdiw911n|jnchkediwak9111|n1an10bc@12911|jn1koohn11.cherk@gmail.com|       
When user hit request check 201 as status code
And check the response body message "OPERATION_SUCCESS"
Then hit the request gain and check the status code 200
And  check the response body error message "FAULT_USER_ALREADY_EXISTS"

@restAssuredPost
Scenario: login to an application with authentication
Given request URI is given to login "http://restapi.demoqa.com/authentication"
When Enter "ToolsQA" and "TestPassword1" to login an application
Then check user logged in
@restAssuredPost4
Scenario: Authorize user is able to Add and remove book
Given A list of book available
When  I Add a book in my reading list
Then The book is added
When I remove a book from reading list
Then the book is removed