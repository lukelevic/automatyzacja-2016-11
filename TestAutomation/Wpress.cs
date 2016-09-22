using System;
using System.Text;
using NUnit.Framework;
using OpenQA.Selenium;
using OpenQA.Selenium.Chrome;
using System.Threading;
using OpenQA.Selenium.Interactions;

namespace SeleniumTests
{
    [TestFixture]
    public class Wpress
    {
        private IWebDriver driver;
        private StringBuilder verificationErrors;
        private string baseURL;
        private bool acceptNextAlert = true;

        [SetUp]
        public void SetupTest()
        {
            driver = new ChromeDriver();

            driver.Manage().Window.Maximize();

            baseURL = "https://automatyzacja2016.wordpress.com/wp-admin";
            verificationErrors = new StringBuilder();
        }

        [TearDown]
        public void TeardownTest()
        {
            try
            {
               // driver.Quit();
            }
            catch (Exception)
            {
                // Ignore errors if unable to close the browser
            }
            Assert.AreEqual("", verificationErrors.ToString());
        }

        [Test]
        public void TheWpressTest()
        {
            driver.Navigate().GoToUrl(baseURL);
            driver.FindElement(By.Id("user_login")).Clear();
            driver.FindElement(By.Id("user_login")).SendKeys("szkolenieautomatyzacja");
            driver.FindElement(By.Id("user_pass")).Clear();
            driver.FindElement(By.Id("user_pass")).SendKeys("QW12qw12");
            driver.FindElement(By.Id("wp-submit")).Click();
            Thread.Sleep(2000);
            driver.FindElement(By.CssSelector("img.avatar.avatar-32")).Click();
            driver.FindElement(By.CssSelector("button.ab-sign-out")).Click();
        }

        [Test]
        public void TheWpressAddNewPost()
        {
            driver.Navigate().GoToUrl(baseURL);

            driver.FindElement(By.Id("user_login")).Clear();
            driver.FindElement(By.Id("user_login")).SendKeys("szkolenieautomatyzacja");
            driver.FindElement(By.Id("user_pass")).Clear();
            driver.FindElement(By.Id("user_pass")).SendKeys("QW12qw12");
            driver.FindElement(By.Id("wp-submit")).Click();
            Thread.Sleep(2000);
            driver.FindElement(By.LinkText("Wpisy")).Click();
            // driver.FindElement(By.XPath("//*[@id=\"menu - posts\"]/a/div[2]")).Click();
            Thread.Sleep(2000);
            //  driver.FindElement(By.XPath("//*[@id=\"wpbody - content\"]/div[3]/h1/a")).Click();
            driver.FindElement(By.LinkText("Dodaj nowy")).Click();
            Thread.Sleep(2000);

            var title = "adaml" + DateTime.Now;
            driver.FindElement(By.Name("post_title")).SendKeys(title);
            Thread.Sleep(2000);
            //  driver.FindElement(By.Id("tinymce")).SendKeys("jakis tekst");
            driver.FindElement(By.Id("publish")).Click();
            Thread.Sleep(2000);

            var linkByTitle = "https://automatyzacja2016.wordpress.com/2016/09/22/" ;
            driver.FindElement(By.XPath("//a[contains(.,'" +linkByTitle+ "')]")).Click();
            Assert.Pass("przeszlo");
            
            driver.FindElement(By.CssSelector("img.avatar.avatar-32")).Click();
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
