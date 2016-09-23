using System;
using System.Text;
using System.Text.RegularExpressions;
using System.Threading;
using NUnit.Framework;
using OpenQA.Selenium;
using OpenQA.Selenium.Firefox;
using OpenQA.Selenium.Support.UI;
using OpenQA.Selenium.Chrome;

namespace TestAutomation.Test
{
    internal class LoginPage : Page
    {

        public LoginPage(IWebDriver driver) : base(driver)
        {

        }
        internal void Open()
        {
            driver.Navigate().GoToUrl(baseURL + "wp-admin");
        }
        internal MainAdminPage LogIn()
        {
            InsertText(By.Id("user_login"), "szkolenieautomatyzacja");
            InsertText(By.Id("user_pass"), "QW12qw12");
            Click(By.Id("wp-submit"));
            return new MainAdminPage(driver);
        }


    }
}