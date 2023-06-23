import io.qameta.allure.Description;
import org.example.utils.JsonReader;
import org.example.models.UserData;
import org.example.steps.SearchSteps;
import org.example.steps.SortingSteps;
import org.testng.annotations.Test;

public class SortingTest extends BaseTest {
    SearchSteps searchSteps = new SearchSteps();
    SortingSteps sortingSteps = new SortingSteps();

    @Description("Check the correct sorting of products by ascending price")
    @Test(dataProvider = "userData", dataProviderClass = JsonReader.class)
    public void sortingByAscendingPriceTest(UserData userData) {
        searchSteps.searchProduct(userData.getPositiveSearchRequest());
        sortingSteps.customizeSortingByAscendingPrice();
        sortingSteps.checkRightSortingByAscendingPrice();
    }

    @Description("Check the correct sorting of products by decreasing price")
    @Test(dataProvider = "userData", dataProviderClass = JsonReader.class)
    public void sortingByDescendingPriceTest(UserData userData) {
        searchSteps.searchProduct(userData.getPositiveSearchRequest());
        sortingSteps.customizeSortingByDescendingPrice();
        sortingSteps.checkRightSortingByDescendingPrice();
    }
}
