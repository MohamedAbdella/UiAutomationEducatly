package Pages;

import BasePage.basePage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class P01_HomePage extends basePage {
    private By program_page_link = By.xpath("//a[@class='styles_navbar__body__end__navItem__aI6tt false'][text()='Programs']");

    public P01_HomePage(WebDriver driver) {
        super(driver);
    }

    public P02_ProgramPage Navigate_To_ProgramPage() {
        //Wait the element until appear and then click on it
        waitForVisibility(driver.findElement(program_page_link));
        driver.findElement(program_page_link).click();
        return new P02_ProgramPage(driver);
    }

}
