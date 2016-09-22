using System;
using System.Text;
using NUnit.Framework;
using OpenQA.Selenium;
using OpenQA.Selenium.Firefox;
using OpenQA.Selenium.Chrome;
using Microsoft.VisualStudio.TestTools.UnitTesting;

namespace SeleniumTests
{
    [TestFixture]
    public class SeleniumIDE
    {
        private IWebDriver driver;
        private StringBuilder verificationErrors;
        private string baseURL;
        private bool acceptNextAlert = true;

        public ITimeouts wait { get; private set; }

        [SetUp]
        public void SetupTest()
        {
            driver = new ChromeDriver(@"C:\repozytorium\automatyzacja-2016-11\");
            baseURL = "https://automatyzacja2016.wordpress.com/wp-admin";
            wait = driver.Manage().Timeouts().ImplicitlyWait(TimeSpan.FromSeconds(10));

            driver.Navigate().GoToUrl(baseURL);
            driver.Manage().Window.Maximize();

            driver.FindElement(By.Id("user_login")).Click();
            driver.FindElement(By.Id("user_login")).Clear();
            driver.FindElement(By.Id("user_login")).SendKeys("szkolenieautomatyzacja");
            driver.FindElement(By.Id("user_pass")).Clear();
            driver.FindElement(By.Id("user_pass")).SendKeys("QW12qw12");
            driver.FindElement(By.Id("wp-submit")).Click();

            //verificationErrors = new StringBuilder();
        }
        
        [TearDown]
        public void TeardownTest()
        {
            driver.Close();
        }
        [Test]
        public void shouldAddNewPost()
        {
       
            driver.FindElement(By.Id("title")).SendKeys("nowy post jejeje");
            driver.FindElement(By.Id("content")).SendKeys("jejeje");
            driver.FindElement(By.Id("save-post")).Click();
            
        }
        [Test]
        public void checkIfPostAdded()
        {
            driver.FindElement(By.ClassName("view-all")).Click();

            NUnit.Framework.Assert.AreEqual(true, driver.PageSource.Contains("nowy post jejeje"));
                        
        }
        
    }

    
        //[Test]
        //public void TheSeleniumIDETest()
        //{
            
        //    //logowanie
        //    driver.Navigate().GoToUrl(baseURL + "/");
        //    driver.FindElement(By.LinkText("Log In")).Click();
        //    driver.FindElement(By.Id("user_login")).Clear();
        //    driver.FindElement(By.Id("user_login")).SendKeys("szkolenieautomatyzacja");
        //    driver.FindElement(By.Id("user_pass")).Clear();
        //    driver.FindElement(By.Id("user_pass")).SendKeys("QW12qw12");
        //    driver.FindElement(By.Id("wp-submit")).Click();

        //    driver.FindElement(By.ClassName("ab-item")).Click();


        //    // ERROR: Caught exception [ERROR: Unsupported command [selectWindow | name=oktab35577322677369017 | ]]
        //   // driver.FindElement(By.CssSelector("span.masterbar__item-content")).Click();
                 
        //    // ERROR: Caught exception [ERROR: Unsupported command [selectWindow | name=oktab35577322677369017 | ]]
        //   // driver.FindElement(By.XPath("(//button[@type='button'])[2]")).Click();
        //}
        //private bool IsElementPresent(By by)
        //{
        //    try
        //    {
        //        driver.FindElement(by);
        //        return true;
        //    }
        //    catch (NoSuchElementException)
        //    {
        //        return false;
        //    }
        //}
        
        //private bool IsAlertPresent()
        //{
        //    try
        //    {
        //        driver.SwitchTo().Alert();
        //        return true;
        //    }
        //    catch (NoAlertPresentException)
        //    {
        //        return false;
        //    }
        //}
        
        //private string CloseAlertAndGetItsText() {
        //    try {
        //        IAlert alert = driver.SwitchTo().Alert();
        //        string alertText = alert.Text;
        //        if (acceptNextAlert) {
        //            alert.Accept();
        //        } else {
        //            alert.Dismiss();
        //        }
        //        return alertText;
        //    } finally {
        //        acceptNextAlert = true;
        //    }
        //}
}

