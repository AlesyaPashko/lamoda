import org.example.models.UserData;
import org.example.steps.SearchSteps;
import org.example.utils.JsonReader;
import org.testng.annotations.Test;

public class SearchTest extends BaseTest {
    SearchSteps searchSteps = new SearchSteps();

    @Test(dataProvider = "userData", dataProviderClass = JsonReader.class)
    public void searchTest(UserData userData) {
        searchSteps.searchProduct(userData.getSearchRequest());
        searchSteps.checkSearchResult(userData.getSearchRequest());
    }
}
