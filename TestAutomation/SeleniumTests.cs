using System;
using System.Text;
using NUnit.Framework;
using OpenQA.Selenium;
using OpenQA.Selenium.Firefox;
using OpenQA.Selenium.Chrome;
using TestAutomation;

namespace SeleniumTests 
{
    
    public class SeleniumTests : Scenario
    {
        [Test]
        public void shouldLogInWithCorrectCredentials()
        {
            login("szkolenieautomatyzacja", "QW12qw12");
            Assert.AreEqual(true,checkIfLoggedIn());
        }

        [Test, Sequential]
        public void shouldNotLogInWithIncorrectCredentials( 
            [Values("user1", "user2", "user3")] string username,
            [Values("password1", "password2", "password3")] string password,
            [Values(false, false, false)] bool expectedResult)
        {
            login(username, password);
            bool result = checkIfLoggedIn();
            Assert.AreEqual(expectedResult, result);
        }

        [Test]
        public void shouldAddNewPost()
        {
            string title = "nowy post";
            string content = "blablabla";
            login("szkolenieautomatyzacja", "QW12qw12");

            addPost(title, content);
            savePost();

            click(By.ClassName("view-all"));
            Assert.AreEqual(true, checkIfPageContains(title));                        
        }
    }
}

