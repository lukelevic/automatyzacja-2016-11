using OpenQA.Selenium;

namespace TestAutomation.pages
{
    internal class AddPostPage : Page
    {
        public AddPostPage(IWebDriver driver) : base(driver)
        {
        }

        internal void addNewPost(string title, string content)
        {
            clearAndWriteText(By.Id("title"), title);
            clearAndWriteText(By.Id("content"), content);
        }

        internal EditPostPage publishPost()
        {
            waitForElementClickable(By.XPath("//*[@id='sample-permalink']/a"), 5);
            click(By.Id("publish"));
            return new EditPostPage(driver);
        }
    }
}