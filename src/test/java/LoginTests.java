import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.HomePage;
import pages.LoginPage;

public class LoginTests extends BaseTest {
    
    @Test
    public void LoginValidCredentialsTest() {

        LoginPage loginPage = new LoginPage(driver, wait, actions);
        HomePage homePage = new HomePage(driver, wait, actions);

        loginPage.provideEmail("camden.bertrand@testpro.io");
        loginPage.providePassword("te$t$tudent");
        loginPage.clickSubmitBtn();
    }

}