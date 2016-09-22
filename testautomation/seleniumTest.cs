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
    public class seleniumTest
    {
        private IWebDriver driver;
        private StringBuilder verificationErrors;
        private string baseURL;
        private bool acceptNextAlert = true;

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

        [Test]
        public void TheLoginTest()
        {
            //driver.Navigate().GoToUrl(baseURL + "/wp-login.php?redirect_to=https%3A%2F%2Fautomatyzacja2016.wordpress.com%2Fwp-admin%2F&reauth=1");
            driver.Navigate().GoToUrl(baseURL);

            driver.FindElement(By.Id("user_login")).Clear();
            driver.FindElement(By.Id("user_login")).SendKeys("szkolenieautomatyzacja");
            driver.FindElement(By.Id("user_pass")).Clear();
            driver.FindElement(By.Id("user_pass")).SendKeys("QW12qw12");
            driver.FindElement(By.Id("wp-submit")).Click();
            Thread.Sleep(4000);
            driver.FindElement(By.LinkText("Wpisy")).Click();
           // driver.FindElement(By.XPath("//*[@id=\"menu - posts\"]/a/div[2]")).Click();
            Thread.Sleep(2000);
            //  driver.FindElement(By.XPath("//*[@id=\"wpbody - content\"]/div[3]/h1/a")).Click();
            driver.FindElement(By.LinkText("Dodaj nowy")).Click();
            Thread.Sleep(2000);
            driver.FindElement(By.Name("post_title")).SendKeys("nowy tytul ala" +' '+ DateTime.Now);
            Thread.Sleep(2000);
            //  driver.FindElement(By.Id("tinymce")).SendKeys("jakis tekst");
            driver.FindElement(By.Id("content-html")).Click();
            driver.FindElement(By.Id("content")).SendKeys("raz dwa trzy");
            driver.FindElement(By.Id("publish")).Click();
            Thread.Sleep(2000);
            driver.FindElement(By.XPath("//a[contains(.,'https://automatyzacja2016.wordpress.com/2016/09/22/nowy-tytul-ala')]")).Click();
            //driver.FindElement(By.LinkText("https://automatyzacja2016.wordpress.com/2016/09/22/nowy-tytul-ala4")).Click();
            Thread.Sleep(2000);
           // driver.FindElement(By.XPath("//img[@class='avatar avatar-32']")).Click();
  
           
            driver.FindElement(By.CssSelector("img.avatar.avatar-32")).Click();
            driver.FindElement(By.CssSelector("button.ab-sign-out")).Click();
            Assert.Pass("przeszlo");
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
