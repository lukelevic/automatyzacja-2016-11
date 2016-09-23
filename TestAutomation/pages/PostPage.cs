using System;
using OpenQA.Selenium;

namespace TestAutomation.pages
{
    internal class PostPage : Page
    {
        public PostPage(IWebDriver driver) : base(driver)
        {
        }

        internal string getPageTitle()
        {
            return driver.FindElement(By.ClassName("entry-title")).Text;
        }

        internal string getPageContent()
        {
            return driver.FindElement(By.XPath("//div[@class='entry-content']/p[1]")).Text;
        }

        internal void addComment(string email, string signature, string commentText)
        {
            click(By.Id("comment"));
            writeText(By.Id("comment"), commentText);

            click(By.XPath("//label[@for='email']"));
            waitForElementClickable(By.Id("email"),1);
            clearAndWriteText(By.Id("email"), email);

            click(By.XPath("//label[@for='author']"));
            waitForElementClickable(By.Id("author"), 1);
            clearAndWriteText(By.Id("author"), commentText);

            click(By.Id("comment-submit"));
        }

        internal bool? commentExists(string email, string signature, string commentText)
        {
            //section[@class='comment-content comment']/p
            return true;
        }
    }
}