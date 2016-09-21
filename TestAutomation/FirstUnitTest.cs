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
        List<string> listOfDays;
        [TestFixtureSetUp]
        public void testFixtureSetup()
        {
            this.listOfDays = new List<string>();
        }

        [SetUp]
        public void setUp()
        {
            listOfDays.Add("Sunday");
        }
        [TearDown]
        public void tearDown()
        {
            listOfDays.Remove("Sunday");
        }
        //[TestFixtureSetUp]
        //[TestFixtureTearDown]

        [Test]
        public void shouldAddMonday()
        {
            listOfDays.Add("Monday");
            Assert.True(listOfDays.Contains("Monday"));
        }
        [Test]
        public void shouldRemoveMonday()
        {
            listOfDays.Remove("Monday");
            Assert.False(listOfDays.Contains("Monday"));
            Assert.That(listOfDays.Count, Is.EqualTo(1));
        }

    }
}
