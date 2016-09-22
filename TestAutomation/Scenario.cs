using System;
using System.Text;
using NUnit.Framework;
using OpenQA.Selenium;
using OpenQA.Selenium.Firefox;
using OpenQA.Selenium.Chrome;
using Microsoft.VisualStudio.TestTools.UnitTesting;
using TestAutomation;

namespace SeleniumTests 
{
    [TestFixture]
    public class Scenario : baseWebDriver
    {
                                      
        [Test]
        public void shouldAddNewPost()
        {
            //given
            string title = "nowy post";
            string content = "blablabla";

            //when
            addPost(title, content);

            //assert
            click(By.ClassName("view-all"));
            NUnit.Framework.Assert.AreEqual(true, driver.PageSource.Contains(title));
                        
        }
    }
}

