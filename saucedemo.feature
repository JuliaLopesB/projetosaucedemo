
@login
Feature: Login
Eu como usuaria quero efetuar testes de login para validar

Background: Acessar site para login
Given que eu esteja no site

  @testePositivo
  Scenario: Login com dados validos
    And preencher com login valido
    When preencher com senha valida
    Then valido login com sucesso
    
    Scenario: Login bloqueado
    But preencher com login bloqueado
    When preencher com senha 
    Then valido sistema com login bloqueado
    
    Scenario: Login com dados Invalidos
    But preencher com login Invalido
    When preencher com senha Invalida
    Then valido que não foi possivel efetuar login
    
    Scenario: Login com dados em branco
    But não preencher campo de login
    When clicar para fazer login
    Then valido dados em branco
 

  
