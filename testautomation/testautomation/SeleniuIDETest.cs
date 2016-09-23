using System;
using System.Text;
using System.Text.RegularExpressions;
using System.Threading;
using NUnit.Framework;
using OpenQA.Selenium;
using OpenQA.Selenium.Firefox;
using OpenQA.Selenium.Chrome;
using OpenQA.Selenium.Support.UI;

namespace SeleniumTests
{
    [TestFixture]
    public class SeleniuIDETest : Page
    {


        [SetUp]
        public void SetupTest()
        {
            PrepareTest();
        }
        
        [TearDown]
        public void TeardownTest()
        {
            driver.Quit();
        }
        
        [Test]
        public void ShouldAddNewPost()
        {
            // GIVEN 
            string finalString;
            finalString = GenerateRandomName("AM title: ");

            // THEN
            AddPost(finalString);
            Wylogowanie();

            // WHEN
            SzukajWpisu(finalString);
        }

        protected void AddPost(string postText)
        {
            click(By.LinkText("Wpisy"));
            click(By.LinkText("Dodaj nowy"));
            sendKeys(By.Id("title"), postText);
            click(By.Id("publish"));
        }

    }
}
