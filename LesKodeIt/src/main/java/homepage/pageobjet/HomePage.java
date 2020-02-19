package homepage.pageobjet;

import homepage.webelement.HomePageWebelement;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class HomePage extends HomePageWebelement {

    @FindBy(xpath = xPathPractice)public static WebElement practiceButton;
    public static WebElement getPracticeButton(){return practiceButton;}
    public static void clickPracticeButton(){getPracticeButton().click();}

}
