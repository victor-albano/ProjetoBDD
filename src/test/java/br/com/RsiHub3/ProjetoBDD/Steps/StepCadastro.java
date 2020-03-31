package br.com.RsiHub3.ProjetoBDD.Steps;

import static org.junit.Assert.assertEquals;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;

import br.com.RsiHub3.ProjetoBDD.Pages.PaginaDeCadastro;
import br.com.RsiHub3.ProjetoBDD.Pages.PaginaInicial;
import br.com.RsiHub3.ProjetoBDD.Pages.PaginaPesquisaMouse;
import br.com.RsiHub3.ProjetoBDD.Utilitarios.DriverFactory;
import br.com.RsiHub3.ProjetoBDD.Utilitarios.ExtraindoDadosExcel;
import br.com.RsiHub3.ProjetoBDD.Utilitarios.SmartWaits;
import cucumber.api.java.After;
import cucumber.api.java.Before;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

public class StepCadastro {

	private WebDriver driver;
	private PaginaInicial paginaInicial = new PaginaInicial(driver);
	private DriverFactory factory = new DriverFactory();
	private PaginaDeCadastro paginaDeCadastro = new PaginaDeCadastro(driver);
	private ExtraindoDadosExcel excel = new ExtraindoDadosExcel();
	
	@Given("^estou pagina inicial$")
	public void estouPaginaInicial() throws Throwable {
		driver = factory.abrirChrome("http://advantageonlineshopping.com/#/");
		new SmartWaits(driver).esperarPaginaCarregar();
		paginaInicial = PageFactory.initElements(driver, PaginaInicial.class);
		paginaDeCadastro = PageFactory.initElements(driver, PaginaDeCadastro.class);
	}
	
	@When("^usuario clica na tela login$")
	public void usuarioClicaNaTelaLogin() throws Throwable {
		paginaInicial.clicarJanelaDeLogin();
	}

	@When("^clica create new account$")
	public void clicaCreateNewAccount() throws Throwable {
		paginaInicial.clicarCreateNewAccount();
	}

	@When("^preenche user name$")
	public void preencheUserName() throws Throwable {
		paginaDeCadastro.digitarUserName(excel.getUserNameCorreto());
	}

	@When("^preenche password$")
	public void preenchePassword() throws Throwable {
		paginaDeCadastro.digitarPassword(excel.getSenha());
	}

	@When("^preenche confirmacao de password$")
	public void preencheConfirmacaoDePassword() throws Throwable {
		paginaDeCadastro.digitarPassword(excel.getSenha());
	}

	@When("^preenche email$")
	public void preencheEmail() throws Throwable {
		paginaDeCadastro.digitarEmail(excel.getEmailCorreto());
	}

	@When("^preenche nome$")
	public void preencheNome() throws Throwable {
		paginaDeCadastro.digitarPrimeiroNome(excel.getFirstName());
	}

	@When("^preenche sobrenome$")
	public void preencheSobrenome() throws Throwable {
		paginaDeCadastro.digitarSobrenome(excel.getLastName());
	}

	@When("^preenche telefone$")
	public void preencheTelefone() throws Throwable {
		paginaDeCadastro.digitarTelefone(excel.getPhoneNumber());
	}

	@When("^seleciona pais$")
	public void selecionaPais() throws Throwable {
		paginaDeCadastro.selecionarComboBox();
	}

	@When("^preenche cidade$")
	public void preencheCidade() throws Throwable {
		paginaDeCadastro.digitarCidade(excel.getCity());
	}

	@When("^preenche endereco$")
	public void preencheEndereco() throws Throwable {
		paginaDeCadastro.digitarEndereco(excel.getAdress());
	}

	@When("^preenche estado$")
	public void preencheEstado() throws Throwable {
		paginaDeCadastro.digitarEstado(excel.getState());
	}

	@When("^preenche cep$")
	public void preencheCep() throws Throwable {
		paginaDeCadastro.digitarCep(excel.getCep());
	}

	@When("^aceita termos de uso$")
	public void aceitaTermosDeUso() throws Throwable {
		paginaDeCadastro.aceitarTermosDeUso();
	}

	@When("^clica no botao register$")
	public void clicaNoBotaoRegister() throws Throwable {
		//paginaDeCadastro.confirmarCadastro();
	}

	@Then("^valida cadastro efetuado$")
	public void validaCadastroEfetuado() throws Throwable {
		//assertEquals("VictorAlbano17", new PaginaInicial(driver).validacaoLoginEfetuado());
		factory.fecharChrome();
	}
	
	@When("^preenche user name invalido$")
	public void preencheUserNameInvalido() throws Throwable {
		paginaDeCadastro.digitarUserName(excel.getUserNameErrado());
	}

	@When("^preenche email invalido$")
	public void preencheEmailInvalido() throws Throwable {
		paginaDeCadastro.digitarEmail(excel.getEmailErrado());
	}

	@When("^clica botao register$")
	public void clicaBotaoRegister() throws Throwable {
		paginaDeCadastro.confirmarCadastro();
	}

	@Then("^valida mensagem de cadastro nao efetuado$")
	public void validaMensagemDeCadastroNaoEfetuado() throws Throwable {
		assertEquals("User name already exists", new PaginaDeCadastro(driver).mensagemCadastroSemSucesso());
		factory.fecharChrome();
	}
}
