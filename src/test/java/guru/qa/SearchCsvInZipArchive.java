package guru.qa;

import com.opencsv.CSVReader;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.io.InputStreamReader;
import java.util.List;
import java.util.zip.ZipEntry;
import java.util.zip.ZipInputStream;

public class SearchCsvInZipArchive {

    private ClassLoader cl = FilesParsingTest.class.getClassLoader();

    @Test
    void zipFileParsingTest() throws Exception {
        try (ZipInputStream zip = new ZipInputStream(
                cl.getResourceAsStream("files.zip")
        ))
        {
            ZipEntry entry;
            boolean found = false;

            while ((entry = zip.getNextEntry()) != null) {

            if (entry.getName().equals("meta.csv")){
                    System.out.println("check_csv");
                   CSVReader csvReader = new CSVReader(new InputStreamReader(zip));
                   List<String[]> data = csvReader.readAll();
                   Assertions.assertEquals(13, data.size());
                   Assertions.assertArrayEquals(
                          new String[]{"150000", "2016-01-01", "Chris Riley", "trailhead9.ub20k5i9t8ou@example.com"},
                          data.get(1));
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