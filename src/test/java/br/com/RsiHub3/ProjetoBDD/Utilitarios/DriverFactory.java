package br.com.RsiHub3.ProjetoBDD.Utilitarios;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class DriverFactory {

	private WebDriver driver;
	
	public WebDriver abrirChrome (String link) {
		System.setProperty("webdriver.chrome.driver", "src/test/resources/ChromeDriver/chromedriver.exe");
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(120, TimeUnit.SECONDS);
		driver.get(link);
		return driver;
	}
	
	public void fecharChrome () {
			driver.quit();
	}
}
