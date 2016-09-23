using System;
using OpenQA.Selenium;

namespace PageObjectPattern.tests
{
    internal class LoginPage : StartPage
    {

        public LoginPage(IWebDriver driver) : base(driver)
        {
        }

        internal MainPage login(string userName, string password)
        {
            click(By.Id("user_login"));
            insert(By.Id("user_login"), userName);
            insert(By.Id("user_pass"), password);
            click(By.Id("wp-submit"));

            return new MainPage(driver);
        }

        internal bool searchForElement(By by)
        {
            bool present;
            try
            {
                driver.FindElement(by);
                present = true;
            }
            catch (NoSuchElementException e)
            {
                present = false;
            }
            return present;
        }
    }
}


