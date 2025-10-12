package tests;

import org.junit.jupiter.api.Test;
import pages.RegistrationPage;

public class RegistrationWithPageObjectsTests extends TestBase {

    RegistrationPage registrationPage = new RegistrationPage();

    @Test
    void successfulRegistrationTest() {

        registrationPage.openPage()
            .checkTitle()
            .hideBanners()
            .setFirstName("Anna")
            .setLastName("Shelyakina")
            .setEmail("anna@shel.com")
            .setGender("Female")
            .setUserNumber("1234567890")
            .setDateOfBirth( "30", "July", "2008")
            .setSubjects("Math")
            .setHobbiesWrapper("Sports")
            .setUploadPicture("img/pic1.jpg")
            .setCurrentAddress("Street 123")
            .setState("NCR")
            .setCity("Delhi")
            .clickButtonSubmit()
            .checkModalDialog("Thanks for submitting the form")
            .checkKeyValue("Student Name", "Anna Shelyakina")
            .checkKeyValue("Student Email", "anna@shel.com")
            .checkKeyValue("Gender", "Female")
            .checkKeyValue("Mobile", "1234567890")
            .checkKeyValue("Date of Birth", "30 July,2008")
            .checkKeyValue("Subjects", "Math")
            .checkKeyValue("Hobbies", "Sports")
            .checkKeyValue("Picture", "pic1.jpg")
            .checkKeyValue("Address", "Street 123")
            .checkKeyValue("State and City", "NCR Delhi")
        ;

    }
}