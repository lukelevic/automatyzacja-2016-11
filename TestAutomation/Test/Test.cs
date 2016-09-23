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
    class TestPosting

    {
        private ChromeDriver driver;
        private string baseURL;
        private string title;

        [SetUp]
        public void SetupTest()
        {
            driver = new ChromeDriver(@"C:\Users\Administrator\Downloads\chromedriver_win32");
            title = ("nowy_wpis-ms");
        }

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
    }
}
