Feature: Test Case 4: Logout User
	Description: I check the user can logout
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

	When 	Click 'Logout' button
	Then 	Verify that user is navigated to login page