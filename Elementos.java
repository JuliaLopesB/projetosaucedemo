package elementosweb;

import org.openqa.selenium.By;

public class Elementos {

	
	public By name = By.id("user-name");
	public By senha = By.id("password");
	public By btnlogin = By.id("login-button");
	public By mensagem = By.xpath("//h3[@data-test='error']");
	
}
