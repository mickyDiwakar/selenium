Feature: Put operation
@restAssuredPut
Scenario: Create a entry if not present if present overide the same
Given URI for Put is given
When user enter the body and hit the response
Then check the rsponse of the body

