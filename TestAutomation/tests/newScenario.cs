using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;
using NUnit.Framework;
using OpenQA.Selenium;
using OpenQA.Selenium.Chrome;

namespace PageObjectPattern.tests
{
    class NewScenario
    {
        protected IWebDriver driver;
        
        
        [SetUp]
        protected void setupTest()
        {
            driver = new ChromeDriver(@"C:\repozytorium\automatyzacja-2016-11\");
            driver.Navigate().GoToUrl("https://automatyzacja2016.wordpress.com/wp-admin");
            driver.Manage().Window.Maximize();
        }

        [TearDown]
        protected void TeardownTest()
        {
           //driver.Close();
        }
    }
}
