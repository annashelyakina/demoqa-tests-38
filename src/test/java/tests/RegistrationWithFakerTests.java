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
        String day = TestData.getDay();
        String month = TestData.getMonth();
        String year = TestData.getYear();
        String userAddress = TestData.getUserAddressFaker();
        String userSubjects = TestData.getUserSubjects();
        String userHobbies = TestData.getUserHobbies();
        String userPicture = TestData.getUserPicture();
        String userState = TestData.getUserState();
        String userCity = TestData.getUserCity(userState);

        registrationPage.openPage()
            .checkTitle()
            .hideBanners()
            .setFirstName(firstName)
            .setLastName(lastName)
            .setEmail(userEmail)
            .setGender(userGender)
            .setUserNumber(userNumber)
            .setDateOfBirth(day, month, year)
            .setSubjects(userSubjects)
            .setHobbiesWrapper(userHobbies)
            .setUploadPicture("img/" + userPicture)
            .setCurrentAddress(userAddress)
            .setState(userState)
            .setCity(userCity)
            .clickButtonSubmit()
            .checkModalDialog("Thanks for submitting the form")
            .checkKeyValue("Student Name", firstName + " " + lastName)
            .checkKeyValue("Student Email", userEmail)
            .checkKeyValue("Gender", userGender)
            .checkKeyValue("Mobile", userNumber)
            .checkKeyValue("Date of Birth", day + " " + month +  "," + year)
            .checkKeyValue("Subjects", userSubjects)
            .checkKeyValue("Hobbies", userHobbies)
            .checkKeyValue("Picture", userPicture)
            .checkKeyValue("Address", userAddress)
            .checkKeyValue("State and City", userState + " " + userCity)
        ;

    }
}