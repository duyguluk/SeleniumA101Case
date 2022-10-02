import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import java.util.List;
import java.util.NoSuchElementException;
import java.util.Objects;
import java.util.Random;
import java.util.concurrent.TimeUnit;

public class a101 {

    public static void main (String[] args) {

        System.setProperty("webdriver.chrome.driver", "drivers/1.5/chromedriver.exe");
        WebDriver driver = new ChromeDriver();
        driver.get("https://www.a101.com.tr/");
        wait(2);

        WebElement allow_permission = driver.findElement(By.xpath("//button[@id='CybotCookiebotDialogBodyLevelButtonLevelOptinAllowAll']"));
        allow_permission.click();
        wait(2);

        WebElement giyim_aksesuar = driver.findElement(By.xpath("//a[@title='GİYİM & AKSESUAR']"));
        driver.get(giyim_aksesuar.getAttribute("href"));
        wait(2);

        WebElement kadin_icgiyim = driver.findElement(By.xpath("//a[@title='Kadın İç Giyim']"));
        driver.get(kadin_icgiyim.getAttribute("href"));
        wait(2);


        WebElement diz_alti_corap = driver.findElement(By.xpath("//a[@title='Dizaltı Çorap']"));
        driver.get(diz_alti_corap.getAttribute("href"));
        wait(2);

        WebElement black_filter = driver.findElement(By.xpath("//input[@id='attributes_integration_colourSİYAH']"));
        black_filter.click();
        wait(2);

        WebElement product = driver.findElement(By.xpath("//ul[@class='product-list-general']//a[@class='name-price']"));
        driver.get(product.getAttribute("href"));
        wait(2);

        WebElement add_to_basket= driver.findElement(By.xpath("//button[@class='add-to-basket button green block with-icon js-add-basket']"));
        add_to_basket.click();
        wait(5);

        WebElement show_basket= driver.findElement(By.xpath("//a[@title='Sepeti Görüntüle']"));
        driver.get(show_basket.getAttribute("href"));
        wait(2);

        WebElement confirm_basket = driver.findElement(By.xpath("//a[@class='button green checkout-button block js-checkout-button']"));
        driver.get(confirm_basket.getAttribute("href"));
        wait(2);


        WebElement continue_shopping = driver.findElement(By.xpath("//a[@title='ÜYE OLMADAN DEVAM ET']"));
        continue_shopping.click();
        wait(2);

        WebElement e_mail= driver.findElement(By.xpath("//input[@name='user_email']"));
        e_mail.sendKeys("testcase0321@hotmail.com");
        wait(2);

        WebElement _continue = driver.findElement(By.xpath("//button[@class='button block green']"));
        _continue.click();
        wait(2);

        WebElement add_new_address = driver.findElement(By.xpath("//li[@class='half']//a[@class='new-address js-new-address']"));
        add_new_address.click();
        wait(2);

        WebElement title =  driver.findElement(By.xpath("//input[@name='title']"));
        title.sendKeys("Ev Adresi");


        WebElement first_name= driver.findElement(By.xpath("//input[@name='first_name']"));
        first_name.sendKeys("Ahmet");


        WebElement last_name= driver.findElement(By.xpath("//input[@name='last_name']"));
        last_name.sendKeys("Yılmaz");


        WebElement phone_number= driver.findElement(By.xpath("//input[@name='phone_number']"));
        phone_number.sendKeys("0 (555) 555-5555");


        Select city=  new Select(driver.findElement(By.xpath("//select[@name='city']")));
        city.selectByVisibleText("MUŞ");
        wait(2);

        WebDriverWait XWait = new WebDriverWait(driver, 60);
        XWait.until(ExpectedConditions.elementToBeClickable(By.xpath("//select[@name='township']"))).click();
        List<WebElement> townshipList = driver.findElements(By.xpath("//select[@name='township']//option"));
        WebElement township = findElementByText(townshipList,"VARTO");
        township.click();
        wait(4);


        XWait.until(ExpectedConditions.elementToBeClickable(By.xpath("//select[@name='district']"))).click();
        List<WebElement> districtList = driver.findElements(By.xpath("//select[@name='district']//option"));
        WebElement district = findElementByText(districtList,"AĞAÇKORUR KÖYÜ");
        district.click();
        WebElement address= driver.findElement(By.xpath("//textarea[@class='js-address-textarea']"));


        int leftLimit = 97; // letter 'a'
        int rightLimit = 122; // letter 'z'
        int targetStringLength = 8;
        Random random = new Random();
        StringBuilder buffer = new StringBuilder(targetStringLength);
        for (int i = 0; i < targetStringLength; i++) {
            int randomLimitedInt = leftLimit + (int)
                    (random.nextFloat() * (rightLimit - leftLimit + 1));
            buffer.append((char) randomLimitedInt);
        }
        String generatedString = buffer.toString();


        address.sendKeys("Lorem Ipsum is simply dummy text of the printing and typesetting industry. Lorem Ipsum has been the industry's standard dummy text ever since the 1500s,"+ generatedString);
        wait(2);


        XWait.until(ExpectedConditions.elementToBeClickable(By.xpath("//button[@class='button green address-modal-submit-button js-set-country js-prevent-emoji js-address-form-submit-button']")));
        WebElement save_address = driver.findElement(By.xpath("//button[@class='button green address-modal-submit-button js-set-country js-prevent-emoji js-address-form-submit-button']"));
        save_address.click();
        wait(3);


        XWait.until(ExpectedConditions.elementToBeClickable(By.xpath("//ul[@class='js-shipping-list']//div[@class='check']")));
        WebElement choose_shipping =  driver.findElement(By.xpath("//ul[@class='js-shipping-list']//div[@class='check']"));
        choose_shipping.click();


        WebElement save_and_continue = driver.findElement(By.xpath("//button[@class='button block green js-proceed-button']"));
        save_and_continue.click();
        wait(2);
    }

    public static WebElement findElementByText(List<WebElement> webElements, String text) {
        return webElements
                .stream()
                .filter(webElement -> Objects.equals(webElement.getText(), text))
                .findFirst()
                .orElseThrow(() -> new NoSuchElementException("No WebElement found containing " + text));
    }
    public static  void wait(int second)
    {
        try
        {
            TimeUnit.SECONDS.sleep(second);
        }
        catch(Exception e)
        {
            System.out.println(e);
        }
    }

}
