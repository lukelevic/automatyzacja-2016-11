import org.junit.*;
import static org.junit.Assert.*;

public class SeleniumIDETest extends AbstactClass{
    private String content = "treść posta";
    int rand = getRandom();
    private String title = "nowy pościk";



//    @Test
//    public void testWordpress() throws Exception {
//        driver.get(baseUrl + "/wp-login.php");
//        driver.findElement(By.id("user_login")).clear();
//        driver.findElement(By.id("user_login")).sendKeys("szkolenieautomatyzacja");
//        driver.findElement(By.id("user_pass")).clear();
//        driver.findElement(By.id("user_pass")).sendKeys("QW12qw12");
//        driver.findElement(By.id("wp-submit")).click();
//        driver.findElement(By.cssSelector("img.avatar.avatar-32")).click();
//        driver.findElement(By.xpath("//button[contains(@class, 'sign-out')]")).click();
//    }

    @Test
    public void testAddPostAndCheck() throws Exception {
        logIn();
        goToNewPost();
        publishNewPost(title, content, rand);
        goToAllPostView();
        logOut();
        goToHomePage();
        goToPostView(title);
        assertTrue(driver.getTitle().contains(title+" "+rand));
    }



//    private boolean isElementPresent(By by) {
//        try {
//            driver.findElement(by);
//            return true;
//        } catch (NoSuchElementException e) {
//            return false;
//        }
//    }
//
//    private boolean isAlertPresent() {
//        try {
//            driver.switchTo().alert();
//            return true;
//        } catch (NoAlertPresentException e) {
//            return false;
//        }
//    }
//
//    private String closeAlertAndGetItsText() {
//        try {
//            Alert alert = driver.switchTo().alert();
//            String alertText = alert.getText();
//            if (acceptNextAlert) {
//                alert.accept();
//            } else {
//                alert.dismiss();
//            }
//            return alertText;
//        } finally {
//            acceptNextAlert = true;
//        }
//    }


}
