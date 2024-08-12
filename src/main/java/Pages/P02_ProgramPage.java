package Pages;

import BasePage.basePage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;

import java.util.List;

public class P02_ProgramPage extends basePage {


    private By searchBtn = By.className("styles_header__start__search__btn__HH8Q_");
    // The text appears When the user entered data in the dropdown
    private By title_Of_Dropdown = By.xpath("//div[@role='listbox'][text()='No matches']");
    // The text appears When the user entered data in the field of Country search

    //The value of computer science existing in ddl of program field
    private By computerScience_Value_IN_Dropdown = By.xpath("//div[@class='ant-select-item-option-content'][text()='Computer Science & IT']");
    //The value of Egypt existing in ddl of country field
    private By egypt_Value_In_Dropdown = By.xpath("//div[@class='ant-select-item-option-content'][text()='Egypt']");


    public P02_ProgramPage(WebDriver driver) {
        super(driver);
    }


    public void User_TypeData_IN_ProgramField(String program_name) {
        // Wait until the URL is "https://www.educatly.com/programs"
        wait.until(ExpectedConditions.urlToBe("https://www.educatly.com/programs"));
        List<WebElement> inputs = driver.findElements(By.cssSelector("input.ant-select-selection-search-input"));
        WebElement firstInput = inputs.get(0); // Index 0 refers to the first element
        firstInput.sendKeys(program_name);
    }

    public P03_ComputerSciencePage User_SelectItem_From_ProgramDDL_And_CLick_SearchBtn() {
        //Wait until the element is visible
        waitForVisibility(driver.findElement(computerScience_Value_IN_Dropdown));
        driver.findElement(computerScience_Value_IN_Dropdown).click();
        driver.findElement(searchBtn).click();
        return new P03_ComputerSciencePage(driver);

    }


    public void User_TypeData_IN_CountryField(String country_name) {
        // Wait until the URL is "https://www.educatly.com/programs"
        wait.until(ExpectedConditions.urlToBe("https://www.educatly.com/programs"));
        List<WebElement> inputs = driver.findElements(By.cssSelector("input.ant-select-selection-search-input"));
        WebElement secondInput = inputs.get(1); // Index 1 refers to the second element
        secondInput.sendKeys(country_name);


    }

    public P04_EgyptCountryPage User_SelectItem_From_CountryuDDL_And_CLick_SearchBtn() {
        waitForVisibility(driver.findElement(egypt_Value_In_Dropdown));
        driver.findElement(egypt_Value_In_Dropdown).click();
        driver.findElement(searchBtn).click();
        return new P04_EgyptCountryPage(driver);

    }


    //User search by using both filters program and countryu
    public P05_ComputerScienceProgram_And_EgyptCountryPage User_Search_By_Both_ProgramAndCountry_Name(String program_name, String country_name) {
        // Wait until the URL is "https://www.educatly.com/programs"
        wait.until(ExpectedConditions.urlToBe("https://www.educatly.com/programs"));
        List<WebElement> inputs = driver.findElements(By.cssSelector("input.ant-select-selection-search-input"));
        WebElement firstInput = inputs.get(0); // Index 0 refers to the first element
        firstInput.sendKeys(program_name);
        waitForVisibility(driver.findElement(computerScience_Value_IN_Dropdown));
        driver.findElement(computerScience_Value_IN_Dropdown).click();
        WebElement secondInput = inputs.get(1); // Index 1 refers to the second element
        secondInput.sendKeys(country_name);
        waitForVisibility(driver.findElement(egypt_Value_In_Dropdown));
        driver.findElement(egypt_Value_In_Dropdown).click();
        driver.findElement(searchBtn).click();
        return new P05_ComputerScienceProgram_And_EgyptCountryPage(driver);

    }

    public void User_Entered_InvalidData_IN_Both_Search_Fields(String program_name, String country_name) {
        wait.until(ExpectedConditions.urlToBe("https://www.educatly.com/programs"));
        List<WebElement> inputs = driver.findElements(By.cssSelector("input.ant-select-selection-search-input"));
        WebElement firstInput = inputs.get(0); // Index 0 refers to the first element
        firstInput.sendKeys(program_name);
        WebElement secondInput = inputs.get(1); // Index 1 refers to the second element
        secondInput.sendKeys(country_name);
        driver.findElement(searchBtn).click();
    }

    // Method to check if the first search field is empty
    public boolean isFirstSearchFieldEmpty() {
        List<WebElement> inputs = driver.findElements(By.cssSelector("input.ant-select-selection-search-input"));
        WebElement firstInput = inputs.get(0);
        return firstInput.getAttribute("value").isEmpty();
    }

    // Method to check if the second search field is empty
    public boolean isSecondSearchFieldEmpty() {
        List<WebElement> inputs = driver.findElements(By.cssSelector("input.ant-select-selection-search-input"));
        WebElement secondInput = inputs.get(1);
        return secondInput.getAttribute("value").isEmpty();
    }

    public String getText_DropdownName_Of_programSearch() {
        waitForVisibility(driver.findElement(title_Of_Dropdown));
        return driver.findElement(title_Of_Dropdown).getText();

    }


}




