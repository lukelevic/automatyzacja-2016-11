package com.example.tests;

import java.text.SimpleDateFormat;
import java.util.concurrent.TimeUnit;
import org.junit.*;
import java.util.Calendar;


import org.openqa.selenium.*;
import org.openqa.selenium.By;
import org.openqa.selenium.chrome.ChromeDriver;


public class SeleniumAddPostAndCheckTest {
    private WebDriver driver;
    private String baseUrl;
    private boolean acceptNextAlert = true;
    private StringBuffer verificationErrors = new StringBuffer();

    @Before
    public void setUp() throws Exception {
        //driver = new FirefoxDriver();
        System.setProperty("webdriver.chrome.driver", "bin/chromedriver.exe");
        driver = new ChromeDriver();
        baseUrl = "https://automatyzacja2016.wordpress.com/";
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
    }

    @Test
    public void testSeleniumJunit() throws Exception {
        //Logowanie
        driver.get(baseUrl + "/");
        driver.get(baseUrl + "/wp-login.php");
        driver.findElement(By.id("user_login")).clear();
        driver.findElement(By.id("user_login")).sendKeys("szkolenieautomatyzacja");
        driver.findElement(By.id("user_pass")).clear();
        driver.findElement(By.id("user_pass")).sendKeys("QW12qw12");
        driver.findElement(By.id("wp-submit")).click();
        driver.manage().window().maximize();
        //Zalogowany

        //Wpisy
        driver.findElement(By.xpath("//*[@id=\"menu-posts\"]/a/div[2]")).click();

        //Dodaj wpis
        driver.findElement(By.xpath("//*[@id=\"wpbody-content\"]/div[3]/h1/a")).click();

        Calendar calendar = Calendar.getInstance();
        java.util.Date now = calendar.getTime();
        java.sql.Timestamp currentTimestamp = new java.sql.Timestamp(now.getTime());
        String napis_tytul = "Lorem Ipsum MichalJanuszS_";
        String currentTimestamp_string = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(currentTimestamp);
        String tytul = napis_tytul + currentTimestamp_string;

        driver.findElement(By.xpath("//*[@id=\"title\"]")).sendKeys(tytul);

        driver.findElement(By.xpath("//*[@id=\"content\"]")).click();
        driver.findElement(By.xpath("//*[@id=\"content\"]")).sendKeys("Niech nie utrudniają Proszę państwa, aktualna struktura organizacji powoduje docenianie wag dalszych kierunków postępowego wychowania. Do tej decyzji skłonił mnie fakt, że rozszerzenie bazy o nowe rekordy spełnia istotną rolę w określaniu systemu przedstawia interpretującą próbę sprawdzenia kolejnych kroków w przyszłościowe rozwiązania powoduje docenianie wag form oddziaływania. Do tej decyzji skłonił mnie fakt, że zawiązanie koalicji zmusza nas do przeanalizowania kolejnych kroków w przyszłościowe rozwiązania koliduje z tym, dalszy rozwój różnych form działalności zabezpiecza udział szerokiej grupie w restrukturyzacji przedsiębiorstwa. Wagi i rozwijanie struktur powoduje docenianie wag modelu rozwoju. Często błędnie postrzeganą sprawą jest to, iż rozpoczęcie powszechnej akcji kształtowania podstaw wymaga niezwykłej precyzji w określaniu dalszych poczynań. Troska organizacji, a szczególnie rozszerzenie bazy o nowe rekordy koliduje z tym, że rozszerzenie naszej działalności powoduje docenianie wag modelu rozwoju. Często niezauważanym szczegółem jest ważne zadanie w kształtowaniu systemu finansowego rozszerza nam efekt kierunków rozwoju. Z drugiej strony, zakończenie tego projektu przedstawia interpretującą próbę sprawdzenia kolejnych kroków w określaniu form oddziaływania. Natomiast nowy model działalności organizacyjnej spełnia ważne zadanie w kształtowaniu istniejących kryteriów koliduje z dotychczasowymi zasadami kierunków rozwoju. Nie muszę.");

        driver.findElement(By.xpath("//*[@id=\"in-category-1680071\"]")).click();


        //Publikuj
        driver.findElement(By.xpath("//*[@id=\"publish\"]")).click();

        // Strona główna
        driver.findElement(By.xpath("//*[@id=\"wp-admin-bar-blog\"]/a")).click();
        driver.findElement(By.xpath("//*[@id=\"wp-admin-bar-view-site\"]/a")).click();


        driver.findElement(By.linkText(tytul));
        Assert.assertEquals(tytul,driver.findElement(By.linkText(tytul)).getText());

        driver.findElement(By.linkText(tytul)).click();
        Assert.assertEquals(tytul,driver.findElement(By.linkText(tytul)).getText());



        //Wylogowywanie
        //driver.findElement(By.cssSelector("img.avatar.avatar-32")).click();
        //driver.findElement(By.cssSelector("button.ab-sign-out")).click();
        //driver.findElement(By.xpath("//*[@id=\"wp-admin-bar-user-info\"]/div/form/button")).click();
        driver.quit();
    }
}