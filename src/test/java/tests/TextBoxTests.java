package tests;

import com.codeborne.selenide.Configuration;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;

public class TextBoxTests {

    @BeforeAll
    static void beforeAll(){
        Configuration.browserSize = "1920x1080";
        Configuration.baseUrl = "https://demoqa.com";
        Configuration.pageLoadStrategy = "eager";
        Configuration.holdBrowserOpen =true;
//        Configuration.timeout =5000; // default 4000
    }


    @Test
    void fillFormTest() {
        open("/text-box");
        $("#userName").setValue("Anna");
        $("#userEmail").setValue("anna@shel.com");
        $("#currentAddress").setValue("Street 23");
        $("#permanentAddress").setValue("Avenue 144");
        $("#submit").click();

        $("#output #name").shouldHave(text("Anna"));
        $("#output #email").shouldHave(text("anna@shel.com"));
        $("#output #currentAddress").shouldHave(text("Street 23"));
        $("#output  #permanentAddress").shouldHave(text("Avenue 144"));
    }


}
