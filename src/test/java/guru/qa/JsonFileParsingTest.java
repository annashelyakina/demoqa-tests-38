package guru.qa;


import com.fasterxml.jackson.databind.ObjectMapper;
import guru.qa.model.Book;
import guru.qa.model.Library;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.io.InputStreamReader;
import java.io.Reader;
import java.util.ArrayList;
import java.util.List;

public class JsonFileParsingTest {

    private ClassLoader cl = FilesParsingTest.class.getClassLoader();
    private static final ObjectMapper mapper = new ObjectMapper();


    @Test
    void jsonFileParsingTest() throws Exception {
        // Создаем экземпляры книг вручную
        Book book1 = new Book(1111, "Война и мир", "Лев Толстой", 1869, "Роман-эпопея");
        Book book2 = new Book(1112, "Преступление и наказание", "Фёдор Достоевский", 1866, "Психологический роман");

        // Добавляем созданные книги в список
        ArrayList<Book> manualBooks = new ArrayList<>();
        manualBooks.add(book1);
        manualBooks.add(book2);

        try (Reader reader = new InputStreamReader(cl.getResourceAsStream("libraryandbooks.json")
        )){

            Library library = mapper.readValue (reader, Library.class);
            Assertions.assertEquals("Центральная городская библиотека", library.getName());
            Assertions.assertEquals("ул. Ленина, д. 15", library.getAddress());
            Assertions.assertEquals("+7 (812) 123-45-67", library.getPhone());

            List<Book> parsedBooks = library.getBooks();

            for (int i = 0; i < parsedBooks.toArray().length; i++) {
                Assertions.assertEquals(manualBooks.get(i).getId(), parsedBooks.get(i).getId());
                Assertions.assertEquals(manualBooks.get(i).getTitle(), parsedBooks.get(i).getTitle());
                Assertions.assertEquals(manualBooks.get(i).getAuthor(), parsedBooks.get(i).getAuthor());
                Assertions.assertEquals(manualBooks.get(i).getYear(), parsedBooks.get(i).getYear());
                Assertions.assertEquals(manualBooks.get(i).getGenre(), parsedBooks.get(i).getGenre());
                System.out.println("Нашлась книга: " + parsedBooks.get(i).getId() + ", "
                        + parsedBooks.get(i).getTitle() +", "+ parsedBooks.get(i).getAuthor()
                        + ", "+ parsedBooks.get(i).getYear() + ", "+ parsedBooks.get(i).getGenre() );
            }
        }
    }
}