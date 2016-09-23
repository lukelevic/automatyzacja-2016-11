using OpenQA.Selenium;
using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;
using TestAutomation;

namespace PageObjectPattern.tests
{
    class Page
    {
        public Page(IWebDriver driver)
        {
            this.driver = driver;
        }

        public IWebDriver driver { get; private set; }
        
        protected void click(By by)
        {
            driver.FindElement(by).Click();
        }

        protected void insert(By by, string text)
        {
            driver.FindElement(by).Clear();
            driver.FindElement(by).SendKeys(text);
        }


    }
}
