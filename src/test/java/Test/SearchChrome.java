package Test;

import entities.google.ValidationSearch;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import resources.navigation.NavigatorChrome;
import scenaries.mvn.SearchLibraries;

public class SearchChrome {

    WebDriver driver;
    ValidationSearch validationSearch;
    SearchLibraries searchLibraries;

    @BeforeMethod // Indica que se ejecutará previo a las pruebas
    public void beforeTest(){
        NavigatorChrome navigatorChrome = new NavigatorChrome(driver); // Se crea una instancia para que el metodo pueda acceder a la clase navigationChrome
        driver = navigatorChrome.openGoogleNavigator("https://mvnrepository.com/");
    }

    public void ReadingData(){
        validationSearch = new ValidationSearch(); // Crea una instancia para utilizarla después
        validationSearch.setSearchcontent("Selenium");
    }

    public void BasicInstances(){
        searchLibraries = new SearchLibraries(driver);
        ReadingData(); // Se llama Reading Data para que busque la información
    }

    @Test // Indica el test que se va a realizar
    public void searchChrome(){
        BasicInstances();
        searchLibraries.SearchMvnLibrary(driver, validationSearch.getSearchcontent().toString());
    }

    @AfterMethod // Indica que se ejecutará después de las pruebas
    public void afterTest(){
        NavigatorChrome navigatorChrome = new NavigatorChrome(driver); // Se crea una instancia para que el metodo pueda acceder a la clase navigationChrome
        driver = navigatorChrome.tearDown();
    }
}
