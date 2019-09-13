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
@comments
Feature: Publicacion comentarios miembros
  Como usuario quiero poder crear comentarios en los concurso y las propuestas para colaborar en la plataforma
@regression
  Scenario: Comentar concurso sin iniciar sesion - mensaje alerta
    Given a "user" in the platform main page
    And go to contests section
    And go to the contest details of "Concurso 1"
    When click on Discuss Button
    Then the comment section opens
    And the advise message appear with the text "Debes ingresar a tu cuenta para publicar un comentario."

  Scenario: Comentar propuesta sin iniciar sesion - mensaje alerta
    Given a "user" in the platform main page
    And go to contests section
    And go to any proposal details
    When click on comments tab
    Then the comment section opens
    And the advise message appear with the text "Debes ingresar a tu cuenta para publicar un comentario."
  @regression
  Scenario: Comentar propuesta sin iniciar sesion - solicitar inicio de sesion
    Given a "user" in the platform main page
    And go to contests section
    And go to any proposal details
    When click on comments tab
    And Write a comment as "Esto es un comentario"
    And click on add comment button
    Then a signin form opens

  Scenario: Comentar concurso sin iniciar sesion - solicitar inicio de sesion
    Given a "user" in the platform main page
    And go to contests section
    And go to the contest details of "Concurso 1"
    When click on Discuss Button
    And Write a comment as "Esto es un comentario"
    And click on add comment button
    Then a signin form opens
  @regression
  @DeleteCommentAfterExecution
  Scenario: Comentar concurso Nombre autor comentario
    Given a "member" in the platform main page
    And logged in the platform with his username as "20190108215141311" and password as "Password123"
    And go to contests section
    And go to the contest details of "Concurso 1"
    When click on Discuss Button
    And Write a comment as "Esto es un comentario"
    And click on add comment button
    Then the autor name is "20190108215141311"

  @DeleteCommentAfterExecution
  Scenario: Comentar propuesta Nombre autor comentario
    Given a "member" in the platform main page
    And logged in the platform with his username as "20190108215141311" and password as "Password123"
    And go to contests section
    And go to any proposal details
    When click on comments tab
    And Write a comment as "Esto es un comentario"
    And click on add comment button
    Then the autor name is "20190108215141311"
  @regression
  @DeleteCommentAfterExecution
  Scenario: Contador comentarios concurso
    Given a "member" in the platform main page
    And logged in the platform with his username as "20190108215141311" and password as "Password123"
    And go to contests section
    And go to the contest details of "Concurso 1"
    When click on Discuss Button
    And Write a comment as "Esto es un comentario"
    And click on add comment button
    Then comment counter increases in 1


  @DeleteCommentAfterExecution
  Scenario: Comentario concurso publico
   Given a "member" in the platform main page
    And logged in the platform with his username as "20190108215141311" and password as "Password123"
    And go to contests section
    And go to the contest details of "Concurso 1"
    When click on Discuss Button
    And Write a comment as "Esto es un comentario"
    And click on add comment button
    Then the comment is public

  @regression
  @DeleteCommentAfterExecution
  Scenario: Comentario propuesta publico
   Given a "member" in the platform main page
    And logged in the platform with his username as "20190108215141311" and password as "Password123"
    And go to contests section
    And go to any proposal details
    When click on comments tab
    And Write a comment as "Esto es un comentario"
    And click on add comment button
    Then the comment is public

  @regression
  @DeleteCommentAfterExecution
  Scenario: Editar comentario
  Given a "member" in the platform main page
    And logged in the platform with his username as "20190108215141311" and password as "Password123"
    And go to contests section
    And go to the contest details of "Concurso 1"
    When click on Discuss Button
    And Write a comment as "Esto es un comentario que se va a editar"
    And click on add comment button
    And click on edit link
    And Write a comment as "Esto es un comentario editado"
    And click on save
    Then the comment has changed

  @regression
  Scenario: Borrar comentario propuesta
   Given a "member" in the platform main page
    And logged in the platform with his username as "20190108215141311" and password as "Password123"
    And go to contests section
    And go to any proposal details
    When click on comments tab
    And Write a comment as "Esto es un comentario para borrar"
    And click on add comment button
    And click on delete comment link
    Then the new comment is deleted
    And the comment counter decrease in 1

  @regression

  Scenario: Crear nuevo debate General
    Given a "member" in the platform main page
    And logged in the platform with his username as "20190108215141311" and password as "Password123"
    And go to Community Section
    And click on discussion tab
    When create new discussion
    And select "General Discussion" as category
    And write a tittle
    And write a comment
    And click on add
    Then a discussion is created
    And is shown in "General Discussion" Section

  @regression

  Scenario: Crear nuevo debate Bugs y mejoras
   Given a "member" in the platform main page
    And logged in the platform with his username as "20190108215141311" and password as "Password123"
    And go to Community Section
    And click on discussion tab
    When create new discussion
    And select "Report bugs and request features" as category
    And write a tittle
    And write a comment
    And click on add
    Then a discussion is created
    And is shown in "Report bugs and request features" Section
