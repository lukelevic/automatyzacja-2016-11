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

namespace SeleniumTest
{
    [TestFixture]
    public class SeleniumTest : Scenario
    {
        [Test]
        public void ShouldLogIn()
        {
            // given
            Open(baseURL);
            tryLogIn("szkolenieautomatyzacja", "QW12qw12");

            //when
            InsertComment();

            //then
            logOut();
            AssertCommentAdded();
        }


       
        private void InsertComment()
        {
            click(By.XPath("//*[@id=\"menu-posts\"]/a"));
            click(By.XPath("//*[@id=\"wpbody-content\"]/div[3]/h1/a"));
            InsertText(By.Name("post_title"), "my Title");
            InsertText(By.Id("content"), "my comment");

            WaitForElement(By.Id("publish"));
            click(By.Id("publish"));

        }

        private void AssertCommentAdded()
        {
            Open("https://automatyzacja2016.wordpress.com");
            Assert.True(driver.PageSource.Contains("my Title"));
        }

             
        


    }
}
   