package tests;

import org.junit.jupiter.api.Test;
import pages.RegistrationPage;

import static com.codeborne.selenide.Condition.*;
import static com.codeborne.selenide.Selenide.$;

public class NegativeWithPageObjectsTests extends TestBase {

    RegistrationPage registrationPage = new RegistrationPage();

    @Test
    void negativeTest() {

        registrationPage.openPage()
            .checkTitle()
            .hideBanners()
            .setFirstName("Anna")
            .setLastName("Shelyakina")
            .setGender("Female")
            .setUserNumber("aaaaaaaaaa")
            .setDateOfBirth( "30", "July", "2008")
            .clickButtonSubmit()
            ;

        $(".modal-dialog").should(disappear);
    }
}