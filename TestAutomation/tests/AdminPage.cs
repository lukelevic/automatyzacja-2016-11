using System;
using OpenQA.Selenium;

namespace TestAutomation.tests
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
    }
}