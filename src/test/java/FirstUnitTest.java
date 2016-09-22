/**
 * Created by Administrator on 2016-09-21.
 */

import junitparams.JUnitParamsRunner;
import junitparams.Parameters;
import org.junit.*;
import org.junit.runner.RunWith;

import java.util.ArrayList;
import static org.junit.Assert.*;

@RunWith(JUnitParamsRunner.class)
public class FirstUnitTest {

//    @Before
//    @After
//    @AfterClass

    public static ArrayList<String> list;

    @BeforeClass
    public static void generateList() {
        System.out.println("before class");
        list = new ArrayList<String>();
        list.add("element");
    }

    @Test
    public void testFirst() {
        System.out.println("testFirst");
        assertEquals(list.contains("element"), true);
    }

    @Test
    public void testSecond() {
        System.out.println("testSecond");
        list.clear();
        assertEquals(list.contains("element"), false);
    }

    @Test
    @Parameters({"1,2,3","2,3,5","80,10,90","1,2,8"})
    public void testSum(String A, String B, int C) {
        System.out.println("testThird");
        int _A = Integer.parseInt(A);
        int _B = Integer.parseInt(B);
        int suma = (_A+_B);
        assertEquals(suma, C);
    }


}
