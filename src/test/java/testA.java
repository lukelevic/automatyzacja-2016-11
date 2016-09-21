
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

    /**
     * Created by Administrator on 2016-09-21.
     */


    public class testA {
        private List<String> Lista = new ArrayList<String>();

        //@Before   przed testem
        @Before
        public void setUp() {
            System.out.println("SetUp");
            Lista.add("element1");
            Lista.add("element2");
        }

        //@After    po tescie
        @After
        public void tearDown() {
            System.out.println("TearDown");
        }

        //@BeforeClass + static przed wszystkimi tetami
        //@AfterClass + static  po wszystkich testach


        @Test
        public void addToListTest() {
            System.out.println("Test: add to list");
            Lista.add("monday");

            Assert.assertEquals(Lista.size(), 3);
            Assert.assertTrue("Element nie jest na liscie", Lista.contains("monday"));
        }

        @Test
        public void removeFromListTest() {
            System.out.println("Test: remove from list");
            Lista.remove("monday");

            Assert.assertEquals(Lista.size(), 2);
            Assert.assertFalse("Element jest na liscie", Lista.contains("monday"));
        }
    }

