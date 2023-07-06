package tests.day11_excelAutomation;

import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.junit.Assert;
import org.junit.Test;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.Map;
import java.util.TreeMap;

public class C02_ReadExcel {
    @Test
    public void test0() throws IOException {
        String filePath = "src/test/java/tests/day11_excelAutomation/ulkeler.xlsx";
        FileInputStream fis = new FileInputStream(filePath);
        Workbook workbook = WorkbookFactory.create(fis);
        Sheet page1 = workbook.getSheet("Sayfa1");
        //- 1.satirdaki 2.hucreye gidelim ve yazdiralim
        System.out.println(page1.getRow(0).getCell(1));
        // - 1.satirdaki 2.hucreyi bir string degiskene atayalim ve yazdiralim
        String wantedCell = page1.getRow(0).getCell(1).toString();
        System.out.println(wantedCell + " wanted ");
        // - 2.satir 4.cell’in afganistan’in baskenti oldugunu test edelim
        String expectedWirte = "Kabil";
        String actualWrite = page1.getRow(1).getCell(3).toString();

        Assert.assertEquals(expectedWirte,actualWrite);
        // - Satir sayisini bulalim
        System.out.println(page1.getLastRowNum() + " is Number of row");
        // - Fiziki olarak kullanilan satir sayisini bulun
        System.out.println(page1.getPhysicalNumberOfRows() + " is Physical number of row");
        // - Ingilizce Ulke isimleri ve baskentleri bir map olarak kaydedelim

        Map<String,String> countriesMap = new TreeMap<>();
        for (int i = 0; i <page1.getLastRowNum() ; i++) {
            String key = page1.getRow(i).getCell(0).toString();
            String value = page1.getRow(i).getCell(1).toString();
            countriesMap.put(key,value);

        }
        System.out.println(countriesMap);

        //Listede Benin isminde bir ulke bulundugunu test edin
        Assert.assertTrue(countriesMap.containsKey("Benin"));
    }
}
