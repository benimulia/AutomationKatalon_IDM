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

// ==================== CREATE GROUP 1 ====================
WebUI.click(findTestObject('Object Repository/Page_Group/div_Group'))

WebUI.click(findTestObject('Object Repository/Page_Group/em_pvu-icon-create-group toolbar-button'))

WebUI.setText(findTestObject('Page_Group/input_group_name'), group_name)

WebUI.click(findTestObject('Object Repository/Page_Group/span_dropdown-btn'))

WebUI.click(findTestObject('Object Repository/Page_Group/li_Petrolink'))

WebUI.click(findTestObject('Page_Group/span_dropdown-btn-2'))

WebUI.click(findTestObject('Object Repository/Page_Group/span_All'))

WebUI.setText(findTestObject('Page_Group/input_group_description'), group_desc)

WebUI.delay(3)

WebUI.click(findTestObject('Object Repository/Page_Group/button_Save'))

WebUI.waitForPageLoad(60)

WebUI.verifyTextPresent('Group Created Successfully.', false)

// ==================== CREATE GROUP 2 ====================
WebUI.click(findTestObject('Object Repository/Page_Group/div_Group'))

WebUI.click(findTestObject('Object Repository/Page_Group/em_pvu-icon-create-group toolbar-button'))

WebUI.setText(findTestObject('Page_Group/input_group_name'), group_name2)

WebUI.click(findTestObject('Object Repository/Page_Group/span_dropdown-btn'))

WebUI.click(findTestObject('Object Repository/Page_Group/li_Petrolink'))

WebUI.click(findTestObject('Page_Group/span_dropdown-btn-2'))

WebUI.click(findTestObject('Object Repository/Page_Group/span_All'))

WebUI.setText(findTestObject('Page_Group/input_group_description'), group_desc2)

WebUI.delay(3)

WebUI.click(findTestObject('Object Repository/Page_Group/button_Save'))

WebUI.waitForPageLoad(60)

WebUI.verifyTextPresent('Group Created Successfully.', false)

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

WebUI.click(findTestObject('Page_User/Page_Create/input_user_company_petrolink'))

WebUI.setText(findTestObject('Page_User/Page_Create/input_user_phone'), phone)

WebUI.setText(findTestObject('Page_User/Page_Create/input_user_email'), email)

WebUI.click(findTestObject('Page_User/btn_add_group_to_user'))

WebUI.click(findTestObject('Page_User/icon_search_group_name_add_group'))

WebUI.setText(findTestObject('Page_User/input_header_search_name_add_group_to_user'), header_search_name)

WebUI.delay(1)

WebUI.click(findTestObject('Page_User/span_ng-star-inserted-all'))

WebUI.click(findTestObject('Page_User/button_add_group_to_user'))

WebUI.click(findTestObject('Page_User/Page_Create/btn_save_user'))

WebUI.delay(1)

WebUI.verifyTextPresent('User Created Successfully.', false)

// ======================== VERIFICATION ========================
Boolean result = false

WebUI.waitForPageLoad(300)

WebUI.click(findTestObject('Page_IDM/div_Audit Trail'))

WebUI.click(findTestObject('Page_Audit_Trail/icon_filter_audit_performed_by'))

WebUI.click(findTestObject('Page_Audit_Trail/check_audit_performed_by_automation_user'))

WebUI.click(findTestObject('Page_User/btn_apply_filter'))

WebUI.delay(5, FailureHandling.STOP_ON_FAILURE)

def actual_text = WebUI.getText(findTestObject('Page_Audit_Trail/td_audit_collection_additional_info'))

if (actual_text.contains('View Changes')) {
    result = true
}

assert result

// ======================= DELETE DATA =======================

WebUI.click(findTestObject('Page_IDM/div_User'))

WebUI.waitForPageLoad(300)

WebUI.click(findTestObject('Object Repository/Page_User/div_User'))

WebUI.click(findTestObject('Page_User/icon_Search_User_username'))

WebUI.setText(findTestObject('Page_User/input_header-search-username'), username)

WebUI.delay(5, FailureHandling.STOP_ON_FAILURE)

WebUI.click(findTestObject('Page_User/td_user_username'))

WebUI.click(findTestObject('Page_User/btn_delete'))

WebUI.click(findTestObject('Page_User/btn_confirm_delete'))

WebUI.delay(3, FailureHandling.STOP_ON_FAILURE)

WebUI.verifyTextPresent('User(s) deleted successfully.', false)

// ================

WebUI.click(findTestObject('Object Repository/Page_Group/div_Group'))

WebUI.waitForPageLoad(300)

WebUI.click(findTestObject('Page_Group/icon_search_group_name'))

WebUI.setText(findTestObject('Page_Group/input_header-search-name-group'), group_name_search)

WebUI.delay(5, FailureHandling.STOP_ON_FAILURE)

WebUI.click(findTestObject('Page_IDM/span_select_all_data_row'))

WebUI.delay(2, FailureHandling.STOP_ON_FAILURE)

WebUI.click(findTestObject('Page_User/btn_delete'))

WebUI.click(findTestObject('Page_User/btn_confirm_delete'))

WebUI.delay(3, FailureHandling.STOP_ON_FAILURE)

WebUI.verifyTextPresent('Group(s) deleted successfully.', false)
