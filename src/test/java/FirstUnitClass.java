import org.junit.*;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Administrator on 2016-09-21.
 */
public class FirstUnitClass {

    List<String> listOne;

    // @Before przed testestm
    // @After po tescie
    // @Before + static przed wszystkimi testami
    // @After + static

    @Before

    public void setUp() {
        listOne = new ArrayList<String>();
        listOne.add("cc");
        listOne.add("cos");
        System.out.println(listOne);

    }


    @Test
    public void testOne() {


        //  List<String> listOne = new ArrayList<String>();
        //    listOne.add("cc");
        //      listOne.add("cos");
        Assert.assertTrue(listOne.contains("cc"));
        System.out.println("test pierwszy" + listOne);
        //  Assert.assertEquals(true, false);

    }


    @Test
    public void testTwo() {

        System.out.println(listOne);
        listOne.remove("cc");
        System.out.println(listOne);
        Assert.assertEquals(listOne.size(), 1);
        Assert.assertFalse(listOne.contains("cc"));

    }

}