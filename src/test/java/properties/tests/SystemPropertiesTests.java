package properties.tests;

import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

import static java.lang.String.format;

public class SystemPropertiesTests {

    @Test
    void systemPropertiesTest(){
        String browser = System.getProperty("browser");
        System.out.println(browser); //null
    }

    @Test
    void systemProperties1Test(){
        System.setProperty("browser", "chrome");
        String browser = System.getProperty("browser");
        System.out.println(browser); //chrome
    }

    @Test
    void systemProperties2Test(){
        String browser = System.getProperty("browser", "mozilla");
        System.out.println(browser); //mozilla
    }

    @Test
    void systemProperties3Test(){
        System.setProperty("browser", "chrome");
        String browser = System.getProperty("browser", "mozilla");
        System.out.println(browser); //chrome
    }

    @Test
    @Tag("property")
    void systemProperties4Test(){
        String browser = System.getProperty("browser", "mozilla");
        System.out.println(browser);
        // gradle property
        // mozilla
        // gradle property -Dbrowser=opera
        //opera
    }

    @Test
    @Tag("hello")
    void systemProperties5Test(){
        String name = System.getProperty("name", "default student");
        String message = format("Hello, %s!", name);

        System.out.println(message);
        //gradle hello
        // Hello, default student!

        //gradle hello -Dname=Anna Shelyakina
        // BUILD FAILED: Task 'Shelyakina' not found in root project 'demoqa-tests-38'.

        //gradle hello -Dname="Anna Shelyakina"
        //gradle hello "-Dname=Anna Shelyakina"
        //  Hello, Anna Shelyakina!
    }

}
