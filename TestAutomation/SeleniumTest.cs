using System;
using System.Text;
using System.Text.RegularExpressions;
using System.Threading;
using NUnit.Framework;
using OpenQA.Selenium;
using OpenQA.Selenium.Firefox;
using OpenQA.Selenium.Support.UI;
using OpenQA.Selenium.Chrome;


namespace SeleniumTests
{
    [TestFixture]
    public class Test1 : Scenario
    {
      

        [Test]
        public void The1Test()
        {
            LogIn();

            AddNewPost();
            AssertPostIsAdded();

        }

        private void AssertPostIsAdded()
        {
            Click(By.XPath("//a[contains(.,'https://automatyzacja2016.wordpress.com/2016/09/22/nowy_wpis-ms')]"));
            Assert.True(driver.PageSource.Contains("nowy_wpis-ms"));
            Click(By.CssSelector("img.avatar.avatar-32"));
            Click(By.CssSelector("button.ab-sign-out"));
        }

        private void AddNewPost()
        {
            Click(By.XPath("//div[@class='wp-menu-image dashicons-before dashicons-admin-post']"));
            Click(By.XPath("//a[@class='page-title-action']"));
            InsertText(By.XPath("//input[@id='title']"), "nowy_wpis-ms");
            Click(By.XPath("//button[contains(.,'Tekstowy')]"));
            InsertText(By.ClassName("wp-editor-area"), "tekst do wpisu");
            Click(By.XPath("//input[@id='publish']"));
        }

 
    }
}
