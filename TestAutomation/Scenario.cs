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
                driver = new ChromeDriver(@"C:\Users\Administrator\Downloads\chromedriver_win32");
                baseURL = "https://automatyzacja2016.wordpress.com/wp-admin";
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
            InsertText(By.Id("user_login"), "szkolenieautomatyzacja");
            InsertText(By.Id("user_pass"), "QW12qw12");
            Click(By.Id("wp-submit"));

        }

        protected void InsertText(By by, String text)
        {
            driver.FindElement(by).Clear();
            driver.FindElement(by).SendKeys(text);
        }

        public void Click(By by)
        {
            WebDriverWait Wait = new WebDriverWait(driver, new TimeSpan(0, 0, 10));
            Wait.Until(ExpectedConditions.ElementToBeClickable(by));
            driver.FindElement(by).Click();
        }




        private bool IsElementPresent(By by)
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

        private bool IsAlertPresent()
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

        private string CloseAlertAndGetItsText()
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
