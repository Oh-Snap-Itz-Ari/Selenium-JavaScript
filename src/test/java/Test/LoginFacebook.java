package Test;

import entities.facebook.ValidationLogin;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import resources.navigation.NavigatorChrome;
import scenaries.facebook.HomeFacebook;

public class LoginFacebook {

    WebDriver driver;
    ValidationLogin validationLogin;
    HomeFacebook homeFacebook;

    @BeforeMethod // Indica que se ejecutará previo a las pruebas
    public void beforeTest(){
        NavigatorChrome navigatorChrome = new NavigatorChrome(driver); // Se crea una instancia para que el metodo pueda acceder a la clase navigationChrome
        driver = navigatorChrome.openGoogleNavigator("https://es-la.facebook.com/");
    }

    public void ReadingData(){
        validationLogin = new ValidationLogin(); // Crea una instancia para utilizarla después
        validationLogin.email = "test@test.com";
        validationLogin.password = "test123";
    }

    public void BasicInstances(){
        homeFacebook = new HomeFacebook (driver);
        ReadingData(); // Se llama Reading Data para que busque la información
    }

    @Test // Indica el test que se va a realizar
    public void tryFacebookLogin(){
        BasicInstances(); // Se llaman las Instancias Básicas para Buscar Inicializar y buscar la data
        homeFacebook.LoginFacebookConfirm(driver, validationLogin.email, validationLogin.password);
    }

    @AfterMethod // Indica que se ejecutará después de las pruebas
    public void afterTest(){
        NavigatorChrome navigatorChrome = new NavigatorChrome(driver); // Se crea una instancia para que el metodo pueda acceder a la clase navigationChrome
        driver = navigatorChrome.tearDown();
    }
}
