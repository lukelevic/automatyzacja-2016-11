using System;
using System.Text;
using System.Text.RegularExpressions;
using System.Threading;
using NUnit.Framework;
using OpenQA.Selenium;
using OpenQA.Selenium.Firefox;
using OpenQA.Selenium.Support.UI;
using OpenQA.Selenium.Chrome;

namespace TestAutomation.Test
{
    internal class Page
    {
        protected IWebDriver driver;
        protected string baseURL = "https://automatyzacja2016.wordpress.com/";
        public Page(IWebDriver driver)
        { 
        this.driver = driver;
        }

        protected void Click(By by)
        {
            
            WebDriverWait Wait = new WebDriverWait(driver, new TimeSpan(0, 0, 10));
            Wait.Until(ExpectedConditions.ElementToBeClickable(by));
            driver.FindElement(by).Click();
        }

        protected void InsertText(By by, string text)
        {
            
            driver.FindElement(by).Clear();
            driver.FindElement(by).SendKeys(text);
        }
    }
}
