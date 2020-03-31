package br.com.RsiHub3.ProjetoBDD.Steps;

import static org.junit.Assert.assertEquals;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;

import br.com.RsiHub3.ProjetoBDD.Pages.PaginaInicial;
import br.com.RsiHub3.ProjetoBDD.Utilitarios.DriverFactory;
import br.com.RsiHub3.ProjetoBDD.Utilitarios.SmartWaits;
import cucumber.api.java.After;
import cucumber.api.java.Before;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

public class StepLogin {
	
	private WebDriver driver;
	private PaginaInicial paginaInicial = new PaginaInicial(driver);
	private DriverFactory factory = new DriverFactory();
	
	@Before
	public void setUp () {
		driver = factory.abrirChrome("http://advantageonlineshopping.com/#/");
		new SmartWaits(driver).esperarPaginaCarregar();
		paginaInicial = PageFactory.initElements(driver, PaginaInicial.class);
	}
	
	@After
	public void tearDown () {
		factory.fecharChrome();
	}

	@Given("^clico na aba login$")
	public void clicoNaAbaLogin() throws Throwable {
		paginaInicial.clicarJanelaDeLogin();
	}

	@When("^digita login valido$")
	public void digitaLoginValido() throws Throwable {
		paginaInicial.digitarLogin("Roger");
	}

	@When("^digita senha valida$")
	public void digitaSenhaValida() throws Throwable {
		paginaInicial.digitarSenha("Abc4");
	}

	@When("^clica no botao login$")
	public void clicaNoBotaoLogin() throws Throwable {
		paginaInicial.clicarSignIn();
	}

	@Then("^valida login efetuado com sucesso$")
	public void validaLoginEfetuadoComSucesso() throws Throwable {
		assertEquals("Roger", new PaginaInicial(driver).validacaoLoginEfetuado());
	}

	@When("^digita login invalido$")
	public void digitaLoginInvalido() throws Throwable {
		paginaInicial.digitarLogin("victor");
	}

	@When("^digita senha invalida$")
	public void digitaSenhaInvalida() throws Throwable {
		paginaInicial.digitarSenha("Senhainvalida");
	}

	@When("^clica botao login$")
	public void clicaBotaoLogin() throws Throwable {
		paginaInicial.clicarSignIn();
	}

	@Then("^valida mensagem de usuario invalido$")
	public void validaMensagemDeUsuarioInvalido() throws Throwable {
		assertEquals("Incorrect user name or password.", paginaInicial.esperarPorMensagemDeValidacao());
	}
}
