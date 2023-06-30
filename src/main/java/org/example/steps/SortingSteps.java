package org.example.steps;

import io.qameta.allure.Step;
import org.example.pages.SortingPage;
import org.example.utils.PriceConverter;
import org.example.utils.Waiters;
import org.testng.Assert;

import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

public class SortingSteps {

    SortingPage sortingPage = new SortingPage();

    @Step("Customize sorting by ascending price")
    public void customizeSortingByAscendingPrice() {
        Waiters.sleep();
        sortingPage.sortingButton.click();
        sortingPage.sortingByAscendingPriceButton.click();
        Waiters.sleep();
    }

    @Step("Customize sorting by descending price")
    public void customizeSortingByDescendingPrice() {
        Waiters.sleep();
        sortingPage.sortingButton.click();
        sortingPage.sortingByDescendingPriceButton.click();
        Waiters.sleep();
    }

    @Step("Get prices list")
    public List<Double> getPricesList() {
        return PriceConverter.getOriginPricesList(sortingPage.priceList);
    }

    @Step("Check right sorting by ascending price")
    public void checkRightSortingByAscendingPrice() {
        Waiters.sleep();
        Assert.assertEquals(getPricesList().stream().sorted().collect(Collectors.toList()), getPricesList());
    }

    @Step("Check right sorting by descending price")
    public void checkRightSortingByDescendingPrice() {
        Assert.assertEquals(getPricesList().stream().sorted(Collections.reverseOrder()).collect(Collectors.toList()), getPricesList());
    }
}
