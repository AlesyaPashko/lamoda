package org.example.utils;

import com.codeborne.selenide.ElementsCollection;
import com.codeborne.selenide.SelenideElement;
import lombok.extern.log4j.Log4j2;

import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

@Log4j2
public class PriceConverter {

    public static List<Double> getOriginPricesList(ElementsCollection priceList) {
        log.info("Get double prices list");
        Waiters.sleep();
        List<Double> priceListOriginal = new ArrayList<Double>();

        for (SelenideElement productPrice : priceList) {
            String priceString = productPrice.getText().replace(" ", "");
            Pattern pat = Pattern.compile("-?[0-9]+(.[0-9]+)?");
            Matcher matcher = pat.matcher(priceString);
            while (matcher.find()) {
                priceListOriginal.add(Double.parseDouble(matcher.group()));
            }
        }
        return priceListOriginal;
    }
}
