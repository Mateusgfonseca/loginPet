package br.com.rocketskills.petlov;

import io.github.bonigarcia.wdm.WebDriverManager;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import org.openqa.selenium.support.ui.WebDriverWait;
import org.openqa.selenium.support.ui.ExpectedConditions;

import java.time.Duration;

import static org.junit.jupiter.api.Assertions.assertTrue;

public class Teste {

    private WebDriver driver;

    @BeforeEach
    public void setUp() {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
    }

    @AfterEach
    public void tearDown() {
        if (driver != null) {
            driver.quit();
        }
    }

    @Test
    @DisplayName("Testa envio de formulário de contato")
    public void testFormularioContato() {
        driver.get("file:///Users/mateusfonseca/Documents/petlov/formulario.html");

        System.out.println("HTML da página carregada:");
        System.out.println(driver.getPageSource());

        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));

        WebElement nome = wait.until(ExpectedConditions.visibilityOfElementLocated(By.name("nome")));
        WebElement email = driver.findElement(By.name("email"));
        WebElement mensagem = driver.findElement(By.name("mensagem"));
        WebElement botaoEnviar = driver.findElement(By.tagName("button"));

        nome.sendKeys("João");
        email.sendKeys("joao@email.com");
        mensagem.sendKeys("Olá, estou entrando em contato!");

        botaoEnviar.click();

        Alert alerta = driver.switchTo().alert();
        assertTrue(alerta.getText().contains("Mensagem enviada com sucesso!"));
        alerta.accept();
    }

} // <--- chave fechando a classe
