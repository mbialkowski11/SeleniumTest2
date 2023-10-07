import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;
import org.testng.annotations.Test;

import java.time.Duration;
import java.util.List;

public class WaitTest {

    WebDriver driver;

    @Test
    public void waitTest()  {

        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        //driver.manage().timeouts().implicitlyWait(10,TimeUnit.SECONDS);                  implicit dla wszysttkich elementów, czeka tyle ile trzeba. W tym przypadku max 10 sek
        driver.get("https://testeroprogramowania.github.io/selenium/wait2.html");

        driver.findElement(By.id("clickOnMe")).click();
        //Thread.sleep(5000);    Czeka zawsze 5 sekund przy tym elemencie, nawet jak się wyświetli szybciej np po 2 sek

        //WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));               explicit - czeka tylko w tym przypadku przez tyle sekund ile trzeba, tak jak implicit
       // wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("p")));


        FluentWait<WebDriver> wait = new FluentWait<>(driver);
        //to samo co explicit tylko nie zawiera wyjatkow. WebdriverWait ma juz zawarte wyjatki w sobie
        wait.ignoring(NoSuchElementException.class);
        wait.withTimeout(Duration.ofSeconds(10));
        wait.pollingEvery(Duration.ofSeconds(1));    //odpytuje co sekunde, domyslnie chyba co pół?
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("p")));


        driver.findElement(By.cssSelector("p"));

        waitForElementToExist(By.cssSelector("p"));


    }
    public void waitForElementToExist(By locator) {


        FluentWait<WebDriver> wait = new FluentWait<>(driver);
        wait.ignoring(NoSuchElementException.class);
        wait.withTimeout(Duration.ofSeconds(10));
        wait.pollingEvery(Duration.ofSeconds(1));    //odpytuje co sekunde, domyslnie chyba co pół?
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("p")));

        wait.until((driver) -> {
            List<WebElement> elements = driver.findElements(locator);
            if (elements.size() > 0) {
                System.out.println("Element jest na stronie");
                return true;
            } else {
                System.out.println("Elementu nie ma na stronie");
                return false;
            }
        });

    }



}
