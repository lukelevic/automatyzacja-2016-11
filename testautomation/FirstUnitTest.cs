﻿using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;
using NUnit.Framework;


namespace testautomation
{
    class FirstUnitTest
    {
        /*   [SetUp]
           [TearDown]
           [TestFixtureSetUp]
           [TestFixtureTearDown]*/

        List<String> dni;

        [Test]
        public void testOne()
        {
        
            dni.Add("friday");
            dni.Add("saturday");
            
            Assert.Contains("friday", dni);

                        
      //      Assert.AreEqual(true, false);

         
        }

        [SetUp]
        public void setUp()
        {
            dni = new List<string> {"monday", "tuesday", "wednesday"};
            
        }        

        [Test]
        public void testTwo()
        {
    
            dni.Remove("monday");

            bool IsOnList = dni.Contains("monday");
            Assert.AreEqual(IsOnList, false);
        
         }


        [Test, Sequential]
        public void dodawanie([Values("1")] string a, [Values("2")] string b, [Values(3)] int x)
        {

            int c = Int32.Parse(a) + Int32.Parse(b);
            Assert.AreEqual(c, x);

        }






    }
}
