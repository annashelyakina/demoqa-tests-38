package pages;

import com.codeborne.selenide.SelenideElement;
import pages.components.CalendarComponent;
import pages.components.ModalDialogComponent;
import pages.components.TableResultComponent;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.*;
import static com.codeborne.selenide.Selenide.executeJavaScript;

public class RegistrationPage {

    private SelenideElement

            firstNameInput= $("#firstName"),

            lastNameInput= $("#lastName"),

            userEmailInput = $("#userEmail"),

            genterWrapper = $("#genterWrapper"),

            userNumberInput =  $("#userNumber"),

            calendarInput = $("#dateOfBirthInput"),

            subjectsInput = $("#subjectsInput"),

            hobbiesWrapperInput = $("#hobbiesWrapper"),

            uploadPicture = $("#uploadPicture"),

            currentAddressInput = $("#currentAddress"),

            stateInput =  $("#state"),

            stateValueInput = $("#stateCity-wrapper"),

            cityInput = $("#city"),

            cityValueInput =  $("#stateCity-wrapper"),

            buttonSubmit = $("#submit")

        ;

    CalendarComponent  calendarComponent = new CalendarComponent();
    ModalDialogComponent modalDialogComponent = new ModalDialogComponent();
    TableResultComponent tableResultComponent = new TableResultComponent();

    public RegistrationPage openPage(){
        open("/automation-practice-form");
        $(".practice-form-wrapper").shouldHave(text("Student Registration Form"));
        executeJavaScript("$('#fixedban').remove()");
        executeJavaScript("$('footer').remove()");

        return this;
    }

    public RegistrationPage setFirstName(String value){
        firstNameInput.setValue(value);

        return this;
    }

    public RegistrationPage setLastName(String value){
        lastNameInput.setValue(value);

        return this;
    }

    public RegistrationPage setEmail(String value){
        userEmailInput.setValue(value);

        return this;
    }

    public RegistrationPage setGender(String value){
        genterWrapper.$(byText(value)).click();

        return this;

    }
    public RegistrationPage setUserNumber(String value){
        userNumberInput.setValue(value);

        return this;
    }
public RegistrationPage setDateOfBirth(String day, String month, String year){
    calendarInput.click();
    calendarComponent.setDate(day, month, year);

    return this;
    }

    public RegistrationPage setSubjects(String value){
        subjectsInput.setValue(value).pressEnter();

        return this;
    }

    public RegistrationPage setHobbiesWrapper(String value){
        hobbiesWrapperInput.$(byText(value)).click();

        return this;
    }

    public RegistrationPage setUploadPicture(String value){
        uploadPicture.uploadFromClasspath(value);

        return this;
    }

    public RegistrationPage setCurrentAddress(String value){
        currentAddressInput.setValue(value);

        return this;
    }
    public RegistrationPage setState(String value){
        stateInput.click();
        stateValueInput.$(byText(value)).click();

        return this;
    }


    public RegistrationPage setCity(String value){
        cityInput.click();
        cityValueInput.$(byText(value)).click();

        return this;
    }

    public RegistrationPage clickButtonSubmit () {
        buttonSubmit.click();

        return this;
    }

    public RegistrationPage checkModalDialog (String value) {
        modalDialogComponent.modalDialog(value);

        return this;
    }

    public RegistrationPage checkKeyValue(String key, String value){
      tableResultComponent.checkResult(key, value);

        return this;
    }

}
