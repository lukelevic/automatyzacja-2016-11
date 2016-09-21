import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.util.LinkedList;
import java.util.List;

public class FirstUnitTests {

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
        Assert.assertEquals("string0", this.list.get(0));
    }

    @Test
    public void testCaseNo2() {
        this.list.remove(0);
        Assert.assertFalse(this.list.contains("string0"));
        Assert.assertNotEquals("string0", this.list.get(0));
    }
}
