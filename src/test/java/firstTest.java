

import junitparams.JUnitParamsRunner;
import junitparams.Parameters;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Administrator on 2016-09-21.
 */

@RunWith(JUnitParamsRunner.class)
public class firstTest{
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

    @Test
    @Parameters({"1,2,3","2,2,4"})
    public void paramsInAnnotation(String a1, String b1, String s1) {


        int a = Integer.parseInt(a1);
        int b = Integer.parseInt(b1);
        int s = Integer.parseInt(s1);
        //int s = a + b;

        Assert.assertEquals(a + b, s);
    }
        @Test
        @Parameters({"5,2,3", "6,2,4"})
        public void paramsInAnnotation (String d1, String f1, Integer g1){


            int kk = Integer.parseInt(d1);
            int ll = Integer.parseInt(f1);
           int ww = g1;
            //int s = a + b;

            Assert.assertEquals(kk - ll, ww);
                }
    }


