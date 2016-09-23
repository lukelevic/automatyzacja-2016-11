using System;
using OpenQA.Selenium;
using NUnit.Framework;

namespace testautomation.src.main
{
    internal class BlogPage : Page
    {
      
        
        public BlogPage(IWebDriver myDriver) : base(myDriver)
        {
        }

        internal void contain(string v)
        {
            Open("https://automatyzacja2016.wordpress.com");
            Assert.IsTrue(driver.PageSource.Contains("Title"));
        }
    }
}