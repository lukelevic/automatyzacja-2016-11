using System;
using System.Text;
using System.Text.RegularExpressions;
using System.Threading;
using NUnit.Framework;
using OpenQA.Selenium;
using System;
using System.Text;
using System.Text.RegularExpressions;
using System.Threading;
using NUnit.Framework;
using OpenQA.Selenium;
using OpenQA.Selenium.Firefox;
using OpenQA.Selenium.Support.UI;
using OpenQA.Selenium.Chrome;


namespace TestAutomation.Test
{
    internal class MainAdminPage : Page
    
    {
        public MainAdminPage(IWebDriver driver) : base(driver)
            {
        }

        internal AddPostPage goToAddNewPostPage()
        {

         
            Click(By.XPath("//div[@class='wp-menu-image dashicons-before dashicons-admin-post']"));
            Click(By.XPath("//a[@class='page-title-action']"));
            return new AddPostPage(driver);
        }

        internal void AddNewPost(string title)
        {
            
            InsertText(By.XPath("//input[@id='title']"), title);
            Click(By.XPath("//button[contains(.,'Tekstowy')]"));
            InsertText(By.ClassName("wp-editor-area"), "tekst do wpisu");
            Click(By.XPath("//input[@id='publish']"));
            //Click(By.XPath("//a[contains(.,'https://automatyzacja2016.wordpress.com/2016/09/23/nowy_wpis-ms')]"));
        }
    }
}