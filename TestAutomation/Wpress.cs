using System;
using System.Text;
using NUnit.Framework;
using OpenQA.Selenium;
using OpenQA.Selenium.Chrome;
using System.Threading;
using OpenQA.Selenium.Interactions;

namespace SeleniumTests
{
    [TestFixture]
    public class Wpress : WpressBase
    {
        
        
        //[Test]
        //public void ShouldLoginLogout()
        //{
                        
        //}

        [Test, Sequential]
        public void ShouldSequentialLoginLogout(
            [Values("1", "2", "szkolenieautomatyzacja")] string login,
            [Values("5", "6", "QW12qw12")] string pass
            )
        {
            LogIn(login, pass);

        }
        
        [Test]
        public void ShouldAddNewPost()
        {

            ClickBy(By.LinkText("Wpisy"), 2);
            ClickBy(By.LinkText("Dodaj nowy"), 2);
            
            var title = "adaml" + DateTime.Now;
            InsertTextBy(By.Name("post_title"), title);
            ClickBy(By.Id("publish"), 5);
            
            var linkByTitle = "https://automatyzacja2016.wordpress.com/2016/09/22/";
            var newPost = driver.FindElement(By.XPath("//a[contains(.,'" + linkByTitle + "')]"));

            Assert.IsNotNull(newPost);
            
        }

        

        private bool IsElementPresent(By by)
        {
            try
            {
                driver.FindElement(by);
                return true;
            }
            catch (NoSuchElementException)
            {
                return false;
            }
        }

        private bool IsAlertPresent()
        {
            try
            {
                driver.SwitchTo().Alert();
                return true;
            }
            catch (NoAlertPresentException)
            {
                return false;
            }
        }

        private string CloseAlertAndGetItsText()
        {
            try
            {
                IAlert alert = driver.SwitchTo().Alert();
                string alertText = alert.Text;
                if (acceptNextAlert)
                {
                    alert.Accept();
                }
                else
                {
                    alert.Dismiss();
                }
                return alertText;
            }
            finally
            {
                acceptNextAlert = true;
            }
        }
    }
}
