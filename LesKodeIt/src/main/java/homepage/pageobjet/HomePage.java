package homepage.pageobjet;

import homepage.webelement.HomePageWebelement;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class HomePage extends HomePageWebelement {

    @FindBy(xpath = xPathPractice)public static WebElement practiceButton;
    public static WebElement getPracticeButton(){return practiceButton;}
    public static void clickPracticeButton(){getPracticeButton().click();}

//    @FindBy(xpath = xPathSelectClassBar)public static WebElement selectClassBar;
//    public static WebElement getSelectClassBar(){return selectClassBar;}
//    public static void clickPracticeButton(){getPracticeButton().click();}




}
