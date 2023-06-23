import io.qameta.allure.Description;
import org.example.models.UserData;
import org.example.steps.BasketSteps;
import org.example.steps.SearchSteps;
import org.example.steps.SortingSteps;
import org.example.utils.JsonReader;
import org.testng.annotations.Test;

public class BasketTest extends BaseTest {
    SearchSteps searchSteps = new SearchSteps();
    SortingSteps sortingSteps = new SortingSteps();
    BasketSteps basketSteps = new BasketSteps();

    @Description("Check the correct list of products in the basket")
    @Test(dataProvider = "userData", dataProviderClass = JsonReader.class)
    public void basketTestByName(UserData userData) {
        searchSteps.searchProduct(userData.getPositiveSearchRequest());
        sortingSteps.customizeSortingByAscendingPrice();
        basketSteps.chooseCheapestProduct();
        basketSteps.checkBasketByCriteria(basketSteps.getProductName());
    }

    @Description("Check the correct total price in the basket")
    @Test(dataProvider = "userData", dataProviderClass = JsonReader.class)
    public void basketTestByPrice(UserData userData) {
        searchSteps.searchProduct(userData.getPositiveSearchRequest());
        sortingSteps.customizeSortingByAscendingPrice();
        basketSteps.chooseCheapestProduct();
        basketSteps.checkBasketByCriteria(basketSteps.getProductPrice());
    }
}
