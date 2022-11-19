package metodos;

import static org.junit.Assert.assertEquals;

import java.io.File;
import java.io.IOException;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;

import drivers.Drivers;

public class Metodos extends Drivers {

	public void clicar(By elemento) {

		try {
			driver.findElement(elemento).click();

		} catch (Exception e) {
			System.out.println("Erro ao tentar clicar no elemento" + elemento);
		}

	}

	public void escrever(By elemento, String texto) {

		try {
			driver.findElement(elemento).sendKeys(texto);

		} catch (Exception e) {
			System.out.println("Erro ao tentar clicar no digitar" + elemento);
		}
	}
		
	public void currenturl(String urlDesejada) {
		assertEquals(urlDesejada, driver.getCurrentUrl());
		
	}
	
	public void validaTexto(String textoEsperado,By elemento) {
		String texto = driver.findElement(elemento).getText();
		assertEquals(texto, textoEsperado);	
			
	}
	
	public void evidencias(String nome) throws IOException {

		TakesScreenshot srcShot = ((TakesScreenshot) driver);
		File srcFile = srcShot.getScreenshotAs(OutputType.FILE);
		File destFile = new File("./src/evidencias/" + nome + ".png");
		FileUtils.copyFile(srcFile, destFile);
	}
	
	
	
}
