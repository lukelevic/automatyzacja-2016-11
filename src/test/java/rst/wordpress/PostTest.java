package rst.wordpress;

import org.junit.Assert;
import org.junit.Test;
import java.util.UUID;

/**
 * Created by Administrator on 2016-09-23.
 */
public class PostTest extends Scenario {
    private String title = UUID.randomUUID().toString() + "_Litwo Ojczyzno Moja";
    private String content = UUID.randomUUID().toString() + " Władza poznawcza w sobie Dobra zdawały się może być nakłoniony, a nie przyczytać; np. będzie takie postępowanie i kary. Kary więc Dobro ów stopień moralności domagać się, że Dobro w naturę człowieka tak wielka i ubóstwie, w takim razie upodla pod instynktu; czymże będzie zgodne z moralnością, a jabym był ideał niewinności albo ku dobremu nadane; ale że często złego na świecie był powierzony, znaczy niemało. Można komu zdawało, jak Kopczyński i Pan Malinowski w takim miejscu umieścił, mają być moralna, a u każdego człowieka, który nam tylko cieszyć. Kto dobre sprawowanie się bez własnej szkody, i dziękuję Dobraj Niedola lub złego przez moralność przez swoją moralność i ludzi wykonywali; taki idteał jako odosobionego. od ogrom, a nie miał stanowić taki idteał jako najdoskonalszą naturę, gdzie niegdzie w czasie, bo tu urojonej czystości w przeciwnym razie, gdyby bez ujęcia ograniczeń lub umysłu, zasługują na winę. Skutki i żądanie lepszego stanu niedołężnego i że najwyższe dobro ma wpływ na winę. Skutki i moralnością. Lecz niebędę się niniejsze dziełko, które mieć musi, jeżeli jako najwyższy stopień złości z wolności osoby jakiej istoty.";
    private String user = "szkolenieautomatyzacja";
    private String password = "QW12qw12";

    @Test
    public void ShouldAddPost(){
        LoginPage lp = new LoginPage(driver);
        AdminMainPage amp = lp.logIn(user,password);

        AddPostPage app = amp.goToAddPost();
        app.addPost(title, content);
        app.publish();

        HomePage hp = new HomePage(driver);
        Assert.assertTrue(hp.isPostAdded(title));
        hp.closeBrowser();
    }
}
