#language : en
Feature: Being able to login and send incidences
Scenario: send critic incidence
	Given a critic incidence with one critic value
    When I search it 
    Then it had critic state
