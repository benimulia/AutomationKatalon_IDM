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

WebUI.click(findTestObject('Page_IDM/div_Company'))

WebUI.click(findTestObject('Object Repository/Page_Company/span_create-company-button d-block'))

WebUI.setText(findTestObject('Object Repository/Page_Company/inputcompanyName'), company_name)

WebUI.click(findTestObject('Object Repository/Page_Company/slider_MFA'))

WebUI.click(findTestObject('Object Repository/Page_Company/check_via_email'))

WebUI.click(findTestObject('Object Repository/Page_Company/button_Save'))

WebUI.waitForPageLoad(60)

WebUI.verifyTextPresent('Company Created Successfully.', false)

// ==================== CREATE USER ====================
WebUI.click(findTestObject('Page_IDM/div_User'))

WebUI.click(findTestObject('Page_User/Page_Create/btn_user_create_user'))

WebUI.setText(findTestObject('Page_User/Page_Create/input_user_first_name'), first_name)

WebUI.setText(findTestObject('Page_User/Page_Create/input_user_middle_name'), middle_name)

WebUI.setText(findTestObject('Page_User/Page_Create/input_user_last_name'), last_name)

WebUI.setText(findTestObject('Page_User/Page_Create/input_user_username'), username)

WebUI.setEncryptedText(findTestObject('Page_User/Page_Create/input_user_password'), password)

WebUI.setEncryptedText(findTestObject('Page_User/Page_Create/input_user_confirm_password'), confirm_password)

WebUI.setText(findTestObject('Page_User/Page_Create/input_user_company'), company)

WebUI.delay(1)

WebUI.click(findTestObject('Page_User/Page_Create/input_user_company_automation_temp'))

WebUI.setText(findTestObject('Page_User/Page_Create/input_user_phone'), phone)

WebUI.setText(findTestObject('Page_User/Page_Create/input_user_email'), email)

WebUI.click(findTestObject('Page_User/Page_Create/btn_save_user'))

WebUI.delay(1)

WebUI.verifyTextPresent('User Created Successfully.', false)

WebUI.verifyElementPresent(findTestObject('Page_User/label_MFA_checked'), 30)

// ==================== EDIT COMPANY MFA ====================
WebUI.click(findTestObject('Page_IDM/div_Company'))

WebUI.click(findTestObject('Page_Company/ellipsis_company_automation_test'))

WebUI.click(findTestObject('Page_Company/button_edit_company'))

WebUI.click(findTestObject('Object Repository/Page_Company/slider_MFA'))

WebUI.click(findTestObject('Object Repository/Page_Company/button_Save'))

WebUI.waitForPageLoad(60)

WebUI.verifyTextPresent('Company Updated Successfully.', false)

// ==================== VERIFY USER ====================
WebUI.click(findTestObject('Page_IDM/div_User'))

WebUI.waitForPageLoad(300)

WebUI.click(findTestObject('Page_User/icon_Search_User_username'))

WebUI.setText(findTestObject('Page_User/input_header-search-username'), username)

WebUI.delay(5, FailureHandling.STOP_ON_FAILURE)

WebUI.doubleClick(findTestObject('Page_User/td_user_username'))

WebUI.delay(5, FailureHandling.STOP_ON_FAILURE)

WebUI.verifyElementNotPresent(findTestObject('Page_User/label_MFA_checked'), 30)

