package br.com.estudos.jpasparkfreemarker.system;


import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;

public class ContaSystemTest {
	private WebDriver driver;	
	
	@Before
	public void inicializa(){	
		driver = new FirefoxDriver();
	}
	
	@Test
	public void deveAdicionarUmaConta(){
		driver.get("http://localhost:8080/conta/cadastra");
		
		WebElement titular = driver.findElement(By.name("titular"));
		WebElement numero = driver.findElement(By.name("numero"));
		WebElement agencia = driver.findElement(By.name("agencia"));
		WebElement banco = driver.findElement(By.name("banco"));
		
		titular.sendKeys("Teste Automatizado pelo amor");
		numero.sendKeys("1990");
		agencia.sendKeys("Av Edigar Faco");
		banco.sendKeys("Bradesco");
		
		titular.submit();
		
		//INDO PARA PAGINA DE LISTAGEM DAS CONTAS
		driver.get("http://localhost:8080/conta/lista");
		
		assertTrue(driver.getPageSource().contains("Teste Automatizado"));
		assertTrue(driver.getPageSource().contains("1991"));
	}
}
