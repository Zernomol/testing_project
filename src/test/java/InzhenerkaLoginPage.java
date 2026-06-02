import com.codeborne.selenide.Selenide;
import com.codeborne.selenide.SelenideElement;


import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;

public class InzhenerkaLoginPage extends BaseTest {

    private final SelenideElement usernameField = $("#username");

    private final SelenideElement passwordField = $("[name='password']");

    private final SelenideElement loginButton = $("button[type='submit']");


    public void openPage() {
        String URL = "https://qa-stand-login.inzhenerka.tech/login";
        open(URL);
    }

    public void setUsernameField(String username) {
        usernameField.setValue(username);
    }

    public void setPasswordField(String password) {
        passwordField.setValue(password);
    }


    public void clickLogin() {
        loginButton.click();
    }

    public void clickLogout() {
        SelenideElement logoutButton = $("body > div > div.row.justify-content-center > div > div > div > a");
        logoutButton.click();

    }



}
