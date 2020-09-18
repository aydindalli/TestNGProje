package com.techproed.excelautomation;

import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.testng.annotations.Test;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

public class WriteExcel {

    @Test
    public void test() throws IOException {
        String dosyaYolu = "C:\\Users\\HP\\IdeaProjects\\TestNGProje\\src\\test\\resources\\ULKELER.xlsx";
        //Java'da bir dosyayı açmak için bu kullanılır, Parametre bölümüne açmak istediğimiz dosyanın adresi (dosya yolu,path) yazılır
        FileInputStream fileInputStream = new FileInputStream(dosyaYolu);

        // Workbook (excel) dosyasını okumaya başladık.
        Workbook workbook = WorkbookFactory.create(fileInputStream);

        // Dosya uzerinde yazma islemi gerceklestirecegimiz icin buraya FileOutputStream class indan nesne olusturuyoruz
        FileOutputStream fileOutputStream =new FileOutputStream(dosyaYolu);

        // Hucre YANI SUTUN olusturma
        workbook.getSheetAt(0).getRow(0).createCell(3).setCellValue("NUFUS");
        workbook.getSheetAt(0).getRow(1).createCell(3).setCellValue("80milyon");
        workbook.getSheetAt(0).getRow(2).createCell(3).setCellValue("10milyon");
        workbook.getSheetAt(0).getRow(3).createCell(3).setCellValue("83milyon");
        workbook.getSheetAt(0).getRow(3).createCell(3).setCellValue("23milyon");

        // Istenilen satirdaki istenilen sutunu silmek , 1.Sayfa/3.Satir/2.Sutun SIL
        workbook.getSheetAt(0).getRow(2).removeCell(workbook.getSheetAt(0).getRow(2).getCell(1));
        workbook.getSheetAt(0).getRow(2).createCell(1).setCellValue("Selanik mi?");

        // Istenilen satiri komple silme ; Almanya satiri gider
        workbook.getSheetAt(0).removeRow(workbook.getSheetAt(0).getRow(1));


        // Yaptigimiz degisiklikleri excell dosyasina aktarir,veriyi yazar ve kaydeder
        workbook.write(fileOutputStream);


        fileInputStream.close();
        fileOutputStream.close();
        workbook.close();
    }

}
