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
    [TestFixture]
    public class TestSelenium : Scenario
    {
       
        [Test]
        public void shouldAddNewPost()
        {
           
            LoginPage lp = new LoginPage(driver);
            AdminPage ap = lp.LogIn("szkolenieautomatyzacja", "QW12qw12", baseURL);
            PostPage pp = ap.goToAddNewPostPage();

            pp.AddPost("test");
            pp.LogOut();
            BlogPage bp = new BlogPage(driver);
            bp.AssertPostExistsWithTitle("test");
        }       
    }  
}
