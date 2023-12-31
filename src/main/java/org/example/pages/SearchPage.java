package org.example.pages;

import com.codeborne.selenide.SelenideElement;
import org.openqa.selenium.By;

import static com.codeborne.selenide.Selenide.$;

public class SearchPage {
    public SelenideElement searchButton = $(By.xpath("//button[contains(@class,'_button_1su1z')]"));
    public SelenideElement requestField = $(By.xpath("//input[contains(@class,'_input_1su1z_19')]"));
    public SelenideElement searchResult = $(By.xpath("//span[contains(@class,\"_pro\")]"));
    public SelenideElement warningText = $(By.xpath("//p[@class=\"_text_1jpla_30\"]"));
}
