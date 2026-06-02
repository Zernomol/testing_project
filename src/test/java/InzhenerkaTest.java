import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class InzhenerkaTest {

    @Test
    @DisplayName("Проверка логина testUser")
    public void Test()
    {
        InzhenerkaLoginPage loginPage = new InzhenerkaLoginPage();
        loginPage.openPage();
        loginPage.setUsernameField("testuser");
        loginPage.setPasswordField("password123");
        loginPage.clickLogin();

        loginPage.clickLogout();


    }
}
