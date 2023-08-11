@TestStore
Feature: Verify the name and product details in automation test store application

  @Validatenameandsurname
  Scenario: Validate the name and surname after registering with required details
    Given Launch the browser and navigate to automation test store application
    And Click on login or register button
    When Click on Continue button
    And User enters personal and other details as requiired in register page to signup
      | Name    | Surname | Email                    | Addressone | Country   | State     | City      | Zipcode | Loginname      |
      | Narsing | Rao     | automation2222@gmail.com | Singapore  | Singapore | Singapore | Singapore |  541203 | automation2222 |
    When Click on Continue button
    Then Validate the name and surname on landing screen
      | Name    | Surname |
      | Narsing | Rao     |
    And User logout the test store application

  @Validateproducttdetails
  Scenario Outline: Validate the product details after checkout on payments page
    Given Launch the browser and navigate to automation test store application
    And Click on login or register button
    And user enters username and userpassword on login account screen
    And Click on login button
    When User add product to the cart and click on checkout
    Then Validate product "<Productname>" details on payments page
    And User logout the test store application

    Examples: 
      | Productname   |
      | Shaving cream |
