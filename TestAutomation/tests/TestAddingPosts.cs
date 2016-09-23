using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;
using NUnit.Framework;
using OpenQA.Selenium;
using OpenQA.Selenium.Chrome;

namespace TestAutomation.tests
{
    class TestAddingPosts
    {
        protected IWebDriver driver;
        protected StringBuilder verificationErrors;
        protected string baseURL;

        [SetUp]
        protected void setupTest()
        {
            driver = new ChromeDriver();
            driver.Manage().Timeouts().ImplicitlyWait(TimeSpan.FromSeconds(15));
            driver.Manage().Window.Maximize();
            verificationErrors = new StringBuilder();
        }
        [Test]
        public void AddNewPost()
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
            Assert.AreEqual(postPage.getPageURL(), postURL);
            Assert.AreEqual(postPage.getPageTitle(), title);
            Assert.AreEqual(postPage.getPageContent(), content);
        }
        [TearDown]
        protected void TeardownTest()
        {
            try
            {
                driver.Quit();
            }
            catch (Exception)
            {
                // Ignore errors if unable to close the browser
            }
            Assert.AreEqual("", verificationErrors.ToString());
        }
    }
}
