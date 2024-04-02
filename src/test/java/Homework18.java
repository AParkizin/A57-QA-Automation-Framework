import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;

public class Homework18 extends BaseTest {
    @Test
    public void playSong() throws InterruptedException{

        provideEmail("demo@class.com");
        providePassword("te$t$tudent");
        clickLoginBtn();
        Thread.sleep(2000);
        playNextSong();
        Thread.sleep(2000);
        clickPlaySong();
        Thread.sleep(2000);

        Assert.assertTrue(isPlaying());

    }

    public boolean isPlaying(){
        WebElement soundBarVisualizer = driver.findElement(By.cssSelector("[data-test='soundbars']"));
        System.out.println("Sound bar is displayed");
        return soundBarVisualizer.isDisplayed();
    }

    public void clickPlaySong() {
        WebElement playSong = driver.findElement(By.cssSelector("[title='Play or resume']"));
        playSong.click();
    }

    public void playNextSong() {
        WebElement nextSong = driver.findElement(By.cssSelector("[title='Play next song']"));
        nextSong.click();
    }
}
