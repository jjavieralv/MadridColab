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
@edituser
Feature: Edición de usuario
  Como usuario quiero poder editar mis datos de usuario en la plataforma para mantener mi perfil actualizado

  @regression
  Scenario: Cambiar nombre
    Given a "user" in the platform main page
    And logged in the platform with his username as "20190108210241542" and password as "Password123"
    And he has accessed to edition profile page
    When he change the name
    Then the name is changed in the profile page

  @regression
  Scenario: Cambiar apellido
    Given a "user" in the platform main page
    And logged in the platform with his username as "20190108210241542" and password as "Password123"
    And he has accessed to edition profile page
    When he change the last name
    Then the last name is changed in the profile page

  @regression
  Scenario: Cambiar pais
    Given a "user" in the platform main page
    And logged in the platform with his username as "20190108210241542" and password as "Password123"
    And he has accessed to edition profile page
    When he change the country
    Then the country is changed in the profile page

  @regression
  Scenario: Cambiar contrasenia
    Given a "user" in the platform main page
    And logged in the platform with his username as "20190108210241542" and password as "Password123"
    And he has accessed to edition profile page
    When he fill the field Contrasenia actual with the actual password as "Password123"
    And he fill the field Nueva contrasenia with "newpassword"
    And he fill the field Reescriba la nueva contrasela with "newpassword"
    And click on Guardar
    And try to change the password to "Password123" again with the old password "Password123"
    Then next message is shown: "Password change failed: Current password is incorrect."
    But the password can be changed to "Password123" if use "newpassword"

  @regression
  Scenario: Cambiar correo electronico
    Given a "user" in the platform main page
    And logged in the platform with his username as "20190108210241542" and password as "Password123"
    And he has accessed to edition profile page
    When he fill the field Nuevo correo electronico with a new email
    And click on Guardar
    Then the email is changed in the profile page

  @regression
  Scenario: Cambiar correo electronico con correo ya usado
    Given a "user" in the platform main page
    And logged in the platform with his username as "20190108210241542" and password as "Password123"
    And he has accessed to edition profile page
    When he fill the field Nuevo correo electronico with an already exist mail such as "s.olmedo13@gmail.com"
    And click on Guardar
    Then next message is shown: "Ya existe un miembro con la misma direccion de correo electronico."

  @regression
  Scenario: Cambiar contrasenia con contrasenia actual invalida
    Given a "user" in the platform main page
    And logged in the platform with his username as "20190108210241542" and password as "Password123"
    And he has accessed to edition profile page
    When he fill the field Contrasenia actual with an incorrect actual password as "Password124"
    And he fill the field Nueva contrasenia with "newpassword"
    And he fill the field Reescriba la nueva contrasenia with "newpassword"
    And click on Guardar
    Then next message is shown: "Password change failed: Current password is incorrect."

  @regression
  Scenario: Cambiar contrasenias no coincidentes
    Given a "user" in the platform main page
    And logged in the platform with his username as "20190108210241542" and password as "Password123"
    And he has accessed to edition profile page
    When he fill the field Contrasenia actual with actual password as "Password123"
    And he fill the field Nueva contrasenia with "newpassword"
    And he fill the field Reescriba la nueva contrasenia with "newpasswords"
    And click on Guardar
    Then next message is shown: "Las contrasenias introducidas no coinciden."

  @regression
  Scenario: Cambiar contrasenias longitud no valida
    Given a "user" in the platform main page
    And logged in the platform with his username as "20190108210241542" and password as "Password123"
    And he has accessed to edition profile page
    When he fill the field Contrasenia actual with actual password as "Password123"
    And he fill the field Nueva contrasenia with "new"
    And he fill the field Reescriba la nueva contrasenia with "new"
    And click on Guardar
    Then next message is shown: "La contrasenia debe tener al menos 8 caracteres"
