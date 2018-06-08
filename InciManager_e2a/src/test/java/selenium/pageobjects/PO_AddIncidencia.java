package selenium.pageobjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class PO_AddIncidencia extends PO_NavView {

	public static void fillForm(WebDriver driver, String namep, String descripcionp, String etiquetap, String campop,
			String latitudp, String longitudp) {
		WebElement name = driver.findElement(By.name("nombre"));
		name.click();
		name.clear();
		name.sendKeys(namep);
		WebElement descripcion = driver.findElement(By.name("descripcion"));
		descripcion.click();
		descripcion.clear();
		descripcion.sendKeys(descripcionp);
		WebElement etiqueta = driver.findElement(By.name("etiqueta"));
		etiqueta.click();
		etiqueta.clear();
		etiqueta.sendKeys(etiquetap);
		WebElement campo = driver.findElement(By.name("campo"));
		campo.click();
		campo.clear();
		campo.sendKeys(campop);
		WebElement latitud = driver.findElement(By.name("latitud"));
		latitud.click();
		latitud.clear();
		latitud.sendKeys(latitudp);
		WebElement longitud = driver.findElement(By.name("longitud"));
		longitud.click();
		longitud.clear();
		longitud.sendKeys(longitudp);
		// Pulsar el boton de Enviar
		By boton = By.className("btn");
		driver.findElement(boton).click();
	}
}