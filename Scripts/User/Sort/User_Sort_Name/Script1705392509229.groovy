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

Boolean result = false

WebUI.waitForPageLoad(300)

WebUI.click(findTestObject('Object Repository/Page_User/div_User'))

WebUI.waitForElementVisible(findTestObject('Page_User/td_user_collection_name'), 180)

List<WebElement> tableElementsOriginal = WebUI.findWebElements(findTestObject('Page_User/td_user_collection_name'), 30)

List<WebElement> tableValuesOriginal = new ArrayList<String>()

for (WebElement e : tableElementsOriginal) {
    String textContent = e.getText().trim()

    tableValuesOriginal.add(textContent)
}

WebUI.click(findTestObject('Page_User/header_user_name'))

List<WebElement> tableElementsAsc = WebUI.findWebElements(findTestObject('Page_User/td_user_collection_name'), 30)

List<WebElement> tableValuesAsc = new ArrayList<String>()

for (WebElement e : tableElementsAsc) {
    String textContent = e.getText().trim()

    tableValuesAsc.add(textContent)
}

// Sort the original list using a case-insensitive comparator
tableValuesOriginal.sort({ def a, def b ->
        a.toLowerCase() <=> b.toLowerCase()
    })

// Print the entire list after sorting
println('tablevalues original after sorting: ' + tableValuesOriginal.toString())

println('tablevalues after sorting (web) : ' + tableValuesAsc.toString())

if (tableValuesOriginal.toString() == tableValuesAsc.toString()) {
    result = true
}

assert result

