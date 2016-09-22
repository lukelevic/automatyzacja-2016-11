package com.example.tests;

import org.junit.After;
import org.junit.Before;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.concurrent.TimeUnit;

public class WordpressScenario {
    protected WebDriver driver;
    protected String baseUrl;

    @Before
    public void Setup() throws Exception {
        System.setProperty("webdriver.chrome.driver", "bin/chromedriver.exe");
        driver = new ChromeDriver();
        baseUrl = "https://automatyzacja2016.wordpress.com/";
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
    }

    public void KliknijXpath(String xpath) {
        driver.findElement(By.xpath(xpath)).click();
    }

    public void KliknijCss(String css) {
        driver.findElement(By.cssSelector(css)).click();
    }
    public void KliknijSelector(String selector){
        driver.findElement(By.id(selector)).click();
    }

    public void WstawTekst(By gdzie, String tekst) {
        driver.findElement(gdzie).sendKeys(tekst);
    }

    public void WstawTekstXpath(String Xpath, String tekst) {
        WstawTekst(By.xpath(Xpath),tekst);
    }
    public void WstawTekstKlasa(String klasa, String tekst) {
        WstawTekst(By.className(klasa),tekst);
    }

    public String GetTitleWithCurrentDate(String tytul) {
        Calendar calendar = Calendar.getInstance();
        java.util.Date now = calendar.getTime();
        java.sql.Timestamp currentTimestamp = new java.sql.Timestamp(now.getTime());
        String currentTimestamp_string = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(currentTimestamp);
        return tytul + currentTimestamp_string;
    }

    public void LogujSie() {
        driver.get(baseUrl + "/");
        driver.get(baseUrl + "/wp-admin");

        //when
        driver.findElement(By.id("user_login")).clear();
        WstawTekst(By.id("user_login"), "szkolenieautomatyzacja");
        driver.findElement(By.id("user_pass")).clear();
        WstawTekst(By.id("user_pass"), "QW12qw12");
        driver.findElement(By.id("wp-submit")).click();
        driver.manage().window().maximize();

    }
    @After
    public void ZamknijOknoPrzegladarki(){
        //Wylogowywanie
        driver.get(baseUrl + "/wp-admin");
        KliknijCss("img.avatar.avatar-32");
        WebDriverWait wait = new WebDriverWait(driver, 10);

        KliknijXpath("//*[@id=\"wp-admin-bar-user-info\"]/div/form/button");
        driver.quit();
    }
}
