import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class Homework21 extends BaseTest{
    String playListName;

    @Test
    public void renamePlaylist() {
        playListName = "First";
        loginPage.loginCorrectCred();
        doubleClickOnPlaylist(playListName);
        enterNewPlaylistName(playListName);
        checkMessage();

    }
    private void doubleClickOnPlaylist(String playlistName) {
        WebElement playlistElement = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id='playlists']/ul/li[3]")));
        actions.doubleClick(playlistElement).perform();
    }
    private void enterNewPlaylistName(String newPlayListName) {
        WebElement playlistInputField = wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("input[name='name']")));
        playlistInputField.sendKeys(Keys.chord(Keys.CONTROL,"A", Keys.BACK_SPACE));
        playlistInputField.sendKeys("newFirst");
        playlistInputField.sendKeys(Keys.ENTER);
    }
    private void checkMessage() {
        WebElement notification = wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("div.success.show")));
        Assert.assertEquals("Updated playlist \"newFirst.\"", notification.getText());
    }
}
