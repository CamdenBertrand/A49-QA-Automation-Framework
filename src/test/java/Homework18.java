import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;

public class Homework18 extends BaseTest{
    @Test
    public void playSong() throws InterruptedException {
        navigateToPage();
        logIn();
        playNext();
        clickPlayBtn();
        Thread.sleep(2000);
        WebElement pauseBtn = driver.findElement(By.cssSelector("span i[class='fa fa-pause']"));
        Assert.assertTrue(pauseBtn.isDisplayed());
    }
    public void clickPlayBtn() {
        WebElement playBtn = driver.findElement(By.cssSelector("footer span i[class='fa fa-play']"));
        playBtn.click();
    }

    public void playNext() {
        WebElement playNext = driver.findElement(By.cssSelector("[data-testid='play-next-btn']"));
        playNext.click();
    }
}
