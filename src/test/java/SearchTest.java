import io.qameta.allure.Description;
import org.example.models.UserData;
import org.example.steps.SearchSteps;
import org.example.utils.JsonReader;
import org.testng.annotations.Test;

public class SearchTest extends BaseTest {
    SearchSteps searchSteps = new SearchSteps();

    @Description("Check the correct work search with normal request")
    @Test(dataProvider = "userData", dataProviderClass = JsonReader.class)
    public void isSearchResultVisible(UserData userData) {
        searchSteps.searchProduct(userData.getPositiveSearchRequest());
        searchSteps.isSearchResultVisible();
    }

    @Description("Check the correct work search with wrong request")
    @Test(dataProvider = "userData", dataProviderClass = JsonReader.class)
    public void isEmptyResultMessageVisible(UserData userData) {
        searchSteps.searchProduct(userData.getNegativeSearchRequest());
        searchSteps.isEmptyResultMessageVisible(userData.getWarningText());
    }
}
