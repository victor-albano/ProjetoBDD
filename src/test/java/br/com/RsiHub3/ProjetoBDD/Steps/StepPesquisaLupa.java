package br.com.RsiHub3.ProjetoBDD.Steps;

import static org.junit.Assert.assertEquals;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;

import br.com.RsiHub3.ProjetoBDD.Pages.PaginaInicial;
import br.com.RsiHub3.ProjetoBDD.Pages.PaginaPesquisaMouse;
import br.com.RsiHub3.ProjetoBDD.Utilitarios.DriverFactory;
import br.com.RsiHub3.ProjetoBDD.Utilitarios.SmartWaits;
import cucumber.api.java.After;
import cucumber.api.java.Before;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

public class StepPesquisaLupa {
	
	private WebDriver driver;
	private PaginaInicial paginaInicial = new PaginaInicial(driver);
	private PaginaPesquisaMouse paginaPesquisa = new PaginaPesquisaMouse(driver);
	private DriverFactory factory = new DriverFactory();

	@Before
	public void setUp () {
		driver = factory.abrirChrome("http://advantageonlineshopping.com/#/");
		new SmartWaits(driver).esperarPaginaCarregar();
		paginaInicial = PageFactory.initElements(driver, PaginaInicial.class);
		paginaPesquisa = PageFactory.initElements(driver, PaginaPesquisaMouse.class);
	}
	
	@After
	public void tearDown () {
		factory.fecharChrome();
	}
	
	@Given("^Usuario clica na lupa$")
	public void usuarioClicaNaLupa() throws Throwable {
		paginaInicial.clicarLupa();
	}

	@When("^usuario digita mouse$")
	public void usuarioDigitaMouse() throws Throwable {
		paginaInicial.pesquisarMouse();
	}

	@When("^clica enter$")
	public void clicaEnter() throws Throwable {
		paginaInicial.clicarEnterNaPesquisa();
	}

	@When("^fecha janela busca$")
	public void fechaJanelaBusca() throws Throwable {
		paginaPesquisa.fecharBusca();
	}

	@When("^seleciona mouse especifico$")
	public void selecionaMouseEspecifico() throws Throwable {
		paginaPesquisa.selecionandoMouseEspecifico();
	}

	@Then("^valida titulo do produto$")
	public void validaTituloDoProduto() throws Throwable {
		paginaPesquisa.EsperaParaPrint();
		assertEquals("HP USB 3 BUTTON OPTICAL MOUSE", paginaPesquisa.validandoMouseEspecifico());
	}
	
	@When("^usuario digita produto invalido$")
	public void usuarioDigitaProdutoInvalido() throws Throwable {
		paginaInicial.pesquisarProdutoInvalido();
	}

	@When("^confirma busca$")
	public void confirmaBusca() throws Throwable {
		paginaInicial.clicarEnterNaPesquisa();
	}

	@When("^fecha busca$")
	public void fechaBusca() throws Throwable {
		paginaPesquisa.fecharBusca();
	}

	@Then("^valida mensagem de produto nao encontrado$")
	public void validaMensagemDeProdutoNaoEncontrado() throws Throwable {
		paginaPesquisa.EsperaParaPrint();
		assertEquals("No results for \"Produto\"", paginaPesquisa.mensagemProdutoNaoEncontrado());
	}
}
