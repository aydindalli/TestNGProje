package com.techproed.utilities;
import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;
import org.openqa.selenium.WebDriver;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import java.io.IOException;
import java.util.concurrent.TimeUnit;

    // @BeforeTest    ; Test baslamadan bir kez once calisir, rapor icin hazirlik yapilir ve nesneler olusturulu

    /* @BeforeClass
            Class ismi
                @BeforeMethod
                    @Test1    =====>  Rapor hazirlama yapilir
                @AfterMethod  =====>  Eger rapor basarisiz olursa ekran goruntusu alinip rapora eklenir
                @BeforeMethod
                    @Test2    =====>  Rapor hazirlama yapilir
                @AfterMethod  =====> Eger rapor basarisiz olursa ekran goruntusu alinip rapora eklenir
       @AfterClass
    */

    // @AfterTest     ; Tum test bittiginde bir kez calisir , raporlandirma sonlandirilir

    // TestBaseFinal class ini miras alarak raporlama yapilir
public abstract class TestBaseFinal {
    protected WebDriver driver;
    protected static ExtentReports extentReports;
    protected static ExtentTest extentTest;
    protected static ExtentHtmlReporter extentHtmlReporter;

    // Test islemine baslamadan once calisir; Rapor alma islemleri icin nesneler olusturup hazirlik yapariz
    @BeforeTest(alwaysRun = true)
    public void setUpTest() {//This is how to set up Extent report. We will create and use this one in out test classes
        // Once ExtentReports dan nesne olusturacagiz , create object to set the location of the report
        extentReports = new ExtentReports();
        // Rapor eklenecek yeri seciyorsunuz
        String filePath = System.getProperty("user.dir") + "/test-output/benimRaporlarim.html";
        //Folder name = test-output, File name = report.html
        //String filePath = System.getProperty("user.dir") + "\\test-output\\report.html";//THIS IS FOR WINDOWS USER
        extentHtmlReporter = new ExtentHtmlReporter(filePath);//2. creating the report with the path we created
        extentReports.attachReporter(extentHtmlReporter);//3. attaching the html report to our custom report

        // Istediginiz bilgileri yazabilirsiniz...
        //WE CAN ADD CUSTOM INFO. NOT NECESSARY. JUST TO GIVE MORE INFORMATION TO THE USER OR TEAM
        extentReports.setSystemInfo("Environment", "Environment Name");
        extentReports.setSystemInfo("Browser", ConfigurationReader.getProperty("browser"));
        extentReports.setSystemInfo("Automation Engineer", "Aydin");
        extentHtmlReporter.config().setDocumentTitle("Google Arama Reports");
        extentHtmlReporter.config().setReportName("Google Arama Automation Reports");
    }

    // Her test methodundan sonra eger testte hata varsa ekran goruntusu alip rapora ekliyorduk
    @AfterMethod(alwaysRun = true)//In AfterMethod, we are getting the screenshots and attaching the report when test fails
    public void tearDownMethod(ITestResult result) throws IOException {
        if (result.getStatus() == ITestResult.FAILURE) {// Eger test basarisizsa
            String screenshotLocation = ReusableMethods.getScreenshot(result.getName());//getScreenshot is coming from ReusableMethods
            extentTest.fail(result.getName());
            extentTest.addScreenCaptureFromPath(screenshotLocation);//adding the screenshot to the report
            extentTest.fail(result.getThrowable());
        } else if (result.getStatus() == ITestResult.SKIP) {
            extentTest.skip("Test Case is skipped: " + result.getName());
        }
        Driver.closeDriver();
    }

    // Her Test bittikten sonra calisir ; RAPOR alma islemini sona erdirip dosya kapatir
    @AfterTest(alwaysRun = true)
    public void tearDownTest() {
        extentReports.flush();
    }
}