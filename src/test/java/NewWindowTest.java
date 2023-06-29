import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

import java.util.Set;

public class NewWindowTest {

    @Test
    public void testNewWindow() {
        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
        driver.get("https://testeroprogramowania.github.io/selenium/");
        WebElement basicPageLink = driver.findElement(By.linkText("Podstawowa strona testowa"));
        System.out.println(basicPageLink.getText());
        basicPageLink.click();
        String currentWindow = driver.getWindowHandle();
        driver.findElement(By.id("newPage")).click();
        Set<String> windowsNames = driver.getWindowHandles();
        for(String window : windowsNames) {
            if(!window.equals(currentWindow)) {
                driver.switchTo().window(window);
            }
        }
        WebElement agreeButton = driver.findElement(By.xpath("//*[@id=\"L2AGLb\"]/div[contains(text(),'Zaakceptuj')]"));
        agreeButton.click();
        driver.findElement(By.name("q")).sendKeys("Selenium");
        driver.switchTo().window(currentWindow);
        driver.findElement(By.name("fname")).sendKeys("Bartek");
    }
}
