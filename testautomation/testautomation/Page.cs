using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;
using NUnit.Framework;
using OpenQA.Selenium;
using OpenQA.Selenium.Firefox;
using OpenQA.Selenium.Chrome;
using OpenQA.Selenium.Support.UI;

namespace SeleniumTests
{
    public class Page
    {
        public WebDriverWait wait;
        public IWebDriver driver;
        public string baseURL, baseURLAdmin;

        public void PrepareTest()
        {
            driver = new ChromeDriver();
            driver.Manage().Window.Maximize();
            wait = new WebDriverWait(driver, TimeSpan.FromSeconds(15));
            baseURL = "https://automatyzacja2016.wordpress.com";
            baseURLAdmin = "https://automatyzacja2016.wordpress.com/wp-admin";
            driver.Navigate().GoToUrl(baseURLAdmin);
            Logowanie("szkolenieautomatyzacja", "QW12qw12");
        }
        protected void EndTest()
        {

        }
        public void click(By by)
        {
            wait.Until<IWebElement>(d => d.FindElement(by)).Click();
        }
        protected void sendKeys(By by, string text)
        {
            wait.Until<IWebElement>(d => d.FindElement(by)).Click();
            wait.Until<IWebElement>(d => d.FindElement(by)).SendKeys(text);
        }
        protected void Logowanie(string login, string pass)
        {
            sendKeys(By.Id("user_login"), login);
            sendKeys(By.Id("user_pass"), pass);
            click(By.Id("wp-submit"));
        }
        protected void Wylogowanie()
        {
            click(By.ClassName("avatar-32"));
            click(By.ClassName("ab-sign-out"));
        }
        protected void SzukajWpisu(string SzukanyWpis)
        {
            driver.Navigate().GoToUrl(baseURL);
            Assert.NotNull(wait.Until<IWebElement>(d => d.FindElement(By.LinkText(SzukanyWpis))));
        }
        protected string GenerateRandomName(string name)
        {
            var chars = "ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz0123456789";
            var stringChars = new char[16];
            var random = new Random();

            for (int i = 0; i < 6; i++)
            {
                stringChars[i] = chars[random.Next(chars.Length)];
            }

            var tmp = new String(stringChars);
            return name + tmp;
        }
    }
}
