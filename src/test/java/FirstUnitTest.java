/**
 * Created by Administrator on 2016-09-21.
 */

import org.junit.Assert;
import org.junit.BeforeClass;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

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

    @Test
    public void testAdd()
    {
        myList.add(TEST_STRING);

        Assert.assertTrue(myList.contains(TEST_STRING));

        // System.out.println("costam");
        // Assert.assertEquals(true, false);
    }

    @Test
    public void testRemove()
    {
        myList.add(TEST_STRING2);

        myList.remove(TEST_STRING2);
        Assert.assertFalse(myList.contains(TEST_STRING2));

    }

}
