import junitparams.JUnitParamsRunner;
import junitparams.Parameters;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;

import java.util.LinkedList;
import java.util.List;

@RunWith(JUnitParamsRunner.class)
public class FirstUnitTest {

    private List<String> list = new LinkedList<String>();

    @Before
    public void setUp() {
        for (int i = 0; i <= 9; i++) {
            this.list.add("string"+i);
        }
    }

    @Test
    public void testCaseNo1() {
        Assert.assertTrue(this.list.size() == 10);
        Assert.assertEquals("string", this.list.get(0));
    }

    @Test
    public void testCaseNo2() {
        this.list.remove(0);
        Assert.assertFalse(this.list.contains("string0"));
        Assert.assertNotEquals("string0", this.list.get(0));
    }

    @Test
    @Parameters({"1,2,3", "3,4,7"})
    public void testCaseNo3(String p1, String p2, int p3) {
        int str1 = Integer.parseInt(p1);
        int str2 = Integer.parseInt(p2);
        Assert.assertEquals(p3, str1+str2);

    }
}
