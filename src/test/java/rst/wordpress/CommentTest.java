package rst.wordpress;

import org.junit.Assert;
import org.junit.Test;

import java.util.UUID;

/**
 * Created by Administrator on 2016-09-23.
 */
public class CommentTest extends Scenario {
    private String comment = UUID.randomUUID().toString() + " Write commeenteknadfgoihadglkna afjbgadmfgnaiodg adfjignadkl.";

    @Test
    public void ShouldAddComment(){
        HomePage hpp = new HomePage(driver);
        hpp.goToMainPage(driver);
        SinglePost sp = hpp.goToFirstMyPost();
        sp.addComment(comment);
        sp.publish();
        Assert.assertTrue(sp.checkIfCommentIsPublished(comment));
    }
}