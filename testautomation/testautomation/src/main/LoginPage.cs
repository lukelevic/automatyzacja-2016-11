using System;
using OpenQA.Selenium;

namespace testautomation.src.main
{
    internal class LoginPage : Page
    {
        public LoginPage(IWebDriver myDriver) : base(myDriver)
        {
        }

        internal AdminPage LogIn(string v1, string v2)
        {
            throw new NotImplementedException();
        }
    }
}