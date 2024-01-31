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

WebUI.click(findTestObject('Page_User/Page_Create/btn_user_create_user'))

WebUI.setText(findTestObject('Page_User/Page_Create/input_user_first_name'), first_name)

WebUI.setText(findTestObject('Page_User/Page_Create/input_user_middle_name'), middle_name)

WebUI.setText(findTestObject('Page_User/Page_Create/input_user_last_name'), last_name)

WebUI.setText(findTestObject('Page_User/Page_Create/input_user_username'), username)

WebUI.setEncryptedText(findTestObject('Page_User/Page_Create/input_user_password'), password)

WebUI.setEncryptedText(findTestObject('Page_User/Page_Create/input_user_confirm_password'), confirm_password)

WebUI.setText(findTestObject('Page_User/Page_Create/input_user_company'), company)

WebUI.delay(1)

WebUI.click(findTestObject('Page_User/Page_Create/input_user_company_petrolink'))

WebUI.setText(findTestObject('Page_User/Page_Create/input_user_phone'), phone)

WebUI.setText(findTestObject('Page_User/Page_Create/input_user_email'), email)

WebUI.click(findTestObject('Page_User/Page_Create/btn_save_user'))

WebUI.verifyTextPresent('User Created Successfully.', false)

