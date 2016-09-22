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
    public class SeleniumTest :Scenario
    {
       
        [Test]
        public void shouldAddNewPost()
        {
            LoginIn("szkolenieautomatyzacja", "QW12qw12");

            AddPost("test");

            LogOut();
            AssertPostExistsWithTitle("test");

        }
        protected void AssertPostExistsWithTitle(String text)
        {
            driver.Navigate().GoToUrl(baseURL);
            Assert.NotNull(wait.Until<IWebElement>(d => d.FindElement(By.LinkText(text))));
        }
    }
}
