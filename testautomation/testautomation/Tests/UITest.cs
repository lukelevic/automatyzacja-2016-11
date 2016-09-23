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

namespace testautomation.Tests
{
    class UITest : Scenarios
    {
        [Test]
        public void ShouldAddNewPostNew()
        {
            // GIVEN 
            string finalString;
            finalString = PageAbss.GenerateRandomName("AM title: ");

            LoginPage lp = new LoginPage(driver, wait);
            AdminPage ap = lp.Login("szkolenieautomatyzacja", "QW12qw12");

            // THEN
            ap.AddPost(finalString);
            WordPressPage wpp = ap.Logout(driver);

            // WHEN
            Assert.IsTrue(wpp.SearchPost(finalString));
        }

        
        [Test, Sequential]
        public void SholudFailLogginWithWrongCredentials([Values("XXX", "YYY")] string _login,
            [Values("YYY", "XXX")] string _pass)
        {
            //GIVEN
            LoginPage lp = new LoginPage(driver, wait);

            //THEN
            AdminPage ap = lp.Login(_login, _pass);

            //WHEN
            Assert.IsNull(ap);
        }

        [Test]
        public void ShouldAddComment()
        {
            //GIVEN
            WordPressPage wpp = new WordPressPage(driver, wait);

            //THEN
            IWebElement addComment = wpp.findElement(By.LinkText("Dodaj komentarz"));
            
            addComment.Click();

            //WHEN
            try
            {
                wpp.sendKeys(By.Id("comment"), "new comment AM");
                driver.FindElement(By.Id("comment")).SendKeys(Keys.Tab + "a@a.pl");
                driver.FindElement(By.Id("comment")).SendKeys(Keys.Tab + Keys.Tab + "AM sign");
                Assert.IsTrue(true);
            }
            catch
            {
                Assert.IsTrue(false);
            }

        }


    }
}
