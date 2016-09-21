import junitparams.JUnitParamsRunner;
import junitparams.Parameters;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;

import java.util.ArrayList;
import java.util.List;


@RunWith(JUnitParamsRunner.class)
public class FirstUnitTest {
    private List <String> Lista = new ArrayList<String>();

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
    @Parameters({"1,2,3","2,3,5", "3,7,10"})
    public void testTwo(String s1, String s2, String s3) {
        int a = Integer.parseInt(s1);
        int b = Integer.parseInt(s2);
        int c = Integer.parseInt(s3);

        Assert.assertEquals(a+b,c);
    }
}
