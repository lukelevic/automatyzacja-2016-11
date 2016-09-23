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
            // given
            Open("https://automatyzacja2016.wordpress.com/wp-admin");
            tryLogIn("szkolenieautomatyzacja", "QW12qw12");

            return new AdminPage(driver);

        }
    }
}