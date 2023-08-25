import io.github.bonigarcia.wdm.WebDriverManager;
import org.apache.commons.lang3.RandomStringUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.Assert;
import org.testng.annotations.*;

import java.time.Duration;
import java.util.UUID;

import static java.lang.Thread.sleep;

public class BaseTest {
    public static WebDriver driver = null;
    //ublic static String url = "https://qa.koel.app/";
     public static String url;
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
    public static void clickSubmit() {
        WebElement submit = driver.findElement(By.cssSelector("button[type='submit']"));
        submit.click();
    }
    public void logIn() {
        provideEmail("camden.bertrand@testpro.io");
        providePassword("te$t$tudent");
        clickSubmit();
    }
    public void searchSong() throws InterruptedException {
        WebElement searchField = driver.findElement(By.cssSelector("input[type='search']"));
        searchField.clear();
        searchField.sendKeys("Dark");
        Thread.sleep(2000);
    }
    public void clickViewAll() throws InterruptedException {
        WebElement viewAllBtn = driver.findElement(By.cssSelector("#searchExcerptsWrapper>div>div>section.songs>h1>button"));
        viewAllBtn.click();
        Thread.sleep(2000);
    }
    public void clickFirstSong() throws InterruptedException {
        WebElement firstSong = driver.findElement(By.cssSelector("#songResultsWrapper tr.song-item:first-child"));
        firstSong.click();
        Thread.sleep(2000);
    }
    public void clickAddTo() throws InterruptedException {
        WebElement addToBtn = driver.findElement(By.cssSelector("button[data-test='add-to-btn']"));
        addToBtn.click();
        Thread.sleep(2000);
    }
    public static void clickPlaylist() throws InterruptedException {
        WebElement firstPlaylistBtn = driver.findElement(By.cssSelector("li[class='playlist playlist']"));
        firstPlaylistBtn.click();
        Thread.sleep(2000);
    }
    public String verifyNoti() {
        WebElement notificationDisplayed = driver.findElement(By.cssSelector("div.success.show"));
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