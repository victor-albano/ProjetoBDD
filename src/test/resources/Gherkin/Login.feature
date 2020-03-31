@Login
Feature: Login

Background: 
	Given estou na tela inicial
	Given clico na aba login

@Positivo
Scenario: Login Com Sucesso
When digita login valido
And digita senha valida
And clica no botao login
Then valida login efetuado com sucesso

@Negativo
Scenario: Login Sem Sucesso
When digita login invalido
And digita senha invalida
And clica botao login
Then valida mensagem de usuario invalido