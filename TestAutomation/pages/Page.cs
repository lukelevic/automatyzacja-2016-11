using OpenQA.Selenium;
using OpenQA.Selenium.Support.UI;
using System;

namespace TestAutomation.pages
{
    public class Page
    {
        protected IWebDriver driver;
        protected string baseURL = "https://automatyzacja2016.wordpress.com";

        public Page(IWebDriver driver)
        {
            this.driver = driver;
        }

        protected void click(By by)
        {
            driver.FindElement(by).Click();
        }
        protected void writeText(By by, String text)
        {
            driver.FindElement(by).Clear();
            driver.FindElement(by).SendKeys(text);
        }
        protected void waitForElementClickable(By by, int seconds)
        {
            WebDriverWait wait = new WebDriverWait(driver, TimeSpan.FromSeconds(seconds));
            wait.Until(ExpectedConditions.ElementToBeClickable(by));
        }
        protected bool isElementVisible(By by)
        {
            WebDriverWait wait = new WebDriverWait(driver, TimeSpan.FromSeconds(1));
            try
            {
                wait.Until(ExpectedConditions.ElementIsVisible(by));
            }
            catch (Exception)
            {
                return false;
            }
            return true;
        }
        public string getPageURL()
        {
            return driver.Url;
        }
    }
}
