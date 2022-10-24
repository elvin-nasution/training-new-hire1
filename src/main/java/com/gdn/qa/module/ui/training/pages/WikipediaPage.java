package com.gdn.qa.module.ui.training.pages;

import net.serenitybdd.core.annotations.findby.FindBy;
import net.serenitybdd.core.pages.WebElementFacade;
import net.thucydides.core.annotations.DefaultUrl;
import net.thucydides.core.pages.PageObject;
import org.springframework.stereotype.Component;

@DefaultUrl("https://www.wikipedia.org/")
@Component("com.gdn.qa.module.ui.training.pages.WikipediaPage")
public class WikipediaPage extends PageObject {

    @FindBy(id = "searchInput")
    private WebElementFacade searchInput;

    @FindBy(xpath = "//*[@id=\"search-form\"]/fieldset/button")
    private WebElementFacade searchButton;

    @FindBy(id = "firstHeading")
    private WebElementFacade pageHeading;

    public void typeToSearchButton(String keyword) {
        searchInput.sendKeys(keyword);
    }

    public void clickSearchButton() {
        searchButton.click();
    }

    public String getPageHeading() {
        return pageHeading.getText().trim();
    }

}