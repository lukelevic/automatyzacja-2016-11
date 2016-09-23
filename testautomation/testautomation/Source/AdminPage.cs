using System;
using OpenQA.Selenium;
using OpenQA.Selenium.Firefox;
using OpenQA.Selenium.Chrome;
using OpenQA.Selenium.Support.UI;

namespace testautomation.Tests
{
    public class AdminPage : PageAbss
    {

        public AdminPage(IWebDriver driver, WebDriverWait wait) : base(driver, wait)
        {
 
        }

        public void AddPost(string postText)
        {
            click(By.LinkText("Wpisy"));
            click(By.LinkText("Dodaj nowy"));
            sendKeys(By.Id("title"), postText);
            click(By.Id("publish"));
        }

        public WordPressPage Logout(IWebDriver driver)
        {
            click(By.ClassName("avatar-32"));
            click(By.ClassName("ab-sign-out"));
            return new WordPressPage(driver, wait);
        }
    }
}