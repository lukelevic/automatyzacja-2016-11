using System;
using Microsoft.VisualStudio.TestTools.UnitTesting;


namespace UnitTestProject1
{
    [TestClass]
    public class UnitTest1
    {
        [TestMethod]
        public void shouldReturnDupa()
        {
            string actual = "dupa";
            Assert.AreEqual("dupa", actual);
        }
    }
}
