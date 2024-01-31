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

WebUI.click(findTestObject('Object Repository/Page_Group/div_Group'))

WebUI.click(findTestObject('Object Repository/Page_Group/em_pvu-icon-create-group toolbar-button'))

WebUI.setText(findTestObject('Page_Group/input_group_name'), group_name)

WebUI.click(findTestObject('Object Repository/Page_Group/span_dropdown-btn'))

WebUI.click(findTestObject('Object Repository/Page_Group/li_Petrolink'))

WebUI.click(findTestObject('Page_Group/span_dropdown-btn-2'))

WebUI.click(findTestObject('Object Repository/Page_Group/span_All'))

WebUI.setText(findTestObject('Page_Group/input_group_description'), group_desc)

WebUI.click(findTestObject('Object Repository/Page_Group/button_Add User(s)Group(s)'))

WebUI.click(findTestObject('Object Repository/Page_Group/icon_search_group_username_add_user'))

WebUI.setText(findTestObject('Object Repository/Page_Group/input_header-search-name'), header_search_name)

WebUI.delay(3)

WebUI.click(findTestObject('Object Repository/Page_Group/span_ng-star-inserted'))

WebUI.click(findTestObject('Object Repository/Page_Group/button_Add to Groups'))

WebUI.click(findTestObject('Object Repository/Page_Group/button_Save'))

WebUI.waitForPageLoad(60)

WebUI.verifyTextPresent('Group Created Successfully.', false)

