package tests;

import com.github.javafaker.Faker;
import java.util.Locale;

public class TestData {

    static Faker faker = new Faker(new Locale("en-GB"));

    public static String getFirstNameFaker(){

        return faker.name().firstName();
    }

    public static String getLastNameFaker(){

        return faker.name().lastName();
    }

    public static String getUserEmailFaker(){

        return faker.internet().emailAddress();
    }

    public static String getUserGenderFaker(){

        return faker.demographic().sex();
    }

    public static String getUserPhoneNumbFaker(){

        return faker.phoneNumber().subscriberNumber(10);
    }

    public static String getUserAddressFaker(){

        return faker.address().streetAddress();
    }

}