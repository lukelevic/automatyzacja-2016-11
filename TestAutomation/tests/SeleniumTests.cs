using System;
using System.Text;
using OpenQA.Selenium;
using OpenQA.Selenium.Chrome;
using NUnit.Framework;
using OpenQA.Selenium.Remote;

namespace TestAutomation.tests
{
    class SeleniumTests
    {
        protected IWebDriver driver;
        protected StringBuilder verificationErrors;
        protected string baseURL;

        [SetUp]
        protected void setupTest()
        {
            driver = new ChromeDriver();
            //DesiredCapabilities caps = new DesiredCapabilities();
            //caps = DesiredCapabilities.Chrome();
            //driver = new RemoteWebDriver(new Uri("http://localhost:4444/hub"), caps);
            driver.Manage().Timeouts().ImplicitlyWait(TimeSpan.FromSeconds(5));
            driver.Manage().Window.Maximize();
            verificationErrors = new StringBuilder();
        }
        [TearDown]
        protected void TeardownTest()
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
