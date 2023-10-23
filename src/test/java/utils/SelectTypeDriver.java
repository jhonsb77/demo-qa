package utils;

import net.serenitybdd.core.Serenity;
import net.thucydides.core.webdriver.DriverSource;
import org.openqa.selenium.WebDriver;

public class SelectTypeDriver implements DriverSource {

    private static final String NAVEGADOR_ACTUAL="firefox";
    WebDriver driver;
    public WebDriver seleccionarTipoDriver() {
        MyDriverSetup myDriverSetup = new MyDriverSetup();
        switch (NAVEGADOR_ACTUAL.trim().toLowerCase()){
            case "firefox":
                Serenity.recordReportData().withTitle("Navegador").andContents("Firefox");
                driver = myDriverSetup.webFirefoxDriver();
                break;
            default:
                Serenity.recordReportData().withTitle("Navegador").andContents("Chrome");
                driver = myDriverSetup.webChromeDriver();
                break;
        }

        return driver;
    }

    @Override
    public WebDriver newDriver() {
        return seleccionarTipoDriver();
    }

    @Override
    public boolean takesScreenshots() {
        return true;
    }

}
