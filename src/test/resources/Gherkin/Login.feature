@Login
Feature: Login Positivo

Scenario: Login Com Sucesso
Given usuario clica na aba login
When digita login valido
And digita senha valida
And clica no botao login
Then valida login efetuado com sucesso