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
import com.kms.katalon.core.util.KeywordUtil as KeywordUtil

Boolean result = false

WebUI.waitForPageLoad(300)

WebUI.click(findTestObject('Page_IDM/div_Audit Trail'))

WebUI.click(findTestObject('Page_Audit_Trail/icon_filter_audit_performed_by'))

WebUI.click(findTestObject('Page_Audit_Trail/check_audit_performed_by'))

WebUI.click(findTestObject('Page_User/btn_apply_filter'))

WebUI.delay(5, FailureHandling.STOP_ON_FAILURE)

def actual_text = WebUI.getText(findTestObject('Page_Audit_Trail/td_audit_collection_performed_by'))

if (actual_text.contains('administrator')) {
    result = true
}

assert result

