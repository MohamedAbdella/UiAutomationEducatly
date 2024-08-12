package Pages;

import org.openqa.selenium.WebDriver;

//The page when appears when the user searched by both program search and country search
public class P05_ComputerScienceProgram_And_EgyptCountryPage {
    private WebDriver driver;

    public P05_ComputerScienceProgram_And_EgyptCountryPage(WebDriver driver) {
        this.driver = driver;
    }

    // Method to check if the current URL matches the expected URL
    public boolean isCorrectUrlDisplayed(String expectedUrl) {
        return driver.getCurrentUrl().equals(expectedUrl);
    }


}
