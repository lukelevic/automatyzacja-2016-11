using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;
using OpenQA.Selenium;

namespace TestAutomation.pages
{
    class MainPage : Page
    {
        public MainPage(IWebDriver driver) : base(driver)
        {
        }

        internal void openMainPage()
        {
            driver.Navigate().GoToUrl(baseURL);
        }
        internal PostPage openPost(string postURL)
        {
            driver.Navigate().GoToUrl(postURL);
            return new PostPage(driver);
        }

        internal string findPostURL(int postOrdinalNumber)
        {
            return driver.FindElement(By.XPath("//article[" + postOrdinalNumber.ToString() + "]//*[@class='entry-title']//a")).GetAttribute("href");
        }
    }
}
