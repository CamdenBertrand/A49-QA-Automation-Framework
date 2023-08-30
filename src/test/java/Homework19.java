import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
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
        WebElement deletePlstBtn = wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("button[title='Delete this playlist']")));
        deletePlstBtn.click();
        Assert.assertEquals(verifyNoti(), notiMsg);
    }
}
