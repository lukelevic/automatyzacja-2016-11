using System;
using OpenQA.Selenium;

namespace PageObjectPattern.tests
{
    internal class AllPostsPage : Page
    {
        public AllPostsPage(IWebDriver driver) : base(driver)
        {
        }

        internal bool searchPost(string title)
        {
            if (driver.PageSource.Contains(title)) return true;
            else return false;
        }
    }
}