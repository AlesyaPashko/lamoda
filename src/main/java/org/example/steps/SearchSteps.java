package org.example.steps;

import com.codeborne.selenide.Condition;
import io.qameta.allure.Step;
import lombok.extern.log4j.Log4j2;
import org.example.pages.SearchPage;
import org.openqa.selenium.Keys;

@Log4j2
public class SearchSteps {
    SearchPage searchPage = new SearchPage();

    @Step("Search product")
    public void searchProduct(String request) {
        log.info("Search product");
        searchPage.searchButton.click();
        searchPage.requestField.val(request).sendKeys(Keys.ENTER);
    }

    @Step("Check is search result visible")
    public void isSearchResultVisible() {
        log.info("Check is search result visible");
        searchPage.searchResult.shouldBe(Condition.visible);
    }

    @Step("Check is empty result message visible")
    public void isEmptyResultMessageVisible(String warningText) {
        log.info("Check is empty result message visible");
        searchPage.warningText.shouldHave(Condition.text(warningText));
    }
}
