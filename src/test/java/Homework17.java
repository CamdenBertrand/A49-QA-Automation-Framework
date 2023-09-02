import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;

public class Homework17 extends BaseTest{
    @Test(enabled = false)
    public void addSongToPlaylist() throws InterruptedException {
        String notiMsg = "Added 1 song into \"First.\"";

        loginPage.loginCorrectCred();
        loginPage.provideEmail("camden.bertrand@testpro.io");
        loginPage.providePassword("te$t$tudent");
        loginPage.clickSubmitBtn();
        homePage.searchSong();
        homePage.clickViewAll();
        homePage.clickFirstSong();
        homePage.clickAddTo();
        homePage.clickPlaylist();
        basePage.checkShowSuccess();

    }

}