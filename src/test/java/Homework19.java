import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;

public class Homework19 extends BaseTest{
    @Test
    public void deletePlaylist() throws InterruptedException {
        String notiMsg = "Deleted playlist \"First.\"";

        navigateToPage();
        provideEmail("camden.bertrand@testpro.io");
        providePassword("te$t$tudent");
        clickSubmit();
        clickPlaylist();
        WebElement deletePlstBtn = driver.findElement(By.cssSelector("button[title='Delete this playlist']"));
        deletePlstBtn.click();
        Thread.sleep(2000);
        Assert.assertEquals(verifyNoti(), notiMsg);
    }
}
