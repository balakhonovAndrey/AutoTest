import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;


public class AutoTest extends BaseTest {

    @Before
    public void startTest() {
        System.out.println("startTest");
    }

    @After
    public void stopTest() {
        System.out.println("stopTest");
    }

    @Test
    public void test1() throws InterruptedException {

        driver.get(url);
        findAndClick(findMenu(menu,"Страхование"));
        findAndClick(findMenu(subMenu, "Страхование путешественников"));

        Assert.assertEquals("Проверка заголовка: "
                ,"Страхование путешественников"
                , findElement("//div[@class='sbrf-rich-outer']/h1").getText());

        findAndClick("//span[text()='Оформить онлайн']");
        findAndClick("//img[@src='/portalserver/content/atom/contentRepository/content/person/travel/banner-zashita-traveler.jpg?id=f6c836e1-5c5c-4367-b0d0-bbfb96be9c53']");

//        (new WebDriverWait(driver, 10))
//                .until(ExpectedConditions.elementToBeClickable(By
//                        .xpath("//div[@class='b-form-box-title ng-binding' and text()='Минимальная']"))).click();

        Thread.sleep(5000); // в 3 часа ночи ничего лучше на ум не приходит((
//        driver.findElement(By.xpath("//div[@class='b-form-box-title ng-binding' and text()='Минимальная']"));

        findAndClick("//*[@class='b-button-block-center']/span");

//        driverClose();
        }

}



//        (new WebDriverWait(driver, 10)).until(new ExpectedCondition<WebDriver>() {
//            public WebDriver apply(WebDriver d) {
//                d.get("https://online.sberbankins.ru/store/vzr/index.html#/viewCalc");
//                return d;
//       }});