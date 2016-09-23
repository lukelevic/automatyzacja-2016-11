using System;
using System.Text;
using System.Text.RegularExpressions;
using System.Threading;
using NUnit.Framework;
using OpenQA.Selenium;
using OpenQA.Selenium.Chrome;
using OpenQA.Selenium.Support.UI;

namespace TestAutomation
{
    [TestFixture]
    public class WordpressTest : WordpressTestBase
    {
        [Test]
        public void shouldAddNewPost()
        {
            // given
            string entryTitle, entryContent;
            generatePostData(out entryTitle, out entryContent);
            tryLogin("szkolenieautomatyzacja", "QW12qw12");
            // when
            publishPost(entryTitle, entryContent);
            string entryPermalink = getPermalink();
            tryLogout();
            // then
            verifyPostIsPublished(entryTitle, entryContent, entryPermalink);
        }
        protected static void generatePostData(out string entryTitle, out string entryContent)
        {
            String TimeStamp = DateTime.Now.ToString("yyyyMMddHHmmssffff");
            entryTitle = "Post Rafala M @" + TimeStamp;
            entryContent = "Dowolny tekst w poście " + TimeStamp;
        }
        private void publishPost(string entryTitle, string entryContent)
        {
            click(By.XPath("//*[@id='menu-posts']/a/div[contains(text(),'Wpisy')]"));
            click(By.XPath("//li[@id='menu-posts']//a[contains(text(),'Dodaj nowy')]"));
            writeText(By.Id("title"), entryTitle);
            writeText(By.Id("content"), entryContent);
            waitForElementPresent(By.XPath("//*[@id='sample-permalink']/a"), 5);
            click(By.Id("publish"));
        }
        private string getPermalink()
        {
            return driver.FindElement(By.XPath("//*[@id='sample-permalink']/a")).GetAttribute("href");
        }
        private void verifyPostIsPublished(string entryTitle, string entryContent, string entryPermalink)
        {
            driver.Navigate().GoToUrl(entryPermalink);
            assertTextInElement(entryTitle, By.ClassName("entry-title"));
            assertTextInElement(entryContent, By.XPath("//div[@class='entry-content']/p[1]"));
        }

        [Test, Sequential]
        public void shouldVerifyCredentials([Values("szkolenieautomatyzacja", "szkolenieautomatyzacja", "notexisting")] string usr, [Values("QW12qw12", "wrongpass", "dummypass")] string pwd, [Values(true, false, false)] bool loggedIn)
        {
            // given
            string wpAdminPath = "/wp-admin/";
            // when
            tryLogin(usr, pwd);
            // then
            Assert.AreEqual(checkUrlIsCorrect(wpAdminPath), loggedIn);
            // cleanup
            tryLogout();
        }
    }
}
