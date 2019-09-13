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
# language: en
@register
Feature: Registro de usuario
  Como usuario quiero poder crear perfiles de miembro para acceder a la plataforma

@regression
  Scenario: Crear usuario con campo screename vacio
    Given the user registration page in spanish language
    When the field Screen Name is not filled
    And the field email is filled with an valid email
    And the field First Name is filled with a valid First Name
    And the field Last Name is filled with a valid Last Name
    And the field Password is filled with a valid Password such as "Password123"
    And the field Retype Password is filled with the same value that the field Password: "Password123"
    And the field Country is filled with a valid country selection
    And the field Short bio is filled with a short text such as "Example of short Bio"
    And click on the button Create account
    Then a message appears under screen name field with the next text: "El nombre de usuario debe tener entre 3 y 26 caracteres.Por favor, elija un nombre de usuario."

  @regression
  Scenario: Crear usuario con campo screenname con caracteres especiales
    Given the user registration page in spanish language
    When the field Screen Name is filled with a name such as "name.with.special.characters"
    And the field email is filled with an valid email
    And the field First Name is filled with a valid First Name
    And the field Last Name is filled with a valid Last Name
    And the field Password is filled with a valid Password such as "Password123"
    And the field Retype Password is filled with the same value that the field Password: "Password123"
    And the field Country is filled with a valid country selection
    And the field Short bio is filled with a short text such as "Example of short Bio"
    And click on the button Create account
    Then a message appears under screen name with error format message

  @regression
  Scenario: Crear usuario con campo email vacio
    Given the user registration page in spanish language
    When the field Screen Name is filled with a valid screen name
    And the field First Name is filled with a valid First Name
    And the field Last Name is filled with a valid Last Name
    And the field Password is filled with an invalid Password such as "Password123"
    And the field Retype Password is filled with the same value that the field Password: "Password123"
    And the field Country is filled with a valid country selection
    And the field Short bio is filled with a short text such as "Example of short Bio"
    And click on the button Create account
    Then a message appears under email field with: Por favor, introduzca su direccion de correo electronico.

  @regression
  Scenario: Crear usuario con contraseña inferior a 8 caracteres
    Given the user registration page in spanish language
    When the field Screen Name is filled with a valid screen name
    And the field email is filled with an valid email
    And the field First Name is filled with a valid First Name
    And the field Last Name is filled with a valid Last Name
    And the field Password is filled with an invalid Password such as "Pass"
    And the field Retype Password is filled with the same value that the field Password: "Pass"
    And the field Country is filled with a valid country selection
    And the field Short bio is filled with a short text such as "Example of short Bio"
    And click on the button Create account
    Then a message appears under password field with: La contrasenia debe tener al menos 8 caracteres

  @regression
  Scenario: Crear usuario con contraseñas no coincidentes
    Given the user registration page in spanish language
    When the field Screen Name is filled with a valid screen name
    And the field email is filled with an valid email
    And the field First Name is filled with a valid First Name
    And the field Last Name is filled with a valid Last Name
    And the field Password is filled with a valid Password such as "Password123"
    And the field Retype Password is filled with the same value that the field Password: "Password124"
    And the field Country is filled with a valid country selection
    And the field Short bio is filled with a short text such as "Example of short Bio"
    And click on the button Create account
    Then a message appears with the next text: Las contrasenias introducidas no coinciden.

  @regression
  Scenario: Crear usuario con campo country sin seleccionar
    Given the user registration page in spanish language
    When the field Screen Name is filled with a valid screen name
    And the field email is filled with an valid email
    And the field First Name is filled with a valid First Name
    And the field Last Name is filled with a valid Last Name
    And the field Password is filled with a valid Password such as "Password123"
    And the field Retype Password is filled with the same value that the field Password: "Password123"
    And the field Country is not filled with a valid country selection
    And the field Short bio is filled with a short text such as "Example of short Bio"
    And click on the button Create account
    Then a message appears under country field with the next text: "Seleccione un pais de la lista anterior."

  @regression
  Scenario: Crear usuario nombre usuario ya existente
    Given the user registration page in spanish language
    When the field Screen Name is filled with a already used name such as "solmedo"
    And the field email is filled with an valid email
    And the field First Name is filled with a valid First Name
    And the field Last Name is filled with a valid Last Name
    And the field Password is filled with a valid Password such as "Password123"
    And the field Retype Password is filled with the same value that the field Password: "Password123"
    And the field Country is filled with a valid country selection
    And click on the button Create account
    Then a message appears under screen name field with the next text: "Ya existe un miembro con el mismo nombre de usuario."

  @regression
  Scenario: Crear usuario mail ya usado
    Given the user registration page in spanish language
    When the field Screen Name is filled with a valid screen name
    And the field email is filled with an already used email such as "s.olmedo13@gmail.com"
    And the field First Name is filled with a valid First Name
    And the field Last Name is filled with a valid Last Name
    And the field Password is filled with a valid Password such as "Password123"
    And the field Retype Password is filled with the same value that the field Password: "Password123"
    And the field Country is filled with a valid country selection
    And click on the button Create account
    Then a message appears under email field with: "Ya existe un miembro con la misma direccion de correo electronico.".

  @regression
  Scenario: Crear usuario sin biografia
    Given the user registration page in spanish language
    When the field Screen Name is filled with a valid screen name
    And the field email is filled with an valid email
    And the field First Name is filled with a valid First Name
    And the field Last Name is filled with a valid Last Name
    And the field Password is filled with a valid Password such as "Password123"
    And the field Retype Password is filled with the same value that the field Password: "Password123"
    And the field Country is filled with a valid country selection
    And click on the button Create account
    Then a user is created

  @regression
  Scenario: Enlace a terminos de uso
    Given the user registration page in spanish language
    When click on Terminos de uso
    Then the user is redirect to "/page/Terms-of-use"

  @regression
  Scenario: Enlace a filosofia y politica de la comunidad
    Given the user registration page in spanish language
    When click on Filosofia y politica comunitaria
    Then the user is redirect to "/page/Community-philosophy-and-policies"
