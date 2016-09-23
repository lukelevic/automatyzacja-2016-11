using System;
using System.Text;
using System.Text.RegularExpressions;
using System.Threading;
using NUnit.Framework;
using OpenQA.Selenium;
using OpenQA.Selenium.Firefox;
using OpenQA.Selenium.Chrome;
using OpenQA.Selenium.Support.UI;

namespace PageObjectPattern
{
    internal class LoginPage :Page
    {
        public LoginPage(IWebDriver driver) : base(driver)
        {
        }

        internal AdminPage LogIn(string v1, string v2, String baseURL)
        {
            driver.Navigate().GoToUrl(baseURL + "/wp-admin");
            driver.FindElement(By.Id("user_login")).Clear();
            driver.FindElement(By.Id("user_login")).SendKeys(v1);
            driver.FindElement(By.Id("user_pass")).Clear();
            driver.FindElement(By.Id("user_pass")).SendKeys(v2);
            driver.FindElement(By.Id("wp-submit")).Click();
            return new AdminPage(driver);
        }
    }
}