package br.com.estudos.jpasparkfreemarker.system;


import static org.junit.Assert.assertTrue;

import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Ignore;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;

import br.com.estudos.jpasparkfreemarker.controller.MainController;

public class ContaSystemTest {
	private WebDriver driver;	
	
	@BeforeClass
	public static void inicializaServer(){	
		String[] params = null;
		MainController.main(params);
	}
	
	@AfterClass
	public static void desligaServer(){
		Runtime.getRuntime().exit(1);
	}
	
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
		
		titular.sendKeys("Teste Automatizado pelo junit");
		numero.sendKeys("1993");
		agencia.sendKeys("Av Francisco Morato");
		banco.sendKeys("City bank");
		
		titular.submit();
		
		//INDO PARA PAGINA DE LISTAGEM DAS CONTAS
		driver.get("http://localhost:8080/conta/lista");
		
		assertTrue(driver.getPageSource().contains("Teste Automatizado pelo junit"));
		assertTrue(driver.getPageSource().contains("1993"));
	}
}
