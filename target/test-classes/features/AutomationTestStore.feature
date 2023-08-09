@TestStore
Feature: Verify the test store automation

  @Validatenameandsurname
  Scenario Outline: Validate the name and surname after registering with required details
    Given Launch the browser "<BrowserName>" and navigate to automation test store application
    And Click on login or register button
    When Click on Continue button
    And User enter name "<Name>" surname "<Surname>" email "<Email>" loginname "<Loginname>" and other details in register page
    When Click on Continue button
    Then Validate the name "<Name>" and surname "<Surname>" on landing screen
    And User logout the test store application

    Examples: 
      | BrowserName | Name    | Surname | Email                   | Loginname     |
      | Chrome      | Narsing | rao     | automation888@gmail.com | automation777 |

  @Validateproducttdetails
  Scenario Outline: Validate the product details after checkout on payments page
    Given Launch the browser "<BrowserName>" and navigate to automation test store application
    And Click on login or register button
    And user enters username "<Username>" and userpassword "<Userpassword>" on login account screen
    And Click on login button
    When User add product to the cart and click on checkout
    Then Validate product "<Productname>" details on payments page
    And User logout the test store application

    Examples: 
      | BrowserName | Username      | Userpassword | Productname   |
      | Chrome      | automation777 | XXXXXXXXX    | Shaving cream |
