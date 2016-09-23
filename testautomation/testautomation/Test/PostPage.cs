using System;
using System.Text;
using System.Text.RegularExpressions;
using System.Threading;
using NUnit.Framework;
using OpenQA.Selenium;
using OpenQA.Selenium.Firefox;
using OpenQA.Selenium.Chrome;
using OpenQA.Selenium.Support.UI;

namespace PageObjectPattern
{
    internal class PostPage :Page
    {
        public PostPage(IWebDriver driver) : base(driver)
        {
        }

        internal void AddPost(string v)
        {
           
            driver.FindElement(By.ClassName("editor-title__input")).SendKeys(v);
            WebDriverWait wait = new WebDriverWait(driver, TimeSpan.FromSeconds(10));
            wait.Until(ExpectedConditions.ElementToBeClickable(By.ClassName("editor-ground-control__publish-button")));
            driver.FindElement(By.ClassName("editor-ground-control__publish-button")).Click();
        }

        internal void LogOut()
        {
            Thread.Sleep(2000);
            driver.FindElement(By.ClassName("masterbar__item-me")).Click();
            driver.FindElement(By.ClassName("me-sidebar__signout-button")).Click();
        }
    }
}