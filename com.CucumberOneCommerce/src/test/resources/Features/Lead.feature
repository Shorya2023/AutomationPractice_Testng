Feature: Lead add/delete feature
		
		
  Scenario: Lead creation/addition a new lead
  	When  Uesr Go to Create Lead Page 
    Given User enters the lead details
    When User Go to Lead details Page
    Then User Verify lead detais
		When User clicks on lead in op Menu
		Then Lead Should be visible in Grid

  Scenario: Lead Deletion
    When User select a  Lead
    And  User clicks on delete button
    Then Lead should get deleted

