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
@results
Feature: Asignación ganadores
  @regression
  Scenario: Asignacion automatica premio finalista
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
    When the contest change to "Ganadores Proximamente"
    And show ribbons
    Then the proposal has the finalist ribbon

  @regression
  Scenario: Asignacion automatica premio semi-finalista
    Given a proposal which a judge decide that can be advance
    And the fellow go to advance proposals selection section
    And advance the proposal
    And the proposal is visible in the Proposal Revision Phase
    And wait until phase change to finalist selection phase
    And a proposal in a contest in phase Finalist selection
    And a fellow decide not advance the proposal
    And wait until phase change to voting phase
    When the contest change to "Ganadores Proximamente"
    And show ribbons
    Then the proposal has the semi-finalist ribbon
  @regression
  Scenario: Cambiar premio a Popular choice
    Given a "admin" in the platform main page
    And logged in the platform with his username as "solmedo" and password as "odemlo13"
    And go to contests section
    And go to any proposal of contest in "Ganadores Anunciados" phase
    When go to admin section
    And select "Popular choice" ribbon
    Then the "Popular choice" ribbon is shown in proposal details
  @regression
  Scenario: Cambiar premio a Judges choicce
    Given a "admin" in the platform main page
    And logged in the platform with his username as "solmedo" and password as "odemlo13"
    And go to contests section
    And go to any proposal of contest in "Ganadores Anunciados" phase
    When go to admin section
    And select "Judges choice" ribbon
    Then the "Judges choicce" ribbon is shown in proposal details
  @regression
  Scenario: Cambiar premio a Popular & Judges choicce
    Given a "admin" in the platform main page
    And logged in the platform with his username as "solmedo" and password as "odemlo13"
    And go to contests section
    And go to any proposal of contest in "Ganadores Anunciados" phase
    When go to admin section
    And select "Popular & Judges choice" ribbon
    Then the "Popular & Judges choice" ribbon is shown in proposal details
