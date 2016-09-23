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
using testautomation.src.main;

namespace testautomation.src.test
{
    class AddBlogPostTest : Scenario
    {
          

        [Test]
        public void ShouldLogIn()
        {
            LoginPage StartPage = new LoginPage(driver);
            AdminPage adminPage = StartPage.LogIn("szkolenieautomatyzacja", "QW12qw12");

            AddPostPage addPost = adminPage.GoToAddPostPage();
            addPost.createPost("Title", "description");
            addPost.Publish();

            BlogPage blogPage = new BlogPage(driver);
            blogPage.contain("Title");
        }



        }


       }

