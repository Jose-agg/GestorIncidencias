#language : en
Feature: Being able to login and being an operator
Scenario: list incidences
	Given 3 incidences
    When the operator list it
    Then he see 3 incidences
