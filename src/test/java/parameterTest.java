import org.junit.Test;

/**
 * Created by Administrator on 2016-09-22.
 */

  import org.junit.Test;


    public class parameterTest extends mainClass {


        @Test
        public void positiveLogin() throws Exception {
            String password = "QW12qw12";
            String login = "szkolenieautomatyzacja";
            // driver.manage().window().maximize();

            openPage();
            logInWordpress(login, password);
            open();
            addText();
            findText();

        }

        @Test
        public void wrongPass() throws Exception {
            String password = "test";
            String login = "szkolenieautomatyzacja";
            // driver.manage().window().maximize();

            openPage();
            logInWordpress(login, password);
            open();
            addText();
            findText();

            @Test
            public void wrongLogin() throws Exception {
                String password = "QW12qw12";
                String login = "test";
                // driver.manage().window().maximize();

                openPage();
                logInWordpress(login, password);
                open();
                addText();
                findText();

    }


