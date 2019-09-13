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
# encoding: utf-8
@selectFinalist
Feature: Selección de propuestas finalistas
  Como equipo del concurso quiero poder gestionar las decisiones de la propuesta para poder avanzar la propuesta a siguientes fases del concurso.

  Background: 
    Given a proposal which a judge decide that can be advance
    When the fellow go to advance proposals selection section
    And advance the proposal
    And the proposal is visible in the Proposal Revision Phase
    And wait until phase change to finalist selection phase

  Scenario: Fellow rechaza propuesta
    Given a proposal in a contest in phase Finalist selection
    When a fellow decide not advance the proposal
    Then the proposal is not visible in the voting phase

  Scenario: Fellow acepta propuesta y asigna juez
    Given a proposal in a contest in phase Finalist selection
    When a fellow decide advance the proposal
    And select the judge
    Then assigned judge can evaluate the proposal


  Scenario: Propuesta que un juez ha evaluado positivamente pero fellow rechaza fase finalista
    Given a proposal in a contest in phase Finalist selection
    When a fellow decide advance the proposal
    And select the judge
    And the judge decide that can be advance
    When the fellow go to advance proposals selection section
    And not advance the proposal
    Then the proposal is not visible in the voting phase


  Scenario: Propuesta que un juez ha evaluado positivamente y fellow avanza
    Given a proposal in a contest in phase Finalist selection
    When a fellow decide advance the proposal
    And select the judge
    And the judge decide that can be advance
    When the fellow go to advance proposals selection section
    And advance the proposal
    Then the proposal is visible in the voting Phase
