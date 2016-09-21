/**
 * Created by Administrator on 2016-09-21.
 */

import org.junit.Assert;
import org.junit.Test;
import org.junit.Before;

import java.util.ArrayList;
import java.util.List;

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
}
