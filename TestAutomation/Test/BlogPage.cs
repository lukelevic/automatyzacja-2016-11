using System;
using System.Text;
using System.Text.RegularExpressions;
using System.Threading;
using NUnit.Framework;
using OpenQA.Selenium;
using OpenQA.Selenium.Firefox;
using OpenQA.Selenium.Support.UI;
using OpenQA.Selenium.Chrome;


namespace TestAutomation.Test
{
    internal class BlogPage : Page
    {
        public BlogPage(IWebDriver driver) : base(driver)
        {
        }

        internal void assertPostAdded(object title)
        {

            //Click(By.XPath("//a[contains(.,'https://automatyzacja2016.wordpress.com/2016/09/22/nowy_wpis-ms')]"));
            //Click(By.XPath("//a[@aria-label='“nowy_wpis-ms” (Edit)']"));
            Assert.True(driver.PageSource.Contains("nowy_wpis-ms"));
            Click(By.CssSelector("img.avatar.avatar-32"));
            Click(By.CssSelector("button.ab-sign-out"));
        }
    }
}