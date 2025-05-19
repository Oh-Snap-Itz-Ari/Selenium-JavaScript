package Test;

import entities.tickets.ValidationTickets;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import resources.navigation.NavigatorChrome;
import scenaries.tickets.HomePageTickets;

public class SearchTickets {

    WebDriver driver;
    ValidationTickets validationTickets;
    HomePageTickets homePageTickets;

    @BeforeMethod // Indica que se ejecutará previo a las pruebas
    public void beforeTest(){
        NavigatorChrome navigatorChrome = new NavigatorChrome(driver); // Se crea una instancia para que el metodo pueda acceder a la clase navigationChrome
        driver = navigatorChrome.openGoogleNavigator("https://www.tiquetesbaratos.com/");
    }

    public void ReadingData(){
        validationTickets = new ValidationTickets(); // Crea una instancia para utilizarla después
        validationTickets.setOriginCity("Bogotá - Colombia (BOG)");
        validationTickets.setDestinyCity("México - Ciudad de México CDMX (MEX)");
    }

    public void BasicInstances(){
        homePageTickets = new HomePageTickets(driver);
        ReadingData(); // Se llama Reading Data para que busque la información
    }

    @Test // Indica el test que se va a realizar
    public void searchAirplaneTickets(){
        BasicInstances();
        homePageTickets.SearchFlights(driver, validationTickets.getOriginCity().toString(), validationTickets.getDestinyCity().toString());
    }

    @AfterMethod // Indica que se ejecutará después de las pruebas
    public void afterTest(){
        NavigatorChrome navigatorChrome = new NavigatorChrome(driver); // Se crea una instancia para que el metodo pueda acceder a la clase navigationChrome
        driver = navigatorChrome.tearDown();
    }
}

