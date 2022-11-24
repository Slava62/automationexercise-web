Feature: Test Case 1: Register User
    Description: I check the user registration scenario works correct
@ignored
@positive  
Scenario: User try to create account
    Given   User has data to create account
    When    User navigate to url 'https://automationexercise.com'
    Then    User verify that home page is visible successfully
    
    When    User click on 'Signup / Login' button
    Then    Verify 'New User Signup!' is visible

    When    User enter name and email address
    And     Click 'Signup' button
    Then    Verify that 'ENTER ACCOUNT INFORMATION' is visible

    When    User Fill details: Title, Name, Email, Password, Date of birth

    And     Select checkbox 'Sign up for our newsletter!'
    And     Select checkbox 'Receive special offers from our partners!'
    And     Fill details: First name, Last name, Company, Address, Address2, Country, State, City, Zipcode, Mobile Number
    And     Click 'Create Account button'
    Then    Verify that 'ACCOUNT CREATED!' caption is visible
    And     Click 'Continue' button
    And     Verify that 'Logged in as' 'username' is visible

    Then    Click 'Delete Account' button
    And     Verify that 'ACCOUNT DELETED!' caption is visible
    And     Click 'Continue' button


