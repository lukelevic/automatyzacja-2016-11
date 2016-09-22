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

namespace AddNewComment
{
    [TestFixture]
    public class AddNewComment
    {
        private IWebDriver driver;
        private StringBuilder verificationErrors;
        private string baseURL;
        private bool acceptNextAlert = true;

        [SetUp]
        public void SetupTest()
        {
            // driver = new FirefoxDriver()
            driver = new ChromeDriver();
            driver.Manage().Window.Maximize();
            baseURL = "https://automatyzacja2016.wordpress.com/";
            verificationErrors = new StringBuilder();
        }
        [Test]
        public void AddNewCommentTest()
        {
            driver.Navigate().GoToUrl("https://automatyzacja2016.wordpress.com/wp-admin");
            driver.FindElement(By.Id("user_login")).Clear();
            driver.FindElement(By.Id("user_login")).SendKeys("szkolenieautomatyzacja");
            driver.FindElement(By.Id("user_pass")).Clear();
            driver.FindElement(By.Id("user_pass")).SendKeys("QW12qw12");
            driver.FindElement(By.Id("wp-submit")).Click();
            driver.FindElement(By.XPath("//*[@id=\"menu-posts\"]/a")).Click();
            driver.FindElement(By.XPath("//*[@id=\"wpbody-content\"]/div[3]/h1/a")).Click();
            driver.FindElement(By.Name("post_title")).SendKeys("my Title");
            driver.FindElement(By.Id("content")).SendKeys("my comment");
            driver.FindElement(By.Id("publish")).Click();
            driver.Navigate().GoToUrl(baseURL);
            Assert.True(driver.PageSource.Contains("my Title"));
        }
        


    }
}
   