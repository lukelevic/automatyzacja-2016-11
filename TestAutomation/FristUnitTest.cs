using System;
using System.Collections.Generic;

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




        [Test, Sequential]
        public void SequentialTest(
            [Values("1", "2", "10")] string s1,
            [Values("5", "6", "20")] string s2,
            [Values(6, 8, 30)] int x
            )
        {
            int ints1;
            int.TryParse(s1, out ints1);

            int ints2;
            int.TryParse(s2, out ints2);

            var result = ints1 + ints2;

            Assert.AreEqual(result, x);
        }

        [OneTimeTearDown]
        public void EndOfTests()
        {
            Console.WriteLine("Bye");
        }
    }
    
}
