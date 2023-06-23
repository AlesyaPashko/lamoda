package org.example.steps;

import com.codeborne.selenide.SelenideElement;
import io.qameta.allure.Step;
import org.example.pages.SortingPage;
import org.example.utils.Waiters;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

import static com.codeborne.selenide.Condition.text;

public class SortingSteps {
    SortingPage sortingPage = new SortingPage();

    @Step("Customize sorting by ascending price")
    public void customizeSortingByAscendingPrice(){
        sortingPage.sortingButton.click();
        sortingPage.sortingByAscendingPriceButton.click();
        Waiters.waiter();
    }
    @Step("Customize sorting by descending price")
    public void customizeSortingByDescendingPrice(){
        sortingPage.sortingButton.click();
        sortingPage.sortingByDescendingPriceButton.click();
        Waiters.waiter();
    }
    @Step("Search right price")
    public String searchRightPrice(String criteria){
        double highestPrice = 0;
        String highestPriceString = null;
        double lowestPrice = Double.MAX_VALUE;

        for (SelenideElement productPrice : sortingPage.priceList) {
            String priceString = productPrice.getText().replace(" ","");
            Pattern pat = Pattern.compile("[-]?[0-9]+(.[0-9]+)?");
            Matcher matcher = pat.matcher(priceString);
            while (matcher.find()) {
                double price = Double.parseDouble(matcher.group());
                if (price > highestPrice) {
                    highestPrice = price;
                    highestPriceString = productPrice.getText();
                }
                if (price < lowestPrice) {
                    lowestPrice = price;
                }
            }
        }
        if (criteria.equals("lowest")){
            return String.valueOf(lowestPrice);
        }
        return highestPriceString;
    }
    @Step("Check right sorting by ascending price")
    public void checkRightSortingByAscendingPrice(){
        sortingPage.priceList.get(0).shouldHave(text(searchRightPrice("lowest")));
    }
    @Step("Check right sorting by descending price")
    public void checkRightSortingByDescendingPrice(){
        sortingPage.priceList.get(0).shouldHave(text(searchRightPrice("highest")));
    }
}
