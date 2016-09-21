using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;
using NUnit.Framework;

namespace TestAutomation
{
    class FirstUnitTest
    {
        List<string> Lista;
        //[SetUp]
        //[TearDown]
        //[TestFixtureSetUp]
        //[TestFixtureTearDown]
        [Test]
        public void testOne()
        {
            
            Lista.Add("trzy");
            Lista.Contains("trzy");
            //wykonac akcje
            //spr wynik
            
            //Console.WriteLine("testOne");
            //Assert.AreEqual(true);
            Assert.Contains("trzy", Lista);
            //Console.WriteLine("lista zawiera element");

        }

        [Test]
        public void UsunElement()
        {
            
            Lista.Contains("a");
            Lista.Remove("a");
            //Assert.Contains("a", Lista2);
            bool A = Lista.Contains("a");
            Assert.AreEqual(A, false);
           
        }
        [SetUp]
        public void SetUp()
        {
            Lista = new List<string> { "a", "b", "c" };

        }
        [Test, Sequential]
        public void param(
            [Values("1")] string x, [Values("2")] string y, [Values(3)] int s)
        {
         int wynik = Int32.Parse(x) + Int32.Parse(y);
         Assert.AreEqual(wynik, s);

        }



      
    }
}
