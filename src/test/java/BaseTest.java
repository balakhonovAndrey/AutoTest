import org.junit.Before;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;


public class BaseTest {

    WebDriver driver = null;
    WebElement element = null;

    String url = "https://www.sberbank.ru/ru/person";
    String menu = "//button[@class='lg-menu__link' and @aria-label='Меню %s']";
    String subMenu = "//*[@class='lg-menu__sub-link' and text()='%s']";
    String polisCost = "//div[@class='b-form-box-title ng-binding' and text()='%s']";

    @Before
    public void startBrowser() {
//        String browser = System.getProperty("browser", "firefox");
//        switch (browser) {
//            case "firefox": {
                this.driver = new FirefoxDriver();
//                break;
//            }
//            case "chrome": {
//                this.driver = new ChromeDriver();
//            }
//        }
    }

    public void driverClose() {
        this.driver.quit();
    }

    public WebElement waitDynamicElement (String xpath) {
        this.element = (new WebDriverWait(this.driver, 10))
                .until(ExpectedConditions.presenceOfElementLocated(By.xpath(xpath)));
        return element;
    }

    public WebElement findElement(String xpath) {
        return this.element = this.driver.findElement(By.xpath(xpath));
    }

    public WebElement findAndClick(String xpath) {
        this.element = this.driver.findElement(By.xpath(xpath));
        this.element.click();
        return element;
    }

    public String findMenu(String menu, String menuName) {
        return String.format(menu, menuName);
    }

}

