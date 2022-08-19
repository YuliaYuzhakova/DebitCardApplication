package ru.netilogy.web;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.jupiter.api.*;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import java.util.List;


public class DebitCardTest {
    private WebDriver driver;

    @BeforeAll
    public static void setupAll() {
        WebDriverManager.chromedriver().setup();
    }

    @BeforeEach
    public void setup() {
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--disable-dev-shm-usage");
        options.addArguments("--no-sandbox");
        options.addArguments("--headless");
        driver = new ChromeDriver(options);
        driver.get("http://localhost:9999");
    }

    @AfterEach
    public void close() {
        driver.quit();
        driver = null;
    }


    @Test
    void debitCardTest1() {
        List<WebElement> elements = driver.findElements(By.className("input__control"));
        elements.get(0).sendKeys("Дмитрий Мамин-Сибиряк");
        elements.get(1).sendKeys("+79135504488");
        driver.findElement(By.cssSelector("[data-test-id=\"agreement\"]")).click();
        driver.findElement(By.className("button_view_extra")).click();
        String text = driver.findElement(By.cssSelector("[data-test-id=\"order-success\"]")).getText();
        Assertions.assertEquals("Ваша заявка успешно отправлена! Наш менеджер свяжется с вами в ближайшее время.", text.trim());
    }

    @Test
    void debitCardTest2() {
        driver.findElement(By.cssSelector("[data-test-id=\"name\"] input")).sendKeys("Дмитрий Мамин-Сибиряк");
        driver.findElement(By.cssSelector("[data-test-id=\"phone\"] input")).sendKeys("+79135504488");
        driver.findElement(By.cssSelector("[data-test-id=\"agreement\"]")).click();
        driver.findElement(By.className("button_view_extra")).click();
        String text = driver.findElement(By.cssSelector("[data-test-id=\"order-success\"]")).getText();
        Assertions.assertEquals("Ваша заявка успешно отправлена! Наш менеджер свяжется с вами в ближайшее время.", text.trim());
    }
}
