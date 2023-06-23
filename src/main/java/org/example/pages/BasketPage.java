package org.example.pages;

import com.codeborne.selenide.ElementsCollection;
import com.codeborne.selenide.SelenideElement;
import org.openqa.selenium.By;

import static com.codeborne.selenide.Selectors.withText;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.$$;

public class BasketPage {
    public ElementsCollection productButtons = $$(By.xpath("//a[contains(@class,\"rd_\")]"));
    public SelenideElement putInBasketButton = $(withText("корзину"));
    public ElementsCollection sizeList = $$(By.xpath("//div[contains(@class,\"_root_xc5u8_2\")]"));
    public ElementsCollection sizeListScroll = $$(By.xpath("//div[contains(@class,\"_select_\")]"));
    public ElementsCollection sizeButtons = $$(By.xpath("//div[contains(@class,\"_colspanMain_\")]"));
    public SelenideElement productName = $(By.xpath("//div[contains(@class,'_modelName')]"));
    public ElementsCollection productListInBasket = $$(By.xpath("//div[@class=\"_category_1uvko_64\"]"));
    public SelenideElement productPrice = $(By.xpath("//span[@aria-label=\"Итоговая цена\"]"));
    public SelenideElement openBasketButton = $(By.xpath("//a[@href=\"/checkout/cart/\"][@type=\"button\"]"));
}
