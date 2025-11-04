package tests;

import com.codeborne.selenide.Configuration;
import com.codeborne.selenide.logevents.SelenideLogger;
import helpers.Attach;
import io.qameta.allure.selenide.AllureSelenide;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.remote.DesiredCapabilities;
import pages.RegistrationPage;

import java.util.Map;

import static io.qameta.allure.Allure.step;
import static tests.StaticTexts.*;

public class RegistrationRemotePropertiesWithFakerTests extends TestBaseRemote {

    RegistrationPage registrationPage = new RegistrationPage();

    @AfterEach
    void addAttachments() {
        Attach.screenshotAs("Last screenshot");
        Attach.pageSource();
        Attach.browserConsoleLogs();
        Attach.addVideo();
    }


    @Test
    @Tag("demoqa_property")
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


        step ("Open form", () -> {
            registrationPage.openPage()
                    .checkTitle()
                    .hideBanners()
            ;
        });
        step ("Fill form", () -> {
            registrationPage.setFirstName(firstName)
                    .setLastName(lastName)
                    .setEmail(userEmail)
                    .setGender(userGender)
                    .setUserNumber(userNumber)
                    .setDateOfBirth(day, month, year)
                    .setSubjects(userSubjects)
                    .setHobbiesWrapper(userHobbies)
                    .setUploadPicture(folderText + userPicture)
                    .setCurrentAddress(userAddress)
                    .setState(userState)
                    .setCity(userCity)
                    .clickButtonSubmit()
            ;
        });
        step ("Check modal dialog with results", () ->{
            registrationPage.checkModalDialog(modalDialogTitle)
            .checkKeyValue(studentNameText, firstName + " " + lastName)
            .checkKeyValue(studentEmailText, userEmail)
            .checkKeyValue(genderText, userGender)
            .checkKeyValue(mobileText, userNumber)
            .checkKeyValue(dateOfBirthText, day + " " + month +  "," + year)
            .checkKeyValue(subjectsText, userSubjects)
            .checkKeyValue(hobbiesText, userHobbies)
            .checkKeyValue(pictureText, userPicture)
            .checkKeyValue(addressText, userAddress)
            .checkKeyValue(stateCityText, userState + " " + userCity)
        ;
        });
    }
}