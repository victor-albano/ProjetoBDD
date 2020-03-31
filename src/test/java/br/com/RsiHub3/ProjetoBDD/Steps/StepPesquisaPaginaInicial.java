package br.com.RsiHub3.ProjetoBDD.Steps;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;

import br.com.RsiHub3.ProjetoBDD.Pages.PaginaInicial;
import br.com.RsiHub3.ProjetoBDD.Pages.PaginaPesquisaMouse;
import br.com.RsiHub3.ProjetoBDD.Utilitarios.DriverFactory;
import br.com.RsiHub3.ProjetoBDD.Utilitarios.SmartWaits;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

public class StepPesquisaPaginaInicial {
	
	private WebDriver driver;
	private PaginaInicial paginaInicial = new PaginaInicial(driver);
	private PaginaPesquisaMouse paginaPesquisa = new PaginaPesquisaMouse(driver);
	private DriverFactory factory = new DriverFactory();
	private boolean condicao;
	
	@Given("^estou na pagina inicial$")
	public void estouNaPaginaInicial() throws Throwable {
		driver = factory.abrirChrome("http://advantageonlineshopping.com/#/");
		new SmartWaits(driver).esperarPaginaCarregar();
		paginaInicial = PageFactory.initElements(driver, PaginaInicial.class);
		paginaPesquisa = PageFactory.initElements(driver, PaginaPesquisaMouse.class);
	}
	
	@When("^usuario clica no botao mouse na tela inicial$")
	public void usuarioClicaNoBotaoMouseNaTelaInicial() throws Throwable {
		paginaInicial.clicarNoIconeMouseTelaInicial();
	}

	@When("^seleciona produto especifico$")
	public void selecionaProdutoEspecifico() throws Throwable {
		paginaPesquisa.selecionandoMouseEspecifico();
	}

	@Then("^valida titulo do mouse$")
	public void validaTituloDoMouse() throws Throwable {
		paginaPesquisa.EsperaParaPrint();
		assertEquals("HP USB 3 BUTTON OPTICAL MOUSE", paginaPesquisa.validandoMouseEspecifico());
		factory.fecharChrome();
	}
	
	@When("^procuro produto nao existente na tela$")
	public void procuroProdutoNaoExistenteNaTela() throws Throwable {
		condicao = paginaInicial.pesquisaListaTelaInicial(paginaInicial.listaProdutosTelaInicial(), "TV");
	}

	@Then("^valido que nao ha este produto$")
	public void validoQueNaoHaEsteProduto() throws Throwable {
		assertFalse(condicao);
		factory.fecharChrome();
	}
}
