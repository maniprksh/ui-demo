Feature: test

  Scenario: Verify the find flight button displays reserve page with Flight to select
    Given I navigate to the Blazeurl
    And I select the from city as "Boston"
    And I select to city as "Dublin"
    Then I click on Find flight button
    And verify reserve page url
    And I verify the header of the page for city "Boston" to "Dublin"
    And I click on "United Airlines" flight


    Scenario: Purchase the flight selected
      Given I navigate to the Blazeurl
      And I select the from city as "Boston"
      And I select to city as "Dublin"
      And I click on Find flight button
      And verify reserve page url
      And I verify the header of the page for city "Boston" to "Dublin"
      And I click on "United Airlines" flight
      And I fill the details with "John","47 collins street","Melbourne"
      And further details "Victoria","3008","amex","45323456677","07","2021","John"
      And set remember me check box as "N"
      Then click on Purchase button
      And Confirm Purchase Page


