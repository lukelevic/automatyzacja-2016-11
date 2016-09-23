using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;
using NUnit.Framework;
using OpenQA.Selenium;
using OpenQA.Selenium.Firefox;
using OpenQA.Selenium.Support.UI;
using OpenQA.Selenium.Chrome;


namespace testautomation.src.test
{
    class Scenario
    {
        protected IWebDriver driver;
        protected StringBuilder verificationErrors;
        protected string baseURL;
        protected bool acceptNextAlert = true;

        [SetUp]
        public void SetupTest()
        {
            // driver = new FirefoxDriver()
            driver = new ChromeDriver();
            driver.Manage().Window.Maximize();
            baseURL = "https://automatyzacja2016.wordpress.com/wp-admin";
            verificationErrors = new StringBuilder();
        }
        [TearDown]
        public void TearDown()
        {
            driver.Quit();
        }
    }
}
