using System;
using System.Text;
using System.Text.RegularExpressions;
using System.Threading;
using NUnit.Framework;
using OpenQA.Selenium;
using OpenQA.Selenium.Firefox;
using OpenQA.Selenium.Chrome;
using OpenQA.Selenium.Support.UI;

namespace SeleniumTests
{
    public class Scenario
    {
        protected IWebDriver driver;
        protected String baseURL;
        protected StringBuilder verificationErrors;
        protected bool acceptNextAlert = false;
        protected WebDriverWait wait;
        [SetUp]
        public void Setup()
        {
            //driver = new FirefoxDriver();
            driver = new ChromeDriver();
            driver.Manage().Window.Maximize();
            driver.Manage().Timeouts().ImplicitlyWait(TimeSpan.FromSeconds(30));
            baseURL = "https://automatyzacja2016.wordpress.com/";
            verificationErrors = new StringBuilder();

            wait = new WebDriverWait(driver, TimeSpan.FromSeconds(10));

        }

        [TearDown]
        public void Teardown()
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
        protected void LoginIn(String login, String password)
        {
            driver.Navigate().GoToUrl(baseURL + "/wp-login.php?redirect_to=https%3A%2F%2Fautomatyzacja2016.wordpress.com%2Fwp-admin%2F&reauth=1");
            driver.FindElement(By.Id("user_login")).Clear();
            driver.FindElement(By.Id("user_login")).SendKeys(login);
            driver.FindElement(By.Id("user_pass")).Clear();
            driver.FindElement(By.Id("user_pass")).SendKeys(password);
            driver.FindElement(By.Id("wp-submit")).Click();
        }

        protected void AddPost(String text)
        {
            driver.FindElement(By.Id("wp-admin-bar-ab-new-post")).Click();
            driver.FindElement(By.ClassName("editor-title__input")).SendKeys(text);
            WebDriverWait wait = new WebDriverWait(driver, TimeSpan.FromSeconds(10));
            wait.Until(ExpectedConditions.ElementToBeClickable(By.ClassName("editor-ground-control__publish-button")));
            driver.FindElement(By.ClassName("editor-ground-control__publish-button")).Click();
        }

        protected void LogOut()
        {
            Thread.Sleep(2000);
            driver.FindElement(By.ClassName("masterbar__item-me")).Click();
            driver.FindElement(By.ClassName("me-sidebar__signout-button")).Click();
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
