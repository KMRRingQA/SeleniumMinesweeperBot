package main.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindAll;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.FindBys;

import java.lang.reflect.Array;
import java.util.List;

public class Fields {
    @FindAll(@FindBy(xpath = "//*[@id=\"A4\"]/div"))
    List <WebElement> fields;

    public List <WebElement> getFields() {
        return this.fields;
    }

    public WebElement[][] playField;

    public WebElement[][] getPlayField(){
        return this.playField;
    }

    public void setPlayField(){
        WebElement[][] matrix = new WebElement[20][20];
        List<WebElement> field = this.getFields();
        int counter = 0;
        for (int y = 2; y<18;y++){
            for (int x = 2; x<18;x++){
                matrix[x][y]=field.get(counter);
                counter++;
            }
            counter++;
        }
        this.playField = matrix;
    }
}
