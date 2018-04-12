Feature: User management
  As a user manager
  I want to manage users

 Scenario: User can list resources
    Given No resources have been created
    When I list resources on the server
    Then I get 2 names
