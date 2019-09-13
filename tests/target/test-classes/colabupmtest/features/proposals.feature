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
@Proposals
Feature: Gestion propuestas concurso
  Como usuario quiero poder crear y gestionar mis propuestas para participar en los concursos
  @regression
  Scenario: Concurso donde no se ha abierto el periodo de propuestas y usuario verificado en la plataforma
   	Given a "member" in the platform main page
    And logged in the platform with his username as "20190108215141311" and password as "Password123"
    And go to contests section
    When enter in a contest where the proposal creation is not still open as "Concurso 2"
    Then the button to create proposal is not shown

  Scenario: Concurso donde se ha abierto el periodo de propuestas y usuario verificado en la plataforma
    	Given a "member" in the platform main page
    And logged in the platform with his username as "20190108215141311" and password as "Password123"
    And go to contests section
    When enter in a contest where the proposal creation is open as "Concurso 1"
    Then the button to create proposal is shown

  Scenario: Concurso donde se ha abierto el periodo de propuestas y usuario no verificado en la plataforma
   	Given a "member" in the platform main page
   	And go to contests section
    When enter in a contest where the proposal creation is open as "Concurso 1"
    And click on the button to create a new proposal
    Then a form to do login appears
  @regression
  Scenario: Creación de concurso con nombre de equipo
     	Given a "member" in the platform main page
    And logged in the platform with his username as "20190108215141311" and password as "Password123"
    And go to contests section
    When enter in a contest where the proposal creation is open as "Concurso 1"
    And click on the button to create a new proposal
    And fill mandatory fields
    And fill the field Team Name
    And fill optional sections
    And click on save and PUBLISH changes button
    And accept the Contest Rules
    Then the proposal is created with the provided information
    And the name that appears in the proposal is that of the team

  Scenario: Creación de concurso sin nombre de equipo
  	Given a "member" in the platform main page
    And logged in the platform with his username as "20190108215141311" and password as "Password123"
    And go to contests section
    When enter in a contest where the proposal creation is open as "Concurso 1"
    And click on the button to create a new proposal
    And fill mandatory fields
    And fill optional sections
    And click on save and PUBLISH changes button
      And accept the Contest Rules
    Then the proposal is created with the provided information
    And the name that appears in the proposal is "20190108215141311"

  Scenario: Solicitar incorporación equipo
    Given a "member" in the platform main page
    And logged in the platform with his username as "20190109175748648" and password as "Password123"
    And go to contests section
    And enter in a contest where the proposal creation is open as "Concurso 1"
    And enter in a proposal details of a proposal created by member "20190108215141311"
    And go to contributors section
    When click on Request Membership
    And click on sent
    Then the button Request Membership disappears
#@Propuestas
 # Scenario: Aceptar solicitud equipo
  #  Given the user "20190108215141311" who has requests membership in his administration area
   # When approve the request
    #Then Requesting user appears as member in the proposal

  #Scenario: Denegar solicitud equipo
   # Given the user "20190108215141311" who has requests membership in his administration area
    #When deny the request
    #Then Requesting user doesn't appear as member in the proposal
  @regression
  Scenario: Apoyar propuesta
     Given a "member" in the platform main page
    And logged in the platform with his username as "20190109175748648" and password as "Password123"
    And go to contests section
    When enter in a contest where the proposal creation is open as "Concurso 1"
    And enter in a proposal details of a proposal created by member "20190108215141311"
    And go to contributors section
    And click on Support proposal button
    Then the user "20190109175748648" is added to support proposal
  @regression
  Scenario: Retirar apoyo propuesta
     Given a "member" in the platform main page
    And logged in the platform with his username as "20190109175748648" and password as "Password123"
    And go to contests section
    When enter in a contest where the proposal creation is open as "Concurso 1"
    And enter in a proposal details of a proposal created by member "20190108215141311"
    And go to contributors section
    And click on Retract support
    Then the user "20190109175748648" is removed to support proposal
  @regression
  Scenario: Eliminar propuesta
     Given a "member" in the platform main page
    And logged in the platform with his username as "20190108215141311" and password as "Password123"
    And go to contests section
    When enter in a contest where the proposal creation is open as "Concurso 1"
    And enter in a proposal details of a proposal created by member "20190108215141311"
    And go to admin section
    And click on delete proposal
    Then the proposal is deleted
