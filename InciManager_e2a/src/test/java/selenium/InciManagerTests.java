package selenium;

import java.util.List;
import java.util.concurrent.TimeUnit;

import org.junit.*;
import org.junit.runner.RunWith;

import selenium.pageobjects.PO_AddIncidencia;
import selenium.pageobjects.PO_LoginView;
import selenium.pageobjects.PO_View;
import selenium.util.SeleniumUtils;

import org.junit.runners.MethodSorters;
import org.openqa.selenium.*;
import org.openqa.selenium.htmlunit.HtmlUnitDriver;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.context.SpringBootTest.WebEnvironment;

import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import manager.InciManagerApplication;

@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest(classes = InciManagerApplication.class, webEnvironment = WebEnvironment.DEFINED_PORT)
// @WebAppConfiguration
@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class InciManagerTests {

	private static WebDriver driver;
	static String URL;

	@Before
	public void setUp() {
		// Antes de cada prueba se navega al URL home de la aplicaciónn
		driver = new HtmlUnitDriver();
		URL = "http://localhost:8085";
		driver.get(URL);
		driver.manage().timeouts().implicitlyWait(4, TimeUnit.SECONDS);
	}

	// Después de cada prueba se borran las cookies del navegador
	@After
	public void tearDown() {
		driver.manage().deleteAllCookies();
		driver.get(URL + "/logout");
	}

	@AfterClass
	static public void end() {
		driver.quit();
	}

	@Test
	public void test1IntentoDeRellenarFormularioSinIniciarSesion() {
		driver.get(URL + "/formSendIncidence");

		PO_View.checkElement(driver, "text", "Sistema de participacion ciudadana");

	}

	@Test
	public void test2IntentoDeListarIncidencias() {
		driver.get(URL + "/list");
		// Comprobamos que nos vamos a la pantalla de login

		PO_View.checkElement(driver, "text", "Sistema de participacion ciudadana");

	}

	@Test
	public void test3InicioSesionValido() {

		// Rellenamos el formulario
		PO_LoginView.fillForm(driver, "Juan", "123456", "Entity");
		// Comprobamos que entramos en sesión
		PO_View.checkElement(driver, "text", "Bienvenidos al sistema de incidencias");

	}

	@Test
	public void test4FormularioIncorrectoCamposVacios() {

		// Rellenamos el formulario
		PO_LoginView.fillForm(driver, "Juan", "123456", "Entity");
		// Comprobamos que entramos en sesión
		SeleniumUtils.esperaCargaPagina(driver, "text", "Bienvenidos al sistema de incidencias", PO_View.getTimeout());

		List<WebElement> elementos = SeleniumUtils.esperaCargaPagina(driver, "free",
				"//li[contains(@id,'formSendIncidence')]/a", PO_View.getTimeout());
		elementos.get(0).click();

		PO_AddIncidencia.fillForm(driver, "", "", "", "", "", "");
		// Al dejar campos vacíos seguimos en el envío de la incidencia mirando como
		// aparecen los inputs
		SeleniumUtils.esperaCargaPagina(driver, "class", "col-sm-10", PO_View.getTimeout());

	}

	@Test
	public void test5TituloYDescripcionPequeña() {

		// Rellenamos el formulario
		PO_LoginView.fillForm(driver, "Juan", "123456", "Entity");
		// Comprobamos que entramos en sesión
		SeleniumUtils.esperaCargaPagina(driver, "text", "Bienvenidos al sistema de incidencias", PO_View.getTimeout());

		List<WebElement> elementos = SeleniumUtils.esperaCargaPagina(driver, "free",
				"//li[contains(@id,'formSendIncidence')]/a", PO_View.getTimeout());
		elementos.get(0).click();

		PO_AddIncidencia.fillForm(driver, "hola", "hola", "fuego,incendio", "fuego:extremo", "45.356", "-32.145");
		// Al dejar campos vacíos seguimos en el envío de la incidencia mirando como
		// aparecen los inputs
		SeleniumUtils.esperaCargaPagina(driver, "class", "text-danger", PO_View.getTimeout());

	}

	@Test
	public void test6ValorProhibido() {

		// Rellenamos el formulario
		PO_LoginView.fillForm(driver, "Juan", "123456", "Entity");
		// Comprobamos que entramos en sesión
		SeleniumUtils.esperaCargaPagina(driver, "text", "Bienvenidos al sistema de incidencias", PO_View.getTimeout());

		List<WebElement> elementos = SeleniumUtils.esperaCargaPagina(driver, "free",
				"//li[contains(@id,'formSendIncidence')]/a", PO_View.getTimeout());
		elementos.get(0).click();

		PO_AddIncidencia.fillForm(driver, "@@@@@", "@@@@@", "@@@@@", "@@@@@:$$$$$", "45.356", "-32.145");
		// Al dejar campos vacíos seguimos en el envío de la incidencia mirando como
		// aparecen los inputs
		SeleniumUtils.esperaCargaPagina(driver, "class", "text-danger", PO_View.getTimeout());

	}

	@Test
	public void test7CampoIncorrecto() {

		// Rellenamos el formulario
		PO_LoginView.fillForm(driver, "Juan", "123456", "Entity");
		// Comprobamos que entramos en sesión
		SeleniumUtils.esperaCargaPagina(driver, "text", "Bienvenidos al sistema de incidencias", PO_View.getTimeout());

		List<WebElement> elementos = SeleniumUtils.esperaCargaPagina(driver, "free",
				"//li[contains(@id,'formSendIncidence')]/a", PO_View.getTimeout());
		elementos.get(0).click();

		PO_AddIncidencia.fillForm(driver, "Titulo incidencia", "Descripcion incorrecta", "Fuego", "NoHayDosPuntos",
				"45.356", "-32.145");
		// Al dejar campos vacíos seguimos en el envío de la incidencia mirando como
		// aparecen los inputs
		SeleniumUtils.esperaCargaPagina(driver, "class", "text-danger", PO_View.getTimeout());

	}

	@Test
	public void test8IncidenciaCorrecta() {

		// Rellenamos el formulario
		PO_LoginView.fillForm(driver, "Juan", "123456", "Entity");
		// Comprobamos que entramos en sesión
		SeleniumUtils.esperaCargaPagina(driver, "text", "Bienvenidos al sistema de incidencias", PO_View.getTimeout());

		List<WebElement> elementos = SeleniumUtils.esperaCargaPagina(driver, "free",
				"//li[contains(@id,'formSendIncidence')]/a", PO_View.getTimeout());
		elementos.get(0).click();

		PO_AddIncidencia.fillForm(driver, "Titulo-incidencia", "Descripcion-incidencia", "Fuego", "Clave:Valor",
				"45.356", "-32.145");
		// Al dejar campos vacíos seguimos en el envío de la incidencia mirando como
		// aparecen los inputs
		SeleniumUtils.esperaCargaPagina(driver, "text", "La Incidencia ha sido enviada correctamente",
				PO_View.getTimeout());

	}

	@Test
	public void test9ListaIncidencia() {

		// Rellenamos el formulario
		PO_LoginView.fillForm(driver, "Juan", "123456", "Entity");
		// Comprobamos que entramos en sesión
		SeleniumUtils.esperaCargaPagina(driver, "text", "Bienvenidos al sistema de incidencias", PO_View.getTimeout());

		List<WebElement> elementos = SeleniumUtils.esperaCargaPagina(driver, "free",
				"//li[contains(@id,'formSendIncidence')]/a", PO_View.getTimeout());
		elementos.get(0).click();

		PO_AddIncidencia.fillForm(driver, "Titulo-incidencia2", "Descripcion-incidencia2", "Fuego", "Clave:Valor",
				"45.356", "-32.145");
		// Al dejar campos vacíos seguimos en el envío de la incidencia mirando como
		// aparecen los inputs
		SeleniumUtils.esperaCargaPagina(driver, "text", "La Incidencia ha sido enviada correctamente",
				PO_View.getTimeout());

		elementos = SeleniumUtils.esperaCargaPagina(driver, "free", "//li[contains(@id,'list')]/a",
				PO_View.getTimeout());
		elementos.get(0).click();

	}

}
