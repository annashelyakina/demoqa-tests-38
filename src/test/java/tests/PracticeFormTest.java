package tests;

import com.codeborne.selenide.Configuration;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import java.io.File;

import static com.codeborne.selenide.Selenide.*;

public class PracticeFormTest {

    @BeforeAll
    static void beforeAll(){
        Configuration.browserSize = "1920x1080";
        Configuration.baseUrl = "https://demoqa.com";
        Configuration.pageLoadStrategy = "eager";
        Configuration.holdBrowserOpen =true;
//        Configuration.timeout = 10000;
    }

    @Test
    void fillFormTest() {
        File fileToUpload = new File("C:/tmp/pic1.jpg");
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
        $("#uploadPicture").uploadFile(fileToUpload);
        $("#currentAddress").setValue("Street 123");
        $("#react-select-3-input").setValue("NCR").pressEnter();
        $("#react-select-4-input").setValue("Delhi").pressEnter();

        $x("//button[@id='submit']").click();
    }


}
