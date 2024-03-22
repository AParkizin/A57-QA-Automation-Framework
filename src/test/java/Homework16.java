import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.time.Duration;

public class Homework16 extends BaseTest {
    @Test
    public void registrationNavigation() {

        ChromeOptions options = new ChromeOptions();
        options.addArguments("--remote-allow-origins=*");

        WebDriver driver = new ChromeDriver(options);
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

        String url = "https://qa.koel.app/";
        driver.get(url);

        WebElement registrationBtn = driver.findElement(By.cssSelector("a[href='registration']"));
        registrationBtn.click();

        String urlRegistration = "https://qa.koel.app/registration";
        Assert.assertEquals(driver.getCurrentUrl(), urlRegistration);
        driver.quit();

    }
}








// Assert.assertEquals(driver.getCurrentUrl(), url);
// driver.quit();
// a[href='registration']
// h2[style]
// https://qa.koel.app/registration