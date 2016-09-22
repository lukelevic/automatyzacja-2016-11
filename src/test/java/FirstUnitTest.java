/**
 * Created by Administrator on 2016-09-21.
 */

import org.junit.AfterClass;
import org.junit.Assert;
import org.junit.BeforeClass;
import org.junit.Test;
import org.junit.runner.RunWith;

import java.util.ArrayList;
import java.util.List;
import junitparams.*;

@RunWith(JUnitParamsRunner.class)
public class FirstUnitTest {

    static final String TEST_STRING = "Monday";
    static final String TEST_STRING2 = "Friday";

    public static List<String> myList;

    // @Before              przed testem
    // @After
    // @BeforeClass         przed wszystkimi testami w klasie
    // @AfterClass

    @BeforeClass
    public static void Setup()
    {
        myList =  new ArrayList<String>();
    }

    @AfterClass
    public static void TearDown()
    {
        myList.clear();
    }

    @Test
    public void testAdd()
    {
        myList.add(TEST_STRING);

        Assert.assertTrue(myList.contains(TEST_STRING));

        // System.out.println("costam");
        // Assert.assertEquals(true, false);
    }

    @Test
    public void testAddSize()
    {
        int initialSize = myList.size();
        int afterSize;

        myList.add(TEST_STRING);
        afterSize = myList.size();

        Assert.assertEquals(initialSize+1, afterSize);
    }

    @Test
    public void testRemove()
    {
        myList.add(TEST_STRING2);

        myList.remove(TEST_STRING2);
        Assert.assertFalse(myList.contains(TEST_STRING2));

    }

    @Test
    @Parameters({"1,2,3","2,3,5"})
    public void testSum(String a, String b, int expectedValue)
    {
        int intA = Integer.parseInt(a);
        int intB = Integer.parseInt(b);

        int result = intA + intB;
        Assert.assertEquals(result, expectedValue);

    }

}
