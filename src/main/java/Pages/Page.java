package Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

/**
 * Created by Administrator on 2016-09-23.
 */
public class Page {
    protected WebDriver driver;
    protected String  baseUrl = "https://automatyzacja2016.wordpress.com/";


    public Page(WebDriver driver) {
        this.driver= driver;
    }

    protected void xpathSendKeyTitle(String xpathExpression,  String title) {
        WebDriverWait waitN = new WebDriverWait(driver, 6);
        waitN.until(ExpectedConditions.elementToBeClickable(By.xpath(xpathExpression)));
        driver.findElement(By.xpath(xpathExpression)).sendKeys(title);
    }




    protected void click(By xpath) {
        WebDriverWait wait = new WebDriverWait(driver, 3);
        wait.until(ExpectedConditions.elementToBeClickable(xpath));
        driver.findElement(xpath).click();
    }

    protected void insert(By login, String text) {
        driver.findElement(login).clear();
        driver.findElement(login).sendKeys(text);
    }











}
