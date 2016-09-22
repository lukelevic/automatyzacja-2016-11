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
    [TestFixture]
    public class SeleniuIDETest
    {
        private IWebDriver driver;
        private StringBuilder verificationErrors;
        private string baseURL, baseURLAdmin;
        private bool acceptNextAlert = true;
        WebDriverWait wait;
        string finalString;

        [SetUp]
        public void SetupTest()
        {
            //driver = new FirefoxDriver();
            driver = new ChromeDriver();
            driver.Manage().Window.Maximize();
            wait = new WebDriverWait(driver, TimeSpan.FromSeconds(15));
            baseURL = "https://automatyzacja2016.wordpress.com";
            baseURLAdmin = "https://automatyzacja2016.wordpress.com/wp-admin";
            verificationErrors = new StringBuilder();

            finalString = GenerateRandomName("AM title: ");
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
        public void SholudAddNewPost()
        {
            driver.Navigate().GoToUrl(baseURLAdmin);
            Logowanie("szkolenieautomatyzacja", "QW12qw12");
            AddPost("Teksat AM");
            Wylogowanie();
            SzukajWpisu(finalString);
        }

        private void Logowanie(string login, string pass)
        {
            driver.FindElement(By.Id("user_login")).Click();
            driver.FindElement(By.Id("user_login")).Clear();
            driver.FindElement(By.Id("user_login")).SendKeys(login);
            driver.FindElement(By.Id("user_pass")).Clear();
            driver.FindElement(By.Id("user_pass")).SendKeys(pass);
            driver.FindElement(By.Id("wp-submit")).Click();
        }
        private void AddPost(string postText)
        {
            wait.Until<IWebElement>(d => d.FindElement(By.LinkText("Wpisy"))).Click();
            wait.Until<IWebElement>(d => d.FindElement(By.LinkText("Dodaj nowy"))).Click();
            wait.Until<IWebElement>(d => d.FindElement(By.Id("title"))).SendKeys(finalString);
            wait.Until<IWebElement>(d => d.FindElement(By.Id("publish"))).Click();
        }
        private void Wylogowanie()
        {
            wait.Until<IWebElement>(d => d.FindElement(By. ClassName("avatar-32"))).Click();
            wait.Until<IWebElement>(d => d.FindElement(By.ClassName("ab-sign-out"))).Click();
        }
        private void SzukajWpisu(string SzukanyWpis)
        {
            driver.Navigate().GoToUrl(baseURL);
            Assert.NotNull(wait.Until<IWebElement>(d => d.FindElement(By.LinkText(SzukanyWpis))));
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
        private string GenerateRandomName(string name)
        {
            var chars = "ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz0123456789";
            var stringChars = new char[14];
            var random = new Random();

            for (int i = 0; i < 6; i++)
            {
                stringChars[i] = chars[random.Next(chars.Length)];
            }

            var tmp = new String(stringChars);
            return name + tmp;
        }
    }
}
