#Author: your.email@your.domain.com
#Keywords Summary :
#Feature: List of scenarios.
#Scenario: Business rule through list of steps with arguments.
#Given: Some precondition step
#When: Some key actions
#Then: To observe outcomes or validation
#And,But: To enumerate more Given,When,Then steps
#Scenario Outline: List of steps for data-driven as an Examples and <placeholder>
#Examples: Container for s table
#Background: List of steps run before each of the scenarios
#""" (Doc Strings)
#| (Data Tables)
#@ (Tags/Labels):To group Scenarios
#<> (placeholder)
#""
## (Comments)
#Sample Feature Definition Template
@votingSystem
Feature: Sistema de votaciones

  Background: 
    Given a proposal which a judge decide that can be advance
    And the fellow go to advance proposals selection section
    And advance the proposal
    And the proposal is visible in the Proposal Revision Phase
    And wait until phase change to finalist selection phase
    And a proposal in a contest in phase Finalist selection
    And a fellow decide advance the proposal
    And select the judge
    And the judge decide that can be advance
    And the fellow go to advance proposals selection section
    And advance the proposal
    And the proposal is visible in the voting Phase

  Scenario: Votar propuesta
    Given a "member" into the proposal which can be vote
    And logged in the platform with his username as "20190108215141311" and password as "Password123"
    When vote for the proposal
    Then appear a message to notify of the vote

  Scenario: Votar propuesta
  	Given a "member" into the proposal which can be vote
    And logged in the platform with his username as "20190108215141311" and password as "Password123"
    When vote for the proposal
    Then the button change to remove vote
    And the count increment in 1

  Scenario: Retirar voto
   Given a "member" into the proposal which can be vote
    And logged in the platform with his username as "20190108215141311" and password as "Password123"
    When vote for the proposal
    And close voting message
    And click on remove vote
    Then the button change to vote again
    And the count decreased in 1
