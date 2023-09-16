@e2e @api
Feature: Get Room

  Scenario: Get room and Validate2

    Given send get request by id
    When validate response body