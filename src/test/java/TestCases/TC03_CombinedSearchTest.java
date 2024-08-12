package TestCases;

import BaseTest.baseTest;
import Pages.P01_HomePage;
import Pages.P02_ProgramPage;
import Pages.P05_ComputerScienceProgram_And_EgyptCountryPage;
import com.github.javafaker.Faker;
import org.testng.Assert;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;
import Listeners.TestListeners;

@Listeners(TestListeners.class)

public class TC03_CombinedSearchTest extends baseTest {

    @Test(priority = 0)
    public void User_Search_ByBoth_Program_And_Country_With_ValidData() {
        P01_HomePage homePage = new P01_HomePage(driver);
        P02_ProgramPage programPage = homePage.Navigate_To_ProgramPage();
        P05_ComputerScienceProgram_And_EgyptCountryPage computerScienceProgramAndEgyptCountryPage = programPage.User_Search_By_Both_ProgramAndCountry_Name("Computer Science", "Egypt");
        String expectedUrl = "https://www.educatly.com/programs/computer-science-it/egypt";
        Assert.assertTrue(computerScienceProgramAndEgyptCountryPage.isCorrectUrlDisplayed(expectedUrl), "The URL is not as expected.");
    }

    @Test(priority = 1)
    public void User_Search_ByBoth_Program_And_Country_With_INValidData() {
        Faker fakeData = new Faker();
        String invalid_Country = fakeData.lorem().characters(7);
        String invalid_program = fakeData.lorem().characters(7);
        P01_HomePage homePage = new P01_HomePage(driver);
        P02_ProgramPage programPage = homePage.Navigate_To_ProgramPage();
        programPage.User_Entered_InvalidData_IN_Both_Search_Fields(invalid_program, invalid_Country);

        // Assert that the first search field is empty
        Assert.assertTrue(programPage.isFirstSearchFieldEmpty(), "The first search field is not empty.");

        // Assert that the second search field is empty
        Assert.assertTrue(programPage.isSecondSearchFieldEmpty(), "The second search field is not empty.");
    }


}
