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

WebUI.waitForElementVisible(findTestObject('Page_Audit_Trail/td_audit_collection_time'), 180)

// Ascending Order
WebUI.click(findTestObject('Page_Audit_Trail/header_audit_time'))

// Function to get table values
// Get original table values
List<WebElement> originalTableElements = WebUI.findWebElements(findTestObject('Page_Audit_Trail/td_audit_collection_time'), 30)

// Convert table elements to Date objects
List<Date> originalTableValues = originalTableElements.collect {
    Date parsedDate = Date.parse("MMM d, yyyy, h:mm:ss a", it.getText().trim())
    return parsedDate
}

List<Date> tableValuesAsc = originalTableValues.sort { a, b ->
    a <=> b
}

println('[asc] tablevalues after sorting: ' + tableValuesAsc.toString())

// Check if ascending order list matches the original
result = (originalTableValues.toString() == tableValuesAsc.toString())

println('result 1 : ' + result)

// Descending Order
WebUI.click(findTestObject('Page_Audit_Trail/header_audit_time'))

List<Date> tableValuesDesc = originalTableValues.sort { a, b ->
    b <=> a
}

println('[desc] tablevalues after sorting: ' + tableValuesDesc.toString())

// Check if descending order list matches the original
result = (result && (originalTableValues.toString() == tableValuesDesc.toString()))

println('result 2 : ' + result)

assert result
