package guru.qa;


import com.fasterxml.jackson.databind.ObjectMapper;
import guru.qa.model.Glossary;
import guru.qa.model.Library;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.io.InputStreamReader;
import java.io.Reader;

public class JsonFileParsingTest {

    private ClassLoader cl = FilesParsingTest.class.getClassLoader();
    private static final ObjectMapper mapper = new ObjectMapper();

    @Test
    void jsonFileParsingTest() throws Exception {
        try (Reader reader = new InputStreamReader(cl.getResourceAsStream("libraryandbooks.json")
        )){

            Library actual = mapper.readValue (reader, Library.class);
            Assertions.assertEquals("Центральная городская библиотека", actual.getName());
            Assertions.assertEquals("ул. Ленина, д. 15", actual.getAddress());
            Assertions.assertEquals("+7 (812) 123-45-67", actual.getPhone());

            Assertions.assertEquals(1111, actual.getBooks().getID());
            Assertions.assertEquals("Война и мир", actual.getBooks().getTitle());
            Assertions.assertEquals("Лев Толстой", actual.getBooks().getAuthor());
            Assertions.assertEquals(1869, actual.getBooks().getYear());
            Assertions.assertEquals("Роман-эпопея", actual.getBooks().getGenre());
        }

    }
}
