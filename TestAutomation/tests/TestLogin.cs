using NUnit.Framework;
using TestAutomation.pages;

namespace TestAutomation.tests
{
    class TestLogin : SeleniumTests
    {
        [Test, Sequential]
        public void shouldValidateCredentialsAtLogin([Values("szkolenieautomatyzacja", "szkolenieautomatyzacja", "notexisting")] string usr, [Values("QW12qw12", "wrongpass", "dummypass")] string pwd, [Values(true, false, false)] bool loggedIn)
        {
            LoginPage loginPage = new LoginPage(driver);
            loginPage.openLoginPage();
            AdminPage adminPage = loginPage.logIn(usr, pwd);
            Assert.AreEqual(loggedIn, adminPage.isUserLoggedIn());
        }
    }
}
