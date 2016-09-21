using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;
using NUnit.Framework;


namespace TestAutomation
{
    class firstUnitTest
    {

        List<string> days;

        [SetUp]
        public void SetUp()
        {
            days = new List<string>();
            days.Add("Monday");
            days.Add("Tuesday");
            days.Add("Wednesday");
        }

        [Test]
        public void shouldItemBeAdded()
        {
            bool actual = days.Contains("Monday");

            Assert.AreEqual(true, actual);
        }

        [Test]
        public void shouldItemBeRemoved()
        {
            days.Remove("Tuesday");
            bool actual = days.Contains("Tuesday");

            Assert.AreEqual(false, actual);
            Assert.AreEqual(2, days.Count());
        }
    }
}

// [SetUp]
// [TearDown]
// [TestFixtureSetUp]
// [TestFixtureTearDown]