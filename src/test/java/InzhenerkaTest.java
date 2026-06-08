import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

public class InzhenerkaTest extends BaseTest {

    @ParameterizedTest
    @CsvSource({
            "testuser, password123",
            "user, user123"

    })
    @DisplayName("Проверка логина")
    public void Test(String name, String password) {
        InzhenerkaLoginPage loginPage = new InzhenerkaLoginPage();

        loginPage.setUsernameField(name);
        loginPage.setPasswordField(password);
        loginPage.clickLogin();
        loginPage.isLoggedIn();



    }

}
