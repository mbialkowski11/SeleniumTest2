import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

import java.util.List;

public class XpathTest {

    @Test
    public void  findElements(){
        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
        driver.get("https://testeroprogramowania.github.io/selenium/basics.html");


        //clickOnMe
        By buttonId = By.xpath("//button[@id='clickOnMe']");
        WebElement clickOnMeButton = driver.findElement(buttonId);


        //fname
        By firstName = By.xpath("//input[@name='fname']");
        WebElement firstNameInput = driver.findElement(firstName);

        //topSecret

        By paraHidden = By.xpath("//p[@class='topSecret']");
        driver.findElement(paraHidden);

        By inputLocator = By.xpath("//input");
        WebElement input = driver.findElement(inputLocator);   //zwraca pierwszy z góry input
        input.sendKeys("Pierwszy");
        List<WebElement> inputs = driver.findElements(inputLocator);  //zwraca cala liste inputow
        System.out.println(inputs.size());

        By linkText = By.xpath("//a[text()='Visit W3Schools.com!']");
        WebElement schoolLink = driver.findElement(linkText);

        By partialLink = By.xpath("//a[contains(text(),'Visit')]");
        WebElement schoolPartial = driver.findElement(partialLink);

        By fullPath = By.xpath("/html/body/div/ul");
        driver.findElement(fullPath);

        By shortPath = By.xpath("//ul");
        driver.findElement(shortPath);

        By allXpath = By.xpath("//*");
        driver.findElement(allXpath);

        By secondElement = By.xpath("(//input)[2]");
        driver.findElement(secondElement);

        By lastElement = By.xpath("(//input)[last()]");
        driver.findElement(lastElement);

        By elementWithAttribute = By.xpath("//*[@name]");
        driver.findElement(elementWithAttribute);

        By attrEq = By.xpath("//button[@id='clickOnMe']");
        By attrNotEq = By.xpath("//*[@id!='clickOnMe']");
        By attrCont = By.xpath("//*[contains(@name,'ame')]");
        By startsWith = By.xpath("//*[starts-with(@name,'user')]");
        By endsWith = By.xpath("//*[substring(@name,string-length(@name)-string-length('fname')+1)='fname']");

        driver.findElement(attrEq);
        driver.findElement(attrNotEq);
        driver.findElement(attrCont);
        driver.findElement(startsWith);
        driver.findElement(endsWith);

        By child = By.xpath("//div/child::ul");
        By desc = By.xpath("//div/descendant::ul");
        By parent = By.xpath("//div/../..");
        By asc = By.xpath("//div/ancestor::*");
        By foll = By.xpath("//img/following::*");
        By follSib = By.xpath("//img/following-sibling::*");
        By prec = By.xpath("//img/preceding::*");
        By precSib = By.xpath("//img/preceding-sibling::*");

        driver.findElement(child);
        driver.findElement(desc);
        driver.findElement(parent);
        driver.findElement(asc);
        driver.findElement(foll);
        driver.findElement(follSib);
        driver.findElement(prec);
        driver.findElement(precSib);

        By divsAndLinks = By.xpath("//a | //div");
        By andOp = By.xpath("//input[@name='fname' and @id='fname']");
        By orOp = By.xpath("//input[@name='fname' or @id='fn']");

        driver.findElement(divsAndLinks);
        driver.findElement(andOp);
        driver.findElement(orOp);


    }
}
