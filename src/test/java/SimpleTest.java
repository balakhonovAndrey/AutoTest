import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class SimpleTest {

    String xpath = "//img[@src='/portalserver/content/atom/contentRepository/content/person/travel/banner-zashita-traveler.jpg?id=f6c836e1-5c5c-4367-b0d0-bbfb96be9c53']";

    @Before
    public void startTest() {
        System.out.println("startTest");
    }

    @After
    public void stopTest() {
        System.out.println("stopTest");
    }

    @Test
    public void test() {
        WebDriver driver = new FirefoxDriver();
        WebElement element = null;

        driver.navigate().to("https://www.sberbank.ru/ru/person");

        element = driver.findElement(By.xpath("//button[@class='lg-menu__link' and @aria-label='Меню Страхование']"));
        element.click();

        element = driver.findElement(By.xpath("//*[@class='lg-menu__sub-link' and text()='Страхование путешественников']"));
        element.click();

        (new WebDriverWait(driver, 10))
                .until(ExpectedConditions.presenceOfElementLocated(By
                        .xpath("//div[@class='sbrf-rich-outer']/h1")));

        String title = driver.findElement(By.xpath("//div[@class='sbrf-rich-outer']/h1")).getText();
        Assert.assertEquals("Проверка заголовка: ","Страхование путешественников", title);

        element = driver.findElement(By.xpath("//span[text()='Оформить онлайн']"));
        element.click();

        element = driver.findElement(By.xpath(xpath));
        element.click();

        driver.get("https://online.sberbankins.ru/store/vzr/index.html#/viewCalc");
        System.out.println("==========");
        System.out.println(driver.getCurrentUrl());
        System.out.println("==========");

        (new WebDriverWait(driver, 10))
                .until(ExpectedConditions.elementToBeClickable(By
                        .xpath("//*[@ng-click='save()']")));


        System.out.println("==========");
        System.out.println("Element isDisplayed: " + driver.findElement(By.xpath("//div[@class='b-form-box-title ng-binding' and text()='Минимальная']")).isDisplayed());
        System.out.println("Save_btn isEnabled: " + driver.findElement(By.xpath("//*[@ng-click='save()']")).isEnabled());
        System.out.println("==========");

        element = driver.findElement(By.xpath("//div[@class='b-form-box-title ng-binding' and text()='Минимальная']"));
        element.click();
    }
}
