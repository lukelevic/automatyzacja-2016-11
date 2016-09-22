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
        [SetUp]
        public void InitialTest()
        {
            DayOffWeek.Add("Sunday");
        }
        List<string> DayOffWeek = new List<string>();
        // [SetUp]
        // [TearDown]
        // [TestFixtureSetup]
        // [TestFixtureTearDown]

        [Test]
        public void testOne()
        {

           
            DayOffWeek.Add("Monday");
            Console.WriteLine("test one");
            Assert.AreEqual(2, DayOffWeek.Count());
                 
           
           


        }
        [Test]
        public void testTwo()
        {
            DayOffWeek.Remove("Sunday");
            Console.WriteLine("test two");
            Assert.AreEqual(3, DayOffWeek.Count());
        }
        [Test]
        public void testThree()
        {
            DayOffWeek.Contains("Monday");
        }
       
       

    }
}
