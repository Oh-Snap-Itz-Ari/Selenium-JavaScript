package Test;

import entities.facebook.ValidationSignIn;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import resources.navigation.NavigatorChrome;
import scenaries.facebook.RegisterFacebook;

public class SignInFacebook {

    public static WebDriver driver; // Al hacerlo de esta manera el valor queda guardado en memoria (No toca instanciarlo cada que se necesite)
    ValidationSignIn validationSignIn;
    RegisterFacebook registerFacebook;

    @BeforeMethod // Indica que se ejecutará previo a las pruebas
    public void beforeTest(){
        NavigatorChrome navigatorChrome = new NavigatorChrome(driver); // Se crea una instancia para que el metodo pueda acceder a la clase navigationChrome
        driver = navigatorChrome.openGoogleNavigator("https://es-la.facebook.com/");
    }

    public void ReadingData(){
        validationSignIn = new ValidationSignIn(); // Crea una instancia para utilizarla después
        validationSignIn.firstName = "Alex";
        validationSignIn.lastName = "Melo";
        validationSignIn.dayBirthday = "5"; // El value en este caso representa el día 5 del mes
        validationSignIn.monthBirthday = "abr"; // El visibletext en este caso representa Abril (April)
        validationSignIn.yearBirthday = "2000"; // El value en este caso representa el año 2000
        // validationSignIn.gender = "Male";
        // validationSignIn.gender = "Female";
        validationSignIn.gender = "Other";
        validationSignIn.email = "alexfabianmelo123@hotmail.com";
        validationSignIn.password = "pass123";
    }

    public void BasicInstances(){
        registerFacebook = new RegisterFacebook (driver);
        ReadingData(); // Se llama Reading Data para que busque la información
    }

    @Test // Indica el test que se va a realizar
    public void tryFacebookSignIn(){
        BasicInstances(); // Se llaman las Instancias Básicas para Buscar Inicializar y buscar la data
        registerFacebook.SignInFacebookConfirm(validationSignIn); // Para no tener que poner toda la data solicitada se hace de esta manera
    }

    @AfterMethod // Indica que se ejecutará después de las pruebas
    public void afterTest(){
        NavigatorChrome navigatorChrome = new NavigatorChrome(driver); // Se crea una instancia para que el metodo pueda acceder a la clase navigationChrome
        driver = navigatorChrome.tearDown();
    }
}
