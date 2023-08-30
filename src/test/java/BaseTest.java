import io.github.bonigarcia.wdm.WebDriverManager;
import org.apache.commons.lang3.RandomStringUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.*;

import java.time.Duration;
import java.util.UUID;

import static java.lang.Thread.sleep;

public class BaseTest {
    public static WebDriver driver = null;
    //ublic static String url = "https://qa.koel.app/";
     public static String url;
    WebDriverWait wait;
    @BeforeSuite
    static void setupClass() {
        WebDriverManager.chromedriver().setup();
    }
    @BeforeMethod
    @Parameters({"BaseURL"})
    public void launchBrowser(String BaseURL) {

        ChromeOptions options = new ChromeOptions();
        options.addArguments("--remote-allow-origins=*");
        url = BaseURL;
        driver = new ChromeDriver(options);
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.manage().window().maximize();
        wait = new WebDriverWait(driver,Duration.ofSeconds(10));
    }
    @AfterMethod
    public void closeBrowser() {
        driver.quit();
    }
    public  void navigateToPage() {
        driver.get(url);
    }
    public static void provideEmail(String email) {
        WebElement emailField = driver.findElement(By.cssSelector("input[type='email']"));
        emailField.clear();
        emailField.sendKeys(email);
    }
    public static void providePassword(String password) {
        WebElement passwordField = driver.findElement(By.cssSelector("input[type='password']"));
        passwordField.clear();
        passwordField.sendKeys(password);
    }
    public void clickSubmit() {
        WebElement submit = wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("button[type='submit']")));
        submit.click();
    }
    public void logIn() {
        provideEmail("camden.bertrand@testpro.io");
        providePassword("te$t$tudent");
        clickSubmit();
    }
    public void searchSong() throws InterruptedException {
        WebElement searchField = wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("input[type='search']")));
        searchField.clear();
        searchField.sendKeys("Dark");
    }
    public void clickViewAll() throws InterruptedException {
        WebElement viewAllBtn = wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("#searchExcerptsWrapper>div>div>section.songs>h1>button")));
        viewAllBtn.click();

    }
    public void clickFirstSong() throws InterruptedException {
        WebElement firstSong = wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("#songResultsWrapper tr.song-item:first-child")));
        firstSong.click();
    }
    public void clickAddTo() throws InterruptedException {
        WebElement addToBtn = wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("button[data-test='add-to-btn']")));
        addToBtn.click();
    }
    public void clickPlaylist() throws InterruptedException {
        WebElement firstPlaylistBtn = wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("li[class='playlist playlist']")));
        firstPlaylistBtn.click();
    }
    public String verifyNoti() {
        WebElement notificationDisplayed = wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("div.success.show")));
        return notificationDisplayed.getText();
    }
    @DataProvider(name = "csvData")
    public Object[][] getDatafromDataProvider(){
        return new Object[][]{
            {"incorrectemail@test.com", "badPassword"},
            {"demo@class.com", ""},
            {"", ""}
        } ;
    }
}