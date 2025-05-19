package scenaries.facebook;

import org.openqa.selenium.WebDriver;
import resources.utils.GlobalResources;

public class HomeFacebook {

    WebDriver driver;

    public HomeFacebook(WebDriver _driver) {
        driver = _driver;
    }

    public void LoginFacebookConfirm(WebDriver driver, String email, String password) {
        GlobalResources globalResources = new GlobalResources(driver);
        globalResources.Write("//*[@id='email' and @name='email']", email);
        globalResources.Write("//*[@id='pass' and @name='pass']", password);
        globalResources.Click("//*[@name='login' and @type='submit']");
    }

}
