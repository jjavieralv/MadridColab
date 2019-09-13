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
@ProposalTemplate
Feature: Plantillas propuestas
  Como usuario quiero poder editar las plantillas de las propuestas de los concursos para poder adaptarlas a las necesidades del concurso

@regression
  Scenario: creacion plantilla propuesta
  	Given a "admin" in the platform main page
    And logged in the platform with his username as "solmedo" and password as "odemlo13"
 		When go to Contest Manager section
 		And click on proposal template tab
    And click on CREATE new template
    Then a new template is created

@regression
  Scenario: Cambio nombre plantilla propuesta
   Given a "admin" in the platform main page
    And logged in the platform with his username as "solmedo" and password as "odemlo13"
    When go to Contest Manager section
 		And click on proposal template tab
    And select a existing template as "New template"
    And change the name of the template to "Example name Proposal Template"
    And click on save template
    Then the new name is "Example name Proposal Template"

  @regression
  Scenario: Añadir secciones propuesta
  Given a "admin" in the platform main page
    And logged in the platform with his username as "solmedo" and password as "odemlo13"
    When go to Contest Manager section
 		And click on proposal template tab
    And select a existing template as "Example name Proposal Template"
    And click on add section button
    And select Text section in section type of new section
    And fill the field Title of new section with "New title section"
    And fill the field character limit with 300
    And fill the field help text with "New Help Text section"
    And fill the field Default text with "New Default Text"
    And click on save template
    And link the proposal Example name Proposal Template to a contest
    Then the proposal template for the contest include the new sections


  Scenario: Eliminar Plantilla propuesta
   Given a "admin" in the platform main page
    And logged in the platform with his username as "solmedo" and password as "odemlo13"
    When go to Contest Manager section
 		And click on proposal template tab
    And select a existing template as "Example name Proposal Template"
    And click on DELETE template
    Then the template is deleted
