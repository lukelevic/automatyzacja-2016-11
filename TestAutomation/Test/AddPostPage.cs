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
    internal class AddPostPage : Page
    {
        public AddPostPage(IWebDriver driver) : base(driver)
        {
        }

        internal BlogPage gotoBlogPage()
        {
            Click(By.XPath("//div[@class='wp-menu-image dashicons-before dashicons-admin-post']"));
            return new BlogPage(driver);
        }
    }
}