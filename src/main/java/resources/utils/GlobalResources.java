package resources.utils;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.Select;

public class GlobalResources {

    WebDriver driver;

    public GlobalResources(WebDriver _driver) {
        driver = _driver;
    }

    public void Click (String xpath){
        driver.findElement(By.xpath(xpath)).click();
    }

    public void Write (String xpath, String text){
        driver.findElement(By.xpath(xpath)).clear();
        driver.findElement(By.xpath(xpath)).sendKeys(text);
    }

    public void SelectListValue (String xpath, String value){
        Select list = new Select(driver.findElement(By.xpath(xpath)));
        list.selectByValue(value);
    }

    public void SelectListText (String xpath, String text){
        Select list = new Select(driver.findElement(By.xpath(xpath)));
        list.selectByVisibleText(text);
    }
}
