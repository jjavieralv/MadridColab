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
@contests
Feature: Concursos web colaborativa
  Como administrador quiero poder gestionar los concursos de la web colaborativa

  #When the Given is common, we can write it in a Background
  @regression

  Scenario: Creacion concurso
    Given a "admin" in the platform main page
    And logged in the platform with his username as "solmedo" and password as "odemlo13"
    When go to Contest Manager section
    And click on Create New Contest
    Then a new contest is created

  @regression
  Scenario: Mostrar pagina concurso
    Given a "admin" in the platform main page
    And logged in the platform with his username as "solmedo" and password as "odemlo13"
    When go to Contest Manager section
    And click on view contest button
    Then the contest is shown


  Scenario: Edicion titulo concurso
    Given a "admin" in the platform main page
    And logged in the platform with his username as "solmedo" and password as "odemlo13"
    When go to Contest Manager section
    And click on the title of the contest which will be change
    And set the new title
    And save description
    Then the title is changed


  Scenario: Edicion pregunta concurso
    Given a "admin" in the platform main page
    And logged in the platform with his username as "solmedo" and password as "odemlo13"
    When go to Contest Manager section
    And click on the title of the contest which will be change
    And set the new question
    And save description
    Then the contest question is changed


  Scenario: Edicion Descripcion concurso
    Given a "admin" in the platform main page
    And logged in the platform with his username as "solmedo" and password as "odemlo13"
    When go to Contest Manager section
    And click on the title of the contest which will be change
    And set the new description
    And save description
    Then the contest description is changed

  @regression
  Scenario: Creacion resource page en concurso
    Given a "admin" in the platform main page
    And logged in the platform with his username as "solmedo" and password as "odemlo13"
    When go to Contest Manager section
    And click on the title of the contest which will be change
    And go to Resources Page
    And click on create Resources Page
    And fill the fields
    And click on save resources
    Then the contest has a link to resources page
    And the resources is shown

  @regression
  Scenario: Seleccionar ontology
    Given a "admin" in the platform main page
    And logged in the platform with his username as "solmedo" and password as "odemlo13"
    When go to Contest Manager section
    And click on the title of the contest which will be change
    And go to Ontologies
    And change ontologies
    And click on save ontologies
    Then the contest show selected ontologies
  @regression
  Scenario: Publicar concurso
    Given a "admin" in the platform main page
    And logged in the platform with his username as "solmedo" and password as "odemlo13"
    When go to Contest Manager section
    And select a contest
    And select Public not private option
    And click on submit
    Then the contest is shown in contest section whith grid view
   # And in outline view
    And in list view

  @regression
  Scenario: Seleccionar concursos que se muestran en la pagina principal
    Given a "admin" in the platform main page
    And logged in the platform with his username as "solmedo" and password as "odemlo13"
    When click on edit contest preferences
    And select the contest which will be shown
    And click on save button
    And go to main page
    Then the selected contests is being shown in the main page

  @regression
  Scenario: Seleccionar los miembros del equipo que componen un concurso
    Given a "admin" in the platform main page
    And logged in the platform with his username as "solmedo" and password as "odemlo13"
    When go to Contest Manager section
    And click on the title of the contest which will be change
    And go to team
    And add members team
    And click on save team
    Then the team members are shown in the contest page

  @regression
  Scenario: Eliminar los miembros del equipo que componen un concurso
    Given a "admin" in the platform main page
    And logged in the platform with his username as "solmedo" and password as "odemlo13"
    When go to Contest Manager section
    And click on the title of the contest which will be change
    And go to team
    And delete members team
    And click on save team
    Then the team members are not shown in the contest page


  Scenario: Eliminar concurso
    Given a "admin" in the platform main page
    And logged in the platform with his username as "solmedo" and password as "odemlo13"
    When go to Contest Manager section
    And select a contest
    And select delete contests including phases option
    And click on submit
    And confirm deletion
    Then the contest is deleted

  @regression
  Scenario: Edicion titulo concurso con tildes
    Given a "admin" in the platform main page
    And logged in the platform with his username as "solmedo" and password as "odemlo13"
    When go to Contest Manager section
    And click on the title of the contest which will be change
    And set the new title with quotes
    And save description
    Then the title is changed

  @regression
  Scenario: Superar Limite characters length titulo
    Given a "admin" in the platform main page
    And logged in the platform with his username as "solmedo" and password as "odemlo13"
    When go to Contest Manager section
    And click on the title of the contest which will be change
    And set a title with 76 characters length
    And save description
    Then appear the next error "The contest title must be at least 3 characters and not more than 75 characters."

  @regression
  Scenario: No superar limite characters length titulo
    Given a "admin" in the platform main page
    And logged in the platform with his username as "solmedo" and password as "odemlo13"
    When go to Contest Manager section
    And click on the title of the contest which will be change
    And set a title with 75 characters length
    And save description
    Then the title is changed

  @regression
  Scenario: Superar limite characters length pregunta
    Given a "admin" in the platform main page
    And logged in the platform with his username as "solmedo" and password as "odemlo13"
    When go to Contest Manager section
    And click on the title of the contest which will be change
    And set a question with 1025 characters length
    And save description
    Then appear the next error "The contest question must be at least 3 characters and not more than 1024 characters."

  @regression
  Scenario: Limite characters length pregunta concurso
    Given a "admin" in the platform main page
    And logged in the platform with his username as "solmedo" and password as "odemlo13"
    When go to Contest Manager section
    And click on the title of the contest which will be change
    And set a question with 1024 characters length
    And save description
    Then the contest question is changed

  @regression
  Scenario: Superar limite characters length descripcion concurso
    Given a "admin" in the platform main page
    And logged in the platform with his username as "solmedo" and password as "odemlo13"
    When go to Contest Manager section
    And click on the title of the contest which will be change
    And set a description with 10001 characters length
    And save description
    Then appear the next error "The contest description must have not more than 10000 characters (including html tags)."

  @regression
  Scenario: No Superar limite characters length descripcion concurso
    Given a "admin" in the platform main page
    And logged in the platform with his username as "solmedo" and password as "odemlo13"
    When go to Contest Manager section
    And click on the title of the contest which will be change
    And set a description with 9900 characters length
    And save description
    Then the contest description is changed
