/**
 * Created by Administrator on 2016-09-21.
 */

import org.junit.*;

import java.util.ArrayList;
import java.util.List;

public class FirstUnitTest {

//    @Before
//    @After
//    @AfterClass

    public static ArrayList<String> list;

    @BeforeClass
    public static void generateList() {
        list = new ArrayList<String>();
        list.add("element");
    }

    @Test
    public void testFirst() {
        System.out.println("testFirst");
        Assert.assertEquals(list.contains("element"), true);
    }

    @Test
    public void testSecond() {
        System.out.println("testSecond");
        list.clear();
        Assert.assertEquals(list.contains("element"), false);
    }


}
