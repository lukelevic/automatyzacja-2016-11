//package com.example.tests;

        import com.thoughtworks.selenium.Selenium;
        import org.junit.Assert;
        import org.openqa.selenium.By;
                import org.openqa.selenium.chrome.ChromeDriver;
        import org.openqa.selenium.chrome.ChromeOptions;
        import org.openqa.selenium.firefox.FirefoxDriver;
                import org.openqa.selenium.WebDriver;
                import com.thoughtworks.selenium.webdriven.WebDriverBackedSelenium;
                import org.junit.After;
                import org.junit.Before;
                import org.junit.Test;
                import static org.junit.Assert.*;

        import java.text.DateFormat;
        import java.text.SimpleDateFormat;
        import java.util.Calendar;
        import java.util.concurrent.TimeUnit;
        import java.util.regex.Pattern;
        import static org.apache.commons.lang3.StringUtils.join;
        import java.sql.Timestamp;
        import java.util.Date;

public class wpisTest {
    private WebDriver driver;
    private String baseUrl;
    private boolean acceptNextAlert = true;
    private StringBuffer verificationErrors = new StringBuffer();
    private String title;
    private String description;
    private Date data;
private String reportDate;
    private String ddd;
    @Before
    public void setUp() throws Exception {


        System.setProperty("webdriver.chrome.driver", "./chromedriver.exe");

        ChromeOptions options = new ChromeOptions();
        options.addArguments("--start-maximized");
        driver = new ChromeDriver( options );

        //driver = new ChromeDriver();
        //WebDriver driver = new FirefoxDriver();
        baseUrl = "https://automatyzacja2016.wordpress.com/";
        // selenium = new WebDriverBackedSelenium(driver, baseUrl);
        driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
        java.util.Date date= new java.util.Date();
        data =  new Timestamp(date.getTime());
       // System.out.println(data);



        String reportDate = data.toString();
        ddd = reportDate + " seba";
        System.out.println(ddd);


        description = "opis";



    }

    @Test
    public void testIde() throws Exception {
       // driver.manage().window().maximize();

        driver.get(baseUrl + "/");
        driver.get(baseUrl + "/wp-login.php");

        driver.findElement(By.xpath(".//*[@id='user_login']")).clear();
        driver.findElement(By.xpath(".//*[@id='user_login']")).sendKeys("szkolenieautomatyzacja");
        driver.findElement(By.xpath(".//*[@id='user_pass']")).clear();
        driver.findElement(By.xpath(".//*[@id='user_pass']")).sendKeys("QW12qw12");
        driver.findElement(By.id("wp-submit")).click();
       // driver.findElement(By.cssSelector("img.avatar.avatar-32")).click();
        driver.findElement(By.xpath(".//*[@id='menu-posts']/a/div[3]")).click();
        driver.findElement(By.xpath(".//*[@id='menu-posts']/ul/li[3]/a")).click();
        //driver.findElement(By.xpath(".//*[@id='title-prompt-text']")).clear();

        driver.findElement(By.id("title")).sendKeys(ddd);
       // driver.findElement(By.xpath(".//*[@id='tinymce']")).clear();
        driver.findElement(By.id("content-html")).click();
        driver.findElement(By.id("content")).sendKeys(description);
        driver.findElement(By.xpath(".//*[@id='publish']")).click();
        driver.findElement(By.xpath(".//*[@id='menu-posts']/a/div[3]")).click();
        driver.findElement(By.xpath("//*[@id='post-search-input']")).sendKeys(ddd);
        driver.findElement(By.id("search-submit")).click();
       //String element =  driver.findElement(By.xpath("//a[@class='row-title']")).getTagName("ariel-label");
        Assert.assertTrue(driver.getPageSource().contains(ddd));

    }

    @After
    public void tearDown() throws Exception {
        driver.quit();
        String verificationErrorString = verificationErrors.toString();
        if (!"".equals(verificationErrorString)) {
            fail(verificationErrorString);
        }
    }
}

