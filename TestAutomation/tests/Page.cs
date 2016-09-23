using OpenQA.Selenium;
using OpenQA.Selenium.Chrome;
using OpenQA.Selenium.Support.UI;
using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace TestAutomation.tests
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
        protected void waitForElementPresent(By by, int seconds)
        {
            WebDriverWait wait = new WebDriverWait(driver, TimeSpan.FromSeconds(seconds));
            wait.Until(ExpectedConditions.ElementToBeClickable(by));
        }
        public string getPageURL()
        {
            return driver.Url;
        }
    }
}
