using OpenQA.Selenium;
using OpenQA.Selenium.Firefox;
using OpenQA.Selenium.Chrome;
using OpenQA.Selenium.Support.UI;
using System;

namespace testautomation.Tests
{
    public class LoginPage : PageAbss
    {
        public string URLAdminPage = "https://automatyzacja2016.wordpress.com/wp-admin";

        public LoginPage(IWebDriver driver, WebDriverWait wait) : base(driver, wait)
        {

        }

        public AdminPage Login(string login, string pass)
        {
            driver.Navigate().GoToUrl(URLAdminPage);
            sendKeys(By.Id("user_login"), login);
            sendKeys(By.Id("user_pass"), pass);
            click(By.Id("wp-submit"));

            if (IsElementVisible(By.Id("login_error"))){
                return null;
            }
            return new AdminPage(driver, wait);
        }


    }
}