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
    class TestPosting : TestScenario

    {

        [Test]
        public void AddPost()
        {
            LoginPage lp = new LoginPage(driver);
            lp.Open();
            MainAdminPage mp = lp.LogIn();

            AddPostPage ap = mp.goToAddNewPostPage();
            mp.AddNewPost(title);

            BlogPage bp = ap.gotoBlogPage();
            bp.assertPostAdded(title);


        }
         public void EditPost()
        {
            LoginPage lp = new LoginPage(driver);
            lp.Open();
            MainAdminPage mp = lp.LogIn();

            AddPostPage ap = mp.goToAddNewPostPage();
            mp.AddNewPost(title);
            EditPost ep = ap.gotoEditPage();
            ep.assertEditPost();


        }

        [TearDown]
        public void TeardownTest()
        {
            try
            {
                driver.Quit();
            }
            catch (Exception) { }
            
        }
    }
}
