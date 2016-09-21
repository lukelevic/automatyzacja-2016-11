using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;
using NUnit.Framework;

namespace testautomation
{
    class SecondUnitTest
    {
        [Test, Sequential]
        public void NewTest(
         [Values("1", "2", "3")] string x,
         [Values("2", "3", "5")] string y,
         [Values("3", "5", "8")] string z)
        {

            int result = Convert.ToInt16(x) + Convert.ToInt16(y);
            Assert.AreEqual(result, Convert.ToInt16(z));
        }
         

    }
}
