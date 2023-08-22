import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;

public class Homework17 extends BaseTest{
    @Test(enabled = false)
    public void addSongToPlaylist() throws InterruptedException {
        String notiMsg = "Added 1 song into \"First.\"";

        navigateToPage();
        provideEmail("camden.bertrand@testpro.io");
        providePassword("te$t$tudent");
        clickSubmit();
        searchSong();
        clickViewAll();
        clickFirstSong();
        clickAddTo();
        clickPlaylist();
        Assert.assertEquals(verifyNoti(), notiMsg);

    }

}