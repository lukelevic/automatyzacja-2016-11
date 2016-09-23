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
    internal class Page
    {
        public Page(IWebDriver driver)
        {
            this.driver = driver;
            this.wait = new WebDriverWait(driver,TimeSpan.FromSeconds(15));
        }
        protected IWebDriver driver;
        protected WebDriverWait wait;
    }
    
}