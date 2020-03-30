@Cadastro
Feature: Cadastro Positivo

Scenario: Cadastro Com Sucesso
Given usuario clica na tela login
When clica create new account
And preenche user name
And preenche password
And preenche confirmacao de password
And preenche email
And preenche nome
And preenche sobrenome
And preenche telefone
And seleciona pais
And preenche cidade
And preenche endereco
And preenche estado
And preenche cep
And aceita termos de uso
And clica no botao register
Then valida cadastro efetuado