Feature: Test Case 2: Login User with correct email and password
	Description: I check the user login scenario works correct
@ignored
@positive
Scenario: Login User with correct email and password
	Given 	User has credentials
    When    User navigate to url 'https://automationexercise.com'
    Then    User verify that home page is visible successfully

	When 	User click on 'Signup / Login' button
	Then 	Verify 'Login to your account' is visible

	When 	User enter correct email address and password
	And 	Click 'login' button
	Then 	User Verify that 'Logged in as' 'username' is visible

	When 	Click 'Delete Account' button
	Then 	Verify that 'ACCOUNT DELETED!' caption is visible