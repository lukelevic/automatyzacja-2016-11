/**
 * Created by MichalJanuszS 2016-09-21.
 */
import org.junit.*;
import junitparams.*;
import org.junit.runner.RunWith;

@RunWith(JUnitParamsRunner.class)

public class DodawanieTest {
    @Test
    @Parameters({"1,2,3", "2,3,5","3,7,10"})
    public void suma(String p1, String p2, Integer p3){
        int int_p1 = Integer.parseInt(p1);
        int int_p2 = Integer.parseInt(p2);
        Integer tmp = int_p1 + int_p2;
        Assert.assertEquals(tmp, p3);
    }
}