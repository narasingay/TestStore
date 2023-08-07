@TestStore
Feature: Verify the functionality add to cart and payments for test store application

@Validatenameandsurname
Scenario Outline: Validate the name and surname
Given Lunch the browser and navigate to automation test store application
And Click on login or register button
And User enter name "<name>" surname "<surname>" and other details in register page
When Click on Continue button
Then Validate the name "<name>" and surname "<surname>" on landing screen

Examples:
| name		| surname	|
| Narsing	| rao			|

@Validateproducttdetails
Scenario Outline: Validate the add to cart functionality
Given Lunch the browser and navigate to automation test store application
And Click on login or register button
And user enters username "<username>" and userpassword "<userpassword>" on login account screen
And Click on login button
When User add product to the cart and proceed to the checkout
And User enter payment details
Then Validate product details on payment page

Examples:
| username				| userpassword		|
| automation215		| XXXXXXXXX				|





 