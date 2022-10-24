package com.gdn.qa.module.ui.training.pages;

import net.serenitybdd.core.pages.PageObject;
import net.serenitybdd.core.pages.WebElementFacade;
import org.openqa.selenium.support.FindBy;
import org.springframework.stereotype.Component;

@Component ("com.gdn.qa.module.ui.training.pages.ProductPage")
public class ProductPage extends PageObject {

    @FindBy(xpath = "/html[1]/body[1]/div[1]/div[1]/div[1]/div[1]/div[2]/span[1]")
    private WebElementFacade productsTitle;

    public String getTxtProducts(){
        return productsTitle.waitUntilVisible().getText();
    }
}
