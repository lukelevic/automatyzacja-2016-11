using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;
using NUnit.Framework;

namespace TestAutomation
{
    class TestAddingNumbers
    {
        [Test, Sequential]
        public void shouldConverToIntAndAdd([Values("1", "2", "3")] string stringOne, [Values("2", "3", "7")] string stringTwo, [Values(3, 5, 10)] int expResult)
        {
            int digitOne = Convert.ToInt32(stringOne);
            int digitTwo = Convert.ToInt32(stringTwo);
            int calcResult = digitOne + digitTwo;
            Assert.AreEqual(calcResult, expResult);
        }
    }
}
