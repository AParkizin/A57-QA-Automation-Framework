import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.Assert;
import org.testng.annotations.Test;

public class Homework20 extends BaseTest {

    @Test
    public void deletePlaylist() {
        String expectedDeletedPlaylistMsg = "Deleted playlist \"Test Pro Playlist.\"";
        provideEmail("aleksandr.parkizin@testpro.io");
        providePassword("Z0ffApQ6");
        clickBtn();

        clickTestProPlaylist();
        clickDeletePlaylist();
        Assert.assertEquals(deletedPlaylistMsg(), expectedDeletedPlaylistMsg);
    }

    public String deletedPlaylistMsg() {
        WebElement notification = wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("[class='success show']")));
        return notification.getText();
    }

    public void clickDeletePlaylist() {
        WebElement deletePlaylist = wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("[title='Delete this playlist']")));
        deletePlaylist.click();
    }

    public void clickTestProPlaylist() {
        WebElement testProPlaylist = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id=\"playlists\"]/ul/li[4]")));
        testProPlaylist.click();
    }
}
