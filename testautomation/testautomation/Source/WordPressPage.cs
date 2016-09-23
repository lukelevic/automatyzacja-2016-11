using OpenQA.Selenium;
using OpenQA.Selenium.Firefox;
using OpenQA.Selenium.Chrome;
using OpenQA.Selenium.Support.UI;
using System;

namespace testautomation.Tests
{
    public class WordPressPage : PageAbss
    {
        public string URLMainPage = "https://automatyzacja2016.wordpress.com";

        public WordPressPage(IWebDriver driver, WebDriverWait wait) : base(driver, wait)
        {

            driver.Navigate().GoToUrl(URLMainPage);
        }

        public bool SearchPost(string SzukanyWpis)
        {
            try {
                wait.Until<IWebElement>(d => d.FindElement(By.LinkText(SzukanyWpis)));
            }
            catch
            {
                return false;
            }
            return true;
        }
    }
}