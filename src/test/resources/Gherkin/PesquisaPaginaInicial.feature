@PesquisaTelaInicial
Feature: Pesquisa Tela Inicial

Background: 
	Given estou na pagina inicial

@Positivo
Scenario: Pesquisa Tela Inicial Com Sucesso
	When usuario clica no botao mouse na tela inicial
	When seleciona produto especifico
	Then valida titulo do mouse
	
@Negativo
Scenario: Pesquisa Tela Inicial Sem Sucesso
	When procuro produto nao existente na tela
	Then valido que nao ha este produto