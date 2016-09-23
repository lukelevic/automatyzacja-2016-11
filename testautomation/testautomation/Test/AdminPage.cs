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
    internal class AdminPage :Page
    {
        public AdminPage(IWebDriver driver) : base(driver)
        {
        }

        internal PostPage goToAddNewPostPage()
        {
            driver.FindElement(By.Id("wp-admin-bar-ab-new-post")).Click();
           
            return new PostPage(driver);
        }
    }
}