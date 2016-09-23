using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;
using NUnit.Framework;
using TestAutomation;
using OpenQA.Selenium;

namespace PageObjectPattern.tests
{
    class PageObjectPatternTest : NewScenario

    {

        [Test]
        public void shouldAddNewPost()
        {
            //given
            string userName = "szkolenieautomatyzacja";
            string password = "QW12qw12";
            string title = "nowy post";
            string content = "content";

            LoginPage lp = new LoginPage(driver);

            //when
            MainPage mp = lp.login(userName,password);
            mp.createNewPost(title,content);
            mp.publishPost();

            //then
            AllPostsPage app = mp.clickViewAllPosts();
            Assert.AreEqual(true,app.searchPost(title));
        }

        [Test, Sequential]
        public void shouldNotLogInWithIncorrectCredentials(
            [Values("user1", "user2", "user3")] string userName,
            [Values("password1", "password2", "password3")] string password)
        {
            LoginPage lp = new LoginPage(driver);
            lp.login(userName, password);

            Assert.AreEqual(true, lp.searchForElement(By.Id("login_error")));
        }


                
        //    bool result = checkIfLoggedIn();
        //    Assert.AreEqual(expectedResult, result);
        //}

        //[Test]
        //public void shouldAddCommentToPost()
        //{

        //}
        // add koment to post
        // create user

    }
}
