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
    [TestFixture]
    public class Test1
    {
        private IWebDriver driver;
        private StringBuilder verificationErrors;
        private string baseURL;
        private bool acceptNextAlert = true;

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

        [Test]
        public void The1Test()
        {
            //driver.Navigate().GoToUrl(baseURL + "/wp-login.php?redirect_to=https%3A%2F%2Fautomatyzacja2016.wordpress.com%2Fwp-admin%2F&reauth=1");
            driver.Navigate().GoToUrl(baseURL);
            driver.FindElement(By.Id("user_login")).Clear();
            driver.FindElement(By.Id("user_login")).SendKeys("szkolenieautomatyzacja");
            driver.FindElement(By.Id("user_pass")).Clear();
            driver.FindElement(By.Id("user_pass")).SendKeys("QW12qw12");
            driver.FindElement(By.Id("wp-submit")).Click();
            Thread.Sleep(3000);
            driver.FindElement(By.XPath("//div[@class='wp-menu-image dashicons-before dashicons-admin-post']")).Click();
            Thread.Sleep(3000);
            driver.FindElement(By.XPath("//a[@class='page-title-action']")).Click();
            Thread.Sleep(3000);
            driver.FindElement(By.XPath("//input[@id='title']")).SendKeys("nowy_wpis-ms");
            Thread.Sleep(3000);
            driver.FindElement(By.XPath("//button[contains(.,'Tekstowy')]")).Click();
            driver.FindElement(By.ClassName("wp-editor-area")).SendKeys("tekst do wpisu");
            driver.FindElement(By.XPath("//input[@id='publish']")).Click();
            Thread.Sleep(3000);
            driver.FindElement(By.XPath("//a[contains(.,'https://automatyzacja2016.wordpress.com/2016/09/22/nowy_wpis-ms')]")).Click();
            Assert.True(driver.PageSource.Contains("nowy_wpis-ms"));
            Thread.Sleep(300);
            driver.FindElement(By.CssSelector("img.avatar.avatar-32")).Click();
            Thread.Sleep(3000);
            driver.FindElement(By.CssSelector("button.ab-sign-out")).Click();
            
            
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
