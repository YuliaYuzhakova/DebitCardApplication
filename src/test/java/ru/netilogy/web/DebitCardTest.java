package ru.netilogy.web;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class DebitCardTest {

    private WebDriver driver;

    @BeforeAll
    static void setUp1 (){
        System.setProperty("webdriver.chrome.driver", "driver/win/chromedriver.exe");
    }

    @BeforeEach
    void setUp2(){
        driver = new ChromeDriver();
    }

    @AfterEach
    public void close(){
        driver.quit();
        driver = null;
    }

}
