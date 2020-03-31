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

public class StepPesquisaPaginaInicial {
	
	private WebDriver driver;
	private PaginaInicial paginaInicial = new PaginaInicial(driver);
	private PaginaPesquisaMouse paginaPesquisa = new PaginaPesquisaMouse(driver);
	private DriverFactory factory = new DriverFactory();

	@Before
	public void setUp() {
		driver = factory.abrirChrome("http://advantageonlineshopping.com/#/");
		new SmartWaits(driver).esperarPaginaCarregar();
		paginaInicial = PageFactory.initElements(driver, PaginaInicial.class);
		paginaPesquisa = PageFactory.initElements(driver, PaginaPesquisaMouse.class);
	}
	
	@After
	public void tearDown () {
		factory.fecharChrome();
	}
	
	@Given("^usuario clica no botao mouse na tela inicial$")
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
	}
}
