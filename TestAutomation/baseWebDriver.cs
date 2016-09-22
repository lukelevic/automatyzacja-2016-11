using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;
using OpenQA.Selenium.Chrome;
using OpenQA.Selenium;
using NUnit.Framework;

namespace TestAutomation
{
    public class baseWebDriver
    {
        protected IWebDriver driver;

        protected void addPost(string title, string content)
        {
            driver.FindElement(By.Id("title")).SendKeys(title);
            driver.FindElement(By.Id("content")).SendKeys(content);
            driver.FindElement(By.Id("save-post")).Click();
        }

        protected void checkIfLoggedIn()
        {
            driver.PageSource.Contains("Kokpit");
        }

        protected void login(string userName, string password)
        {

            driver.FindElement(By.Id("user_login")).Click();
            driver.FindElement(By.Id("user_login")).Clear();
            driver.FindElement(By.Id("user_login")).SendKeys(userName);
            driver.FindElement(By.Id("user_pass")).Clear();
            driver.FindElement(By.Id("user_pass")).SendKeys(password);
            driver.FindElement(By.Id("wp-submit")).Click();
        }

        protected void LogOut()
        {
            driver.FindElement(By.ClassName("avatar avatar-32")).Click();
            driver.FindElement(By.ClassName("ab-sign-out")).Click();
        }
        protected void openPage(string url)
        {
            driver.Navigate().GoToUrl(url);
            driver.Manage().Window.Maximize();
        }
       

        protected void click(By by)
        {
            driver.FindElement(by).Click();
        }

        protected void insert(By by, string text)
        {
            driver.FindElement(by).Clear();
            driver.FindElement(by).SendKeys(text);
        }

        [SetUp]
        protected void setupTest()
        {
            driver = new ChromeDriver(@"C:\repozytorium\automatyzacja-2016-11\");
            driver.Navigate().GoToUrl("https://automatyzacja2016.wordpress.com/wp-admin");
            driver.Manage().Window.Maximize();
            login("szkolenieautomatyzacja", "QW12qw12");
        }

        [TearDown]
        public void TeardownTest()
        {

            driver.Close();
        }
    }
}
