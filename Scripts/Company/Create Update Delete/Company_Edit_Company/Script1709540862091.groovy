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

// ========================== CREATE 2 COMPANY ==========================

WebUI.click(findTestObject('Page_IDM/div_Company'))

WebUI.click(findTestObject('Object Repository/Page_Company/span_create-company-button d-block'))

WebUI.setText(findTestObject('Object Repository/Page_Company/inputcompanyName'), 'A')

WebUI.click(findTestObject('Object Repository/Page_Company/button_Save'))

WebUI.waitForPageLoad(60)

WebUI.verifyTextPresent('Company Created Successfully.', false)

WebUI.click(findTestObject('Object Repository/Page_Company/span_create-company-button d-block'))

WebUI.setText(findTestObject('Object Repository/Page_Company/inputcompanyName'), 'B')

WebUI.click(findTestObject('Object Repository/Page_Company/button_Save'))

WebUI.waitForPageLoad(60)

WebUI.verifyTextPresent('Company Created Successfully.', false)


// ========================== GO TO USER TAB ==========================
WebUI.click(findTestObject('Page_IDM/div_User'))
WebUI.click(findTestObject('Page_IDM/div_Company'))

// EDIT COMPANY

WebUI.click(findTestObject('Page_IDM/div_Company'))

WebUI.click(findTestObject('Page_Company/ellipsis_company_exact_with_variable',[('companyObjName'):'A']))

WebUI.click(findTestObject('Page_Company/button_edit_company'))

WebUI.setText(findTestObject('Object Repository/Page_Company/inputcompanyName'), 'AB')

WebUI.click(findTestObject('Object Repository/Page_Company/button_Save'))

WebUI.waitForPageLoad(60)

WebUI.verifyTextPresent('Company Updated Successfully.', false)

//----------------

WebUI.click(findTestObject('Page_IDM/div_Group'))

WebUI.click(findTestObject('Page_IDM/div_Company'))

WebUI.click(findTestObject('Page_Company/ellipsis_company_exact_with_variable',[('companyObjName'):'B']))

WebUI.click(findTestObject('Page_Company/button_edit_company'))

WebUI.setText(findTestObject('Object Repository/Page_Company/inputcompanyName'), 'BA')

WebUI.click(findTestObject('Object Repository/Page_Company/button_Save'))

WebUI.waitForPageLoad(60)

WebUI.verifyTextPresent('Company Updated Successfully.', false)

// DELETE COMPANY

WebUI.click(findTestObject('Page_IDM/div_Company'))

WebUI.click(findTestObject('Page_Company/ellipsis_company_exact_with_variable',[('companyObjName'):'AB']))

WebUI.click(findTestObject('Page_Company/button_delete_company'))

WebUI.click(findTestObject('Page_User/btn_confirm_delete'))

WebUI.waitForPageLoad(60)

WebUI.verifyTextPresent('Company deleted successfully.', false)

WebUI.click(findTestObject('Page_IDM/div_Company'))

WebUI.click(findTestObject('Page_Company/ellipsis_company_exact_with_variable',[('companyObjName'):'BA']))

WebUI.click(findTestObject('Page_Company/button_delete_company'))

WebUI.click(findTestObject('Page_User/btn_confirm_delete'))

WebUI.waitForPageLoad(60)

WebUI.verifyTextPresent('Company deleted successfully.', false)

