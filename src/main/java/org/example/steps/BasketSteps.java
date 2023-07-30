package org.example.steps;

import com.codeborne.selenide.CollectionCondition;
import com.codeborne.selenide.Condition;
import io.qameta.allure.Step;
import lombok.extern.log4j.Log4j2;
import org.example.pages.BasketPage;

@Log4j2
public class BasketSteps {
    BasketPage basketPage = new BasketPage();

    @Step("Choose cheapest product")
    public void chooseCheapestProduct() {
        log.info("Choose cheapest product");
        basketPage.productButtons.get(0).click();
        if (basketPage.sizeList.size() > 0) {
            basketPage.sizeList.get(0).click();
        } else if (basketPage.sizeListScroll.size() > 0) {
            basketPage.sizeListScroll.get(0).click();
            basketPage.sizeButtons.get(0).click();
        }
    }

    public String getProductCharacteristicByCriteria(String criteria) {
        log.info("Get product characteristic by criteria");
        if (criteria.equals("price")) {
            return basketPage.productPrice.getText();
        }
        return basketPage.productName.getText();
    }

    @Step("Check basket by criteria")
    public void checkBasketByCriteria(String criteria) {
        log.info("Check basket by criteria");
        String readProductCriteria = getProductCharacteristicByCriteria(criteria);
        basketPage.putInBasketButton.click();
        basketPage.openBasketButton.click();
        basketPage.productListInBasket
                .filter(Condition.text(readProductCriteria))
                .shouldHave(CollectionCondition.sizeGreaterThan(0));
    }
}
