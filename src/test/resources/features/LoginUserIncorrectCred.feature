Feature: Test Case 3: Login User with incorrect email and password
	Description: I check the errors catch when login with incorrect email and password
@ignored
@negative
Scenario: Login User with incorrect email and password
	Given 	User has incorrect email and password
    When    User navigate to url 'https://automationexercise.com'
    Then    User verify that home page is visible successfully

	When 	User click on 'Signup / Login' button
	Then 	Verify 'Login to your account' is visible

	When 	User enter incorrect email address and password
	And 	Click 'login' button
	Then 	Verify error 'Your email or password is incorrect!' is visible