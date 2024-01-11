import static com.kms.katalon.core.checkpoint.CheckpointFactory.findCheckpoint
import static com.kms.katalon.core.testcase.TestCaseFactory.findTestCase
import static com.kms.katalon.core.testdata.TestDataFactory.findTestData
import static com.kms.katalon.core.testobject.ObjectRepository.findTestObject
import static com.kms.katalon.core.testobject.ObjectRepository.findWindowsObject
import com.kms.katalon.core.checkpoint.Checkpoint as Checkpoint
import com.kms.katalon.core.cucumber.keyword.CucumberBuiltinKeywords as CucumberKW
import com.kms.katalon.core.keyword.builtin.VerifyMatchKeyword
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
import com.kms.katalon.core.util.KeywordUtil as KeywordUtil
import java.text.SimpleDateFormat as SimpleDateFormat
import java.util.Date as Date
import java.util.TimeZone as TimeZone

WebUI.waitForPageLoad(300)

WebUI.waitForElementPresent(findTestObject('Object Repository/Page_IDM/div_FirstRowCreatedDate'), 10)

def element = WebUI.getText(findTestObject('Object Repository/Page_IDM/div_FirstRowCreatedDate'))

def timeBeforeChange = element ? element : null

println("Time before change: $timeBeforeChange")

WebUI.click(findTestObject('Object Repository/Page_IDM/span_UTC'))

WebUI.click(findTestObject('Object Repository/Page_IDM/rb_UTC_CustomTime'))

WebUI.click(findTestObject('Object Repository/Page_IDM/span_UTC_select'))

WebUI.click(findTestObject('Object Repository/Page_IDM/li_UTC_select'))

WebUI.click(findTestObject('Object Repository/Page_IDM/button_Apply'))

WebUI.refresh()

WebUI.waitForElementPresent(findTestObject('Object Repository/Page_IDM/div_FirstRowCreatedDate'), 10)

element = WebUI.getText(findTestObject('Object Repository/Page_IDM/div_FirstRowCreatedDate'))

def timeAfterChange = element ? element : null

println("Time after change: $timeAfterChange")

boolean result

if (timeBeforeChange != timeAfterChange) {
    println('Timezone changed successfully')
	result = true
} else {
    println('Timezone changed fail')
	result = false
}

WebUI.click(findTestObject('Object Repository/Page_IDM/span_UTC'))

WebUI.click(findTestObject('Object Repository/Page_IDM/rb_UTC_LocalTime'))

WebUI.click(findTestObject('Object Repository/Page_IDM/button_Apply'))

assert result
