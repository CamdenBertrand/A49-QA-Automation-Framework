import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class PlayListTests extends BaseTest {
    String playListName ;
    @BeforeClass
    void login(){
        loginPage.loginCorrectCred();
        playListName ="Tester777";
    }
    @Test(priority = 1)
    public void createPlaylist()  {
        playListPage.clickOnCreatePlaylistBtn();
        playListPage.clickOnCreateNewPlaylist();
        playListPage.enterNewPlaylistName(playListName);
        basePage.checkShowSuccess();
    }
    @Test(priority = 2)
    public void renamePlaylist()  {
        playListPage.doubleClickOnPlaylist(playListName);
        playListName ="Updated"+ playListName;
        playListPage.enterNewPlaylistName(playListName);
        playListPage.checkMessage();
    }

    @Test(priority = 3)
    public void deletePlaylist()  {
        playListPage.clickOnPlaylist(playListName);
        playListPage.clickOnDeletePlaylistBtn();
        basePage.checkShowSuccess();
    }


}