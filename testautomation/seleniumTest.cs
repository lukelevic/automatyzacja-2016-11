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
    public class seleniumTest : Scenario
    {
        [Test]
        public void ShouldBePossibleToAddNewPost()
        {   //given
            LogIn();
            //when
            AddNewPost();
            //then
            AssertNewPostAdded();
         }
        private void AssertNewPostAdded()
         {
            Click(By.XPath("//a[contains(.,'https://automatyzacja2016.wordpress.com/2016/09/23/nowy-tytul-ala')]"));
            LogOut();
            Assert.Pass("przeszlo");
         }
        private void AddNewPost()
         {
            Click(By.LinkText("Wpisy"));
            Click((By.LinkText("Dodaj nowy")));
            Insert(By.Name("post_title"), "nowy tytul ala" + ' ' + DateTime.Now);
            Click(By.Id("content-html"));
            Insert(By.Id("content"), "raz dwa trzy");
            Click(By.Id("publish"));
         }
     }
}
