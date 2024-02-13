
Feature: Todays Discount
  Background:
 		Given User launch specified browser
    When User Open URL "https://admin-demo.nopcommerce.com/login?ReturnUrl=%2Fadmin%2F" 
    And User enter valid username "admin@yourstore.com" and password "admin"
    When User click on Login 
    Then  User able to login successfully and verify home page title "Dashboard / nopCommerce administration"
   
@smokeTests
  Scenario: verify the Discount for todays date.
    When  User clicks on discount menu 
    Then  User able to see discount fields
    When  Select todays date as start date 
    When  User cliks on Search
    Then  verify the discount is present
    Then Close the browser
    
    
 @smokeTests
  Scenario: verify the Discount for given enddate date.
    When  User clicks on discount menu 
    Then  User able to see discount fields
    When  Select todays date as Enddate as "1/30/2024" date 
    When  User cliks on Search
    Then  verify the discount is present
    Then Close the browser
    
    
    
    
   