package org.example.steps;

import io.qameta.allure.Step;
import org.example.pages.SearchPage;

import static com.codeborne.selenide.Condition.text;

public class SearchSteps {
    SearchPage searchPage = new SearchPage();

    @Step("Search product")
    public void searchProduct(String request) {
        searchPage.searchButton.click();
        searchPage.requestField.setValue(request);
        searchPage.afterInputRequestButton.click();
    }
    @Step("Check search result")
    public void checkSearchResult(String rightResult){
        searchPage.searchResult.shouldHave(text(rightResult));
    }
}
