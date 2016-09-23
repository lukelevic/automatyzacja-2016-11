using OpenQA.Selenium;

namespace TestAutomation.pages
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
            clearAndWriteText(By.Id("user_login"), usr);
            clearAndWriteText(By.Id("user_pass"), pwd);
            click(By.Id("wp-submit"));
            return new AdminPage(driver);
        }
    }
}