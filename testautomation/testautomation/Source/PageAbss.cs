using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;
using NUnit.Framework;
using OpenQA.Selenium;
using OpenQA.Selenium.Firefox;
using OpenQA.Selenium.Chrome;
using OpenQA.Selenium.Support.UI;

namespace testautomation.Tests
{
    public class PageAbss
    {
        protected WebDriverWait wait;
        protected IWebDriver driver;
        public PageAbss(IWebDriver driver, WebDriverWait wait)
        {
            this.driver = driver;
            this.wait = wait;
        }

        public static string GenerateRandomName(string nameprefix)
        {
            var chars = "ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz0123456789";
            var stringChars = new char[16];
            var random = new Random();

            for (int i = 0; i < 6; i++)
            {
                stringChars[i] = chars[random.Next(chars.Length)];
            }

            var tmp = new String(stringChars);
            return nameprefix + tmp;
        }
        public void click(By by)
        {
            wait.Until<IWebElement>(d => d.FindElement(by)).Click();
        }
        public void sendKeys(By by, string text)
        {
            //wait.Until<IWebElement>(d => d.FindElement(by)).Click();
            wait.Until<IWebElement>(ExpectedConditions.ElementToBeClickable(by)).Click();
            wait.Until<IWebElement>(d => d.FindElement(by)).SendKeys(text);
        }
    }
}
