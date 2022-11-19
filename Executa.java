package runner;

import org.junit.runner.RunWith;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import drivers.Drivers;
import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import io.cucumber.junit.CucumberOptions.SnippetType;
import io.github.bonigarcia.wdm.WebDriverManager;

@RunWith(Cucumber.class)
@CucumberOptions(

		features = "./src/test/resources/", glue = "steps", tags = "@login", dryRun = false, monochrome = true, plugin = {
				"pretty", "html:target/reports-cucumber.html" }, snippets = SnippetType.CAMELCASE

)

public class Executa extends Drivers {

	public static void abrirNavegador() {
		boolean headless = false;
		String ambiente = "https://www.saucedemo.com/";
		WebDriverManager.chromedriver().setup();
		ChromeOptions chromeOptions = new ChromeOptions();
		chromeOptions.addArguments("start-maximazed");
		if (headless) {
			chromeOptions.addArguments("--headless");
		}
		driver = new ChromeDriver(chromeOptions);
		driver.get(ambiente);

	}

	public static void fecharNavegador() {
		driver.quit();
	}

}
