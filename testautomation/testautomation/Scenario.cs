using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;
using NUnit.Framework;
using OpenQA.Selenium;
using OpenQA.Selenium.Firefox;
using OpenQA.Selenium.Support.UI;
using OpenQA.Selenium.Chrome;

namespace SeleniumTest
{
    public class Scenario
    {
        protected IWebDriver driver;
        protected StringBuilder verificationErrors;
        protected string baseURL;
        protected bool acceptNextAlert = true;

        [SetUp]
        public void SetupTest()
        {
            // driver = new FirefoxDriver()
            driver = new ChromeDriver();
            driver.Manage().Window.Maximize();
            baseURL = "https://automatyzacja2016.wordpress.com/wp-admin";
            verificationErrors = new StringBuilder();
        }
        protected void Open(String baseURL)
        {
            driver.Navigate().GoToUrl(baseURL);
        }


        protected void tryLogIn(String login, String password)
        {
            InsertText(By.Id("user_login"), login);
            InsertText(By.Id("user_pass"), password);
            click(By.Id("wp-submit"));
        }

        protected void click(By by)
        {
            driver.FindElement(by).Click();
        }


        protected void InsertText(By by, String text)
        {
            driver.FindElement(by).Clear();
            driver.FindElement(by).SendKeys(text);
        }

        protected void WaitForElement(By by)
        {
            new WebDriverWait(driver, TimeSpan.FromSeconds(10)).Until(ExpectedConditions.ElementToBeClickable(by));
        }

        protected void logOut()
        {
            click(By.Id("wp-admin-bar-my-account"));
            driver.FindElement(By.CssSelector("button.ab-sign-out")).Click();
        }
        [TearDown]
        public void TearDown()
        {
            driver.Quit();
        }

    }
}
