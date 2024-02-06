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
import org.openqa.selenium.By as By
import org.openqa.selenium.Keys as Keys
import com.kms.katalon.core.util.KeywordUtil as KeywordUtil
import com.kms.katalon.core.webui.driver.DriverFactory as DriverFactory
import org.openqa.selenium.WebElement as WebElement
import java.text.SimpleDateFormat
import java.util.Date
import java.util.List
import java.util.Locale


Boolean result = false

WebUI.waitForPageLoad(300)

WebUI.click(findTestObject('Page_IDM/div_Audit Trail'))

WebUI.click(findTestObject('Page_Audit_Trail/icon_filter_audit_time'))

WebUI.click(findTestObject('Page_Audit_Trail/check_filter_24hrs'))

WebUI.delay(5, FailureHandling.STOP_ON_FAILURE)

// Function to get table values
// Get original table values
List<WebElement> originalTableValues = getTableValues()

// Check if each date is within the last 24 hours
result = originalTableValues.every { isWithinLast24Hours(it.text) }

assert result

List<WebElement> getTableValues() {
    List<WebElement> tableElements = WebUI.findWebElements(findTestObject('Page_Audit_Trail/td_audit_collection_time'), 30)

    List<WebElement> tableValues = new ArrayList<WebElement>()

    for (WebElement e : tableElements) {
        tableValues.add(e)
    }

    return tableValues
}

boolean isWithinLast24Hours(String dateString) {
    def dateFormat = new SimpleDateFormat("MMM d, yyyy, h:mm:ss a", Locale.ENGLISH)
    def date = dateFormat.parse(dateString)

    // Get the current date and time
    def currentDate = new Date()

    // Calculate the difference in milliseconds
    def diffInMilliseconds = currentDate.time - date.time

    // Calculate the difference in hours
    def diffInHours = diffInMilliseconds / (1000 * 60 * 60)

    // Check if the date is within the last 24 hours
    return diffInHours < 24
}


