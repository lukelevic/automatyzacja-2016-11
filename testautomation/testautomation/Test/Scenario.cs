using System;
using System.Text;
using System.Text.RegularExpressions;
using System.Threading;
using NUnit.Framework;
using OpenQA.Selenium;
using OpenQA.Selenium.Firefox;
using OpenQA.Selenium.Chrome;
using OpenQA.Selenium.Support.UI;

namespace PageObjectPattern
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

    }  
}