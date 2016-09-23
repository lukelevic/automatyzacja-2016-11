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
    internal class BlogPage :Page
    {
        public BlogPage(IWebDriver driver) : base(driver)
        {
        }

        internal void AssertPostExistsWithTitle(string v)
        {
            driver.Navigate().GoToUrl("https://automatyzacja2016.wordpress.com/");
            Assert.NotNull(wait.Until<IWebElement>(d => d.FindElement(By.LinkText(v))));
        }
    }
}