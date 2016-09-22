using System;
using System.Text;
using System.Text.RegularExpressions;
using System.Threading;
using NUnit.Framework;
using OpenQA.Selenium;
using OpenQA.Selenium.Firefox;
using OpenQA.Selenium.Support.UI;
using OpenQA.Selenium.Chrome;

namespace SeleniumTests
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
            driver = new ChromeDriver(@"C:\Users\Administrator\.nuget\packages\Selenium.WebDriver.ChromeDriver\2.24.0\driver");
            baseURL = "https://automatyzacja2016.wordpress.com/wp-admin";
            driver.Manage().Window.Maximize();
            verificationErrors = new StringBuilder();
        }

        [TearDown]
        public void TeardownTest()
        {
            try
            {
                driver.Quit();
            }
            catch (Exception)
            {
                // Ignore errors if unable to close the browser
            }
            Assert.AreEqual("", verificationErrors.ToString());
        }

        public void LogIn()
        {
            driver.Navigate().GoToUrl(baseURL);

            Insert(By.Id("user_login"), "szkolenieautomatyzacja");

            Insert(By.Id("user_pass"), "QW12qw12");

            Click(By.Id("wp-submit"));

        }
        public void LogOut()
        {
            Click(By.XPath("//*[@id=\"wp-admin-bar-my-account\"]/a/img"));
            Click(By.XPath("//*[@id=\"wp-admin-bar-user-info\"]/div/form/button"));
        }


        protected void Click(By by)
        {
            WebDriverWait waitThree = new WebDriverWait(driver, new TimeSpan(
                0, 0, 3));
            waitThree.Until(ExpectedConditions.ElementToBeClickable(by));
            driver.FindElement(by).Click();
        }

        protected void Insert(By by, string v)
        {
            driver.FindElement(by).Clear();
            driver.FindElement(by).SendKeys(v);
        }


        protected bool IsElementPresent(By by)
        {
            try
            {
                driver.FindElement(by);
                return true;
            }
            catch (NoSuchElementException)
            {
                return false;
            }
        }

        protected bool IsAlertPresent()
        {
            try
            {
                driver.SwitchTo().Alert();
                return true;
            }
            catch (NoAlertPresentException)
            {
                return false;
            }
        }

        protected string CloseAlertAndGetItsText()
        {
            try
            {
                IAlert alert = driver.SwitchTo().Alert();
                string alertText = alert.Text;
                if (acceptNextAlert)
                {
                    alert.Accept();
                }
                else
                {
                    alert.Dismiss();
                }
                return alertText;
            }
            finally
            {
                acceptNextAlert = true;
            }
        }
    }
}
        
    
