/**
 * Created by MichalJanuszS 2016-09-21.
 */
import org.junit.*;
import org.junit.Assert;
import java.util.ArrayList;
import java.util.List;

public class FirstUnitTest {
    List<String> myLista;                        // uzycie zmiennej w tescieTrzy
    static List<String> myListaStatyczna;        // uzycie zmiennej w statycznym

    // @BeforeClass + static        wykonanuie czegos przed wszystkimi testami w klasie
    // @Before                      wykonanuie czegos przed testem
    // @After                       wykonanuie czegos przed testem
    // @AfterClass + static         wykonanuie czegos przed wszystkimi testami w klasie

    @Test
    public void testOne()
    {
        List<String> myList = new ArrayList<String>();
        myList.add("Element");

        //sprawdzic wynik
        Assert.assertEquals(myList.contains("Element"),true);
    }

    @Test
    public void testDwa()
    {
        List<String> lista = generateList();
        //sprawdzic wynik
        Assert.assertEquals(lista.contains("Element"),false);
        Assert.assertEquals(lista.contains("dwa"),true);
        Assert.assertEquals(lista.size(),1);
    }

    private List<String> generateList()  {
        List<String> myList = new ArrayList<String>();
        myList.add("Element");
        myList.add("dwa");
        myList.remove("Element");
        return myList;
    }

    @Before
    public void generateListBefore(){
        myLista = new ArrayList<String>();
        myLista.add("Element");
        myLista.add("dwa");
        myLista.remove("Element");
    }

    @Test
    public void testTrzy()
    {
        //sprawdzic wynik
        Assert.assertEquals(myLista.contains("Element"),false);
        Assert.assertEquals(myLista.contains("dwa"),true);
        Assert.assertEquals(myLista.size(),1);
    }

    @BeforeClass
    public static void dodajZmienne(){
        myListaStatyczna = new ArrayList<String>();
        myListaStatyczna.add("Element");
    }

    @AfterClass
    public static void kasujZmienne(){
        myListaStatyczna.remove("Element");
    }
}
