using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;
using NUnit.Framework;

namespace TestAutomation
{
      
    class SumOfStrings
    {

       [Test, Sequential]
        public void shouldAddTwoConvertedStrings(
            [Values("1", "2", "3")] string firstString,
            [Values("2", "3", "7")] string secondString,
            [Values(3, 5, 10)] int result)
        {

            int convertedFirstNumber = int.Parse(firstString);
            int convertedSecondString = int.Parse(secondString);
            int sum = convertedFirstNumber + convertedSecondString;

            Assert.AreEqual(result, sum);
        }
    }
}
