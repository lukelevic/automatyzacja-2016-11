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
    }
}