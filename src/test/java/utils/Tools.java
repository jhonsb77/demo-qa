package utils;

import net.serenitybdd.core.pages.PageObject;
import net.serenitybdd.core.pages.WebElementFacade;
import org.openqa.selenium.Alert;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Wait;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.ArrayList;

public class Tools extends PageObject {

    public String validarAlerta() {
        String print="";
        try{
            Wait<WebDriver> wait = new WebDriverWait(getDriver(), Duration.ofSeconds(2));
            wait.until(ExpectedConditions.alertIsPresent());
            Alert alert = getDriver().switchTo().alert();
            print = alert.getText();
            alert.accept();
            return print;
        }catch (Exception e){
            e.printStackTrace();
            return print;
        }
    }


    public void scrollElement(WebElementFacade element){
        explicitWait(element);
        JavascriptExecutor js = (JavascriptExecutor) getDriver();
        js.executeScript("arguments[0].scrollIntoView(true);", element);
    }

    public void scrollPixel(String x, String y){
        JavascriptExecutor js = (JavascriptExecutor) getDriver();
        js.executeScript("window.scrollBy("+x+","+y+")");
    }

    public void explicitWait(WebElementFacade element){
        try{
            withTimeoutOf(Duration.ofSeconds(10)).waitFor(element).isClickable();
        }catch (Exception e){
            System.out.println("No se pudo localizar el elemento "+element);
        }
    }

    public void javaScriptClick(WebElementFacade element){
        explicitWait(element);
        ((JavascriptExecutor) this.getDriver()).executeScript("arguments[0].click();",
                element);
    }

    public void moveElement(WebElementFacade element){
        Actions actions = new Actions(getDriver());
        actions.moveToElement(element).build().perform();
    }

    public void scrollFooter(){
        JavascriptExecutor js = (JavascriptExecutor) getDriver();
        js.executeScript("window.scrollTo(0, document.body.scrollHeight)");
    }

}
