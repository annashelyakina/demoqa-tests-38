package guru.qa;

import com.codeborne.xlstest.XLS;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.zip.ZipEntry;
import java.util.zip.ZipInputStream;

public class SearchXlsxInZipArchive {

    private ClassLoader cl = FilesParsingTest.class.getClassLoader();

    @Test
    void zipFileParsingTest() throws Exception {
        try (ZipInputStream zip = new ZipInputStream(
                cl.getResourceAsStream("files.zip")
        )) {
            ZipEntry entry;
            boolean found = false;

            while ((entry = zip.getNextEntry()) != null) {

                if (entry.getName().equals("disciplines.xlsx")){
                    System.out.println("check_xlsx");
                    XLS xls = new XLS(zip);
                    String actualValue = xls.excel.getSheetAt(0).getRow(7).getCell(1).getStringCellValue();
                    Assertions.assertTrue(actualValue.contains("Корпоративные экономические информационные системы"));
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