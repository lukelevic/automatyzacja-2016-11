import junitparams.JUnitParamsRunner;
import junitparams.Parameters;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;

import java.util.ArrayList;
import java.util.List;


@RunWith(JUnitParamsRunner.class)
public class JUnitParamTest {
    @Test
    @Parameters({"1,2,3","2,3,5", "3,7,10", "10,5,15", "20,30,50"})
    public void testDodawanie(String s1, String s2, String s3) {
        int a = Integer.parseInt(s1);
        int b = Integer.parseInt(s2);
        int c = Integer.parseInt(s3);

        Assert.assertEquals(a+b,c);
    }
    @Test
    @Parameters({"5,2,3","8,3,5", "17,7,10"})
    public void testOdejmowanie(String s1, String s2, String s3) {
        int a = Integer.parseInt(s1);
        int b = Integer.parseInt(s2);
        int c = Integer.parseInt(s3);

        Assert.assertEquals(a-b,c);
    }
}
