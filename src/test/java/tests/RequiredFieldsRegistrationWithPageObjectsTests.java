package tests;

import org.junit.jupiter.api.Test;
import pages.RegistrationPage;

public class RequiredFieldsRegistrationWithPageObjectsTests extends TestBase {

    RegistrationPage registrationPage = new RegistrationPage();

    @Test
    void successfulRegistrationTest() {

        registrationPage.openPage()
            .checkTitle()
            .hideBanners()
            .setFirstName("Anna")
            .setLastName("Shelyakina")
            .setGender("Female")
            .setUserNumber("1234567890")
            .setDateOfBirth( "14", "July", "2008")
            .clickButtonSubmit()
            .checkModalDialog("Thanks for submitting the form")
            .checkKeyValue("Student Name", "Anna Shelyakina")
            .checkKeyValue("Gender", "Female")
            .checkKeyValue("Mobile", "1234567890")
            .checkKeyValue("Date of Birth", "14  July,2008")
             ;

    }
}