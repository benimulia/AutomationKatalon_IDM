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
import com.kms.katalon.core.testobject.SelectorMethod as SelectorMethod
import com.kms.katalon.core.testobject.TestObject as TestObject
import com.kms.katalon.core.webservice.keyword.WSBuiltInKeywords as WS
import com.kms.katalon.core.webui.keyword.WebUiBuiltInKeywords as WebUI
import com.kms.katalon.core.windows.keyword.WindowsBuiltinKeywords as Windows
import internal.GlobalVariable as GlobalVariable
import org.openqa.selenium.Keys as Keys

WebUI.click(findTestObject('Page_IDM/div_User'))

WebUI.waitForPageLoad(300)

WebUI.click(findTestObject('Object Repository/Page_User/div_User'))

WebUI.click(findTestObject('Page_User/icon_Search_User_username'))

WebUI.setText(findTestObject('Page_User/input_header-search-username'), username_search)

WebUI.delay(5, FailureHandling.STOP_ON_FAILURE)

WebUI.click(findTestObject('Page_User/td_user_username'))

WebUI.click(findTestObject('Page_User/btn_delete'))

WebUI.click(findTestObject('Page_User/btn_confirm_delete'))

WebUI.delay(3, FailureHandling.STOP_ON_FAILURE)

WebUI.verifyTextPresent('User(s) deleted successfully.', false)

//WebUI.click(findTestObject('Page_User/span_delete_username_search'))
//
//WebUI.setText(findTestObject('Page_User/input_header-search-username'), username_search)
//
//WebUI.delay(5, FailureHandling.STOP_ON_FAILURE)
//
//WebUI.verifyElementNotPresent(findTestObject('Page_User/td_user_username'), 0)

