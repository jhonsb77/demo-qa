package utils;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.HashMap;
import java.util.Map;

public class MyDriverSetup {

    private final Logger log = LoggerFactory.getLogger(MyDriverSetup.class);
    WebDriver driver = null;
    Map<String, Object> prefs = new HashMap<String, Object>();
    FirefoxOptions firefoxOptions = new FirefoxOptions();
    ChromeOptions chromeOptions = new ChromeOptions();


    public WebDriver webChromeDriver() {
        try {
            System.setProperty("webdriver.chrome.driver","C:\\drivers\\chromedriver.exe");
            chromeOptions.addArguments("--incognito");
            chromeOptions.addArguments("--no-sandobox");
            chromeOptions.addArguments("--disable-gpu-sanbox");
            chromeOptions.setExperimentalOption("prefs", prefs);
            driver = new ChromeDriver(chromeOptions);
            driver.manage().window().maximize();
        } catch (Exception e) {
            log.warn("Falló al crear driver desktop chrome");
        }
        return driver;
    }

    public WebDriver webFirefoxDriver() {
        try {
            WebDriverManager.firefoxdriver().setup();
            driver = new FirefoxDriver(firefoxOptions);
            driver.manage().window().maximize();
            firefoxOptions.addArguments("--incognito");
            firefoxOptions.addArguments("--no-sandobox");
            firefoxOptions.addArguments("--disable-gpu-sanbox");
            firefoxOptions.addArguments("--disable-notifications");
        } catch (Exception e) {
            log.warn("Falló al crear driver desktop firefox");
        }
        return driver;
    }
}