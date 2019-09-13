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

Feature: Wiki personalizada
  Como usuario quiero poder ver información relativa a la página para conocer más sobre la plataforma.

  @About
  Scenario: Secciones principales pagina about
    Given la pagina de informacion sobre la plataforma
    When se comprueban las secciones principales que contiene
    Then son Acerca de CoLab.upm, Origen ,Como funciona, Preguntas frecuentes, Personas, Promotores y Colaboradores, y Contacto

  @About
  Scenario: Subcontenido sección ¿Cómo funciona?
    Given la pagina de informacion sobre la plataforma
    When se comprueban las secciones dentro de la seccion Como funciona
    Then son Retos y Areas de trabajo y Participa

  @About
  Scenario: Contenido seccion Acerca de Madrid CoLab
    Given la pagina de informacion sobre la plataforma
    When se comprueba el contenido de la seccion Acerca de Madrid CoLab
    Then coincide con el del fichero "Acerca_de_Madrid_CoLab.html"

  @About
  Scenario: Contenido seccion Origen
    Given la pagina de informacion sobre la plataforma
    When se comprueba el contenido de la seccion Origen
    Then coincide con el del fichero "Origen.html"

  @About
  Scenario: Contenido seccion Concursos y Area de trabajo
    Given la pagina de informacion sobre la plataforma
    When se comprueba el contenido de la seccion Concursos y Area de trabajo
    Then coincide con el del fichero "Concursos_Y_Area_Trabajo.html"

  @About
  Scenario: Contenido seccion Participa
    Given la pagina de informacion sobre la plataforma
    When se comprueba el contenido de la seccion Participa
    Then coincide con el del fichero "Participa.html"

  @About
  Scenario: Contenido seccion Preguntas frecuentes
    Given la pagina de informacion sobre la plataforma
    When se comprueba el contenido de la seccion Preguntas frecuentes
    Then coincide con el del fichero "Preguntas_frecuentes.html"

  @About
  Scenario: Contenido seccion Personas
    Given la pagina de informacion sobre la plataforma
    When se comprueba el contenido de la seccion Personas
    Then coincide con el del fichero "Personas.html"

 # @About
  #Scenario: Contenido seccion Equipo
   # Given la pagina de informacion sobre la plataforma
    #When se comprueba el contenido de la seccion Equipo
    #Then coincide con el del fichero "Equipo.html"

  @About
  Scenario: Contenido seccion Colaboradores
    Given la pagina de informacion sobre la plataforma
    When se comprueba el contenido de la seccion Colaboradores
    Then coincide con el del fichero "Colaboradores.html"

  @About
  Scenario: Contenido seccion Contacto
    Given la pagina de informacion sobre la plataforma
    When se comprueba el contenido de la seccion Contacto
    Then coincide con el del fichero "Contacto.html"

  @About
  Scenario: Contenido terminos de uso
    Given la pagina de terminos de uso
    When se comprueba el contenido
    Then coincide con el del fichero "terminos_de_uso.html"

  @About
  Scenario: Contenido normas de los concursos
    Given la pagina de normas de los concursos
    When se comprueba el contenido
    Then coincide con el del fichero "normas_concursos.html"

  @About
  Scenario: Contenido politica de privacidad
    Given la pagina politicas de privacidad
    When se comprueba el contenido
    Then coincide con el del fichero "politica_privacidad.html"

  @About
  Scenario: Contenido Filosofia y politicas comunes
    Given la pagina de filosofia y politicas comunes
    When se comprueba el contenido
    Then coincide con el del fichero "filosofia.html"
