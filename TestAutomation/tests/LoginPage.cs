using System;
using OpenQA.Selenium;

namespace TestAutomation.tests
{
    internal class LoginPage : Page
    {
        public LoginPage(IWebDriver driver) : base(driver)
        {
        }

        internal void openLoginPage()
        {
            driver.Navigate().GoToUrl(baseURL + "/wp-login.php");
        }

        internal AdminPage logIn(string usr, string pwd)
        {
            writeText(By.Id("user_login"), usr);
            writeText(By.Id("user_pass"), pwd);
            click(By.Id("wp-submit"));
            return new AdminPage(driver);
        }
    }
}