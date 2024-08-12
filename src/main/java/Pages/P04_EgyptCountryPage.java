package Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

//The page that appears when the user search by country filter
public class P04_EgyptCountryPage {
    private WebDriver driver;
    private By filterLabel = By.className("styles_criteriaCards__card__DWCA1");

    public P04_EgyptCountryPage(WebDriver driver) {
        this.driver = driver;
    }

    //This method make me assert on the name of filter label
    public String get_The_Label_NAme() {
        return driver.findElement(filterLabel).getText();
    }

}

