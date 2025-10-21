package guru.qa;

import com.codeborne.selenide.Configuration;
import org.junit.jupiter.api.*;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.*;
import static com.codeborne.selenide.Selenide.$;

public class NifflerWebTestsWithAnnotations {


    @BeforeAll
    static void beforeAll(){

        Configuration.pageLoadStrategy="eager";
    }

    @BeforeEach
    void setUp() {

        open("https://auth.niffler.qa.guru/");
    }

    @CsvSource(value = {
            "Demo1,demo1"
    })
    @ParameterizedTest(name = "Авторизация пользователя {0} с паролем {1} на сайте")
    @Tag("BLOCKER")
    void userAuthorizationOnSite(String login, String password) {

        $("#username").setValue(login);
        $("#password").setValue(password);
        $("#login-button").click();
        $("[data-testid=PersonIcon]").click();
        $("[role=menu]").$(byText("Sign out")).click();
        $("[role=dialog]").$(byText("Log out")).click();
    }


    @CsvSource(value = {
            "Milk,55",
            "Bread,100"
    })
    @ParameterizedTest(name = "Создание новой категории расходов {0} с указанием суммы {1}")
    @Tag("BLOCKER")
    void addNewSpendingWithAmount(String spending, String amount) {

        $("#username").setValue("Demo1");
        $("#password").setValue("demo1");
        $("#login-button").click();
        $("header").$(byText("New spending")).click();
        $("#amount").setValue(amount);
        $("ul").$(byText(spending)).click();
        $("#save").click();
        $("[data-testid=PersonIcon]").click();
        $("[role=menu]").$(byText("Sign out")).click();
        $("[role=dialog]").$(byText("Log out")).click();
    }

    @CsvSource(value = {
            "Milk,55",
            "Bread,100"
    })
    @ParameterizedTest(name = "Удаление существующей категории расходов {0} с конкретной суммой {1}")
    @Tag("BLOCKER")
    void deleteExistingSpendingWithAmount(String spending, String amount) {

        $("#username").setValue("Demo1");
        $("#password").setValue("demo1");
        $("#login-button").click();
        $("header").$(byText("New spending")).click();
        $("#amount").setValue(amount);
        sleep(3000);
        $("ul").$(byText(spending)).click();
        $("#save").click();
        $("[placeholder=Search]").setValue(spending).pressEnter();
        $("tbody").$("tr").shouldHave(text(spending)).shouldHave(text(amount));
        $("td").$("[type=checkbox]").click();
        $("#delete").click();
        $("[role=dialog]").shouldHave(text("Delete spendings?"));
        $("[role=dialog]").$(byText("Delete")).click();
        $("header").$(byText("New spending")).click();
        $("[data-testid=PersonIcon]").click();
        $("[role=menu]").$(byText("Sign out")).click();
        $("[role=dialog]").$(byText("Log out")).click();
    }


    @Test
    @Tag("BLOCKER")
    @DisplayName("Логаут пользователя на сайте")
    void userLogoutFromSite() {

        $("#username").setValue("Demo1");
        $("#password").setValue("demo1");
        $("#login-button").click();
        $("[data-testid=PersonIcon]").click();
        $("[role=menu]").$(byText("Sign out")).click();
        $("[role=dialog]").$(byText("Log out")).click();
    }
}
