package br.com.rocketskills.petlov;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class LoginTest {

    WebDriver driver;

    @BeforeEach
    void setUp() {
        driver = new ChromeDriver(); // Certifique-se de que o chromedriver está no PATH
        driver.manage().window().maximize();
    }

    @Test
    @DisplayName("Deve fazer login com sucesso")
    void testLoginSuccess() {
        driver.get("https://exemplo.com/login"); // Substitua pela URL real

        // Preenchendo os campos de login
        WebElement emailInput = driver.findElement(By.name("email"));
        emailInput.sendKeys("usuario@email.com");

        WebElement passwordInput = driver.findElement(By.name("senha"));
        passwordInput.sendKeys("senha123");

        // Clicando no botão de login
        driver.findElement(By.cssSelector("button[type='submit']")).click();

        // Verificando o resultado
        WebElement mensagem = driver.findElement(By.id("mensagem-boas-vindas"));
        assertEquals("Bem-vindo de volta!", mensagem.getText());
    }

    @AfterEach
    void tearDown() {
        if (driver != null) {
            driver.quit(); // Encerra o navegador
        }
    }
}
