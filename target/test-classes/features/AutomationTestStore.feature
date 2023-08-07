@TestStore
Feature: Verify the test store automation

  @Validatenameandsurname
  Scenario Outline: Validate the name and surname after registering with required details
    Given Lunch the browser and navigate to automation test store application
    And Click on login or register button
    When Click on Continue button
    And User enter name "<Name>" surname "<Surname>" email "<Email>" loginname "<Loginname>" and other details in register page
    When Click on Continue button
    Then Validate the name "<Name>" and surname "<Surname>" on landing screen
    And User logout the test store application

    Examples: 
      | Name    | Surname | Email                   | Loginname     |
      | Narsing | rao     | automation555@gmail.com | automation444 |

  @Validateproducttdetails
  Scenario Outline: Validate the product details after checkout on payments page
    Given Lunch the browser and navigate to automation test store application
    And Click on login or register button
    And user enters username "<Username>" and userpassword "<Userpassword>" on login account screen
    And Click on login button
    When User add product to the cart and click on checkout
    Then Validate product "<Productname>" details on payments page
    And User logout the test store application

    Examples: 
      | Username      | Userpassword | Productname   |
      | automation444 | XXXXXXXXX    | Shaving cream |
