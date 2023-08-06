@TestStore
Feature: Verify the functionality for payments after adding add to cart

@Validatenameandsurname
Scenario Outline: Validate the name and surname
Given Lunch the browser and navigate to automation test store application
And Click on register button
And User enter name "<name>" surname "<surname>" and other details in register page
When Click on Continue button
Then Validate the name "<name>" and surname "<surname>" on landing screen

Examples:
| name		| surname	|
| narsing	| rao			|

@Validatepaymentdetails
Scenario Outline: Validate the name and surname after entering all details
Given Lunch the browser and navigate to automation test store application
And Click on register button 
And User enter name "<name>" surname "<surname>" and other details in register page
When Click on Continue button
And Add a product to the cart and proceed to the checkout
And User enter payment details
Then Validate product details on payment page

Examples:
| name		| surname	|
| narsing	| rao			|






 