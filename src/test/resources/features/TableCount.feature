Feature: Table record count

  Scenario: Table record count should match expected
    Given a table with name of user
    When the operator requests count
    Then the table record count should be 1

  Scenario: Table record count should match expected
    Given a table with name of employee
    When the operator requests count
    Then the table record count should be 3
