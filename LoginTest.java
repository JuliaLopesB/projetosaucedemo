package steps;

import java.io.IOException;

import elementosweb.Elementos;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import massaDeDados.MassadeDados;
import metodos.Metodos;
import runner.Executa;

public class LoginTest {

	Metodos met = new Metodos();
	Elementos el = new Elementos();
	MassadeDados massa = new MassadeDados();

	@Given("que eu esteja no site")
	public void queEuEstejaNoSite() {
	    Executa.abrirNavegador();
	}
	@Given("preencher com login valido")
	public void preencherComLoginValido() throws IOException {
	    met.escrever(el.name, massa.performance_glitch_user);
	    met.evidencias("passo-1-ct01");
	}
	@When("preencher com senha valida")
	public void preencherComSenhaValida() throws IOException {
	    met.escrever(el.senha, massa.senha);
	    met.evidencias("passo-2-ct01");
	}
	@Then("valido login com sucesso")
	public void validoLoginComSucesso() throws IOException {
	    met.clicar(el.btnlogin);
	    
	    met.evidencias("passo-3-ct01");
	    met.currenturl("https://www.saucedemo.com/inventory.html");
	    Executa.fecharNavegador();
	}
	
	@Given("preencher com login bloqueado")
	public void preencherComLoginBloqueado() throws IOException {
	   met.escrever(el.name, massa.locked_out_user);
	   met.evidencias("passo-1-ct02");
	}
	@When("preencher com senha")
	public void preencherComSenha() throws IOException {
		met.escrever(el.senha, massa.senha);
		met.evidencias("passo-2-ct02");
	}
	
	@Then("valido sistema com login bloqueado")
	public void validoSistemaComLoginBloqueado() throws IOException {
		met.clicar(el.btnlogin);
		met.evidencias("passo-3-ct02");
	    met.validaTexto(massa.msgloquado, el.mensagem);
	    Executa.fecharNavegador();
	}
	

	@Given("preencher com login Invalido")
	public void preencherComLoginInvalido() throws IOException {
		met.escrever(el.name, massa.problem_user);
		met.evidencias("passo-1-ct03");
	    
	}
	@When("preencher com senha Invalida")
	public void preencherComSenhaInvalida() throws IOException {
	    met.escrever(el.senha, "000000");
	    met.evidencias("passo-2-ct03");
	}
	@Then("valido que n�o foi possivel efetuar login")
	public void validoQueNOFoiPossivelEfetuarLogin() throws IOException {
	    met.clicar(el.btnlogin);
	    met.evidencias("passo-3-ct03");
	    met.validaTexto(massa.msgInvalido, el.mensagem);
	    Executa.fecharNavegador();
	}

	
	@Given("n�o preencher campo de login")
	public void nOPreencherCampoDeLogin() throws IOException {
	    met.escrever(el.name, "");
	    met.escrever(el.senha, "");
	    met.evidencias("passo-1-ct04");
	}
	
	@When("clicar para fazer login")
	public void clicarParaFazerLogin() throws IOException {
		met.clicar(el.btnlogin);
		met.evidencias("passo-2-ct04");
	}
	
	@Then("valido dados em branco")
	public void validoDadosEmBranco() {
	    met.validaTexto(massa.msgEmranco, el.mensagem);
	    Executa.fecharNavegador();
	}











}
