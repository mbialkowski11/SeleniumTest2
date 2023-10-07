import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.Test;

import java.util.Set;

public class Homework {


    @Test
    public void homeworkTest() {
        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
        driver.get("https://testeroprogramowania.github.io/selenium/basics.html");


        //1. Odczytanie tekstu z "Witaj na stronie testowej" a następnie podświetlenie

        Actions actions = new Actions(driver);
        WebElement heading = driver.findElement(By.tagName("h1"));
        System.out.println(heading.getText());
        actions.moveToElement(heading).perform();

        //2. Kliknięcie w button oraz akceptacja popupu

        driver.findElement(By.id("clickOnMe")).click();
        driver.switchTo().alert().accept();

        //3. Wpisanie imienia
        driver.findElement(By.name("fname")).sendKeys("Michal");

        //4, Kliknięcie w link "IamWeirdLink" , akceptacja cookies oraz wpisanie frazy w googlu i wejście w nią
        driver.findElement(By.linkText("IamWeirdLink")).click();
        driver.findElement(By.cssSelector("[class='QS5gu sy4vM']")).click();
        driver.findElement(By.name("q")).sendKeys("Selenium");
        //driver.findElement(By.name("btnK")).click();
        driver.findElement(By.cssSelector("body > div.L3eUgb > div.o3j99.ikrT4e.om7nvf > form > div:nth-child(1) > div.A8SBwf > div.FPdoLc.lJ9FBc > center > input.gNO89b")).click();

        //5. Pobranie i wypisanie wartości $100
        driver.get("https://testeroprogramowania.github.io/selenium/basics.html");
        WebElement tableText = driver.findElement(By.cssSelector("td:nth-child(2)"));
        System.out.println(tableText.getText());

        //6. Wybór z selecta Mercedes oraz wypisanie tej wartości (wypisuje wartość selecta, ale pierwotnego)

        WebElement carSelect = driver.findElement(By.cssSelector("select"));
        Select cars = new Select(carSelect);
        cars.selectByValue("mercedes");

        WebElement choosenCar= driver.findElement(By.cssSelector("option:nth-child(4)"));
        System.out.println(choosenCar.getText());

        //7. Tick koło Potwierdzam oraz wybór Female

        driver.findElement(By.cssSelector("input[type='checkbox']")).click();
        driver.findElement(By.cssSelector("input[value='female']")).click();

        //8. Usunięcie nazwy Mickey i zmiana na Andrzej oraz zmiana hasła na 123456789

        WebElement nick = driver.findElement(By.name("username"));
        nick.clear();
        nick.sendKeys("Andrzej");

        WebElement password = driver.findElement(By.name("password"));
        password.clear();
        password.sendKeys("123456789");

        //9. Kliknięcie Submit i akceptacja obu popupów

        driver.findElement(By.cssSelector("input[type='submit']")).click();
        driver.switchTo().alert().accept();
        driver.switchTo().alert().accept();

        //10. Kliknięcie buttonu Click me i wpisanie frazy Selenium w nowym oknie a następnie wyszukanie jej w googlu

        driver.findElement(By.id("newPage")).click();
        String currentWindow = driver.getWindowHandle();


        Set<String> windowsNames = driver.getWindowHandles();
        for(String window : windowsNames) {
            if(!window.equals(currentWindow)) {
                driver.switchTo().window(window);
            }
        }
        driver.findElement(By.name("q")).sendKeys("Selenium");
        driver.findElement(By.cssSelector("body > div.L3eUgb > div.o3j99.ikrT4e.om7nvf > form > div:nth-child(1) > div.A8SBwf > div.FPdoLc.lJ9FBc > center > input.gNO89b")).click();

        driver.close();
        driver.switchTo().window(currentWindow);


        //11. Wypisanie tekstu z ukrytego paragrafu

        WebElement paragraph = driver.findElement(By.className("topSecret"));
        System.out.println(paragraph.getAttribute("textContent"));

        //12. Wypisanie tekstu Child z listy

        WebElement list = driver.findElement(By.cssSelector("#container > ul > li:nth-child(1) > ul > li"));
        System.out.println(list.getText());









    }
}
