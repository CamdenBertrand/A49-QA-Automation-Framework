package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class LoginPage extends BasePage{

    public LoginPage(WebDriver driver, WebDriverWait wait, Actions actions) {
        super(driver, wait, actions);
    }
    public void loginCorrectCred() {
        provideEmail("camden.bertrand@testpro.io");
        providePassword("te$t$tudent");
        clickSubmitBtn();
    }


    public void provideEmail(String email) {
        enterText(By.cssSelector("input[type='email']"), email);
    }

    public void providePassword(String password) {

        enterText(By.cssSelector("input[type='password']"), password);
    }

    public void clickSubmitBtn() {
        clickOnElement(By.cssSelector("button[type='submit']"));
    }


}
