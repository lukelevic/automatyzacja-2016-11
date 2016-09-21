using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

using NUnit.Framework;

namespace testautomation
{
    class FirstUnitTest
    {
        List<string> lista = new List<string>();
        [SetUp]
        // [SetUp]   // przed testem
        // [TearDown]
        // [TestFixtureSetUp]
        // [TestFixtureTearDown]
        public void setUp()
        {
            lista.Add("element");
        }
        [Test]
        public void testAdd()
        {

           // lista.Add("element");
           // lista.Add("element2");

            // wykonac akcje
            Console.WriteLine("Zawartosc listy",lista);
            //sprawdzic wynik
            Assert.AreEqual(1, lista.Count);
            //Assert.IsTrue(lista.Contains("element"))
        }

        [Test]
        public void testRemove()
        {
            lista.Remove("element");
            // wykonac akcje
            Console.WriteLine("Zawartosc listy", lista);
            //sprawdzic wynik
            Assert.AreEqual(1,lista.Count);
            //Assert.areEqual(lista.size(),1);
            //Assert.False(lista.Contains("element"))
        }
    }
}
