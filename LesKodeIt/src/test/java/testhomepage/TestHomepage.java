package testhomepage;

import homepage.pageobjet.HomePage;
import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.Test;

public class TestHomepage extends HomePage {
    public static  HomePage hp;

    public static void getInItElements(){ hp=PageFactory.initElements(driver,HomePage.class); }
    @Test (priority = 1)
    public static void testPracticeButton() throws InterruptedException {
        getInItElements();
        clickPracticeButton();
        sleepFor(2);
    }

    @Test (priority = 2)
    public static void testSelectClassBar() throws InterruptedException {
        getInItElements();
        clickPracticeButton();
        clickSelectClassBar();
        sleepFor(2);
    }

    @Test(priority = 3)
    public static void clickOnRadioButton() throws InterruptedException {
        getInItElements();
        clickPracticeButton();
        sleepFor(2);
        clickRadioButton();
        sleepFor(2);

    }

    @Test(priority = 4)
    public static void clickOnSelectButton() throws InterruptedException {
        getInItElements();
        clickPracticeButton();
        sleepFor(2);
        selectFromDrop(webElemetSelectButton, "benz");
        sleepFor(3);

    }

    @Test(priority = 5)
    public static void clickOnSelectMultiButton() throws InterruptedException {
        getInItElements();
        clickPracticeButton();
        sleepFor(2);
        selectFromMultipleDrop(webElemetSelectMultiButton, "apple", "orange");
        sleepFor(3);

    }

    @Test(priority = 6)
    public static void clickOnCheckButton() throws InterruptedException {
        getInItElements();
        clickPracticeButton();
        sleepFor(2);
        checkButton();
        sleepFor(3);

    }

    @Test(priority = 7)
    public static void newWindowOpen() throws InterruptedException {
        getInItElements();
        clickPracticeButton();
        sleepFor(2);
        newTabOpen();
        handleNewTab(driver).close();
        sleepFor(3);
    }

    @Test(priority = 8)
    public static void newWindowOpen1() throws InterruptedException {
        getInItElements();
        clickPracticeButton();
        sleepFor(2);
        newTabOpen1();
        handleNewTab(driver).close();
        sleepFor(3);

    }
    @Test(priority = 9)
    public static void alertHandleAccept() throws InterruptedException {
        getInItElements();
        clickPracticeButton();
        sleepFor(2);
        searchBoxSend();
        for (int i = 0;i<namelist().size();i++){
            System.out.println(namelist());
        }
        alertNewHandle();
        sleepFor(2);
        okAlert();

    }

    @Test(priority = 10)
    public static void alertHandleCancle() throws InterruptedException {
        getInItElements();
        clickPracticeButton();
        sleepFor(2);
        alertNewHandle();
        sleepFor(2);
        cancelAlert();
    }
    @Test(priority = 11)
    public static void getTable() throws InterruptedException {
        getInItElements();
        clickPracticeButton();
        sleepFor(2);
        scrollUpDown(2500);
        getListOfWebElementsByXpath(webElemetTable);
        sleepFor(2);

    }
    @Test(priority = 12)
    public void testiFrame() {
        getInItElements();
        clickPracticeButton();
        scrollUpDown(2500);
        iframeHandle(hp.iFrameName);
        hp.useSearchbar("python");
        hp.clearSearchBar();
    }

}
