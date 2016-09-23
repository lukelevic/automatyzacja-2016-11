using NUnit.Framework;
using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;
using TestAutomation.pages;

namespace TestAutomation.tests
{
    class TestComments : SeleniumTests
    {
        [Test]
        public void shouldAddComment()
        {
            string email = System.Guid.NewGuid().ToString() + "@test.com";
            string signature = "Signed: " + System.Guid.NewGuid().ToString();
            string commentText = "Comment text: " + System.Guid.NewGuid().ToString();
            MainPage mainPage = new MainPage(driver);
            mainPage.openMainPage();
            PostPage postPage = mainPage.openPost(mainPage.findPostURL(4));
            postPage.addComment(email, signature, commentText);
            Assert.True(postPage.commentExists(email, signature, commentText));
        }
    }
}
