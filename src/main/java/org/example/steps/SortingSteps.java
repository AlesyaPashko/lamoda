package org.example.steps;

import io.qameta.allure.Step;
import org.example.pages.SortingPage;
import org.example.utils.PriceHelper;
import org.example.utils.Waiters;

import static com.codeborne.selenide.Condition.text;

public class SortingSteps {
    SortingPage sortingPage = new SortingPage();

    @Step("Customize sorting by ascending price")
    public void customizeSortingByAscendingPrice(){
        sortingPage.sortingButton.click();
        sortingPage.sortingByAscendingPriceButton.click();
        Waiters.sleep();
    }

    @Step("Customize sorting by descending price")
    public void customizeSortingByDescendingPrice(){
        sortingPage.sortingButton.click();
        sortingPage.sortingByDescendingPriceButton.click();
        Waiters.sleep();
    }

    @Step("Check right sorting by ascending price")
    public void checkRightSortingByAscendingPrice(){
        sortingPage.priceList.get(0).shouldHave(text(PriceHelper.searchRightPrice(sortingPage.priceList,"lowest")));
    }

    @Step("Check right sorting by descending price")
    public void checkRightSortingByDescendingPrice(){
        sortingPage.priceList.get(0).shouldHave(text(PriceHelper.searchRightPrice(sortingPage.priceList,"highest")));
    }
}
