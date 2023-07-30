package org.example.steps;

import io.qameta.allure.Step;
import lombok.extern.log4j.Log4j2;
import org.example.pages.SortingPage;
import org.example.utils.PriceConverter;
import org.testng.Assert;

import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

@Log4j2
public class SortingSteps {

    SortingPage sortingPage = new SortingPage();

    @Step("Customize sorting by ascending price")
    public void customizeSortingByAscendingPrice() {
        log.info("Customize sorting by ascending price");
        sortingPage.sortingButton.click();
        sortingPage.sortingByAscendingPriceButton.click();
    }

    @Step("Customize sorting by descending price")
    public void customizeSortingByDescendingPrice() {
        log.info("Customize sorting by descending price");
        sortingPage.sortingButton.click();
        sortingPage.sortingByDescendingPriceButton.click();
    }

    @Step("Get prices list")
    public List<Double> getPricesList() {
        log.info("Get prices list");
        return PriceConverter.getOriginPricesList(sortingPage.priceList);
    }

    @Step("Check right sorting by ascending price")
    public void checkRightSortingByAscendingPrice() {
        log.info("Check right sorting by ascending price");
        Assert.assertEquals(getPricesList().stream().sorted().collect(Collectors.toList()), getPricesList());
    }

    @Step("Check right sorting by descending price")
    public void checkRightSortingByDescendingPrice() {
        log.info("Check right sorting by descending price");
        Assert.assertEquals(getPricesList().stream().sorted(Collections.reverseOrder()).collect(Collectors.toList()), getPricesList());
    }
}
