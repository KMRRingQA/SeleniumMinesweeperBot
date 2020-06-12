package main.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class NavigationPage {
    @FindBy(xpath = "//*[@id=\"level_select_2\"]/span")
    private WebElement intermediate;

    public WebElement getIntermediate() {
        return intermediate;
    }

}
