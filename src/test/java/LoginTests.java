import org.testng.annotations.Test;
import pages.HomePage;
import pages.LoginPage;

public class LoginTests extends BaseTest {
    
    @Test
    public void LoginValidCredentialsTest() {

        LoginPage loginPage = new LoginPage(driver);
        HomePage homePage = new HomePage(driver);

        loginPage.provideEmail("camden.bertrand@testpro.io");
        loginPage.providePassword("te$t$tudent");
        loginPage.clickSubmitBtn();
    }

}