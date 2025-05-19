package scenaries.demoQA;

import entities.DemoQA.HomeDemoQA;
import org.openqa.selenium.WebDriver;
import resources.utils.GlobalResources;

public class ElementsDemoQA {

    public static WebDriver driver;

    public ElementsDemoQA(WebDriver _driver) {
        driver = _driver;
    }

    public void ModifyElements(HomeDemoQA homeDemoQA) { //Al hacer lo de public static WebDriver ya no sería necesario pedir el driver

        GlobalResources globalResources = new GlobalResources(driver);

        String divElements = "//*[@id='app']/div/div/div/div[1]/div/div/div[1]/span/div";
        String spanWebTables = "//span[text()='Web Tables']";
        String inputFilterTable = "//*[@id='searchBox']";

        globalResources.JSModifyAttribute(divElements, "style", "background: rgb(255, 0, 0);"); // Cambia el color de la variable con base al Atributo Style (En este caso lo cambia a rojo)
        globalResources.Click(spanWebTables);
        globalResources.JSRemoveAttribute(inputFilterTable,"autocomplete"); // Elimina el autocomplete de la barra de búsqueda (Propíedad HTML)
        globalResources.JSRemoveAttribute(inputFilterTable,"placeholder"); // Elimina el placeholder de la barra de búsqueda (Propiedad HTML)

    }
}
