@PesquisaLupa
Feature: Pesquisa Lupa

Background: 
	Given Usuario clica na lupa

@Positivo
Scenario: Pesquisa Lupa Com Sucesso
When usuario digita mouse
And clica enter
And fecha janela busca
And seleciona mouse especifico
Then valida titulo do produto

@Negativo
Scenario: Pesquisa Lupa Sem Sucesso
When usuario digita produto invalido
And confirma busca
And fecha busca
Then valida mensagem de produto nao encontrado