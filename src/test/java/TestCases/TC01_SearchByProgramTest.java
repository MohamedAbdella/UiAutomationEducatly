package TestCases;

import BaseTest.baseTest;
import Listeners.TestListeners;
import Pages.P01_HomePage;
import Pages.P02_ProgramPage;
import Pages.P03_ComputerSciencePage;
import com.github.javafaker.Faker;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

@Listeners(TestListeners.class)
public class TC01_SearchByProgramTest extends baseTest {
    @Test(priority = 0)
    public void User_Can_SearchBy_ProgramField_With_ValidData() {
        P01_HomePage homePage = new P01_HomePage(driver);
        P02_ProgramPage programPage = homePage.Navigate_To_ProgramPage();
        programPage.User_TypeData_IN_ProgramField("computer Science");
        P03_ComputerSciencePage computerSciencePage = programPage.User_SelectItem_From_ProgramDDL_And_CLick_SearchBtn();
        Assert.assertTrue(computerSciencePage.get_The_Label_NAme().contains("Computer"));
    }

    @Test(priority = 1)
    public void User_Can_SearchBy_ProgramField_With_INValidData() {
        Faker fakeData = new Faker();  //Generate random data to write it in the search field
        String invalid_Program = fakeData.lorem().characters(7);
        P01_HomePage homePage = new P01_HomePage(driver);
        P02_ProgramPage programPage = homePage.Navigate_To_ProgramPage();
        programPage.User_TypeData_IN_ProgramField(invalid_Program);
        Assert.assertTrue(programPage.getText_DropdownName_Of_programSearch().contains("No matches"));
    }


}
