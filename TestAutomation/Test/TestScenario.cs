using NUnit.Framework;
using OpenQA.Selenium;
using OpenQA.Selenium.Firefox;
using OpenQA.Selenium.Support.UI;
using OpenQA.Selenium.Chrome;
namespace TestAutomation.Test
{
    internal class TestScenario
    {
        protected ChromeDriver driver;
        protected string baseURL;
        protected string title;
        [SetUp]
        public void SetupTest()
        {
            driver = new ChromeDriver(@"C:\Users\Administrator\Downloads\chromedriver_win32");
            title = ("nowy_wpis-ms");
        }
    }
}