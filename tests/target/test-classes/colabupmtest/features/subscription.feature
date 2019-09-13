#Author: your.email@your.domain.com
#Keywords Summary :
#Feature: List of Scenario:s.
#Scenario:: Business rule through list of steps with arguments.
##Given: Some precondition step
#When: Some key actions
#Then: To observe outcomes or validation
#And,But: To enumerate more #Given,When,Then steps
#Scenario: Outline: List of steps for data-driven as an Examples and <placeholder>
#Examples: Container for s table
#Background: List of steps run before each of the Scenario:s
#""" (Doc Strings)
#| (Data Tables)
#@ (Tags/Labels):To group Scenario:s
#<> (placeholder)
#""
## (Comments)
#Sample Feature Definition Template
@subscription
Feature: Sistema suscripciones
  Como usuario quiero poder suscribirme a los concursos y propuestas para recibir notificaciones sobre cambios en los mismos

  Scenario: Gestion suscripciones eliminar
    Given a "member" in the platform main page
    And logged in the platform with his username as "20190109174806798" and password as "Password123"
    And go to contests section
    And he subscribe to a contest
    When go to manage subscribed activities
    And select all
    And click on delete selected
    Then the user is unsubscribe

  Scenario: Cambio boton suscripcion propuestas
    Given a "member" in the platform main page
    And logged in the platform with his username as "20190109174806798" and password as "Password123"
    And go to contests section
    And go to any proposal details
    When he subscribe to a proposal
    Then the button change to unsubscribe in proposal details

  Scenario: Cambio boton cancelar suscripcion propuestas
    Given a "member" in the platform main page
    And logged in the platform with his username as "20190109174806798" and password as "Password123"
    And go to contests section
    And go to any proposal details
    And he subscribe to a proposal
    When click on unsubscribe in a proposal
    Then the button change to subscribe in proposal details

  Scenario: Cambio boton suscripcion concursos
    Given a "member" in the platform main page
    And logged in the platform with his username as "20190109174806798" and password as "Password123"
    And go to contests section
    When he subscribe to a contest
    Then the button change to unsubscribe in contest details

  Scenario: Cambio boton cancelar suscripcion concursos
    Given a "member" in the platform main page
    And logged in the platform with his username as "20190109174806798" and password as "Password123"
    And go to contests section
    And he subscribe to a contest
    When click on unsubscribe in a contest
    Then the button change to subscribe in contest details

  Scenario: Notificacion suscripcion propuesta
    Given a "member" in the platform main page
    And logged in the platform with his username as "20190109174806798" and password as "Password123"
    And go to contests section
    And go to any proposal details
    And he subscribe to a proposal
    When someone write a comment in the proposal
    Then the subscribe user receive a "new comment in proposal" notification

  Scenario: Notificacion suscripcion concurso
    Given a "member" in the platform main page
    And logged in the platform with his username as "20190109174806798" and password as "Password123"
    And go to contests section
    And he subscribe to a contest
    When someone write a comment in the contest
    Then the subscribe user receive a "new comment in contest" notification
