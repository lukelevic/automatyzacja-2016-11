using System;
using System.Text;
using NUnit.Framework;
using OpenQA.Selenium;
using OpenQA.Selenium.Firefox;

namespace SeleniumTests
{
    [TestFixture]
    public class SeleniumIDE
    {
        private IWebDriver driver;
        private StringBuilder verificationErrors;
        private string baseURL;
        private bool acceptNextAlert = true;
        
        [SetUp]
        public void SetupTest()
        {
            driver = new FirefoxDriver();
            baseURL = "https://wordpress.com/";
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
        
        [Test]
        public void TheSeleniumIDETest()
        {
            driver.Navigate().GoToUrl(baseURL + "/");
            driver.FindElement(By.LinkText("Log In")).Click();
            driver.FindElement(By.Id("user_login")).Clear();
            driver.FindElement(By.Id("user_login")).SendKeys("szkolenieautomatyzacja");
            driver.FindElement(By.Id("user_pass")).Clear();
            driver.FindElement(By.Id("user_pass")).SendKeys("QW12qw12");
            driver.FindElement(By.Id("wp-submit")).Click();
            // ERROR: Caught exception [ERROR: Unsupported command [selectWindow | name=oktab35577322677369017 | ]]
            driver.FindElement(By.CssSelector("span.masterbar__item-content")).Click();
            // ERROR: Caught exception [ERROR: Unsupported command [selectWindow | name=oktab35577322677369017 | ]]
            driver.FindElement(By.CssSelector("img.gravatar")).Click();
            // ERROR: Caught exception [ERROR: Unsupported command [selectWindow | name=oktab35577322677369017 | ]]
            driver.FindElement(By.CssSelector("img.gravatar")).Click();
            // ERROR: Caught exception [ERROR: Unsupported command [selectWindow | name=oktab35577322677369017 | ]]
            driver.FindElement(By.CssSelector("img.gravatar")).Click();
            // ERROR: Caught exception [ERROR: Unsupported command [selectWindow | name=oktab35577322677369017 | ]]
            driver.FindElement(By.CssSelector("svg.gridicon.gridicons-bell  > g > path")).Click();
            // ERROR: Caught exception [ERROR: Unsupported command [selectWindow | name=oktab35577322677369017 | ]]
            driver.FindElement(By.CssSelector("img.gravatar")).Click();
            // ERROR: Caught exception [ERROR: Unsupported command [selectWindow | name=oktab35577322677369017 | ]]
            driver.FindElement(By.CssSelector("svg.gridicon.gridicons-create")).Click();
            // ERROR: Caught exception [ERROR: Unsupported command [selectWindow | name=oktab35577322677369017 | ]]
            driver.FindElement(By.CssSelector("svg.gridicon.gridicons-user-circle")).Click();
            // ERROR: Caught exception [ERROR: Unsupported command [selectWindow | name=oktab35577322677369017 | ]]
            driver.FindElement(By.CssSelector("span.profile-gravatar__edit-label-wrap")).Click();
            // ERROR: Caught exception [ERROR: Unsupported command [selectWindow | name=oktab35577322677369017 | ]]
            driver.FindElement(By.XPath("(//button[@type='button'])[2]")).Click();
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
        
        private string CloseAlertAndGetItsText() {
            try {
                IAlert alert = driver.SwitchTo().Alert();
                string alertText = alert.Text;
                if (acceptNextAlert) {
                    alert.Accept();
                } else {
                    alert.Dismiss();
                }
                return alertText;
            } finally {
                acceptNextAlert = true;
            }
        }
    }
}
