using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;
using NUnit.Framework;
using OpenQA.Selenium;
using OpenQA.Selenium.Chrome;
using OpenQA.Selenium.Support.UI;

namespace TestAutomation
{
    public class WordpressTestBase
    {
        protected IWebDriver driver;
        protected StringBuilder verificationErrors;
        protected string baseURL;

        [SetUp]
        protected void SetupTest()
        {
            setup();
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
        protected void setup()
        {
            driver = new ChromeDriver();
            driver.Manage().Timeouts().ImplicitlyWait(TimeSpan.FromSeconds(5));
            driver.Manage().Window.Maximize();
            baseURL = "https://automatyzacja2016.wordpress.com";
            verificationErrors = new StringBuilder();
        }
        protected void waitForElementPresent(By by, int seconds)
        {
            WebDriverWait wait = new WebDriverWait(driver, TimeSpan.FromSeconds(seconds));
            wait.Until(ExpectedConditions.ElementToBeClickable(by));
        }

        protected void tryLogin(String userName, String passWord)
        {
            driver.Navigate().GoToUrl(baseURL + "/wp-login.php");
            writeText(By.Id("user_login"), userName);
            writeText(By.Id("user_pass"), passWord);
            click(By.Id("wp-submit"));
        }
        protected void tryLogout()
        {
            try
            {
                driver.FindElement(By.CssSelector("img.avatar.avatar-32")).Click();
                driver.FindElement(By.CssSelector("button.ab-sign-out")).Click();
            }
            catch (Exception)
            {
                // ignore logout error
            }
        }
        protected void click(By by)
        {
            driver.FindElement(by).Click();
        }
        protected void writeText(By by, String text)
        {
            driver.FindElement(by).Clear();
            driver.FindElement(by).SendKeys(text);
        }
        protected void assertTextInElement(string expectedText, By by)
        {
            Assert.AreEqual(expectedText, driver.FindElement(by).Text);
        }
        protected bool checkUrlIsCorrect(string expectedPath)
        {
            return (baseURL + expectedPath).Equals(driver.Url, StringComparison.Ordinal);
        }
    }
}
