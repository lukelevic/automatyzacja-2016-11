using OpenQA.Selenium;

namespace TestAutomation.pages
{
    internal class AdminPage : Page
    {
        public AdminPage(IWebDriver driver) : base(driver)
        {
        }

        internal AddPostPage goToAddNewPost()
        {
            click(By.XPath("//*[@id='menu-posts']/a/div[contains(text(),'Wpisy')]"));
            click(By.XPath("//li[@id='menu-posts']//a[contains(text(),'Dodaj nowy')]"));
            return new AddPostPage(driver);
        }

        internal bool isUserLoggedIn()
        {
            return isElementVisible(By.Id("wp-admin-bar-my-account"));
        }
    }
}