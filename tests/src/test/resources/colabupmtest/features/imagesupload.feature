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
@imageUpload
Feature: Herramienta subida imagenes
  Como administrador quiero una herramienta que me permita subir imágenes a la plataforma para utilizarlas en la creación de concursos.

  Scenario: subir imagen tamaño superior al limite de tamaño para imagenes recortadas
    Given the upload image tool
    When upload an image heavier than 6MB with crop button
    Then an error appear
    
   Scenario: subir imagen tamaño superior al limite de tamaño para imagenes sin recortar
    Given the upload image tool
    When upload an image heavier than 6MB with direct button
    Then an error appear

  Scenario: Subir imagen en la seccion imagenes recortadas con un tamaño superior al limite
    Given the upload image tool
    When upload an image larger than 300x300 with crop button
    Then the image in the server has 300px wide x 300px high
  

  Scenario: Subir imagen que no vaya a ser recortada
      Given the upload image tool
    When upload an image larger than 300x300 with direct button
    Then the image has the original size