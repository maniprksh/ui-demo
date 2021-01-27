Feature: Verify API calls

  @testrunner
Scenario: Verify name of people1 API get call
  When I call "people/1" api
  Then I verify the name as "Luke Skywalker"
  And I print the films api


  Scenario: Get eye color of asked name
    When I call "people/" api
    Then I print the eye color for "Darth Vader"