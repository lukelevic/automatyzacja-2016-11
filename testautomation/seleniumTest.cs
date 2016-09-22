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
        public void ShouldBePossibleToAddNewPost()
        {

            LogIn();

            AddNewPost();

            AssertNewPostAdded();

        }

        private void AssertNewPostAdded()
        {
            Click(By.XPath("//a[contains(.,'https://automatyzacja2016.wordpress.com/2016/09/22/nowy-tytul-ala')]"));


            LogOut();
            Assert.Pass("przeszlo");
        }

        private void AddNewPost()
        {
            Click(By.LinkText("Wpisy"));

            Click((By.LinkText("Dodaj nowy")));

            Insert(By.Name("post_title"), "nowy tytul ala" + ' ' + DateTime.Now);


            Click(By.Id("content-html"));
            Insert(By.Id("content"), "raz dwa trzy");
            Click(By.Id("publish"));
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


        private void Click(By by)
        {
           WebDriverWait waitThree = new WebDriverWait(driver, new TimeSpan(
               0, 0, 3));
           waitThree.Until(ExpectedConditions.ElementToBeClickable(by));
           driver.FindElement(by).Click(); 
        }

        private void Insert(By by, string v)
        {
            driver.FindElement(by).Clear();
            driver.FindElement(by).SendKeys(v);
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
