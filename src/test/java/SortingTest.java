import com.google.gson.stream.JsonReader;
import org.example.models.UserData;
import org.example.steps.SearchSteps;
import org.example.steps.SortingSteps;
import org.testng.annotations.Test;

public class SortingTest extends BaseTest {
    SearchSteps searchSteps = new SearchSteps();
    SortingSteps sortingSteps = new SortingSteps();
    @Test(dataProvider = "userData", dataProviderClass = JsonReader.class)
    public void sortingByAscendingPriceTest(UserData userData) {
        searchSteps.searchProduct(userData.getSearchRequest());
        sortingSteps.customizeSortingByAscendingPrice();
        sortingSteps.checkRightSortingByAscendingPrice();
    }
    @Test(dataProvider = "userData", dataProviderClass = JsonReader.class)
    public void sortingByDescendingPriceTest(UserData userData) {
        searchSteps.searchProduct(userData.getSearchRequest());
        sortingSteps.customizeSortingByDescendingPrice();
        sortingSteps.checkRightSortingByDescendingPrice();
    }
}
