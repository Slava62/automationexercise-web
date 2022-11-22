Feature: Test Case 1: Register User
    Description: I check the user registration scenario works correct

# Background: User is on main page
# # 	Given I navigate to the login page
# 	# When I submit username and password
# 	# Then I should be logged in 

Scenario: User try to create account
    Given   User launch browser
    When    User navigate to url 'https://automationexercise.com'
    Then    User verify that home page is visible successfully
    
    When    User click on 'Signup / Login' button
    Then    Verify 'New User Signup!' is visible

    When    User enter name and email address
    And     Click 'Signup' button
    Then    Verify that 'ENTER ACCOUNT INFORMATION' is visible

    When    User Fill details: Title, Name, Email, Password, Date of birth

     And     Select checkbox 'Sign up for our newsletter!'
#     And     Select checkbox 'Receive special offers from our partners!'
    # And     Fill details: First name, Last name, Company, Address, Address2, Country, State, City, Zipcode, Mobile Number
    # And     Click 'Create Account button'
    # Then    Verify that 'ACCOUNT CREATED!' is visible
    # And     Click 'Continue' button
    # And     Verify that 'Logged in as username' is visible

# 17. Click 'Delete Account' button
# 18. Verify that 'ACCOUNT DELETED!' is visible and click 'Continue' button

# 	Given User search for Lenovo Laptop
# 	When Add the first laptop that appears in the search result to the basket
# 	Then User basket should display with added item

# Scenario: Navigate to a product and add the same to the User basket
# 	Given User navigate for Lenovo Laptop
# 	When Add the laptop to the basket
# 	Then User basket should display with added item


