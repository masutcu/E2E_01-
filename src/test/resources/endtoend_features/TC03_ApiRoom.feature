@e2e @api
Feature: Get Room

  Scenario: Get room and Validate2

    Given send get request to url by id
    When validate response body