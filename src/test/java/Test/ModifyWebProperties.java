package Test;

import entities.DemoQA.HomeDemoQA;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import resources.navigation.NavigatorChrome;

public class ModifyWebProperties {

    public static WebDriver driver; // Al hacerlo de esta manera el valor queda guardado en memoria (No toca instanciarlo cada que se necesite)
    HomeDemoQA homeDemoQA;
    scenaries.demoQA.ElementsDemoQA elementsDemoQA;

    @BeforeMethod // Indica que se ejecutará previo a las pruebas
    public void beforeTest(){
        NavigatorChrome navigatorChrome = new NavigatorChrome(driver); // Se crea una instancia para que el metodo pueda acceder a la clase navigationChrome
        driver = navigatorChrome.openGoogleNavigator("https://demoqa.com/elements");
    }

    public void ReadingData(){
        // En este caso no es necesario utilizar la función de ReadingData ya que no se envia información
    }

    public void BasicInstances(){
        elementsDemoQA = new scenaries.demoQA.ElementsDemoQA(driver);
        ReadingData(); // Se llama Reading Data para que busque la información
    }

    @Test // Indica el test que se va a realizar
    public void modifyElements(){
        BasicInstances(); // Se llaman las Instancias Básicas para Buscar Inicializar y buscar la data
        elementsDemoQA.ModifyElements(homeDemoQA); // Para no tener que poner toda la data solicitada se hace de esta manera
    }

    @AfterMethod // Indica que se ejecutará después de las pruebas
    public void afterTest(){
        NavigatorChrome navigatorChrome = new NavigatorChrome(driver); // Se crea una instancia para que el metodo pueda acceder a la clase navigationChrome
        driver = navigatorChrome.tearDown();
    }
}
