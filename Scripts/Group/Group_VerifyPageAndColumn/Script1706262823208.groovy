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

WebUI.waitForPageLoad(300)

WebUI.verifyElementPresent(findTestObject('Page_IDM/div_Group'), 0)

KeywordUtil.markPassed('Group menu is present')

WebUI.click(findTestObject('Page_IDM/div_Group'))

WebUI.verifyElementPresent(findTestObject('Page_Group/col_group_name'), 0)

WebUI.verifyElementPresent(findTestObject('Page_Group/col_group_company_name'), 0)

WebUI.verifyElementPresent(findTestObject('Page_Group/col_group_type'), 0)

WebUI.verifyElementPresent(findTestObject('Page_Group/col_group_created_date'), 0)

WebUI.verifyElementPresent(findTestObject('Page_Group/col_group_modified_date'), 0)

WebUI.verifyElementPresent(findTestObject('Page_Group/col_group_status'), 0)

KeywordUtil.markPassed('Group columns are present')

WebUI.click(findTestObject('Page_User/menu_btn_filter'))

WebUI.click(findTestObject('Page_User/checkbox_filter_name'))

WebUI.delay(5)

WebUI.verifyElementNotPresent(findTestObject('Page_User/header_user_name'), 0)

