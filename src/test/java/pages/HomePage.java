package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.Assert;

public class HomePage extends BasePage{
    public HomePage (WebDriver driver) {
        super(driver);
    }
    By userAvatarIcon = By.cssSelector("img.avatar");
    By allSongsBtn = By.cssSelector("li a.songs");
    By searchField = By.cssSelector("input[type='search']");
    By viewAllBtn = By.cssSelector("#searchExcerptsWrapper>div>div>section.songs>h1>button");
    By firstPlaylistBtn = By.cssSelector("li[class='playlist playlist']");
    By firstSong = By.cssSelector("#songResultsWrapper tr.song-item:first-child");
    By addToBtn = By.cssSelector("button[data-test='add-to-btn']");
    By playbackBtn = By.cssSelector(".playback");
    By soundbarElem = By.cssSelector("[data-testid='sound-bar-play']");
    By playBtnBot = By.cssSelector("[data-testid='play-btn']");
    By playPan = By.cssSelector(".side.player-controls");

    public WebElement getUserAvatar(){
        return findElement(userAvatarIcon);
    }
    public void clickPlay() {
        findElement(playbackBtn).click();
    }
    public void checkSongIsPlaying() {
        WebElement soundBar = wait.until(ExpectedConditions.visibilityOfElementLocated(soundbarElem));
        Assert.assertTrue(soundBar.isDisplayed());
    }
    public void checkIfPlayBtnIsVisible() {
        WebElement playBtn =   wait.until(ExpectedConditions.visibilityOfElementLocated(playBtnBot));
        Assert.assertTrue(playBtn.isDisplayed());
    }

    public void mouseMoveToPlayBtn() {
        WebElement playPanel = wait.until(ExpectedConditions.visibilityOfElementLocated(playPan));
        actions.moveToElement(playPanel).perform();
    }
    public void clickAllSongs() {
        findElement(allSongsBtn).click();
    }

    public void contextClickSongByName(String songName)  {
        By songNameEl = By.xpath("//section[@id='songsWrapper']//td[text()='"+songName+"']");
        WebElement song =wait.until(ExpectedConditions.elementToBeClickable(songNameEl));
        actions.contextClick(song).perform();
    }

    public void searchSong() {
        findElement(searchField).clear();
        actions.moveToElement((WebElement) searchField).sendKeys("dark");
    }

    public void clickViewAll() {
        findElement(viewAllBtn).click();
    }

    public void clickPlaylist() {
        findElement(firstPlaylistBtn).click();
    }

    public void clickFirstSong() {
        findElement(firstSong).click();
    }

    public void clickAddTo() {
        findElement(addToBtn).click();
    }
}
