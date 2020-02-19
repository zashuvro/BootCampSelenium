package testhomepage;

import homepage.pageobjet.HomePage;
import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.Test;

public class TestHomepage extends HomePage {

    public static void getInItElements(){ PageFactory.initElements(driver,HomePage.class); }
    @Test
    public static void testPracticeButton() throws InterruptedException {
        getInItElements();
        clickPracticeButton();
        sleepFor(2);
    }

}
