
Feature: verify Orders Details
  Background:
 		Given User launch specified browser
    When User Open URL "https://admin-demo.nopcommerce.com/login?ReturnUrl=%2Fadmin%2F" 
    And User enter valid username "admin@yourstore.com" and password "admin"
    When User click on Login 
    Then  User able to login successfully and verify home page title "Dashboard / nopCommerce administration"
   
@sanityTests
  Scenario: Verify Order createdtime with status as complete
    When  User clicks on Sales menu 
    When  User cliks on Submenu Orders under Sales
    When  Select Orders status as Completed 
    When  User clicks on Search
    Then  verify the records displayed woth status completed
    Then  verify the created time for above record with completed status.
    
    