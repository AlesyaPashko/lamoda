package org.example.pages;


import com.codeborne.selenide.ElementsCollection;
import com.codeborne.selenide.SelenideElement;
import org.openqa.selenium.By;

import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.$$;

public class SortingPage {
    public SelenideElement sortingButton = $(By.xpath("//span[contains(text(),\"По популярности\")]"));
    public SelenideElement sortingByAscendingPriceButton = $(By.xpath("//span[contains(text(),\"По возрастанию цены\")]"));
    public SelenideElement sortingByDescendingPriceButton = $(By.xpath("//span[contains(text(),\"По убыванию цены\")]"));
    public ElementsCollection priceList = $$(By.xpath("//span[contains(@class,\"price-WE\")]"));
}
