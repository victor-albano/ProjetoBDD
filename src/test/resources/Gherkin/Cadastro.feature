@Cadastro
Feature: Cadastro Positivo

Background: 
	Given usuario clica na tela login
	When clica create new account
	And preenche password
	And preenche confirmacao de password
	And preenche nome
	And preenche sobrenome
	And preenche telefone
	And seleciona pais
	And preenche cidade
	And preenche endereco
	And preenche estado
	And preenche cep
	And aceita termos de uso

@Positivo
Scenario: Cadastro Com Sucesso
	And preenche user name
	And preenche email
	And clica no botao register
	Then valida cadastro efetuado

@Negativo	
Scenario: Cadastro Sem Sucesso
	And preenche user name invalido
	And preenche email invalido
	And clica botao register
	Then valida mensagem de cadastro nao efetuado
	