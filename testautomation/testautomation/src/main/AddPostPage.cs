using System;
using OpenQA.Selenium;

namespace testautomation.src.main
{
    internal class AddPostPage : Page
    {
        public AddPostPage(IWebDriver myDriver) : base(myDriver)
        {
        }

        internal void createPost(string v1, string v2)
        {
           
            click(By.XPath("//*[@id=\"wpbody-content\"]/div[3]/h1/a"));
            InsertText(By.Name("post_title"), "Title");
            InsertText(By.Id("content"), "description");

           
        }

        internal void Publish()
        {
            WaitForElement(By.Id("publish"));
            click(By.Id("publish"));
        }
    }
}