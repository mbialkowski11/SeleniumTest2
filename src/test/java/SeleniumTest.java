import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

public class SeleniumTest {


    @Test
    public void openGooglePage() {
        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
       //WebDriver driver = getDriver("chrome");
        driver.manage().window().maximize();
        driver.get("https://www.google.com");


        // znalezienie przycisku
        WebElement agreeButton = driver.findElement(By.xpath("//div[text()='Zaakceptuj wszystko']"));
        //kliknięcie przycisku
        agreeButton.click();
        //powrot do pierwotnego okna
        driver.switchTo().defaultContent();
        //znajdz pole wyszukiwani
        WebElement searchField = driver.findElement(By.name("q"));
        //wprowadz wartosc selenium do pola
        searchField.sendKeys("Selenium");
        //zasymuluj nacisniecie przycisku enter
        //searchField.sendKeys(Keys.ENTER);
        WebElement searchButton = driver.findElement(By.cssSelector("body > div.L3eUgb > div.o3j99.ikrT4e.om7nvf > form > div:nth-child(1) > div.A8SBwf > div.FPdoLc.lJ9FBc > center > input.gNO89b"));
       // WebElement searchButton = driver.findElement(By.cssSelector("[name='btnK']"));
        searchButton.click();
        // znalezc rezultat
        WebElement result = driver.findElement(By.xpath("//a[contains(@href,'selenium.dev')]//h3"));

        Assert.assertTrue(result.isDisplayed());


    }

    public WebDriver getDriver (String browser) {
        switch (browser) {
            case "chrome":
                String chromePath = "C:\\Users\\micha\\Downloads\\chromedriver_win32\\chromedriver.exe";
                System.setProperty("webdriver.chrome.driver", chromePath);
                return  new ChromeDriver();
            case "firefox":
                return new FirefoxDriver();
            case "ie":
                String iePath = "C:\\Users\\micha\\Downloads\\IEDriverServer_x64_4.8.1\\IEDriverServer.exe";
                System.setProperty("webdriver.ie.driver", iePath);
                return new InternetExplorerDriver();
            default:
                throw new InvalidArgumentException("Invalid browser name");
        }
    }
}
