package scenaries.tickets;

import org.openqa.selenium.WebDriver;
import resources.utils.GlobalResources;

public class HomePageTickets {

    WebDriver driver;

    public HomePageTickets(WebDriver _driver) {
        driver = _driver;
    }

    public void SearchFlights(WebDriver driver, String originCity, String destinyCity) {
        GlobalResources globalResources = new GlobalResources(driver);
        globalResources.Write("//*[@id='place_name_flight' and @name='place_name']", originCity);
        globalResources.Write("//*[@id='place_name_flight_to' and @name='place_name_to']", destinyCity);
        globalResources.Click("//*[@class='btnPrimary text-uppercase']");
    }

}
