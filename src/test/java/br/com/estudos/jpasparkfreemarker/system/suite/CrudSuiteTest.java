package br.com.estudos.jpasparkfreemarker.system.suite;

import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.runner.RunWith;
import org.junit.runners.Suite;
import org.junit.runners.Suite.SuiteClasses;

import br.com.estudos.jpasparkfreemarker.controller.MainController;
import br.com.estudos.jpasparkfreemarker.system.ContaSystemTest;

@RunWith(Suite.class)
@SuiteClasses({ContaSystemTest.class})
public class CrudSuiteTest {
	
	@BeforeClass
	public static void inicializaServer() {
		String[] params = null; 
		MainController.main(params);
	}
	
	@AfterClass
	public static void desligaServer(){
		Runtime.getRuntime().exit(1);
	}
	
}
