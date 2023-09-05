package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.Assert;

import java.util.List;

public class PlaylistPage extends BasePage {
    public String playListName;
    By allSongsLoc = By.cssSelector(".song-list-wrap.main-scroll-wrap.playlist td.title");
    By createNewPlaylistCon = By.cssSelector("[data-testid='playlist-context-menu-create-simple']");
    By createPlaylistBtn = By.cssSelector("[data-testid='sidebar-create-playlist-btn']");
    By playlistInput = By.cssSelector("input[name='name']");
    By deletePlaylist = By.cssSelector(".del.btn-delete-playlist");

    By playNoti = By.xpath("//*[contains(text(),'Updated playlist')]");

    public PlaylistPage(WebDriver driver) {
        super(driver);
    }


    public void checkNumberOfSongsInPlaylist() {
        wait.until(ExpectedConditions.visibilityOfElementLocated(allSongsLoc));
        List<WebElement> allSongsInPlaylist =driver.findElements(allSongsLoc);
        //This block is for visibility - printing all the songs
        for (WebElement element: allSongsInPlaylist)
        {
            System.out.println(element.getText());
        }
        Assert.assertEquals(allSongsInPlaylist.size(),3);
    }

    public void clickOnCreateNewPlaylist() {
        wait.until(ExpectedConditions.visibilityOfElementLocated(createNewPlaylistCon)).click();
    }

    public void clickOnCreatePlaylistBtn() {
        wait.until(ExpectedConditions.visibilityOfElementLocated(createPlaylistBtn)).click();
    }

    public void enterNewPlaylistName(String newPlayListName) {
        WebElement playlistInputField = wait.until(ExpectedConditions.visibilityOfElementLocated(playlistInput));
//       clear() does not work, element has an attribute of "required"
//       workaround is ctrl A (to select all) then backspace to clear then replace with new playlist name
        playlistInputField.sendKeys(Keys.chord(Keys.CONTROL,"A", Keys.BACK_SPACE));
        //FOR MAC
        //playlistInputField.sendKeys(Keys.chord(Keys.COMMAND,"A", Keys.BACK_SPACE));
        playlistInputField.sendKeys(newPlayListName);
        playlistInputField.sendKeys(Keys.ENTER);
    }

    public void clickOnDeletePlaylistBtn() {
        WebElement deletePlaylistBtn = wait.until(ExpectedConditions.elementToBeClickable(deletePlaylist));
        actions.click(deletePlaylistBtn).perform();
    }

    public void clickOnPlaylist(String playListName) {
        By playlistElClick = By.xpath("//a[contains(text()," + playListName + ")]");
        wait.until(ExpectedConditions.visibilityOfElementLocated(playlistElClick));}

    public void doubleClickOnPlaylist(String playlistName) {
        By playlistElDblClick = By.xpath("//a[contains(text(),'" + playlistName + "')]");
        WebElement playlistElement = wait.until(ExpectedConditions.visibilityOfElementLocated(playlistElDblClick));
        actions.doubleClick(playlistElement).perform();
    }

    public void checkMessage(String playListName) {
        WebElement notification = wait.until(ExpectedConditions.visibilityOfElementLocated(playNoti));
        Assert.assertEquals("Updated playlist \""+playListName+".\"",notification.getText());
    }

}

