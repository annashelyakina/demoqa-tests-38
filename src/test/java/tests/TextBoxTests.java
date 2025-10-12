package tests;

import org.junit.jupiter.api.Test;
import pages.TextBoxPage;

import static com.codeborne.selenide.Selenide.$;

public class TextBoxTests extends TestBase {

TextBoxPage textBoxPage = new TextBoxPage();

    @Test
    void fillFormTest() {
        textBoxPage.openPage()
                .checkTitle()
                .setUserName("Anna")
                .setEmail("anna@shel.com")
                .setCurrentAddress("Street 23")
                .setPermanentAddress("Avenue 144")
                .clickButtonSubmit()
                .resultCheck("Anna")
                .resultCheck("anna@shel.com")
                .resultCheck("Street 23")
                .resultCheck("Avenue 144")
                ;
    }


}
