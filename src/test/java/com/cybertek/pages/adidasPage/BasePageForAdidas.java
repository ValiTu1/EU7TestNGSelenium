package com.cybertek.pages.adidasPage;

import com.cybertek.utilities.Driver;
import org.openqa.selenium.support.PageFactory;

public abstract class BasePageForAdidas {

    public BasePageForAdidas(){
        PageFactory.initElements(Driver.get(), this);
    }





















}
