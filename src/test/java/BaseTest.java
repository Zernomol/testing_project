import com.codeborne.selenide.Configuration;
import com.codeborne.selenide.SelenideElement;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;

import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;

public class BaseTest {
    @BeforeAll
    public static void setUp() {
        //Configuration.browser="firefox";
        Configuration.browserSize = "1920x1080";
    }

    @BeforeEach
    public void openPage() {

        String URL = "https://qa-stand-login.inzhenerka.tech/login";
        open(URL);
    }

    ;

    @AfterEach
    public void clickLogout() {
        SelenideElement logoutButton = $("body > div > div.row.justify-content-center > div > div > div > a");
        logoutButton.click();

    }
}
