package TestCases;
import BaseTest.baseTest;
import Pages.P01_HomePage;
import Pages.P02_ProgramPage;
import Pages.P03_ComputerSciencePage;
import Pages.P04_EgyptCountryPage;
import com.github.javafaker.Faker;
import org.testng.Assert;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;
import Listeners.TestListeners;

@Listeners(TestListeners.class)
public class TC02_SearchByCountry extends baseTest {
    @Test(priority = 0)
    public void User_Can_SearchBy_CountryField_With_ValidData() {
        P01_HomePage homePage = new P01_HomePage(driver);
        P02_ProgramPage programPage = homePage.Navigate_To_ProgramPage();
        programPage.User_TypeData_IN_CountryField("Egypt");
        P04_EgyptCountryPage countryPage = programPage.User_SelectItem_From_CountryuDDL_And_CLick_SearchBtn();
        Assert.assertTrue(countryPage.get_The_Label_NAme().contains("Egypt"));

    }

    @Test(priority = 1)
    public void User_Can_SearchBy_CountryField_With_INValidData() {
        Faker fakeData = new Faker();
        String invalid_Country = fakeData.lorem().characters(7);
        P01_HomePage homePage = new P01_HomePage(driver);
        P02_ProgramPage programPage = homePage.Navigate_To_ProgramPage();
        programPage.User_TypeData_IN_CountryField(invalid_Country);
        Assert.assertTrue(programPage.getText_DropdownName_Of_programSearch().contains("No matches"));
    }
}
