package tests.day11_excelAutomation;

import org.apache.poi.ss.usermodel.*;
import org.junit.Assert;
import org.junit.Test;
import utilities.TestBase;

import java.io.FileInputStream;
import java.io.IOException;

public class C01_ReadExcel {
    @Test
    public void test01() throws IOException {
        String filePath = "src/test/java/tests/day11_excelAutomation/ulkeler.xlsx";
        //eger excel dosyasi proje icerisinde degilde masasustu veya download
        //gibi baski bir klasor'un icinde ise dosya yolu dinamik hale getirilebilir



        FileInputStream fis = new FileInputStream(filePath);

        Workbook workbook = WorkbookFactory.create(fis);


        /*
            olusturdugumuz workbook bizim excel'imizi canli olarak kullanmaz
            23. satir calistiginda yani verdigimiz dosya yolunda olan
            excel'deki tum bilgileri alip bu class'da olusturdugumuz
            workbook objesine yuikler

            YANI workbook objesi excel'deki bilgilerin bir kopyasina sahip olur
            workbook'da bir degisiklik yapaprsak ana excel degismez

            EGER ana excel'inde degismesini istiyorsak islem bittikten sonra
            yani class'in en sonunda workbook'daki yeni hali excel'e kaydetmemiz gerekir
            */




        Sheet page1 = workbook.getSheet("Sayfa1");
        Row row = page1.getRow(3);
        Cell cell = row.getCell(2);

        System.out.println(cell);
        //excel'de satir ve sutun numarlari index kullanir
        //YANI satir ve sutun numaralari 0 ile baslar


        //12. satirda bulunan Azerbaycan'in ingilizce baskent isminin Baku oldugunu test edin.
        Row twelthRow = page1.getRow(11);
        Cell capitalCity = twelthRow.getCell(1);
        String expectedCapital = "Baku";
        String actualCapital = capitalCity.toString();
        //burada bir tanesi cell data type birisi ise string oldugu icin casting ile cell'i toString yaparak isleme devam ettik.
        Assert.assertEquals(expectedCapital,actualCapital);


    }
}
