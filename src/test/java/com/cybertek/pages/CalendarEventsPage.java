package com.cybertek.pages;

import com.cybertek.utilities.Driver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.List;

public class CalendarEventsPage extends BasePage {

    public CalendarEventsPage() {
        PageFactory.initElements(Driver.get(), this);
    }

    @FindBy(css = "[title='Create Calendar event']")
    public WebElement createCalendarEvent;

    @FindBy(xpath = "(//div[@class='btn-toolbar']//div[contains(.,'Options')])[2]")
    public WebElement options;

    @FindBy(xpath = "//li/input[@type='number']")
    public WebElement pageNumber;

    @FindBy(xpath = "//div[@class='btn-group']/button")
    public WebElement viewPerPage;

    @FindBy(css = ".dropdown-item")
    public List<WebElement> viewPerPageOptions;

    @FindBy(css = "tbody> tr")
    public List<WebElement> tableRows;

    @FindBy(xpath = "//i[contains(.,'Next')]")
    public WebElement nextBtn;

    @FindBy(xpath = "//label[@class='dib'][3]")
    public WebElement totalRecords;

    @FindBy(xpath = "//label[@class='dib'][2]")
    public WebElement noOfPages;

    public int getnumberOfRecords(){
        String[] arr= totalRecords.getText().split(" ");
        return Integer.parseInt(arr[2]);
    }

    public int getnumberOfPages(){

        String[] arr= noOfPages.getText().split(" ");
        return Integer.parseInt(arr[1]);
    }

}
