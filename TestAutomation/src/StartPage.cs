using OpenQA.Selenium;
using OpenQA.Selenium.Support.UI;
using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;
using TestAutomation;

namespace PageObjectPattern.tests
{
    public class StartPage
    {
        public StartPage(IWebDriver driver)
        {
            this.driver = driver;
        }

        public IWebDriver driver { get; private set; }
        public WebDriverWait wait { get; set; }
           
        protected void click(By by)
        {
            driver.FindElement(by).Click();
        }

        protected void insert(By by, string text)
        {
            driver.FindElement(by).Clear();
            driver.FindElement(by).SendKeys(text);
        }

        protected void openPage(string url)
        {
            driver.Navigate().GoToUrl(url);
            driver.Manage().Window.Maximize();
        }

        protected void waitForElement(IWebDriver driver, By by, int timeout)
        {
            var wait = new WebDriverWait(driver, TimeSpan.FromSeconds(timeout));
            wait.Until(ExpectedConditions.ElementExists(by));
        }
    }
}
