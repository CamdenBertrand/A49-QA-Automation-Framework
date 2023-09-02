
import org.testng.annotations.Test;


public class ActionsTest extends BaseTest {

    @Test
    void contextClickOnSong() throws InterruptedException {
        loginPage.loginCorrectCred();
        homePage.clickAllSongs();
        playListPage.contextClickSongByName("Reactor");
        homePage.clickPlay();
        homePage.checkSongIsPlaying();
    }

    @Test
    void mouseHoverTest() {
        loginPage.loginCorrectCred();
        homePage.clickAllSongs();
        homePage.mouseMoveToPlayBtn();
        homePage.checkIfPlayBtnIsVisible();
    }
    @Test
    void checkPlaylistSongs() {
        loginPage.loginCorrectCred();
        playListPage.clickOnPlaylist("newFirst");
        playListPage.checkNumberOfSongsInPlaylist();
    }


}