package tests.day11_excelAutomation;

import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.junit.Test;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

public class C03_WriteExcel {
    @Test
    public void test01() throws IOException {
        String filePath = "src/test/java/tests/day11_excelAutomation/ulkeler.xlsx";
        FileInputStream fis = new FileInputStream(filePath);
        Workbook workbook = WorkbookFactory.create(fis);
        Sheet page1 = workbook.getSheet("Sayfa1");
        //4) 4.hucreye yeni bir cell olusturalim
        page1.getRow(0).createCell(4);
        //5) Olusturdugumuz hucreye “Nufus” yazdiralim
        page1.getRow(0).createCell(4).setCellValue("Nufus");
        //6) 2.satir nufus kolonuna 1500000 yazdiralim
        page1.getRow(1).createCell(4).setCellValue(150000);
        //7) 10.satir nufus kolonuna 250000 yazdiralim
        page1.getRow(9).createCell(4).setCellValue(250000);
        //8) 15.satir nufus kolonuna 54000 yazdiralim
        page1.getRow(14).createCell(4).setCellValue(54000);
        //9) Dosyayi kaydedelim
        FileOutputStream fos = new FileOutputStream(filePath);
        workbook.write(fos);

        //10)Dosyayi kapatalim
        fis.close();
        fos.close();
        workbook.close();
    }
}
