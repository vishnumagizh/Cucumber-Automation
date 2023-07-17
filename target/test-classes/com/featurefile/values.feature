
@tag
Feature: Check currency converter

  @tag1
  Scenario: user selects the required option to convert the currency
    Given launch the application
    
    When user enters "50"  in amount field
    And user selects "USD" currency option before conversion
    And user selects "inr" currency to be converted after conversion
    Then user converts the currency
    And user displays the converted currency 

