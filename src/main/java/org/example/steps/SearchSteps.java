package org.example.steps;

import com.codeborne.selenide.Condition;
import io.qameta.allure.Step;
import org.example.pages.SearchPage;
import org.example.utils.Waiters;
import org.openqa.selenium.Keys;

public class SearchSteps {
    SearchPage searchPage = new SearchPage();

    @Step("Search product")
    public void searchProduct(String request) {
        searchPage.searchButton.click();
        searchPage.requestField.val(request).sendKeys(Keys.ENTER);
    }

    @Step("Check search result")
    public void checkPositiveSearchResult() {
        searchPage.searchResult.shouldBe(Condition.visible);
    }

    @Step("Check negative search result")
    public void checkNegativeSearchResult(String warningText) {
        Waiters.sleep();
        searchPage.warningText.shouldHave(Condition.text(warningText));
    }
}
