package org.example.steps;

import com.codeborne.selenide.CollectionCondition;
import com.codeborne.selenide.Condition;
import io.qameta.allure.Step;
import org.example.pages.BasketPage;
import org.example.utils.Waiters;

public class BasketSteps {
    BasketPage basketPage = new BasketPage();

    @Step("Choose cheapest product")
    public void chooseCheapestProduct() {
        basketPage.productButtons.get(0).click();
        Waiters.sleep();
        if (basketPage.sizeList.size() > 0) {
            basketPage.sizeList.get(0).click();
        } else if (basketPage.sizeListScroll.size() > 0) {
            basketPage.sizeListScroll.get(0).click();
            Waiters.sleep();
            basketPage.sizeButtons.get(0).click();
        }
    }

    @Step("Get product name")
    public String getProductName() {
        return basketPage.productName.getText();
    }

    @Step("Get product price")
    public String getProductPrice() {
        return basketPage.productPrice.getText();
    }

    @Step("Check basket by criteria")
    public void checkBasketByCriteria(String criteria) {
        basketPage.putInBasketButton.click();
        basketPage.openBasketButton.click();
        basketPage.productListInBasket
                .filter(Condition.text(criteria))
                .shouldHave(CollectionCondition.sizeGreaterThan(0));
    }
}
