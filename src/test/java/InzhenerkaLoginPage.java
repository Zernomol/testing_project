
import com.codeborne.selenide.SelenideElement;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;


import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;

public class InzhenerkaLoginPage {

    private SelenideElement usernameField = $("#username");

    private SelenideElement passwordField = $("[name='password']");

    private SelenideElement loginButton = $("button[type='submit']");


    public void setUsernameField(String username) {
        usernameField.setValue(username);
    }

    public void setPasswordField(String password) {
        passwordField.setValue(password);
    }


    public void clickLogin() {
        loginButton.click();
    }



    public void isLoggedIn() {
        System.out.println($("body").shouldHave(text("Привет, ")).exists());


    }
}
