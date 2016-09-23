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
    internal class EditPost : Page

    {
        public EditPost(IWebDriver driver) : base(driver)
        {
            Click(By.XPath("//button[contains(.,'Tekstowy')]"));
            InsertText(By.ClassName("wp-editor-area"), "nowy nowy tekst do wpisu");
            Click(By.XPath("//input[@id='publish']"));
            Thread.Sleep(3000);
        }

        internal void assertEditPost()
        {
            Click(By.XPath("//div[@class='wp-menu-image dashicons-before dashicons-admin-post']"));
            Assert.True(driver.PageSource.Contains("nowy nowy tekst do wpisu"));
        }
    }
}