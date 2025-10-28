package guru.qa;

import com.codeborne.selenide.CollectionCondition;
import com.codeborne.selenide.Selenide;
import org.junit.jupiter.api.*;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.ValueSource;

import static com.codeborne.selenide.CollectionCondition.sizeGreaterThan;
import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selenide.*;

public class WebTest {

    @BeforeEach
    void setUp() {
        open("https://duckduckgo.com/");
    }

    @ValueSource(strings = {
            "Selenide", "JUnit 5"
    })
    @ParameterizedTest (name = "Проверка результатов для поискового запроса {0} должен отдавать не пустой спиоск карточек")
    @Tag("BLOCKER")
    void searchResultsShouldNotBeEmpty(String searchQuery) {

        $("#searchbox_input").setValue(searchQuery).pressEnter();
        $$("[data-testid='mainline'] li[data-layout='organic']")
                .shouldBe(sizeGreaterThan(0));
    }
    @CsvSource(value = {
            "Selenide,https://ru.selenide.org",
            "JUnit 5,https://junit.org"
    })

    @ParameterizedTest (name = "Для поискового запроса {0} в первой карточке должна быть ссылка {1}")
    @Tag("BLOCKER")
    void searchResultsShouldContainExpectedUrl(String searchQuery, String expectedLink) {
     Selenide.
        $("#searchbox_input").setValue(searchQuery).pressEnter();
        $("[data-testid='mainline'] li[data-layout='organic']")
                .shouldHave(text(expectedLink));
    }







    @Test
    @Tag("BLOCKER")
    @DisplayName("Проверка результатов для поискового запроса 'junit5' должен отдавать не пустой спиоск карточек")
    void successfulSearchJUnitTest() {

        $("#searchbox_input").setValue("juint 5").pressEnter();
        $$("[data-testid='mainline'] li[data-layout='organic']")
                .shouldBe(sizeGreaterThan(0));
    }

    @Test
    @Tag("BLOCKER")
    @DisplayName("Проверка результатов для поискового запроса 'selenide' должен открываться не пустой список фото")
    void successfulSearchPhotoTest() {

        $("#searchbox_input").setValue("selenide").pressEnter();
        $("[data-zci-link='Изображения']").click();

        $$("img.title--img__img")
                .shouldBe(sizeGreaterThan(0));
    }

    }

