package tests;

import com.github.javafaker.Faker;
import java.util.Locale;
import java.util.Objects;

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

    public static String getDay(){

        return String.format("%s", faker.number().numberBetween(1, 28));
    }

    public static String getMonth(){

        return  faker.options().option("January", "February", "March", "April",
                "May", "June", "July", "August", "September", "October", "November", "December");
    }

    public static String getYear(){

        return String.format("%s", faker.number().numberBetween(1950, 2024));
    }

    public static String getUserAddressFaker(){

        return faker.address().streetAddress();
    }

    public static String getUserSubjects(){

        return faker.options().option("Maths", "English", "History","Chemistry");
    }

    public static String getUserHobbies(){

        return faker.options().option("Sports", "Reading", "Music");
    }
    public static String getUserPicture(){

        return faker.options().option("pic1.jpg", "pic2.jpg", "pic3.jpg", "pic4.jpg");
    }

    public static String getUserState(){

        return faker.options().option("NCR", "Uttar Pradesh", "Haryana", "Rajasthan");
    }

    public  static String getUserCity(String state) {
        String city = "";

        if (Objects.equals(state, "NCR")) {
            city =  faker.options().option("Delhi", "Gurgaon", "Noida");
        } else if (Objects.equals(state, "Uttar Pradesh")) {
            city =   faker.options().option("Agra", "Lucknow", "Merrut");
        } else if (Objects.equals(state, "Haryana")) {
            city =   faker.options().option("Karnal", "Panipat");
        } else if (Objects.equals(state, "Rajasthan")) {
            city =   faker.options().option("Jaipur", "Jaiselmer");
        }
        return city;
    }
}