using System;
using OpenQA.Selenium;

namespace TestAutomation.tests
{
    internal class AddPostPage : Page
    {
        public AddPostPage(IWebDriver driver) : base(driver)
        {
        }

        internal void addNewPost(string title, string content)
        {
            writeText(By.Id("title"), title);
            writeText(By.Id("content"), content);
        }

        internal EditPostPage publishPost()
        {
            waitForElementPresent(By.XPath("//*[@id='sample-permalink']/a"), 5);
            click(By.Id("publish"));
            return new EditPostPage(driver);
        }
    }
}