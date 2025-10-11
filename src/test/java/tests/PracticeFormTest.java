package tests;

import com.codeborne.selenide.Configuration;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import static com.codeborne.selenide.Condition.appear;
import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.*;

public class PracticeFormTest {

    @BeforeAll
    static void setupEnvironment(){
        Configuration.browserSize = "1920x1080";
        Configuration.baseUrl = "https://demoqa.com";
        Configuration.pageLoadStrategy = "eager";
        open("/automation-practice-form");
        executeJavaScript("$('#fixedban').remove()");
        executeJavaScript("$('footer').remove()");
    }

    @Test
    void fillFormTest() {
        $("#firstName").setValue("Anna");
        $("#lastName").setValue("Shelyakina");
        $("#userEmail").setValue("anna@shel.com");
        $("#genterWrapper").$(byText("Female")).click();
        $("#userNumber").setValue("7878787878");
        $("#dateOfBirthInput").click();
        $(".react-datepicker__month-select").selectOption("March");
        $(".react-datepicker__year-select").selectOption("2008");
        $(".react-datepicker__day--024:not(.react-datepicker__day--outside-month)").click();
        $("#subjectsInput").setValue("Hindi").pressEnter();
        $("#hobbiesWrapper").$(byText("Reading")).click();
        $("#uploadPicture").uploadFromClasspath("img/pic1.jpg");
        $("#currentAddress").setValue("Street 123");
        $("#react-select-3-input").setValue("NCR").pressEnter();
        $("#react-select-4-input").setValue("Delhi").pressEnter();
        $("#submit").click();

        $(".modal-dialog").should(appear);
        $("#example-modal-sizes-title-lg").shouldHave(text("Thanks for submitting the form"));
        $(".table-responsive").shouldHave(text("Anna Shelyakina"),
                text("anna@shel.com"),
                text("Female"),
                text("7878787878"),
                text("24 March,2008"),
                text("Hindi"),
                text("Reading"),
                text("pic1.jpg"),
                text("Street 123"),
                text("NCR Delhi"));

        $("#closeLargeModal").click();
    }


}
