package org.example.pages;

import com.codeborne.selenide.ElementsCollection;
import com.codeborne.selenide.SelenideElement;
import org.openqa.selenium.By;

import static com.codeborne.selenide.Selectors.*;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.$$;

public class SortingPage {
    public SelenideElement sortingButton = $(withText("популярности"));
    public SelenideElement sortingByAscendingPriceButton = $(withText("возрастанию"));
    public SelenideElement sortingByDescendingPriceButton = $(withText("убыванию"));
    public ElementsCollection priceList = $$(By.xpath("//span[contains(@class,\"price-WE\")]"));
}
