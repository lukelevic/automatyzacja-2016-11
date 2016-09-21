/**
 * Created by Administrator on 2016-09-21.
 */

import junitparams.*;
import org.junit.Assert;
import org.junit.Test;
import org.junit.Before;
import org.junit.runner.RunWith;

import java.util.ArrayList;
import java.util.List;

@RunWith(JUnitParamsRunner.class)
public class FirstUnitTest {
    private static final String DAY_NAME = "Monday";
    private List<String> week = new ArrayList<String>();

    @Before
    public void addDayToWeek() {
        week.add(DAY_NAME);
    }
    // @After
    // @BeforeClass + static
    // @AfterClass + static

    @Test
    public void addTest()
    {
        Assert.assertEquals(1, week.size());
        Assert.assertTrue(week.contains(DAY_NAME));
    }

    @Test
    public void removeTest()
    {
        week.remove(DAY_NAME);
        Assert.assertEquals(0, week.size());
        Assert.assertFalse(week.contains(DAY_NAME));
    }

    @Test
    @Parameters({"1,2,3", "2,3,5", "3,7,10"})
    public void addStrings(String p1, String p2, int p3) {
        int _p1 = Integer.parseInt(p1);
        int _p2 = Integer.parseInt(p2);
        Assert.assertEquals(p3, _p1+_p2);
    }
}
