using NUnit.Framework;
using TestAutomation.pages;

namespace TestAutomation.tests
{
    class TestAddingPosts : SeleniumTests
    {
        [Test]
        public void shouldAddNewPostInTextMode()
        {
            string usr = "szkolenieautomatyzacja";
            string pwd = "QW12qw12";
            string title = "RM TITLE: " + System.Guid.NewGuid().ToString();
            string content = "RM CONTENT: " + System.Guid.NewGuid().ToString();

            LoginPage loginPage = new LoginPage(driver);
            loginPage.openLoginPage();
            AdminPage adminPage = loginPage.logIn(usr, pwd);

            AddPostPage addPostPage = adminPage.goToAddNewPost();
            addPostPage.addNewPost(title, content);
            EditPostPage editPostPage = addPostPage.publishPost();
            string postURL = editPostPage.getPermalink();

            PostPage postPage = editPostPage.displayPost(postURL);
            Assert.AreEqual(postURL, postPage.getPageURL());
            Assert.AreEqual(title, postPage.getPageTitle());
            Assert.AreEqual(content, postPage.getPageContent());
        }
    }
}
