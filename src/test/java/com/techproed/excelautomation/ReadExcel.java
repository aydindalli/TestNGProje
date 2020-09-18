package com.techproed.excelautomation;
import org.apache.poi.ss.usermodel.*;
import org.testng.annotations.Test;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
public class ReadExcel {
    @Test
    public void test() throws IOException {
        String dosyaYolu = "C:\\Users\\HP\\IdeaProjects\\TestNGProje\\src\\test\\resources\\ULKELER.xlsx";
        /*
        Workbook  ; Excel dosya adi java da
        Worksheet ; Her acik excel sekmesi (Sayfa1, Sayfa2, ... vs)
        Row       ; Her satira Row(Satir) denir
        Cell      ; Her sutuna Cell(Hucre) denir
         */
        //Java'da bir dosyayı açmak için bu kullanılır, Parametre bölümüne açmak istediğimiz dosyanın adresi (dosya yolu,path) yazılır
        FileInputStream fileInputStream = new FileInputStream(dosyaYolu);

        // Workbook (excel) dosyasını okumaya başladık.
        Workbook workbook = WorkbookFactory.create(fileInputStream);

        // 1. sayfaya gider. (index değeri 0'dan başlar.)
        Sheet sheet       = workbook.getSheetAt(0);
        // 1. satıra gidelim. (index değeri 0'dan başlar.)
        Row row           = sheet.getRow(0);
        // 1. Hücreyi alalım. (index değeri 0'dan başlar.)
        Cell ulkeler      = row.getCell(0);
        Cell baskentler   = row.getCell(1);
        Cell meshurlar    = row.getCell(2);

        System.out.println(ulkeler);
        System.out.println(baskentler);
        System.out.println(meshurlar);

        // Excel'e Git -> Sheet 0'sayfaya git -> i. İndexteki Satıra git -> j. İndexteki sutun
        System.out.println(workbook.getSheetAt(0).getRow(3).getCell(1));
        System.out.println(workbook.getSheetAt(0).getRow(7).getCell(2));
        System.out.println(workbook.getSheetAt(0).getRow(10).getCell(0));

        // Son satır(Row)'ın numarasını almak için (indexini, index 0 dan başlar)
        int satirSayisi = workbook.getSheetAt(0).getLastRowNum() + 1;
        System.out.println("Satır sayısı : " + satirSayisi);

        // İçerisinde veri olan satır sayısını almak isterseniz
        // index'i 1'den başlıyor.
        int doluSatirSayisi = workbook.getSheetAt(0).getPhysicalNumberOfRows();
        System.out.println("Dolu Satır Sayısı : " + doluSatirSayisi);


        // SUTUNLARI ALMA (SUTUN SUTUN)
        System.out.println(" ");
        int sonSatirinIndexi = workbook.getSheetAt(0).getLastRowNum();
        // Tum ulkeleri sutun halinde yazdirma
        for (int i=0 ; i<= sonSatirinIndexi ;i++){
            System.out.println(workbook.getSheetAt(0).getRow(i).getCell(0));
        }

        // Tum baskentleri yazdiralim
        for (int j=0; j<=sonSatirinIndexi ; j++){
            System.out.println(workbook.getSheetAt(0).getRow(j).getCell(1));
        }

        // Tum meshurlari yazdiriniz
        for (int k=0; k<=sonSatirinIndexi; k++){
            System.out.println(workbook.getSheetAt(0).getRow(k).getCell(2));
        }



        // Bir satirin son sutunun index ini alma
        int sonSutunIndexi = workbook.getSheetAt(0).getRow(0).getLastCellNum();
        System.out.println("Son sutun Index ;" + sonSutunIndexi);

        // 4 . Satirin tum elemanlarini yazdirma ; Turkiye satiri
        for (int i =0 ; i<sonSutunIndexi; i++) {
            System.out.println("4. satir  -"+ (i+1) +". sutun :" +workbook.getSheetAt(0).getRow(3).getCell(i));
        }

        System.out.println("  ");
        // Tum tabloyu yazdirma
        for(int i=0;i<satirSayisi;i++){
            for (int j = 0; j < sonSutunIndexi; j++) {
                System.out.print(workbook.getSheetAt(0).getRow(i).getCell(j)+"-");
            }
            System.out.println("");
        }

    }
}


