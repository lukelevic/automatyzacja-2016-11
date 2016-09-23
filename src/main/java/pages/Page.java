package pages;

import org.openqa.selenium.WebDriver;

public abstract class Page {
    protected WebDriver driver;
    public String baseUrl = "https://automatyzacja2016.wordpress.com/";


    public Page(WebDriver driver) {
        this.driver = driver;
    }

}
