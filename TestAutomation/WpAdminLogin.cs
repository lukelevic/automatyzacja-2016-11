using System;
using System.Text;
using System.Text.RegularExpressions;
using System.Threading;
using NUnit.Framework;
using OpenQA.Selenium;
using OpenQA.Selenium.Chrome;
using OpenQA.Selenium.Support.UI;

namespace TestAutomation
{
    [TestFixture]
    public class WpAdminLogin
    {
        private IWebDriver driver;
        private StringBuilder verificationErrors;
        private string baseURL;
        private bool acceptNextAlert = true;

        [SetUp]
        public void SetupTest()
        {
            driver = new ChromeDriver();
            driver.Manage().Timeouts().ImplicitlyWait(TimeSpan.FromSeconds(15));
            driver.Manage().Window.Maximize();
            baseURL = "https://automatyzacja2016.wordpress.com/";
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
        public void TheIdeExportTest()
        {
            // login
            driver.Navigate().GoToUrl(baseURL + "/wp-login.php");
            driver.FindElement(By.Id("user_login")).Clear();
            driver.FindElement(By.Id("user_login")).SendKeys("szkolenieautomatyzacja");
            driver.FindElement(By.Id("user_pass")).Clear();
            driver.FindElement(By.Id("user_pass")).SendKeys("QW12qw12");
            driver.FindElement(By.Id("wp-submit")).Click();
            // add post
            String TimeStamp = DateTime.Now.ToString("yyyyMMddHHmmssffff");
            String entryTitle = "Post Rafala M @" + TimeStamp;
            String entryContent = "Dowolny tekst w poście " + TimeStamp;
            driver.FindElement(By.XPath("//*[@id='menu-posts']/a/div[contains(text(),'Wpisy')]")).Click();
            driver.FindElement(By.XPath("//li[@id='menu-posts']//a[contains(text(),'Dodaj nowy')]")).Click();
            //driver.FindElement(By.Id("title")).Click();
            driver.FindElement(By.Id("title")).SendKeys(entryTitle);
            //driver.FindElement(By.Id("content-html")).Click();
            driver.FindElement(By.Id("content")).SendKeys(entryContent);
            Thread.Sleep(1000);
            driver.FindElement(By.Id("publish")).Click();
            String entryPermalink = driver.FindElement(By.XPath("//*[@id='sample-permalink']/a")).Text;
            // logout
            driver.FindElement(By.CssSelector("img.avatar.avatar-32")).Click();
            driver.FindElement(By.CssSelector("button.ab-sign-out")).Click();
            driver.Navigate().GoToUrl(entryPermalink);

            Assert.AreEqual(entryTitle, driver.FindElement(By.ClassName("entry-title")).Text);
            Assert.AreEqual(entryContent, driver.FindElement(By.XPath("//div[@class='entry-content']/p[1]")).Text);
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
