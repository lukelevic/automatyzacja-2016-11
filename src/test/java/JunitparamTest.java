/**
 * Created by Administrator on 2016-09-21.
 */

import org.junit.Test;
import junitparams.*;
import org.junit.*;
import org.junit.runner.RunWith;


@RunWith(JUnitParamsRunner.class)
public class JunitparamTest {


    @Test
    @Parameters({"1,2,3", "2,3,5", "3,7,10"})
    public void adding(String p1, String p2, int p3) {

        int pp1 = Integer.parseInt(p1);
        int pp2 = Integer.parseInt(p2);


        Assert.assertEquals(pp1 + pp2, p3);

    }
}
