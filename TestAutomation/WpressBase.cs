using NUnit.Framework;
using OpenQA.Selenium;
using OpenQA.Selenium.Chrome;
using OpenQA.Selenium.Support.UI;
using System;
using System.Text;

namespace SeleniumTests
{
    public class WpressBase
    {
        protected IWebDriver driver;
        protected StringBuilder verificationErrors;
        protected string baseURL;
        protected bool acceptNextAlert = true;

        [SetUp]
        public void SetupTest()
        {
            driver = new ChromeDriver();
            driver.Manage().Window.Maximize();
            baseURL = "https://automatyzacja2016.wordpress.com/wp-admin";
            verificationErrors = new StringBuilder();

            //LogIn();
        }

        [TearDown]
        public void TeardownTest()
        {
            LogOut();

            try
            {
                driver.Quit();
            }
            catch (Exception)
            {
                
            }
        }
        
        protected void InsertTextBy(By by, string text)
        {
            driver.FindElement(by).Clear();
            driver.FindElement(by).SendKeys(text);
        }

        protected void ClickBy(By by, int timeout)
        {
            var wait = new WebDriverWait(driver, TimeSpan.FromSeconds(timeout));
            var element = wait.Until(ExpectedConditions.ElementToBeClickable(by));
            element.Click();
        }

        protected void GoToUrl(string baseUrl)
        {
            driver.Navigate().GoToUrl(baseURL);
        }

        protected void LogIn(string login = "szkolenieautomatyzacja", string pass = "QW12qw12")
        {
            GoToUrl(baseURL);
            InsertTextBy(By.Id("user_login"), login);
            InsertTextBy(By.Id("user_pass"), pass);
            ClickBy(By.Id("wp-submit"), 5);
        }

        protected void LogOut()
        {
            var wait = new WebDriverWait(driver, TimeSpan.FromSeconds(5));
            var element = wait.Until(ExpectedConditions.ElementToBeClickable(By.CssSelector("img.avatar.avatar-32")));
            element.Click();

            element = wait.Until(ExpectedConditions.ElementToBeClickable(By.CssSelector("button.ab-sign-out")));
            element.Click();
        }
    }
}