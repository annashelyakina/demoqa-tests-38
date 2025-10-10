package tests;

import com.codeborne.selenide.Configuration;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import java.io.File;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.*;

public class PracticeFormTest {

    @BeforeAll
    static void beforeAll(){
        Configuration.browserSize = "1920x1080";
        Configuration.baseUrl = "https://demoqa.com";
        Configuration.pageLoadStrategy = "eager";
//        Configuration.holdBrowserOpen =true;
    }

    @Test
    void fillFormTest() {
        open("/automation-practice-form");
        $("#firstName").setValue("Anna");
        $("#lastName").setValue("Shelyakina");
        $("#userEmail").setValue("anna@shel.com");
        $x("//label[@for='gender-radio-2']").click();
        $("#userNumber").setValue("7878787878");
        $("#dateOfBirthInput").click();
        $x("//option[@value='1985']").click();
        $x("//option[@value='3']").click();
        $(".react-datepicker__day--024").click();
        $("#subjectsInput").setValue("Hindi").pressEnter();
        $x("//label[@for='hobbies-checkbox-2']").click();
        $("#uploadPicture").uploadFromClasspath("pic1.jpg");
        $("#currentAddress").setValue("Street 123");
        $("#react-select-3-input").setValue("NCR").pressEnter();
        $("#react-select-4-input").setValue("Delhi").pressEnter();
        $x("//button[@id='submit']").click();

        $("#example-modal-sizes-title-lg").shouldHave(text("Thanks for submitting the form"));

        $(byText("Anna Shelyakina"));
        $(byText("anna@shel.com"));
        $(byText("Female"));
        $(byText("7878787878"));
        $(byText("24 April,1985"));
        $(byText("Hindi"));
        $(byText("Reading"));
        $(byText("pic1.jpg"));
        $(byText("Street 123"));
        $(byText("NCR Delhi"));

        $("#closeLargeModal").click();
    }


}
