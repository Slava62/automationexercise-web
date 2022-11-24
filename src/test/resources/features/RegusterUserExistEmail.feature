Feature: Test Case 5: Register User with existing email
	Description: I check the errors catch when user register with existing email

@positive
Scenario: Register User with existing email
	Given 	User has existing email
    When    User navigate to url 'https://automationexercise.com'
    Then    User verify that home page is visible successfully

	When 	User click on 'Signup / Login' button
	Then    Verify 'New User Signup!' is visible

	When 	User enter name and email address
	And 	Click 'Signup' button
	Then 	Verify error 'Email Address already exist!' is displayed