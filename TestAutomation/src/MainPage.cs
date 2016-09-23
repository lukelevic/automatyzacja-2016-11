using OpenQA.Selenium;
using System;


namespace PageObjectPattern.tests
{
    internal class MainPage : Page
    {
        public MainPage(IWebDriver driver) : base(driver)
        {
        }

        internal void publishPost()
        {
            click((By.Id("save-post")));
        }

        
        internal void createNewPost(string title, string content)
        {
            insert(By.Id("title"), title);
            insert(By.Id("content"), content);
        }

        internal AllPostsPage clickViewAllPosts()
        {
            click(By.ClassName("view-all"));
            return new AllPostsPage(driver);
        }
    }
}