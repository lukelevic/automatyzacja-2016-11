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


    }
}
