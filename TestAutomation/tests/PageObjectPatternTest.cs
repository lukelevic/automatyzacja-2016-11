using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;
using NUnit.Framework;
using TestAutomation;

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
    }
}
