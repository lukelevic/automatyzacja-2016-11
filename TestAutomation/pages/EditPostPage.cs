using OpenQA.Selenium;

namespace TestAutomation.pages
{
    internal class EditPostPage : Page
    {
        public EditPostPage(IWebDriver driver) : base(driver)
        {
        }

        internal string getPermalink()
        {
            return driver.FindElement(By.XPath("//*[@id='sample-permalink']/a")).GetAttribute("href");
        }

        internal PostPage displayPost(string postURL)
        {
            driver.Navigate().GoToUrl(postURL);
            return new PostPage(driver);
        }
    }
}