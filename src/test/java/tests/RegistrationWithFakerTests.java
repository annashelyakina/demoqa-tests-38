package tests;

import com.github.javafaker.Faker;
import org.junit.jupiter.api.Test;
import pages.RegistrationPage;

import java.util.Locale;

public class RegistrationWithFakerTests extends TestBase {

    RegistrationPage registrationPage = new RegistrationPage();

    @Test
    void successfulRegistrationTest() {

        Faker faker = new Faker(new Locale("en-GB"));

        String firstName = faker.name().firstName();
        String lastName = faker.name().lastName();
        String userEmail = faker.internet().emailAddress();
        String userGender = faker.demographic().sex();
        String userPhoneNumber = faker.phoneNumber().subscriberNumber(10);
        String userAddress = faker.address().streetAddress();


        registrationPage.openPage()
            .checkTitle()
            .hideBanners()
            .setFirstName(firstName)
            .setLastName(lastName)
            .setEmail(userEmail)
            .setGender(userGender)
            .setUserNumber(userPhoneNumber)
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
            .checkKeyValue("Mobile", userPhoneNumber)
            .checkKeyValue("Date of Birth", "30 July,2008")
            .checkKeyValue("Subjects", "Math")
            .checkKeyValue("Hobbies", "Sports")
            .checkKeyValue("Picture", "pic1.jpg")
            .checkKeyValue("Address", userAddress)
            .checkKeyValue("State and City", "NCR Delhi")
        ;

    }
}