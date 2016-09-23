using System;
using OpenQA.Selenium;

namespace testautomation.src.main
{
    internal class AdminPage : Page
    {
        public AdminPage(IWebDriver myDriver) : base(myDriver)
        {
        }

        internal AddPostPage GoToAddPostPage()
        {
            throw new NotImplementedException();
        }
    }
}