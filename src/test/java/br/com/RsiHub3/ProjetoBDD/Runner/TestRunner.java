package br.com.RsiHub3.ProjetoBDD.Runner;

import org.junit.runner.RunWith;

import cucumber.api.CucumberOptions;
import cucumber.api.SnippetType;
import cucumber.api.junit.Cucumber;

	
	@RunWith(Cucumber.class)
	@CucumberOptions(
         features = "src/test/resources/Gherkin", 
         glue = {"br.com.RsiHub3.ProjetoBDD.Steps"},
         snippets = SnippetType.CAMELCASE ,
         tags = "@PesquisaTelaInicial"
         )
	
	public class TestRunner {
		
	}
