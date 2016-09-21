using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

using NUnit.Framework;

namespace TestAutomation
{
    public class FirstUnitTest
    {
        public List<string> list;

        [OneTimeSetUp]
        public void InitializeTestClass()
        {
            Console.WriteLine("Hi");
        }

        [SetUp]
        public void InitializeParticularTest()
        {
            list = new List<string>() { "A", "B", "C" };
        }
        
        [Test]
        public void IsOnList()
        {
            var result = list.Contains("C");
            Assert.AreEqual(result, true);
        }

        [Test]
        public void IsRemovedFromList()
        {
            list.Remove("C");
            var result = list.Contains("C");
            Assert.AreEqual(result, false);
        }

        [OneTimeTearDown]
        public void EndOfTests()
        {
            Console.WriteLine("Bye");
        }
    }
    
}
