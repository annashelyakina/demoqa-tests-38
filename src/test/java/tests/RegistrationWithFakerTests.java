package tests;

import org.junit.jupiter.api.Test;
import pages.RegistrationPage;

public class RegistrationWithFakerTests extends TestBase {

    RegistrationPage registrationPage = new RegistrationPage();

    @Test
    void successfulRegistrationTest() {

        String firstName = TestData.getFirstNameFaker();
        String lastName = TestData.getLastNameFaker();
        String userEmail = TestData.getUserEmailFaker();
        String userGender = TestData.getUserGenderFaker();
        String userNumber = TestData.getUserPhoneNumbFaker();
        String userAddress = TestData.getUserAddressFaker();

        registrationPage.openPage()
            .checkTitle()
            .hideBanners()
            .setFirstName(firstName)
            .setLastName(lastName)
            .setEmail(userEmail)
            .setGender(userGender)
            .setUserNumber(userNumber)
            .setDateOfBirth("30", "July", "2008")
            .setSubjects("Math")
            .setHobbiesWrapper("Sports")
            .setUploadPicture("img/pic1.jpg")
            .setCurrentAddress(userAddress)
            .setState("NCR")
            .setCity("Delhi")
            .clickButtonSubmit()
            .checkModalDialog("Thanks for submitting the form")
            .checkKeyValue("Student Name", firstName + " " + lastName)
            .checkKeyValue("Student Email", userEmail)
            .checkKeyValue("Gender", userGender)
            .checkKeyValue("Mobile", userNumber)
            .checkKeyValue("Date of Birth", "30 July,2008")
            .checkKeyValue("Subjects", "Math")
            .checkKeyValue("Hobbies", "Sports")
            .checkKeyValue("Picture", "pic1.jpg")
            .checkKeyValue("Address", userAddress)
            .checkKeyValue("State and City", "NCR Delhi")
        ;

    }
}