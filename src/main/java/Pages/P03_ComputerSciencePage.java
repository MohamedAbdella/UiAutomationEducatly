package Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

//The page that appears when the user searched by program filter
public class P03_ComputerSciencePage {
    private WebDriver driver;
    private By filterLabel = By.className("styles_criteriaCards__card__DWCA1");

    public P03_ComputerSciencePage(WebDriver driver) {
        this.driver = driver;
    }

    //This method make me assert on the name of filter label
    public String get_The_Label_NAme(){
        return driver.findElement(filterLabel).getText();
    }

}
