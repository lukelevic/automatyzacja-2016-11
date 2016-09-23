using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;
using NUnit.Framework;
using OpenQA.Selenium;
using OpenQA.Selenium.Firefox;
using OpenQA.Selenium.Support.UI;
using OpenQA.Selenium.Chrome;

namespace testautomation.src.test
{
    class AddBlogPostTest
    {
        [Test]
        public void ShouldLogIn()
        {
            LoginPage StartPage = new LoginPage(driver);
            AdminPage adminPage = StartPage.LogIn("szkolenieautomatyzacja", "QW12qw12");

            AddPostPage addPost = adminPage.GoToAddPostPage();
            addPost.createPost("Title", "description");
            addPost.Publish();
            addPostPage.LogOut();
            BlogPage blogPage = new BlogPage(driver);
            Assert.IsTrue(BP.contain("Title");
                  

            
        }
    }
}
