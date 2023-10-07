import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

public class ImageTest {

    WebDriver driver;

    @Test
    public void imageTest() {

        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.get("https://testeroprogramowania.github.io/selenium/basics.html");

        WebElement image = driver.findElement(By.tagName("img"));
        System.out.println(image.getAttribute("naturalHeight"));
        String height = image.getAttribute("naturalHeight");

        Assert.assertEquals("0", height);


        driver.get("https://testeroprogramowania.github.io/selenium/image.html");

        WebElement image2 = driver.findElement(By.tagName("img"));
        System.out.println(image.getAttribute("naturalHeight"));
        String height2 = image2.getAttribute("naturalHeight");

        Assert.assertEquals("0", height2);

    }
}
