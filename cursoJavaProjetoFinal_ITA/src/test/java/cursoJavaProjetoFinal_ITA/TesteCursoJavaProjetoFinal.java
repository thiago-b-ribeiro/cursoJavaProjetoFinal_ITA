package cursoJavaProjetoFinal_ITA;

import java.awt.Dimension;
import java.util.HashMap;
import java.util.Map;

import org.junit.After;
import org.junit.Before;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

	public class TesteCursoJavaProjetoFinal {
	  private WebDriver driver;
	  private Map<String, Object> vars;
	  JavascriptExecutor js;
	  
	  @Before
	  public void setUp() {
	    driver = new FirefoxDriver();
	    js = (JavascriptExecutor) driver;
	    vars = new HashMap<String, Object>();
	  }
	  
	  @After
	  public void tearDown() {
	    driver.quit();
	  }
	  
	  @Test
	  public void testeCursoJavaProjetoFinal_01() {
	    driver.get("http://localhost:8080/cursoJavaProjetoFinal_ITA/");
//	    driver.manage().window().setSize(new Dimension(1536, 834));
	    driver.findElement(By.cssSelector("button")).click();
	    driver.findElement(By.name("nome")).click();
	    driver.findElement(By.name("nome")).sendKeys("Thiago Barbosa");
	    driver.findElement(By.name("login")).sendKeys("thiago.ribeiro");
	    driver.findElement(By.name("email")).sendKeys("thiago.ribeiro@email.com");
	    driver.findElement(By.name("senha")).sendKeys("123");
	    driver.findElement(By.cssSelector("input:nth-child(5)")).click();
	  }
	  
	  @Test
	  public void testeCursoJavaProjetoFinal_02() {
	    driver.get("http://localhost:8080/cursoJavaProjetoFinal_ITA/");
//	    driver.manage().window().setSize(new Dimension(1536, 834));
	    driver.findElement(By.cssSelector("button")).click();
	    driver.findElement(By.name("nome")).click();
	    driver.findElement(By.name("nome")).sendKeys("Beatriz Ribeiro");
	    driver.findElement(By.name("login")).sendKeys("beatriz.ribeiro");
	    driver.findElement(By.name("email")).sendKeys("beatriz.ribeiro@email.com");
	    driver.findElement(By.name("senha")).sendKeys("123");
	    driver.findElement(By.cssSelector("input:nth-child(5)")).click();
	  }
	  
	  @Test
	  public void testeCursoJavaProjetoFinal_03() {
	    driver.get("http://localhost:8080/cursoJavaProjetoFinal_ITA/");
//	    driver.manage().window().setSize(new Dimension(1536, 834));
	    driver.findElement(By.cssSelector("button")).click();
	    driver.findElement(By.name("nome")).click();
	    driver.findElement(By.name("nome")).sendKeys("Sebastina Barbosa");
	    driver.findElement(By.name("login")).sendKeys("sebastiana.ribeiro");
	    driver.findElement(By.name("email")).sendKeys("sebastiana.ribeiro@email.com");
	    driver.findElement(By.name("senha")).sendKeys("123");
	    driver.findElement(By.cssSelector("input:nth-child(5)")).click();
	  }
	  
	}
