package guru.qa;

import com.codeborne.pdftest.PDF;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.zip.ZipEntry;
import java.util.zip.ZipInputStream;

public class SearchPdfInZipArchive {

    private ClassLoader cl = FilesParsingTest.class.getClassLoader();

    @Test
    void zipFileParsingTest() throws Exception {
        try (ZipInputStream zip = new ZipInputStream(
                cl.getResourceAsStream("files.zip")
        )) {
            ZipEntry entry;
            boolean found = false;

            while ((entry = zip.getNextEntry()) != null) {

                if (entry.getName().equals("description.pdf")) {
                    System.out.println("check_pdf");
                    PDF pdf = new PDF(zip);
                    Assertions.assertEquals("Admin", pdf.author);
                    found = true;
                }
            }
            if(!found) {
                System.out.println("Файл не найден");
            }
        } catch(Exception e) {
            System.out.println("Обработано исключение: " + e.getMessage());
        }
    }
}