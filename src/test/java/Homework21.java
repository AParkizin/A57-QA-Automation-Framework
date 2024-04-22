import io.netty.handler.codec.http.websocketx.extensions.WebSocketExtensionEncoder;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.Assert;
import org.testng.annotations.Test;

public class Homework21 extends BaseTest {
    @Test
    public void renamePlaylist() {
        String updatedPlaylistMsg = "Updated playlist \"POLO.\"";
        //GIVEN
        provideEmail("aleksandr.parkizin@testpro.io");
        providePassword("Z0ffApQ6");
        clickLoginBtn();

        //WHEN
        locatePlaylist();
        contextClickPlaylist();
        clickEditPlaylist();
        enterNewPlaylistName();

        //THEN
        Assert.assertEquals(newPlaylistNameSuccessMsg(), updatedPlaylistMsg);
    }

    //THEN
    public String newPlaylistNameSuccessMsg() {
        WebElement notification = wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("div.success.show")));
        return notification.getText();
    }

    public void enterNewPlaylistName() {
        WebElement newPlaylistName = wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("[name='name']")));
        newPlaylistName.sendKeys(Keys.chord(Keys.CONTROL,"A", Keys.BACK_SPACE));
        newPlaylistName.sendKeys("NewSashaPlaylist");
        newPlaylistName.sendKeys(Keys.ENTER);
    }

    public void clickEditPlaylist() {
        WebElement editPlaylist = wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("li[data-testid = 'playlist-context-menu-edit-93544']")));
        actions.contextClick(editPlaylist).perform();
    }

    public void contextClickPlaylist() {
        WebElement secondPlaylist = wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("a[href='#!/playlist/93544']")));
        actions.contextClick(secondPlaylist).perform();
    }

    public void locatePlaylist() {
        WebElement selectPlaylist = driver.findElement(By.cssSelector("a[href='#!/playlist/93544']"));
        actions.moveToElement(selectPlaylist).perform();
        selectPlaylist.click();
    }
}
