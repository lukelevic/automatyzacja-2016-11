using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;
using NUnit.Framework;
using System.Diagnostics;

namespace testautomation
{
    class FirstUnitTest
    {

        List<string> Lista = new List<string>();

        [SetUp] //przed kazdym testem
        public void Start()
        {
            Lista.Add("elem 1");
        }
        //[TearDown] po kazdym tescie
        //[TestFixtureSetUp] przed wszystkimi testami
        //[TestFixtureTearDown] po wszystkich testach

        // atrybut wymagany zeby bylo wiadomo ze to test
        [Test]
        public void ShouldAddElementToList()
        {
            Lista.Add("elem 2");
            // wykonac akcje
            Console.WriteLine("Test one text: {0}", Lista[0]);
            // sprawdzic wynik
            Assert.AreEqual(2, Lista.Count());
        }

        [Test]
        public void ShouldRemoveElementFromList()
        {
            Lista.Remove("elem 1");
            // wykonac akcje
            Console.WriteLine("Test two text");
            // sprawdzic wynik
            Assert.AreEqual(2, Lista.Count());
        }
        [Test, Sequential]
        public void testParam(
            [Values("1", "2", "3")] string x,
            [Values("2", "3", "5")] string y,
            [Values("3", "5", "8")] string z)
        {
            int result = Convert.ToInt16(x) + Convert.ToInt16(y);
            Assert.AreEqual(result, Convert.ToInt16(z));
        }
    }
}
