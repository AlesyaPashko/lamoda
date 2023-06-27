import io.qameta.allure.Description;
import org.example.models.BasketCriteriasData;
import org.example.steps.BasketSteps;
import org.example.steps.SearchSteps;
import org.example.steps.SortingSteps;
import org.example.utils.JsonReader;
import org.testng.annotations.Test;

public class BasketTest extends BaseTest {
    SearchSteps searchSteps = new SearchSteps();
    SortingSteps sortingSteps = new SortingSteps();
    BasketSteps basketSteps = new BasketSteps();

    @Description("Check the correct list of products in the basket by criteria")
    @Test(dataProvider = "basketCriterias", dataProviderClass = JsonReader.class)
    public void basketTestByName(BasketCriteriasData basketCriteriasData) {
        searchSteps.searchProduct(basketCriteriasData.getUserData().getPositiveSearchRequest());
        sortingSteps.customizeSortingByAscendingPrice();
        basketSteps.chooseCheapestProduct();
        basketSteps.checkBasketByCriteria(basketCriteriasData.getCriteria());
    }
}
