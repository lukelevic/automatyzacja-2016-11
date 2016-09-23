using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;
using OpenQA.Selenium.Chrome;
using OpenQA.Selenium;
using NUnit.Framework;

namespace TestAutomation
{
    public class Scenario
    {
        protected IWebDriver driver;
        

        protected void addPost(string title, string content)
        {
            insert(By.Id("title"), title);
            insert(By.Id("content"), content);
            //driver.FindElement(By.Id("title")).SendKeys(title);
            //driver.FindElement(By.Id("content")).SendKeys(content);
        }

        protected void savePost()
        {
            driver.FindElement(By.Id("save-post")).Click();
        }

        protected bool checkIfLoggedIn()
        {
            if (driver.PageSource.Contains("Kokpit")) return true;
            else return false;                
        }

        protected void login(string userName, string password)
        {
            click(By.Id("user_login"));
            insert(By.Id("user_login"),userName);
            insert(By.Id("user_pass"), password);
            click(By.Id("wp-submit"));
        }

        protected void LogOut()
        {
            click(By.ClassName("avatar avatar-32"));
            click(By.ClassName("ab-sign-out"));           
        }

        protected void openPage(string url)
        {
            driver.Navigate().GoToUrl(url);
            driver.Manage().Window.Maximize();
        }
       
        protected void click(By by)
        {
            driver.FindElement(by).Click();
        }

        protected void insert(By by, string text)
        {       
            driver.FindElement(by).Clear();
            driver.FindElement(by).SendKeys(text);
        }
        
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
            driver.Close();
        }

        protected void wait()
        {

        }

        protected bool checkIfPageContains(string text)
        {
            if (driver.PageSource.Contains(text)) return true;
            else return false;
        }
    }
}



//int input = Convert.ToInt32(Console.ReadLine());
//string classify;

//// if-else construction.
//if (input > 0)
//    classify = "positive";
//else
//    classify = "negative";

//// ?: conditional operator.
//classify = (input > 0) ? "positive" : "negative";