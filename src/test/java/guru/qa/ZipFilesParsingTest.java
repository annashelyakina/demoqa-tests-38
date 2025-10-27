package guru.qa;

import com.codeborne.pdftest.PDF;
import com.codeborne.xlstest.XLS;
import com.opencsv.CSVReader;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.io.InputStreamReader;
import java.util.List;
import java.util.zip.ZipEntry;
import java.util.zip.ZipInputStream;

public class ZipFilesParsingTest {

    private ClassLoader cl = FilesParsingTest.class.getClassLoader();

    @Test
    void zipFileParsingTest() throws Exception {
        try (ZipInputStream zip = new ZipInputStream(
                cl.getResourceAsStream("files.zip")
        )) {
            ZipEntry entry;

            while ((entry = zip.getNextEntry()) != null) {
                System.out.println(entry.getName());

                if (entry.getName().equals("disciplines.xlsx")){
                    System.out.println("check_xlsx");
                    XLS xls = new XLS(zip);
                    String actualValue = xls.excel.getSheetAt(0).getRow(7).getCell(1).getStringCellValue();
                    Assertions.assertTrue(actualValue.contains("Корпоративные экономические информационные системы"));
                }
                else if (entry.getName().equals("description.pdf")) {
                    System.out.println("check_pdf");
                    PDF pdf = new PDF(zip);
                    Assertions.assertEquals("Admin", pdf.author);
                }
                else if (entry.getName().equals("meta.csv")){
                    System.out.println("check_csv");
                   CSVReader csvReader = new CSVReader(new InputStreamReader(zip));
                   List<String[]> data = csvReader.readAll();
                   Assertions.assertEquals(13, data.size());
                   Assertions.assertArrayEquals(
                          new String[]{"150000", "2016-01-01", "Chris Riley", "trailhead9.ub20k5i9t8ou@example.com"},
                          data.get(1));

                }
            }

        }
    }
}