package br.com.rocketskills.petlov;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.time.Duration;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.ClassOrderer.ClassName;
import org.junit.platform.engine.discovery.ClassNameFilter;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Wait;
import org.openqa.selenium.support.ui.WebDriverWait;

class selenium {

	@Test
	@DisplayName("Deve poder cadastrar um ponto de doação")
	void createPoint() {
		WebDriver driver = new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

		driver.get("https://petlov.vercel.app/signup");

		WebElement title = driver.findElement(By.cssSelector("h1"));

		Wait<WebDriver> wait = new WebDriverWait(driver, Duration.ofSeconds(2));
		wait.until(d -> title.isDisplayed());


		assertEquals("Cadastro de ponto de doação", title.getText(), "Verificando o Slogan");

        WebElement name = driver.findElement(By.cssSelector("input[placeholder='Nome do ponto de doação']"));
        name.sendKeys("Mateus Fonseca");
		
		WebElement email = driver.findElement(By.cssSelector("input[name=email]"));
        email.sendKeys("mateus.gfonseca0@gmail.com");

		WebElement cep = driver.findElement(By.cssSelector("input[name=cep]"));
        cep.sendKeys("30494-390");

		WebElement cepButton = driver.findElement(By.cssSelector("input[value='Buscar CEP']"));
        cepButton.click();

		WebElement number = driver.findElement(By.name("addressNumber"));
        number.sendKeys("222");

		WebElement details = driver.findElement(By.name("addressDetails"));
        details.sendKeys("Flat Horizonte");

		driver.findElement(By.xpath("//span[text()=\"Cachorros\"]/..")).click();

		driver.findElement(By.className("button-register")).click();

		WebElement result = driver.findElement(By.cssSelector("#sucess-page p"));

		Wait<WebDriver> waitResult = new WebDriverWait(driver, Duration.ofSeconds(2));
		waitResult.until(d -> result.isDisplayed());

		String target = "Seu ponto de doaão foi adicionado com sucesso. Juntos, podemos criar um mundo onde todos os animais recebam o amor e cuidado que merecem.";

		assertEquals(target, result.getText(), "Verificando a mensagem de sucesso.");


		driver.close();
	}
}
