import static com.kms.katalon.core.checkpoint.CheckpointFactory.findCheckpoint
import static com.kms.katalon.core.testcase.TestCaseFactory.findTestCase
import static com.kms.katalon.core.testdata.TestDataFactory.findTestData
import static com.kms.katalon.core.testobject.ObjectRepository.findTestObject
import static com.kms.katalon.core.testobject.ObjectRepository.findWindowsObject
import com.kms.katalon.core.checkpoint.Checkpoint as Checkpoint
import com.kms.katalon.core.cucumber.keyword.CucumberBuiltinKeywords as CucumberKW
import com.kms.katalon.core.mobile.keyword.MobileBuiltInKeywords as Mobile
import com.kms.katalon.core.model.FailureHandling as FailureHandling
import com.kms.katalon.core.testcase.TestCase as TestCase
import com.kms.katalon.core.testdata.TestData as TestData
import com.kms.katalon.core.testng.keyword.TestNGBuiltinKeywords as TestNGKW
import com.kms.katalon.core.testobject.TestObject as TestObject
import com.kms.katalon.core.webservice.keyword.WSBuiltInKeywords as WS
import com.kms.katalon.core.webui.keyword.WebUiBuiltInKeywords as WebUI
import com.kms.katalon.core.windows.keyword.WindowsBuiltinKeywords as Windows
import internal.GlobalVariable as GlobalVariable
import org.openqa.selenium.Keys as Keys
import org.openqa.selenium.By as By
import org.openqa.selenium.WebDriver as WebDriver
import org.testng.Assert as Assert
import com.kms.katalon.core.webui.driver.DriverFactory as DriverFactory
import com.kms.katalon.core.util.KeywordUtil as KeywordUtil
import internal.GlobalVariable as GlobalVariable

//'Define Custom Path where file needs to be downloaded'
String downloadPath = GlobalVariable.DOWNLOAD_PATH

WebUI.click(findTestObject('Page_IDM/div_Audit Trail'))

WebUI.click(findTestObject('Page_Audit_Trail/button_export'))

//'Wait for Some time so that file gets downloaded and Stored in user defined path'
WebUI.delay(10)

//'Verifying the file is download in the User defined Path'
Assert.assertTrue(isFileDownloaded(downloadPath, 'AuditLog.csv'), 'Failed to download Expected document') // remove this line if you want to keep the file

boolean isFileDownloaded(String downloadPath, String fileName) {
    long timeout = (1 * 60) * 1000 //1 min

    long start = new Date().getTime()

    boolean downloaded = false

    File file = new File(downloadPath, fileName)

    while (!(downloaded)) {
        KeywordUtil.logInfo("Checking file exists $file.absolutePath")

        downloaded = file.exists()

        if (downloaded) {
            file.delete()
        } else {
            long now = new Date().getTime()

            if ((now - start) > timeout) {
                break
            }
            
            Thread.sleep(3000)
        }
    }
    
    return downloaded
}

