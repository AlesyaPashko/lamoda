import com.codeborne.selenide.ElementsCollection;
import com.codeborne.selenide.Selenide;
import com.codeborne.selenide.SelenideElement;
import org.example.models.UserData;
import org.example.utils.JsonReader;
import org.example.utils.Waiters;
import org.openqa.selenium.By;
import org.testng.annotations.Test;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.$$;

public class WildberriesTest extends BaseTest  {

    @Test(dataProvider = "userData", dataProviderClass = JsonReader.class)
    public void searchTest(UserData userData) {
        searchProduct(userData.getSearchRequest());
        $(By.xpath("//h2")).shouldHave(text(userData.getSearchRequest()));
    }
    @Test(dataProvider = "userData", dataProviderClass = JsonReader.class)
    public void sortingByAscendingPriceTest(UserData userData) {
        searchProduct(userData.getSearchRequest());
        openSortingByAscendingPrice();
        ElementsCollection priceList = $$(By.xpath("//span[contains(@class,\"price-WE\")]"));
        Waiters.waiter();
        priceList.get(0).shouldHave(text(searchLowestPrice(priceList)));

    }
    @Test(dataProvider = "userData", dataProviderClass = JsonReader.class)
    public void sortingByDescendingPriceTest(UserData userData) {
        searchProduct(userData.getSearchRequest());
        openSortingByDescendingPrice();
        ElementsCollection priceList = $$(By.xpath("//span[contains(@class,\"price-WE\")]"));
        Waiters.waiter();
        priceList.get(0).shouldHave(text(searchHighestPrice(priceList)));

    }
    public void searchProduct(String searchRequest) {
        $(By.xpath("//button[contains(@class,'_button_1su1z')]")).click();
        $(By.xpath("//input[contains(@class,'_input_1su1z_19')]")).setValue(searchRequest);
        $(By.xpath("//button[contains(@class,'_button_1su1z')]")).click();
    }
    public void openSortingByAscendingPrice() {
        $(By.xpath("//span[contains(text(),\"По популярности\")]")).click();
        $(By.xpath("//span[contains(text(),\"По возрастанию цены\")]")).click();
    }
    public void openSortingByDescendingPrice() {
        $(By.xpath("//span[contains(text(),\"По популярности\")]")).click();
        $(By.xpath("//span[contains(text(),\"По убыванию цены\")]")).click();
    }
    public String searchLowestPrice(ElementsCollection priceList){
        double lowestPrice = Double.MAX_VALUE;

        for (SelenideElement productPrice : priceList) {
            Pattern pat = Pattern.compile("[-]?[0-9]+(.[0-9]+)?");
            Matcher matcher = pat.matcher(productPrice.getText());
            while (matcher.find()) {
                String priceText = matcher.group();
                double price = Double.parseDouble(priceText);
                if (price < lowestPrice) {
                    lowestPrice = price;
                }
            }
        }
        return String.valueOf(lowestPrice);
    }
    public String searchHighestPrice(ElementsCollection priceList){
        double highestPrice = 0;
        String highestPriceString = null;

        for (SelenideElement productPrice : priceList) {
            String priceString = productPrice.getText().replace(" ","");
            Pattern pat = Pattern.compile("[-]?[0-9]+(.[0-9]+)?");
            Matcher matcher = pat.matcher(priceString);
            while (matcher.find()) {
                String priceText = matcher.group();
                double price = Double.parseDouble(priceText);
                if (price > highestPrice) {
                    highestPrice = price;
                    highestPriceString = productPrice.getText();
                }
            }
        }
        return highestPriceString;
    }

}
