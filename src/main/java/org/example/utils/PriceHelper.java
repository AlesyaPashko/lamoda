package org.example.utils;

import com.codeborne.selenide.ElementsCollection;
import com.codeborne.selenide.SelenideElement;
import lombok.extern.log4j.Log4j2;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

@Log4j2
public class PriceHelper {

    public static String searchRightPrice(ElementsCollection priceList, String criteria) {
        log.info("Search right price");
        double highestPrice = 0;
        String highestPriceString = null;
        double lowestPrice = Double.MAX_VALUE;

        for (SelenideElement productPrice : priceList) {
            String priceString = productPrice.getText().replace(" ", "");
            Pattern pat = Pattern.compile("-?[0-9]+(.[0-9]+)?");
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
        if (criteria.equals("lowest")) {
            return String.valueOf(lowestPrice);
        }
        return highestPriceString;
    }
}
