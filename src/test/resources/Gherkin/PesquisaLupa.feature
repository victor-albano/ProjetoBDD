@PesquisaLupa
Feature: Pesquisa Lupa

Scenario: Pesquisa Lupa Com Sucesso
Given Usuario clica na lupa
When usuario digita mouse
And clica enter
And fecha janela busca
And seleciona mouse especifico
Then valida titulo do produto