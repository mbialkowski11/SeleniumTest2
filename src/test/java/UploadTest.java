import io.github.bonigarcia.wdm.WebDriverManager;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.Test;

import java.io.File;
import java.io.IOException;

public class UploadTest {

    @Test
    public void executeJavascript() throws IOException {
        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
        int randomNumber = (int) (Math.random()*1000);
        driver.get("https://testeroprogramowania.github.io/selenium/fileupload.html");
        TakesScreenshot screenshot = (TakesScreenshot) driver;
        File before = screenshot.getScreenshotAs(OutputType.FILE);
        String fileName = "beforeUpload" + randomNumber + ".png";
        FileUtils.copyFile(before,new File("src/test/resources/" + fileName));
        driver.findElement(By.id("myFile")).sendKeys("C:\\Users\\micha\\OneDrive\\Pulpit\\opis.txt");
       // File after = screenshot.getScreenshotAs(OutputType.FILE);
       // FileUtils.copyFile(after,new File("src/test/resources/afterUpload.png"));
        Actions actions = new Actions(driver);
        //actions.contextClick().perform();
        actions.contextClick(driver.findElement(By.id("myFile"))).perform();

    }
}
